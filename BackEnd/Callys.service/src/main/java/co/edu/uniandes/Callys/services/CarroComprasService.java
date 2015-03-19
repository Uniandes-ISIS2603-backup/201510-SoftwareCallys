/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.services;

import co.edu.uniandes.Callys.artista.logic.api.ICarroComprasLogic;
import co.edu.uniandes.Callys.artista.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.artista.logic.dto.CarroComprasPageDTO;
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
public class CarroComprasService {
    
     @Inject
    protected ICarroComprasLogic carroComprasLogicService;

    @POST
    public CarroComprasDTO createCarroCompras(CarroComprasDTO carroCompras) {
        return carroComprasLogicService.createCarroCompras(carroCompras);
    }

    @DELETE
    @Path("{id}")
    public void deleteCarroCompras(@PathParam("id") Long id) {
        carroComprasLogicService.deleteCarroCompras(id);
    }

    @GET
    public CarroComprasPageDTO getCarroCompras(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return carroComprasLogicService.getArtistas(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CarroComprasDTO getCarroCompras(@PathParam("id") Long id) {
        return carroComprasLogicService.getArtista(id);
    }

    @PUT
    public void updateCarroCompras(@PathParam("id") Long id, CarroComprasDTO carroCompras) {
        carroComprasLogicService.updateCarroCompras(carroCompras);
    }
}
