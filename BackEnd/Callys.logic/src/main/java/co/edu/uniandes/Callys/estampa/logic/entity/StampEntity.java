package co.edu.uniandes.Callys.estampa.logic.entity;

import co.edu.uniandes.Callys.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class StampEntity {

    @Id
    @GeneratedValue(generator = "Stamp")
    private Long id;
    private String name;
    private String topic;
    private Integer rating;
    private Integer price;
    private String image;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() 
    {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getRating() {
        return rating;
    }


    public void setRating(Integer rating) {
        this.rating = rating;
    }
}