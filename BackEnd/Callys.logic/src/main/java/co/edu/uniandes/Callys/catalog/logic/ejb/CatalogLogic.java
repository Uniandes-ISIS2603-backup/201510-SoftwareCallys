package co.edu.uniandes.Callys.catalog.logic.ejb;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import co.edu.uniandes.Callys.catalog.logic.api.ICatalogLogic;
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogDTO;
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogPageDTO;
import co.edu.uniandes.Callys.catalog.logic.converter.CatalogConverter;
import co.edu.uniandes.Callys.catalog.logic.entity.CatalogEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Default
@Stateless
@LocalBean
public class CatalogLogic implements ICatalogLogic {

    @PersistenceContext(unitName = "CatalogoClassPU")
    protected EntityManager entityManager;

    public CatalogDTO createCatalogo(CatalogDTO detail) {
        CatalogEntity entity = CatalogConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return CatalogConverter.entity2PersistenceDTO(entity);
    }

    public List<CatalogDTO> getCatalogo() {
        Query q = entityManager.createQuery("select u from CatalogoEntity u");
        return CatalogConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public CatalogPageDTO getCatalogo(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CatalogoEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CatalogoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CatalogPageDTO response = new CatalogPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(CatalogConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public CatalogDTO getCatalogo(Long id) {
        return CatalogConverter.entity2PersistenceDTO(entityManager.find(CatalogEntity.class, id));
    }

    public void deleteCatalogo(Long id) {
        CatalogEntity entity = entityManager.find(CatalogEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCatalogo(CatalogDTO detail) {
        CatalogEntity entity = entityManager.merge(CatalogConverter.persistenceDTO2Entity(detail));
        CatalogConverter.entity2PersistenceDTO(entity);
    }
}
