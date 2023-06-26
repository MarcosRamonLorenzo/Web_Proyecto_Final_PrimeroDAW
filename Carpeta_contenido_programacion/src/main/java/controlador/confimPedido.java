/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.CestaDAO;
import dao.DireccionDAO;
import dao.PedidoFacturaDAO;
import dto.Cesta;
import dto.Direccion;
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
@WebServlet(name = "confimPedido", urlPatterns = {"/confimPedido"})
public class confimPedido extends HttpServlet {

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
            Usuario usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (Usuario) session.getAttribute("usuario") : null;
            if (usuarioSesion == null) {
                out.println("<h2>No tienes permiso para acceder a esta sección</h2><p><a href=\"javascript: history.go(-1)\">Volver atrás</a></p>");

            } else {
                //cogemos las lineas pedido de la cesta principal del usuario junto a la direccion
                CestaDAO c = new CestaDAO();
                ArrayList<LineaPedido> ln = c.getLineasByNombreCesta(usuarioSesion.getEmail());
                String numDir = request.getParameter("direccion");
                //con el metodo siguiente código podemos ver cual es el codigo que se utlizara para hacer la nueva factura
                int cod = new PedidoFacturaDAO().siguienteCodigo();
                try {

                    int codDir = Integer.parseInt(numDir);
                    /*pero antes de hacer el pedido y borrar las lineas pedido hacemos una cesta copia
                    que llevará el nombre de el codigo de la factura.Despues con esa cesta podremos coger las lineas pedido de esa facturas 
                    y utilizarla para hacer su respectivo pdf y xml*/
                    Cesta cestaCop = new Cesta(String.valueOf(cod), numDir, usuarioSesion, null) ;
                    //añadimos la cesta a la bd
                    c.anyadir(cestaCop);
                    
                    //hacemos el pedido factura .La direecion será la misma para las dos
                    
                    PedidoFactura pedido = new PedidoFactura(cod, LocalDateTime.now(), TipoEstadoFacturacion.No_Facturado, new DireccionDAO().getByCodigo(codDir), c.getByNombreCesta(usuarioSesion.getEmail()));
                    //añadimos el pedido a la bd
                    new PedidoFacturaDAO().anyadir(pedido);
                    
                    for (LineaPedido lineaPedido : ln) {
                        //ahora por cada linea la añadimos a la cesta copia correspondiente
                        c.anyadirLinPed(lineaPedido, cestaCop);
                        //y eliminamos la linea de la cesta pricipal
                        c.eliminarLinPed(lineaPedido.getArticulo().getCodigo(), c.getByNombreCesta(usuarioSesion.getEmail()));
                        
                    }
                    response.sendRedirect("pedidoFac.jsp");

                } catch (Exception e) {
                    numDir = null;
                    out.println("<h2>Ha ocurrido un error</h2><p><a href=\"javascript: history.go(-1)\">volver</a></p>");
                }

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
            Logger.getLogger(confimPedido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(confimPedido.class.getName()).log(Level.SEVERE, null, ex);
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
