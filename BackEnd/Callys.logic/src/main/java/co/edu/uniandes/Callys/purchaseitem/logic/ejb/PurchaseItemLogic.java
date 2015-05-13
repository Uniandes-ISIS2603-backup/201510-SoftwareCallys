package co.edu.uniandes.Callys.purchaseitem.logic.ejb;

import co.edu.uniandes.Callys.purchaseitem.logic.api.IPurchaseItemLogic;
import co.edu.uniandes.Callys.purchaseitem.logic.converter.PurchaseItemConverter;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.entity.PurchaseItemEntity;
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
public class PurchaseItemLogic implements IPurchaseItemLogic{
    
    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public PurchaseItemDTO createPurchaseItem(PurchaseItemDTO detail) {
        PurchaseItemEntity entity = PurchaseItemConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return PurchaseItemConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<PurchaseItemDTO> getPurchaseItems() {
        Query q = entityManager.createQuery("select u from PurchaseItemEntity u");
        return PurchaseItemConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public PurchaseItemPageDTO getPurchaseItems(Integer page, Integer maxRecords) {
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

    @Override
    public PurchaseItemDTO getPurchaseItem(Long id) {
        return PurchaseItemConverter.entity2PersistenceDTO(entityManager.find(PurchaseItemEntity.class, id));
    }
    
    @Override
    public List<PurchaseItemDTO> getItemsByPurchase(Long idPurchase)
    {
        List<PurchaseItemDTO> answer=new ArrayList<PurchaseItemDTO>();
        Query q = entityManager.createQuery("select u from ItemEntity u");
        List<PurchaseItemDTO> items=PurchaseItemConverter.entity2PersistenceDTOList(q.getResultList());
        for(PurchaseItemDTO item:items)
        {
            if(item.getIdPurchase().equals(idPurchase))
            {
                answer.add(item);
            }
        }
        return answer;
    }
}
