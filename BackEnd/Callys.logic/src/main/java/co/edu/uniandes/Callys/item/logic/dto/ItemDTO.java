package  co.edu.uniandes.Callys.item.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDTO {
    private Long id;
    private Long camiseta;
    private double monto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(Long camiseta) {
        this.camiseta = camiseta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}