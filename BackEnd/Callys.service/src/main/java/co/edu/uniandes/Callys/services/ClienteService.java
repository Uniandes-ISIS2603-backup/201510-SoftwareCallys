package co.edu.uniandes.Callys.services;

import co.edu.uniandes.Callys.carroCompras.logic.api.ICarroComprasLogic;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.Callys.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.cliente.logic.dto.ClientePageDTO;

import javax.ws.rs.DELETE;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

@Path("/cliente")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteService {

    @Inject
    protected IClienteLogic clienteLogicService;
    
    @Inject
    protected ICarroComprasLogic carroComprasLogicService;

    @POST
    public ClienteDTO createCliente(ClienteDTO cliente) {
        return clienteLogicService.createCliente(cliente);
//        CarroComprasDTO carro=new CarroComprasDTO();
//        carro.setDatosEnvio("Calle inventada 123");
//        carro.setMonto(new Double(0));
//        carro.setFormaPago("Tarjeta de crédito");
//        carro.se
//            private Long id;
//    private Double monto;
//    private String formaPago;
//    private String datosEnvio;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        clienteLogicService.deleteCliente(id);
    }

    @GET
    public ClientePageDTO getCliente(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return clienteLogicService.getClientes(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ClienteDTO getCliente(@PathParam("id") Long id) {
        return clienteLogicService.getCliente(id);
    }

    @PUT
    @Path("{id}")
    public void updateCliente(ClienteDTO cliente) {
        clienteLogicService.updateCliente(cliente);
    }
}
