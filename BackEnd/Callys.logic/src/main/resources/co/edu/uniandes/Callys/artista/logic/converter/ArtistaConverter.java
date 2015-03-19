/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.artista.logic.converter;

import java.software.logic.dto.ArtistaDTO;
import java.software.logic.entity.ArtistaEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author estudiante
 */
public class ArtistaConverter {
    
     public static ArtistaDTO entity2PersistenceDTO(ArtistaEntity entity) {
        if (entity != null) {
            ArtistaDTO dto = new ArtistaDTO();
            dto.setId(entity.getId());
            dto.setClave(entity.getClave());
            dto.setNumeroEstampas(entity.getNumeroEstampas());
            dto.setComisionPorVenta(entity.getComisionPorVenta());
            dto.setDatosVContacto(entity.getDAtosContacto());
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
            entity.setNumeroEstampas(dto.getNumeroEstampas());
            entity.setComisionPorVenta(dto.getComisionPorVenta());
            entity.setDatosVContacto(dto.getDAtosContacto());

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
