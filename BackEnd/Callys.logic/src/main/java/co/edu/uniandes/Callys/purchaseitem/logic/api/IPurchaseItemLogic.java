package co.edu.uniandes.Callys.purchaseitem.logic.api;

import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
import java.util.List;

public interface IPurchaseItemLogic {
    
    public PurchaseItemDTO createPurchaseItem(PurchaseItemDTO detail);

    public List<PurchaseItemDTO> getPurchaseItems();

    public PurchaseItemPageDTO getPurchaseItems(Integer page, Integer maxRecords);

    public PurchaseItemDTO getPurchaseItem(Long id);
    
    public List<PurchaseItemDTO> getItemsByPurchase(Long idPurchase);
}
