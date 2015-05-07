/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.client.logic.ejb;

import co.edu.uniandes.Callys.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.Callys.cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.Callys.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.Callys.cliente.logic.ejb.ClienteLogic;
import co.edu.uniandes.Callys.cliente.logic.entity.ClienteEntity;
import static co.edu.uniandes.Callys.util._TestUtil.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author estudiante
 */

@RunWith(Arquillian.class)
public class ClientLogicTest {
    
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteDTO.class.getPackage())
                .addPackage(ClienteConverter.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(IClienteLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IClienteLogic clienteLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    @Before
    public void configTest() {
        System.out.println("em: " + em);
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = new ClienteEntity();
            entity.setId(generateRandom(Long.class));
            entity.setNombre(generateRandom(String.class));
            entity.setNumCompras(generateRandom(Integer.class));
            entity.setNumeroTarjeta(generateRandom(Integer.class));
            entity.setIdCompras(generateRandom(String.class));
            entity.setPassword(generateRandom(String.class));
            entity.setCarroComprasId(generateRandom(Long.class));
            entity.setCodigoDeSeguridad(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createClienteTest() {
        ClienteDTO dto = new ClienteDTO();
            dto.setId(generateRandom(Long.class));
            dto.setNombre(generateRandom(String.class));
            dto.setNumCompras(generateRandom(Integer.class));
            dto.setNumeroTarjeta(generateRandom(Integer.class));
            dto.setIdCompras(generateRandom(String.class));
            dto.setPassword(generateRandom(String.class));
            dto.setCarroComprasId(generateRandom(Long.class));
            dto.setCodigoDeSeguridad(generateRandom(Integer.class));

        ClienteDTO result = clienteLogic.createCliente(dto);

        Assert.assertNotNull(result);

        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getNumCompras(), entity.getNumCompras());
        Assert.assertEquals(dto.getNumeroTarjeta(), entity.getNumeroTarjeta());
        Assert.assertEquals(dto.getIdCompras(), entity.getIdCompras());
        Assert.assertEquals(dto.getPassword(), entity.getPassword());
        Assert.assertEquals(dto.getCarroComprasId(), entity.getCarroComprasId());
        Assert.assertEquals(dto.getCodigoSeguridad(), entity.getCodigoSeguridad());
        
    }
    
    @Test
    public void getClientsTest() {
        List<ClienteDTO> list = clienteLogic.getClientes();
        Assert.assertEquals(list.size(), data.size());
        for (ClienteDTO dto : list) {
            boolean found = false;
            for (ClienteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getArtistTest() {
        ClienteEntity entity = data.get(0);
        ClienteDTO dto = clienteLogic.getCliente(entity.getId());
        Assert.assertNotNull(dto);
        
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getNombre(), dto.getNombre());
        Assert.assertEquals(entity.getNumCompras(), dto.getNumCompras());
        Assert.assertEquals(entity.getNumeroTarjeta(), dto.getNumeroTarjeta());
        Assert.assertEquals(entity.getIdCompras(), dto.getIdCompras());
        Assert.assertEquals(entity.getPassword(), dto.getPassword());
        Assert.assertEquals(entity.getCarroComprasId(), dto.getCarroComprasId());
        Assert.assertEquals(entity.getCodigoSeguridad(), dto.getCodigoSeguridad());
        
        
    }
    
    @Test
    public void getArtistPaginationTest() {
        //Page 1
        ClientePageDTO dto1 = clienteLogic.getClientes(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        ClientePageDTO dto2 = clienteLogic.getClientes(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());
        for (ClienteDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (ClienteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        for (ClienteDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (ClienteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void deleteClientTest() {
        ClienteEntity entity = data.get(0);
        clienteLogic.deleteCliente(entity.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateClientTest() {
        ClienteEntity entity = data.get(0);

        ClienteDTO dto = new ClienteDTO();
            dto.setId(generateRandom(Long.class));
            dto.setNombre(generateRandom(String.class));
            dto.setNumCompras(generateRandom(Integer.class));
            dto.setNumeroTarjeta(generateRandom(Integer.class));
            dto.setIdCompras(generateRandom(String.class));
            dto.setPassword(generateRandom(String.class));
            dto.setCarroComprasId(generateRandom(Long.class));
            dto.setCodigoDeSeguridad(generateRandom(Integer.class));

        clienteLogic.updateCliente(dto);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());
        
        Assert.assertEquals(dto.getId(), resp.getId());
        Assert.assertEquals(dto.getNombre(), resp.getNombre());
        Assert.assertEquals(dto.getNumCompras(), resp.getNumCompras());
        Assert.assertEquals(dto.getNumeroTarjeta(), resp.getNumeroTarjeta());
        Assert.assertEquals(dto.getIdCompras(), resp.getIdCompras());
        Assert.assertEquals(dto.getPassword(), resp.getPassword());
        Assert.assertEquals(dto.getCarroComprasId(), resp.getCarroComprasId());
        Assert.assertEquals(dto.getCodigoSeguridad(), resp.getCodigoSeguridad());
    }
}
