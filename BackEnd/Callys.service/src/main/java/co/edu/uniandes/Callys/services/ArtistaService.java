package co.edu.uniandes.Callys.services;
import co.edu.uniandes.Callys.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
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

@Path("/artista")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
        return artistaLogicService.getArtistas(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ArtistaDTO getArtista(@PathParam("id") Long id) {
        return artistaLogicService.getArtista(id);
    }

    @PUT
    @Path("{id}")
    public void updateArtista(ArtistaDTO artista) {
        artistaLogicService.updateArtista(artista);
    }
}
