<%-- 
    Document   : login
    Created on : Apr 28, 2023, 2:53:27 PM
    Author     : ciclost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>TuCafetiko</title>
        <meta name="description" content="HTML5">
        <meta name="author" content="Adrián Pareja Morote">
        <link rel="stylesheet" href="css/csslogin.css">
        <link rel="shortcut icon" href="favicon.ico">
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/footer.css">
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
                           <% }
                            else {%>
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
            <form action="LoginServletPR" method="post">
                <h2>LOGIN</h2>
                <label id="user" for="user">Usuario </label>
                <input placeholder="Introduce el usuario" type="text" name="email">
                <br>
                <label for="password">Contraseña </label>
                <input id="password" placeholder="Introduce la contraseña" type="password" name="password">
                <br>
                <a id="olvido" href="#">He olvidado la contraseña</a>
                <br>
                <input type="submit" value="acceder" />  
                
                <%
                if (request.getAttribute("error") != null && (boolean) request.getAttribute("error")) {
                    out.println("<p>(*) Nombre de correo o contraseña inválidos. Vuelve a intentarlo</p>");
                }
                %>
            
            </form>
            <h4><a id="registrate" href="Registro.html">No tienes una cuenta, <u>regístrate</u></a></h4>
            <script src="js/scripts.js"></script>
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
