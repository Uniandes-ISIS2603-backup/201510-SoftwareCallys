package co.edu.uniandes.Callys.estampa.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StampEntity {
    @Id
    @GeneratedValue(generator = "Stamp")
    private Long id;
    private Long idArtist;
    private String name;
    private String topic;
    private Integer rating;
    private String image;
    private Integer price;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdArtist()
    {
        return idArtist;
    }
    
    public void setIdArtist(Long idArtist)
    {
        this.idArtist=idArtist;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getPrice() {
        return price;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}