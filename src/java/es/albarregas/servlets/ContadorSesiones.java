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
import javax.servlet.http.HttpSession;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ContadorSesiones", urlPatterns = {"/ContadorSesiones"})
public class ContadorSesiones extends HttpServlet {

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
        HttpSession sesion;
        Integer auxNumero;
        // int numero = 1;
        
        // posibilidades --> viene la 1? vez           --> crear session con request.getSession(true)
        //               --> viene de pulsar eliminar  --> si hay sesion --> eliminar sesion, poner auxNumero igual a 0, 
        //                                                                   para desactivar boton eliminar y asi evitar que entre por esa rama si no hay sesion abierta                                                                     
        //               --> viene de pulsar recargar  --> puede haber sesion o no
        //                                                    >> si hay sesion abierta    --> incrementar valor de atributo contador de sesion
        //                                                    >> si no hay sesion abierta --> crear sesion
        if("eliminar".equals(request.getParameter("accion"))){
           // viene de pulsar eliminar, puede encontrarse que hay sesion o que no haya sesion
           sesion = request.getSession(false);//en caso de no existir no te crea la sesion y te devuelve null,(con false) no me crea una nueva sesion y me devuelve null y a true te lo crea
           sesion.invalidate();//Elimina la sesion del servidor, te la borra
           auxNumero = 0;
        } else{
            if ("recargar".equals(request.getParameter("accion"))) {
                // viene de pulsar recargar, puede encontrarse que haya sesion o que no haya sesion
                sesion = request.getSession(false);//te obtiene la sesion si la hay, obteienes la sesion de la palicacion
                if (sesion == null){// no hay sesion aun
                    sesion = request.getSession(true);// te crea la sesion un objeto de tipo sesion esto es para cuando la hemos borrado alguna vez.
                    sesion.setAttribute("contador", 1);
                } else{
                    sesion.setAttribute("contador", (Integer) sesion.getAttribute("contador") + 1);
                }// if..else
            } else{
                // viene por 1? vez
                sesion = request.getSession(true);// es por que la carga por primera vez
                sesion.setAttribute("contador", 1);
            }//if
            auxNumero = (Integer) sesion.getAttribute("contador");
        }//if eliminar
        
        // y mostramos el html de la respuesta
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contador usando sesiones</title>");
            out.println("</head>");
            out.println("<body>");
            
            if (auxNumero == 0){
                out.println("<h2>Sesion eliminada</h2>");
            } else{
                out.println("<h2>Esta pagina ha sido visitada " + auxNumero + " veces</h2>");
            }//if
            
            out.println("<form action=\"ContadorVisitasSession\" method=\"get\">");
            
            if (auxNumero == 0) {
                out.println("<input type=\"submit\" name=\"accion\" value=\"eliminar\" disabled>");
            } else {
                out.println("<input type=\"submit\" name=\"accion\" value=\"eliminar\">");
            }//if
            
            out.println("<input type=\"submit\" name=\"accion\" value=\"recargar\">");
            out.println("</form>");
            
            out.println("<br><a href=\"" + request.getContextPath() + "\">Volver al Indice</a>");
            out.println("</body>");
            out.println("</html>");
        }//try
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
