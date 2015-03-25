package co.edu.uniandes.Callys.estampa.logic.entity;

/**
 *
 * @author estudiante
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StampEntity {

    @Id
    @GeneratedValue(generator = "Stamp")
    private Long id;
    private String tema;
    private double rating;
    private double popularidad;
   

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
        this.rating =rating;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }
}

