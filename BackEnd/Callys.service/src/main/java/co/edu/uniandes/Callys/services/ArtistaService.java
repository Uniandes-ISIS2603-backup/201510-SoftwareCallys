package co.edu.uniandes.Callys.services;
import co.edu.uniandes.Callys.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.Callys.estampa.logic.api.IStampLogic;
import co.edu.uniandes.Callys.estampa.logic.dto.StampDTO;
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

@Path("/artista")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtistaService {
    
    @Inject
    protected IArtistaLogic artistaLogicService;
    
    @Inject
    protected IStampLogic stampLogicService;

    @POST
    public ArtistaDTO createArtista(ArtistaDTO artista) {
        return artistaLogicService.createArtista(artista);
    }

    @DELETE
    @Path("{id}")
    public void deleteArtista(@PathParam("id") Long id) {
        artistaLogicService.deleteArtista(id);
        List<StampDTO> stamps=stampLogicService.getStampsByArtist(id);
        for(StampDTO stamp:stamps)
        {
            stampLogicService.deleteStamp(stamp.getId());
        }
    }

    @GET
    public ArtistaPageDTO getArtistas(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return artistaLogicService.getArtistas(page, maxRecords);
    }

    @POST
    @Path("login")
    public ArtistaDTO login(ArtistaDTO artista) {
        return artistaLogicService.login(artista.getUsername(), artista.getClave());
    }

    @PUT
    @Path("{id}")
    public void updateArtista(@PathParam("id") Long id, ArtistaDTO artista) {
        artistaLogicService.updateArtista(artista);
    }
}
