package co.edu.uniandes.Callys.artista.logic.api;

import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import java.util.List;

public interface IArtistaLogic {
    
    public ArtistaDTO createArtista(ArtistaDTO detail);
    
    public List<ArtistaDTO> getArtistas();

    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords);

    public ArtistaDTO getArtista(long id);

    public void deleteArtista(long id);

    public void updateArtista(ArtistaDTO detail);
}
