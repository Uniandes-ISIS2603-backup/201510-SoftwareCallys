package co.edu.uniandes.Callys.carroCompras.logic.api;

import co.edu.uniandes.Callys.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasDTO;
import co.edu.uniandes.Callys.carroCompras.logic.dto.CarroComprasPageDTO;
import java.util.List;

public interface ICarroComprasLogic {
    public CarroComprasDTO createCarroCompras(CarroComprasDTO detail);

    public List<CarroComprasDTO> getCarrosCompras();

    public CarroComprasPageDTO getCarrosCompras(Integer page, Integer maxRecords);

    public CarroComprasDTO getCarroCompras(Long id);

    public void deleteCarroCompras(Long id);

    public void updateCarroCompras(CarroComprasDTO detail);

    public ArtistaPageDTO getArtistas(Integer page, Integer maxRecords);
}
