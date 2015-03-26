package co.edu.uniandes.Callys.purchaseitem.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseItemDTO {
    
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
    
    public Long getIdPurchase(){
    	return idPurchase;
    }
    
    public void setIdPurchase(Long nIdPurchase){
    	this.idPurchase = nIdPurchase;
    }
}
