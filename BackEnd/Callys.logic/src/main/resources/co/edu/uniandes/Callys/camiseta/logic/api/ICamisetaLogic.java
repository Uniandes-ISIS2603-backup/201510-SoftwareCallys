/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.camiseta.logic.api;

import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface ICamisetaLogic {
    
    public CamisetaDTO createCamiseta(CamisetaDTO detail);

    public List<CamisetaDTO> getCamiseta();

    public CamisetaDTO getCamiseta(Integer page, Integer maxRecords);

    public CamisetaPageDTO getCamiseta(Long id);

    public void deleteCamiseta(Long id);

    public void updateCamiseta(CamisetaDTO detail);
}
