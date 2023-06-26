CREATE TABLE PROYECTO_USUARIO(
email VARCHAR2(40) PRIMARY KEY,
nombre VARCHAR2(30) NOT NULL,
apellidos VARCHAR2(30) NOT NULL,
contrasenya VARCHAR2(20) NOT NULL,
telefono NUMBER(9),
fecha_nacimiento date,
fecha_ultima_conexion date ,
foto varchar2(30),
tipoUsuario varchar2(20) CHECK (tipoUsuario IN ('cliente', 'administrador')) 

);

CREATE TABLE PROYECTO_TICKET(
codigo NUMBER(6) PRIMARY KEY,
asunto VARCHAR2(20)NOT NULL,
mensaje VARCHAR2(500)NOT NULL,
email VARCHAR2(40) constraint fk_ticket references PROYECTO_USUARIO NOT NULL
);



CREATE TABLE PROYECTO_DIRECCION(
numero NUMBER(9),
email VARCHAR2(40) NOT NULL REFERENCES PROYECTO_USUARIO,
tipo VARCHAR2(20) NOT NULL,
direccion VARCHAR2(50) NOT NULL,
poblacion VARCHAR2(20) NOT NULL,
provincia VARCHAR2(20)NOT NULL,
codigo_postal NUMBER(5) NOT NULL,
CONSTRAINT PK_DIREECION  PRIMARY KEY(numero,email)

);

CREATE TABLE PROYECTO_CESTA(
nombre VARCHAR2(70)NOT NULL PRIMARY KEY,
tipo VARCHAR2(10)NOT NULL,
email_cliente  VARCHAR2(40) NOT NULL REFERENCES PROYECTO_USUARIO

);


CREATE TABLE PROYECTO_PEDIDOYFACTURACION(
codigo number(4),
fecha_pedido date NOT NULL,
numero number(9) NOT NULL,
email VARCHAR2(70) NOT NULL,
estado_facturacion varchar2(15) NOT NULL,
nombre_cesta VARCHAR2(70) constraint fk_NOM_CEST references PROYECTO_CESTA NOT NULL,
CONSTRAINT FK_NOMBRE_EMAIL FOREIGN KEY(numero,email) REFERENCES PROYECTO_DIRECCION,
PRIMARY KEY(codigo)
 
);                  



CREATE TABLE PROYECTO_ARTICULO(

codigo NUMBER(3) PRIMARY KEY,
PVP number(4) NOT NULL,
descripcion VARCHAR2(50)NOT NULL,
marca varchar2(20)NOT NULL,
unidad_medida Varchar(20) NOT NULL,
stock number(3)NOT NULL,
usuario_crea  VARCHAR2(40) REFERENCES PROYECTO_USUARIO,
usuario_modifica VARCHAR2(40) REFERENCES PROYECTO_USUARIO,
fecha_creacion date NOT NULL,
fecha_ultima_modificacion date NOT NULL,
foto VARCHAR2(80)

);

CREATE TABLE PROYECTO_LINEAS_PEDIDO(
codigo_articulo NUMBER(3) REFERENCES PROYECTO_ARTICULO NOT NULL,
nombre_cesta VARCHAR2(70) references PROYECTO_CESTA NOT NULL,
email  VARCHAR2(40) NOT NULL REFERENCES PROYECTO_USUARIO ,
precio number(4) not null,
cantidad number(2) not null,
PRIMARY KEY(codigo_articulo,nombre_cesta,email)

);

CREATE TABLE PROYECTO_CATEGORIA(
codigo number(4) PRIMARY KEY NOT NULL,
nombre varchar2(20) NOT NULL
);

CREATE TABLE PROYECTO_R_ARTICULO_CATEGORIA(
codigo_categoria NUMBER(4) REFERENCES PROYECTO_CATEGORIA,
codigo_articulo NUMBER(3) REFERENCES PROYECTO_ARTICULO,
PRIMARY KEY(codigo_categoria,codigo_articulo)
);



CREATE TABLE PROYECTO_CAFETERA(
tipo varchar2(30) NOT NULL,
Capacidad_del_deposito_de_capsulas number(2),
peso VARCHAR2(10) NOT NULL,
codigo_artic NUMBER(3) primary key references PROYECTO_ARTICULO NOT NULL
);

CREATE TABLE PROYECTO_CAPSULA(
tipo varchar2(30) NOT NULL,
cantidad_por_capsula VARCHAR2(10) NOT NULL,
codigo_artic NUMBER(3) primary key references PROYECTO_ARTICULO NOT NULL
);

CREATE TABLE PROYECTO_MOLIDO(
tipo varchar2(30) NOT NULL,
peso VARCHAR2(10) NOT NULL,
codigo_artic NUMBER(3) primary key references PROYECTO_ARTICULO NOT NULL
);


alter table PROYECTO_USUARIO add (check(fecha_nacimiento >= TO_DATE('01/01/2000', 'DD/MM/YYYY')));
alter table PROYECTO_USUARIO add (check(fecha_ultima_conexion >= TO_DATE('01/01/2000', 'DD/MM/YYYY')));
alter table PROYECTO_PEDIDOYFACTURACION add ( check (estado_facturacion in ('Facturado','No_Facturado')));
alter table PROYECTO_PEDIDOYFACTURACION add ( check (fecha_pedido >= TO_DATE ('01/01/2000', 'DD/MM/YYYY')));
alter table PROYECTO_ARTICULO add (check(fecha_creacion >= TO_DATE('01/01/2000', 'DD/MM/YYYY')));
alter table PROYECTO_ARTICULO add (check(fecha_ultima_modificacion >= TO_DATE('01/01/2000', 'DD/MM/YYYY')));



/*
DROP TABLE  PROYECTO_MOLIDO;
DROP TABLE  PROYECTO_CAPSULA;
DROP TABLE PROYECTO_CAFETERA;
DROP TABLE PROYECTO_R_ARTICULO_CATEGORIA;
DROP TABLE PROYECTO_CATEGORIA;
DROP TABLE PROYECTO_LINEAS_PEDIDO;
DROP TABLE PROYECTO_ARTICULO;
DROP TABLE PROYECTO_PEDIDOYFACTURACION;
DROP TABLE PROYECTO_CESTA;
DROP TABLE PROYECTO_DIRECCION;
DROP TABLE PROYECTO_TICKET;
DROP TABLE PROYECTO_USUARIO;
*/
