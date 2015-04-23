package co.edu.uniandes.callys.estampa.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StampPageDTO {
   
    private Long totalRecords;

    private List<StampDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<StampDTO> getRecords() {
        return records;
    }

    public void setRecords(List<StampDTO> records) {
        this.records = records;
    }
}
