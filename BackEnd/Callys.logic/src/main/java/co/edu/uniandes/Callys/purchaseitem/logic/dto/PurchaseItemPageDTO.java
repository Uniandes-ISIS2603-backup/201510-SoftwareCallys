package co.edu.uniandes.callys.purchaseitem.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseItemPageDTO {
    
    private Long totalRecords;

    private List<PurchaseItemDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<PurchaseItemDTO> getRecords() {
        return records;
    }

    public void setRecords(List<PurchaseItemDTO> records) {
        this.records = records;
    }
}
