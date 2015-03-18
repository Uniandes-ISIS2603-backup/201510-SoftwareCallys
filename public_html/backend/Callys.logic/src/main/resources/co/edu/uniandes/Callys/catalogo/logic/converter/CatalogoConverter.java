/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalogo.logic.converter;

import co.edu.uniandes.Callys.catalogo.logic.dto.CatalogoDTO;
import co.edu.uniandes.Callys.catalogo.logic.dto.CatalogoPageDTO;
import co.edu.uniandes.Callys.catalogo.logic.entity.CatalogoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class CatalogoConverter {
    
    public static CatalogoDTO entity2PersistenceDTO(CatalogoEntity entity) {
        if (entity != null) {
            CatalogoDTO dto = new CatalogoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setNumElementos(entity.getNumeroElementos());
            return dto;
        } else {
            return null;
        }
    }

    public static CatalogoEntity persistenceDTO2Entity(CatalogoDTO dto) {
        if (dto != null) {
            CatalogoEntity entity = new CatalogoEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setNumeroElementos(dto.getNumElementos());
            return entity;
        } else {
            return null;
        }
    }

    public static List<CatalogoDTO> entity2PersistenceDTOList(List<CatalogoEntity> entities) {
        List<CatalogoDTO> dtos = new ArrayList<CatalogoDTO>();
        for (CatalogoEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CatalogoEntity> persistenceDTO2EntityList(List<CatalogoDTO> dtos) {
        List<CatalogoEntity> entities = new ArrayList<CatalogoEntity>();
        for (CatalogoDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
