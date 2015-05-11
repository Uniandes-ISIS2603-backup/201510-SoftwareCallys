package co.edu.uniandes.Callys.camiseta.logic.dto;

import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CamisetaDTO {
    private Long id;
    private String color;
    private String talla;
    private String material;
    private String texto; 
    private Collection<ItemEntity> items;

    public Collection<ItemEntity> getStamps() {
        return items;
    }

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

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
       this.material = material;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String  texto) {
        this.texto = texto;
    }
}