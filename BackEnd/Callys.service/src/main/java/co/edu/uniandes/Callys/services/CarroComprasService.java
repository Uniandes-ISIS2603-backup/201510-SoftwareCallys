package co.edu.uniandes.Callys.services;

import co.edu.uniandes.Callys.carroCompras.logic.api.ICarroComprasLogic;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasPageDTO;
import co.edu.uniandes.Callys.purchaseitem.logic.api.IPurchaseItemLogic;
import co.edu.uniandes.Callys.purchase.logic.api.IPurchaseLogic;
import co.edu.uniandes.Callys.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.Callys.item.logic.dto.ItemDTO;
import co.edu.uniandes.Callys.item.logic.api.IItemLogic;
import co.edu.uniandes.Callys.purchaseitem.logic.dto.PurchaseItemDTO;
import java.util.List;
import java.util.Date;
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

@Path("/carroCompras")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroComprasService {
    
    @Inject
    protected ICarroComprasLogic carroComprasLogicService;
    
    @Inject
    protected IPurchaseLogic purchaseLogicService;
    
    @Inject
    protected IPurchaseItemLogic purchaseItemLogicService;
    
    @Inject
    protected IItemLogic itemLogicService;

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
        return carroComprasLogicService.getCarrosCompras(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CarroComprasDTO getCarroCompras(@PathParam("id") Long id) {
        return carroComprasLogicService.getCarroCompras(id);
    }

    @PUT
    @Path("{id}")
    public void updateCarroCompras(CarroComprasDTO carroCompras) {
        carroComprasLogicService.updateCarroCompras(carroCompras);
    }
    
    @POST
    @Path("comprar")
    public PurchaseDTO registrarCompra(@QueryParam("id")Long id){
        CarroComprasDTO carroCompras = carroComprasLogicService.getCarroCompras(id);
        PurchaseDTO pur = new PurchaseDTO();
        pur.setDate(new Date());
        pur.setDatosDeEnvio(carroCompras.getDatosEnvio());
        pur.setFormaDePago(carroCompras.getFormaPago());
        PurchaseDTO pur2 = purchaseLogicService.createPurchase(pur);
        List<ItemDTO> items = itemLogicService.getItemsByShoppingCart(carroCompras.getId());
        for(ItemDTO i : items){
            PurchaseItemDTO pitem= new PurchaseItemDTO();
            pitem.setIdCamiseta(i.getCamiseta());
            pitem.setMonto(i.getMonto());
            pitem.setIdPurchase(pur2.getId());
            purchaseItemLogicService.createPurchaseItem(pitem);
            itemLogicService.deleteItem(i.getId());
        }
        carroComprasLogicService.emptyShoppingCart(id);
        return pur2;
    }
}
