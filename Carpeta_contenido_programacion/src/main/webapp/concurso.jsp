<%-- 
    Document   : concurso
    Created on : 22 May 2023, 17:05:23
    Author     : ciclost
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>TuCafetiko</title>
        <meta name="description" content="HTML5">
        <meta name="author" content="Adrián Pareja Morote">
        <link rel="shortcut icon" href="favicon.ico">
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/footer.css">
        <link rel="stylesheet" href="./css/concurso.css">
    </head>
    <body>

        <header>
            <nav>
                <section id="primernav">

                    <a id="img1" href="./index.jsp"> <img id="img1" src="img/logodefinitivo.png" alt="Logo"></a>
                    <ul class="primeranavopciones">
                        <li class="ladearriba"><input id="buscar" type="search" placeholder="BUSCAR"/></li>

                        <%
                            if (request.getSession().getAttribute("usuario") == null) {%>
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

        <main>
            <section class="concurso">
                <h1 class="h1">Concurso en TuCafetiko</h1>
                <article class="texto">
                    <p>En nuestra tienda de café, estamos emocionados de anunciar nuestro último concurso. </p>
                    <p>Participa en nuestro concurso y gana un lote completo de café Nespresso. ¿Cómo </p>
                    <p>participar? Sólo tienes que introducir un numero y si aciertas te llevas una cafetera.TU ELIGES CUAL. </p>

                </article>	

                <%
                    if (request.getSession().getAttribute("usuario") == null) {%>
                <a class="enlacelog" href="./login.jsp">INICIE SESIÓN AQUÍ PARA PARTICIPAR</a>
                <%} else {%>


                <article class="concurso">

                    <p class="numeroAleatorio"><%
                        if (session.getAttribute("numeroAl") != null) {
                            out.print(session.getAttribute("numeroAl"));
                        } else {
                            out.print("XX");
                        }

                        %></p>
                    <form action="concursoServlet">

                        <%if (session.getAttribute("ganador") == null) {%>
                        <input class="enviar" type="number" name="numero" required>
                        <input class="enviar" type="submit" value="Participar">
                        <%} else {%>
                        <p class="ganador"><%=session.getAttribute("ganador")%></p> 
                        <%}%>

                    </form>

                </article>
            </section>
            <%  }
            %>

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
