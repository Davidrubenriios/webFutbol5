/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.AdministradorJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;

/**
 *
 * @author DAVID
 */
@WebServlet(name = "sRegistroAdm", urlPatterns = {"/sRegistroAdm"})
public class sRegistroAdm extends HttpServlet {

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
          Administrador objAdministrador = new Administrador();
          AdministradorJpaController objCtrolAdm = new AdministradorJpaController();
          
          String nomAd = "";
          String apeAd = "";
          String emailAd = "";
          String passAd = "";
          String domAd = "";
          int dniAd = 0 ;
          int cgoAreaAd = 0;
          int telAd = 0;
          int idAdministrador = 0;
          String accion = "";
          
          accion = request.getParameter("txtAccion");
          
          if(!Objects.isNull(request.getParameter("txtIdAdm"))){
              idAdministrador = Integer.parseInt(request.getParameter("extIdAdm"));
          }
          
          if(!Objects.isNull(request.getParameter("txtNomAd"))){
              nomAd = request.getParameter("txtNomAd");
          }
          if(!Objects.isNull(request.getParameter("txtApeAd"))){
              apeAd = request.getParameter("txtApeAd");
          }
          
          if(!Objects.isNull(request.getParameter("txtEmailAd"))){
              emailAd = request.getParameter("txtEmailAd");
          }
          
          if(!Objects.isNull(request.getParameter("txtPassAd"))){
              passAd = request.getParameter("txtPassAd");
          }
          
          if(!Objects.isNull(request.getParameter("txtDomAd"))){
              domAd = request.getParameter("txtDomAd");
          }
          
          if(!Objects.isNull(request.getParameter("txtDniAdm"))){
              dniAd = Integer.parseInt(request.getParameter("txtDniAdm"));
          }
          
          if(!Objects.isNull(request.getParameter("txtCgoAreaAdm"))){
              cgoAreaAd = Integer.parseInt(request.getParameter("txtCgoAreaAdm"));
          }
          
           if(!Objects.isNull(request.getParameter("txttelAdm"))){
              telAd = Integer.parseInt(request.getParameter("txttelAdm"));
          }
           
           objAdministrador.setIdAdministrador(idAdministrador);
           objAdministrador.setNombre(nomAd);
           objAdministrador.setApellido(apeAd);
           objAdministrador.setEmailAdm(emailAd);
           objAdministrador.setClave(passAd);
           objAdministrador.setDomicilio(domAd);
           objAdministrador.setDni(dniAd);
           objAdministrador.setCodigoArea(cgoAreaAd);
           objAdministrador.setTelefono(telAd);
           
           switch (accion){
               case "N":
                   objCtrolAdm.create(objAdministrador);
                   request.getRequestDispatcher("loginAd.jsp").forward(request, response);
                   break;
                   
               case "B":
                   objCtrolAdm.destroy(idAdministrador);
                   request.getRequestDispatcher("listaAd.jsp").forward(request, response);
                   break;
                   
               case "E":
                   objCtrolAdm.edit(objAdministrador);
                   request.getRequestDispatcher("listaAd.jsp").forward(request, response);
                   break;
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
