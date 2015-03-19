/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.artista.logic.api;


import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface IArtistaLogic {
    
    public ArtistaDTO createArtista(ArtistaDTO detail);

    public List<ArtistaDTO> getArtista();

    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords);

    public ArtistaDTO getArtista(long id);

    public void deleteArtista(long id);

    public void updateArtista(ArtistaDTO detail);
}
