/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.software.logic.api;

import java.software.logic.dto.StampDTO;
import java.software.logic.dto.StampPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface IStampLogic {
     public StampDTO createStamp(StampDTO detail);

    public List<StampDTO> getStamp();

    public StampDTO getStamp(Integer page, Integer maxRecords);

    public StampPageDTO getStamp(Long id);

    public void deleteStamp(Long id);

    public void updateStamp(StampDTO detail);
}
