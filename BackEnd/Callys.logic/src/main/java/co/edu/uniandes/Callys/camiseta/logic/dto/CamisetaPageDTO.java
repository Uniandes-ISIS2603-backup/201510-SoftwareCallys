package co.edu.uniandes.callys.camiseta.logic.dto;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class CamisetaPageDTO {
    private Long totalRecords;

    private List<CamisetaDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<CamisetaDTO> getRecords() {
        return records;
    }

    public void setRecords(List<CamisetaDTO> records) {
        this.records = records;
    }
}
