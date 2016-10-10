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
@WebServlet(name = "FormularioMartes04102016", urlPatterns = {"/FormularioMartes04102016"})
public class FormularioMartes04102016 extends HttpServlet {
//Nos ayudara a cambiar de ventana
int semaforo=0;



//Los utilizamos al mostrar los datos
 String [] checkbox;
 String [] selectmultiple;

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
          
           //SI no entramos en modificar datos, vemos el formulario
            if(semaforo==2){
                datos(request,response);
            }
           
///////--------------------------FORMULARIO-----------------------------          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");      
            out.println("<link rel=\"stylesheet\" href=\"CSS/estiloDatosPersonales.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<p id=\"Titulo\"><i>Datos personales</i></p>");
         
                if(request.getParameterValues("nombre") == null){
                    out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\"\"></p>");
                }else{
                    out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
                }
                if(request.getParameterValues("apellido") == null){
                    out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\"\"></p>");
                }else{
                    out.println("<p>apellido: <input type=\"text\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
                }
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
                 
             out.println("<table>");
            out.println("<tr>");
            out.println("<td><label>Preferencias</label></td>");
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
            semaforo++;
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
         }//ELSE
    }//TRY
}//METODO
    
     public void datos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
//------------------------------------------CARGAMOS EL FORMULARIO PERO ESTA VE OCULTO PARA NO PERDER LOS DATOS-------------------------------------------------           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");            
            out.println("</head>");
            out.println("<body>");
           if(request.getParameterValues("nombre") == null){
               out.println("<p><input type=\"hidden\" name=\"nombre\" value=\"\"></p>");
           }else{
            out.println("<p><input type=\"hidden\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
           }
            if(request.getParameterValues("apellido") == null){
               out.println("<p><input type=\"hidden\" name=\"apellido\" value=\"\"></p>");
           }else{
            out.println("<p><input type=\"hidden\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
           }
            if("Mujer".equals(request.getParameter("sexo"))){
            out.println("<td><input type=\"radio\" name=\"sexo\" style=\"display:none;\" value=\"Hombre\" /></td>");
            out.println("<td><label></label><input type=\"radio\" name=\"sexo\" style=\"display:none;\" checked=\"checked\" value=\"Mujer\" /></td>");        
        }else{         
            out.println("<td><input type=\"radio\" name=\"sexo\" style=\"display:none;\" checked=\"checked\" value=\"Hombre\"/></td>");
            out.println(" <td><label></label><input type=\"radio\" style=\"display:none;\" name=\"sexo\"  value=\"Mujer\"/></td>");
        }
             if(request.getParameterValues("checkbox") == null){
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Deporte\" style=\"display:none;\"></td>");            
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Lectura\" style=\"display:none;\"></td>");     
            out.println("<td> <input type=\"checkbox\" name=\"checkbox\" value=\"Cine\" style=\"display:none;\"></td>");     
            out.println("<td><input type=\"checkbox\" name=\"checkbox\" value=\"Viajes\" style=\"display:none;\"></td>");           
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
           }//MENU
        }//FOR
                 
            
            
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadodeporte+" value=\"Deporte\" style=\"display:none;\"></td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadolectura+" value=\"Lectura\" style=\"display:none;\"></td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadocine+" value=\"Viajes\" style=\"display:none;\"></td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadoviajes+" value=\"Viajes\" style=\"display:none;\"></td>");
        
        }//ELSE
            
            out.println("<p id=\"Titulo\"><i>Todo correcto, informacion enviada</i></p>");
            Enumeration<String> nombres  = request.getParameterNames();
            while(nombres.hasMoreElements()){
                    String nombre = nombres.nextElement();
                    
                    if(!nombre.startsWith("Env")){
                        if(!nombre.startsWith("Limp")){
                            if(nombre.startsWith("Passwo")){  
                                out.println("LA CONTRASE?A HA SIDO ENVIADA<br/>");
                            }else{
                                    if(nombre.startsWith("check")){                            
                                        out.println("LAS AFICIONES SON: ");
                                        selectmultiple = request.getParameterValues("checkbox");
                                        for(String j: selectmultiple){
                                            out.println(j+" ");
                                        }
                                        out.println("<br/>");
                                    }if(nombre.startsWith("dia")){                            
                                        out.println("FECHA DE NACIMIENTO: "+request.getParameter("dia")+" / "+request.getParameter("mes")+" / "+request.getParameter("anio")+"<br/>");                                     
                                    }   
                                    else{
                                        if(nombre.startsWith("mes") || nombre.startsWith("anio") || nombre.startsWith("checkbox")){
                                            
                                        }else{  
                                        out.println(nombre.toUpperCase()+": "+request.getParameter(nombre)+"<br/>");
                                        }
                                    }//ELSE
                                }//ELSE
                            }//IF                       
                    }else{                       
                    }//ELSE
                }//MENU
            
       semaforo=semaforo-2;
 out.println("<BR><div id=\"botones\">  <input type=\"submit\" name=\"Volver\" value=\"Volver\"/>");        
 out.println("<input type=\"button\" value=\"Mandar\" onclick=\"window.location.href='index.html';\"/>");

        }//TRY
     }//DATOS
     
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
