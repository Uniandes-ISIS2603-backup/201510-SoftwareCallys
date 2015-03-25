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

import co.edu.uniandes.Callys.camiseta.logic.api.ICamisetaLogic;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.Callys.camiseta.logic.dto.CamisetaPageDTO;
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

@Path("/artistas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
/**
 *
 * @author estudiante
 */
public class CamisetaService {
    
     @Inject
    protected ICamisetaLogic camisetaLogicService;

    @POST
    public CamisetaDTO createCamiseta(CamisetaDTO camiseta) {
        return camisetaLogicService.createCamiseta(camiseta);
    }

    @DELETE
    @Path("{id}")
    public void deleteCamiseta(@PathParam("id") Long id) {
        camisetaLogicService.deleteCamiseta(id);
    }

    @GET
    public List<CamisetaDTO> getCamiseta() {
        return camisetaLogicService.getCamiseta();
    }
    
    @GET
    public CamisetaPageDTO getCamiseta(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return camisetaLogicService.getCamiseta(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CamisetaDTO getCamiseta(@PathParam("id") Long id) {
        return camisetaLogicService.getCamiseta(id);
    }

    @PUT
    public void updateCamiseta(CamisetaDTO camiseta) {
        camisetaLogicService.updateCamiseta(camiseta);
    }  
}
