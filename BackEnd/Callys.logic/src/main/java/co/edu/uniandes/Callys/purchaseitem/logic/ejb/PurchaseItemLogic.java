package co.edu.uniandes.callys.purchaseitem.logic.ejb;

import co.edu.uniandes.callys.purchaseitem.logic.converter.PurchaseItemConverter;
import co.edu.uniandes.callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
import co.edu.uniandes.callys.purchaseitem.logic.entity.PurchaseItemEntity;
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
public class PurchaseItemLogic {
    
    @PersistenceContext(unitName = "PurchaseClassPU")
    protected EntityManager entityManager;

    public PurchaseItemDTO createPurchaseItem(PurchaseItemDTO detail) {
        PurchaseItemEntity entity = PurchaseItemConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return PurchaseItemConverter.entity2PersistenceDTO(entity);
    }

    public List<PurchaseItemDTO> getPurchaseItem() {
        Query q = entityManager.createQuery("select u from PurchaseItemEntity u");
        return PurchaseItemConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public PurchaseItemPageDTO getPurchaseItem(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from PurchaseItemEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from PurchaseItemEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        PurchaseItemPageDTO response = new PurchaseItemPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(PurchaseItemConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public PurchaseItemDTO getPurchaseItem(Long id) {
        return PurchaseItemConverter.entity2PersistenceDTO(entityManager.find(PurchaseItemEntity.class, id));
    }

    public void deletePurchaseItem(Long id) {
        PurchaseItemEntity entity = entityManager.find(PurchaseItemEntity.class, id);
        entityManager.remove(entity);
    }

    public void updatePurchaseItem(PurchaseItemDTO detail) {
        PurchaseItemEntity entity = entityManager.merge(PurchaseItemConverter.persistenceDTO2Entity(detail));
        PurchaseItemConverter.entity2PersistenceDTO(entity);
    }
}
