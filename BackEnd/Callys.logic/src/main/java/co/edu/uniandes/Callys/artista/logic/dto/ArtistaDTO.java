package co.edu.uniandes.Callys.artista.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArtistaDTO {
    private Long id;
    private String clave;
    private Integer numeroEstampas;
    private String datosContacto;
    private Double comisionPorVenta;
    private List<Long> stamps;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        this.numeroEstampas = numeroEstampas;
    }

    public String getDatosContacto() {
        return datosContacto;
    }

    public void setDatosContacto(String datosContacto) {
        this.datosContacto = datosContacto;
    }
    
    public Double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta(Double comisionPorVenta) {
        this.comisionPorVenta = comisionPorVenta;
    }
    
    public List<Long> getStamps() {
        return stamps;
    }
    
    public void setStamps(List<Long> stamps) {
        this.stamps=stamps;
    }
}
