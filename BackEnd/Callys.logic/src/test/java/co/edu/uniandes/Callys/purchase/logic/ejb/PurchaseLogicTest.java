package co.edu.uniandes.Callys.purchase.logic.ejb;

import static co.edu.uniandes.Callys.util._TestUtil.*;
import co.edu.uniandes.Callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.Callys.purchase.logic.converter.PurchaseConverter;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
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
public class PurchaseLogicTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PurchaseEntity.class.getPackage())
                .addPackage(PurchaseDTO.class.getPackage())
                .addPackage(PurchaseItemEntity.class.getPackage())
                .addPackage(PurchaseItemDTO.class.getPackage())
                .addPackage(PurchaseConverter.class.getPackage())
                .addPackage(PurchaseLogic.class.getPackage())
                .addPackage(IPurchaseLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IPurchaseLogic purchaseLogic;

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
        em.createQuery("delete from PurchaseEntity").executeUpdate();
    }

    private List<PurchaseEntity> data = new ArrayList<PurchaseEntity>();

    private void insertData() {
        for (int i = 0; i < 2; i++) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setDate(parseDate(generateRandomDate()));
            entity.setDatosDeEnvio(generateRandom(String.class));
            entity.setFormaDePago(generateRandom(String.class));
            entity.setIdCliente(new Long(1));
            em.persist(entity);
            data.add(entity);
        }
        PurchaseEntity entity = new PurchaseEntity();
        entity.setDate(parseDate(generateRandomDate()));
        entity.setDatosDeEnvio(generateRandom(String.class));
        entity.setFormaDePago(generateRandom(String.class));
        entity.setIdCliente(new Long(2));
        em.persist(entity);
        data.add(entity);
    }

    @Test
    public void createPurchaseTest() {
        PurchaseDTO dto = new PurchaseDTO();
        dto.setId(generateRandom(Long.class));
        dto.setDate(parseDate(generateRandomDate()));
        dto.setDatosDeEnvio(generateRandom(String.class));
        dto.setFormaDePago(generateRandom(String.class));

        PurchaseDTO result = purchaseLogic.createPurchase(dto);

        Assert.assertNotNull(result);

        PurchaseEntity entity = em.find(PurchaseEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getDate(), entity.getDate());
        Assert.assertEquals(dto.getDatosDeEnvio(), entity.getDatosDeEnvio());
        Assert.assertEquals(dto.getFormaDePago(), entity.getFormaDePago());
    }

    @Test
    public void getPurchasesTest() {
        List<PurchaseDTO> list = purchaseLogic.getPurchases();
        Assert.assertEquals(list.size(), data.size());
        for (PurchaseDTO dto : list) {
            boolean found = false;
            for (PurchaseEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getPurchaseTest() {
        PurchaseEntity entity = data.get(0);
        PurchaseDTO dto = purchaseLogic.getPurchase(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getDate(), dto.getDate());
        Assert.assertEquals(entity.getDatosDeEnvio(), dto.getDatosDeEnvio());
        Assert.assertEquals(entity.getFormaDePago(), dto.getFormaDePago());
    }
    
    @Test
    public void getPurchasesByClientTest() {
        List<PurchaseDTO> purchases=purchaseLogic.getPurchasesByClient(new Long(1));
        Assert.assertFalse(purchases.isEmpty());
        Assert.assertEquals(2,purchases.size());
        purchases=purchaseLogic.getPurchasesByClient(new Long(2));
        Assert.assertFalse(purchases.isEmpty());
        Assert.assertEquals(1,purchases.size());
        purchases=purchaseLogic.getPurchasesByClient(new Long(3));
        Assert.assertTrue(purchases.isEmpty());
    }

    @Test
    public void getItemPaginationTest() {
        //Page 1
        PurchasePageDTO dto1 = purchaseLogic.getPurchases(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        PurchasePageDTO dto2 = purchaseLogic.getPurchases(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());
        for (PurchaseDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (PurchaseEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        for (PurchaseDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (PurchaseEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
