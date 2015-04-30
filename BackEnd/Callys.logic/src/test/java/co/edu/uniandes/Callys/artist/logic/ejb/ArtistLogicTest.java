package co.edu.uniandes.Callys.artist.logic.ejb;

import static co.edu.uniandes.Callys.util._TestUtil.*;
import co.edu.uniandes.Callys.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.Callys.artista.logic.converter.ArtistaConverter;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.Callys.artista.logic.ejb.ArtistaLogic;
import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
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
public class ArtistLogicTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaDTO.class.getPackage())
                .addPackage(ArtistaConverter.class.getPackage())
                .addPackage(ArtistaLogic.class.getPackage())
                .addPackage(IArtistaLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IArtistaLogic artistaLogic;

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
        em.createQuery("delete from ArtistaEntity").executeUpdate();
    }

    private List<ArtistaEntity> data = new ArrayList<ArtistaEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArtistaEntity entity = new ArtistaEntity();
            entity.setId(generateRandom(Long.class));
            entity.setClave(generateRandom(String.class));
            entity.setNumeroEstampas(generateRandom(Integer.class));
            entity.setDatosContacto(generateRandom(String.class));
            entity.setComisionPorVenta(generateRandom(Double.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createArtistTest() {
        ArtistaDTO dto = new ArtistaDTO();
        dto.setId(generateRandom(Long.class));
        dto.setClave(generateRandom(String.class));
        dto.setNumeroEstampas(generateRandom(Integer.class));
        dto.setDatosContacto(generateRandom(String.class));
        dto.setComisionPorVenta(generateRandom(Double.class));

        ArtistaDTO result = artistaLogic.createArtista(dto);

        Assert.assertNotNull(result);

        ArtistaEntity entity = em.find(ArtistaEntity.class, result.getId());

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getClave(), entity.getClave());
        Assert.assertEquals(dto.getComisionPorVenta(), entity.getComisionPorVenta());
        Assert.assertEquals(dto.getDatosContacto(), entity.getDatosContacto());
        Assert.assertEquals(dto.getNumeroEstampas(), entity.getNumeroEstampas());
    }
    
    @Test
    public void getArtistTest() {
        List<ArtistaDTO> list = artistaLogic.getArtistas();
        Assert.assertEquals(list.size(), data.size());
        for (ArtistaDTO dto : list) {
            boolean found = false;
            for (ArtistaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
