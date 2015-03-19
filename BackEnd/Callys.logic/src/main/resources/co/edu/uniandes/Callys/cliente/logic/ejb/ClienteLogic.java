/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.Cliente.logic.ejb;

import co.edu.uniandes.Callys.Cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.Callys.Cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.Cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.Callys.Cliente.logic.entity.ClienteEntity;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.inject.Default;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ClienteLogic {
    
    @PersistenceContext(unitName = "ClienteClassPU")
    protected EntityManager entityManager;

    public ClienteDTO createCliente(ClienteDTO sport) {
        ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return ClienteConverter.entity2PersistenceDTO(entity);
    }

    public List<ClienteDTO> getClientes() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return ClienteConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public ClientePageDTO getClientes(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SportEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SportEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ClientePageDTO response = new ClientePageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ClienteConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public ClienteDTO getCliente(Long id) {
        return ClienteConverter.entity2PersistenceDTO(entityManager.find(ClienteEntity.class, id));
    }

    public void deleteCliente(Long id) {
        ClienteEntity entity = entityManager.find(ClienteEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCliente(ClienteDTO cliente) {
        ClienteEntity entity = entityManager.merge(ClienteConverter.persistenceDTO2Entity(cliente));
        ClienteConverter.entity2PersistenceDTO(entity);
    }
}
