<%-- 
    Document   : Calculadora
    Created on : 11-oct-2016, 11:51:35
    Author     : AlfonsoTerrones
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form" action="Calculadora.jsp" method="post">
            <table>
                <tr>
                    <td>Primer valor</td>
                    <td><input type="text" name="operador1" size="10"/></td>
                    <td>Segundo valor</td>
                    <td><input type="text" name="operador2" size="10"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="operacion" value="Sumar"/>Sumar</td>
                    <td><input type="checkbox" name="operacion" value="Restar"/>Restar</td>
                    <td><input type="checkbox" name="operacion" value="Multiplicar"/>Multiplicar</td>
                    <td><input type="checkbox" name="operacion" value="Dividir"/>Dividir</td>
                </tr>                
                <tr>
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar"/></td>
                    <td colspan="2"><input type="submit" name="borrar" value="Borrar" /></td>
                </tr>
            </table>
        </form>
        <%
          int resultado=0;
            if(request.getParameter("enviar") != null){
                 Calendar c1 = GregorianCalendar.getInstance();
                
               try{
                   int valor1=Integer.parseInt(request.getParameter("operador1"));
                   int valor2=Integer.parseInt(request.getParameter("operador2"));
                   
                   switch(request.getParameter("operacion")){
                       case "Restar":
                            resultado=valor1-valor2;
                             %> <br/> <h3>El resultado de la resta es :<%=resultado%></h3><%
                        break;
                        
                        case "Sumar":
                            resultado=valor1+valor2;
                             %> <br/> <h3>El resultado de la suma es :<%=resultado%></h3><%
                        break;
                        
                        case "Dividir":
                            if(valor2==0){
                               %> <br/> <h3>No puedes dividir por 0</h3><%
                            }else{
                            resultado=valor1/valor2;

                            %> <br/> <h3>El resultado de la division es :<%=resultado%></h3><%
                            }           
                        break;
                        
                        case "Multiplicar":
                            resultado=valor1*valor2;
                            %> <br/> <h3>El resultado de la multiplicacion es :<%=resultado%></h3><%
                        break;
                        
                         default: 

                            %> <br/> <h3>No has seleccionado ninguna operación!</h3><%
                        }
                    
               
               
               
               
               
               
               
               } catch (NumberFormatException ex) {
               %><br/> <h3>Tienes que introducir numeros!!</h3> <%
               }
               System.out.println("Fecha actual: "+c1.getTime().toLocaleString());

%><br/> <h3>Fecha actual es:<%=c1.getTime().toLocaleString()%></h3> <%
    
    
               %>
               Navegadores permitidos: <%=request.getHeader("user-agent")%> 
               <%}
               %>
                out.println("<a id=\"volver\" href=\"index.html\">Volver</a>");
                
                       
                   
                
               
               
               
               
               
               
               
               
               
               
               
               
               
               
                
                
               
    </body>
</html>
