<%-- 
    Document   : informacion
    Created on : 22 May 2023, 17:06:03
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
        <link rel="stylesheet" href="./css/informacion.css">
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
			<section class="primerasec">
					<section class="fotos">
                <img class="logo nespresso" src="./img/logo.png" alt="fotoLogo">
				<img class="logo starbucks" src="./img/logoStarbucks.png" alt="fotoLogo">
					</section>
                <p>Bienvenidos a nuestra tienda de café. Ofrecemos una amplia variedad de productos, </p>
                <p>incluyendo cápsulas de café, café molido y cafeteras de diferentes modelos y marcas. </p>
                <p>Nuestros productos son de alta calidad y están diseñados para satisfacer los gustos de</p>
                <p>nuestros clientes más exigentes. La tienda fue fundada por Marcos Ramón Lorenzo y Adrián</p>
                <p>Paraje Morote, dos apasionados del café. Si necesitas ayuda para elegir el producto </p>
                <p>adecuado, no dudes en ponerte en contacto con nosotros a través de nuestros correos </p>
                <p>electrónicos:</p>

            </section>
            <section class="segundasec">
                <h2>Nuestros creadores</h2>
                    
                    <ul class="correos">
                    	<li>Marcos Ramón Lorenzo: <a href="mailto:marcosramon.alu@iespacomolla.es">marcosramon.alu@iespacomolla.es</a></li>
                    	<li>Adrián Paraje Morote: <a href="mailto:adrianpareja.alu@iespacomolla.es">adrianpareja.alu@iespacomolla.es</a></li>
                    </ul>
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
