package co.edu.uniandes.callys.purchaseitem.logic.api;
import co.edu.uniandes.callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
import java.util.List;
public interface IPurchaseItemLogic {
    
    public PurchaseItemDTO createPurchaseItem(PurchaseItemDTO detail);

    public List<PurchaseItemDTO> getPurchaseItem();

    public PurchaseItemPageDTO getPurchaseItem(Integer page, Integer maxRecords);

    public PurchaseItemDTO getPurchaseItem(Long id);

    public void deletePurchaseItem(Long id);

    public void updatePurchaseItem(PurchaseItemDTO detail);
}
