package co.edu.uniandes.Callys.purchaseitem.logic.ejb;

import static co.edu.uniandes.Callys.util._TestUtil.*;
import co.edu.uniandes.Callys.purchaseitem.logic.api.IPurchaseItemLogic;
import co.edu.uniandes.Callys.purchaseitem.logic.converter.PurchaseItemConverter;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.entity.PurchaseItemEntity;
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
public class PurchaseItemLogic {
    public static final String DEPLOY = "Prueba";
    
     @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
            .addPackage(PurchaseItemEntity.class.getPackage())
            .addPackage(PurchaseItemDTO.class.getPackage())
            .addPackage(PurchaseItemConverter.class.getPackage())
            .addPackage(PurchaseItemLogic.class.getPackage())
            .addPackage(IPurchaseItemLogic.class.getPackage())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IPurchaseItemLogic purchaseItemLogic;

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
        em.createQuery("delete from PurchaseItemEntity").executeUpdate();
    }

    private List<PurchaseItemEntity> data = new ArrayList<PurchaseItemEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PurchaseItemEntity entity = new PurchaseItemEntity();
            entity.setId(generateRandom(Long.class));
            entity.setIdCamiseta(generateRandom(Long.class));
            entity.setIdPurchase(generateRandom(Long.class));
            entity.setMonto(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createPurchaseItemTest() {
        PurchaseItemDTO dto = new PurchaseItemDTO();
        dto.setId(generateRandom(Long.class));
        dto.setIdCamiseta(generateRandom(Long.class));
        dto.setIdPurchase(generateRandom(Long.class));
        dto.setMonto(generateRandom(Integer.class));
        PurchaseItemDTO result = purchaseItemLogic.createPurchaseItem(dto);

        Assert.assertNotNull(result);

        PurchaseItemEntity entity = em.find(PurchaseItemEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getIdCamiseta(), entity.getIdCamiseta());
        Assert.assertEquals(dto.getIdPurchase(), entity.getIdPurchase());
        Assert.assertEquals(dto.getMonto(), entity.getMonto());
    }

    @Test
    public void getPurchaseItemsTest() {
        List<PurchaseItemDTO> list = purchaseItemLogic.getPurchaseItems();
        Assert.assertEquals(list.size(), data.size());
        for (PurchaseItemDTO dto : list) {
            boolean found = false;
            for (PurchaseItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getPurchaseItemTest() {
        PurchaseItemEntity entity = data.get(0);
        PurchaseItemDTO dto = purchaseItemLogic.getPurchaseItem(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getIdCamiseta(), dto.getIdCamiseta());
        Assert.assertEquals(entity.getIdPurchase(), dto.getIdPurchase());
        Assert.assertEquals(entity.getMonto(), dto.getMonto());
    }

    @Test
    public void getItemPaginationTest() {
        //Page 1
        PurchaseItemPageDTO dto1 = purchaseItemLogic.getPurchaseItems(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        PurchaseItemPageDTO dto2 = purchaseItemLogic.getPurchaseItems(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());
        for (PurchaseItemDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (PurchaseItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        for (PurchaseItemDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (PurchaseItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}