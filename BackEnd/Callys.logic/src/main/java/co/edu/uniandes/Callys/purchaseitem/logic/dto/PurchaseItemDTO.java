package co.edu.uniandes.Callys.purchaseitem.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseItemDTO {
    private Long id;
    private Integer monto;
    private Long idCamiseta;
    private Long idPurchase;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
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