/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.CestaDAO;
import dao.PedidoFacturaDAO;
import dto.LineaPedido;
import dto.PedidoFactura;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciclost
 */
public class ExportarXml extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean errorFactura = false;
        // Recogemos al ususuario que está en la sesión
        HttpSession session = request.getSession(false);
        Usuario usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (Usuario) session.getAttribute("usuario") : null;
        try (PrintWriter out = response.getWriter()) {
            try {
                // Recogemos el codigo de factura que se solicita exportar
                if (request.getParameter("id")!= null ) {
                    int codigo = Integer.valueOf(request.getParameter("id"));
                    PedidoFactura factura = new PedidoFacturaDAO().getByCodigo(codigo);
                    // Si la factura existe en la BD y además está asociada al mismo usuario que hay en la sesión entonces exportamos (excepto si es admin)
                    if (usuarioSesion != null && factura != null || usuarioSesion.isAdministrador()) {
                        response.setContentType("text/plain;charset=UTF-8");
                        out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                        out.println("<factura codigo_factura=\"" + factura.getCodigo() + "\">");

                        out.println("\t<fecha>");
                        out.println("\t\t<dia>" + factura.getFechaPedido().getDayOfMonth() + "</dia>");
                        out.println("\t\t<mes>" + factura.getFechaPedido().getMonthValue() + "</mes>");
                        out.println("\t\t<anyo>" + factura.getFechaPedido().getYear() + "</anyo>");
                        out.println("\t\t<hora>" + factura.getFechaPedido().getHour() + "</hora>");
                        out.println("\t\t<minuto>" + factura.getFechaPedido().getMinute() + "</minuto>");
                        out.println("\t\t<segundo>" + factura.getFechaPedido().getSecond() + "</segundo>");
                        out.println("\t</fecha>");

                        out.println("\t<direccion_facturacion_pedido>");
                        out.println("\t\t<direccion>" + factura.getDireccion().getDireccion() + "</direccion>");
                        out.println("\t\t<poblacion>" + factura.getDireccion().getPoblacion() + "</poblacion>");
                        out.println("\t\t<provincia>" + factura.getDireccion().getProvincia() + "</provincia>");
                        out.println("\t</direccion_facturacion_pedido>");
                        out.println("\t\t<cliente>" + factura.getCesta().getCliente().getNombre()+ "</cliente>");
                      
                        
                        out.println("\t\t<lineas>");

                        double precio_total =0;
                        ArrayList<LineaPedido> lineas = new CestaDAO().getLineasByNombreCesta(String.valueOf(factura.getCodigo()));
                        for (LineaPedido linea : lineas) {
                           precio_total += linea.getPrecio(); 
                            out.println("\t\t\t<producto codigo_producto=\"" + linea.getArticulo().getCodigo() + "\">");
                            out.println("\t\t\t\t<nombre>" + linea.getArticulo().getDescripcion()+ "</nombre>");
                            out.println("\t\t\t\t<precio_unitario>" + redondear(linea.getPrecio()) + "</precio_unitario>");
                            out.println("\t\t\t\t<marca>" + linea.getArticulo().getFabricacion() + "</iva>");
                            out.println("\t\t\t\t<cantidad_productos>" + linea.getCantidadad() + "</cantidad_productos>");
                            out.println("\t\t\t\t<total_linea>" + redondear(linea.getPrecio()) + "</total_linea>");
                            out.println("\t\t\t</producto>");
                        }

                        out.println("\t\t</lineas>");
                        out.println("\t</pedido_asociado>");

           
                        out.println("\t<total>" + redondear(precio_total) + "</total>");
                        out.println("</factura>");
                        response.setHeader("Content-Disposition", "attachment; filename=\"Factura" + factura.getCodigo() + ".xml\"");

                    } else {
                        errorFactura = true;
                    }

                } else {
                    errorFactura = true;
                }

                if (errorFactura) {
                    out.println("<p>Error. No tienes acceso a esta factura. </p><p><a href=\"javascript: history.go(-1)\">Volver atrás</a></p>");
                }
            } catch (SQLException e) {
                out.println("<h1>ERROR SQL</h1>");
            }
        }

    }
    
    private static double redondear(double valor){
        return Math.round(valor*100)/100.0;
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
