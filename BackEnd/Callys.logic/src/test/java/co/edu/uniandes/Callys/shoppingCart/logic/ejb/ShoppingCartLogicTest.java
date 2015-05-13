package co.edu.uniandes.Callys.shoppingCart.logic.ejb;

import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import static co.edu.uniandes.Callys.util._TestUtil.*;
import co.edu.uniandes.Callys.carroCompras.logic.api.ICarroComprasLogic;
import co.edu.uniandes.Callys.carroCompras.logic.converter.CarroComprasConverter;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasPageDTO;
import co.edu.uniandes.Callys.carroCompras.logic.ejb.CarroComprasLogic;
import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
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

@RunWith(Arquillian.class)
public class ShoppingCartLogicTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CarroComprasEntity.class.getPackage())
                .addPackage(CarroComprasDTO.class.getPackage())
                .addPackage(ItemEntity.class.getPackage())
                .addPackage(ItemDTO.class.getPackage())
                .addPackage(CamisetaEntity.class.getPackage())
                .addPackage(CamisetaDTO.class.getPackage())
                .addPackage(StampEntity.class.getPackage())
                .addPackage(StampDTO.class.getPackage())
                .addPackage(CarroComprasConverter.class.getPackage())
                .addPackage(CarroComprasLogic.class.getPackage())
                .addPackage(ICarroComprasLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ICarroComprasLogic carroComprasLogic;

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
        em.createQuery("delete from CarroComprasEntity").executeUpdate();
    }

    private List<CarroComprasEntity> data = new ArrayList<CarroComprasEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CarroComprasEntity entity = new CarroComprasEntity();
            entity.setId(generateRandom(Long.class));
            entity.setDatosEnvio(generateRandom(String.class));
            entity.setFormaPago(generateRandom(String.class));
            entity.setMonto(generateRandom(Double.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createShoppingCartTest() {
        CarroComprasDTO dto = new CarroComprasDTO();
        dto.setId(generateRandom(Long.class));
        dto.setDatosEnvio(generateRandom(String.class));
        dto.setFormaPago(generateRandom(String.class));
        dto.setMonto(generateRandom(Double.class));
        
        CarroComprasDTO result = carroComprasLogic.createCarroCompras(dto);

        Assert.assertNotNull(result);

        CarroComprasEntity entity = em.find(CarroComprasEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getDatosEnvio(), entity.getDatosEnvio());
        Assert.assertEquals(dto.getFormaPago(), entity.getFormaPago());
        Assert.assertEquals(dto.getMonto(), entity.getMonto());
    }
    
    @Test
    public void getShoppingCartTest() {
        List<CarroComprasDTO> list = carroComprasLogic.getCarrosCompras();
        Assert.assertEquals(list.size(), data.size());
        for (CarroComprasDTO dto : list) {
            boolean found = false;
            for (CarroComprasEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getShoppingCartsTest() {
        CarroComprasEntity entity = data.get(0);
        CarroComprasDTO dto = carroComprasLogic.getCarroCompras(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getDatosEnvio(), entity.getDatosEnvio());
        Assert.assertEquals(dto.getFormaPago(), entity.getFormaPago());
        Assert.assertEquals(dto.getMonto(), entity.getMonto());
    }
    
    @Test
    public void getShoppingCartsPaginationTest() {
        //Page 1
        CarroComprasPageDTO dto1 = carroComprasLogic.getCarrosCompras(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        CarroComprasPageDTO dto2 = carroComprasLogic.getCarrosCompras(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());
        for (CarroComprasDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (CarroComprasEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        for (CarroComprasDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (CarroComprasEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void deleteShoppingCartsTest() {
        CarroComprasEntity entity = data.get(0);
        carroComprasLogic.deleteCarroCompras(entity.getId());
        CarroComprasEntity deleted = em.find(CarroComprasEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateShoppingCartTest() {
        CarroComprasEntity entity = data.get(0);

        CarroComprasDTO dto = new CarroComprasDTO();
        dto.setId(entity.getId());
        dto.setDatosEnvio(generateRandom(String.class));
        dto.setFormaPago(generateRandom(String.class));
        dto.setMonto(generateRandom(Double.class));
        
        carroComprasLogic.updateCarroCompras(dto);

        CarroComprasEntity resp = em.find(CarroComprasEntity.class, entity.getId());

        Assert.assertEquals(dto.getDatosEnvio(), resp.getDatosEnvio());
        Assert.assertEquals(dto.getFormaPago(), resp.getFormaPago());
        Assert.assertEquals(dto.getMonto(), resp.getMonto());
    }
}