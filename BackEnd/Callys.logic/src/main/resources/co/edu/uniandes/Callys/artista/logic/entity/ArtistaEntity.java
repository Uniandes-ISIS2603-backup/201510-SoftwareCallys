/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.artista.logic.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author estudiante
 */
@Entity
public class ArtistaEntity {
 


    @Id
    @GeneratedValue(generator = "Artista")
    private String id;
    private String clave;
    private Integer numeroEstampas;
    private String datosContacto;
    private double comisionPorVenta;

    public String getId() {
        return id;
    }

    public void setId( String id) {
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
        this.numeroEstampas =numeroEstampas;
    }

    public String getDAtosContacto() {
        return datosContacto;
    }

    public void setDatosVContacto(String datosContacto) {
        this.datosContacto= datosContacto;
    }
    
    public double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta( double comisionPorVenta) {
        this.comisionPorVenta= comisionPorVenta;
    }


}
