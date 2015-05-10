package  co.edu.uniandes.Callys.item.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDTO {
    private Long id;
    private Long camiseta;
    private Double monto;

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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}