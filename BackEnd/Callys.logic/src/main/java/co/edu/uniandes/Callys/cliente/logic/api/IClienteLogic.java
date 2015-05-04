package co.edu.uniandes.Callys.cliente.logic.api;

import co.edu.uniandes.Callys.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.cliente.logic.dto.ClientePageDTO;
import java.util.List;

public interface IClienteLogic {
    
    public ClienteDTO createCliente(ClienteDTO detail);

    public List<ClienteDTO> getClientes();

    public ClientePageDTO getClientes(Integer page, Integer maxRecords);

    public ClienteDTO getCliente(Long id);

    public void deleteCliente(Long id);

    public void updateCliente(ClienteDTO detail);
    
    public Integer loginCliente(String name, String password);
}
