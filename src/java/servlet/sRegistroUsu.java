/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.UsuarioJpaController;
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
import modelo.Usuario;

/**
 *
 * @author DAVID
 */
public class sRegistroUsu extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Usuario objUsuario = new Usuario();
            UsuarioJpaController objCtrolUsu = new UsuarioJpaController();

            String nom = "";
            String apel = "";
            String email = "";
            String pass = "";
            int cgoArea = 0;
            int tel = 0;
            int idUsuario = 0;
            String accion = "";
            accion = request.getParameter("txtAccion");

            if (!Objects.isNull(request.getParameter("txtId"))) {
                idUsuario = Integer.parseInt(request.getParameter("txtId"));
            }

            if (!Objects.isNull(request.getParameter("txtNombre"))) {
                nom = request.getParameter("txtNombre");
            }

            if (!Objects.isNull(request.getParameter("txtApellido"))) {
                apel = request.getParameter("txtApellido");
            }

            if (!Objects.isNull(request.getParameter("txtEmail"))) {
                email = request.getParameter("txtEmail");
            }

            if (!Objects.isNull(request.getParameter("txtPassword"))) {
                pass = request.getParameter("txtPassword");
            }

            if (!Objects.isNull(request.getParameter("txtCgoArea"))) {
                cgoArea = Integer.parseInt(request.getParameter("txtCgoArea"));
            }

            if (!Objects.isNull(request.getParameter("txtTel"))) {
                tel = Integer.parseInt(request.getParameter("txtTel"));
            }

            objUsuario.setIdUsuario(idUsuario);
            objUsuario.setApellido(apel);
            objUsuario.setNombre(nom);
            objUsuario.setEmailUsu(email);
            objUsuario.setClave(pass);
            objUsuario.setCodigoArea(cgoArea);
            objUsuario.setTelefono(tel);

            switch (accion) {
                case "N":
                    objCtrolUsu.create(objUsuario); 
                    request.setAttribute("msjCorrecto", "Su cuanta fue creado con exito. Ya puede ingersea con su ausuario y contraneña");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                    
                case "B":
                    objCtrolUsu.destroy(idUsuario);
                    request.getRequestDispatcher("listaUsu.jsp").forward(request, response);
                    break;

                case "E":

                    objCtrolUsu.edit(objUsuario);
                    request.getRequestDispatcher("listaUsu.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(sRegistroUsu.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(sRegistroUsu.class.getName()).log(Level.SEVERE, null, ex);
        }
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
