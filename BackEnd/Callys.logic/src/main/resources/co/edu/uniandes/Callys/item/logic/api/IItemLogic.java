/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.item.logic.api;

import java.software.logic.dto.ItemDTO;
import java.software.logic.dto.ItemPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface IItemLogic {
    public ItemDTO createStamp(ItemDTO detail);

    public List<ItemDTO> getStamp();

    public ItemDTO getStamp(Integer page, Integer maxRecords);

    public ItemPageDTO getStamp(Long id);

    public void deleteStamp(Long id);

    public void updateStamp(ItemDTO detail);
}
