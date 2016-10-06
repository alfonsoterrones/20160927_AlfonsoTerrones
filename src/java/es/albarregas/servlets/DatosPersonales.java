/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "DatosPersonales", urlPatterns = {"/DatosPersonales"})
public class DatosPersonales extends HttpServlet {
    String nombre="";
    String apellido="";
    String contrasenia="";
    String estado="";
    String dia="";
    String mes="";
    String anio="";
    String usuario="";
    String [] valorescheckbox;
    
int[]errores=new int[3];

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DatosPersonales</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatosPersonales at " + request.getContextPath() + "</h1>");
            //corregirFormulario(request,response);
            out.println("</body>");
            out.println("</html>");
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            //---------------Pasamos parametros
            
              corregirFormulario(request,response);    
               
               
            
            
            
             /*  response.setContentType("text/html;charset=UTF-8");
               out.print(request.getParameter("Enviar"));
               
                if(request.getParameter("Modificar").equals("Modificar")){
                        out.println("<p> nombre:  "+request.getParameter("nombre")+"</p>");
                        out.println("<p> apellidos:  "+request.getParameter("apellido")+"</p>");
                        out.println("<p> contrase?a:  "+request.getParameter("contrasenia")+"</p>");                    
*/
 
                
   
    
    
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               PrintWriter out = response.getWriter();
               response.setContentType("text/html;charset=UTF-8");
              
               nombre=request.getParameter("nombre");
               apellido=request.getParameter("apellido");
              contrasenia=request.getParameter("contrasenia");
               estado=request.getParameter("estado"); 
              dia=request.getParameter("dia");
        
               mes=request.getParameter("mes");
               
                anio="1980";
                 
                  usuario=request.getParameter("usuario");
                  
                  
               
               
               
               
               
                if(request.getParameter("Enviar").equals("Enviar")){
                    if(!"".equals(request.getParameter("nombre")) && !"".equals(request.getParameter("apellido"))  && !"".equals(request.getParameter("contrasenia")) ){                  
                    
                        
                        
                        
                        
                        

                       
                       
                            Enumeration<String> nombres  = request.getParameterNames();
            String [] checkbox;
            String [] selectmultiple;
            
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>formulario completo</title>");    
            out.println("</head>");
            out.println("<body>");
            out.println("<form id=\"DatosPersonales\" method=\"get\">");
            out.println("<h1>Datos recibidos del formulario</h1>");
            
            
                while(nombres.hasMoreElements()){
                    String nombre = nombres.nextElement();
                    
                    if(!nombre.startsWith("Env")){
                        if(!nombre.startsWith("Limp")){
                            if(nombre.startsWith("Passwo")){  
                                out.println("LA CONTRASE?A HA SIDO ENVIADA<br/>");
                            }else{
                                if(nombre.startsWith("carn")){
                                    out.println("CARNETS QUE TIENE: ");
                                    checkbox = request.getParameterValues("carnet");
                                    for(String i: checkbox){
                                        out.println(i);
                                    }  
                                    out.println("<br/>");
                                }else{
                                    if(nombre.startsWith("aficio")){                            
                                        out.println("LAS AFICIONES SON: ");
                                        selectmultiple = request.getParameterValues("aficiones");
                                        for(String j: selectmultiple){
                                            out.println(j);
                                        }
                                        out.println("<br/>");
                                    }else{
                                        out.println(nombre.toUpperCase()+": "+request.getParameter(nombre)+"<br/>");
                                    }
                                }
                            }
                        
                    }else{
                        out.println("EL FORMULARIO HA SIDO ENVIADO<br/>");
                    }
                }   
                  
                
        }
                out.println("<input type=\"submit\" name=\"Modificar\" value=\"Modificar\"/>");
                out.println(" <a href=\"index.html\">Volver</a>");
                out.println("</form>");
            out.println("</body>");
            out.println("</html>");
                  
    
               }else{
                   if("".equals(request.getParameter("nombre"))){
                  errores[0]=1;
                    }
                  if("".equals(request.getParameter("apellido"))){
                  errores[1]=2;
                    }
                  if("".equals(request.getParameter("contrasenia"))){
                  errores[2]=3;
                    }
                  corregirFormulario(request,response);
               }
          }else{
                
          }
    
    }
    
    public void corregirFormulario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TODO supply a title</title>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"CSS/estiloDatosPersonales.css\">");
        out.println("</head>");
        out.println("<body>");
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
        out.println("<form id=\"DatosPersonales\" method=\"post\">");
        out.println("<p id=\"Titulo\" ><i>informacion personal</i></p>");
        out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+nombre+"\"></p>");
        out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\""+apellido+"\"></p>");
        out.println("<label>Sexo:</label>");
        //out.println(estado);out.println(estado);out.println(estado);out.println(estado);
        //if(estado.equals("Hombre")){
          //  out.println("<label>Hombre</label><input type=\"radio\" name=\"estado\" checked=\"checked\"></p>");
            //out.println("<label>Mujer</label><input type=\"radio\" name=\"estado\" value=\""+estado+"\"></p>");
        //}if(estado.equals("Mujer")){
          //  out.println("<label>Mujer</label><input type=\"radio\" name=\"estado\" checked=\"checked\"></p>");
          //  out.println("<label>Hombre</label><input type=\"radio\" name=\"estado\" value=\""+estado+"\"></p>");
        //}else{
         //   out.println("<label>Hombre</label><input type=\"radio\" name=\"estado\" value=\""+estado+"\"></p>");
          //  out.println("<label>Mujer</label><input type=\"radio\" name=\"estado\" value=\""+estado+"\"></p>");
            
        //}
        
        
        String valorestadoHombre=" ";
        String valorestadoMujer=" ";
        switch(estado){
            case "Hombre":
                        valorestadoHombre="checked=\"checked\"";
                        
                break;               
            case "Mujer":
                        valorestadoMujer="checked=\"checked\"";
                break;
          
       
        }
        
        out.println("<label>Hombre</label><input type=\"radio\" name=\"estado\" "+valorestadoHombre+"/></p>");
        out.println("<label>Mujer</label><input type=\"radio\" name=\"estado\" "+valorestadoMujer+"/></p>");
        
       
        
       
        
 	out.println("<label>dia: </label><input type=\"number\" name=\"dia\" min=\"1\" max=\"31\" value=\""+dia+"\" required=\"required\"/>");
        out.println("<label>mes: </label><input type=\"number\" name=\"mes\" min=\"1\" max=\"12\" value=\""+mes+"\" required=\"required\"/>");
       out.println("<label>anio: </label><input type=\"number\" name=\"anio\" min=\"1900\" max=\"2016\" value=\""+anio+"\" required=\"required\"/>");

        out.println("<p id=\"Titulo\" ><i>Datos de acceso</i></p>");
        out.println("<p>* usuario: <input type=\"text\" name=\"usuario\" value=\""+usuario+"\"></p>");
        out.println("<p>* contrase&ntilde;a: <input type=\"text\" name=\"contrasenia\" value=\""+contrasenia+"\"></p>");
        out.println("<p id=\"Titulo\" ><i>informacion General</i></p></p>");
        String checkeadodeporte = " ";
        String checkeadolectura = " ";
        String checkeadoviajes = " ";
        String checkeadocine = " ";
        
        out.println("<input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/>");
        
           
        String [] valorescheckbox = request.getParameterValues("checkbox");
        
        
        /*if(!"null".equals(request.getParameterValues("checkbox"))){
         out.println("Cantidad de parametros : "+ valorescheckbox.length);
        out.println("antes del for");
       
        for(String valor : valorescheckbox){
            out.println("entramos en el for del switch");
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
           out.println("salimos del switch");
       }out.println("salimos del for");
        }
*/
       out.println(" <p>Deporte: <input type=\"checkbox\" name=\"deporte\" "+checkeadodeporte+"/></p>");
       out.println("<p>Lectura: <input type=\"checkbox\" name=\"lectura\" "+checkeadolectura+"/></p>");
       out.println("<p>Cine: <input type=\"checkbox\" name=\"cine\" "+checkeadocine+"/></p>");
       out.println("<p>Viajes: <input type=\"checkbox\" name=\"viajes\" "+checkeadoviajes+"/></p>");
       
      out.println("<input type=\"button\" value=\"reset\" onclick = \"location='"+request.getContextPath()+"/HTML/DatosPersonal.html'\"/>");
   
      out.println("<input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/>");
      
      


        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
}