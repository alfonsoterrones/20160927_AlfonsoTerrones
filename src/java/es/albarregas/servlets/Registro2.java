
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Registro2", urlPatterns = {"/Registro2"})
public class Registro2 extends HttpServlet {
     int[]errores=new int[3];
      boolean semaforo=true;
      
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        iniciamosFormulario(request,response);
        }
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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void iniciamosFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
     
      
            if(revisasErrores(request,response) && semaforo){
                pantallaDeError(request,response);
            }else{
                
            semaforo=true;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p id=\"Titulo\"><i>Datos personales</i></p>");
            out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
        
            
         if("Mujer".equals(request.getParameter("sexo"))){
               out.println("<table>");
        out.println("<tr>");
            out.println("<td><label>Sexo</label></td>");
            out.println("<td><input type=\"radio\" name=\"sexo\" value=\"Hombre\"/>Hombre</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td><label></label><input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\"Mujer\"/>Mujer</td>");
        out.println("</tr>");
out.println("</table>");
        }else{
               out.println("<table>");
       out.println(" <tr>");
            out.println("<td><label>Sexo</label></td>");
            out.println("<td><input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\"Hombre\"/>Hombre</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
           out.println(" <td><label></label><input type=\"radio\" name=\"sexo\"  value=\"Mujer\"/>Mujer</td>");
        out.println("</tr>");
out.println("</table>");
         }
           out.println("<BR><label>Fecha de nacimiento:</label>");
                out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"dia\" min=\"1\" max=\"31\" value=\""+request.getParameter("dia")+"\">");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"mes\" min=\"1\" max=\"12\" value=\""+request.getParameter("mes")+"\">");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"anio\" min=\"1900\" max=\"2016\" value=\""+request.getParameter("anio")+"\"></p>");
        out.println("<BR><p id=\"Titulo\"><i>Datos de acceso</i></p>");
        out.println("<p>usuario: <input type=\"text\" name=\"usuario\" value=\""+request.getParameter("usuario")+"\"></p>");
        out.println("<p>contrase&ntilde;a: <input type=\"password\" name=\"contrasenia\" value=\""+request.getParameter("contrasenia")+"\"></p>");
        out.println("<BR><BR><p id=\"Titulo\" ><i>Informacion General</i></p>");
             
              if(request.getParameterValues("checkbox") == null){
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
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Viajes\">Viajes</td>");
        out.println("</tr>");
        out.println("</table>");
                  
                  
             
         }else{
      
        String checkeadodeporte=" ";
        String checkeadolectura=" ";
        String checkeadocine=" ";
        String checkeadoviajes=" ";
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
                 
            
            
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" "+checkeadodeporte+" value=\"Deporte\">Deporte</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" "+checkeadolectura+" value=\"Lectura\">Lectura</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td> <input type=\"checkbox\" name=\"checkbox\" "+checkeadocine+" value=\"Cine\">Cine</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" "+checkeadoviajes+" value=\"Viajes\">Viajes</td>");
        out.println("</tr>");
        out.println("</table>");
        }
        
        out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
            
            
            
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
        
      }
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
                  

}
    
        public void pantallaDeError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p id=\"Titulo\"><i>ERRORRRRRRRRRRRRRR</i></p>");
            out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
        if("Mujer".equals(request.getParameter("sexo"))){
               out.println("<table>");
        out.println("<tr>");
            out.println("<td><label>Sexo</label></td>");
            out.println("<td><input type=\"radio\" name=\"sexo\" value=\"Hombre\"/>Hombre</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td><label></label><input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\"Mujer\"/>Mujer</td>");
        out.println("</tr>");
out.println("</table>");
        }else{
               out.println("<table>");
       out.println(" <tr>");
            out.println("<td><label>Sexo</label></td>");
            out.println("<td><input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\"Hombre\"/>Hombre</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
           out.println(" <td><label></label><input type=\"radio\" name=\"sexo\"  value=\"Mujer\"/>Mujer</td>");
        out.println("</tr>");
out.println("</table>");
            
        }
             out.println("<BR><label>Fecha de nacimiento:</label>");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"dia\" min=\"1\" max=\"31\" value=\""+request.getParameter("dia")+"\">");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"mes\" min=\"1\" max=\"12\" value=\""+request.getParameter("mes")+"\">");
        out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"anio\" min=\"1900\" max=\"2016\" value=\""+request.getParameter("anio")+"\"></p>");
        out.println("<BR><p id=\"Titulo\"><i>Datos de acceso</i></p>");
        out.println("<p>usuario: <input type=\"text\" name=\"usuario\" value=\""+request.getParameter("usuario")+"\"></p>");
        out.println("<p>contrase&ntilde;a: <input type=\"password\" name=\"contrasenia\" value=\""+request.getParameter("contrasenia")+"\"></p>");
        out.println("<BR><BR><p id=\"Titulo\" ><i>Informacion General</i></p>");
       out.println("<table>");
        out.println("<tr>");
            out.println("<td><label>Preferencias</label></td>");
            
            
                  if(request.getParameterValues("checkbox") == null){
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
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Viajes\">Viajes</td>");
        out.println("</tr>");
        out.println("</table>");
                  
                  
             
         }else{
        
        String checkeadodeporte=" ";
        String checkeadolectura=" ";
        String checkeadocine=" ";
        String checkeadoviajes=" ";
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
                 
            
            
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" "+checkeadodeporte+" value=\"Deporte\">Deporte</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" "+checkeadolectura+" value=\"Lectura\">Lectura</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td> <input type=\"checkbox\" name=\"checkbox\" "+checkeadocine+" value=\"Cine\">Cine</td>");
        out.println("</tr>");
        out.println("<tr>");
            out.println("<td> </td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" "+checkeadoviajes+" value=\"Viajes\">Viajes</td>");
        out.println("</tr>");
        out.println("</table>");
        }
        
        
        out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            semaforo=false;
            
        
        }
        }
    
    
}

