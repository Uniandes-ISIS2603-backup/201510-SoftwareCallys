package co.edu.uniandes.Callys.item.logic.converter;

import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;

public class ItemConverter {
    public static ItemDTO entity2PersistenceDTO(ItemEntity entity) {
        if (entity != null) {
            ItemDTO dto = new ItemDTO();
            dto.setId(entity.getId());
            dto.setMonto(entity.getMonto());
            if (entity.getCamiseta()!= null) {
                dto.setCamiseta(entity.getCamiseta().getId());
            }
            return dto;
        } else {
            return null;
        }
    }

    public static ItemEntity persistenceDTO2Entity(ItemDTO dto) {
        if (dto != null) {
            ItemEntity entity = new ItemEntity();
            entity.setId(dto.getId());
            entity.setMonto(dto.getMonto());
            return entity;
        } else {
            return null;
        }
    }

    public static List<ItemDTO> entity2PersistenceDTOList(List<ItemEntity> entities) {
        List<ItemDTO> dtos = new ArrayList<ItemDTO>();
        for (ItemEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<ItemEntity> persistenceDTO2EntityList(List<ItemDTO> dtos) {
        List<ItemEntity> entities = new ArrayList<ItemEntity>();
        for (ItemDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    } 
}
