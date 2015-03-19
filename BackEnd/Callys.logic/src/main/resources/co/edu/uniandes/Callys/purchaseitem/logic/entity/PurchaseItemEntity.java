/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.purchaseitem.logic.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
@Entity
public class PurchaseItemEntity {
    
    @Id
    @GeneratedValue(generator = "Purchase")
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
    
    public int getMonto() {
        return monto;
    }

    public void setMonto(int nDDE ) {
        this.monto = nDDE;
    }
    
    public Long getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(Long nFDP ) {
        this.idCamiseta = nFDP;
    }
}
