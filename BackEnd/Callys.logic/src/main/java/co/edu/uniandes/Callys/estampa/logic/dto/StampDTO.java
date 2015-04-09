package co.edu.uniandes.Callys.estampa.logic.dto;

import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StampDTO {
    private Long id;
    private String tema;
    private double rating;
    private double popularidad;
    private Long idCatalogo;
    private Long idArtista;
    
    private Collection<CamisetaEntity> camisetas;
 
    public Collection<CamisetaEntity> getCamisetas() {
        return camisetas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }
    
    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
    
    public Long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Long idArtista) {
        this.idArtista = idArtista;
    }
}