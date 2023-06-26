<%-- 
    Document   : carrito
    Created on : May 16, 2023, 11:40:16 AM
    Author     : ciclost
--%>
<%@page import="dao.PedidoFacturaDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.DireccionDAO"%>
<%@page import="dto.Direccion"%>
<%@page import="dto.LineaPedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CestaDAO"%>
<%@page import="dto.Usuario"%>
<%
    Usuario usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (Usuario) session.getAttribute("usuario") : null;
    CestaDAO c = new CestaDAO();
    ArrayList<LineaPedido> ln = c.getLineasByNombreCesta(usuarioSesion.getEmail());
    double precio_total = 0;


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/cesta.css">
        <link rel="stylesheet" href="./css/footer.css">
        <meta charset="UTF-8">
        <title>Cesta</title>
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

            <h2>CESTA</h2>

            <table>
                <% for (LineaPedido l : ln) {
                        precio_total += l.getCantidadad()*l.getArticulo().getPrecio();

                %> 

                <tr>

                    <td class="primero"><img class="imgs" src="<%=l.getArticulo().getFoto()%>" alt=""></td>

                    <td class="primero textito"><%=l.getArticulo().getDescripcion()%></td>

                    <td class="primero">Cantidad: 


                        <form name="modificarCantidad "  method="post" action="modificarCantidad?id=<%=l.getArticulo().getCodigo()%>">
                            <select id="cant" name="cantidad" onchange='this.form.submit()' >
                                <option <%=l.estaSelected(1)%> >1</option>
                                <option <%=l.estaSelected(2)%> >2</option>
                                <option <%=l.estaSelected(3)%> >3</option>
                                <option <%=l.estaSelected(4)%>>4</option>
                                <option <%=l.estaSelected(5)%>>5</option>
                                <option <%=l.estaSelected(6)%>>6</option>
                                <option <%=l.estaSelected(7)%>>7</option>
                                <option <%=l.estaSelected(8)%>>8</option>
                                <option <%=l.estaSelected(9)%>>9</option>
                                
                            </select>
                        </form>

                    </td>

                    <td class="primero"><%=l.getCantidadad()*l.getArticulo().getPrecio() %>€</td>

                    <td class="primero"><a class="rojo" href="EliminarProducto?id=<%=l.getArticulo().getCodigo()%>">Eliminar Producto</a></td>

                </tr>

                <%            }

                %>

            </table>
            <hr style="border: 1px solid #1a1919; margin: 0px 50px 0px 50px;">




             <table>

                <tr>
                <form name="direecionPed" method="post" action="confimPedido">
                    <td class="segundo"><b>Dirección de Envío:</b>


                        <select name="direccion" id="direccion" >
                            <%  List<Direccion> direcciones = new DireccionDAO().getDireccionesDe(usuarioSesion);
                                for (Direccion d : direcciones) {%>
                                <option value="<%=d.getNumero()%>" ><%=d.getDireccion()%> --(<%=d.getPoblacion()%>)</option>
                                   
                              <%  }
                            %>
                        </select>   

                    </td>

                    <td><b>Subtotal: <%=precio_total%>€</b></td>
                    <% if (!ln.isEmpty()) {
                    %>

                    <td><input  class="boton" type="submit" onclick="confirmarPedido()" value="Tramitar pedido" /></td>

                        <%
                            }
                        %>

                </form>
                <script>
                    function confirmarPedido() {
                        if (confirm("¿Desea confirmar el pedido?")) {
                            window.location.replace("confimPedido");
                        }
                    }
                </script></td>

                </tr>

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
