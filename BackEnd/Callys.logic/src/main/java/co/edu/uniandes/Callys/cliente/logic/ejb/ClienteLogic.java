package co.edu.uniandes.Callys.cliente.logic.ejb;

import co.edu.uniandes.Callys.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.Callys.cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.Callys.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.Callys.cliente.logic.entity.ClienteEntity;
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
public class ClienteLogic implements IClienteLogic{
    
    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public ClienteDTO createCliente(ClienteDTO sport) {
        ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return ClienteConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<ClienteDTO> getClientes() {
        Query q = entityManager.createQuery("select u from SportEntity u");
        return ClienteConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
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

    @Override
    public void updateCliente(ClienteDTO cliente) {
        ClienteEntity entity = entityManager.merge(ClienteConverter.persistenceDTO2Entity(cliente));
        ClienteConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public ClienteDTO getCliente(long id) {
        return ClienteConverter.entity2PersistenceDTO(entityManager.find(ClienteEntity.class, id));
    }

    @Override
    public void deleteCliente(long id) {
        ClienteEntity entity = entityManager.find(ClienteEntity.class, id);
        entityManager.remove(entity);
    }
}
