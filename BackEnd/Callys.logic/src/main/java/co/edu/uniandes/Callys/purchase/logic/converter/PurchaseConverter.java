package co.edu.uniandes.Callys.purchase.logic.converter;

import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
import co.edu.uniandes.Callys.purchaseitem.logic.entity.PurchaseItemEntity;
import java.util.ArrayList;
import java.util.List;

public class PurchaseConverter {
    
    public static PurchaseDTO entity2PersistenceDTO(PurchaseEntity entity) {
        if (entity != null) {
            PurchaseDTO dto = new PurchaseDTO();
            dto.setId(entity.getId());
            dto.setIdCliente(entity.getIdCliente());
            dto.setDate(entity.getDate());
            dto.setDatosDeEnvio(entity.getDatosDeEnvio());
            dto.setFormaDePago(entity.getFormaDePago());
            if(entity.getPurchaseItems() != null){
                List<Long> purchaseItems = new ArrayList<Long>();
                for(PurchaseItemEntity e : entity.getPurchaseItems()){
                    purchaseItems.add(e.getId());
                }
                dto.setPurchaseItems(purchaseItems);
            }
            return dto;
        } else {
            return null;
        }
    }

    public static PurchaseEntity persistenceDTO2Entity(PurchaseDTO dto) {
        if (dto != null) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setId(dto.getId());
             entity.setIdCliente(dto.getIdCliente());
            entity.setDate(dto.getDate());
            entity.setDatosDeEnvio(dto.getDatosDeEnvio());
            entity.setFormaDePago(dto.getFormaDePago());
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