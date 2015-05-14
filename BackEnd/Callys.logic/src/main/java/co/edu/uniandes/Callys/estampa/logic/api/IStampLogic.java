package co.edu.uniandes.Callys.estampa.logic.api;


import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.dto.StampPageDTO;
import java.util.List;

public interface IStampLogic {
     
    public StampDTO createStamp(StampDTO detail);

    public List<StampDTO> getStamps();

    public StampPageDTO getStamps(Integer page, Integer maxRecords);

    public StampDTO getStamp(Long id);

    public void deleteStamp(Long id);

    public void updateStamp(StampDTO detail);
    
    public List<StampDTO> getStampsByArtist(Long idArtist);
    
    public StampDTO getStampWithBestRating();
    
    public List<StampDTO> getStampsByPrice(Integer minPrice, Integer maxPrice);
    
    public List<StampDTO> getStampsByTopic(String topic);
}
