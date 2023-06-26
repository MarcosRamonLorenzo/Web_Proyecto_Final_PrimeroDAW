<%-- 
    Document   : SobreNosotros
    Created on : 22 May 2023, 17:03:31
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
        <link rel="stylesheet" href="./css/cssSobreNosotros.css">
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

            <section class="texto">
                <h3>Conoce el trabajo de nuestra tienda y sobre nuestra historia</h3>
                <article class="texto_img">

                    <article class="textaco">
                        <p>En la ciudad de Elda/Petrer, España, vivían dos amigos inseparables: Adrián y Marcos. Los dos compartían una pasión por el café, una bebida que les encantaba por su aroma, sabor y variedad. Se conocieron en la universidad mientras estudiaban administración de empresas y rápidamente se dieron cuenta de que compartían un sueño: abrir su propia tienda de café en línea.</p>
                        <br>
                        <p>Adrián y Marcos se dieron cuenta de que para llevar a cabo su proyecto necesitaban adquirir conocimientos profundos sobre el café. A pesar de que en España existían varias tiendas de café, querían aprender más sobre el proceso de producción y la cultura detrás de esta bebida en otro lugar del mundo. Por lo tanto, decidieron viajar a Colombia, uno de los principales productores de café en el mundo.</p>
                        <br>
                        <p>El viaje fue toda una aventura para ellos. Llegaron a Bogotá, la capital colombiana, y allí comenzaron a buscar información sobre la industria del café. Descubrieron que Colombia era el tercer mayor productor de café del mundo, después de Brasil y Vietnam. También se dieron cuenta de que existían diferentes regiones cafeteras en Colombia, cada una con sus propias características y sabores únicos.</p>
                        <br>
                        <p>Decidieron visitar algunas de estas regiones para aprender más sobre la producción de café y la cultura cafetera en Colombia. Fueron a la región del Eje Cafetero, donde visitaron varias fincas cafeteras y aprendieron sobre el proceso de cultivo, cosecha y producción del café. También conocieron a los productores locales y degustaron diferentes tipos de café.
                        </p>
                        <br>
                        <p>Después de varios meses de aprendizaje en Colombia, Pablo y Luis regresaron a España con una gran cantidad de información y experiencias valiosas sobre el café. Decidieron que era el momento de poner en práctica todo lo que habían aprendido y e iniciaron su tienda online.</p>
                    </article>
                    <article class="image">
                        <img class="img" src="./img/aboutUs.jpg" alt="">
                    </article>
                </article>
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
