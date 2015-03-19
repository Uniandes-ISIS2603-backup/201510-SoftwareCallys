/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.cliente.logic.entity;

import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
public class ClienteEntity 
{


    @Id
    @GeneratedValue(generator = "Cliente")
    private long id;
    private String nombre;
    private Integer numeroCompras;
    private Integer numeroTargeta;
    private Integer codigoDeSeguridad;
    private long carroComprasId;
    private String idCompras;
    
    public String getIdCompras()
    {
        return idCompras;
    }
    
    public void setIdCompras(String idCompras)
    {
        this.idCompras= idCompras;
    }

    public long getId() {
        return id;
    }

    public void setId( long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(Integer numeroCompras) {
        this.numeroCompras =numeroCompras;
    }

    public Integer getNumeroTargeta() {
        return numeroTargeta;
    }

    public void setNumeroTargeta( Integer numeroTargeta) {
        this.numeroTargeta= numeroTargeta;
    }
    
    public  Integer getCodigoSeguridad() {
        return codigoDeSeguridad;
    }

    public void setCodigoDeSeguridad( Integer codigoDeSeguridad) {
        
        this.codigoDeSeguridad= codigoDeSeguridad;
    }
    
    public long getCarroDecompras()
    {
        return carroComprasId;
    }
    public void setCarroDeCompras(long carroCompras)
    {
        this.carroComprasId= carroCompras;
    }


}
