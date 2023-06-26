<%-- 
    Document   : products
    Created on : May 4, 2023, 10:59:51 AM
    Author     : ciclost
--%>

<%@page import="java.lang.Integer"%>
<%@page import="java.util.Enumeration"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="dto.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 

int contador =1;

CategoriaDAO cat = new CategoriaDAO();



String categoria = request.getParameter("categoria");

Integer codigo=0;

if (categoria != null) {
  if (categoria.equals("CAFETERA")) {
  
    codigo = cat.getCodigoDe("CAFETERA");
    
  } else if (categoria.equals("CAPSULA")) {
  
     codigo = cat.getCodigoDe("CAPSULA");
     
  } else if (categoria.equals("MOLIDO")) {
  
     codigo = cat.getCodigoDe("MOLIDO");
  }
}


ArrayList<Articulo> product= cat.getProductoByCodCateg(codigo);

%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/navegacion.css">
        <link rel="stylesheet" href="./css/molido.css">
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

        <main class="principal">

            <% try {
                    
                
                    
               
             
             for (Articulo arti : product) {%>
            <section class="molido<%=contador%>">

                <img class="imgStar" src="<%= arti.getFoto()%>" alt="Producto 1">
                <p class="textoBajo"><%= arti.getDescripcion()%></p>
                <p class="textoBajo"><%= arti.getPrecio()%> €</p>
                <a class="boton" href="producto.jsp?id=<%= arti.getCodigo()%>">Comprar</a>
            </section>
            <%        
                    
                    contador++;
                        
                     }
                     } catch (Exception e) {
                    out.print(" <h1>SERVIDOR CAIDO</h1> ");
                }
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