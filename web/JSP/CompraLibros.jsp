<%-- 
    Document   : PruebaMiaSesiones
    Created on : 18-oct-2016, 23:11:42
    Author     : AlfonsoTerrones
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="es.albarregas.beans.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de libros</title>
        <link rel="stylesheet" href="../CSS/estiloLibreria.css"/>

    </head> 
    <body>
        <%
            boolean iguales=false;
            HttpSession sesion = request.getSession(true);
            ArrayList<Libro> libros = new ArrayList();
            Libro libro = new Libro();

            if (sesion.getAttribute("libro") != null) {//si la sesion esta creada el array recibe los valores de la sesion
                libros = (ArrayList<Libro>) sesion.getAttribute("libro");   //poasamos el array que hemos creado en la sesion al array libros
            } else {
                sesion.setAttribute("libros", libros);//creamos el atributo de libros en la sesion "sesion"

            }
            if (request.getParameter("Comprar") == null) {//si no pulsamos comprar entramos en el resto de botones
                if (request.getParameter("Aniadir") != null) {
                    if(request.getParameter("cantidad").matches(".*[a-zA-z].*")){//Si metemos alguna vocal en la caja de texto cantidad
                            %><p id='error'>Has introducido letras en el codigo</p><%
                        }else{//si esta todo bien sequimos
                            if (request.getParameter("libros") != null) {    //Si seleccionamos un libro                          
                                if (request.getParameter("cantidad").equals("0") || request.getParameter("cantidad").equals("")) { //comprobamos que la cantidad no sea 0 ni vacia
                                    %><p id='error'>  La cantidad es incorrecta</p><%
                                }else {
                                    libro.setNombre(request.getParameter("libros"));//guardamos el valor de el nombre en el objeto libro
                                    libro.setCantidad(Integer.parseInt(request.getParameter("cantidad"))); //guardamos el valor de la cantidad en el objeto                                     
                                        for (Libro l : libros) {//recorremos el bucle para ver si el libro ya lo habiamos añadido en la lista anteriormente
                                            if(l.getNombre().equals(request.getParameter("libros"))){//aqui comprobamos si el nombre del libro esta ya en la cesta
                                                int cantidad= Integer.parseInt(request.getParameter("cantidad"));//pasamos el strig de cantidad a un int
                                                l.setCantidad(libro.getCantidad() + cantidad);//actualizamos el numero de libros en la cesta
                                                
                                                %><p>Libro añadido a la cesta</p><%
                                                %><p>Este libro ya lo tenias en la cesta, ahora tienes <%=l.getCantidad()%><%
                                                %> libros con el nombre "<%=libro.getNombre()%>"</p><%
                                               
                                                iguales=true;                                                
                                                }else{ //si el libro añadido no lo hemos metido anteriormente no hay que hacer nada                                                    
                                                }//else
                                        }//for                               
                                            if(iguales){//si ya existia el libro no haceos nada porq ya lo hicimos anteriormente
                                         iguales=false;                                                                                                                           
                                    }else{//si no son iguales añadimos el nuevo libro a la cesta
                                        iguales=false;
                                        libros.add(libro);                                                                              
                                        %><p>Libro añadido a la cesta</p><%
                                        %><p>Hemos añadido <%=libro.getCantidad()%><%
                                        %> libros  con el nombre "<%=libro.getNombre()%>"</p><%
                                    }//else
                                    sesion.setAttribute("libro", libros);                       
                                }//else
                            }else {   
                                %><p id='error'> No hay libros seleccionados</p><%
                            }//else
                        }//else
                }//if

        %>

        <form action="CompraLibros.jsp" method="post" >
            <h2>Compra de libros</h2>
            <IMG SRC="../IMAGENES/libros.jpg" WIDTH=178 HEIGHT=180 ALT="Obra de K. Haring"><br/>
            <select name="libros" multiple="multiple">
                <option value="Juego de Tronos">Juego de Tronos</option>
                <option value=" El alquimista">El corazon del oceano</option>
                <option value="Cien años de soledad ">Los pilares de la Tierra</option>
                <option value="Harry Potter">Africa en el corazon</option>
                <option value="Campos de fresa">Campos de fresa</option>
                <option value="El niño del pijama de rayas">El niño del pijama de rayas</option>
            </select><br/>
            <br/>
            Cantidad: <input type="text" name="cantidad"/><br/>
            <input type="submit" name="Aniadir" value="Aniadir"/>
            <input type="reset"  name="Limpiar" value="Limpiar"/>
            <input type="submit" name="Comprar" value="Comprar"/>
        </form>
        <br/> <br/>
        <form method="POST" action="../index.html">
            <input type="submit" value="Volver"/>
        </form>  

<%}         else {//Hemos pulsado comprar
                
                ArrayList<Libro> librosComprados = (ArrayList<Libro>) sesion.getAttribute("libro");//Nos creamos un array nuevo donde metemos los libros ya comprados
                    if(libros.isEmpty()) {//si esta vacio nos muestra lo que hay dentro del if
                        %><h1>No has comprado aun ningun libro!</h1><%
                        %><form action="CompraLibros.jsp" method="post" ><%
                    }else{//si esta vacio nos muestra los libros
                        %><h1>Compra realizada</h1><%
                        %><b>Cantidad Libros</b><br/><%
                
                        for (Libro l : libros) {
                            %><%=l.getCantidad()%> <%
                            %><%=l.getNombre()%><br/><%
                        }
                    }
                    sesion.invalidate();
%>
        <br/>
        <form method="POST" action="../index.html">
            <input type="submit" value="Volver"/>
        </form>  
        <% } %>
    </body>
</html>