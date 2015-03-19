/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.estampa.logic.api;


import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
import co.edu.uniandes.Callys.estampa.logic.dto.StampPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface IStampLogic {
     public StampDTO createStamp(StampDTO detail);

    public List<StampDTO> getStamp();

    public StampPageDTO getStamp(Integer page, Integer maxRecords);

    public StampDTO getStamp(Long id);

    public void deleteStamp(Long id);

    public void updateStamp(StampDTO detail);
}
