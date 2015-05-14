package co.edu.uniandes.Callys.cliente.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String username;
    private Integer numCompras;
    private Integer numeroTarjeta;
    private Integer codigoSeguridad;
    private Long carroCompras;
    private List<Long> purchases;
    private String password;
    
    public List<Long> getPurchases() {
        return purchases;
    }
    
    public void setPurchases(List<Long> purchases) {
        this.purchases=purchases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
    public Integer getNumCompras() {
        return numCompras;
    }

    public void setNumCompras(Integer numCompras) {
        this.numCompras = numCompras;
    }

    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public Integer getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoDeSeguridad(Integer codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
    public Long getCarroCompras() {
        return carroCompras;
    }
    
    public void setCarroCompras(Long carroCompras) {
        this.carroCompras=carroCompras;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password= password;
    }
}