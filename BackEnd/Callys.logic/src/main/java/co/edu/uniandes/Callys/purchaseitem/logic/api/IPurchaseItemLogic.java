/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.purchaseitem.logic.api;

import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IPurchaseItemLogic {
    
    public PurchaseItemDTO createPurchaseItem(PurchaseItemDTO detail);

    public List<PurchaseItemDTO> getPurchaseItem();

    public PurchaseItemPageDTO getPurchaseItem(Integer page, Integer maxRecords);

    public PurchaseItemDTO getPurchaseItem(Long id);

    public void deletePurchaseItem(Long id);

    public void updatePurchaseItem(PurchaseItemDTO detail);
}
