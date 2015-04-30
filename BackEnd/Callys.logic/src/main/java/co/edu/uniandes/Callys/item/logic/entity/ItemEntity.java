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
    Long id;
    private Long idCamiseta;
    private Long idCarritoC;
    private Double monto;
    @ManyToOne
    private CamisetaEntity camiseta;
    @ManyToOne
    private CarroComprasEntity carroCompras;

    public CamisetaEntity getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(CamisetaEntity camiseta) {
        this.camiseta = camiseta;
    }
    
    public CarroComprasEntity getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(CarroComprasEntity carroCompras) {
        this.carroCompras = carroCompras;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(Long idCamiseta) {
        this.idCamiseta = idCamiseta;
    }

    public Long getIdCarritoC() {
        return idCarritoC;
    }

    public void setIdCarritoC(Long idCarritoC) {
        this.idCarritoC = idCarritoC;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}