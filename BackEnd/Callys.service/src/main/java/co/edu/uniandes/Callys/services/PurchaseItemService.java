/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.services;
import co.edu.uniandes.Callys.purchaseitem.logic.api.IPurchaseItemLogic;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemPageDTO;
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

@Path("/purchaseItem")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseItemService {
    
    @Inject
    protected IPurchaseItemLogic purchaseItemLogicService;

    @POST
    public PurchaseItemDTO createPurchaseItem(PurchaseItemDTO pi) {
        return purchaseItemLogicService.createPurchaseItem(pi);
    }

    @DELETE
    @Path("{id}")
    public void deletePurchaseItem(@PathParam("id") Long id) {
        purchaseItemLogicService.deletePurchaseItem(id);
    }

    @GET
    public PurchaseItemPageDTO getPurchaseItem(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return purchaseItemLogicService.getPurchaseItem(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public PurchaseItemDTO getCatalogo(@PathParam("id") Long id) {
        return purchaseItemLogicService.getPurchaseItem(id);
    }

    @PUT
    public void updatePurchaseItem(PurchaseItemDTO detail) {
        purchaseItemLogicService.updatePurchaseItem(detail);
    }

}
