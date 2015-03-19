/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.software.logic.converter;

import java.software.logic.dto.StampDTO;
import java.software.llogic.entity.StampEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author estudiante
 */
public class StampConverter {
 public static StampDTO entity2PersistenceDTO(StampEntity entity) {
        if (entity != null) {
            StampDTO dto = new StampDTO();
            dto.setId(entity.getId());
            dto.setTema(entity.getTema());
            dto.setRating(entity.getRating());
            dto.setPopularidad(entity.getPopularidad());
            return dto;
        } else {
            return null;
        }
    }

    public static StampEntity persistenceDTO2Entity(StampDTO dto) {
        if (dto != null) {
            StampEntity entity = new StampEntity();
            entity.setId(dto.getId());

            entity.setTema(dto.getTema());

            entity.setRating(dto.getRating());

            entity.setPopularidad(dto.getPopularidad());

            return entity;
        } else {
            return null;
        }
    }

    public static List<StampDTO> entity2PersistenceDTOList(List<StampEntity> entities) {
        List<StampDTO> dtos = new ArrayList<StampDTO>();
        for (StampEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<StampEntity> persistenceDTO2EntityList(List<StampDTO> dtos) {
        List<StampEntity> entities = new ArrayList<StampEntity>();
        for (StampDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }   
}
