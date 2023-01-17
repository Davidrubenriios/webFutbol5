/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.UsuarioJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author DAVID
 */
public class sLogin extends HttpServlet {

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
        RequestDispatcher rd;

        HttpSession sesion = request.getSession();
        String usu, pass;

        usu = request.getParameter("txtUsuario");
        pass = request.getParameter("txtClave");

        sesion.setAttribute("idUsuario", null);
        sesion.setAttribute("emailUsu", null);

        Usuario Usua;
        UsuarioJpaController objCtrlUsu = new UsuarioJpaController();
        Usua = objCtrlUsu.LoginUsuario(usu, pass);
        if (Usua.getIdUsuario() != null) {
            String strlUsuario = Usua.getIdUsuario().toString();
            sesion.setAttribute("idUsuario", strlUsuario);
            sesion.setAttribute("Nombre", Usua.getNombre());
            sesion.setAttribute("Apellido", Usua.getApellido());
            sesion.setAttribute("Telefono", Usua.getTelefono());
            rd = request.getRequestDispatcher("turnos.jsp");
        } else {
            request.setAttribute("alertMsg", "Los datos ingresados no son validos. Por favor verifique!");
            request.setAttribute("alertTitulo", "Datos incompletos");
            rd = request.getRequestDispatcher("login.jsp");
        }
        rd.include(request, response);
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
