package co.edu.uniandes.Callys.purchaseitem.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PurchaseItemEntity {
    
    @Id
    @GeneratedValue(generator = "PurchaseItem")
    private Long id;
    private String name;
    private int monto;
    private Long idCamiseta;
    private Long idPurchase;
    
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

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    public Long getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(Long idCamiseta) {
        this.idCamiseta = idCamiseta;
    }
    
    public Long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }
}