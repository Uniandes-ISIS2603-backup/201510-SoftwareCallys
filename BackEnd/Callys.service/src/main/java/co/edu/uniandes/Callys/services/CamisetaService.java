package co.edu.uniandes.Callys.services;
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

@Path("/camiseta")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
        return camisetaLogicService.getCamisetas();
    }
    
    @GET
    public CamisetaPageDTO getCamiseta(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return camisetaLogicService.getCamisetas(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CamisetaDTO getCamiseta(@PathParam("id") Long id) {
        return camisetaLogicService.getCamiseta(id);
    }

    @PUT
     @Path("{id}")
    public void updateCamiseta(CamisetaDTO camiseta) {
        camisetaLogicService.updateCamiseta(camiseta);
    }  
}
