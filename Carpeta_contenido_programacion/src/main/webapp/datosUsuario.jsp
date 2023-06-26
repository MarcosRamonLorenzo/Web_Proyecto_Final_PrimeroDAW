<%-- 
    Document   : datosUsuario
    Created on : 9 May 2023, 19:10:50
    Author     : ciclost
--%>

<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
      
      Usuario u = (Usuario) session.getAttribute("usuario");
      
 
%>
<!DOCTYPE html>
<html lang="es">
<head>
    
    <link rel="stylesheet" href="./css/navegacion.css">
    <link rel="stylesheet" href="./css/usuario.css">
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

    <main class="principal">

        <h2 class="h2">PERFIL</h2>

        <section>

            <article class="nombre"><strong>Nombre:</strong> <%= u.getNombre() %> </article>
            <article class="apellidos"><strong>Apellidos:</strong> <%= u.getApellidos() %></article>
            <article class="mail"><strong>Email:</strong> <%=u.getEmail() %> </article>
            <article class="telefono"><strong>Telefono:</strong> <%= u.getTelefono() %></article>
            <article class="fNac"><strong>Fecha de Nacimiento:</strong> <%=u.getFechaNacimiento().toString() %></article>

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
