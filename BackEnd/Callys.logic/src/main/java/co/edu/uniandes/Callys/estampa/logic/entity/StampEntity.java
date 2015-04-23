package co.edu.uniandes.callys.estampa.logic.entity;

import co.edu.uniandes.callys.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.callys.camiseta.logic.entity.CamisetaEntity;
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
    private int rating;
    private Long idArtista;
    @ManyToMany(mappedBy="stamps")
    private List<CamisetaEntity> camisetas;
    @ManyToOne
    private ArtistaEntity artista;

    public void addCamiseta(CamisetaEntity camiseta) {
        if (!getCamisetas().contains(camiseta)) {
            camisetas.add(camiseta);
        }
        if (!camiseta.getStamps().contains(this)) {
            camiseta.getStamps().add(this);
        }
    }
 
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
    
    public ArtistaEntity getArtista() {
        return artista;
    }

    public void setArtista(ArtistaEntity artista) {
        this.artista = artista;
    }
}