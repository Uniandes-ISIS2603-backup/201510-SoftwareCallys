package co.edu.uniandes.callys.cliente.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClienteEntity 
{
    @Id
    @GeneratedValue(generator = "Cliente")
    private Long id;
    private String name;
    private Integer numCompras;
    private Integer numeroTarjeta;
    private Integer codigoSeguridad;
    private long carroComprasId;
    private String idCompras;
    
    public String getIdCompras() {
        return idCompras;
    }
    
    public void setIdCompras(String idCompras) {
        this.idCompras= idCompras;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
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
    
    public  Integer getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoDeSeguridad(Integer codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
    public long getCarroComprasId() {
        return carroComprasId;
    }
    
    public void setCarroComprasId(long carroComprasId) {
        this.carroComprasId= carroComprasId;
    }
}