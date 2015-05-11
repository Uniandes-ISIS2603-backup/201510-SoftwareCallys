package co.edu.uniandes.Callys.camiseta.logic.entity;

import co.edu.uniandes.Callys.item.logic.entity.ItemEntity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class CamisetaEntity {
    @Id
    @GeneratedValue(generator = "Camiseta")
    private Long id;
    private String color;
    private String talla;
    private String material;
    private String texto;
    
    @OneToMany 
    @JoinTable(name="Camiseta_Item", 
        joinColumns=@JoinColumn(name="Camiseta_ID"),
        inverseJoinColumns=@JoinColumn(name="Item_ID"))  
    private Collection<ItemEntity> items;

    public Collection<ItemEntity> getStamps() {
        return items;
    }

    public void setStamps(Collection<ItemEntity> stamps) {
        this.items = stamps;
    }

    public void addStamp(ItemEntity stamp) {
        if (!getStamps().contains(stamp)) {
            items.add(stamp);
        }
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