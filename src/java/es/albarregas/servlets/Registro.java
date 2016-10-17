
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {
      
      int[]errores=new int[4];      //Nos mostrara que error es el que hay
      boolean semaforo=true;        //nos ayudara a cambiar de ventanas
      int controlador=1;            //nos atudara a cambiar de pantallas
      
      
            String [] checkbox;     //nos ayudan a mostrar los datos en un bucle
            String [] selectmultiple;//nos ayudan a mostrar los datos en un bucle
      
    
    
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
            
     
      //Primero revisamos los errores, y el boolean nos permite entrar en los datos cuando ya hemos mostrado la pantalla de  "error al introducir los datos
            if(revisasErrores(request,response) && semaforo){
                pantallaDeError(request,response);
            }else{
                
           
      //Si hemos pasado por aqui dos veces quiere decir que no hemos ido a la pantlla de errores por lo que todo esta bien y no muestra el formulario, muestra la pantalla de envio          
            controlador++;
            if(controlador==2){
                    pantallaDeEnvio(request,response);
                }
            
//----------------------------------Mostramos los posibles errores----------------------------------------------------
            semaforo=true;   
                for(int valor : errores){        
                switch(valor){
            case 1:
                out.println("<p id=\"Error\" >El campo nombre es obligatorio</p>");
                break;       
             case 2:
                out.println("<p id=\"Error\" >El campo apellido es obligatorio</p>");
                break;       
             case 3:
                out.println("<p id=\"Error\" >El campo contrase&ntilde;a es obligatorio</p>");
                break;                
             case 4:
                out.println("<p id=\"Error\" >Error al intrducir la fecha</p>");
                break;
        }
        }
   //reiniciamos el valor de los errores una vez mostrados
           errores[0]=0;
           errores[1]=0;
           errores[2]=0;
           errores[3]=0;
 
//----------------------------------Cargamos el formulario----------------------------------------------------
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");      
            out.println("<link rel=\"stylesheet\" href=\"CSS/estiloDatosPersonales.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<p id=\"Titulo\"><i>Datos personales</i></p>");
            out.println("<p>*nombre: <input type=\"text\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            out.println("<p>*apellido: <input type=\"text\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
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
                }//else  
            out.println("<BR><label>Fecha de nacimiento:</label>");
            out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"dia\" min=\"1\" max=\"31\" value=\""+request.getParameter("dia")+"\">");
            out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"mes\" min=\"1\" max=\"12\" value=\""+request.getParameter("mes")+"\">");
            out.println("<label><Strong> / </Strong></label><input type=\"number\" name=\"anio\" min=\"1900\" max=\"2016\" value=\""+request.getParameter("anio")+"\"></p>");
            out.println("<BR><p id=\"Titulo\"><i>Datos de acceso</i></p>");
            out.println("<p>usuario: <input type=\"text\" name=\"usuario\" value=\""+request.getParameter("usuario")+"\"></p>");
            out.println("<p>*contrase&ntilde;a: <input type=\"password\" name=\"contrasenia\" value=\""+request.getParameter("contrasenia")+"\"></p>");
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
           }//menu
        }//for     
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
        }//else
            out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Enviar\" value=\"Enviar\"/> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }//if  
      }//try
    }//Inicializamos formulario
   //Este metodo revisara los errores mediante una variable auxiliar
    protected boolean revisasErrores(HttpServletRequest request, HttpServletResponse response){
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
                  int dia = Integer.parseInt(request.getParameter("dia"));
                  int anio = Integer.parseInt(request.getParameter("anio"));

                  switch (request.getParameter("mes")){
                      case "1":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                      case "2":
                          if(dia>28){
                              if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
                                  if(dia==29){
                                      
                                  }
                              }else{
                              aux=true;
                              errores[3]=4;
                              }
                              break;
                          }
                      case "3":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                      case "4":
                          if(dia>30){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "5":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "6":
                          if(dia>30){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "7":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "8":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                      case "9":
                          if(dia>30){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "10":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "11":
                          if(dia>30){
                              aux=true;
                              errores[3]=4;
                              break;
                          }
                       case "12":
                          if(dia>31){
                              aux=true;
                              errores[3]=4;
                              break;
                          }                     
                  }
                  return aux;
}//revisar errores
    //Pantalla que nos mostrara cuandoo hay un error
        public void pantallaDeError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       //variable controlador de pantallas
       controlador--;  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<form id=\"Registro\" method=\"post\">");
            out.println("<title>Servlet Prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p id=\"Titulo\"><i>Ha habido alg&uacute;n error</i></p>");
            out.println("<p><input type=\"hidden\" name=\"nombre\" value=\""+request.getParameter("nombre")+"\"></p>");
            out.println("<p><input type=\"hidden\" name=\"apellido\" value=\""+request.getParameter("apellido")+"\"></p>");
            if("Mujer".equals(request.getParameter("sexo"))){
            out.println("<td><input type=\"radio\" name=\"sexo\" style=\"display:none;\" value=\"Hombre\" /></td>");
            out.println("<td><label></label><input type=\"radio\" name=\"sexo\" style=\"display:none;\" checked=\"checked\" value=\"Mujer\" /></td>");
        }else{
            out.println("<td><input type=\"radio\" name=\"sexo\" style=\"display:none;\" checked=\"checked\" value=\"Hombre\"/></td>");
            out.println(" <td><label></label><input type=\"radio\" style=\"display:none;\" name=\"sexo\"  value=\"Mujer\"/></td>");
        }//else
            out.println("<label><Strong>  </Strong></label><input type=\"hidden\" name=\"dia\" min=\"1\" max=\"31\" value=\""+request.getParameter("dia")+"\">");
            out.println("<label><Strong>  </Strong></label><input type=\"hidden\" name=\"mes\" min=\"1\" max=\"12\" value=\""+request.getParameter("mes")+"\">");
            out.println("<label><Strong>  </Strong></label><input type=\"hidden\" name=\"anio\" min=\"1900\" max=\"2016\" value=\""+request.getParameter("anio")+"\"></p>");
            out.println("<p><input type=\"hidden\" name=\"usuario\" value=\""+request.getParameter("usuario")+"\"></p>");
            out.println("<p><input type=\"hidden\" name=\"contrasenia\" value=\""+request.getParameter("contrasenia")+"\"></p>");
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
           }//menu
        }//for                                        
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadodeporte+" value=\"Deporte\" style=\"display:none;\"></td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadolectura+" value=\"Lectura\" style=\"display:none;\"></td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadocine+" value=\"Viajes\" style=\"display:none;\"></td>");
            out.println("<td><input type=\"checkbox\" name=\"checkbox\"   "+checkeadoviajes+" value=\"Viajes\" style=\"display:none;\"></td>");        
        }//else        
            out.println("<BR><div id=\"botones\"> <input type=\"submit\" name=\"Volver\" value=\"Volver\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            semaforo=false;            
        }//try
        }//Pantalla de error
        
        
        public void pantallaDeEnvio(HttpServletRequest request, HttpServletResponse response)
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
            out.println("<p id=\"Titulo\"><i>Todo correcto, informacion enviada</i></p>");
            Enumeration<String> nombres  = request.getParameterNames();
            
            
            //Bucle para mostrar los datos
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
                                        //Mes y a?o no lo mostramos porq ya lo hemos mostrado arriba
                                        if(nombre.startsWith("mes") || nombre.startsWith("anio")){
                                            
                                        }else{  
                                        out.println(nombre.toUpperCase()+": "+request.getParameter(nombre)+"<br/>");
                                        }//else
                                    }//else
                                }//else
                            }//if                       
                    }else{                       
                    }//else
                }//While 
         //out.println("<input type=\"button\" value=\"Volver\" onclick=\"window.location.href='index.html';\"/>");
             out.println("</body>");
            out.println("</form>");
            out.println("</html>");
        }//try
    }//Pantalla de envio
        
       
}//Class

