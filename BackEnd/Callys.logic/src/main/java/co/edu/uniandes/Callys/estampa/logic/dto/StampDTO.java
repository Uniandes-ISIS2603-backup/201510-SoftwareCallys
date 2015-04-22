package co.edu.uniandes.Callys.estampa.logic.dto;

import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StampDTO {
    private Long id;
    private String name;
    private String topic;
    private int rating;
    private Long idArtista;
    private List<CamisetaEntity> camisetas;
 
    public List<CamisetaEntity> getCamisetas() {
        return camisetas;
    }

    public void setCamisetas(List<CamisetaEntity> camisetas) {
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