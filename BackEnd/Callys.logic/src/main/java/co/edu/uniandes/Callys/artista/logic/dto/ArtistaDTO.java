package co.edu.uniandes.Callys.artista.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArtistaDTO {
    private Long id;
    private String name;
    private String username;
    private String clave;
    private String datosContacto;
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

    public String getDatosContacto() {
        return datosContacto;
    }

    public void setDatosContacto(String datosContacto) {
        this.datosContacto = datosContacto;
    }
    
    public List<Long> getStamps() {
        return stamps;
    }
    
    public void setStamps(List<Long> stamps) {
        this.stamps=stamps;
    }
}
