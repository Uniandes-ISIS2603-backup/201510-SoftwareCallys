/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.carroCompras.logic.converter;


import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author estudiante
 */
public class CarroComprasConverter {
    
    public static CarroComprasDTO entity2PersistenceDTO(CarroComprasEntity entity) {
        if (entity != null) {
            CarroComprasDTO dto = new CarroComprasDTO();
            dto.setId(entity.getId());
            dto.setTema(entity.getTema());
            dto.setRating(entity.getRating());
            dto.setPopularidad(entity.getPopularidad());
            return dto;
        } else {
            return null;
        }
    }

    public static CarroComprasEntity persistenceDTO2Entity(CarroComprasDTO dto) {
        if (dto != null) {
            CarroComprasEntity entity = new CarroComprasEntity();
            entity.setId(dto.getId());

            entity.setTema(dto.getTema());

            entity.setRating(dto.getRating());

            entity.setPopularidad(dto.getPopularidad());

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
