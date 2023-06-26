<%-- 
    Document   : pedidoFac
    Created on : May 20, 2023, 12:16:17 PM
    Author     : ciclost
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="dto.PedidoFactura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PedidoFacturaDAO"%>
<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (Usuario) session.getAttribute("usuario") : null;
    PedidoFacturaDAO pf = new PedidoFacturaDAO();
    ArrayList<PedidoFactura> pedidos = null;

    if (usuarioSesion.isAdministrador()) {
        pedidos = pf.getAll();

    } else {
        pedidos = pf.getAllDeUsuario(usuarioSesion);
    }

    if (usuarioSesion == null) {
        response.sendRedirect("login.jsp");
    }


%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/pedFact.css">
        <link rel="stylesheet" href="./css/footer.css">
        <title>TuCafetiko</title>
    </head>
    <body>

        <header>
            <nav>
                <section id="primernav">

                   <a id="img1" href="./index.jsp"> <img id="img1" src="img/logodefinitivo.png" alt="Logo"></a>
                    <ul class="primeranavopciones">
                        <li class="ladearriba"><input id="buscar" type="search" placeholder="BUSCAR"/></li>

                        <%                            if (request.getSession().getAttribute("usuario") == null) {%>
                        <li class="ladearriba"><a id="login" href="./login.jsp">INICIAR SESIÓN</a></li>

                        <%   } else { %> 
                        <li class="ladearriba"><a id="login" href="LogoutServlet">CERRAR SESIÓN</a></li>
                        <li class="ladearriba"><a id="cesta" href="./carrito.jsp">CESTA</a></li>
                        <li class="ladearriba"><a id="usuario" href="./datosUsuario.jsp"><img src="./img/usuario.png" alt="alt"/></a></li>
                                <%
                                    }
                                %> 




                    </ul>


                </section>

                <section class="segundonav">
                    <ul>
                        <li class="coloresnav"><a href="./index.jsp">HOME</a></li>
                        <li class="coloresnav"><a href="./categorias.jsp">CATEGORÍAS</a></li>
                        <li class="coloresnav"><a href="./SobreNosotros.jsp">SOBRE NOSOTROS</a></li>
                            <% if (request.getSession().getAttribute("usuario") != null) {%>
                        <li class="coloresnav"><a href="./pedidoFac.jsp">PEDIDOS Y FACTURAS</a></li>
                            <% } else {%>
                        <li class="coloresnav"><a href="./login.jsp">PEDIDOS Y FACTURAS</a></li>
                            <%}
                            %>

                        <li class="coloresnav"><a href="./contacto.jsp">CONTACTO</a></li>
                        <li class="coloresnav"><a href="./concurso.jsp">CONCURSO</a></li>
                        <li class="coloresnav"><a href="./informacion.jsp">INFORMACIÓN</a></li>
                    </ul>
                </section>
            </nav>

        </header>

        <main class="principal">

            <table>

                <tr>

                    <td class="titulo">Email</td>

                    <td class="titulo">Código Facturación</td>

                    <td class="titulo">Dirección Facturación</td>

                    <td class="titulo">Fecha</td>

                    <td class="titulo">Estado Facturación</td>

                    <td class="titulo">Factura XML</td>

                    <td class="titulo">Factura PDF</td>

                </tr>


                <% for (PedidoFactura p : pedidos) {%>
                <tr>
                    <td><%=p.getCesta().getCliente().getEmail()%></td>

                    <td><%=p.getCodigo()%></td>

                    <td><%=p.getDireccion().getDireccion()%></td>
                    <%
                        String fechaFormateada = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(p.getFechaPedido());
                    %>
                    <td><%=fechaFormateada%></td>

                    <td><%=p.getEstadoFacturacion()%> | <a class="fac" href="FacturarServlet?id=<%=p.getCodigo()%>">Facturar</a></td>

                    <td><a href="ExportarXml?id=<%=p.getCodigo()%>"><img class="imgs" src="./img/xml.png" alt="Factura XML"></a></td>


                    <td><a href="ExportarPdf?id=<%=p.getCodigo()%>"><img class="imgs" src="./img/pdf.png" alt="Factura PDF"></a></td>


                </tr>
                <%    }
                %>


            </table>

        </main>

        <footer>

            <ul class="footer">
                <li class="footerleft"><a target="_blank" href="./DerechosUso.html">Derechos de uso</a></li>
                <li class="footerleft"><a target="_blank" href="./PoliticaPriv.html">Política de privacidad</a></li>
                <li class="footerleft"><a target="_blank" href="./ReservaInstalaciones.html">Reserva de instalaciones</a></li>
                <li class="footerleft"><a target="_blank" href="./Devoluciones.html">Devoluciones y reclamaciones</a></li>
            </ul>


            <ul class="foot2">
                <li class="footerright">Creado por: </li>
                <li class="footerright">Marcos Ramón Lorenzo</li>
                <li><img src="./img/m.png" height="30px"></li>
                <li class="footerright">Adrián Pareja Morote</li>
                <li><img src="./img/a.png" height="30px"></li>

            </ul>





        </footer>
    </body>
</html>
