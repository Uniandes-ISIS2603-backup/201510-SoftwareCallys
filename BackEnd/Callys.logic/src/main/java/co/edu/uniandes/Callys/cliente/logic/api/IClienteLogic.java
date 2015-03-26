package co.edu.uniandes.callys.cliente.logic.api;
import co.edu.uniandes.callys.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.callys.cliente.logic.dto.ClientePageDTO;
import java.util.List;
public interface IClienteLogic {
    
    public ClienteDTO createCliente(ClienteDTO detail);

    public List<ClienteDTO> getCliente();

    public ClientePageDTO getCliente(Integer page, Integer maxRecords);

    public ClienteDTO getCliente(long id);

    public void deleteCliente(long id);

    public void updateCliente(ClienteDTO detail);
}
