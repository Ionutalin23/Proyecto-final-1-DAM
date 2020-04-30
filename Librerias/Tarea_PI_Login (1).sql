DROP TABLE tutor CASCADE CONSTRAINTS;
DROP TABLE centro CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE empresa CASCADE CONSTRAINTS;
DROP TABLE grupo CASCADE CONSTRAINTS;
DROP TABLE alumno CASCADE CONSTRAINTS;
DROP TABLE practica CASCADE CONSTRAINTS;
DROP TABLE colabora CASCADE CONSTRAINTS;
DROP TABLE gestiona CASCADE CONSTRAINTS;
DROP TABLE pertenece CASCADE CONSTRAINTS;
DROP TABLE registra CASCADE CONSTRAINTS;


CREATE TABLE alumno (
    dni         VARCHAR2(9 CHAR) NOT NULL,
    nombre      VARCHAR2(25 CHAR) NOT NULL,
    apellidos   VARCHAR2(55 CHAR) NOT NULL,
    num_exp     NUMBER(15) NOT NULL,
    nacionalidad VARCHAR2(50 CHAR) NOT NULL,
    fecha_nacim DATE NOT NULL
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( num_exp );

CREATE TABLE centro (
    cod_centro   NUMBER(1) NOT NULL,
    localidad    VARCHAR2(25 CHAR) NOT NULL,
    director     VARCHAR2(25 CHAR) NOT NULL,
    dat          VARCHAR2(25 CHAR) NOT NULL
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( cod_centro );

CREATE TABLE USERS (
    USR          VARCHAR2(50 CHAR) NOT NULL,
    PWD          VARCHAR2(30 CHAR) NOT NULL,
    ROL          VARCHAR2(25 CHAR) NOT NULL
);

ALTER TABLE USERS ADD CONSTRAINT USR_pk PRIMARY KEY ( USR );

CREATE TABLE colabora (
    centro_cod_centro   NUMBER(1) NOT NULL,
    empresa_cif         VARCHAR2(15 CHAR) NOT NULL,
    numconv             NUMBER NOT NULL,
    anexo_1             VARCHAR2(50 CHAR) NOT NULL,
    fecha               DATE NOT NULL
);

ALTER TABLE colabora ADD CONSTRAINT colabora_pk PRIMARY KEY ( centro_cod_centro,
                                                              empresa_cif );

CREATE TABLE empresa (
    cif         VARCHAR2(15 CHAR) NOT NULL,
    nombre      VARCHAR2(20 CHAR) NOT NULL,
    direccion   VARCHAR2(30 CHAR) NOT NULL,
    telefono    NUMBER(12) NOT NULL,
    localidad   VARCHAR2(50 CHAR) NOT NULL,
    resp_empresa VARCHAR2(50 CHAR) NOT NULL,
    email VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( cif );

CREATE TABLE gestiona (
    tutor_dni_tutor   VARCHAR2(9 CHAR) NOT NULL,
    grupo_cod_grupo   NUMBER(5) NOT NULL,
    anexo_2_2         DATE NOT NULL,
    acad             VARCHAR2(9) NOT NULL
);

ALTER TABLE gestiona ADD CONSTRAINT gestiona_pk PRIMARY KEY ( tutor_dni_tutor,
                                                              grupo_cod_grupo );

CREATE TABLE grupo (
    cod_grupo        NUMBER(5) NOT NULL,
    nom_grupo        VARCHAR2(50 CHAR) NOT NULL,
    clave_ciclo      NUMBER(10) NOT NULL,
    nombre_ciclo     VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( cod_grupo );

CREATE TABLE pertenece(

    alumno_num_exp     NUMBER(15) NOT NULL,
    grupo_cod_grupo    NUMBER(5) NOT NULL,
    acad              VARCHAR2(9) NOT NULL    

);

ALTER TABLE pertenece ADD CONSTRAINT pertenece_pk PRIMARY KEY ( grupo_cod_grupo , alumno_num_exp);

CREATE TABLE practica (
    empresa_cif      VARCHAR2(15 CHAR) NOT NULL,
    alumno_num_exp   NUMBER(15) NOT NULL,
    anexo_2_1        DATE NOT NULL,
    anexo_3          DATE NOT NULL,
    anexo_7          DATE NOT NULL,
    anexo_8          DATE NOT NULL,
    fecha_ini        DATE NOT NULL,
    fecha_fin        DATE NOT NULL,
    horario          VARCHAR2(50 CHAR) NOT NULL,
    tutore           VARCHAR2(50 CHAR) NOT NULL,
    acad            VARCHAR2(9) NOT NULL   
);

ALTER TABLE practica ADD CONSTRAINT practica_pk PRIMARY KEY ( empresa_cif,
                                                              alumno_num_exp );

CREATE TABLE tutor (
    dni_tutor           VARCHAR2(9 CHAR) NOT NULL,
    nombre              VARCHAR2(25 CHAR) NOT NULL,
    apellidos           VARCHAR2(50 CHAR) NOT NULL,
    centro_cod_centro   NUMBER(1)
);

ALTER TABLE tutor ADD CONSTRAINT tutor_pk PRIMARY KEY ( dni_tutor );

CREATE TABLE registra(

    tutor_dni_tutor   VARCHAR2(9 CHAR) NOT NULL,
    USERS_USR          VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE registra ADD CONSTRAINT registra_pk PRIMARY KEY ( tutor_dni_tutor , USERS_USR);



ALTER TABLE colabora
    ADD CONSTRAINT colabora_centro_fk FOREIGN KEY ( centro_cod_centro )
        REFERENCES centro ( cod_centro ) ON DELETE CASCADE;

ALTER TABLE colabora
    ADD CONSTRAINT colabora_empresa_fk FOREIGN KEY ( empresa_cif )
        REFERENCES empresa ( cif ) ON DELETE CASCADE;

ALTER TABLE gestiona
    ADD CONSTRAINT gestiona_grupo_fk FOREIGN KEY ( grupo_cod_grupo )
        REFERENCES grupo ( cod_grupo ) ON DELETE CASCADE;

ALTER TABLE gestiona
    ADD CONSTRAINT gestiona_tutor_fk FOREIGN KEY ( tutor_dni_tutor )
        REFERENCES tutor ( dni_tutor ) ON DELETE CASCADE;

ALTER TABLE practica
    ADD CONSTRAINT practica_alumno_fk FOREIGN KEY ( alumno_num_exp )
        REFERENCES alumno ( num_exp ) ON DELETE CASCADE;

ALTER TABLE practica
    ADD CONSTRAINT practica_empresa_fk FOREIGN KEY ( empresa_cif )
        REFERENCES empresa ( cif ) ON DELETE CASCADE;

ALTER TABLE tutor
    ADD CONSTRAINT tutor_centro_fk FOREIGN KEY ( centro_cod_centro )
        REFERENCES centro ( cod_centro ) ON DELETE CASCADE;
        
ALTER TABLE pertenece
    ADD CONSTRAINT pertenece_grupo_fk FOREIGN KEY ( grupo_cod_grupo )
        REFERENCES grupo(cod_grupo) ON DELETE CASCADE;

ALTER TABLE pertenece
    ADD CONSTRAINT pertenece_alumno_fk FOREIGN KEY ( alumno_num_exp )
        REFERENCES alumno(num_exp) ON DELETE CASCADE;
        
ALTER TABLE registra
    ADD CONSTRAINT registra_tutor_fk FOREIGN KEY ( tutor_dni_tutor )
        REFERENCES tutor(dni_tutor) ON DELETE CASCADE;

ALTER TABLE registra
    ADD CONSTRAINT registra_USERS_fk FOREIGN KEY ( USERS_USR )
        REFERENCES USERS(USR) ON DELETE CASCADE;


        
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000000A', 'Juan', 'Perez Garcia',1111112,'Espanol','2/2/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000001B', 'Pedro', 'lopez Fernandez',1111113,'Frances','01/01/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000003C', 'Fernando', 'Hernandez Carceller',1111114,'Rumano','10/10/2001');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000004D', 'Laura', 'Ramos Jimenez',1111115,'Ingles','03/03/2001');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000005E', 'Juan Luis', 'Parra Garrido',1111116,'Peruano','01/01/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000006F', 'Maria', 'Peña llistar',1111117,'Espanol','3/7/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000007G', 'Alba', 'Torres Bono',1111118,'Espanol','5/10/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000008H', 'Jose', 'Sanchez Altaba',1111119,'Espanol','1/11/2001');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000009I', 'Antonio', 'Rodilla Gimenez',1111120,'Espanol','8/8/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000010J', 'Carlos', 'Gascon Nager',1111121,'Espanol','3/5/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000011K', 'Paula', 'Buj Escorihuela',1111122,'Espanol','9/2/2001');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000012L', 'Natalia', 'Fretes Gordillo',1111123,'Espanol','7/3/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000013M', 'Irene', 'Santos Dauden',1111124,'Espanol','9/5/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000014N', 'Alicia', 'Ibañez Casas',1111125,'Espanol','6/1/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000015O', 'Luis', 'Villa Martinez',1111126,'Espanol','4/9/2001');



INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(4, 'villaviciosa', 'Ana','Juan');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(5, 'Alcobendas', 'Maria','Rosana');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(6, 'Valencia', 'Marta','Elena');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(7, 'Santa Cruz', 'Pedro','Jose Antonio');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(8, 'Malaga', 'Gloria','Calos');

INSERT INTO USERS(USR, PWD, ROL) VALUES('Pedro Camacho', 'MiUniEsLaMejor', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Raul Dominguez', 'LenguajeMarcas', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Ernesto Ramirez', 'SubnettingPOESIA', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Antonio Martin', 'AppFuncionaestupendo', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Felipe Delgado', 'Practicas', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Ana Manzaneda', 'SuperDirectora', 'Director');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Gloria Martin', 'NosVemosEnJunioo', 'Director');

INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('I19000000', 'Sonimar S.A.', 'C/Zabala Nº6', 654737382, 'Madrid','Arturo Velazquez','SArturo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('I18000000', 'Coneccting S.A.', 'AVD/ Aranda Nº53', 657856746, 'Madrid','Lucia Goya','DLucia@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('I17000000', 'Diseñoweb S.A.', 'C/Villalovos Nº20', 637463546, 'Mostoles','Oscar Murillo','DOscar@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('I16000000', 'Akerman S.A.', 'C/San Andres Nº96', 609898767, 'Valencia','Miguel Greco','AkermanMiguel@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('I15000000', 'SoftAMD S.A.', 'C/Marin Nº24', 600699611, 'Santa Cruz','Adrian Picasso','SAdrian@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M14000000', 'Adeslas S.A.', 'C/Villalobos Nº112', 600699611, 'Madrid','Ave Maria','hola@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M13000000', 'Quiron S.A.', 'C/Coruña Nº206', 600699611, 'Madrid','Yolanda Dali','QYolanda@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M12000000', 'Pol Poniente S.A.', 'C/Velazquez Nº56', 600699611, 'VillaPobreza','Javier Zurbaran','PJavier@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M11000000', 'Clg. Farma S.A.', 'c/Soroya Nº33', 600699611, 'Valencia','Eduardo Miro','CEduardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M10000000', 'Asebio S.A.', 'c/Manrique Nº15', 600699611, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');


INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0001, 'DAAAM-2020', 0050, 'DAMM');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0002, 'ASIR-2020', 0051, 'ASIR');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0003, 'DAW-2020', 0052, 'DAW');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0004, 'TAFAD_2020', 0053, 'TAFAD');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0005, 'ENFERMERIA-2020', 0054, 'ENFERMERIA');


INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('15000001A', 'Pedro ', 'Camacho Camacho', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('16000001B', 'Raul', 'Rodriguez Mercado', 5);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('17000001C', 'Ernesto', 'Ramirez Ramirez', 6);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('18000001D', 'Antonio', 'Martin Guzman', 7);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001E', 'Felipe ', 'Delgado Alfonsez', 8);

INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('15000001A','Pedro Camacho');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('16000001B','Raul Dominguez');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('17000001C','Ernesto Ramirez');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('18000001D','Antonio Martin');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('19000001E','Felipe Delgado');

INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'I19000000', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M14000000', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'I18000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'M13000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'I17000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'M12000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(7,'I16000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(7,'M11000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(8,'I15000000', 15005, '3/03/15', '2/05/11');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(8,'M10000000', 15005, '3/03/15', '2/05/11');

INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('15000001A',0001, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('16000001B',0002, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('17000001C',0003, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('18000001D',0004, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('19000001E',0005, '2/7/15', '2019-2020');

INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111112, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Pedro ','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111113, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Raul','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111114, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Ernesto','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111115, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111116, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Felipe','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111117, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Pedro ','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111118, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Raul','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111119, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Ernesto','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111120, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111121, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Felipe','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111122, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Pedro ','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111123, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Raul','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111124, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Ernesto','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111125, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111126, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Felipe','2019-2020');

INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111112,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111113,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111114,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111115,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111116,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111117,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111118,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111119,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111120,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111121,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111122,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111123,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111124,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111125,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111126,0005, '2019-2020');


-- SELECT * FROM PI.Users WHERE usr = 'Pedro Camacho' AND pwd = 'MiUniEsLaMejor';
-- Workspace: PI
-- Contraseña: password