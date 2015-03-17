/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.software.logic.dto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.inject.Default;

import java.software.logic.api.IStampLogic;
import java.software.logic.dto.StampDTO;
import java.software.logic.dto.StampPageDTO;
import java.software.logic.converter.StampConverter;
import java.software.llogic.entity.StampEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author estudiante
 */
public class StampLogic {
    
    @PersistenceContext(unitName = "StampClassPU")
    protected EntityManager entityManager;

    public StampDTO createStamp(StampDTO sport) {
        StampEntity entity = StampConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return StampConverter.entity2PersistenceDTO(entity);
    }

    public List<StampDTO> getStamps() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return StampConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public StampPageDTO getStamps(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SportEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SportEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        StampPageDTO response = new StampPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(StampConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public StampDTO getStamp(Long id) {
        return StampConverter.entity2PersistenceDTO(entityManager.find(StampEntity.class, id));
    }

    public void deleteStamp(Long id) {
        StampEntity entity = entityManager.find(StampEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateStamp(StampDTO stamp) {
        StampEntity entity = entityManager.merge(StampConverter.persistenceDTO2Entity(stamp));
        StampConverter.entity2PersistenceDTO(entity);
    }
}
