/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.CestaDAO;
import dao.DireccionDAO;
import dao.PedidoFacturaDAO;
import dto.LineaPedido;
import dto.PedidoFactura;
import dto.TipoEstadoFacturacion;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciclost
 */
@WebServlet(name = "FacturarServlet", urlPatterns = {"/FacturarServlet"})
public class FacturarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try ( PrintWriter out = response.getWriter()) {
            try {

                String Id = request.getParameter("id");
                PedidoFactura fact = new PedidoFacturaDAO().getByCodigo(Integer.parseInt(Id));
                //despues de coger la factura que queremos facturar con el metodo actualizarFactura() acutalizamos ese campo
                new PedidoFacturaDAO().actualizarFactura(fact);
                response.sendRedirect("pedidoFac.jsp");
                
            } catch (Exception e) {

                out.println("<h2>Ha ocurrido un error</h2><p><a href=\"javascript: history.go(-1)\">volver</a></p>");
                out.println(e.getMessage());
                
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(FacturarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(FacturarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
