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
import co.edu.uniandes.Callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchasePageDTO;
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

@Path("/purchase")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseService {
    
    @Inject
    protected IPurchaseLogic purchaseLogicService;

    @POST
    public PurchaseDTO createPurchase(PurchaseDTO p) {
        return purchaseLogicService.createPurchase(p);
    }

    @DELETE
    @Path("{id}")
    public void deletePurchase(@PathParam("id") Long id) {
        purchaseLogicService.deletePurchase(id);
    }

    @GET
    public PurchasePageDTO getPurchase(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return purchaseLogicService.getPurchase(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public PurchaseDTO getPurchase(@PathParam("id") Long id) {
        return purchaseLogicService.getPurchase(id);
    }

    @PUT
    public void updatePurchase(@PathParam("id") Long id, PurchaseDTO detail) {
        purchaseLogicService.updatePurchase(detail);
    }

}