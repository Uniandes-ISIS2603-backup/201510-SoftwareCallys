/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  co.edu.uniandes.Callys.item.logic.dto;

/**
 *
 * @author estudiante
 */
public class ItemDTO {
    private Long id;

    private double monto;

    private Long idCamiseta;
    
    private Long idCarritoC;

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
