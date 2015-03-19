/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.catalog.logic.api;

/**
 *
 * @author estudiante
 */
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogDTO;
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogPageDTO;
import java.util.List;

public interface ICatalogLogic {

    public CatalogDTO createCatalogo(CatalogDTO detail);

    public List<CatalogDTO> getCatalogo();

    public CatalogPageDTO getCatalogo(Integer page, Integer maxRecords);

    public CatalogDTO getCatalogo(Long id);

    public void deleteCatalogo(Long id);

    public void updateCatalogo(CatalogDTO detail);
}
