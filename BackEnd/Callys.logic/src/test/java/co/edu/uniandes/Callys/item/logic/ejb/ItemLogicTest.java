package co.edu.uniandes.Callys.item.logic.ejb;

import co.edu.uniandes.Callys.item.logic.api.IItemLogic;
import co.edu.uniandes.Callys.item.logic.converter.ItemConverter;
import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import co.edu.uniandes.Callys.item.logic.dto.ItemPageDTO;
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
            .addPackage(CamisetaEntity.class.getPackage())
            .addPackage(CamisetaDTO.class.getPackage())
            .addPackage(StampEntity.class.getPackage())
            .addPackage(StampDTO.class.getPackage())
            .addPackage(CarroComprasEntity.class.getPackage())
            .addPackage(CarroComprasDTO.class.getPackage())
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
        em.createQuery("delete from ItemEntity").executeUpdate();
    }

    private List<ItemEntity> data = new ArrayList<ItemEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CamisetaEntity shirt = new CamisetaEntity();
            shirt.setColor(generateRandom(String.class));
            shirt.setMaterial(generateRandom(String.class));
            shirt.setTalla(generateRandom(String.class));
            shirt.setTexto(generateRandom(String.class));
            em.persist(shirt);
            //TODO queda pendiente las estampas
            
            ItemEntity entity = new ItemEntity();
            entity.setMonto(generateRandom(Double.class));
            entity.setCamiseta(shirt);

            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createItemTest() {
        Long shirt = data.get(0).getCamiseta().getId();
        ItemDTO dto = new ItemDTO();
        dto.setMonto(generateRandom(Double.class));
        dto.setCamiseta(shirt);
        
        ItemDTO result = itemLogic.createItem(dto);
        
        Assert.assertNotNull(result);

        ItemEntity entity = em.find(ItemEntity.class, result.getId());

        Assert.assertEquals(dto.getMonto(), entity.getMonto());
        Assert.assertEquals(dto.getCamiseta(), entity.getCamiseta().getId());
    }

    @Test
    public void getItemsTest() {
        List<ItemDTO> list = itemLogic.getItems();
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
        ItemDTO dto = itemLogic.getItem(entity.getId());
        
        Assert.assertNotNull(dto);
        
        Assert.assertEquals(entity.getMonto(), dto.getMonto());
        Assert.assertEquals(entity.getCamiseta().getId(), dto.getCamiseta());
    }

    @Test
    public void deleteItemTest() {
        ItemEntity entity = data.get(0);
        itemLogic.deleteItem(entity.getId());
        ItemEntity deleted = em.find(ItemEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateItemTest() {
        ItemEntity entity = data.get(0);
        Long newShirt = data.get(1).getCamiseta().getId();

        ItemDTO dto = new ItemDTO();
        dto.setId(entity.getId());
        dto.setCamiseta(newShirt);
        dto.setMonto(generateRandom(Double.class));
        
        itemLogic.updateItem(dto);
        ItemEntity resp = em.find(ItemEntity.class, entity.getId());

        Assert.assertEquals(dto.getMonto(), resp.getMonto());
        Assert.assertEquals(dto.getCamiseta(), resp.getCamiseta().getId());
    }

    @Test
    public void getItemPaginationTest() {
        //Page 1
        ItemPageDTO dto1=itemLogic.getItems(1,2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        
        ItemPageDTO dto2=itemLogic.getItems(2, 2);
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

