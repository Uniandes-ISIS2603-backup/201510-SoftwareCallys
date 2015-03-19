/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.software.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author estudiante
 */
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
