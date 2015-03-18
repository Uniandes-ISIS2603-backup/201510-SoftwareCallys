/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalogo.logic.dto;

/**
 *
 * @author estudiante
 */
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CatalogoPageDTO{

    private Long totalRecords;

    private List<CatalogoDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<CatalogoDTO> getRecords() {
        return records;
    }

    public void setRecords(List<CatalogoDTO> records) {
        this.records = records;
    }
}
