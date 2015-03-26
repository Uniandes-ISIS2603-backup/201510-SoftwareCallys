/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalog.logic.dto;

/**
 *
 * @author estudiante
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CatalogDTO {

    private Long id;

    private String name;

    private Integer numeroElementos;
    
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
        this.name = name;
    }

    public Integer getNumElementos() {
        return numeroElementos;
    }

    public void setNumElementos(Integer numElementos) {
        this.numeroElementos = numElementos;
    }
}
