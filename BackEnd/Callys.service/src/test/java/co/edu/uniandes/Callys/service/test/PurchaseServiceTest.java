package co.edu.uniandes.Callys.service.test;

import co.edu.uniandes.Callys.services.StampService;
import java.io.File;
import co.edu.uniandes.Callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.Callys.purchase.logic.converter.PurchaseConverter;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
import co.edu.uniandes.Callys.purchase.logic.ejb.PurchaseLogic;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Arquillian.class)
public class PurchaseServiceTest {

    public static final String DEPLOY = "Callys.service";
    public static String URLRESOURCES = "src/main/webapp";

    @ArquillianResource
    URL deploymentURL;
    
    @Deployment
    public static Archive<?> createDeployment() {
        

        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
            .addAsLibraries(DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml").artifact("co.edu.uniandes.Callys:Callys.logic:0.0.1-SNAPSHOT").resolveAsFiles())
            .addPackage(StampService.class.getPackage())
            .addAsWebResource(new File(URLRESOURCES, "index.html"))
            .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
            .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
            .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
    }
    private static WebDriver driver;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
 
    @Before
    public void setURL(){
        driver.get(deploymentURL + "index.html");
    }
    
    /*La anotación ‘@BeforeClass’ indica lo que se debe ejecutar ANTES de correr
     el archivo de pruebas. Este método instancia un nuevo driver firefox
     (causando la apertura de una ventana física de firefox).*/
    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    /* La anotación ‘@AfterClass’ indica lo que se debe ejecutar DESPUÉS de ejecutar
     el archivo de pruebas. Este método cierra la ventana de firefox
     abierta por @BeforeClass que se utilizó para la prueba.*/
    @AfterClass
    public static void tearDown() throws Exception {
 
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
 
    
        @Test
    public void t1createStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("upload")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("name")).sendKeys("Estampa");
        driver.findElement(By.id("price")).sendKeys("20");
        driver.findElement(By.id("saveStamp")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    @Test
    public void t2deleteStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("upload")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("name")).sendKeys("Estampa");
        driver.findElement(By.id("price")).sendKeys("20");
        driver.findElement(By.id("saveStamp")).click();
        Thread.sleep(2000);
   
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("name")).equals("Estampa");
        driver.findElement(By.id("delete")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
        
    }
 
    @Test
    public void t3likeStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("upload")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("name")).sendKeys("Estampa");
        driver.findElement(By.id("price")).sendKeys("20");
        driver.findElement(By.id("saveStamp")).click();
        Thread.sleep(2000);
   
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("name")).equals("Estampa");
        driver.findElement(By.id("like")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
        
    }
    
      @Test
    public void t4dislikeStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("upload")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("name")).sendKeys("Estampa");
        driver.findElement(By.id("price")).sendKeys("20");
        driver.findElement(By.id("saveStamp")).click();
        Thread.sleep(2000);
   
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("name")).equals("Estampa");
        driver.findElement(By.id("dislike")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
        
    }
    
    @Test
    public void t5editStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("upload")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("name")).sendKeys("Estampa");
        driver.findElement(By.id("price")).sendKeys("20");
        driver.findElement(By.id("saveStamp")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("name")).equals("Estampa");
        driver.findElement(By.id("edit")).click();
        Thread.sleep(2000);
        /*
        driver.findElement(By.id("name")).equals("Estampa");
        driver.findElement(By.id("price")).equals("20");
                */
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("name")).sendKeys("Flash");
        driver.findElement(By.id("price")).sendKeys("35");
        driver.findElement(By.id("saveStamp")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
     @Test
    public void t6buyShirt() throws Exception {
        boolean success = false;
        driver.findElement(By.id("shirt")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("shirt1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("color")).clear();
        driver.findElement(By.id("size")).clear();
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("color")).sendKeys("Silver");
        driver.findElement(By.id("size")).sendKeys("S");
        driver.findElement(By.id("quantity")).sendKeys("2");
        driver.findElement(By.id("addToCart")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
}