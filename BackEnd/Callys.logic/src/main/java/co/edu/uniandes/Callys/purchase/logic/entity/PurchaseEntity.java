package co.edu.uniandes.Callys.purchase.logic.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import co.edu.uniandes.Callys.purchaseitem.logic.entity.PurchaseItemEntity;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
public class PurchaseEntity {
    @Id
    @GeneratedValue(generator = "Purchase")
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String datosDeEnvio;
    private String formaDePago;
    @OneToMany
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

    public void setDatosDeEnvio(String nDDE ) {
        this.datosDeEnvio = nDDE;
    }
    
    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String nFDP ) {
        this.formaDePago = nFDP;
    }
    
    public void setPurchaseItems(List<PurchaseItemEntity> purchaseItems){
        this.purchaseItems = purchaseItems;
    }
    
    public List<PurchaseItemEntity> getPurchaseItems(){
        return purchaseItems;
    }
}