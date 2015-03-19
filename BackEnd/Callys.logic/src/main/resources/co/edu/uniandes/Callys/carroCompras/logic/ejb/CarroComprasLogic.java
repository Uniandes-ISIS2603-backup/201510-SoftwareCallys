/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.carroCompras.logic.ejb;

import java.software.logic.converter.CarroComprasConverter;
import java.software.logic.dto.CarroComprasDTO;
import java.software.logic.dto.CarroComprasPageDTO;
import java.software.logic.entity.CarroComprasEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
public class CarroComprasLogic {
       
    @PersistenceContext(unitName = "CarroComprasClassPU")
    protected EntityManager entityManager;

    public CarroComprasDTO createCarroCompras(CarroComprasDTO sport) {
        CarroComprasEntity entity = CarroComprasConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return CarroComprasConverter.entity2PersistenceDTO(entity);
    }

    public List<CarroComprasDTO> getCarroCompras() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return CarroComprasConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public CarroComprasPageDTO getCarroCompras(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SportEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SportEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CarroComprasPageDTO response = new CarroComprasPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(CarroComprasConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public CarroComprasDTO getCarroCompras(Long id) {
        return CarroComprasConverter.entity2PersistenceDTO(entityManager.find(CarroComprasEntity.class, id));
    }

    public void deleteCarroCompras(Long id) {
        CarroComprasEntity entity = entityManager.find(CarroComprasEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCarroCompras(CarroComprasDTO carroCompras) {
        CarroComprasEntity entity = entityManager.merge(CarroComprasConverter.persistenceDTO2Entity(carroCompras));
        CarroComprasConverter.entity2PersistenceDTO(entity);
    }
}
