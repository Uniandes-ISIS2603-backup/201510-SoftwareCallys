/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.item.logic.ejb;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.inject.Default;

import java.software.logic.api.IItemLogic;
import java.software.logic.dto.ItemDTO;
import java.software.logic.dto.ItemPageDTO;
import java.software.logic.converter.ItemConverter;
import java.software.logic.entity.ItemEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author estudiante
 */
public class ItemLogic {
     
    @PersistenceContext(unitName = "ItemClassPU")
    protected EntityManager entityManager;

    public ItemDTO createItem(ItemDTO sport) {
        ItemEntity entity = ItemConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return ItemConverter.entity2PersistenceDTO(entity);
    }

    public List<ItemDTO> getSItems() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return ItemConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public ItemPageDTO getSItems(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SportEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SportEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ItemPageDTO response = new ItemPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ItemConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public ItemDTO getItem(Long id) {
        return ItemConverter.entity2PersistenceDTO(entityManager.find(ItemEntity.class, id));
    }

    public void deleteItem(Long id) {
        ItemEntity entity = entityManager.find(ItemEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateItem(ItemDTO item) {
        ItemEntity entity = entityManager.merge(ItemConverter.persistenceDTO2Entity(item));
        ItemConverter.entity2PersistenceDTO(entity);
    }
}
