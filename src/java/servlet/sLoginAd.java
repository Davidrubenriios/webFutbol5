/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.AdministradorJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Administrador;

/**
 *
 * @author DAVID
 */
public class sLoginAd extends HttpServlet {

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
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd;

            HttpSession sesion = request.getSession();
            String adm, pass;

            adm = request.getParameter("txtAdministrador");
            pass = request.getParameter("txtClave");

            sesion.setAttribute("idAdministrador", null);
            sesion.setAttribute("emailAdm", null);

            Administrador Admi;
            AdministradorJpaController objCtrlAdm = new AdministradorJpaController();
            Admi = objCtrlAdm.LoginAdministrador(adm, pass);
            if (Admi.getIdAdministrador() != null) {
                String strlAdministrador = Admi.getIdAdministrador().toString();
                sesion.setAttribute("idAdministrador", strlAdministrador);
                sesion.setAttribute("NombreAd", Admi.getNombre());
                sesion.setAttribute("ApellidoAd", Admi.getApellido());
                sesion.setAttribute("DNI", Admi.getDni());
                rd = request.getRequestDispatcher("administrador.jsp");
            } else {
                request.setAttribute("alertMsg", "Los datos ingresados no son validos. Por favor verifique!");
                request.setAttribute("alertTitulo", "Datos incompletos");
                rd = request.getRequestDispatcher("loginAd.jsp");
            }
            rd.include(request, response);
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
