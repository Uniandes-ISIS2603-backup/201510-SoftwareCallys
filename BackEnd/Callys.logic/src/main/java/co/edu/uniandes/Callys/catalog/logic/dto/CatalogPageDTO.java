package co.edu.uniandes.Callys.catalog.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CatalogPageDTO{

    private Long totalRecords;

    private List<CatalogDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<CatalogDTO> getRecords() {
        return records;
    }

    public void setRecords(List<CatalogDTO> records) {
        this.records = records;
    }
}
