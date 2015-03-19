/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.camiseta.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author estudiante
 */
@Entity
public class CamisetaEntity {
        @Id
    @GeneratedValue(generator = "Camiseta")
    private Long id;
    private String color;
    private int talla;
    private String material;
    private String texto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(double rating) {
        this.talla =talla;
    }

    public String getMaterial() {
        return material;
    }

    public String getTexto()
    {
        return texto;
    }
    
    public void setTexto(double popularidad) {
        this.texto = texto;
    }
}
