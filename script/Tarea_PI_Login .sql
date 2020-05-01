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
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000015P', 'Pepe', 'Pepinillo',1111127,'Espanol','4/9/2002');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('20000015Q', 'Pezonio', 'Giratorio',1111128,'Ruso','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000151', 'Croissante', 'Crujiente',1111129,'Frances','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000152', 'Toco', 'Lagaita',1111130,'Irlandés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000153', 'Sergiu', 'Crisan',1111131,'Rumano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000154', 'Florin', 'Padurariu',1111132,'Rumano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000155', 'Janini', 'Janono',1111133,'Hungaro','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000156', 'Peluson', 'Mariposon',1111134,'Finlandés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000157', 'Hasan', 'Mohamet',1111135,'Marroqui','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000158', 'Stefani', 'Pijilla',1111136,'Ecuatoriano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000159', 'Zahira', 'Pantalón',1111137,'Hati','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000110', 'Lucia', 'Lucesapagadas',1111138,'Irlandés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000111', 'Andrea', 'Mahou',1111139,'Española','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000112', 'Ainhoa', 'Aisia',1111140,'Irlandés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000112', 'Jessica', 'James',1111141,'Estadounidense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000113', 'Jennifer', 'Gonzalez',1111142,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000114', 'Rubén', 'Ruvete',1111143,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000115', 'Ivan', 'Iviene',1111144,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000116', 'Izan', 'Jose',1111145,'Canadiense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000117', 'Dani', 'Osann',1111146,'Rumano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000118', 'Daryl', 'Dixon',1111147,'Canadiense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000119', 'Carla', 'Marquesita',1111148,'Española','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000120', 'Nano', 'Elite',1111149,'Mexicano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000121', 'Nairobi', 'MiLleches',1111150,'Chilena','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000122', 'Andres', 'Solello',1111151,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000123', 'Tokio', 'Masserati',1111152,'Española','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000124', 'Nick', 'Clark',1111153,'Estadounidense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000125', 'Shaine', 'tamuerto',1111154,'Estadounidense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000126', 'Rick', 'Grimes',1111155,'Estadounidense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000127', 'Carl', 'Grimes',1111156,'Irlandés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000128', 'Michonne', 'Espada',1111157,'Colombiana','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000129', 'Negan', 'Lucille',1111158,'Canadiense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000130', 'Aaron', 'Pipper',1111159,'Alemán','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Steve', 'Nojobs',1111160,'Italiano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Benefacio', 'Huesos',1111161,'Argelino','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Mitocondria', 'Respiratoria',1111162,'Frances','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Teleco', 'Friki',1111163,'Inglés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Discordio', 'Molar',1111164,'Portugés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Cuarenteno', 'Acabaya',1111165,'Rumano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Veranus', 'Anosotrus',1111166,'Griego','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Jhon', 'Nieve',1111167,'Escocés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Escozór', 'Intenso',1111168,'Africano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Hambruno', 'Delgao',1111169,'Lituano','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Yosoy', 'Canicani',1111170,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Peter', 'Laanguila',1111171,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Osito', 'Gominola',1111172,'Francés','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Auron', 'Replay',1111173,'Español','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Stone', 'Wood',1111174,'Estadounidense','4/9/2000');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, nacionalidad, fecha_nacim) VALUES('200000131', 'Chancla', 'Quetelanzo',1111175,'Español','4/9/2000');




INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(4, 'villaviciosa', 'Ana','Juan');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(5, 'Alcobendas', 'Maria','Rosana');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(6, 'Valencia', 'Marta','Elena');

INSERT INTO USERS(USR, PWD, ROL) VALUES('Pedro Camacho', 'MiUniEsLaMejor', 'Tutor');
INSERT INTO USERS(USR, PWD, ROL) VALUES('Raul Dominguez', 'damexp', 'Tutor');
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
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M14000000', 'Adeslas S.A.', 'C/Villalobos Nº112', 600699612, 'Madrid','Ave Maria','hola@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M13000000', 'Quiron S.A.', 'C/Coruña Nº206', 600699613, 'Madrid','Yolanda Dali','QYolanda@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M12000000', 'Pol Poniente S.A.', 'C/Velazquez Nº56', 600699614, 'VillaPobreza','Javier Zurbaran','PJavier@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M11000000', 'Clg. Farma S.A.', 'c/Soroya Nº33', 600699615, 'Valencia','Eduardo Miro','CEduardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M10000000', 'Teclado S.A.', 'c/Victoria Nº25', 600699616, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M10000001', 'Raton S.A.', 'c/Dulu Nº11', 600699617, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M10000002', 'Cascos S.A.', 'c/Crle Nº95', 600699618, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M9000000', 'Xiaomi S.A.', 'c/Paloma Nº11', 600699619, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M8000000', 'Samsung S.A.', 'c/Palo Nº5', 600699610, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M7000000', 'Apple S.A.', 'c/Tecno Nº17', 600699698, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M6000000', 'REALME S.A.', 'c/Madrid Nº1', 600699612, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M5000000', 'HUAWEI S.A.', 'c/Barcelona Nº2', 600699613, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M4000000', 'BQ S.A.', 'c/Martires Nº3', 600699614, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M3000000', 'NZQQ S.A.', 'c/JuanCarlos Nº4', 600699615, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M2000000', 'LENOVO S.A.', 'c/Ordena Nº5', 600699616, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('M1000000', 'MSI S.A.', 'c/EncufeTv Nº6', 600699617, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S10000000', 'ASUS S.A.', 'c/Disipador Nº15', 600699618, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S20000000', 'AMAZON S.A.', 'c/Ranura Nº7', 600699619, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S30000000', 'EBAY S.A.', 'c/Pilar Nº8', 600699620, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S40000000', 'MercadoLibre S.A.', 'c/Dinerros Nº12', 600699621, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S50000000', 'WindForce S.A.', 'c/Vientto Nº9', 600699623, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S60000000', 'IDEA S.A.', 'c/Fuerza Nº10', 600699624, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S70000000', 'CONECTOR S.A.', 'c/RJ45 Nº11', 600699625, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S80000000', 'WINDOWS S.A.', 'c/VISTA Nº88', 600699626, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, resp_empresa, email) VALUES('S90000000', 'GOOGLE S.A.', 'c/Drive Nº15', 600699627, 'Santa Cruz de Tenerife','Ricardo Tapies','ARicardo@gmail.com');


INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0001, 'DAAAM-2020', 0050, 'DAMM');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0002, 'ASIR-2020', 0051, 'ASIR');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0003, 'DAW-2020', 0052, 'DAW');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0004, 'TAFAD_2020', 0053, 'TAFAD');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0005, 'ENFERMERIA-2020', 0054, 'ENFERMERIA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0006, 'MEDICINA-2020', 0055, 'MEDICINA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0007, 'INGENIERIA-2020', 0056, 'INGENIERIA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0008, 'VIDEOJUEGOS-2020', 0057, 'VIDEOJUEGOS');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(0009, 'ARTES_2020', 0058, 'ARTES');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00010, 'IMAGEN-2020', 0059, 'IMAGEN');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00011, 'FOROGRAFÍA-2020', 0060, 'FOROGRAFÍA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00012, 'ILUSTRACIÓN-2020', 0061, 'ILUSTRACIÓN');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00013, 'LITERATURA-2020', 0062, 'LITERATURA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00014, 'POESÍA_2020', 0063, 'POESÍA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00015, 'LATÍN-2020', 0064, 'LATÍN');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00016, 'MÚSICA-2020', 0065, 'MÚSICA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00017, 'TICO-2020', 0066, 'TICO');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00018, 'NATURALES-2020', 0067, 'NATURALES');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00019, 'GEOGRAFÍA_2020', 0068, 'GEOGRAFÍA');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(00020, 'CIENCIA-2020', 0069, 'CIENCIA');


INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('15000001A', 'Pedro ', 'Camacho Camacho', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('16000001B', 'Raul', 'Rodriguez Mercado', 5);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('17000001C', 'Ernesto', 'Ramirez Ramirez', 6);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('18000001D', 'Antonio', 'Martin Guzman', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001E', 'Alto ', 'Carlos', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001F', 'Diegi ', 'Holas', 5);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001G', 'Ramonso ', 'Foso', 6);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001H', 'Indigo ', 'Velasco', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001I', 'Ramon ', 'Cajón', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001J', 'Alfonsito ', 'Rellenito', 5);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001K', 'Luis ', 'Alonso', 6);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001L', 'Jesus ', 'Alfonsez', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001M', 'Marisa ', 'Maria', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001N', 'Monse ', 'Rodriguez', 5);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('19000001O', 'Carmen ', 'Carlota', 6);

INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('15000001A','Pedro Camacho');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('16000001B','Raul Dominguez');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('17000001C','Ernesto Ramirez');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('18000001D','Antonio Martin');
INSERT INTO registra(tutor_dni_tutor,USERS_USR) VALUES('19000001E','Felipe Delgado');

INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'I19000000', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'I18000000', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'I17000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'I16000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'I15000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'M14000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M13000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M12000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M11000000', 15005, '3/03/15', '2/05/11');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M10000000', 15005, '3/03/15', '2/05/11');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M10000001', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M10000002', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'M9000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'M8000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M7000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'M6000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M5000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M4000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M3000000', 15005, '3/03/15', '2/05/11');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M2000000', 15005, '3/03/15', '2/05/11');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'M1000000', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'S90000000', 15001, '2/7/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'S10000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'S20000000', 15002, '5/01/15', '2/06/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'S30000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(6,'S40000000', 15003, '02/08/15', '01/12/13');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'S50000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'S60000000', 15004, '09/05/15', '2/09/14');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'S70000000', 15005, '3/03/15', '2/05/11');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'S80000000', 15005, '3/03/15', '2/05/11');

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
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M14000000', 1111122, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Pedro ','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M13000000', 1111123, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Raul','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M12000000', 1111124, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Ernesto','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M11000000', 1111125, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M14000000', 1111126, '2/7/15', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Felipe','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M13000000', 1111127, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Pedro','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M12000000', 1111128, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Raul','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('M11000000', 1111129, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Ernesto','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S90000000', 1111130, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S10000000', 1111131, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S20000000', 1111132, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S30000000', 1111133, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S40000000', 1111134, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S50000000', 1111135, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S60000000', 1111136, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S70000000', 1111137, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S80000000', 1111138, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S90000000', 1111139, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S10000000', 1111140, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S20000000', 1111141, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S30000000', 1111142, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S40000000', 1111143, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S50000000', 1111144, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S60000000', 1111145, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S70000000', 1111146, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S80000000', 1111147, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S90000000', 1111148, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S10000000', 1111149, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('S20000000', 1111150, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111151, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111152, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111153, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111154, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111155, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111156, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111157, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111158, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111159, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111160, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111161, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111162, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111163, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111164, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111165, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111166, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111167, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111168, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111169, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111170, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I16000000', 1111171, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I17000000', 1111172, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I18000000', 1111173, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I19000000', 1111174, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore,acad) VALUES('I15000000', 1111175, '2/7/16', '2/7/15', '2/7/15', '2/7/15', '2/7/15', '3/7/15', 'de 9 a 5', 'Antonio','2019-2020');

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
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111127,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111128,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111129,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111130,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111131,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111132,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111133,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111134,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111135,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111136,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111137,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111138,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111139,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111140,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111141,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111142,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111143,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111144,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111145,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111146,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111147,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111148,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111149,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111150,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111151,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111152,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111153,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111154,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111155,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111156,0005, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111157,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111158,0002, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111159,0003, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111160,0004, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111161,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111162,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111163,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111164,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111165,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111166,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111167,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111168,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111169,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111170,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111171,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111172,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111173,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111174,0001, '2019-2020');
INSERT INTO pertenece(alumno_num_exp,grupo_cod_grupo, acad) VALUES(1111175,0001, '2019-2020');



-- SELECT * FROM PI.Users WHERE usr = 'Pedro Camacho' AND pwd = 'MiUniEsLaMejor';
-- Workspace: PI
-- Contraseña: password