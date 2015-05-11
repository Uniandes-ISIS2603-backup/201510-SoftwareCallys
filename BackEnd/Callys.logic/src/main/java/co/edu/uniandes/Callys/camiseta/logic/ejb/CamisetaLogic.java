package co.edu.uniandes.Callys.camiseta.logic.ejb;

import co.edu.uniandes.Callys.camiseta.logic.api.ICamisetaLogic;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.Callys.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Default
@Stateless
@LocalBean
public class CamisetaLogic implements ICamisetaLogic{
    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public CamisetaDTO createCamiseta(CamisetaDTO shirt) {
        CamisetaEntity entity = CamisetaConverter.persistenceDTO2Entity(shirt);
        entity.setStamps(new ArrayList<StampEntity>());
        entityManager.persist(entity);
        return CamisetaConverter.entity2PersistenceDTO(entity); 
    }

    @Override
    public List<CamisetaDTO> getCamisetas() {
        Query q = entityManager.createQuery("select u from CamisetaEntity u");
        return CamisetaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
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

    @Override
    public CamisetaDTO getCamiseta(Long id) {
        return CamisetaConverter.entity2PersistenceDTO(entityManager.find(CamisetaEntity.class, id));
    }

    @Override
    public void deleteCamiseta(Long id) {
        CamisetaEntity entity = entityManager.find(CamisetaEntity.class, id);
        entityManager.remove(entity);
    }

    @Override
    public void updateCamiseta(CamisetaDTO camiseta) {
        CamisetaEntity entity = entityManager.merge(CamisetaConverter.persistenceDTO2Entity(camiseta));
        List<StampEntity> stamps=this.getSelectedStamps(camiseta);
        entity.setStamps(stamps);
        CamisetaConverter.entity2PersistenceDTO(entity);
    }
    
    public void addStamp(StampDTO stamp,CamisetaDTO shirt)
    {
        CamisetaEntity entity = entityManager.find(CamisetaEntity.class, shirt.getId());
        StampEntity entityStamp = entityManager.find(StampEntity.class, stamp.getId());
        entity.getStamps().add(entityStamp);
    }
    
    private List<StampEntity> getSelectedStamps(CamisetaDTO shirt) {
        if(shirt != null && shirt.getStamps()!= null) {
            List<StampEntity> stamps = new ArrayList<StampEntity>();
            for (Long stamp : shirt.getStamps()) {
                stamps.add(entityManager.find(StampEntity.class, stamp));
            }
            return stamps;
        }
        else {
            return null;
        }
    }
}