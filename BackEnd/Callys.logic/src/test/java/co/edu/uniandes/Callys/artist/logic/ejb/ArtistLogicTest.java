package co.edu.uniandes.Callys.artist.logic.ejb;

import static co.edu.uniandes.Callys.util._TestUtil.*;
import co.edu.uniandes.Callys.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.Callys.artista.logic.converter.ArtistaConverter;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.Callys.artista.logic.ejb.ArtistaLogic;
import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
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
            .addPackage(StampEntity.class.getPackage())
            .addPackage(StampDTO.class.getPackage())
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
            List<StampEntity> stamps = new ArrayList<StampEntity>();
            ArtistaEntity entity = new ArtistaEntity();
            entity.setClave(generateRandom(String.class));
            entity.setName(generateRandom(String.class));
            entity.setUsername(generateRandom(String.class));
            entity.setDatosContacto(generateRandom(String.class));
            entity.setComisionPorVenta(generateRandom(Double.class));
            for(int j=0; j < 3; j++) {
                StampEntity stamp=new StampEntity();
                stamp.setImage(generateRandom(String.class));
                stamp.setName(generateRandom(String.class));
                stamp.setPrice(generateRandom(Integer.class));
                stamp.setRating(generateRandom(Integer.class));
                stamp.setTopic(generateRandom(String.class));
                stamps.add(stamp);
                em.persist(stamp);
            }
            entity.setStamps(stamps);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createArtistTest() {
        List<Long> stamps = new ArrayList<Long>();
        for (int i = 0; i < 3; i++) {
            stamps.add(data.get(0).getStamps().get(i).getId());
        }
        ArtistaDTO dto = new ArtistaDTO();
        dto.setClave(generateRandom(String.class));
        dto.setName(generateRandom(String.class));
        dto.setUsername(generateRandom(String.class));
        dto.setDatosContacto(generateRandom(String.class));
        dto.setComisionPorVenta(generateRandom(Double.class));
        dto.setStamps(stamps);
        
        ArtistaDTO result = artistaLogic.createArtista(dto);

        Assert.assertNotNull(result);

        ArtistaEntity entity = em.find(ArtistaEntity.class, result.getId());

        Assert.assertEquals(dto.getClave(), entity.getClave());
        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getUsername(), entity.getUsername());
        Assert.assertEquals(dto.getComisionPorVenta(), entity.getComisionPorVenta());
        Assert.assertEquals(dto.getDatosContacto(), entity.getDatosContacto());

        Assert.assertEquals(dto.getStamps().size(), entity.getStamps().size());
        for (int i = 0; i < dto.getStamps().size(); i++) {
            Assert.assertEquals(dto.getStamps().get(i), entity.getStamps().get(i).getId());
        }
    }
    
    @Test
    public void getArtistsTest() {
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
    
    @Test
    public void getArtistTest() {
        ArtistaEntity entity = data.get(0);
        ArtistaDTO dto = artistaLogic.getArtista(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getId(), dto.getId());
        Assert.assertEquals(entity.getClave(), dto.getClave());
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getUsername(), dto.getUsername());
        Assert.assertEquals(entity.getComisionPorVenta(), dto.getComisionPorVenta());
        Assert.assertEquals(entity.getDatosContacto(), dto.getDatosContacto());

        Assert.assertEquals(entity.getStamps().size(), dto.getStamps().size());
        for (int i = 0; i < entity.getStamps().size(); i++) {
            Assert.assertEquals(entity.getStamps().get(i).getId(), dto.getStamps().get(i));
        }
    }
    
    @Test
    public void getArtistPaginationTest() {
        //Page 1
        ArtistaPageDTO dto1 = artistaLogic.getArtistas(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.getRecords().size());
        Assert.assertEquals(3L, dto1.getTotalRecords().longValue());
        ArtistaPageDTO dto2 = artistaLogic.getArtistas(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.getRecords().size());
        Assert.assertEquals(3L, dto2.getTotalRecords().longValue());
        for (ArtistaDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (ArtistaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        for (ArtistaDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (ArtistaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
   
    @Test
    public void deleteArtistTest() {
        ArtistaEntity entity = data.get(0);
        artistaLogic.deleteArtista(entity.getId());
        ArtistaEntity deleted = em.find(ArtistaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateArtistTest() {
        ArtistaEntity entity = data.get(0);

        ArtistaDTO dto = new ArtistaDTO();
        dto.setId(entity.getId());
        dto.setClave(generateRandom(String.class));
        dto.setNumeroEstampas(generateRandom(Integer.class));
        dto.setDatosContacto(generateRandom(String.class));
        dto.setComisionPorVenta(generateRandom(Double.class));

        artistaLogic.updateArtista(dto);

        ArtistaEntity resp = em.find(ArtistaEntity.class, entity.getId());

        Assert.assertEquals(dto.getClave(), resp.getClave());
        Assert.assertEquals(dto.getComisionPorVenta(), resp.getComisionPorVenta());
        Assert.assertEquals(dto.getDatosContacto(), resp.getDatosContacto());
    }
    
    @Test
    public void loginTest() {
        ArtistaEntity entity = data.get(0);
        ArtistaDTO dto = artistaLogic.login(entity.getUsername(), entity.getClave());
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getClave(), entity.getClave());
        Assert.assertEquals(dto.getComisionPorVenta(), entity.getComisionPorVenta());
        Assert.assertEquals(dto.getDatosContacto(), entity.getDatosContacto());
        
    }
}