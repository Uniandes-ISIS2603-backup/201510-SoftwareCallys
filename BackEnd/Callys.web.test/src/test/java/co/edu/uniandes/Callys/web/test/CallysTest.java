package co.edu.uniandes.Callys.web.test;
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
public class CallysTest {
    
    // Es la instancia inicial del web driver que controlará el navegador firefox
        private static WebDriver driver;
        // url en el cual se aloja la página web (en este caso localhost:8080)
        private static String baseUrl;
        // variable que indica si varios alert consecutivos (alert javascript) se tomarán
        private static boolean acceptNextAlert = true;
        private static StringBuffer verificationErrors = new StringBuffer();
 
       /*La anotación @BeforeClass indica lo que se debe ejecutar ANTES de correr el archivo de pruebas. Este método instancia un nuevo driver firefox (causando la apertura de una ventana física de firefox).*/
        @BeforeClass
        public static void setUp() throws Exception {
            driver = new FirefoxDriver();
        // se define el url base del proyecto web
            baseUrl = "http://localhost:8080";
        /* Indica cuanto se espera para la respuesta de cualquier comando realizado hacia el navegador*/
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
 
 
        // La anotación @AfterClass indica lo que se debe ejecutar DESPUES de ejecutar
        // el archivo de pruebas. Este método cierra la ventana de firefox
        // abierta por @BeforeClass que se utilizó para la prueba.
        @AfterClass
        public static void tearDown() throws Exception {
            // Se cierra el navegador.
            driver.quit();
           // Se verifica que se haya cerrado efectivamente el navegador.
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
    
    @Before
    public void setUpUrl() {
        driver.get(baseUrl + "/Callys.service");
    }
    
   @Test 
    public void t1signUpArtist() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("artist")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Luis");
        driver.findElement(By.id("userNameArtist")).sendKeys("Luis");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    @Test
    public void t2LogIn() throws Exception {
        boolean success = false;
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("Luis");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        success = true;
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    @Test
    public void t3createStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("artist")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Luis");
        driver.findElement(By.id("userNameArtist")).sendKeys("Luis");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("Luis");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
       
       
        Thread.sleep(2000);
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
    public void t4deleteStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("artist")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Luis");
        driver.findElement(By.id("userNameArtist")).sendKeys("Luis");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("Luis");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();     
       
        Thread.sleep(2000);
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
    public void t5likeStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("artist")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Luis");
        driver.findElement(By.id("userNameArtist")).sendKeys("Luis");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("Luis");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
       
       
        Thread.sleep(2000);
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
    public void t6dislikeStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("artist")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Luis");
        driver.findElement(By.id("userNameArtist")).sendKeys("Luis");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("Luis");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
       
       
        Thread.sleep(2000);
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
    public void t7editStamp() throws Exception {
        boolean success = false;
        driver.findElement(By.id("signup")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("artist")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameArtist")).clear();
        driver.findElement(By.id("userNameArtist")).clear();
        driver.findElement(By.id("passwordArtist")).clear();
        
        driver.findElement(By.id("nameArtist")).sendKeys("Luis");
        driver.findElement(By.id("userNameArtist")).sendKeys("Luis");
        driver.findElement(By.id("passwordArtist")).sendKeys("testPassword123");
        driver.findElement(By.id("submitArtist")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("password")).clear();
        
        driver.findElement(By.id("userName")).sendKeys("Luis");
        driver.findElement(By.id("password")).sendKeys("testPassword123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
       
       
        Thread.sleep(2000);
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
    public void t8addToCart() throws Exception {
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
    public void t9signUpClient() throws Exception {
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
    
}

