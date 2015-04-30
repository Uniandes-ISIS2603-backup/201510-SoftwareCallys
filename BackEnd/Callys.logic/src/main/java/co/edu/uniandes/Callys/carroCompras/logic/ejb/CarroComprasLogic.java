package co.edu.uniandes.Callys.carroCompras.logic.ejb;

import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.Callys.carroCompras.logic.converter.CarroComprasConverter;
import co.edu.uniandes.Callys.carroCompras.logic.api.ICarroComprasLogic;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasPageDTO;
import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
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
public class CarroComprasLogic implements ICarroComprasLogic{
       
    @PersistenceContext(unitName ="CallysClassPU")
    protected EntityManager entityManager;

    @Override
    public CarroComprasDTO createCarroCompras(CarroComprasDTO sport) {
        CarroComprasEntity entity = CarroComprasConverter.persistenceDTO2Entity(sport);
        entityManager.persist(entity);
        return CarroComprasConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<CarroComprasDTO> getCarrosCompras() {
        Query q = entityManager.createQuery("select u from CarroComprasEntity u");
        return CarroComprasConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public CarroComprasPageDTO getCarrosCompras(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CarroComprasEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CarroComprasEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CarroComprasPageDTO response = new CarroComprasPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(CarroComprasConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    @Override
    public CarroComprasDTO getCarroCompras(Long id) {
        return CarroComprasConverter.entity2PersistenceDTO(entityManager.find(CarroComprasEntity.class, id));
    }

    @Override
    public void deleteCarroCompras(Long id) {
        CarroComprasEntity entity = entityManager.find(CarroComprasEntity.class, id);
        entityManager.remove(entity);
    }

    @Override
    public void updateCarroCompras(CarroComprasDTO carroCompras) {
        CarroComprasEntity entity = entityManager.merge(CarroComprasConverter.persistenceDTO2Entity(carroCompras));
        CarroComprasConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}