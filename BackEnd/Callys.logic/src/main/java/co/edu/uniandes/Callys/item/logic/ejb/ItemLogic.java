package co.edu.uniandes.Callys.item.logic.ejb;

import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.Callys.item.logic.api.IItemLogic;
import co.edu.uniandes.Callys.item.logic.converter.ItemConverter;
import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.dto.ItemPageDTO;
import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ItemLogic implements IItemLogic{
     
    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public ItemDTO createItem(ItemDTO item) {
        ItemEntity entity = ItemConverter.persistenceDTO2Entity(item);
        CamisetaEntity camiseta = this.getSelectedShirt(item);
        if (camiseta != null) {
            entity.setCamiseta(camiseta);
        }
        entityManager.persist(entity);
        return ItemConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<ItemDTO> getItems() {
        Query q = entityManager.createQuery("select u from ItemEntity u");
        return ItemConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public ItemPageDTO getItems(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from ItemEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from ItemEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ItemPageDTO response = new ItemPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ItemConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    @Override
    public ItemDTO getItem(Long id) {
        return ItemConverter.entity2PersistenceDTO(entityManager.find(ItemEntity.class, id));
    }

    private CamisetaEntity getSelectedShirt(ItemDTO item){
        if (item != null && item.getCamiseta() != null) {
            return entityManager.find(CamisetaEntity.class, item.getCamiseta());
        }else{
            return null;
        }
    }
        
    @Override
    public void deleteItem(Long id) {
        ItemEntity entity = entityManager.find(ItemEntity.class, id);
        entityManager.remove(entity);
    }

    @Override
    public void updateItem(ItemDTO item) {
        ItemEntity entity = entityManager.merge(ItemConverter.persistenceDTO2Entity(item));
        CamisetaEntity shirt = this.getSelectedShirt(item);
        if (shirt != null) {
            entity.setCamiseta(shirt);
        }
        ItemConverter.entity2PersistenceDTO(entity);
    }
}