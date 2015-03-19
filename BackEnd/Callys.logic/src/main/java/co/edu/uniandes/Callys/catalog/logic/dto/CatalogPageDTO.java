/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalog.logic.dto;

/**
 *
 * @author estudiante
 */
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
