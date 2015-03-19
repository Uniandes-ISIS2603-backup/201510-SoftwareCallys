/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.purchaseitem.logic.dto;

import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class PurchaseItemPageDTO {
    
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
