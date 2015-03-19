/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalog.logic.converter;

import co.edu.uniandes.Callys.catalog.logic.dto.CatalogDTO;
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogPageDTO;
import co.edu.uniandes.Callys.catalog.logic.entity.CatalogEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class CatalogConverter {
    
    public static CatalogDTO entity2PersistenceDTO(CatalogEntity entity) {
        if (entity != null) {
            CatalogDTO dto = new CatalogDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setNumElementos(entity.getNumeroElementos());
            dto.setStamps(entity.getStamps());
            return dto;
        } else {
            return null;
        }
    }

    public static CatalogEntity persistenceDTO2Entity(CatalogDTO dto) {
        if (dto != null) {
            CatalogEntity entity = new CatalogEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setNumeroElementos(dto.getNumElementos());
            entity.setStamps(dto.getStamps());
            return entity;
        } else {
            return null;
        }
    }

    public static List<CatalogDTO> entity2PersistenceDTOList(List<CatalogEntity> entities) {
        List<CatalogDTO> dtos = new ArrayList<CatalogDTO>();
        for (CatalogEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CatalogEntity> persistenceDTO2EntityList(List<CatalogDTO> dtos) {
        List<CatalogEntity> entities = new ArrayList<CatalogEntity>();
        for (CatalogDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
