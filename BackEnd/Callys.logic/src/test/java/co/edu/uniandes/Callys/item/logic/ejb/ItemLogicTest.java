/*
package co.edu.uniandes.Callys.item.logic.ejb;

import co.edu.uniandes.Callys.item.logic.api.IItemLogic;
import co.edu.uniandes.Callys.item.logic.converter.ItemConverter;
import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.ejb.ItemLogic;
import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
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
public class ItemLogicTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
            .addPackage(ItemEntity.class.getPackage())
            .addPackage(ItemDTO.class.getPackage())
            .addPackage(ItemConverter.class.getPackage())
            .addPackage(IItemLogic.class.getPackage())
            .addPackage(ItemLogic.class.getPackage())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IItemLogic itemLogic;

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

    private List<ItemEntity> data = new ArrayList<ItemEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ItemEntity entity = new ItemEntity();

            entity.setId(generateRandom(Long.class));

            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createItemTest() {
        ItemDTO dto = new ItemDTO();
        dto.setMonto(generateRandom(Double.class));
        dto.setId(generateRandom(Long.class));
        
        ItemDTO result = itemLogic.createItem(dto);
        
        Assert.assertNotNull(result);

        ItemEntity entity = em.find(ItemEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getMonto(), entity.getMonto());
    }

    @Test
    public void getItemsTest() {
        List<ItemDTO> list = itemLogic.getItem();
        Assert.assertEquals(list.size(), data.size());
        for (ItemDTO dto : list) {
            boolean found = false;
            for (ItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getItemTest() {
        ItemEntity entity = data.get(0);
        ItemDTO dto = itemLogic.getStamp(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getTopic(), dto.getTopic());
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getIdArtista(), dto.getIdArtista());
        Assert.assertEquals(entity.getRating(), dto.getRating());
    }

    @Test
    public void deleteItemTest() {
        ItemEntity entity = data.get(0);
        itemLogic.deleteStamp(entity.getId());
        ItemEntity deleted = em.find(ItemEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateItemTest() {
        ItemEntity entity = data.get(0);
        ItemDTO dto = new ItemDTO();
        
        dto.setTopic(generateRandomTopic());
        dto.setId(generateRandom(Long.class));
        dto.setIdArtista(generateRandom(Long.class));
        dto.setRating(generateRandom(Integer.class));
        dto.setName(generateRandom(String.class));
        
        itemLogic.updateStamp(dto);
        ItemEntity resp = em.find(ItemEntity.class, entity.getId());
        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getTopic(), resp.getTopic());
        Assert.assertEquals(dto.getId(), resp.getId());
        Assert.assertEquals(dto.getIdArtista(), resp.getIdArtista());
        Assert.assertEquals(dto.getRating(), resp.getRating());
    }

    @Test
    public void getItemPaginationTest() {
        //Page 1
        ItemPageDTO dto1=itemLogic.getStamp(1,2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        
        ItemPageDTO dto2=itemLogic.getStamp(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());

        for (ItemDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (ItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ItemDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (ItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
*/
