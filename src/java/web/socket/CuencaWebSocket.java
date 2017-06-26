
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
        return listToString(listTemperatura) + "," + listToString(listPrecipitacion);
    }

    
    public String listToString(List<Cuenca> list){
        String content1 = "<table><thead><tr><th>Id Cuenca</th>\n" +
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
            content1 = content1 + "<td>"+c.getId_cuenca()+"</td>";
            content1 = content1 + "<td>"+c.getEne_value()+"</td>";
            content1 = content1 + "<td>"+c.getFeb_value()+"</td>";
            content1 = content1 + "<td>"+c.getMar_value()+"</td>";
            content1 = content1 + "<td>"+c.getAbr_value()+"</td>";
            content1 = content1 + "<td>"+c.getMay_value()+"</td>";
            content1 = content1 + "<td>"+c.getJun_value()+"</td>";
            content1 = content1 + "<td>"+c.getJul_value()+"</td>";
            content1 = content1 + "<td>"+c.getAgo_value()+"</td>";
            content1 = content1 + "<td>"+c.getSet_value()+"</td>";
            content1 = content1 + "<td>"+c.getOct_value()+"</td>";
            content1 = content1 + "<td>"+c.getNov_value()+"</td>";
            content1 = content1 + "<td>"+c.getDic_value()+"</td>";
            content1 = content1 + "<td>"+c.getAnual_value()+"</td>";
            content1 = content1 + "</tr>";
        }
        
        content1 = content1 + "</tbody></table>";
        
        
        
        return content1;
    }
    
}
