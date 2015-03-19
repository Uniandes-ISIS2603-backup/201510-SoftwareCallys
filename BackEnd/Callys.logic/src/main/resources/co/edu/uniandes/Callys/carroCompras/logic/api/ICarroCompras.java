/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.Callys.carroCompras.logic.api;

import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasPageDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
public interface ICarroCompras {
    public CarroComprasDTO createCarroCompras(CarroComprasDTO detail);

    public List<CarroComprasDTO> getCarroCompras();

    public CarroComprasDTO getCarroCompras(Integer page, Integer maxRecords);

    public CarroComprasPageDTO getCarroCompras(Long id);

    public void deleteCarroCompras(Long id);

    public void updateCarroCompras(CarroComprasDTO detail);
}
