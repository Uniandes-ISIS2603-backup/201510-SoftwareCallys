package co.edu.uniandes.Callys.catalog.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CatalogDTO {
    private Long id;
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
