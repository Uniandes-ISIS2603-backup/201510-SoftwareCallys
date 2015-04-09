package co.edu.uniandes.Callys.cliente.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDTO {
    private long id;
    private String nombre;
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

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
