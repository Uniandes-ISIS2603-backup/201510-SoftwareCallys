/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.purchase.logic.dto;

import java.util.Date;

/**
 *
 * @author estudiante
 */
public class PurchaseDTO {
    
    private Long id;
    private String name;
    private Date fecha;
    private String datosDeEnvio;
    private String formaDePago;
    private String itemsComprados;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return fecha;
    }

    public void setDate(Date nFecha) {
        this.fecha = nFecha;
    }
    
    public String getDatosDeEnvio() {
        return datosDeEnvio;
    }

    public void setDatosDeEnvio(String nDatos) {
        this.datosDeEnvio = nDatos;
    }
    
    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String nFormaDePago) {
        this.formaDePago = nFormaDePago;
    }
    
    public String getItemsC() {
        return itemsComprados;
    }

    public void setItemsC(String nItc) {
        this.itemsComprados = nItc;
    }
}
