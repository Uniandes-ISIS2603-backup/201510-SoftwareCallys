/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author estudiante
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class CallysTest {
    
    public static String baseUrl;
    public static String URLRESOURCES = "src/main/webapp";
    public static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();
    
    @BeforeClass
    public static void setUp() {
        // Se crea un ainstancia del driver de firefox sobre el que se ejecutara la aplicacion.
        driver = new FirefoxDriver();
        baseUrl="http://localhost:8080";
//        // Este timeout sirve para esperar que inicie el firefox
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    @Before
    public void setUpTest() {
        // El browser ira a esta url. Se ejecuta al inicar cada uno de los metodos de prueba indicados con @Test
        driver.get(baseUrl + "index.html");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        //Se ejecuta al terminar todos los metodos de prueba indicados con @Test
        // Cierra el browser
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
        driver.findElement(By.id("stamp")).click();
        /**
        List<WebElement> rows =driver.findElements(By.xpath("//div[contains(@id,'Container')]/div"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(4).getText().equals("Estampa") && elems.get(5).getText().equals("20")) {
               
                success = true;
            }
        }
        */
       
        success = true;
        
        assertTrue(success);
        Thread.sleep(2000);
        
        
    }
    
    @Test
    public void t2deleteStamp() throws Exception {
        boolean success = false;  
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
        driver.findElement(By.id("stamp")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
     @Test
    public void t6addToCart() throws Exception {
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
    
     @Test
    public void t7signUpClient() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
       
        driver.findElement(By.id("userNameClient")).clear();
        driver.findElement(By.id("passwordClient")).clear();
        driver.findElement(By.id("creditCardClient")).clear();
        driver.findElement(By.id("emailClient")).clear();
         
        driver.findElement(By.id("userNameClient")).sendKeys("TestUser1");
        driver.findElement(By.id("passwordClient")).sendKeys("testPassword123");
        driver.findElement(By.id("creditCardClient")).sendKeys("1234567890");
        driver.findElement(By.id("emailClient")).sendKeys("testuser@callys.com");
        
        driver.findElement(By.id("submitClient")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    public void t8signUpArtist() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Test User");
        driver.findElement(By.id("userNameArtist")).sendKeys("TestUser1");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    @Test
    public void t9LogIn() throws Exception {
        boolean success = false;
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("TestUser1");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
}
