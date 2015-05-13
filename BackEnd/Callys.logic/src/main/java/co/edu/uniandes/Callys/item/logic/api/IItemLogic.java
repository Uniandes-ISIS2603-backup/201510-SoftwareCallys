package co.edu.uniandes.Callys.item.logic.api;

import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.dto.ItemPageDTO;
import java.util.List;

public interface IItemLogic {
    public ItemDTO createItem(ItemDTO detail);

    public List<ItemDTO> getItems();

    public ItemPageDTO getItems(Integer page, Integer maxRecords);

    public ItemDTO getItem(Long id);

    public void deleteItem(Long id);

    public void updateItem(ItemDTO detail);
    
    public List<ItemDTO> getItemsByShoppingCart(Long idShoppingCart);
}
