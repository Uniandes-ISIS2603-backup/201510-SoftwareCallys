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
public class PurchaseItemDTO {
    
    private Long id;
    private String name;
    private int monto;
    private Long idCamiseta;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer nMonto) {
        this.monto = nMonto;
    }
    
    public Long getIdCamiseta(){
    	return idCamiseta;
    }
    
    public void setIdCamiseta(Long nIdCamiseta){
    	this.idCamiseta = nIdCamiseta;
    }
}
