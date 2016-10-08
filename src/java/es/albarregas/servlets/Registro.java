/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "Prueba", urlPatterns = {"/Prueba"})
public class Registro extends HttpServlet {
    int[]errores=new int[3];
    boolean controlador=true;

        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
           out.println(revisasErrores(request, response));
           
           if(!revisasErrores(request, response)){
                 out.println("Entramos");
                 
               for(int valor : errores){        
                switch(valor){
            case 1:
                out.println("<p id=\"Error\" ><h1>Error al introducir el nombre</h1></p>");
                break;
        
             case 2:
                out.println("<p id=\"Error\" ><h1>Error al intrducir el apellido</h1></p>");
                break;
        
             case 3:
                out.println("<p id=\"Error\" ><h1>Error al intrducir la contrase&ntilde;a</h1></p>");
                break;
        }
        }  
           errores[0]=0;
           errores[1]=0;
           errores[2]=0; 
           
           controlador=false;
           
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form id=\"DatosPersonales\" method=\"get\">");
            out.println("<p id=\"Titulo\"><i>Datos personales</i></p>");
            out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
            out.println("<table>");
            out.println("<tr>");
        //--------------------------------Aqui cargams el sexo------------------------------
        if("Mujer".equals(request.getParameter("sexo"))){
                out.println("<td><label>Sexo</label></td>");
                out.println("<td><input type=\"radio\" name=\"sexo\" >Hombre</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td> </td>");
                out.println("<td><input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\""+request.getParameter("sexo")+"\">Mujer</td>");
                out.println("</tr>");
                out.println("</table>");
        }else{
                out.println("<td><label>Sexo</label></td>");
                out.println("<td><input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\""+request.getParameter("sexo")+"\">Hombre</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td> </td>");
                out.println("<td><input type=\"radio\" name=\"sexo\" >Mujer</td>");
                out.println("</tr>");
                out.println("</table>");
        }
//-----------------------------------------------------------------------------------------------

        out.println("<BR><label>Fecha de nacimiento:</label>");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"dia\" min=\"1\" max=\"31\" value=\""+request.getParameter("dia")+"\">");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"mes\" min=\"1\" max=\"12\" value=\""+request.getParameter("mes")+"\">");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"anio\" min=\"1900\" max=\"2016\" value=\""+request.getParameter("anio")+"\"></p>");
        out.println("<BR><p id=\"Titulo\"><i>Datos de acceso</i></p>");
        out.println("<p>usuario: <input type=\"text\" name=\"usuario\" value=\""+request.getParameter("usuario")+"\"></p>");
        out.println("<p>contrase&ntilde;a: <input type=\"password\" name=\"contrasenia\" value=\""+request.getParameter("contrasenia")+"\"></p>");
        out.println("<BR><BR><p id=\"Titulo\" ><i>Informacion General</i></p>");
        
       if(request.getParameterValues("checkbox") ==null){
        out.println("<table>");
        out.println("<tr>");
        out.println("<td><label>Preferencias</label></td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Deporte\">Deporte</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> </td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Lectura\">Lectura</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> </td>");
        out.println("<td> <input type=\"checkbox\" name=\"checkbox\" value=\"Cine\">Cine</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> </td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Viajes\" >Viajes</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
       }
        String checkeadodeporte="";
        String checkeadolectura="";
        String checkeadocine="";
        String checkeadoviajes="";
        String [] valorescheckbox = request.getParameterValues("checkbox");
        
        
        for(String valor:valorescheckbox){
             switch (valor){
               case "Deporte":
                   checkeadodeporte="checked=\"checked\"";
                   break;
               case "Lectura":
                   checkeadolectura="checked=\"checked\"";
                   break;
               case "Cine":
                   checkeadocine="checked=\"checked\"";
                   break;
               case "Viajes":
                   checkeadoviajes="checked=\"checked\"";
                   break;
           }
        }
        out.println("<table>");
        out.println("<tr>");
        out.println("<td><label>Preferencias</label></td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Deporte\" value=\""+request.getParameter("checkbox")+"\" "+checkeadodeporte+"/>Deporte</td>");         
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> </td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Lectura\" value=\""+request.getParameter("checkbox")+"\" "+checkeadolectura+"/>Lectura</td>");  
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> </td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Cine\" value=\""+request.getParameter("checkbox")+"\" "+checkeadocine+"/>Cine</td>");  
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> </td>");
        out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Vieajes\" value=\""+request.getParameter("checkbox")+"\" "+checkeadoviajes+"/>Viajes</td>");  
        out.println("</tr>");
        out.println("</table>");
        out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
           
             
        }else{
               System.out.println("Estamos en el else");
               
            pantallaDeHaHabidoUnError(request,response);
           }
        }//if
    }

 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
             
             out.println("Estamos En el get");
            
             
             out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
             
             
        if(request.getParameter("Enviar").equals("Enviar")){
             
            out.println("Estamos dentro de la pregunta del get");
            processRequest(request,response);
       
         }
        
         }
    }


    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        processRequest(request, response);
    }


    
    @Override
    public String getServletInfo() {
        
        return "Short description";
    }



protected boolean revisasErrores(HttpServletRequest request, HttpServletResponse response)
{
       boolean aux=false;
            
                  if("".equals(request.getParameter("nombre"))){
                  errores[0]=1;
                  aux=true;
                  
                  }
                  if("".equals(request.getParameter("apellido"))){
                  errores[1]=2;
                  aux=true;
                  
                  }
                  if("".equals(request.getParameter("contrasenia"))){
                  errores[2]=3;
                  aux=true;
     
                  }
                  return aux;
                  //pantallaDeHaHabidoUnError(request,response);
                        

}

protected void pantallaDeHaHabidoUnError(HttpServletRequest request, HttpServletResponse response)
             
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        try (PrintWriter out = response.getWriter()) {
         
         
       
         
         System.out.println("Estamos en el metodoPantalla ha habido");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<body>");
            if(request.getParameter("nombre").equals("")){
                out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\" \"></p>"); 
            }
            out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            
            if(request.getParameter("apellido").equals("")){
                out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\" \"></p>"); 
            }
            out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
            
            if(request.getParameter("contrasenia").equals("")){
                out.println("<p>contrasenia: <input type=\"password\" name=\"contrasenia\" value=\" \"></p>"); 
            }
            out.println("<p>contrasenia: <input type=\"text\" name=\"contrasenia\" value=\""+request.getParameter("contrasenia")+"\"></p>");
            
            out.println("<title>Ha habido un error</title>"); 
            out.println("<title>metodoHaHabidoErrores</title>");
            out.println("</body>");
            out.println("Ha habido un error");
            out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/>");
            out.println("</form>");       
            out.println("</html>");
     
}
}
}


