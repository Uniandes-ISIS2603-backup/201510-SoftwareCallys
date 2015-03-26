package co.edu.uniandes.callys.cliente.logic.dto;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDTO {
 
    
    private long id;
    private String nombre;
    private Integer numeroCompras;
    private Integer numeroTargeta;
    private Integer codigoDeSeguridad;
    private long carroComprasId;
    
    private String idCompras;
    
    public String getIdCompras()
    {
        return idCompras;
    }
    
    public void setIdCompras(String idCompras)
    {
        this.idCompras= idCompras;
    }
    

    public long getId() {
        return id;
    }

    public void setId( long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(Integer numeroCompras) {
        this.numeroCompras =numeroCompras;
    }

    public Integer getNumeroTargeta() {
        return numeroTargeta;
    }

    public void setNumeroTargeta( Integer numeroTargeta) {
        this.numeroTargeta= numeroTargeta;
    }
    
    public  Integer getCodigoSeguridad() {
        return codigoDeSeguridad;
    }

    public void setCodigoDeSeguridad( Integer codigoDeSeguridad) {
        
        this.codigoDeSeguridad= codigoDeSeguridad;
    }
    
    public long getCarroDecompras()
    {
        return carroComprasId;
    }
    public void setCarroDeCompras(long carroComprasId)
    {
        this.carroComprasId = carroComprasId;
    }
}
