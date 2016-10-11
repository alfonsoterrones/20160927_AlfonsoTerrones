<%-- 
    Document   : Saludo
    Created on : 10-oct-2016, 17:27:54
    Author     : AlfonsoTerrones
--%>

<%@page import="java.time.LocalTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String var = "";
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        int hora = LocalTime.now().getHour();
        String tiempo="";
        
        if(hora>21 && hora<6){
            tiempo="noches";
        }
         if(hora>6 && hora<13){
            tiempo="dias";
        }
         if(hora>13 && hora<21){
            tiempo="tardes";
        }
         
        if(sexo.equals("Hombre")){
            sexo = "señor";
        }else{
            sexo = "señora";
        }
        %>
        
        <h1>Hola, buenas <%=tiempo%> <%=sexo%> <%=nombre%></h1>
    </body>
</html>
