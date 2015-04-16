package co.edu.uniandes.Callys.estampa.logic.dto;

import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StampDTO {
    Long id;
    private String name;
    private String topic;
    private int rating;
    private Long idArtista;
    
    private Collection<CamisetaEntity> camisetas;
 
    public Collection<CamisetaEntity> getCamisetas() {
        return camisetas;
    }

    public void setCamisetas(Collection<CamisetaEntity> camisetas) {
        this.camisetas = camisetas;
    }

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
    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public Long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Long idArtista) {
        this.idArtista = idArtista;
    }
}