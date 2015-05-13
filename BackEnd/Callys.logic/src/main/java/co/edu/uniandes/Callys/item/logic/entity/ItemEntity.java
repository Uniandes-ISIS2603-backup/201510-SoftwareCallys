package co.edu.uniandes.Callys.item.logic.entity;

import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(generator = "Item")
    private Long id;
    private Long idShoppingCart;
    private Double monto;
    @OneToOne
    private CamisetaEntity camiseta;
    
    public Long getIdShoppingCart() 
    {
        return idShoppingCart;
    }
    
    public void setIdShoppingCart(Long idShoppingCart)
    {
        this.idShoppingCart=idShoppingCart;
    }
    
    public CamisetaEntity getCamiseta() {
        return camiseta;
    }
            
    public void setCamiseta(CamisetaEntity camiseta) {
        this.camiseta = camiseta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}