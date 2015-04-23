package co.edu.uniandes.callys.camiseta.logic.ejb;

import co.edu.uniandes.callys.camiseta.logic.api.ICamisetaLogic;
import co.edu.uniandes.callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.callys.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.callys.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.callys.camiseta.logic.entity.CamisetaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CamisetaLogic implements ICamisetaLogic{
    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    public CamisetaDTO createCamiseta(CamisetaDTO sport) {
        CamisetaEntity entity = CamisetaConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return CamisetaConverter.entity2PersistenceDTO(entity);
    }

    public List<CamisetaDTO> getCamisetas() {
        Query q = entityManager.createQuery("select u from CamisetaEntity u");
        return CamisetaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public CamisetaPageDTO getCamisetas(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CamisetaEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CamisetaEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CamisetaPageDTO response = new CamisetaPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(CamisetaConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public CamisetaDTO getCamiseta(Long id) {
        return CamisetaConverter.entity2PersistenceDTO(entityManager.find(CamisetaEntity.class, id));
    }

    public void deleteCamiseta(Long id) {
        CamisetaEntity entity = entityManager.find(CamisetaEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCamiseta(CamisetaDTO camiseta) {
        CamisetaEntity entity = entityManager.merge(CamisetaConverter.persistenceDTO2Entity(camiseta));
        CamisetaConverter.entity2PersistenceDTO(entity);
    }
}
