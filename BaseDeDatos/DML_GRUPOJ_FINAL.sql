INSERT INTO PROYECTO_USUARIO(email,nombre,apellidos,contrasenya,telefono,fecha_nacimiento,fecha_ultima_conexion,tipoUsuario) VALUES ('marcosramon.alu@iespacomolla.es','Marcos','Ramón','123456',691204438,TO_DATE('06/02/2023', 'DD/MM/YYYY'),TO_DATE('06/02/2023', 'DD/MM/YYYY'),'administrador');
INSERT INTO PROYECTO_USUARIO(email,nombre,apellidos,contrasenya,telefono,fecha_nacimiento,fecha_ultima_conexion,tipoUsuario) VALUES ('adrianpareja.alu@iespacomolla.es','Adrián ','Pareja','112233',694206430,TO_DATE('07/02/2023', 'DD/MM/YYYY'),TO_DATE('06/02/2023', 'DD/MM/YYYY'),'administrador');
INSERT INTO PROYECTO_USUARIO(email,nombre,apellidos,contrasenya,telefono,fecha_nacimiento,fecha_ultima_conexion,tipoUsuario) VALUES ('cliente.alu@iespacomolla.es','Luís','Enrique','654321',691305531,TO_DATE('06/01/2023', 'DD/MM/YYYY'),TO_DATE('06/02/2023', 'DD/MM/YYYY'),'cliente');


INSERT INTO PROYECTO_TICKET(codigo,email,asunto,mensaje) VALUES (000001,'marcosramon.alu@iespacomolla.es','Descuento','Descuento del 50%');
INSERT INTO PROYECTO_TICKET(codigo,email,asunto,mensaje) VALUES (000002,'adrianpareja.alu@iespacomolla.es','Descuento','Descuento del 51%');





INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('marcosramon.alu@iespacomolla.es',1, 'Calle', 'Calle de Madrid','Petrer','Alicante',03610);
INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('adrianpareja.alu@iespacomolla.es',2,'Calle', 'Emilio Rico','Elda','Alicante',03600);
INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('cliente.alu@iespacomolla.es',3,'Calle', 'Aristides Maillol','Barcelona','Barcelona',08028);
INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('marcosramon.alu@iespacomolla.es',4,'Calle', 'Calle de la Libertad','Madrid','Madrid',28001 );
INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('cliente.alu@iespacomolla.es',5,'Calle', 'Calle de Logroño','Madrid','Madrid',28001 );
INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('marcosramon.alu@iespacomolla.es',6,'Calle', 'Aristides Maillol','Madrid','Madrid',28001 );
INSERT INTO PROYECTO_DIRECCION(email,numero,tipo,direccion,poblacion,provincia,codigo_postal) VALUES('cliente.alu@iespacomolla.es',7,'Calle', 'Calle Parla','Madrid','Madrid',28001 );
 




/*C�?PSULAS*/

INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(1 ,4.90,'Cafe Master Origin Colombia ','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/colombia_XL.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(2 ,5,'Master Origin India','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/india_XL.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(3 ,5.50,'INFINIMENT ESPRESSO','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/infiniment-espresso.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(4 ,4.09,'Napoli','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/ispirazione-napoli-L.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(5 ,4.70,'Ristretto','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/ispirazione-ristretto_L.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(6 ,4.70,'Istambul','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/main-image_S (2).png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(7 ,4.70,'Paris','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/main-image_S.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(8 ,5,'Buenos Aires','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/buenosAires.avif');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(9 ,3.50,'Scuro','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/c2.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(10 ,6,'Vienna Lungo','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'),TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Capsulas/vienna-linizio-lungo_XL.png');

/*CAFETERAS*/

INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(11 ,109.90,'Inissia Ruby Roja ','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/cafetera1InissiaRubyRoja.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(12 ,119.90,'Essenza Mini Intense Gris','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Cafetera2EssenzaMiniIntenseGris.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(14 ,199.90,'Vertuo Plus Deluxe Titan ','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Cafetera4VertuoPlusDeluxeTitan.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(15 ,159.90,'Pixie Electric Red 3 ','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Cafetera5Pixie.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(16 ,109.90,'Vertuo Next Pod Blanca ','Nespresso','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Cafetera6VertuoNextPodBlanca.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(17 ,19.90,'Mimoka 1200 Blue ','Cecotec','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Italiana1Mimoka1200.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(18 ,16.90,'Mimoka 600 Shiny ','Cecotec','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Italiana2Mimoka600.png_md');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(19 ,11.90,'Mokclassic 300 beige ','Cecotec','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Italiana3Mokclassic300.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(20 ,85.90,'Moking 200 Acero Inoxidable ','Cecotec','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Italiana4Moking200.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion,marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(21 ,20.90,'Mokclassic 1200 Garnet ','Cecotec','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Cafetera/Italiana5Mokclassic1200Garnet.png');


/*MOLIDO*/

INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(23 ,5.10,'Blonde Espresso ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/starbucksBlondeEspresso.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(24 ,7.10,'Colombia ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/starbucksColombia.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(25 ,7.10,'Espresso Roast Dark ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/starbucksEspressoRoastDark.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(26 ,7.10,'House Blend Limited Edition ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/starbucksHouseBlen.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(27 ,6.90,'House Blend ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/StarbucksHouseBlend.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(28 ,7.30,'Pike Place Limited Edition ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/pike_place.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(29 ,6.80,'Pike Place ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/starbucksPikePlace.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(30 ,6.60,'Veranda Blend Limited Edition ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/veranda_blend_verde.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(31 ,6.10,'Veranda Blend ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/veranda_blend.png');
INSERT INTO PROYECTO_ARTICULO (codigo, PVP, descripcion, marca, unidad_medida, stock, fecha_creacion, fecha_ultima_modificacion, foto) VALUES(32 ,5.90,'Verona ','Starbucks','Unidades',500,TO_DATE('01/10/2022','DD/MM/YYYY'), TO_DATE('01/01/2023','DD/MM/YYYY'),'./img/Molido/starbucksVerona.png');





INSERT INTO PROYECTO_CATEGORIA VALUES(1,'CAFETERA');
INSERT INTO PROYECTO_CATEGORIA VALUES(2,'CAPSULA');
INSERT INTO PROYECTO_CATEGORIA VALUES(3,'MOLIDO');



INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,11);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,12);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,14);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,15);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,16);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,17);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,18);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,19);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,20);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (1,21);



INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,1);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,2);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,3);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,4);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,5);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,6);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,7);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,8);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,9);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (2,10);


INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,23);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,24);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,25);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,26);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,27);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,28);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,29);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,30);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,31);
INSERT INTO PROYECTO_R_ARTICULO_CATEGORIA(CODIGO_CATEGORIA,CODIGO_ARTICULO) VALUES (3,32);







UPDATE PROYECTO_USUARIO SET telefono=69128457 where email='marcosramon.alu@iespacomolla.es';

UPDATE PROYECTO_DIRECCION SET direccion='PLAZA MAYOR Nº3 2A' where email='marcosramon.alu@iespacomolla.es';
UPDATE PROYECTO_ARTICULO SET PVP=0.80 where codigo=1;


