package co.edu.uniandes.callys.purchaseitem.logic.converter;

import co.edu.uniandes.callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.callys.purchaseitem.logic.entity.PurchaseItemEntity;
import java.util.ArrayList;
import java.util.List;

public class PurchaseItemConverter {
    
    public static PurchaseItemDTO entity2PersistenceDTO(PurchaseItemEntity entity) {
        if (entity != null) {
            PurchaseItemDTO dto = new PurchaseItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setMonto(entity.getMonto());
            dto.setIdCamiseta(entity.getIdCamiseta());
            dto.setIdPurchase(entity.getIdPurchase());
            return dto;
        } else {
            return null;
        }
    }

    public static PurchaseItemEntity persistenceDTO2Entity(PurchaseItemDTO dto) {
        if (dto != null) {
            PurchaseItemEntity entity = new PurchaseItemEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setMonto(dto.getMonto());
            entity.setIdCamiseta(dto.getIdCamiseta());
            entity.setIdPurchase(dto.getIdPurchase());
            return entity;
        } else {
            return null;
        }
    }

    public static List<PurchaseItemDTO> entity2PersistenceDTOList(List<PurchaseItemEntity> entities) {
        List<PurchaseItemDTO> dtos = new ArrayList<PurchaseItemDTO>();
        for (PurchaseItemEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<PurchaseItemEntity> persistenceDTO2EntityList(List<PurchaseItemDTO> dtos) {
        List<PurchaseItemEntity> entities = new ArrayList<PurchaseItemEntity>();
        for (PurchaseItemDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
