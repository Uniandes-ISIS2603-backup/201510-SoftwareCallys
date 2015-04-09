package co.edu.uniandes.Callys.item.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(generator = "Item")
    private Long id;
    private Long idCamiseta;
    private Long idCarritoC;
    private double monto;

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

    public void setMonto(double monto) {
        this.monto = monto;
    }
}