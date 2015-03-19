/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.software.logic.api;

import java.software.logic.dto.ArtistaDTO;
import java.software.logic.dto.ArtistaPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface IArtistaLogic {
    
    public ArtistaDTO createArtista(ArtistaDTO detail);

    public List<ArtistaDTO> getArtista();

    public ArtistaDTO getArtista(Integer page, Integer maxRecords);

    public ArtistaDTO getArtista(String id);

    public void deleteArtista(String id);

    public void updateArtista(ArtistaDTO detail);
}