package co.edu.uniandes.Callys.service.test;

import java.io.File;
import co.edu.uniandes.callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.callys.purchase.logic.converter.PurchaseConverter;
import co.edu.uniandes.callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.callys.purchase.logic.dto.PurchasePageDTO;
import co.edu.uniandes.callys.purchase.logic.entity.PurchaseEntity;
import co.edu.uniandes.callys.purchase.logic.ejb.PurchaseLogic;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PurchaseLogicTest {

    public static final String DEPLOY = "Callys.service";

    @Deployment
    public static Archive<?> createDeployment() {
        String URLRESOURCES = "src/main/webapp";

        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
            .addAsLibraries(DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml").artifact("co.edu.uniandes.Callys:Callys.logic:0.0.1-SNAPSHOT").resolveAsFiles())
            .addAsWebResource(new File(URLRESOURCES, "index.html"))
            .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("META-INF/beans.xml", "beans.xml")
            .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
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
            /*
            insertData();
            */
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

    private List<PurchaseEntity> data = new ArrayList<PurchaseEntity>();
/*
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setId(generateRandom(Long.class));
            em.persist(entity);
            data.add(entity);
        }
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
*/
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
    public void getItemPaginationTest() {
        //Page 1
        PurchasePageDTO dto1=purchaseLogic.getPurchases(1,2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        PurchasePageDTO dto2=purchaseLogic.getPurchases(2, 2);
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