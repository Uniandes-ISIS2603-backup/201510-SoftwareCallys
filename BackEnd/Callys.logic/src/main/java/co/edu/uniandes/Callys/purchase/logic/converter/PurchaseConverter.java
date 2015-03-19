/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.purchase.logic.converter;

import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class PurchaseConverter {
    
    public static PurchaseDTO entity2PersistenceDTO(PurchaseEntity entity) {
        if (entity != null) {
            PurchaseDTO dto = new PurchaseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDate(entity.getDate());
            dto.setDatosDeEnvio(entity.getDatosDeEnvio());
            dto.setFormaDePago(entity.getFormaDePago());
            dto.setItemsC(entity.getItemsC());
            return dto;
        } else {
            return null;
        }
    }

    public static PurchaseEntity persistenceDTO2Entity(PurchaseDTO dto) {
        if (dto != null) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDate(dto.getDate());
            entity.setDatosDeEnvio(dto.getDatosDeEnvio());
            entity.setFormaDePago(dto.getFormaDePago());
            entity.setItemsC(dto.getItemsC());
            return entity;
        } else {
            return null;
        }
    }

    public static List<PurchaseDTO> entity2PersistenceDTOList(List<PurchaseEntity> entities) {
        List<PurchaseDTO> dtos = new ArrayList<PurchaseDTO>();
        for (PurchaseEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<PurchaseEntity> persistenceDTO2EntityList(List<PurchaseDTO> dtos) {
        List<PurchaseEntity> entities = new ArrayList<PurchaseEntity>();
        for (PurchaseDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
