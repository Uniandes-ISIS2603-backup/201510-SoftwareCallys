package co.edu.uniandes.callys.artista.logic.api;

import co.edu.uniandes.callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.callys.artista.logic.dto.ArtistaPageDTO;
import java.util.List;

public interface IArtistaLogic {
    
    public ArtistaDTO createArtista(ArtistaDTO detail);
    
    public List<ArtistaDTO> getArtistas();

    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords);

    public ArtistaDTO getArtista(Long id);

    public void deleteArtista(Long id);

    public void updateArtista(ArtistaDTO detail);
}
