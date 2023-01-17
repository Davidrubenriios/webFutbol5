/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.AdministradorJpaController;
import controlador.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;

/**
 *
 * @author DAVID
 */
public class sRegistroAd extends HttpServlet {

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
            String apelAd = "";
            String emailAd = "";
            String passAd = "";
            String domiAd = "";
            int dniAd = 0;
            int cgoAreaAd = 0;
            int telAd = 15;
            int idAdministrador = 0;
            String accion = "";
            accion = request.getParameter("txtAccion");

            if (!Objects.isNull(request.getParameter("txtIdAd"))) {
                idAdministrador = Integer.parseInt(request.getParameter("txtIdAd"));
            }

            if (!Objects.isNull(request.getParameter("txtNombreAd"))) {
                nomAd = request.getParameter("txtNombreAd");
            }

            if (!Objects.isNull(request.getParameter("txtApellidoAd"))) {
                apelAd = request.getParameter("txtApellidoAd");
            }

            if (!Objects.isNull(request.getParameter("txtEmailAd"))) {
                emailAd = request.getParameter("txtEmailAd");
            }

            if (!Objects.isNull(request.getParameter("txtPasswordAd"))) {
                passAd = request.getParameter("txtPasswordAd");
            }
            if(!Objects.isNull(request.getParameter("txtDniAd"))) {
                dniAd = Integer.parseInt("txtDniAd");
            }
            if(!Objects.isNull(request.getParameter("txtDomicilioAd"))){
                domiAd = request.getParameter("txtDomicilioAd");
            }

            if (!Objects.isNull(request.getParameter("txtCgoAreaAd"))) {
                cgoAreaAd = Integer.parseInt(request.getParameter("txtCgoAreaAd"));
            }

            if (!Objects.isNull(request.getParameter("txtTelAd"))) {
                telAd = Integer.parseInt(request.getParameter("txtTelAd"));
            }
            
            objAdministrador.setIdAdministrador(idAdministrador);
            objAdministrador.setNombre(nomAd);
            objAdministrador.setApellido(apelAd);
            objAdministrador.setEmailAdm(emailAd);
            objAdministrador.setClave(passAd);
            objAdministrador.setDomicilio(domiAd);
            objAdministrador.setDni(dniAd);
            objAdministrador.setCodigoArea(cgoAreaAd);
            objAdministrador.setTelefono(telAd);
          

            switch (accion) {
                case "N":
                    objCtrolAdm.create(objAdministrador);
                    request.getRequestDispatcher("listaAd.jsp").forward(request, response);
                    break;

                case "B":
            {
                try {
                    objCtrolAdm.destroy(idAdministrador);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(sRegistroAd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    request.getRequestDispatcher("listaAd.jsp").forward(request, response);
                    break;

                case "E":

            {
                try {
                    objCtrolAdm.edit(objAdministrador);
                } catch (Exception ex) {
                    Logger.getLogger(sRegistroAd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
