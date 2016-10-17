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
@WebServlet(name = "pruebFormulario", urlPatterns = {"/pruebFormulario"})
public class pruebFormulario extends HttpServlet {

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
         PrintWriter out = response.getWriter();
        cabecera(request,response);
        out.println("<form action=\"pruebFormulario\" method=\"post\">");
        out.println("<p>Hola</p>");
        
        if (request.getParameter("enviar") != null) {
           out.println("<p> Le hemos dado a enviar </p>"); 
       }else if(request.getParameter("enviar2") != null) {
            out.println("<p>no le hemos dado a enviar2</p>");
             }else if(request.getParameter("enviar2") == null && request.getParameter("enviar") == null) {
        
                 out.println("Estams en la pagina de inicio");
       }
        
       
        out.println("<td><input type=\"submit\" name=\"enviar\" value=\"Enviar\" /></td>");
        out.println("<td><input type=\"submit\" name=\"enviar2\" value=\"Enviar2\" /></td>");
         out.println("<td><input type=\"submit\" name=\"inicio\" value=\"inicio\" /></td>");
        
         
       
        
        out.println("</body>");
        out.println("</html>");
        
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
  private void cabecera(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");                                                      
        PrintWriter out = response.getWriter();
        
        response.setContentType("text/html;charset=UTF-8");
        out.println();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Strict//EN\"");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registro de usuarios</title>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"ESTILOS/estilo.css\" media=\"screen\" />");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
      
    }


  
}
