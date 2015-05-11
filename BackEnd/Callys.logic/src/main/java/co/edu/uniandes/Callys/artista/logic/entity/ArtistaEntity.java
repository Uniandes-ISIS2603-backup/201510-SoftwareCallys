package co.edu.uniandes.Callys.artista.logic.entity;

import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ArtistaEntity{ 
    @Id
    @GeneratedValue(generator = "Artista")
    private Long id;
    private String clave;
    private Integer numeroEstampas;
    private String datosContacto;
    private Double comisionPorVenta;
    @OneToMany
    private List<StampEntity> stamps;
    
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
}