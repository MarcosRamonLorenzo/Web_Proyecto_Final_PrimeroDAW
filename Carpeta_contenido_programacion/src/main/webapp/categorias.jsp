<%-- 
    Document   : categorias
    Created on : May 4, 2023, 10:55:33 AM
    Author     : ciclost
--%>
<%@page import="dao.CategoriaDAO"%>
<%

    CategoriaDAO cat = new CategoriaDAO();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/categorias.css">
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

            <form class="principal" action="./products.jsp" method="post">
                <input type="hidden" name="codigoCat" value="" />
                <section class="cafeteras">

                    <img class="imgStar" src="./img/Cafetera/cafetera1InissiaRubyRoja.png" alt="Producto 1">
                    <p class="textoBajo">CAFETERAS</p>
                    <button class="boton" type="submit" name="categoria" value="CAFETERA">Ver Más</button>


                </section>

                <section class="molido">

                    <img class="imgStar" src="./img/Molido/starbucksColombia.png" alt="Producto 2">
                    <p class="textoBajo">CAFÉ MOLIDO</p>
                    <button class="boton" type="submit" name="categoria" value="MOLIDO">Ver Más</button>

                </section>

                <section class="capsulas">

                    <img class="imgStar" src="./img/Capsulas/colombia_XL.png" alt="Producto 3">
                    <p class="textoBajo">CAFÉ CÁPSULAS</p>
                    <button class="boton" type="submit" name="categoria" value="CAPSULA">Ver Más</button>

                </section>
            </form>



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