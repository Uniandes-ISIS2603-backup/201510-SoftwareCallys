package co.edu.uniandes.callys.artista.logic.dto;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ArtistaDTO {
    
     private long id;

    private String clave ;

    private Integer numeroEstampas;

    private String datosContacto;
    
    private double comisionPorVenta;
    
    public long getId() {
        return id;
    }

    public void setId( long id) {
        this.id = id;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getNumeroEstampas() {
        return numeroEstampas;
    }

    public void setNumeroEstampas(Integer numeroEstampas) {
        this.numeroEstampas =numeroEstampas;
    }

    public String getDAtosContacto() {
        return datosContacto;
    }

    public void setDatosVContacto(String datosContacto) {
        this.datosContacto= datosContacto;
    }
    
    public double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta( double comisionPorVenta) {
        this.comisionPorVenta= comisionPorVenta;
    }

}
