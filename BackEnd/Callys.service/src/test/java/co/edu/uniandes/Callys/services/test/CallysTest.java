/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.services.test;

import co.edu.uniandes.Callys.services.ArtistaService;
import co.edu.uniandes.Callys.services.CamisetaService;
import co.edu.uniandes.Callys.services.CarroComprasService;
import co.edu.uniandes.Callys.services.ClienteService;
import co.edu.uniandes.Callys.services.ItemService;
import co.edu.uniandes.Callys.services.PurchaseItemService;
import co.edu.uniandes.Callys.services.PurchaseService;
import co.edu.uniandes.Callys.services.StampService;
import java.io.File;
import java.net.URL;
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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

    // Esta variable contendra la URL que utiliza arquillian paraejecutar el contenedor
    @ArquillianResource
    URL deploymentURL;

    @Deployment
    public static Archive<?> createDeployment() {

        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");

        WebArchive war = ShrinkWrap
                // Nombre del Proyecto "Callys.service" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "Callys.service.war")
                // Se agrega la dependencia a la l�gica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.Callys:Callys.logic:0.0.1")
                        .resolveAsFiles())
                // Se agregan los compilados de los paquetes que se van a probar
                .addPackage(StampService.class.getPackage())
                .addPackage(ArtistaService.class.getPackage())
                .addPackage(CamisetaService.class.getPackage())
                .addPackage(CarroComprasService.class.getPackage())
                .addPackage(ClienteService.class.getPackage())
                .addPackage(ItemService.class.getPackage())
                .addPackage(PurchaseService.class.getPackage())
                .addPackage(PurchaseItemService.class.getPackage())
                
                // Se agregan los html, el bootstrap y los javascript. 
                .addAsWebResource(new File(URLRESOURCES, "index.html"))
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/assets/css/").as(GenericArchive.class), "/src/assets/css/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/assets/fonts/").as(GenericArchive.class), "/src/assets/fonts/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/assets/libs/").as(GenericArchive.class), "/src/assets/libs/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/shared/crud").as(GenericArchive.class), "/src/shared/crud", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/shared/mocks").as(GenericArchive.class), "/src/shared/mocks", Filters.includeAll())
                // Los siguientes son los javascript de los modulos que se van a probar.
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/cart/").as(GenericArchive.class), "/src/modules/cart/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/catalog/").as(GenericArchive.class), "/src/modules/catalog/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/client/").as(GenericArchive.class), "/src/modules/client/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/contact/").as(GenericArchive.class), "/src/modules/contact/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/details/").as(GenericArchive.class), "/src/modules/details/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/login/").as(GenericArchive.class), "/src/modules/login/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/purchase/").as(GenericArchive.class), "/src/modules/purchase/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/shirt/").as(GenericArchive.class), "/src/modules/shirt/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/singup/").as(GenericArchive.class), "/src/modules/singup/", Filters.includeAll())
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/modules/stamp/").as(GenericArchive.class), "/src/modules/stamp/", Filters.includeAll())
                   // El archivo que contiene la configuracion a la base de datos. 
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
//                // El archivo beans.xml es necesario para injecci�n de dependencias. 
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));

        return war;
    }
    
    @BeforeClass
    public static void setUp() {
        // Se crea un ainstancia del driver de firefox sobre el que se ejecutara la aplicacion.
        driver = new FirefoxDriver();
//        // Este timeout sirve para esperar que inicie el firefox
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    @Before
    public void setUpTest() {
        // El browser ira a esta url. Se ejecuta al inicar cada uno de los metodos de prueba indicados con @Test
        driver.get(deploymentURL + "index.html");
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
}
