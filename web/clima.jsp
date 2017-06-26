<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Cuenca</th>
                    <th>Enero</th>
                    <th>Febrero</th>
                    <th>Marzo</th>
                    <th>Abril</th>
                    <th>Mayo</th>
                    <th>Junio</th>
                    <th>Julio</th>
                    <th>Agosto</th>
                    <th>Setiembre</th>
                    <th>Octubre</th>
                    <th>Noviembre</th>
                    <th>Diciembre</th>
                    <th>Anual</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cuenca" items="${listTemperatura}">
                    <tr>
                        <td>${cuenca.id_cuenca}</td>
                        <td>${cuenca.ene_value}</td>
                        <td>${cuenca.feb_value}</td>
                        <td>${cuenca.mar_value}</td>
                        <td>${cuenca.abr_value}</td>
                        <td>${cuenca.may_value}</td>
                        <td>${cuenca.jun_value}</td>
                        <td>${cuenca.jul_value}</td>
                        <td>${cuenca.ago_value}</td>
                        <td>${cuenca.set_value}</td>
                        <td>${cuenca.oct_value}</td>
                        <td>${cuenca.nov_value}</td>
                        <td>${cuenca.dic_value}</td>
                        <td>${cuenca.anual_value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <h2>${msg}</h2>
        </div>
    </body>
</html>
