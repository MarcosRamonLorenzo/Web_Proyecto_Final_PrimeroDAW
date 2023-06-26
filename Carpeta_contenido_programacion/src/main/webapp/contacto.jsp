<%-- 
    Document   : contacto
    Created on : 22 May 2023, 17:04:08
    Author     : ciclost
--%>

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
        <link rel="stylesheet" href="./css/contacto.css">
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

            <section class="contacto">
                <h1 class="h1">Ponte en Contacto</h1>
                <p>En esta sección usted puede ponerse en contacto con nosotros por </p>
                     <p>si le ha dado algun problema con algun producto de nuestra tienda </p>
                     <p>la con algún servicio de envío o de empaquetado que  </p>
                     <p> pueda afectar a la calidad del producto a la hora de la entrega.</p>

            </section>

            <section class="formulario">
                <form action="EnviarCorreoServlet" method="post">
                    <label for="email">Email:</label>
                    <input class="form" type="email" id="email" name="email" required><br>
                    <label for="subject">Asunto:</label>
                    <input class="form" type="text" id="subject" name="subject" required><br>
                    <label for="message">Mensaje:</label><br>
                    <textarea id="message" name="message" rows="4" cols="50" required></textarea><br>
                    <input class="enviar" type="submit" value="Enviar">
                </form>

            </section>

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
