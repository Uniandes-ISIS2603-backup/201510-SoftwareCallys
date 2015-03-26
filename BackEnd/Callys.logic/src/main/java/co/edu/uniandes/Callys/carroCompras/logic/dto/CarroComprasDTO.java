package co.edu.uniandes.callys.carroCompras.logic.dto;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class CarroComprasDTO {
     private Long id;

    private double monto;

    private String formaPago;

    private String datosEnvio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(String formaPago)
    {
        this.formaPago = formaPago;
    }

    public void setDatosEnvio(String datosEnvio) {
        this.datosEnvio = datosEnvio;
    }

    public String getDatosEnvio() {
        return datosEnvio;
    }

   
}
