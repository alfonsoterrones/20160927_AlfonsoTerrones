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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "ContadorCookie", urlPatterns = {"/ContadorCookie"})
public class ContadorCookie extends HttpServlet {


  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Cookie cookie=null;
        
        Cookie cookies[]= request.getCookies();
        
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("contador")){
                    
                    cookie=cookies[i];
                }
            }
        }
    
        if(cookies==null){
            cookie=new Cookie("contador","0");
        }else if(request.getParameter("borrar") != null){
            cookie.setValue("0");
   
            
        }
        
        int contador=Integer.parseInt(cookie.getValue());
        cookie.setValue(Integer.toString(contador + 1));
        cookie.setMaxAge(604800);
        response.addCookie(cookie);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Strict//ES\"");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contador de visitas</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"ESTILOS/estilo.css\" media=\"screen\" />");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>N?mero de veces que se ha visitado la p?gina " + cookie.getValue() + "</h2>");
        out.println("<br />");
        out.println("<form action=\"ContadorCookie\" method=\"post\">");
        out.println("<input type=\"submit\" name=\"borrar\" value=\"Eliminar cookie\" class=\"boton\" />");
        out.println("<input type=\"submit\" name=\"recarga\" value=\"Recargar\" class=\"boton\" />");
        out.println("</form>");
        out.println("<br />");
        out.println("<a href=\"" + request.getContextPath() + "\">Volver</a>");
        out.println("</body>");
        out.println("</html>");
        
        
        
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        doGet(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
