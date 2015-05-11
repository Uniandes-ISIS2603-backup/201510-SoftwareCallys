package co.edu.uniandes.Callys.purchase.logic.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.Callys.purchaseitem.logic.entity.PurchaseItemEntity;
import java.util.List;

@XmlRootElement
public class PurchaseDTO {
    private Long id;
    private Date fecha;
    private String datosDeEnvio;
    private String formaDePago;
    private List<PurchaseItemEntity> purchaseItems;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return fecha;
    }

    public void setDate(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getDatosDeEnvio() {
        return datosDeEnvio;
    }

    public void setDatosDeEnvio(String nDDE) {
        this.datosDeEnvio = nDDE;
    }
    
    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String nFDP ) {
        this.formaDePago = nFDP;
    }
    
    public List<PurchaseItemEntity> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItemEntity> purchaseItems ) {
        this.purchaseItems = purchaseItems;
    }
}