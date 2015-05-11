package co.edu.uniandes.Callys.camiseta.logic.converter;

import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import java.util.ArrayList;
import java.util.List;

public class CamisetaConverter {
    
    public static CamisetaDTO entity2PersistenceDTO(CamisetaEntity entity) {
        if (entity != null) {
            CamisetaDTO dto = new CamisetaDTO();
            dto.setId(entity.getId());
            dto.setColor(entity.getColor());
            dto.setTalla(entity.getTalla());
            dto.setMaterial(entity.getMaterial());
            dto.setTexto(entity.getTexto());
            if (entity.getStamps()!=null) {
                List<Long> stamps=new ArrayList<Long>();
                for(int i=0;i<entity.getStamps().size();i++) {
                    stamps.add(entity.getStamps().get(i).getId());
                }
                dto.setStamps(stamps);
            }
            return dto;
        } else {
            return null;
        }
    }

    public static CamisetaEntity persistenceDTO2Entity(CamisetaDTO dto) {
        if (dto != null) {
            CamisetaEntity entity = new CamisetaEntity();
            entity.setId(dto.getId());
            entity.setColor(dto.getColor());
            entity.setTalla(dto.getTalla());
            entity.setMaterial(dto.getMaterial());
            entity.setTexto(dto.getTexto());
            return entity;
        } else {
            return null;
        }
    }

    public static List<CamisetaDTO> entity2PersistenceDTOList(List<CamisetaEntity> entities) {
        List<CamisetaDTO> dtos = new ArrayList<CamisetaDTO>();
        for (CamisetaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CamisetaEntity> persistenceDTO2EntityList(List<CamisetaDTO> dtos) {
        List<CamisetaEntity> entities = new ArrayList<CamisetaEntity>();
        for (CamisetaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }   
}
