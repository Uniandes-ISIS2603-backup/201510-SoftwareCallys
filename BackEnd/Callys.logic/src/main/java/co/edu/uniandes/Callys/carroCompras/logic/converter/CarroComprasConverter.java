package co.edu.uniandes.callys.carroCompras.logic.converter;

import co.edu.uniandes.callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.callys.carroCompras.logic.entity.CarroComprasEntity;
import java.util.ArrayList;
import java.util.List;

public class CarroComprasConverter {
    
    public static CarroComprasDTO entity2PersistenceDTO(CarroComprasEntity entity) {
        if (entity != null) {
            CarroComprasDTO dto = new CarroComprasDTO();
            dto.setId(entity.getId());
            dto.setMonto(entity.getMonto());
            dto.setFormaPago(entity.getFormaPago());
            dto.setDatosEnvio(entity.getDatosEnvio());
            return dto;
        } else {
            return null;
        }
    }

    public static CarroComprasEntity persistenceDTO2Entity(CarroComprasDTO dto) {
        if (dto != null) {
            CarroComprasEntity entity = new CarroComprasEntity();
            entity.setId(dto.getId());
            entity.setMonto(dto.getMonto());
            entity.setFormaPago(dto.getFormaPago());
            entity.setDatosEnvio(dto.getDatosEnvio());
            return entity;
        } else {
            return null;
        }
    }

    public static List<CarroComprasDTO> entity2PersistenceDTOList(List<CarroComprasEntity> entities) {
        List<CarroComprasDTO> dtos = new ArrayList<CarroComprasDTO>();
        for (CarroComprasEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CarroComprasEntity> persistenceDTO2EntityList(List<CarroComprasDTO> dtos) {
        List<CarroComprasEntity> entities = new ArrayList<CarroComprasEntity>();
        for (CarroComprasDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }   
}
