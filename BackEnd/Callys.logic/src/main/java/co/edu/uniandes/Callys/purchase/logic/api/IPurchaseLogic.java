package co.edu.uniandes.Callys.purchase.logic.api;

import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
import java.util.List;

public interface IPurchaseLogic {
    
    public PurchaseDTO createPurchase(PurchaseDTO detail);

    public List<PurchaseDTO> getPurchase();

    public PurchasePageDTO getPurchase(Integer page, Integer maxRecords);

    public PurchaseDTO getPurchase(Long id);

    public void deletePurchase(Long id);

    public void updatePurchase(PurchaseDTO detail);
}
