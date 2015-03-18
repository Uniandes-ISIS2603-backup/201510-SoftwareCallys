/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalogo.logic.ejb;

/**
 *
 * @author estudiante
 */
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.inject.Default;

import co.edu.uniandes.Callys.catalogo.logic.api.ICatalogoLogic;
import co.edu.uniandes.Callys.catalogo.logic.dto.CatalogoDTO;
import co.edu.uniandes.Callys.catalogo.logic.dto.CatalogoPageDTO;
import co.edu.uniandes.Callys.catalogo.logic.converter.CatalogoConverter;
import co.edu.uniandes.Callys.catalogo.logic.entity.CatalogoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Default
@Stateless
@LocalBean
public class CatalogoLogic implements ICatalogoLogic {

    @PersistenceContext(unitName = "CatalogoClassPU")
    protected EntityManager entityManager;

    public CatalogoDTO createCatalogo(CatalogoDTO detail) {
        CatalogoEntity entity = CatalogoConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return CatalogoConverter.entity2PersistenceDTO(entity);
    }

    public List<CatalogoDTO> getCatalogo() {
        Query q = entityManager.createQuery("select u from CatalogoEntity u");
        return CatalogoConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public CatalogoPageDTO getCatalogo(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CatalogoEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CatalogoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CatalogoPageDTO response = new CatalogoPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(CatalogoConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public CatalogoDTO getCatalogo(Long id) {
        return CatalogoConverter.entity2PersistenceDTO(entityManager.find(CatalogoEntity.class, id));
    }

    public void deleteCatalogo(Long id) {
        CatalogoEntity entity = entityManager.find(CatalogoEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCatalogo(CatalogoDTO detail) {
        CatalogoEntity entity = entityManager.merge(CatalogoConverter.persistenceDTO2Entity(detail));
        CatalogoConverter.entity2PersistenceDTO(entity);
    }
}
