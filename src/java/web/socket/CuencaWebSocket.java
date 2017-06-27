
package web.socket;

import dao.DaoCuenca;
import dao.impl.DaoCuencaImpl;
import dto.Cuenca;
import java.util.List;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/wscuenca")
public class CuencaWebSocket {

    @OnMessage
    public String onMessage(String message) {
        
        System.out.println("Se entró a onMessage en el Servidor");
        DaoCuenca daoCuenca = new DaoCuencaImpl();
        List<Cuenca> listTemperatura = daoCuenca.getCuencas("cuenca_temperatura");
        List<Cuenca> listPrecipitacion = daoCuenca.getCuencas("cuenca_precipitacion");
        System.out.println(listTemperatura.toString());
        return listToString(listTemperatura, "temperatura") 
                + "," + listToString(listPrecipitacion, "precipitacion");
    }

    
    public String listToString(List<Cuenca> list, String indicador){
        String content1 = "<table class=\"table\"><thead><tr><th>Id Cuenca</th>\n" +
                        "<th>Enero</th>\n" +
                        "<th>Febrero</th>\n" +
                        "<th>Marzo</th>\n" +
                        "<th>Abril</th>\n" +
                        "<th>Mayo</th>\n" +
                        "<th>Junio</th>\n" +
                        "<th>Julio</th>\n" +
                        "<th>Agosto</th>\n" +
                        "<th>Setiembre</th>\n" +
                        "<th>Octubre</th>\n" +
                        "<th>Noviembre</th>\n" +
                        "<th>Diciembre</th>\n" +
                        "<th>Anual</th></tr></thead><tbody>";
        
        for(Cuenca c : list){
            content1 = content1 + "<tr>";
            content1 = content1 + "<td style=\"font-weight: bold;\">" + c.getId_cuenca() + "</td>";
            content1 = content1 + addStyleToTd(c.getEne_value(), indicador);
            content1 = content1 + addStyleToTd(c.getFeb_value(), indicador);
            content1 = content1 + addStyleToTd(c.getMar_value(), indicador);
            content1 = content1 + addStyleToTd(c.getAbr_value(), indicador);
            content1 = content1 + addStyleToTd(c.getMay_value(), indicador);
            content1 = content1 + addStyleToTd(c.getJun_value(), indicador);
            content1 = content1 + addStyleToTd(c.getJul_value(), indicador);
            content1 = content1 + addStyleToTd(c.getAgo_value(), indicador);
            content1 = content1 + addStyleToTd(c.getSet_value(), indicador);
            content1 = content1 + addStyleToTd(c.getOct_value(), indicador);
            content1 = content1 + addStyleToTd(c.getNov_value(), indicador);
            content1 = content1 + addStyleToTd(c.getDic_value(), indicador);
            content1 = content1 + addStyleToTd(c.getAnual_value(), indicador);
            content1 = content1 + "</tr>";
        }
        
        content1 = content1 + "</tbody></table>";

        return content1;
    }
    
    private String addStyleToTd(Float value, String indicador){
        String td = null;
        int bajo = 0;
        int medioIni = 0;
        int medioFin = 0;
        int alto = 0;
        
        switch(indicador){
            case "temperatura":
                    bajo = 10;
                    medioIni = 11;
                    medioFin = 25;
                    alto = 26;
                break;
            
            case "precipitacion":
                    bajo = 26;
                    medioIni = 27;
                    medioFin = 70;
                    alto = 71;
                break;
        }
        
        if(value <= bajo){
            td = "<td style=\"color: #303F9F;\">" + value + "</td>";
        } else{
            if( value >=medioIni && value <=medioFin){
                td = "<td style=\"color:  #212121;\">" + value + "</td>";
            } else{
                if( value >= alto ){
                    td = "<td style=\"color: #D32F2F;\">" + value + "</td>";
                } else{
                    td = "<td>" + value + "</td>";
                }
            }
        }
        
        return td;
    }
    
}
