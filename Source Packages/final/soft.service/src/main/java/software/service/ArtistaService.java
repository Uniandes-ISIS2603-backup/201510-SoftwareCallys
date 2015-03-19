/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.service;

import java.software.logic.api.IArtistaLogic;
import java.software.logic.dto.ArtistaDTO;
import java.software.logic.dto.ArtistaPageDTO;

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
public class ArtistaService {
    
     @Inject
    protected IArtistaLogic artistaLogicService;

    @POST
    public ArtistaDTO createArtista(ArtistaDTO artista) {
        return artistaLogicService.createArtista(artista);
    }

    @DELETE
    @Path("{id}")
    public void deleteArtista(@PathParam("id") Long id) {
        artistaLogicService.deleteArtista(id);
    }

    @GET
    public ArtistaPageDTO getArtistas(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return artistaLogicService.getArtista(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ArtistatDTO getArtista(@PathParam("id") Long id) {
        return artistaLogicService.getArtista(id);
    }

    @PUT
    public void updateArtista(@PathParam("id") Long id, ArtistaDTO artista) {
        artistaLogicService.updateArtista(artista);
    }
}
