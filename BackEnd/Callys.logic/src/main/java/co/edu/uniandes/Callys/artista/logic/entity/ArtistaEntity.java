package co.edu.uniandes.Callys.artista.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ArtistaEntity{ 
    @Id
    @GeneratedValue(generator = "Artista")
    Long id;
    private String clave;
    private Integer numeroEstampas;
    private String datosContacto;
    private double comisionPorVenta;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    
    public double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta( double comisionPorVenta) {
        this.comisionPorVenta = comisionPorVenta;
    }
}