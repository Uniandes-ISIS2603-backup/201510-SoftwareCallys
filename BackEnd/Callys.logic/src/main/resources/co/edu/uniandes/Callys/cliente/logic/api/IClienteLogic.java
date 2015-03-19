/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.Cliente.logic.api;



import co.edu.uniandes.Callys.Cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.Callys.Cliente.logic.dto.ClientePageDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IClienteLogic {
    
    
    public ClienteDTO createCliente(ClienteDTO detail);

    public List<ClienteDTO> getCliente();

    public ClientePageDTO getCliente(Integer page, Integer maxRecords);

    public ClienteDTO getCliente(long id);

    public void deleteCliente(long id);

    public void updateCliente(ClienteDTO detail);
}
