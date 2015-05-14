package co.edu.uniandes.Callys.carroCompras.logic.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.persistence.CascadeType;

@XmlRootElement
public class CarroComprasDTO {
    @Id
    @GeneratedValue(generator = "CarroCompras")
    private Long id;
    private Double monto;
    private String formaPago;
    private String datosEnvio;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Long> items;
    
    public List<Long> getItems()
    {
       return items; 
    }
    
    public void setItems(List<Long> items) {
        this.items = items;
    }
     
//    public void addItem(ItemEntity item) {
//        if (!getItems().contains(item)) {
//            items.add(item);
//        }
//    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(String datosEnvio) {
        this.datosEnvio = datosEnvio;
    }   
}