package web.servlet;

import dao.DaoCuenca;
import dao.impl.DaoCuencaImpl;
import dto.Cuenca;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CuencaServlet", urlPatterns = {"/Cuenca"})
public class CuencaServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        accion = (accion == null) ? "": accion;
        String target = "index.jsp";
        String result = null;
        
        System.out.println("Llegaste al servlet");
        System.out.println("accion: "+accion);
        
        DaoCuenca daoCuenca = new DaoCuencaImpl();
        
        if("QRY".equals(accion)){
            List<Cuenca> listTemperatura = daoCuenca.cuencaTemperaturaQRY();
            List<Cuenca> listPrecipitacion = daoCuenca.cuencaPrecipitacionQRY();
            
            if(listTemperatura != null && listPrecipitacion != null){
                request.setAttribute("listTemperatura", listTemperatura);
                request.setAttribute("listPrecipitacion", listPrecipitacion);   
                
                System.out.println("Entraste al if(listTemperatura != null && listPrecipitacion != null)");
            } else {
                System.out.println("Entraste al else");
                result = daoCuenca.getMessage();
                System.out.println(result);
            }
            
            target = "clima.jsp";
        }
        
        if (result != null) {
            request.setAttribute("msg", result);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
        
        
        
    }
        

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
