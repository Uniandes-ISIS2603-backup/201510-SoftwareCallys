package co.edu.uniandes.callys.estampa.logic.dto;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StampDTO {
    
    private Long id;

    private String tema;

    private double rating;

    private double popularidad;
    
    private Long idCatalogo;
    
    private Long idArtista;
    
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

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idC) {
        this.idCatalogo = idC;
    }
    
    public Long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Long idA) {
        this.idArtista = id;
    }
}
