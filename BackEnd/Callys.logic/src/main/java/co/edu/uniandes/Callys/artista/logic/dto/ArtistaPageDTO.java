package co.edu.uniandes.Callys.artista.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArtistaPageDTO {
    
    private Long totalRecords;

    private List<ArtistaDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<ArtistaDTO> getRecords() {
        return records;
    }

    public void setRecords(List<ArtistaDTO> records) {
        this.records = records;
    }
}
