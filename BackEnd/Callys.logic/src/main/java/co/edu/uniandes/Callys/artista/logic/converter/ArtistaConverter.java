package co.edu.uniandes.Callys.artista.logic.converter;

import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
import java.util.ArrayList;
import java.util.List;

public class ArtistaConverter {
    
     public static ArtistaDTO entity2PersistenceDTO(ArtistaEntity entity) {
        if (entity != null) {
            ArtistaDTO dto = new ArtistaDTO();
            dto.setId(entity.getId());
            dto.setClave(entity.getClave());
            dto.setName(entity.getName());
            dto.setUsername(entity.getUsername());
            dto.setComisionPorVenta(entity.getComisionPorVenta());
            dto.setDatosContacto(entity.getDatosContacto());
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

    public static ArtistaEntity persistenceDTO2Entity(ArtistaDTO dto) {
        if (dto != null) {
            ArtistaEntity entity = new ArtistaEntity();
            entity.setId(dto.getId());
            entity.setClave(dto.getClave());
            entity.setName(dto.getName());
            entity.setUsername(dto.getUsername());
            entity.setComisionPorVenta(dto.getComisionPorVenta());
            entity.setDatosContacto(dto.getDatosContacto());
            return entity;
        } else {
            return null;
        }
    }

    public static List<ArtistaDTO> entity2PersistenceDTOList(List<ArtistaEntity> entities) {
        List<ArtistaDTO> dtos = new ArrayList<ArtistaDTO>();
        for (ArtistaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<ArtistaEntity> persistenceDTO2EntityList(List<ArtistaDTO> dtos) {
        List<ArtistaEntity> entities = new ArrayList<ArtistaEntity>();
        for (ArtistaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
