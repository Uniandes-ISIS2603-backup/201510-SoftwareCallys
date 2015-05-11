package co.edu.uniandes.Callys.estampa.logic.converter;

import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;

public class StampConverter {
 public static StampDTO entity2PersistenceDTO(ItemEntity entity) {
        if (entity != null) {
            StampDTO dto = new StampDTO();
            dto.setId(entity.getId());
            dto.setTopic(entity.getTopic());
            dto.setName(entity.getName());
            dto.setRating(entity.getRating());
            dto.setImage(entity.getImage());
            dto.setPrice(entity.getPrice());
            if (entity.getArtist()!= null) {
                dto.setArtist(entity.getArtist().getId());
            }  
            return dto;
        } else {
            return null;
        }
    }

    public static ItemEntity persistenceDTO2Entity(StampDTO dto) {
        if (dto != null) {
            ItemEntity entity = new ItemEntity();
            entity.setId(dto.getId());
            entity.setTopic(dto.getTopic());
            entity.setName(dto.getName());
            entity.setRating(dto.getRating());
            entity.setImage(dto.getImage());
            entity.setPrice(dto.getPrice());
            return entity;
        } else {
            return null;
        }
    }

    public static List<StampDTO> entity2PersistenceDTOList(List<ItemEntity> entities) {
        List<StampDTO> dtos = new ArrayList<StampDTO>();
        for (ItemEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<ItemEntity> persistenceDTO2EntityList(List<StampDTO> dtos) {
        List<ItemEntity> entities = new ArrayList<ItemEntity>();
        for (StampDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }   
}