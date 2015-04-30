package co.edu.uniandes.Callys.purchase.logic.ejb;

import co.edu.uniandes.Callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.Callys.purchase.logic.converter.PurchaseConverter;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
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
public class PurchaseLogic implements IPurchaseLogic {

    @PersistenceContext(unitName = "CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public PurchaseDTO createPurchase(PurchaseDTO detail) {
        PurchaseEntity entity = PurchaseConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return PurchaseConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<PurchaseDTO> getPurchases() {
        Query q = entityManager.createQuery("select u from PurchaseEntity u");
        return PurchaseConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public PurchasePageDTO getPurchases(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from PurchaseEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from PurchaseEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        PurchasePageDTO response = new PurchasePageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(PurchaseConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    @Override
    public PurchaseDTO getPurchase(Long id) {
        return PurchaseConverter.entity2PersistenceDTO(entityManager.find(PurchaseEntity.class, id));
    }
}
