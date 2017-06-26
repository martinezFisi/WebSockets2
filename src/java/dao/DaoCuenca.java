package dao;

import dto.Cuenca;
import java.util.List;

public interface DaoCuenca {
    public List<Cuenca> cuencaTemperaturaQRY();
    public List<Cuenca> cuencaPrecipitacionQRY();
    public Cuenca cuencaAleatorio(int id, String nombreTabla);
    public List<Cuenca> getCuencas(String nombreTabla);
    public String getMessage();
    
}
