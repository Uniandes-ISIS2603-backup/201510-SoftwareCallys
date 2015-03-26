/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.item.logic.api;


import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.dto.ItemPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface IItemLogic {
    public ItemDTO createItem(ItemDTO detail);

    public List<ItemDTO> getItem();

    public ItemPageDTO getItem(Integer page, Integer maxRecords);

    public ItemDTO getItem(Long id);

    public void deleteItem(Long id);

    public void updateItem(ItemDTO detail);
}
