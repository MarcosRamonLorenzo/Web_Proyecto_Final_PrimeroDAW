/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ArticuloDao;
import dao.CestaDAO;
import dto.Articulo;
import dto.Cesta;
import dto.LineaPedido;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.sql.NUMBER;

/**
 *
 * @author ciclost
 */
@WebServlet(name = "AddProductCesta", urlPatterns = {"/AddProductCesta"})
public class AddProductCesta extends HttpServlet {

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
        HttpSession session = request.getSession();
        try ( PrintWriter out = response.getWriter()) {
            //cogemos los datos que le hemos pasado 
            Usuario usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (Usuario) session.getAttribute("usuario") : null;
            String strId = request.getParameter("id");
            String strCantidad = request.getParameter("cantidad");

            if (strId != null && strCantidad != null && session.getAttribute("usuario") != null) {
                //con los datos anteriores si no son nulos cogemos el articulo correspondiente
                Articulo pro = new ArticuloDao().getByCodigo(Integer.parseInt(strId));
                int cantidad = Integer.parseInt(strCantidad);
                //cremamos la linea pedido y la insertamos 
                LineaPedido ln = new LineaPedido(cantidad, cantidad*pro.getPrecio(), pro);
                CestaDAO cesta = new CestaDAO();

                if (cesta.getByNombreCesta(usuarioSesion.getEmail()) == null) {
                    // si no existe una cesta cremos una y como nombre le ponemos el email del usuario session para despues poder identificar la cesta mas facil
                    Cesta carrito = new Cesta(usuarioSesion.getEmail(), "cesta", usuarioSesion, null);
                    try {
                         cesta.anyadir(carrito);
                    } catch (Exception e) {
                        out.println("<h2>Este articulo ya esta en la cesta. Revisa el formulario</h2><p><a href=\"javascript: history.go(-1)\">Volver atrás</a></p>");
                        out.println(" <a href=\"carrito.jsp\"></a> ");
                    }
                    
                    
                    
                }
                 try {
                     //añadimos el producto a la cesta.Si intentamos añadir el mismo producto simplemente no se introducirá
                cesta.anyadirLinPed(ln, cesta.getByNombreCesta(usuarioSesion.getEmail()));
                 
                 }catch (Exception e) {
                        session.setAttribute("errorPrCesta", true);
            
                    }
                response.sendRedirect("carrito.jsp");

            } else {

                out.println("<h2>Datos incorrectos. Revisa el formulario</h2><p><a href=\"javascript: history.go(-1)\">Volver atrás</a></p>");
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
        } catch (SQLException ex) {
            Logger.getLogger(AddProductCesta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(AddProductCesta.class.getName()).log(Level.SEVERE, null, ex);
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
