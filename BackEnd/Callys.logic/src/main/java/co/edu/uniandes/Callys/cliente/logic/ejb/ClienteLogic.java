package co.edu.uniandes.Callys.cliente.logic.ejb;

import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.uniandes.Callys.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.Callys.cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.Callys.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.Callys.cliente.logic.entity.ClienteEntity;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ClienteLogic implements IClienteLogic{

    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public ClienteDTO createCliente(ClienteDTO cliente) {
        if(!findByName(cliente.getNombre())){
            ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(cliente);
            CarroComprasEntity carroCompras = this.getSelectedShoppingCart(cliente);
            if (carroCompras != null) {
                entity.setCarroCompras(carroCompras);
            }
            entity.setPurchases(new ArrayList<PurchaseEntity>());
            entityManager.persist(entity);
            return ClienteConverter.entity2PersistenceDTO(entity);
        }else{
            return null;
        }
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
        CarroComprasEntity carroCompras = this.getSelectedShoppingCart(cliente);
        if (carroCompras != null) {
            entity.setCarroCompras(carroCompras);
        }
        List<PurchaseEntity> purchases=this.getSelectedPurchases(cliente);
        entity.setPurchases(purchases);
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
    
    private CarroComprasEntity getSelectedShoppingCart(ClienteDTO cliente) {
        if (cliente != null && cliente.getCarroCompras() != null) {
            return entityManager.find(CarroComprasEntity.class, cliente.getCarroCompras());
        }else{
            return null;
        }
    }
    
    private List<PurchaseEntity> getSelectedPurchases(ClienteDTO cliente) {
        if(cliente != null && cliente.getPurchases() != null) {
            List<PurchaseEntity> purchases = new ArrayList<PurchaseEntity>();
            for (Long purchase : cliente.getPurchases()) {
                purchases.add(entityManager.find(PurchaseEntity.class, purchase));
            }
            return purchases;
        }
        else {
            return null;
        }
    }
    
    /*
        Return true si el cliente existe false de lo contrario
    */
    private boolean findByName(String nombre){
        List result = entityManager.createQuery(
                "SELECT u FROM ClienteEntity u WHERE c.name LIKE :clientName")
                .setParameter("clientName", nombre)
                .setMaxResults(10)
                .getResultList();
        return !result.isEmpty( );
    }
}
