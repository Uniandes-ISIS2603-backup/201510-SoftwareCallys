/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.services;

/**
 *
 * @author estudiante
 */
import co.edu.uniandes.Callys.catalog.logic.api.ICatalogLogic;
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogDTO;
import co.edu.uniandes.Callys.catalog.logic.dto.CatalogPageDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/catalogo")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatalogoService {

    @Inject
    protected ICatalogLogic catalogoLogicService;

    @POST
    public CatalogDTO createCatalogo(CatalogDTO catalogo) {
        return catalogoLogicService.createCatalogo(catalogo);
    }

    @DELETE
    @Path("{id}")
    public void deleteCatalogo(@PathParam("id") Long id) {
        catalogoLogicService.deleteCatalogo(id);
    }

    @GET
    public CatalogPageDTO getCatalogos(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return catalogoLogicService.getCatalogo(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CatalogDTO getCatalogo(@PathParam("id") Long id) {
        return catalogoLogicService.getCatalogo(id);
    }

    @PUT
    public void updateCatalogo(@PathParam("id") Long id, CatalogDTO detail) {
        catalogoLogicService.updateCatalogo(detail);
    }
}
