/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalogo.logic.api;

/**
 *
 * @author estudiante
 */
import co.edu.uniandes.Callys.catalogo.logic.dto.CatalogoDTO;
import co.edu.uniandes.Callys.catalogo.logic.dto.CatalogoPageDTO;
import java.util.List;

public interface ICatalogoLogic {

    public CatalogoDTO createCatalogo(CatalogoDTO detail);

    public List<CatalogoDTO> getCatalogo();

    public CatalogoPageDTO getCatalogo(Integer page, Integer maxRecords);

    public CatalogoDTO getCatalogo(Long id);

    public void deleteCatalogo(Long id);

    public void updateCatalogo(CatalogoDTO detail);
}
