package co.edu.uniandes.Callys.purchaseitem.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PurchaseItemEntity {
    @Id
    @GeneratedValue(generator = "PurchaseItem")
    private Long id;
    private Double monto;
    private Long idCamiseta;
    private Long idPurchase;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPurchase() {
        return idPurchase;
    }
    
    public void setIdPurchase(Long idPurchase) {
        this.idPurchase=idPurchase;
    }
    
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public Long getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(Long idCamiseta) {
        this.idCamiseta = idCamiseta;
    }
}