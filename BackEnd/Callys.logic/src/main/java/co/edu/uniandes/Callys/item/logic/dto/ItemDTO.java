package  co.edu.uniandes.Callys.item.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDTO {
    private Long id;
    private Long camiseta;
    private Long carroCompras;
    private Double monto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCamiseta() {
        return camiseta;
    }

    public void setIdCamiseta(Long camiseta) {
        this.camiseta = camiseta;
    }

    public Long getIdCarritoC() {
        return carroCompras;
    }

    public void setIdCarritoC(Long carroCompras) {
        this.carroCompras = carroCompras;
    }
    
    public Long getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(Long camiseta) {
        this.camiseta = camiseta;
    }

    public Long getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(Long carroCompras) {
        this.carroCompras = carroCompras;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}