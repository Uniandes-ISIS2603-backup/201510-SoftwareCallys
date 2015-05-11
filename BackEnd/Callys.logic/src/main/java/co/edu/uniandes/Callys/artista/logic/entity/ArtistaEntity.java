package co.edu.uniandes.Callys.artista.logic.entity;

import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ArtistaEntity{ 
    @Id
    @GeneratedValue(generator = "Artista")
    private Long id;
    private String name;
    private String username;
    private String clave;
    private String datosContacto;
    private Double comisionPorVenta;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<StampEntity> stamps;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username=username;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
    
    public List<StampEntity> getStamps() {
        return stamps;
    }
    
    public void setStamps(List<StampEntity> stamps) {
        this.stamps=stamps;
    }
}