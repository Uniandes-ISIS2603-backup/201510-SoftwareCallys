/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.camiseta.logic.dto;

import java.util.List;

/**
 *
 * @author estudiante
 */
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
