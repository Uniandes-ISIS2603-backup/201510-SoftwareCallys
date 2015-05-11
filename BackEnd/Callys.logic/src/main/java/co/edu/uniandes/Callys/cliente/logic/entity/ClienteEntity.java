package co.edu.uniandes.Callys.cliente.logic.entity;

import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import co.edu.uniandes.Callys.purchase.logic.entity.PurchaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ClienteEntity 
{
    @Id
    @GeneratedValue(generator = "Cliente")
    private Long id;
    private String name;
    private Integer numCompras;
    private Integer numeroTarjeta;
    private Integer codigoSeguridad;
    private String password;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<PurchaseEntity> purchases;
    @OneToOne(cascade = CascadeType.REMOVE)
    private CarroComprasEntity carroCompras;
        
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public List<PurchaseEntity> getPurchases() {
        return purchases;
    }
    
    public void setPurchases(List<PurchaseEntity> purchases) {
        this.purchases= purchases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public Integer getNumCompras() {
        return numCompras;
    }

    public void setNumCompras(Integer numCompras) {
        this.numCompras = numCompras;
    }

    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public  Integer getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoDeSeguridad(Integer codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
    public CarroComprasEntity getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(CarroComprasEntity carroCompras) {
        this.carroCompras = carroCompras;
    }
}