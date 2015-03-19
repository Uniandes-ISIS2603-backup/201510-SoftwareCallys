/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.item.logic.converter;
import java.software.logic.dto.ItemDTO;
import java.software.logic.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author estudiante
 */
public class ItemConverter {
    public static ItemDTO entity2PersistenceDTO(ItemEntity entity) {
        if (entity != null) {
            ItemDTO dto = new ItemDTO();
            dto.setId(entity.getId());
            dto.setTema(entity.getTema());
            dto.setRating(entity.getRating());
            dto.setPopularidad(entity.getPopularidad());
            return dto;
        } else {
            return null;
        }
    }

    public static ItemEntity persistenceDTO2Entity(ItemDTO dto) {
        if (dto != null) {
            ItemEntity entity = new ItemEntity();
            entity.setId(dto.getId());

            entity.setTema(dto.getTema());

            entity.setRating(dto.getRating());

            entity.setPopularidad(dto.getPopularidad());

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
