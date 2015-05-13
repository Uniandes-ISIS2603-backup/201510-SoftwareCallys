package co.edu.uniandes.Callys.shirt.logic.ejb;

import static co.edu.uniandes.Callys.util._TestUtil.*;
import co.edu.uniandes.Callys.camiseta.logic.api.ICamisetaLogic;
import co.edu.uniandes.Callys.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.camiseta.logic.ejb.CamisetaLogic;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
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
public class ShirtLogicTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
            .addPackage(CamisetaEntity.class.getPackage())
            .addPackage(StampDTO.class.getPackage())
            .addPackage(StampEntity.class.getPackage())
            .addPackage(ArtistaDTO.class.getPackage())
            .addPackage(ArtistaEntity.class.getPackage())
            .addPackage(CamisetaDTO.class.getPackage())
            .addPackage(CamisetaConverter.class.getPackage())
            .addPackage(CamisetaLogic.class.getPackage())
            .addPackage(ICamisetaLogic.class.getPackage())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ICamisetaLogic camisetaLogic;

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
        em.createQuery("delete from CamisetaEntity").executeUpdate();
    }

    private List<CamisetaEntity> data = new ArrayList<CamisetaEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CamisetaEntity entity = new CamisetaEntity();
            entity.setId(generateRandom(Long.class));
            entity.setColor(generateRandom(String.class));
            entity.setTalla(generateRandom(String.class));
            entity.setMaterial(generateRandom(String.class));
            entity.setTexto(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createShirtTest() {
        CamisetaDTO dto = new CamisetaDTO();
        dto.setId(generateRandom(Long.class));
        dto.setColor(generateRandom(String.class));
        dto.setTalla(generateRandom(String.class));
        dto.setMaterial(generateRandom(String.class));
        dto.setTexto(generateRandom(String.class));

        CamisetaDTO result = camisetaLogic.createCamiseta(dto);

        Assert.assertNotNull(result);

        CamisetaEntity entity = em.find(CamisetaEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getColor(), entity.getColor());
        Assert.assertEquals(dto.getTalla(), entity.getTalla());
        Assert.assertEquals(dto.getMaterial(), entity.getMaterial());
        Assert.assertEquals(dto.getTexto(), entity.getTexto());
    }
    
    @Test
    public void getShirtTest() {
        List<CamisetaDTO> list = camisetaLogic.getCamisetas();
        Assert.assertEquals(list.size(), data.size());
        for (CamisetaDTO dto : list) {
            boolean found = false;
            for (CamisetaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getArtistTest() {
        CamisetaEntity entity = data.get(0);
        CamisetaDTO dto = camisetaLogic.getCamiseta(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getColor(), dto.getColor());
        Assert.assertEquals(entity.getTalla(), dto.getTalla());
        Assert.assertEquals(entity.getMaterial(), dto.getMaterial());
        Assert.assertEquals(entity.getTexto(), dto.getTexto());
    }
    
    @Test
    public void getShirtPaginationTest() {
        //Page 1
        CamisetaPageDTO dto1 = camisetaLogic.getCamisetas(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        CamisetaPageDTO dto2 = camisetaLogic.getCamisetas(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());
        for (CamisetaDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (CamisetaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        for (CamisetaDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (CamisetaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void deleteArtistTest() {
        CamisetaEntity entity = data.get(0);
        camisetaLogic.deleteCamiseta(entity.getId());
        CamisetaEntity deleted = em.find(CamisetaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateArtistTest() {
        CamisetaEntity entity = data.get(0);

        CamisetaDTO dto = new CamisetaDTO();
        dto.setId(entity.getId());
        dto.setColor(generateRandom(String.class));
        dto.setTalla(generateRandom(String.class));
        dto.setMaterial(generateRandom(String.class));
        dto.setTexto(generateRandom(String.class));

        camisetaLogic.updateCamiseta(dto);

        CamisetaEntity resp = em.find(CamisetaEntity.class, entity.getId());

        Assert.assertEquals(dto.getColor(), resp.getColor());
        Assert.assertEquals(dto.getTalla(), resp.getTalla());
        Assert.assertEquals(dto.getMaterial(), resp.getMaterial());
        Assert.assertEquals(dto.getTexto(), resp.getTexto());
    }
}