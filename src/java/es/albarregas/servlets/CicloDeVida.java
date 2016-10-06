/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "CicloDeVida", urlPatterns = {"/CicloDeVida"})
public class CicloDeVida extends HttpServlet {

    public CicloDeVida(){
        super();
        System.out.println("Constructor ciclo de vida");
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        System.out.println("Estoy dentro de init");
        //El constructor del propio init
    }
    
    @Override
    public void destroy(){
        System.out.println("Estoy dentro de destroy");
    }
    
    //get es el que se ejecuta desde la URL y el doPost cuando lo enviamos desde el formulario
    //se ha ejecutado por el doGet
    //request peticion cuando pedimos un recurso al servidor
    //response devuelve recursos 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Pasa por el doGet");
        PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet ContadorCookies</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<a href=\"index.html\" >Volver</a>");
         out.println("</body>");
         out.println("</html>");
    }

}
