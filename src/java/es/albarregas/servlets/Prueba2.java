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
@WebServlet(name = "Prueba2", urlPatterns = {"/Prueba2"})
public class Prueba2 extends HttpServlet {

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
            
            
           // if(request.getParameter("Modificar") != null){
            //if(request.getParameter("Modificar").equals("Modificar")){
             //   metodo(request,response);
            //}
            //}else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Prueba2</title>");            
            out.println("</head>");
            out.println("<form id=\"DatosPersonales\" method=\"get\">");
            out.println("<body>");
            out.println("<p>nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            out.println(request.getParameter("sexo"));
            out.println("<input type=\"radio\" name=\"sexo\" checked=\"checked\" value=\""+request.getParameter("sexo")+"\">");
            out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Modificar\" value=\"Modificar\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
            out.println("</body>");
            out.println("</form>");
            out.println("</html>");
            }
       // }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Estamos en el get");
            //Aqui me aparece null, pero si fuera un type="text" si me saldria sin problema
            out.println(request.getParameter("nombre"));
            out.println(request.getParameter("sexo"));
            
        }
    }

   
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

    
    public void metodo (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Prueba2</title>");            
            out.println("</head>");
                out.println("<form id=\"DatosPersonales\" method=\"post\">");

                out.println("Estamos en el metodo");
                 out.println(request.getParameter("sexo"));
                out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Volver\" value=\"Volver\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
       out.println("</body>");
        out.println("</body>");     
       out.println("</form>");
            out.println("</html>");
        }
    }  
    
}