package co.edu.uniandes.Callys.estampa.logic.dto;

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

    public void setId(Long nId) {
        this.id = nId;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String nTema) {
        this.tema = nTema;
    }

    public double getRating() {
        return rating;
    }

    public void setPopularidad(double nPopularidad) {
        this.popularidad = nPopularidad;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setRating(double nRating) {
        this.rating = nRating;
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
        this.idArtista = idA;
    }
}
