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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        
        <style type="text/css">
            #fondo{
                background: #F5F5F5;
            }
        </style>
        
    </head>
    <body id="fondo">
        
        <div class="page-header">
            <h2 style="text-align: center">Banco Mundial - Indicadores del clima</h2>
        </div>
        
        
        <br/>
        
        <div class="panel panel-success">
            <!-- Default panel contents -->
            <div class="panel-heading"><h3>Indicadores de Temperatura en Cuencas</h3></div>
            <div id="contentTemperatura"></div> 
        </div>
        <br/>
        <br/>
        <div class="panel panel-success">
            <!-- Default panel contents -->
            <div class="panel-heading"><h3>Indicadores de Precipitación en Cuencas</h3></div>    
            <div id="contentPrecipitacion"></div>   
        </div>
        
        
        
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
