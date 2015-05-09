package co.edu.uniandes.Callys.cliente.logic.ejb;

import co.edu.uniandes.Callys.carroCompras.logic.converter.CarroComprasConverter;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
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
    public ClienteDTO createCliente(ClienteDTO cliente) {
        ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(cliente);
        CarroComprasEntity carroCompras = this.getSelectedShoppingCart(cliente);
        if (carroCompras != null) {
            entity.setCarroCompras(carroCompras);
        }
        entityManager.persist(entity);
        return ClienteConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<ClienteDTO> getClientes() {
        Query q = entityManager.createQuery("select u from ClienteEntity u");
        return ClienteConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public ClientePageDTO getClientes(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from ClienteEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from ClienteEntity u");
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
    public ClienteDTO getCliente(Long id) {
        return ClienteConverter.entity2PersistenceDTO(entityManager.find(ClienteEntity.class, id));
    }

    @Override
    public void deleteCliente(Long id) {
        ClienteEntity entity = entityManager.find(ClienteEntity.class, id);
        entityManager.remove(entity);
    }
    
    private CarroComprasEntity getSelectedShoppingCart(ClienteDTO cliente){
        if (cliente != null && cliente.getCarroComprasId() != null) {
            return entityManager.find(CarroComprasEntity.class, cliente.getCarroComprasId());
        }else{
            return null;
        }
    }
    
    @Override
    public CarroComprasDTO getCarroComprasClient(ClienteDTO cliente) {
        System.out.println("Llega al método");
        if (cliente != null && cliente.getCarroComprasId() != null) {
            System.out.println("Llega al if");
            return CarroComprasConverter.entity2PersistenceDTO(entityManager.find(CarroComprasEntity.class, cliente.getCarroComprasId()));
        }else{
            return null;
        }
    }
    
    @Override
    public Integer loginCliente(String nombre, String password) {
        Query q;
        q = entityManager.createQuery("Select u from ClienteEntity u where u.name = '"+nombre+"';");
        ClienteDTO dto = ClienteConverter.entity2PersistenceDTO(entityManager.find(ClienteEntity.class, q.getSingleResult()));
        return (dto.getPassword().equals(password))?1:0;
    }
}
