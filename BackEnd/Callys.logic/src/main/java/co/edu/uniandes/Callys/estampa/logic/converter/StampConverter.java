package co.edu.uniandes.Callys.estampa.logic.converter;

import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import java.util.ArrayList;
import java.util.List;

public class StampConverter {
 public static StampDTO entity2PersistenceDTO(StampEntity entity) {
        if (entity != null) {
            StampDTO dto = new StampDTO();
            dto.setId(entity.getId());
            dto.setTopic(entity.getTopic());
            dto.setName(entity.getName());
            dto.setRating(entity.getRating());
            dto.setIdArtista(entity.getIdArtista());
            dto.setPrice(entity.getPrice());
            return dto;
        } else {
            return null;
        }
    }

    public static StampEntity persistenceDTO2Entity(StampDTO dto) {
        if (dto != null) {
            StampEntity entity = new StampEntity();
            entity.setId(dto.getId());
            entity.setTopic(dto.getTopic());
            entity.setName(dto.getName());
            entity.setRating(dto.getRating());
            entity.setIdArtista(dto.getIdArtista());
            entity.setPrice(dto.getPrice());
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