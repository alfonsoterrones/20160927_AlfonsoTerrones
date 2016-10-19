/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.beans.Objeto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.beans.Objeto;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "TresUsuarioConSesiones", urlPatterns = {"/TresUsuarioConSesiones"})
public class TresUsuarioConSesiones extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
          
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"get\">");
            out.println("<title>Servlet Prueba</title>");      
            out.println("<link rel=\"stylesheet\" href=\"CSS/estiloDatosPersonales.css\">");
            out.println("</head>");
            out.println("<body>");
            
            if (request.getParameter("enviar") != null) {
                out.println("<p id=\"Titulo\"><i>Datos pasados</i></p>");
                
                HttpSession session = request.getSession(true);
              
                ArrayList<Objeto> usuarios = (ArrayList)session.getAttribute("usuarios");
              
                int contador=0;
                
                for(Objeto usuario : usuarios){
                contador++;
                out.println("<h1>Usuario "+contador+"</h1>");
                out.println("<p> nombre:"+usuario.getNombre()+"</p>");
                out.println("<p> id:"+usuario.getId()+"</p>");
                out.println("<p> edad:"+usuario.getEdad()+"</p>");
                
                }
                
            }else{
            if (request.getParameter("Enviar") != null) {
                HttpSession session;
                session = request.getSession();
                out.println("<p id=\"Titulo\"><i>Datos enviados</i></p>");
                out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"enviar\" value=\"enviar\"/></div>");
                
                ArrayList<Objeto> usuarios = new ArrayList();
                
                for(int i=0;i<3;i++){
                Objeto usuario = new Objeto();
                usuario.setId(Integer.parseInt(request.getParameter("id"+i)));
                usuario.setNombre(request.getParameter("nombre"+i));
                usuario.setEdad(Integer.parseInt(request.getParameter("edad"+i)));
                usuarios.add(usuario);
                }
                
                
                session.setAttribute("usuarios", usuarios);
            
                
            }else{
            out.println("<p id=\"Titulo\"><i>Datos personales</i></p>");
            for(int i=0; i<3; i++){
            out.println("<h1>Usuario"+i+"</h1>");
            out.println("<p>id: <input type=\"text\" name=\"id"+i+"\" ></p>");
            out.println("<p>nombre: <input type=\"text\" name=\"nombre"+i+"\" ></p>");
            out.println("<p>edad: <input type=\"text\" name=\"edad"+i+"\" ></p>");
            }
            out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/></div>");
            
            }
            out.println("</body>");
            out.println("</html>");
        }
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
