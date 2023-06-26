<%-- 
    Document   : index
    Created on : Apr 29, 2023, 11:31:15 AM
    Author     : ciclost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/index.css">
        <link rel="stylesheet" href="./css/footer.css">
        <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Display&display=swap" rel="stylesheet">
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
                    <ul><li class="coloresnav"><a href="./index.jsp">HOME</a></li>
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
        <main class="principal">

            <section class="categorias">

                <h2 class="h2">CATEGORÍAS</h2>
                <p class="txtCateg">Descubre todos los productos que forman parte de este nuevo y revolucionario sistema de café.</p>

            </section>


            <section class="foto1">

                <img class="imgStar" src="./img/Cafetera/cafetera1InissiaRubyRoja.png" alt="Producto 1">
                <p class="textoBajo">CAFETERAS</p>
                <form  action="./products.jsp" method="post">
                    <input type="hidden" name="codigoCat" value="" />
                    <button class="boton" type="submit" name="categoria" value="CAFETERA">Ver Más</button>
                </form>

            </section>

            <section class="foto2">

                <img class="imgStar" src="./img/Molido/starbucksColombia.png" alt="Producto 2">
                <p class="textoBajo">CAFÉ MOLIDO</p>
                <form  action="./products.jsp" method="post">
                    <input type="hidden" name="codigoCat" value="" />
                    <button class="boton" type="submit" name="categoria" value="MOLIDO">Ver Más</button>
                </form>

            </section>

            <section class="foto3">

                <img class="imgStar" src="./img/Capsulas/colombia_XL.png" alt="Producto 3">
                <p class="textoBajo">CAFÉ CÁPSULAS</p>
                <form  action="./products.jsp" method="post">
                    <input type="hidden" name="codigoCat" value="" />
                    <button class="boton" type="submit" name="categoria" value="CAPSULA">Ver Más</button>
                </form>

            </section>

            <section class="concurso">

                <h2 class="h3">CONCURSO</h2>

                <p>¿Quieres disfrutar del verdadero sabor del cafe? Pues estas de suerte<br>ya que en TuCafetiko estamos de concurso!<br>Participia para ganar:</p>

                <button class="boton" onclick="window.location.href = './concurso.html'">Ver Más</button>

            </section>

            <section class="sNosotros">

                <h2 class="h3">SOBRE NOSOTROS</h2>

                <p>Conoce más sobre nosotros<br>nuestra ubicación, cómo realizamos nuestro trabajo<br>y por qué lo realizamos.</p>

                <button class="boton" onclick="window.location.href = './SobreNosotros.html'">Ver Más</button>

            </section>

            <section class="mVendidos">

                <h2 class="h2">MÁS VENDIDOS</h2>
                <p class="txtCateg">Descubre todos los productos que más se estan venidiendo esta temporada.</p>

            </section>

            <section class="foto4">

                <img class="imgStar" src="./img/Capsulas/india_XL.png" alt="Producto 1">
                <button class="boton"><a class="enlaceMasVend" href="./producto.jsp?id=2">Ver Más</a></button>

            </section>

            <section class="foto5">

                <img class="imgStar" src="./img/Cafetera/Cafetera6VertuoNextPodBlanca.png" alt="Producto 2">
                <button class="boton"><a class="enlaceMasVend" href="./producto.jsp?id=16">Ver Más</a></button>

            </section>

            <section class="foto6">

                <img class="imgStar" src="./img/Molido/starbucksEspressoRoastDark.png" alt="Producto 3">
                 <button class="boton"><a class="enlaceMasVend" href="./producto.jsp?id=25">Ver Más</a></button>

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
