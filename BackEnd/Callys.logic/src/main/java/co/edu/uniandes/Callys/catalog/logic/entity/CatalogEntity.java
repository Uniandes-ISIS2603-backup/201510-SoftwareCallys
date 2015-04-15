package co.edu.uniandes.Callys.catalog.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CatalogEntity {

    @Id
    @GeneratedValue(generator = "Catalogo")
    Long id;
    private String name;
    private Integer numElementos;
    
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

    public Integer getNumeroElementos() {
        return numElementos;
    }

    public void setNumeroElementos(Integer numElementos) {
        this.numElementos = numElementos;
    }
}