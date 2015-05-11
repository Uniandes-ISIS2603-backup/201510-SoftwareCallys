package co.edu.uniandes.Callys.stamp.logic.ejb;

import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.Callys.estampa.logic.api.IStampLogic;
import co.edu.uniandes.Callys.estampa.logic.converter.StampConverter;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.dto.StampPageDTO;
import co.edu.uniandes.Callys.estampa.logic.ejb.StampLogic;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import static co.edu.uniandes.Callys.util._TestUtil.generateRandom;
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
public class StampLogicTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
            .addPackage(StampEntity.class.getPackage())
            .addPackage(StampDTO.class.getPackage())
            .addPackage(ArtistaEntity.class.getPackage())
            .addPackage(ArtistaDTO.class.getPackage())
            .addPackage(StampConverter.class.getPackage())
            .addPackage(IStampLogic.class.getPackage())
            .addPackage(StampLogic.class.getPackage())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IStampLogic stampLogic;

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
        em.createQuery("delete from StampEntity").executeUpdate();
    }

    private List<StampEntity> data = new ArrayList<StampEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArtistaEntity artist=new ArtistaEntity();
            artist.setClave(generateRandom(String.class));
            artist.setComisionPorVenta(generateRandom(Double.class));
            artist.setDatosContacto(generateRandom(String.class));
            em.persist(artist);
            
            StampEntity entity = new StampEntity();
            entity.setTopic(generateRandomTopic());
            entity.setRating(generateRandom(Integer.class));
            entity.setName(generateRandom(String.class));
            entity.setImage(generateRandom(String.class));
            entity.setPrice(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createStampTest() {
        StampDTO dto = new StampDTO();
        dto.setTopic(generateRandomTopic());
        dto.setRating(generateRandom(Integer.class));
        dto.setName(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));
        
        StampDTO result = stampLogic.createStamp(dto);

        Assert.assertNotNull(result);

        StampEntity entity = em.find(StampEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getTopic(), entity.getTopic());
        Assert.assertEquals(dto.getRating(),entity.getRating());
        Assert.assertEquals(dto.getPrice(),entity.getPrice());
        Assert.assertEquals(dto.getImage(),entity.getImage());
    }

    @Test
    public void getStampsTest() {
        List<StampDTO> list = stampLogic.getStamps();
        Assert.assertEquals(list.size(), data.size());
        for (StampDTO dto : list) {
            boolean found = false;
            for (StampEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getStampTest() {
        StampEntity entity = data.get(0);
        StampDTO dto = stampLogic.getStamp(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getTopic(), dto.getTopic());
        Assert.assertEquals(entity.getRating(),dto.getRating());
        Assert.assertEquals(entity.getPrice(),dto.getPrice());
        Assert.assertEquals(entity.getImage(),dto.getImage());
    }

    @Test
    public void deleteStampTest() {
        StampEntity entity = data.get(0);
        stampLogic.deleteStamp(entity.getId());
        StampEntity deleted = em.find(StampEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateStampTest() {
        StampEntity entity = data.get(0);
        
        StampDTO dto = new StampDTO();
        dto.setTopic(generateRandomTopic());
        dto.setId(entity.getId());
        dto.setRating(generateRandom(Integer.class));
        dto.setName(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));
        
        stampLogic.updateStamp(dto);
        StampEntity resp = em.find(StampEntity.class, entity.getId());
        Assert.assertEquals(dto.getName(),resp.getName());
        Assert.assertEquals(dto.getTopic(),resp.getTopic());
        Assert.assertEquals(dto.getRating(),resp.getRating());
        Assert.assertEquals(dto.getPrice(),resp.getPrice());
        Assert.assertEquals(dto.getImage(),resp.getImage());
    }

    @Test
    public void getStampPaginationTest() {
        //Page 1
        StampPageDTO dto1=stampLogic.getStamps(1,2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        
        StampPageDTO dto2=stampLogic.getStamps(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());

        for (StampDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (StampEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (StampDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (StampEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    private String generateRandomTopic(){
        int randomNum = 1 + (int)(Math.random()*3);
        switch(randomNum){
            case 1: return "Animales";
            case 2: return "Videojuegos";
            case 3: return "Otros";
        }
        return null;
    }
}