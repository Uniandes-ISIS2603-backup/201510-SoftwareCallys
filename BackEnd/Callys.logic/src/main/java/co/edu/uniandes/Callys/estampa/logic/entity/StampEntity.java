package co.edu.uniandes.callys.estampa.logic.entity;
import co.edu.uniandes.callys.camiseta.logic.entity.CamisetaEntity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class StampEntity {

    @Id
    @GeneratedValue(generator = "StampEntity")
    private Long id;
    private String tema;
    private double rating;
    private double popularidad;
    private Long idCatalogo;
    private Long idArtista;
    
    @ManyToMany(mappedBy="stamps")
    
    private Collection<CamisetaEntity> camisetas;
     public void addCamiseta(CamisetaEntity camiseta) {
      if (!getCamisetas().contains(camiseta)) {
          getCamisetas().add(camiseta);
      }
      if (!camiseta.getStamps().contains(this)) {
          camiseta.getStamps().add(this);
      }
    }
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

