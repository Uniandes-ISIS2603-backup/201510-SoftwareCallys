package co.edu.uniandes.callys.artista.logic.api;
import co.edu.uniandes.callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.callys.artista.logic.dto.ArtistaPageDTO;
import java.util.List;
public interface IArtistaLogic {
    
    public ArtistaDTO createArtista(ArtistaDTO detail);

    public List<ArtistaDTO> getArtista();

    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords);

    public ArtistaDTO getArtista(long id);

    public void deleteArtista(long id);

    public void updateArtista(ArtistaDTO detail);
}
