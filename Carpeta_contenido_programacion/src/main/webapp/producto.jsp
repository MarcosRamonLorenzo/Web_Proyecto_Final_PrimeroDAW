<%-- 
    Document   : producto
    Created on : May 9, 2023, 11:31:18 AM
    Author     : ciclost
--%>

<%@page import="dao.ArticuloDao"%>
<%@page import="dto.Articulo"%>
<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Articulo p = null;
    int codigo = 0;
    Usuario usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (Usuario) session.getAttribute("usuario") : null;
    if (request != null && request.getParameter("id") != null) {
        codigo = Integer.parseInt(request.getParameter("id"));
        p = new ArticuloDao().getByCodigo(codigo);
    }

%>
<!DOCTYPE html>
<html >
    <head>
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/footer.css">
        <link rel="stylesheet" href="./css/estiloprod.css" />
        <title>Producto</title>
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


        <main >
            <%                if (p == null && codigo == 0) {
                    out.println("<p>Error. Producto no encontrado. </p><p><a href=\"javascript: history.go(-1)\">Volver atrás</a></p>");
                    out.println(codigo);
                } else {
            %>

            <img class="image" src="<%=p.getFoto()%>" >

            <article class="container">



                <p id="primertxt"><%=p.getDescripcion()%></p>

                <p><%=p.getPrecio()%>€</p>    

                <form name="anyadircarrito" method="post" action="AddProductCesta" >
                    <p id="cantidad">Cantidad

                        <select name="cantidad">
                            <option selected value="1">1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>

                        </select>
                    </p>
                    <ul>
                        <%
                            if (usuarioSesion == null) {

                        %>
                        <a class="enlacelog" href="./login.jsp">INICIE SESIÓN AQUÍ PARA COMPRAR</a>



                </form>

                <br>
                <!-- <input  class="boton" type="submit" value="Editar Producto" /> -->
                <%                } else {%>
                <input type="hidden" name="id" value="<%= p.getCodigo()%>" />
                <%if (usuarioSesion.isAdministrador()) {
                %><input  class="boton" type="button" value="Editar Producto" /><%
                        } else {%>
                <input  class="boton" type="submit" value="Añadir al carrito" />
                <%}
                %>

                <%
                    }

                %>



                </ul>
            </article>

            <% }%>



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
