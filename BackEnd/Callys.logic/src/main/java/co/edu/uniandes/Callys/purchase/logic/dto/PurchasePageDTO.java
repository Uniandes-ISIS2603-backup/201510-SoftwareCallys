package co.edu.uniandes.Callys.purchase.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchasePageDTO {
    
    private Long totalRecords;

    private List<PurchaseDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<PurchaseDTO> getRecords() {
        return records;
    }

    public void setRecords(List<PurchaseDTO> records) {
        this.records = records;
    }
}
