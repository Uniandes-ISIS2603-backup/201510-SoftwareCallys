/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.Cliente.logic.dto;

import java.util.List;

/**
 *
 * @author estudiante
 */
public class ClientePageDTO {
    
    private Long totalRecords;

    private List<ClienteDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<ClienteDTO> getRecords() {
        return records;
    }

    public void setRecords(List<ClienteDTO> records) {
        this.records = records;
    }
}
