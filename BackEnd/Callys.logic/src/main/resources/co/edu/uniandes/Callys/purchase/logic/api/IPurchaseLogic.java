/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.purchase.logic.api;

import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IPurchaseLogic {
    
    public PurchaseDTO createCompra(PurchaseDTO detail);

    public List<PurchaseDTO> getCompra();

    public PurchasePageDTO getCompra(Integer page, Integer maxRecords);

    public PurchaseDTO getCompra(Long id);

    public void deleteCompra(Long id);

    public void updateCompra(PurchaseDTO detail);
}
