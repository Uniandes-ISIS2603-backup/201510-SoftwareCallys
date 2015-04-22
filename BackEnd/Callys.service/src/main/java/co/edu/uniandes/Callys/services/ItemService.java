/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.services;

import co.edu.uniandes.Callys.item.logic.api.IItemLogic;
import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.dto.ItemPageDTO;
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

@Path("/item")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
/**
 *
 * @author estudiante
 */
public class ItemService {
    
     @Inject
    protected IItemLogic itemLogicService;

    @POST
    public ItemDTO createItem(ItemDTO item) {
        return itemLogicService.createItem(item);
    }

    @DELETE
    @Path("{id}")
    public void deleteItem(@PathParam("id") Long id) {
        itemLogicService.deleteItem(id);
    }

    @GET
    public ItemPageDTO getItem(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return itemLogicService.getItems(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ItemDTO getItem(@PathParam("id") Long id) {
        return itemLogicService.getItem(id);
    }
   
//    @GET
//    public List<ItemDTO> getItem() {
//        return itemLogicService.getItems();
//    }
    

    @PUT
    @Path("{id}") 
    public void updateItem(ItemDTO item) {
        itemLogicService.updateItem(item);
    } 
}
