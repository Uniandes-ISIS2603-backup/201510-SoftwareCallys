package co.edu.uniandes.Callys.artista.logic.ejb;

import co.edu.uniandes.Callys.artista.logic.converter.ArtistaConverter;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ArtistaLogic {
 
    
    protected EntityManager entityManager;

    public ArtistaDTO createArtista(ArtistaDTO sport) {
        ArtistaEntity entity = ArtistaConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return ArtistaConverter.entity2PersistenceDTO(entity);
    }

    public List<ArtistaDTO> getArtistas() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return ArtistaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SportEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SportEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ArtistaPageDTO response = new ArtistaPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ArtistaConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public ArtistaDTO getArtista(Long id) {
        return ArtistaConverter.entity2PersistenceDTO(entityManager.find(ArtistaEntity.class, id));
    }

    public void deleteArtista(Long id) {
        ArtistaEntity entity = entityManager.find(ArtistaEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateArtista(ArtistaDTO artista) {
        ArtistaEntity entity = entityManager.merge(ArtistaConverter.persistenceDTO2Entity(artista));
        ArtistaConverter.entity2PersistenceDTO(entity);
    }
}
