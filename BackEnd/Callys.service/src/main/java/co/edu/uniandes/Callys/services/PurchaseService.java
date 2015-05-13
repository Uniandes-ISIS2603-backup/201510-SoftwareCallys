package co.edu.uniandes.Callys.services;

import co.edu.uniandes.Callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.api.IPurchaseItemLogic;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/purchase")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseService {
    
    @Inject
    protected IPurchaseLogic purchaseLogicService;
    
    @Inject
    protected IPurchaseItemLogic purchaseItemLogicService;

    @POST
    public PurchaseDTO createPurchase(PurchaseDTO p) {
        return purchaseLogicService.createPurchase(p);
    }

    @GET
    public PurchasePageDTO getPurchases(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return purchaseLogicService.getPurchases(page, maxRecords);
    }

    @GET
    @Path("byClient")
    public List<PurchaseDTO> getPurchasesByClient(@QueryParam("id") Long idClient) {
        System.out.println("id:"+idClient);
        return purchaseLogicService.getPurchasesByClient(idClient);
    }
    
    @GET
    @Path("items")
    public List<PurchaseItemDTO> getPurchaseItemsByPurchase(@QueryParam("id") Long idPurchase) {
        return purchaseItemLogicService.getItemsByPurchase(idPurchase);
    }
    
    @GET
    @Path("{id}")
    public PurchaseDTO getPurchase(@PathParam("id") Long id) {
        return purchaseLogicService.getPurchase(id);
    }
}