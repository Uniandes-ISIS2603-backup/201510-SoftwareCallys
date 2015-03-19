/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.camiseta.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.inject.Default;

import java.software.logic.api.ICamisetaLogic;
import java.software.logic.dto.CamisetaDTO;
import java.software.logic.dto.CamisetaPageDTO;
import java.software.logic.converter.CamisetaConverter;
import java.software.logic.entity.CamisetaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author estudiante
 */
public class CamisetaLogic {
    @PersistenceContext(unitName = "CamisetaClassPU")
    protected EntityManager entityManager;

    public CamisetaDTO createCamiseta(CamisetaDTO sport) {
        CamisetaEntity entity = CamisetaConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return CamisetaConverter.entity2PersistenceDTO(entity);
    }

    public List<CamisetaDTO> getCamisetas() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return CamisetaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public CamisetaPageDTO getCamisetas(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SportEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SportEntity u");
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
