package co.edu.uniandes.Callys.purchase.logic.api;

import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;

import java.util.List;

public interface IPurchaseLogic {
    
    public PurchaseDTO createPurchase(PurchaseDTO detail);

    public List<PurchaseDTO> getPurchases();

    public PurchasePageDTO getPurchases(Integer page, Integer maxRecords);

    public PurchaseDTO getPurchase(Long id);
    
    public void deletePurchase(Long id);
    
    public List<PurchaseDTO> getPurchasesByClient(Long idClient);
}
