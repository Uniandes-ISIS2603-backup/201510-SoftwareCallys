package co.edu.uniandes.Callys.item.logic.entity;

import co.edu.uniandes.Callys.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.Callys.carroCompras.logic.entity.CarroComprasEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(generator = "Item")
    private Long id;
    private Double monto;
    @ManyToOne
    private CamisetaEntity camiseta;
    @ManyToOne 
    private CarroComprasEntity carroCompras;
    
    public CarroComprasEntity getCarroCompras()
    {
       return carroCompras;
    }
    
    public CamisetaEntity getCamiseta() {
        return camiseta;
    }

    public void setCarroCompras(CarroComprasEntity carroCompras)
    {
        this.carroCompras = carroCompras;
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