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


        
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('111111t', 'Juan', 'Perez Garcia',1111112,'Espanol','2/2/1998');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('111112t', 'Pedro', 'lopez Garcia',1111113,'Frances','01/01/1999');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('111113t', 'Fernando', 'lapez Garcia',1111114,'Rumano','10/10/2001');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('111114t', 'Fernanda', 'Perez Garcia',1111115,'Ingles','03/03/2003');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('111115t', 'Juan Luis', 'lapiz Garcia',1523543,'Peruano','01/01/1997');

INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(4, 'villaviciosa', 'Ana','pepito');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(5, 'congo', 'Maria','Rosana');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(6, 'wuhan', 'Con','Chin Pan');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(7, 'Islas Canarias', 'Pedro','Fernandes');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(8, 'Valencia', 'Paxi','Perez');

INSERT INTO USERS(USR, PWD, ROL) VALUES('Pedro Camacho', 'MiUniEsLaMejor', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Raul Dominguez', 'damexp', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Ernesto Ramirez', 'SubnettingPOESIA', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Carlos Olas', 'UniNOfestivo', 'Director');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Domingo Diego', 'NosVemosEnJunioo', 'Director');

INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('aaaa1111', 'LaEmpresa S.A.', 'c/Desgracia Nº69', 654737382, 'Las VillaCarmen','Carlo Magno','hola@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('bbbb1111', 'Codigo S.A.', 'c/Madrid Nº21', 657856746, 'Los Matorrales','Zeus','hola@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('cccc1111', 'Javeros S.A.', 'c/SanJuan Nº01', 637463546, 'Las Piñas','El Cesar','hola@gmail.com');

INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('dddd1111', 'PorElCodigo S.A.', 'c/Burlaos Nº96', 609898767, 'VillaBosque','Aquaman','hola@gmail.com');

INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('eeee1111', 'SoftAMD S.A.', 'c/Miseria Nº99', 600699611, 'VillaPobreza','Ave Maria','hola@gmail.com');

INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(4, 'DAAAM', 0044, 'DOWN');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(5, 'LART', 0043, 'DAM');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(6, 'FUT', 0042, 'DAM');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(7, 'ASIR', 0041, 'AS');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(8, 'Loa', 0040, 'LO');


INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('159963A', 'Juan Carlos', 'Montero Delpalo', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('259861Z', 'Miguel Fuentes', 'Gutierrez Vacio', 5);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('759883V', 'Carlos Pana', 'Benito Iglesias', 6);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('951877P', 'Antonio Guzman', 'Martin Orlando', 7);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('999863V', 'Felipe Filipino', 'Delgado Alfonsez', 8);

INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('159963A','Pedro Camacho');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('259861Z','Raul Dominguez');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('759883V','Ernesto Ramirez');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('951877P','Carlos Olas');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('999863V','Domingo Diego');

INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'aaaa1111', 154895, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'bbbb1111', 118963, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'cccc1111', 756824, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(7,'dddd1111', 695470, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(8,'eeee1111', 502697, '3/03/15', '2/05/11');

INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('159963A',4, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('259861Z',5, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('759883V',6, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('951877P',7, '2/7/15', '2019-2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, acad) VALUES('999863V',8, '2/7/15', '2019-2020');

INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('aaaa1111', 1111112, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Dolores Fuertes de Barriga','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('bbbb1111', 1111113, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Marisa','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('cccc1111', 1111114, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Juan Manco','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('dddd1111', 1111115, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Anacardo','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('eeee1111', 1523543, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Estefaniaa','2019-2020');

INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111112,4, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111113,5, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111114,6, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111115,7, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1523543,8, '2019-2020');

-- SELECT * FROM PI.Users WHERE usr = 'Pedro Camacho' AND pwd = 'MiUniEsLaMejor';
-- Workspace: PI
-- Contraseña: password