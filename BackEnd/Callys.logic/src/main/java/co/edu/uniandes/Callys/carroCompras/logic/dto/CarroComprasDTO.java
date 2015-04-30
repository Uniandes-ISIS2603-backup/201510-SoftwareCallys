package co.edu.uniandes.Callys.carroCompras.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarroComprasDTO {
    private Long id;
    private Double monto;
    private String formaPago;
    private String datosEnvio;

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