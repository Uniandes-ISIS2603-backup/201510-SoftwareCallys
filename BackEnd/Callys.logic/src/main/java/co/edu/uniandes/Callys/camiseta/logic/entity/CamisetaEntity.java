package co.edu.uniandes.Callys.camiseta.logic.entity;

import co.edu.uniandes.Callys.estampa.logic.entity.StampEntity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
/**
 *
 * @author estudiante
 */
@Entity
public class CamisetaEntity {
    @Id
    @GeneratedValue(generator = "CamisetaEntity")
    private Long id;
    private String color;
    private int talla;
    private String material;
    private String texto;
    
    @ManyToMany 
    @JoinTable(name="Camiseta_Stamp", 
      joinColumns=@JoinColumn(name="Camiseta_ID"),
      inverseJoinColumns=@JoinColumn(name="Stamp_ID"))  
    private Collection<StampEntity> stamps;

    
    public Collection<StampEntity> getStamps() {
    return stamps;
  }

  public void setStamps(Collection<StampEntity> stamps) {
    this.stamps = stamps;
  }
  
   public void addDepartment(StampEntity stamp) {
    if (!getStamps().contains(stamp)) {
        getStamps().add(stamp);
    }
    if (!stamp.getCamisetas().contains(this)) {
      stamp.getCamisetas().add(this);
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

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla =talla;
    }

    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
       this.material=material;
    }

    public String getTexto()
    {
        return texto;
    }
    
    public void setTexto(String  texto) {
        this.texto = texto;
    }
}
