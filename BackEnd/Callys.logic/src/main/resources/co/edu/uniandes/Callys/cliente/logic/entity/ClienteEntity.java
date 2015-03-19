/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.Cliente.logic.entity;

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
    private CarroComprasEntity carroCompras;
    
    

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
    
    public CarroComprasEntity getCarroDecompras()
    {
        return carroCompras;
    }


}
