package co.edu.uniandes.Callys.camiseta.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CamisetaDTO {
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
    public void setTalla(int talla)
    {
        this.talla=talla;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getTexto()
    {
        return texto;
    }
    
    public void setTexto (String texto) {
        this.texto = texto;
    }
}
