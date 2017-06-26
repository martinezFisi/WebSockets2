<%-- 
    Document   : index
    Created on : 25-jun-2017, 13:28:25
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
    </head>
    <body>
<!--        <form action="Cuenca">
            <input type="hidden" name="accion" value="QRY">
            <input type="submit" value="Entrar">
        </form>-->
        
        <h1 style="text-align: center">Banco Mundial - Indicadores de clima</h1>

        
        <h2>Indicadores de Temperatura en Cuencas</h2>
        <div id="contentTemperatura"></div>
        <br/>
        <br/>
        <h2>Indicadores de Precipitacion en Cuencas</h2>
        <div id="contentPrecipitacion"></div>
        
        
        
        
        
        
        <script>
            $(document).ready(    
                function(){
                    callWS();
                }
            );
        </script>
        
        <script>
            
            
            function callWS(){
                    var uriWS="ws://localhost:8080/WorldBankClime2/wscuenca";
                    var miWebsocket= new WebSocket(uriWS);

                    miWebsocket.onopen=function(evento) {
                        console.log("Envío de requerimiento");
                        miWebsocket.send("hola");
                    } 

                    miWebsocket.onmessage=function(evento) {
                        console.log("Recepción de respuesta");
                        var response = evento.data;
                        
                        var array = response.split(",");
                        var temp = array[0];
                        var prec = array[1];
                        
                        
                        $("#contentTemperatura").html(temp);
                        $("#contentPrecipitacion").html(prec);
                    }
            }
            
            setInterval(
                    
                function(){ 
                    callWS();
                }
                
            ,3000);
            
        </script>
        
        
        
    </body>
</html>
