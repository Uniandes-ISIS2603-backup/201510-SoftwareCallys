package co.edu.uniandes.Callys.item.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemPageDTO {
    private Long totalRecords;

    private List<ItemDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<ItemDTO> getRecords() {
        return records;
    }

    public void setRecords(List<ItemDTO> records) {
        this.records = records;
    }
}
