package co.edu.uniandes.Callys.camiseta.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CamisetaDTO {
    private Long id;
    private String name;
    private Integer price;
    private String image;
    private String color;
    private String talla;
    private String material;
    private String texto; 
    private List<Long> stamps;

    public List<Long> getStamps() {
        return stamps;
    }
    
    public void setStamps(List<Long> stamps) {
        this.stamps=stamps;
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
    
    public String getName()
    {
        return name;
    }

    public void setName(String  name) {
        this.name = name;
    }
    
    public String getImage()
    {
        return image;
    }

    public void setImage(String  image) {
        this.image = image;
    }
    
    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer  price) {
        this.price = price;
    }
}