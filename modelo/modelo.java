package modelo;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import vista.Busqueda_Alumnos;
import vista.Busqueda_Anexos;
import vista.Busqueda_Empresas;
import vista.Busqueda_Grupos;
import vista.Busqueda_Tutores;
import vista.MenuVista;
import vista.Ventana_Conf_Anexo;
import vista.Ventana_Estadisticas;
import vista.Ventana_Conf_Delete;
import vista.Ventana_Login;
import vista.Ventana_Login_Config;
import vista.Ventana_Mensaje_ERROR;
import vista.Vista_Info_Alumno;
import vista.Vista_Info_Empresa;
import vista.Vista_Info_Grupo;
import vista.Vista_Info_Tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class modelo {

//	================================================ MVC =========================================
	private Ventana_Login vista_ventana_login;
	private MenuVista vista_ventana_menu;
	private Busqueda_Alumnos busquedaAlumnos;
	private Busqueda_Anexos busquedaAnexos;
	private Busqueda_Empresas busquedaEmpresas;
	private Busqueda_Grupos busquedaGrupos;
	private Busqueda_Tutores busquedaTutores;
	private Vista_Info_Tutor vista_info_tutor;
	private Vista_Info_Empresa vista_info_empresa;
	private Vista_Info_Alumno vista_info_alumno;
	private Vista_Info_Grupo vista_info_grupo;
	private Ventana_Login_Config vista_login_config;
	private Ventana_Mensaje_ERROR ventana_mensaje_error;
	private Ventana_Estadisticas ventana_estadisticas;
	private Ventana_Conf_Delete ventana_conf_delete;
	private Ventana_Conf_Anexo ventana_conf_anexo;
//  ============================================================================================================================

	public void setVista(Busqueda_Alumnos busquedaAlumnos) {
		this.busquedaAlumnos = busquedaAlumnos;
	}

	public void setVista(Busqueda_Anexos busquedaAnexos) {
		this.busquedaAnexos = busquedaAnexos;
	}

	public void setVista(Busqueda_Empresas busquedaEmpresas) {
		this.busquedaEmpresas = busquedaEmpresas;
	}

	public void setVista(Busqueda_Grupos busquedaGrupos) {
		this.busquedaGrupos = busquedaGrupos;
	}

	public void setVista(Busqueda_Tutores busquedaTutores) {
		this.busquedaTutores = busquedaTutores;
	}

	public void setVista(Ventana_Login vista_ventana_login) {
		this.vista_ventana_login = vista_ventana_login;
	}

	public void setVista(Ventana_Login_Config vista_login_config) {
		this.vista_login_config = vista_login_config;
	}

	public void setVista(MenuVista vista_ventana_menu) {
		this.vista_ventana_menu = vista_ventana_menu;
	}

	public void setVista(Vista_Info_Tutor vista_info_tutor) {
		this.vista_info_tutor = vista_info_tutor;
	}

	public void setVista(Vista_Info_Empresa vista_info_empresa) {
		this.vista_info_empresa = vista_info_empresa;
	}

	public void setVista(Vista_Info_Alumno vista_info_alumno) {
		this.vista_info_alumno = vista_info_alumno;
	}

	public void setVista(Vista_Info_Grupo vista_info_grupo) {
		this.vista_info_grupo = vista_info_grupo;
	}

	public void setVista(Ventana_Mensaje_ERROR ventana_mensaje_error) {
		this.ventana_mensaje_error = ventana_mensaje_error;
	}

	public void setVista(Ventana_Estadisticas ventana_estadisticas) {
		this.ventana_estadisticas = ventana_estadisticas;
	}

	public void setVista(Ventana_Conf_Anexo ventana_conf_anexo) {
		this.ventana_conf_anexo = ventana_conf_anexo;
	}

//  ========================================================================= MVC ====================================================

	private String[] credenciales = new String[3];
	private ArrayList<Integer> alumnosEstadisticas = new ArrayList<Integer>();
	private LinkedHashMap<String, Integer> gruposAlumnos = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> tutorAlumnos = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> tutorCiclos = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> alumnosEmpresa = new LinkedHashMap<String, Integer>();
	private String nombreTabla;
	private String nombreClave;
	private String clave;
	private String cifEmpresa;
	private int anexoSeleccionado;
	private String nombreAnexo;
	private String nombreTablaAnexo;
	private Connection conexion;
	private int fallos;
	private String resultado;
	private String resultadoAlum;
	private String resultadoUsu;
	private String resultadoDEL;
	private String USR;
	private String rol;
	private String SQLanexo2_1 = "SELECT num_exp \"EXPEDIENTE\",nombre, apellidos, anexo_2_1 FROM PI.alumno, PI.practica WHERE num_exp=alumno_num_exp";
	private String SQLanexo1 = "SELECT E.cif, E.nombre \"Empresa\",C.cod_centro, C.localidad, C.director, CO.anexo_1 FROM PI.centro C, PI.colabora CO, PI.empresa E WHERE CO.centro_cod_centro=C.cod_centro AND  CO.empresa_cif=E.cif";
	private String SQLanexo2_2 = "SELECT A.num_Exp,A.nombre, A.apellidos,CONCAT(GR.nom_grupo,CONCAT(',',GR.cod_grupo)) \"GRUPO\", CONCAT(E.nombre,CONCAT(',',E.cif)) \"EMPRESA\", PR.horario, G.Anexo_2_2 FROM PI.alumno A, PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.Tutor T, PI.centro C, "
			+ "PI.colabora CO, PI.Empresa E, PI.practica PR WHERE A.num_exp=P.alumno_num_exp AND T.dni_tutor=G.tutor_dni_tutor AND C.cod_centro=T.centro_cod_centro AND CO.empresa_cif=E.cif "
			+ "AND P.grupo_cod_grupo=GR.cod_grupo AND G.grupo_cod_grupo=GR.cod_grupo AND CO.centro_cod_centro=C.cod_centro\n"
			+ "AND PR.empresa_cif=E.cif AND PR.alumno_num_exp=A.num_exp";
	private String SQLanexo3 = "SELECT A.num_exp, A.nombre, A.apellidos, PR.anexo_3 FROM PI.alumno A, PI.practica PR WHERE num_exp=alumno_num_exp";
	private String SQLanexo7 = "SELECT A.num_exp, A.nombre, A.apellidos, PR.anexo_7 FROM PI.alumno A, PI.practica PR WHERE A.num_exp=PR.alumno_num_exp";
	private String SQLanexo8 = "SELECT A.num_exp, A.nombre, A.apellidos,CONCAT(C.localidad,CONCAT(',',C.cod_centro)) \"CENTRO\", CONCAT(E.nombre,CONCAT(',',E.cif)) \"EMPRESA\", PR.anexo_8 FROM PI.alumno A, PI.practica PR, PI.empresa E, PI.centro C, PI.colabora CO WHERE num_exp=alumno_num_exp AND PR.empresa_cif=E.cif\n"
			+ "AND CO.empresa_cif=E.cif AND C.cod_centro=CO.centro_cod_centro";
	
	
	private String SQLTut = "SELECT TU.dni_tutor, TU.nombre, TU.apellidos, TU.centro_cod_centro FROM PI.TUTOR TU, PI.GESTIONA GE WHERE TU.dni_tutor= GE.tutor_dni_tutor AND GE.ACAD = '2018-2019' ";
	private String SQLTut2 = "SELECT TU.dni_tutor, TU.nombre, TU.apellidos, TU.centro_cod_centro FROM PI.TUTOR TU, PI.GESTIONA GE WHERE TU.dni_tutor= GE.tutor_dni_tutor AND GE.ACAD = '2019-2020' ";
	
	private String SQLTut_2 = "SELECT nombre, apellidos,clave_ciclo, nombre_ciclo FROM PI.Tutor TU, PI.Grupo GR, PI.Gestiona GE WHERE TU.dni_tutor = GE.tutor_dni_tutor AND GE.grupo_cod_grupo = GR.cod_grupo AND nombre_ciclo ='DAMM'";
	
	
	private String SQAlumno = "SELECT AL.dni, AL.nombre, AL.apellidos, AL.num_exp, AL.nacionalidad, AL.fecha_nacim FROM PI.alumno AL, PI.Pertenece PE WHERE AL.num_exp = PE.alumno_num_exp AND PE.acad = '2018-2019'";
	private String SQLAlumno2= "SELECT AL.dni, AL.nombre, AL.apellidos, AL.num_exp, AL.nacionalidad, AL.fecha_nacim FROM PI.alumno AL, PI.Pertenece PE WHERE AL.num_exp = PE.alumno_num_exp AND PE.acad = '2019-2020'";
	
	private String SQLEmp = "SELECT EM.CIF, EM.nombre, EM.direccion, EM.telefono, EM.localidad, EM.resp_empresa, EM.email FROM PI.empresa EM, PI.Practica PR WHERE EM.cif = PR.empresa_cif  AND PR.acad = '2018-2019'";
	private String SQLEmp2 = "SELECT EM.CIF, EM.nombre, EM.direccion, EM.telefono, EM.localidad, EM.resp_empresa, EM.email FROM PI.empresa EM, PI.Practica PR WHERE EM.cif = PR.empresa_cif  AND PR.acad = '2019-2020'";
	
	
	private String SQLGrp = "SELECT DISTINCT GR.cod_grupo, GR.nom_grupo, GR.clave_ciclo, GR.nombre_ciclo FROM PI.grupo GR, PI.Pertenece PE WHERE GR.cod_grupo = PE.grupo_cod_grupo AND PE.acad ='2018-2019'  ";
	private String SQLGrp2 = "SELECT DISTINCT GR.cod_grupo, GR.nom_grupo, GR.clave_ciclo, GR.nombre_ciclo FROM PI.grupo GR, PI.Pertenece PE WHERE GR.cod_grupo = PE.grupo_cod_grupo AND PE.acad ='2019-2020' ";

	
	
	private String SqlEstadisticasPracticas = "SELECT COUNT(ANEXO_2_1) FROM PI.practica where ? IS NOT NULL";
	private String SqlEstadisticasPracticas2 = "SELECT COUNT(?) FROM PI.practica where ANEXO_2_1 IS NULL";
	private String SqlGruposAlumnos = "select nom_grupo \"GRUPO\", count(*) \"ALUMNOS\" from PI.grupo, PI.alumno, PI.pertenece where alumno.num_exp=pertenece.alumno_num_exp AND grupo.cod_grupo=pertenece.grupo_cod_grupo group by grupo.nom_grupo";
	private String SqlAlumnosTutor="SELECT G.acad \"AÑO\", concat(t.nombre,concat('-->',gr.nombre_ciclo)) \"TUTOR\",count(*) \"Alumnos\" FROM PI.grupo GR, PI.gestiona G, PI.tutor T, PI.alumno A, PI.pertenece P WHERE GR.cod_grupo=G.grupo_cod_grupo AND G.tutor_dni_tutor=T.dni_tutor\n" + 
			"AND A.num_exp=P.alumno_num_exp AND P.grupo_cod_grupo=GR.cod_grupo group by G.acad, T.nombre, GR.nombre_ciclo";
	private String SQLanexo1Busqueda = "SELECT E.cif, E.nombre \"Empresa\",C.cod_centro, C.localidad, C.director, CO.anexo_1 FROM PI.centro C, PI.colabora CO, PI.empresa E WHERE CO.centro_cod_centro=C.cod_centro AND  CO.empresa_cif=E.cif AND E.nombre LIKE ?";
	private String SQLanexo2_1Busqueda = "SELECT num_exp \"EXPEDIENTE\",nombre, apellidos, anexo_2_1 FROM PI.alumno, PI.practica WHERE num_exp=alumno_num_exp AND nombre LIKE ?";
	private String SQLanexo2_2Busqueda = "SELECT A.num_Exp,A.nombre, A.apellidos,CONCAT(GR.nom_grupo,CONCAT(',',GR.cod_grupo)) \"GRUPO\", CONCAT(E.nombre,CONCAT(',',E.cif)) \"EMPRESA\", PR.horario, G.Anexo_2_2 FROM PI.alumno A, PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.Tutor T, PI.centro C, "
			+ "PI.colabora CO, PI.Empresa E, PI.practica PR WHERE A.num_exp=P.alumno_num_exp AND T.dni_tutor=G.tutor_dni_tutor AND C.cod_centro=T.centro_cod_centro AND CO.empresa_cif=E.cif "
			+ "AND P.grupo_cod_grupo=GR.cod_grupo AND G.grupo_cod_grupo=GR.cod_grupo AND CO.centro_cod_centro=C.cod_centro\n"
			+ "AND PR.empresa_cif=E.cif AND PR.alumno_num_exp=A.num_exp AND A.nombre LIKE ?";
	private String SQLanexo3Busqueda = "SELECT A.num_exp, A.nombre, A.apellidos, PR.anexo_3 FROM PI.alumno A, PI.practica PR WHERE num_exp=alumno_num_exp AND A.nombre LIKE ?";
	private String SQLanexo7Busqueda = "SELECT A.num_exp, A.nombre, A.apellidos, PR.anexo_7 FROM PI.alumno A, PI.practica PR WHERE A.num_exp=PR.alumno_num_exp AND A.nombre LIKE ?";
	private String SQLanexo8Busqueda = "SELECT A.num_exp, A.nombre, A.apellidos,CONCAT(C.localidad,CONCAT(',',C.cod_centro)) \"CENTRO\", CONCAT(E.nombre,CONCAT(',',E.cif)) \"EMPRESA\", PR.anexo_8 FROM PI.alumno A, PI.practica PR, PI.empresa E, PI.centro C, PI.colabora CO WHERE num_exp=alumno_num_exp AND PR.empresa_cif=E.cif\n"
			+ "AND CO.empresa_cif=E.cif AND C.cod_centro=CO.centro_cod_centro AND A.nombre LIKE ?";
	private String SQLinforme1 = "SELECT G.acad \"AÑO\", T.nombre \"TUTOR\", GR.nombre_ciclo \"Ciclo\", count(*) \"Alumnos\", E.nombre \"EMPRESA\", PR.anexo_2_1 \"Anexo 2.1\",PR.anexo_3 \"Anexo 3\",PR.anexo_7 \"Anexo 7\", PR.anexo_8 \"Anexo 8\" FROM PI.grupo GR, PI.gestiona G, PI.tutor T, PI.alumno A, PI.pertenece P, PI.practica PR, PI.empresa E WHERE GR.cod_grupo=G.grupo_cod_grupo AND G.tutor_dni_tutor=T.dni_tutor\n" + 
			"AND A.num_exp=P.alumno_num_exp AND P.grupo_cod_grupo=GR.cod_grupo AND A.num_exp=PR.alumno_num_exp AND PR.empresa_cif=E.cif group by G.acad, T.nombre, GR.nombre_ciclo,E.nombre, PR.anexo_2_1, PR.anexo_3, PR.anexo_7, PR.anexo_8";
	private String SQLinforme2 ="SELECT G.acad \"AÑO\", GR.nombre_ciclo \"CICLO\", T.dni_tutor \"DNI\", T.nombre, T.apellidos, C.Localidad \"CENTRO\", GR.nom_grupo \"GRUPO\" FROM PI.grupo GR, PI.gestiona G, PI.tutor T, PI.centro C WHERE GR.cod_grupo=G.grupo_cod_grupo AND G.tutor_dni_tutor=T.dni_tutor AND T.centro_cod_centro=C.cod_Centro";
	private String SQLinforme3 ="Select P.acad \"AÑO\", CO.numconv \"Nºconv\", E.nombre \"EMPRESA\", A.dni, A.nombre, GR.nom_grupo \"GRUPO\", T.nombre \"TUTOR.C\", PR.tutore \"TUTORE\" FROM PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.tutor T, PI.colabora CO, PI.empresa E, PI.practica PR, PI.alumno A "
			+ "WHERE A.num_exp=PR.alumno_num_exp AND PR.empresa_cif=E.cif AND E.cif=CO.empresa_cif AND A.num_Exp=P.alumno_num_exp AND P.grupo_cod_grupo=GR.cod_grupo AND GR.cod_grupo=G.grupo_cod_grupo AND G.tutor_dni_tutor=T.dni_tutor order by E.nombre";
	private String SQLinforme4="SELECT PR.acad \"AÑO\", T.nombre \"TUTOR C.\",GR.nombre_ciclo \"CICLO\",A.nombre \"ALUMNO\", E.nombre \"EMPRESA\",CO.numconv \"NºCONV\",concat(PR.fecha_ini,concat('-',PR.fecha_fin)) \"FECHAS\", PR.horario \"HORARIO\", PR.tutore \"TUTOR E.\" FROM PI.alumno A, PI.practica PR,\n" + 
			"PI.empresa E, PI.colabora CO,PI.centro C, PI.tutor T, PI.gestiona G, PI.grupo GR, PI.pertenece P WHERE A.num_exp=PR.alumno_num_exp AND PR.empresa_cif=E.cif\n" + 
			"AND E.cif=CO.empresa_cif AND CO.centro_cod_centro=C.cod_centro AND C.cod_centro=T.centro_cod_centro AND T.dni_tutor=G.tutor_dni_tutor\n" + 
			"AND G.grupo_cod_grupo=GR.cod_grupo AND GR.cod_grupo=P.grupo_cod_grupo AND P.alumno_num_exp=A.num_exp";
	private String SQLTutoresCiclo="SELECT G.acad \"AÑO\", GR.nombre_ciclo \"CICLO\",count(*) \"TUTORES\" FROM PI.grupo GR, PI.gestiona G, PI.tutor T, PI.centro C WHERE GR.cod_grupo=G.grupo_cod_grupo AND G.tutor_dni_tutor=T.dni_tutor AND T.centro_cod_centro=C.cod_Centro\n" + 
			"group by g.acad,gr.nombre_ciclo";
	private String SQLAlumnosEmpresa="Select P.acad \"AÑO\", E.nombre \"EMPRESA\",count(*) \"ALUMNOS\" FROM PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.tutor T, PI.colabora CO, PI.empresa E, PI.practica PR, PI.alumno A WHERE A.num_exp=PR.alumno_num_exp AND PR.empresa_cif=E.cif AND"
			+ " E.cif=CO.empresa_cif AND A.num_Exp=P.alumno_num_exp AND P.grupo_cod_grupo=GR.cod_grupo AND GR.cod_grupo=G.grupo_cod_grupo AND G.tutor_dni_tutor=T.dni_tutor group by P.acad,E.nombre";
	private JTable tablaTut;
	private JTable tablaAnx;
	private ChartPanel barPanelAlumnos;
	private ChartPanel CircularPanelAlumnos;
	private ChartPanel linealPanelAlumnos;
	private ChartPanel barPanelGrupos;
	private ChartPanel barPanelAlumnosTutor;
	private ChartPanel CircularPanelGrupos;
	private ChartPanel CircularPanelAlumnosTutor;
	private ChartPanel CircularPanelTutoresCiclo;
	private ChartPanel barPanelTutoresCiclo;
	private ChartPanel CircularPanelAlumnosEmpresa;
	private ChartPanel barPanelAlumnosEmpresa;
	
	private String resultadoEmpresa;
	private String resultadoGrupo;
	private String resultadoTutor;
	private String resultadoUsuario;
	private boolean mod;
	private String resultadoUsuarioUpdate;
	private String resultadoGrupoUpdate;
	private String anexo1Update;
	private String anexo2Update;
	private String anexo2_2Update;
	private String anexo3Update;
	private String anexo7Update;
	private String anexo8Update;
	private boolean exitoDelete;

	public void ConexionBBDD() {
		lecturaFichero();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(credenciales[2], credenciales[0], credenciales[1]);
			System.out.println(" - Conexión con ORACLE establecida -");
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con ORACLE -");
			e.printStackTrace();
		}
	}

	public void setVista(Ventana_Conf_Delete ventana_conf_delete) {
		this.ventana_conf_delete = ventana_conf_delete;
	}

	public void login(String usuario, String password) {
		String SQL = "select * from PI.USERS WHERE USR=? AND PWD=?";
		try {
			PreparedStatement stm = conexion.prepareStatement(SQL);
			stm.setString(1, usuario);
			stm.setString(2, password);
			ResultSet rst = stm.executeQuery();
			if (rst.next()) {
				USR = rst.getString(1);
				resultado = "Correcto";
				fallos = 0;
				vista_ventana_login.actualizar();
			} else {
				fallos++;
				if (fallos == 3) {
					resultado = "Cerrar";
					vista_ventana_login.actualizar();
				}
				resultado = "Incorrecto";
				vista_ventana_login.actualizar();
			}
			rst.close();
			stm.close();

		} catch (Exception e) {
			System.out.println(" – Error Statement -");
			e.printStackTrace();
		}

	}

	public void rol(String usuario, String password) {
		String SQL = "select rol from PI.USERS WHERE USR=? AND PWD=?";
		try {
			PreparedStatement stm = conexion.prepareStatement(SQL);
			stm.setString(1, usuario);
			stm.setString(2, password);
			ResultSet rst = stm.executeQuery();

			if (rst.next()) {
				if (rst.getString("ROL").equals("Tutor")) {
					this.rol = "Tutor";
				} else if (rst.getString("ROL").equals("Director")) {
					this.rol = "Director";
				}
			}

			rst.close();
			stm.close();

		} catch (Exception e) {
			System.out.println(" – Error Statement -");
			e.printStackTrace();
		}

	}

	public String getRol() {
		return this.rol;

	}

	public String getUSR() {
		return this.USR;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void finalizar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getSQLanexo2_1() {
		return SQLanexo2_1;
	}

	public String getSQLanexo1() {
		return SQLanexo1;
	}

	public String getSQTUT() {
		return SQLTut;
	}
	public String getSQTUT2() {
		return SQLTut2;
	}

	public String getSQTUT_2() {
		return SQLTut_2;
	}

	public String getSQLanexo2_2() {
		return SQLanexo2_2;
	}

	public String getSQLanexo3() {
		return SQLanexo3;
	}

	public String getSQLanexo7() {
		return SQLanexo7;
	}

	public String getSQLanexo8() {
		return SQLanexo8;
	}

	public String getSQLalumnos() {
		return SQAlumno;
	}
	public String getSQLalumnos2() {
		return SQLAlumno2;
	}

	public String getSQLGrp() {
		return SQLGrp;
	}
	public String getSQLGrp2() {
		return SQLGrp2;
	}

	private int getColumnas(String SQL) {
		int num = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getFilas(String SQL) {
		int numFilas = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				numFilas++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	public TableModel getTabla(String SQL) {

		int numColumnas = getColumnas(SQL);
		int numFilas = getFilas(SQL);

		String[] cabecera = new String[numColumnas];

		Object[][] contenido = new Object[numFilas][numColumnas];

		try {
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				cabecera[i] = rsmd.getColumnName(i + 1);
			}
			int fila = 0;
			while (rs.next()) {
				for (int column = 1; column <= numColumnas; column++) {
					contenido[fila][column - 1] = rs.getString(column);
				}
				fila++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new DefaultTableModel(contenido, cabecera);

	}

	public String getSQLEmp() {
		return SQLEmp;
	}
	public String getSQLEmp2() {
		return SQLEmp2;
	}

	public void lecturaFichero() {
		File file = new File("config.ini");
		int i = 0;
		if (file.exists()) {
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNext()) {
					credenciales[i] = sc.nextLine();
					i++;
				}
				sc.close();

			} catch (IOException e) {
				System.err.println("Error de ENTRADA/SALIDA");
				e.printStackTrace();
			}
		} else {
			System.err.println("El fichero no existe");
		}
	}

	public void VerFichero() {
		lecturaFichero();
		vista_login_config.setTxtUrlBD(credenciales[2]);
		vista_login_config.setTxtPasswordBD(credenciales[1]);
		vista_login_config.setTxtUsuarioBD(credenciales[0]);
	}

	public void modificarfichero() {
		File file = new File("config.ini");
		if (file.exists()) {
			try {
				PrintWriter pw = new PrintWriter(file);
				pw.println(vista_login_config.getUsuarioBD());
				pw.println(vista_login_config.getPassBD());
				pw.println(vista_login_config.getUrlBD());
				pw.close();

			} catch (IOException e) {
				System.err.println("Error de ENTRADA/SALIDA");
				e.printStackTrace();
			}
		} else {
			System.err.println("El fichero no existe");
		}

	}

//	MODIFICAR EMPRESA ========================
	public void modificarEmpresa(String cif, String nombre, String direccion, int i, String localidad,
			String representante, String email) {
		PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement(
					"UPDATE PI.EMPRESA SET CIF=?, NOMBRE=?, DIRECCION=?, TELEFONO=?, LOCALIDAD=?, EMAIL=?, RESP_EMPRESA=?");
			stmt.setString(1, cif);
			stmt.setString(2, nombre);
			stmt.setString(3, direccion);
			stmt.setInt(4, i);
			stmt.setString(5, localidad);
			stmt.setString(6, email);
			stmt.setString(7, representante);

			int resul = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void soundButton() {
		AudioClip sonido;
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/sonido2.wav"));
		sonido.play();
	}

	public void downloadTable(JTable table) {
		File ruta = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(ruta);
		int seleccionado = fc.showSaveDialog(null);
		if (seleccionado == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(table);
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public JTable SubirTabla() {
		File ruta = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(ruta);
		int seleccionado = fc.showOpenDialog(null);
		if (seleccionado == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				tablaTut = (JTable) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return tablaTut;
	}

	public JTable CargarTabla() {
		File ruta = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(ruta);
		int seleccionado = fc.showOpenDialog(null);
		if (seleccionado == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				tablaAnx = (JTable) ois.readObject();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();

			}
		}
		return tablaAnx;
	}

//	NUEVO ALUMNO ========================
	public void añadirAlumno(String dni, String nombre, String apellido, String expediente, String nacionalidad,
			String fechaNacim) {
		String consulta = "SELECT * FROM PI.alumno WHERE DNI=?";
		String insert = "insert into PI.alumno values(?,?,?,?,?,?)";
		try {
			PreparedStatement cons = conexion.prepareStatement(consulta);
			cons.setString(1, dni);
			ResultSet rs = cons.executeQuery();
			if (rs.next()) {
				resultadoAlum = "EXISTENTE";
				vista_info_alumno.actualizar();
			} else {
				PreparedStatement ins = conexion.prepareStatement(insert);
				ins.setString(1, dni);
				ins.setString(2, nombre);
				ins.setString(3, apellido);
				ins.setString(4, expediente);
				ins.setString(5, nacionalidad);
				ins.setString(6, fechaNacim);
				int resul = ins.executeUpdate();
				if (resul > 0) {
					resultadoAlum = "EXITO";
					vista_info_alumno.actualizar();
				}
				cons.close();
				rs.close();
				ins.close();
			}
		} catch (SQLException e) {
			if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || expediente.isEmpty()
					|| nacionalidad.isEmpty() || fechaNacim.isEmpty()) {
				resultadoAlum = "VACIO";
				vista_info_alumno.actualizar();
			} else {
				resultadoAlum = "ERROR";
				vista_info_alumno.actualizar();
			}

		}
	}

	public void insertImageUSR() { // INSERTAR IMÁGEN EN ORACLE
		try {
			PreparedStatement ps = conexion.prepareStatement("update PI.USERS SET foto=? WHERE USR=?");
			ps.setString(2, "Pedro Camacho");

			java.io.FileInputStream fin = new java.io.FileInputStream("c:\\pedro.jpg");
			ps.setBinaryStream(1, fin, fin.available());
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadImagenUSR() { // CARGAR IMAGEN DESDE ORACLE A JAVA
		String usu = getUSR();
		try {
			PreparedStatement ps = conexion.prepareStatement("select foto from PI.USERS WHERE USR=?");
			ps.setString(1, usu);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Blob b = rs.getBlob(1);
				byte barr[] = b.getBytes(1, (int) b.length());
				FileOutputStream fout = new FileOutputStream("/img/" + usu + ".jpg");
				fout.write(barr);
				fout.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getResultadoAlum() {
		return resultadoAlum;
	}

	public void añadirUsuario(String username, String password, String rol2, String email, String nombre,
			String apellido) {
		String consulta = "SELECT * FROM PI.USERS WHERE USR=?";
		String insert = "insert into PI.USERS values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement cons = conexion.prepareStatement(consulta);
			cons.setString(1, username);
			ResultSet rs = cons.executeQuery();
			if (rs.next()) {
				resultadoUsu = "EXISTENTE";
				vista_ventana_login.actualizar2();
			} else {
				PreparedStatement ins = conexion.prepareStatement(insert);
				ins.setString(1, username);
				ins.setString(2, password);
				ins.setString(3, rol2);
				ins.setString(4, email);
				ins.setString(5, nombre);
				ins.setString(6, apellido);
				ins.setString(7, null);
				int resul = ins.executeUpdate();
				if (resul > 0) {
					resultadoUsu = "EXITO";
					vista_ventana_login.actualizar2();
				}
				cons.close();
				rs.close();
				ins.close();
			}
		} catch (SQLException e) {
			if (username.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || rol2.isEmpty() || password.isEmpty()
					|| email.isEmpty()) {
				resultadoUsu = "VACIO";
				vista_ventana_login.actualizar2();
			} else {
				resultadoUsu = "ERROR";
				vista_ventana_login.actualizar2();
			}

		}

	}

	public String getResultadoUsu() {
		return resultadoUsu;
	}

	public void dibujarGraficaBarrasPracticas() {
		DefaultCategoryDataset barChart = new DefaultCategoryDataset();
		barChart.setValue((alumnosEstadisticas.get(0)), "cantidad", "Alumnos en Prácticas");
		barChart.setValue((alumnosEstadisticas.get(1)), "cantidad", "Alumnos sin Prácticas");
		barChart.setValue((alumnosEstadisticas.get(0) + alumnosEstadisticas.get(1)), "cantidad", "Total Alumnos");

		JFreeChart barChart1 = ChartFactory.createBarChart3D("Alumnos", "", "Cantidad", barChart,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt = barChart1.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.orange);
		barPanelAlumnos = new ChartPanel(barChart1);
		ventana_estadisticas.actualizarPanel();

	}

	public void dibujarGraficaCircularAlumnos() {
		DefaultPieDataset circularChart = new DefaultPieDataset();
		circularChart.setValue("Alumnos en Prácticas: " + alumnosEstadisticas.get(0), alumnosEstadisticas.get(0));
		circularChart.setValue("Alumnos sin Prácticas: " + alumnosEstadisticas.get(1), alumnosEstadisticas.get(1));
		JFreeChart circulo = ChartFactory.createPieChart3D("Alumnos", circularChart, true, true, false);
		BufferedImage circchrt = circulo.createBufferedImage(785, 460);
		;
		CircularPanelAlumnos = new ChartPanel(circulo);
		CircularPanelAlumnos.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel2();
	}

	public ChartPanel getBarPanelAlumnos() {
		return barPanelAlumnos;
	}

	public ChartPanel getCircularPanelAlumnos() {
		return CircularPanelAlumnos;
	}

	public void dibujarGraficaLinealPracticas() {
		XYSeries series = new XYSeries("Alumnos");
		series.add(0, 0);
		series.add(0, 5);
		series.add((int) alumnosEstadisticas.get(0), 30);
		XYDataset datos = new XYSeriesCollection(series);
		JFreeChart linea = ChartFactory.createXYLineChart("Alumnos en prácticas", "cantidad alumnos", "Marzo", datos,
				PlotOrientation.HORIZONTAL, true, true, false);
		BufferedImage linealImage = linea.createBufferedImage(785, 460);
		linealPanelAlumnos = new ChartPanel(linea);
		linealPanelAlumnos.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel3();

	}

	public ChartPanel getLinealPanelAlumnos() {
		return linealPanelAlumnos;
	}

	public void alumnosPracticasAlumnos() {
		if (!alumnosEstadisticas.isEmpty()) {
			alumnosEstadisticas.clear();
		}
		try {
			PreparedStatement ps = conexion.prepareStatement(SqlEstadisticasPracticas);
			ps.setString(1, "ANEXO_2_1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				alumnosEstadisticas.add(rs.getInt(1));
			}
			PreparedStatement ps2 = conexion.prepareStatement(SqlEstadisticasPracticas2);
			ps2.setString(1, "*");
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				alumnosEstadisticas.add(rs2.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void GruposAlumnos() {
		if (!gruposAlumnos.isEmpty()) {
			gruposAlumnos.clear();
		}
		try {
			PreparedStatement ps = conexion.prepareStatement(SqlGruposAlumnos);
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next()) {
				gruposAlumnos.put(rs.getString("GRUPO"), rs.getInt("ALUMNOS"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dibujarGraficaBarrasGrupos() {
		DefaultCategoryDataset barChart = new DefaultCategoryDataset();
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[0])), "cantidad",
				(Comparable) gruposAlumnos.keySet().toArray()[0]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[1])), "cantidad",
				(Comparable) gruposAlumnos.keySet().toArray()[1]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[2])), "cantidad",
				(Comparable) gruposAlumnos.keySet().toArray()[2]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[3])), "cantidad",
				(Comparable) gruposAlumnos.keySet().toArray()[3]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[4])), "cantidad",
				(Comparable) gruposAlumnos.keySet().toArray()[4]);

		JFreeChart barChart1 = ChartFactory.createBarChart3D("Grupos", "", "Cantidad Alumnos", barChart,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt = barChart1.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.orange);
		barPanelGrupos = new ChartPanel(barChart1);
		ventana_estadisticas.actualizarPanel4();
	}

	public ChartPanel getBarPanelGrupos() {
		return barPanelGrupos;
	}

	public ChartPanel getCircularGrupos() {
		return CircularPanelGrupos;
	}

	public void dibujarGraficaCircularGrupos() {
		DefaultPieDataset circularChart = new DefaultPieDataset();
		circularChart.setValue(
				gruposAlumnos.keySet().toArray()[0] + ": " + gruposAlumnos.get(gruposAlumnos.keySet().toArray()[0]),
				gruposAlumnos.get(gruposAlumnos.keySet().toArray()[0]));
		circularChart.setValue(
				gruposAlumnos.keySet().toArray()[1] + ": " + gruposAlumnos.get(gruposAlumnos.keySet().toArray()[1]),
				gruposAlumnos.get(gruposAlumnos.keySet().toArray()[1]));
		circularChart.setValue(
				gruposAlumnos.keySet().toArray()[2] + ": " + gruposAlumnos.get(gruposAlumnos.keySet().toArray()[2]),
				gruposAlumnos.get(gruposAlumnos.keySet().toArray()[2]));
		circularChart.setValue(
				gruposAlumnos.keySet().toArray()[3] + ": " + gruposAlumnos.get(gruposAlumnos.keySet().toArray()[3]),
				gruposAlumnos.get(gruposAlumnos.keySet().toArray()[3]));
		circularChart.setValue(
				gruposAlumnos.keySet().toArray()[4] + ": " + gruposAlumnos.get(gruposAlumnos.keySet().toArray()[4]),
				gruposAlumnos.get(gruposAlumnos.keySet().toArray()[4]));
		JFreeChart circulo = ChartFactory.createPieChart3D("Grupos", circularChart, true, true, false);
		BufferedImage circchrt = circulo.createBufferedImage(785, 460);
		;
		CircularPanelGrupos = new ChartPanel(circulo);
		CircularPanelGrupos.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel5();
	}

//ELIMINAR DATOS
	public void borrarDato(String clave, String nombre, String nombreClave) {
		String delete;
		nombre = "PI." + nombre;
		delete = "DELETE FROM " + nombre + " WHERE " + nombreClave + " = '" + clave + "'";

		try {
			Statement ins = conexion.createStatement();
			ResultSet rs = ins.executeQuery(delete);
			exitoDelete = true;
			ins.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean getStatusDelete() {
		return exitoDelete;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return this.clave;
	}

	public void setNombreTabla(String nomTabla) {
		this.nombreTabla = nomTabla;

	}

	public String getNombreTabla() {
		return this.nombreTabla;
	}

	public String getNombreClave() {
		return this.nombreClave;
	}

	public void setNombreClave(String nomClave) {
		this.nombreClave = nomClave;

	}

//	NUEVA EMPRESA ========================
	public void añadirEmpresa(String cif, String nombre, String direccion, String telefono, String localidad,
			String representante, String email) {
		String consulta = "SELECT * FROM PI.empresa WHERE CIF=?";
		String insert = "insert into PI.empresa values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement cons = conexion.prepareStatement(consulta);
			cons.setString(1, cif);
			ResultSet rs = cons.executeQuery();
			if (rs.next()) {
				resultadoEmpresa = "EXISTENTE";
				vista_info_empresa.actualizar();
			} else {
				PreparedStatement ins = conexion.prepareStatement(insert);
				ins.setString(1, cif);
				ins.setString(2, nombre);
				ins.setString(3, direccion);
				ins.setString(4, telefono);
				ins.setString(5, localidad);
				ins.setString(6, representante);
				ins.setString(7, email);
				int resul = ins.executeUpdate();
				if (resul > 0) {
					resultadoEmpresa = "EXITO";
					vista_info_empresa.actualizar();
				}
				cons.close();
				rs.close();
				ins.close();
			}
		} catch (SQLException e) {
			if (cif.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || localidad.isEmpty()
					|| representante.isEmpty() || email.isEmpty()) {
				resultadoEmpresa = "VACIO";
				vista_info_empresa.actualizar();
			} else {
				resultadoEmpresa = "ERROR";
				vista_info_empresa.actualizar();
			}

		}
	}

	public String getResultadoEmpresa() {
		return resultadoEmpresa;
	}

//	NUEVO GRUPO========================
	public void añadirGrupo(String codGrupo, String nombre, String ciclo, String claveCiclo) {
		String consulta = "SELECT * FROM PI.grupo WHERE cod_grupo=?";
		String insert = "insert into PI.empresa values(?,?,?,?)";
		try {
			PreparedStatement cons = conexion.prepareStatement(consulta);
			cons.setString(1, codGrupo);
			ResultSet rs = cons.executeQuery();
			if (rs.next()) {
				resultadoGrupo = "EXISTENTE";
				vista_info_grupo.actualizar();
			} else {
				PreparedStatement ins = conexion.prepareStatement(insert);
				ins.setString(1, codGrupo);
				ins.setString(2, nombre);
				ins.setString(3, ciclo);
				ins.setString(4, claveCiclo);
				int resul = ins.executeUpdate();
				if (resul > 0) {
					resultadoGrupo = "EXITO";
					vista_info_grupo.actualizar();
				}
				cons.close();
				rs.close();
				ins.close();
			}
		} catch (SQLException e) {
			if (codGrupo.isEmpty() || nombre.isEmpty() || ciclo.isEmpty() || claveCiclo.isEmpty()) {
				resultadoGrupo = "VACIO";
				vista_info_grupo.actualizar();
			} else {
				resultadoGrupo = "ERROR";
				vista_info_grupo.actualizar();
			}

		}
	}

	public String getResultadoGrupo() {
		return resultadoGrupo;
	}

//	NUEVO TUTOR ========================
	public void añadirTutor(String dni, String nombre, String apellidos, String codCentro) {
		String consulta = "SELECT * FROM PI.tutor WHERE dni_tutor=?";
		String insert = "insert into PI.empresa values(?,?,?,?)";
		try {
			PreparedStatement cons = conexion.prepareStatement(consulta);
			cons.setString(1, dni);
			ResultSet rs = cons.executeQuery();
			if (rs.next()) {
				resultadoTutor = "EXISTENTE";
				vista_info_tutor.actualizar();
			} else {
				PreparedStatement ins = conexion.prepareStatement(insert);
				ins.setString(1, dni);
				ins.setString(2, nombre);
				ins.setString(3, apellidos);
				ins.setString(4, codCentro);
				int resul = ins.executeUpdate();
				if (resul > 0) {
					resultadoTutor = "EXITO";
					vista_info_tutor.actualizar();
				}
				cons.close();
				rs.close();
				ins.close();
			}
		} catch (SQLException e) {
			if (dni.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || codCentro.isEmpty()) {
				resultadoTutor = "VACIO";
				vista_info_tutor.actualizar();
			} else {
				resultadoTutor = "ERROR";
				vista_info_tutor.actualizar();
			}

		}
	}

	public String getResultadoTutor() {
		return resultadoTutor;
	}

	public void modificarAlumno(String DNI, String nombre, String apellidos, int EXP, String Fnac,
			String nacionalidad) {
		PreparedStatement stmt;
		try {
			SimpleDateFormat formatt = new SimpleDateFormat("YYYY-MM-DD");
			java.util.Date utildate = formatt.parse(Fnac);
			Date sqlDate = new Date(utildate.getTime());

			stmt = conexion.prepareStatement(
					"UPDATE PI.Alumno SET DNI=?, NOMBRE = ?, APELLIDOS = ?, NACIONALIDAD = ?, FECHA_NACIM=?  WHERE NUM_EXP = ?");
			stmt.setString(1, DNI);
			stmt.setString(2, nombre);
			stmt.setString(3, apellidos);
			stmt.setString(4, nacionalidad);
			stmt.setDate(5, sqlDate);

			stmt.setInt(6, EXP);
			int resul = stmt.executeUpdate();
			if (resul > 0) {
				resultadoUsuarioUpdate = "EXITO";
				vista_info_alumno.actualizar2();
			} else {
				resultadoUsuarioUpdate = "ERROR";
				vista_info_alumno.actualizar2();
			}
		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}

	}

	public void modificarTutor(String dni, String nombre, String apellidos, int codCentro) {
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(
					"UPDATE PI.tutor SET nombre = ?, apellidos = ?, centro_cod_centro = ?  WHERE dni_tutor = ?");
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setInt(3, codCentro);
			ps.setString(4, dni);

			int resul = ps.executeUpdate();
			if (resul>0) {
				resultadoTutor="EXITO";
				vista_info_tutor.actualizarUpdate();
			}else {
				resultadoTutor="ERROR";
				vista_info_tutor.actualizarUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void setmodificar(boolean mod) {
		this.mod = mod;

	}

	public boolean getmodificar() {
		return this.mod;
	}

	public String getResultadoUsuarioUpdate() {
		return resultadoUsuarioUpdate;
	}

	public void modificarGrupo(int codigo, String grupo, int clave, String ciclo) {
		PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement(
					"UPDATE PI.grupo SET nom_grupo = ?, clave_ciclo = ?, nombre_ciclo = ? WHERE cod_grupo = ?");
			stmt.setString(1, grupo);
			stmt.setInt(2, clave);
			stmt.setString(3, ciclo);
			stmt.setInt(4, codigo);

			int resul = stmt.executeUpdate();
			if (resul > 0) {
				resultadoGrupoUpdate = "EXITO";
				vista_info_grupo.actualizar2();
			} else {
				resultadoGrupoUpdate = "ERROR";
				vista_info_grupo.actualizar2();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String getResultadoGrupoUpdate() {
		return resultadoGrupoUpdate;
	}

	public String getAnexo1Update() {
		return anexo1Update;
	}

	public String getAnexo2Update() {
		return anexo2Update;
	}

	public void modificarAnexo1(String cif, String empresa, String cod_centro, String localidad, String director,
			String anexo_1) {
		PreparedStatement stmt, stmt2, stmt3, stmt4;
		try {
			int codigo = Integer.parseInt(cod_centro);
			stmt = conexion.prepareStatement(
					"UPDATE PI.colabora SET anexo_1 = ? WHERE centro_cod_centro = ? AND empresa_cif= ?");
			stmt2 = conexion.prepareStatement("UPDATE PI.empresa SET nombre = ? WHERE cif= ?");
			stmt3 = conexion.prepareStatement("UPDATE PI.centro SET localidad = ? WHERE cod_centro = ?");
			stmt4 = conexion.prepareStatement("UPDATE PI.centro SET director = ? WHERE cod_centro = ?");
			stmt4.setString(1, director);
			stmt4.setString(2, cod_centro);
			stmt3.setString(1, localidad);
			stmt3.setString(2, cod_centro);
			stmt2.setString(1, empresa);
			stmt2.setString(2, cif);
			stmt.setString(1, anexo_1);
			stmt.setString(2, cod_centro);
			stmt.setString(3, cif);
			int resul = stmt.executeUpdate();
			int resul2 = stmt2.executeUpdate();
			int resul3 = stmt3.executeUpdate();
			int resul4 = stmt4.executeUpdate();
			if (resul > 0 && resul2 > 0 && resul3 > 0 && resul4 > 0) {
				anexo1Update = "EXITO";
				busquedaAnexos.actualizar();
			} else {
				anexo1Update = "ERROR";
				busquedaAnexos.actualizar();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void modificarAnexo2(String expe, String nombre, String apellidos, String anexo_2_1) {
		PreparedStatement stmt, stmt2, stmt3, stmt4;
		int resul3;
		try {
			if (!anexo_2_1.equals("null") && !anexo_2_1.isEmpty()) {
//				SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy HH:");
				SimpleDateFormat formatt = new SimpleDateFormat("YYYY-MM-DD HH:");
				java.util.Date utildate = formatt.parse(anexo_2_1);
				Date sqlDate = new Date(utildate.getTime());
				stmt3 = conexion.prepareStatement("UPDATE PI.practica SET anexo_2_1 = ? WHERE alumno_num_exp = ?");
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ? WHERE num_exp = ?");
				stmt2 = conexion.prepareStatement("UPDATE PI.alumno SET apellidos = ? WHERE num_exp= ?");
				stmt.setString(1, nombre);
				stmt.setString(2, expe);
				stmt2.setString(1, apellidos);
				stmt2.setString(2, expe);
				stmt3.setDate(1, sqlDate);
				stmt3.setString(2, expe);
				resul3 = stmt3.executeUpdate();
				int resul = stmt.executeUpdate();
				int resul2 = stmt2.executeUpdate();
				if (resul > 0 && resul2 > 0 && resul3 > 0) {
					anexo2Update = "EXITO";
					busquedaAnexos.actualizar2();
				} else {
					anexo2Update = "ERROR";
					busquedaAnexos.actualizar2();
				}
			} else {
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ? WHERE num_exp = ?");
				stmt2 = conexion.prepareStatement("UPDATE PI.alumno SET apellidos = ? WHERE num_exp= ?");
				stmt.setString(1, nombre);
				stmt.setString(2, expe);
				stmt2.setString(1, apellidos);
				stmt2.setString(2, expe);

				int resul = stmt.executeUpdate();
				int resul2 = stmt2.executeUpdate();
				if (resul > 0 && resul2 > 0) {
					anexo2Update = "EXITO";
					busquedaAnexos.actualizar2();
				} else {
					anexo2Update = "ERROR";
					busquedaAnexos.actualizar2();
				}
			}

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}
	}

	public void modificarAnexo2_2(String expe, String nombre, String apellidos, String grupo, String empresa,
			String horario, String anexo_2_2) {
		PreparedStatement stmt, stmt2, stmt3, stmt4, stmt5;
		String[] grupoArray = grupo.split(",");
		String[] empresaArray = empresa.split(",");
		int codigo = Integer.parseInt(grupoArray[1]);
		try {
			if (!anexo_2_2.equals("null") && !anexo_2_2.isEmpty()) {
//				SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy HH:");
				SimpleDateFormat formatt = new SimpleDateFormat("YYYY-MM-DD HH:");
				java.util.Date utildate = formatt.parse(anexo_2_2);
				Date sqlDate = new Date(utildate.getTime());
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ?, apellidos=? WHERE num_exp = ?");
				stmt2 = conexion.prepareStatement("UPDATE PI.practica SET horario = ? WHERE alumno_num_exp= ?");
				stmt3 = conexion.prepareStatement("UPDATE PI.gestiona SET anexo_2_2 = ? WHERE grupo_cod_grupo = ?");
				stmt4 = conexion.prepareStatement("UPDATE PI.grupo SET nom_grupo = ? WHERE cod_grupo = ?");
				stmt5 = conexion.prepareStatement("UPDATE PI.empresa SET nombre = ? WHERE cif = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);
				stmt2.setString(1, horario);
				stmt2.setString(2, expe);
				stmt3.setDate(1, sqlDate);
				stmt3.setInt(2, codigo);
				stmt4.setString(1, grupoArray[0]);
				stmt4.setInt(2, codigo);
				stmt5.setString(1, empresaArray[0]);
				stmt5.setString(2, empresaArray[1]);
				int resul3 = stmt3.executeUpdate();
				int resul = stmt.executeUpdate();
				int resul2 = stmt2.executeUpdate();
				int resul4 = stmt4.executeUpdate();
				int resul5 = stmt5.executeUpdate();
				if (resul > 0 && resul2 > 0 && resul3 > 0 && resul4 > 0 && resul5 > 0) {
					anexo2_2Update = "EXITO";
					busquedaAnexos.actualizar3();
				} else {
					anexo2_2Update = "ERROR";
					busquedaAnexos.actualizar3();
				}
			} else {
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ?, apellidos=? WHERE num_exp = ?");
				stmt2 = conexion.prepareStatement("UPDATE PI.practica SET horario = ? WHERE alumno_num_exp= ?");
				stmt4 = conexion.prepareStatement("UPDATE PI.grupo SET nom_grupo = ? WHERE cod_grupo = ?");
				stmt5 = conexion.prepareStatement("UPDATE PI.empresa SET nombre = ? WHERE cif = ?");

				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);
				stmt2.setString(1, horario);
				stmt2.setString(2, expe);
				stmt4.setString(1, grupoArray[0]);
				stmt4.setInt(2, codigo);
				stmt5.setString(1, empresaArray[0]);
				stmt5.setString(2, empresaArray[1]);

				int resul = stmt.executeUpdate();
				int resul2 = stmt2.executeUpdate();
				int resul4 = stmt4.executeUpdate();
				int resul5 = stmt5.executeUpdate();
				if (resul > 0 && resul2 > 0 && resul4 > 0 && resul5 > 0) {
					anexo2_2Update = "EXITO";
					busquedaAnexos.actualizar3();
				} else {
					anexo2_2Update = "ERROR";
					busquedaAnexos.actualizar3();
				}
			}

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}

	}

	public String getAnexo2_2Update() {
		return anexo2_2Update;
	}

	public void modificarAnexo3(String expe, String nombre, String apellidos, String anexo_3) {
		PreparedStatement stmt, stmt2;
		int resul2;
		try {
			if (!anexo_3.equals("null") && !anexo_3.isEmpty()) {
//				SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy HH:");
				SimpleDateFormat formatt = new SimpleDateFormat("YYYY-MM-DD HH:");
				java.util.Date utildate = formatt.parse(anexo_3);
				Date sqlDate = new Date(utildate.getTime());
				stmt2 = conexion.prepareStatement("UPDATE PI.practica SET anexo_3 = ? WHERE alumno_num_exp = ?");
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ?, apellidos=? WHERE num_exp = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);
				stmt2.setDate(1, sqlDate);
				stmt2.setString(2, expe);
				resul2 = stmt2.executeUpdate();
				int resul = stmt.executeUpdate();
				if (resul > 0 && resul2 > 0) {
					anexo3Update = "EXITO";
					busquedaAnexos.actualizar4();
				} else {
					anexo3Update = "ERROR";
					busquedaAnexos.actualizar4();
				}
			} else {
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ?, apellidos=? WHERE num_exp = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);

				int resul = stmt.executeUpdate();
				if (resul > 0) {
					anexo2Update = "EXITO";
					busquedaAnexos.actualizar4();
				} else {
					anexo2Update = "ERROR";
					busquedaAnexos.actualizar4();
				}
			}

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}
	}

	public String getAnexo3Update() {
		return anexo3Update;
	}

	public void modificarAnexo7(String expe, String nombre, String apellidos, String anexo_7) {
		PreparedStatement stmt, stmt2;
		int resul2;
		try {
			if (!anexo_7.equals("null") && !anexo_7.isEmpty()) {
//				SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy HH:");
				SimpleDateFormat formatt = new SimpleDateFormat("YYYY-MM-DD HH:");
				java.util.Date utildate = formatt.parse(anexo_7);
				Date sqlDate = new Date(utildate.getTime());
				stmt2 = conexion.prepareStatement("UPDATE PI.practica SET anexo_7 = ? WHERE alumno_num_exp = ?");
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ?, apellidos=? WHERE num_exp = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);
				stmt2.setDate(1, sqlDate);
				stmt2.setString(2, expe);
				resul2 = stmt2.executeUpdate();
				int resul = stmt.executeUpdate();
				if (resul > 0 && resul2 > 0) {
					anexo7Update = "EXITO";
					busquedaAnexos.actualizar5();
				} else {
					anexo7Update = "ERROR";
					busquedaAnexos.actualizar5();
				}
			} else {
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre = ?, apellidos=? WHERE num_exp = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);

				int resul = stmt.executeUpdate();
				if (resul > 0) {
					anexo7Update = "EXITO";
					busquedaAnexos.actualizar5();
				} else {
					anexo7Update = "ERROR";
					busquedaAnexos.actualizar5();
				}
			}

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}
	}

	public String getAnexo7Update() {
		return anexo7Update;
	}

	public void modificarAnexo8(String expe, String nombre, String apellidos, String centro, String empresa,
			String anexo_8) {
		PreparedStatement stmt, stmt2, stmt3, stmt4;
		int resul4;
		String[] centroArray = centro.split(",");
		String[] empresaArray = empresa.split(",");
		int cod_centro = Integer.parseInt(centroArray[1]);
		try {
			if (!anexo_8.equals("null") && !anexo_8.isEmpty()) {
//				SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy HH:");
				SimpleDateFormat formatt = new SimpleDateFormat("YYYY-MM-DD HH:");
				java.util.Date utildate = formatt.parse(anexo_8);
				Date sqlDate = new Date(utildate.getTime());
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre= ?, apellidos = ? WHERE num_exp= ?");
				stmt2 = conexion.prepareStatement("UPDATE PI.centro SET localidad= ? WHERE cod_centro= ?");
				stmt3 = conexion.prepareStatement("UPDATE PI.empresa SET nombre = ? WHERE cif = ?");
				stmt4 = conexion.prepareStatement("UPDATE PI.practica SET anexo_8 = ? WHERE alumno_num_exp = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);
				stmt2.setString(1, centroArray[0]);
				stmt2.setInt(2, cod_centro);
				stmt3.setString(1, empresaArray[0]);
				stmt3.setString(2, empresaArray[1]);
				stmt4.setDate(1, sqlDate);
				stmt4.setString(2, expe);
				resul4 = stmt4.executeUpdate();
				int resul = stmt.executeUpdate();
				int resul2 = stmt2.executeUpdate();
				int resul3 = stmt3.executeUpdate();
				if (resul > 0 && resul2 > 0 && resul3 > 0 && resul4 > 0) {
					anexo8Update = "EXITO";
					busquedaAnexos.actualizar6();
				} else {
					anexo8Update = "ERROR";
					busquedaAnexos.actualizar6();
				}
			} else {
				stmt = conexion.prepareStatement("UPDATE PI.alumno SET nombre= ?, apellidos = ? WHERE num_exp= ?");
				stmt2 = conexion.prepareStatement("UPDATE PI.centro SET localidad= ? WHERE cod_centro= ?");
				stmt3 = conexion.prepareStatement("UPDATE PI.empresa SET nombre = ? WHERE cif = ?");
				stmt.setString(1, nombre);
				stmt.setString(2, apellidos);
				stmt.setString(3, expe);
				stmt2.setString(1, centroArray[0]);
				stmt2.setInt(2, cod_centro);
				stmt3.setString(1, empresaArray[0]);
				stmt3.setString(2, empresaArray[1]);

				int resul = stmt.executeUpdate();
				int resul2 = stmt2.executeUpdate();
				int resul3 = stmt3.executeUpdate();
				if (resul > 0 && resul2 > 0 && resul3 > 0) {
					anexo8Update = "EXITO";
					busquedaAnexos.actualizar6();
				} else {
					anexo8Update = "ERROR";
					busquedaAnexos.actualizar6();
				}
			}

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}
	}

	public String getAnexo8Update() {
		return anexo8Update;
	}

	public String getCifEmpresa() {
		return cifEmpresa;
	}

	public void setCifEmpresa(String cifEmpresa) {
		this.cifEmpresa = cifEmpresa;
	}

	public String getNombreAnexo() {
		return nombreAnexo;
	}

	public void setNombreAnexo(String nombreAnexo) {
		this.nombreAnexo = nombreAnexo;
	}

	public String getNombreTablaAnexo() {
		return nombreTablaAnexo;
	}

	public void setNombreTablaAnexo(String nombreTablaAnexo) {
		this.nombreTablaAnexo = nombreTablaAnexo;
	}

	public int getAnexoSeleccionado() {
		return anexoSeleccionado;
	}

	public void setAnexoSeleccionado(int selected) {
		this.anexoSeleccionado = selected;
	}

	public void anularAnexo(String nombreTablaAnexo2, String nombreAnexo2, String cifEmpresa2) {
		PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement(
					"UPDATE PI." + nombreTablaAnexo2 + " SET " + nombreAnexo2 + " = ? WHERE empresa_cif = ?");
			stmt.setNull(1, java.sql.Types.VARCHAR);
			stmt.setString(2, cifEmpresa2);
			int resul = stmt.executeUpdate();
			if (resul > 0) {
				anexo1Update = "EXITO";
				busquedaAnexos.actualizar();
			} else {
				anexo1Update = "ERROR";
				busquedaAnexos.actualizar();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void anularAnexo2(String nombreTablaAnexo2, String nombreAnexo2, String cifEmpresa2) {
		PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement(
					"UPDATE PI." + nombreTablaAnexo2 + " SET " + nombreAnexo2 + " = ? WHERE alumno_num_exp = ?");
			stmt.setNull(1, java.sql.Types.DATE);
			stmt.setString(2, cifEmpresa2);
			int resul = stmt.executeUpdate();
			if (resul > 0) {
				anexo2Update = "EXITO";
				busquedaAnexos.actualizar2();
			} else {
				anexo2Update = "ERROR";
				busquedaAnexos.actualizar2();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void anularAnexo2_2(String nombreTablaAnexo2, String nombreAnexo2, String cifEmpresa2) {
		PreparedStatement stmt;
		try {
			String[] array = cifEmpresa2.split(",");
			stmt = conexion.prepareStatement(
					"UPDATE PI." + nombreTablaAnexo2 + " SET " + nombreAnexo2 + " = ? WHERE grupo_cod_grupo = ?");
			stmt.setNull(1, java.sql.Types.DATE);
			stmt.setInt(2, Integer.parseInt(array[1]));
			int resul = stmt.executeUpdate();
			if (resul > 0) {
				anexo2_2Update = "EXITO";
				busquedaAnexos.actualizar3();
			} else {
				anexo2_2Update = "ERROR";
				busquedaAnexos.actualizar3();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private int getColumnasBusquedaAnexos(String SQL, String Condicion) {
		int num = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(SQL);
			pst.setString(1, "%" + Condicion + "%");
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getFilasBusquedaAnexos(String SQL, String Condicion) {
		int numFilas = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(SQL);
			pst.setString(1, "%" + Condicion + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				numFilas++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	public TableModel getTablaBusquedaAnexos(String SQL, String Condicion) {

		int numColumnas = getColumnasBusquedaAnexos(SQL, Condicion);
		int numFilas = getFilasBusquedaAnexos(SQL, Condicion);

		String[] cabecera = new String[numColumnas];

		Object[][] contenido = new Object[numFilas][numColumnas];

		try {
			PreparedStatement pst = conexion.prepareStatement(SQL);
			pst.setString(1, "%" + Condicion + "%");
			;
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				cabecera[i] = rsmd.getColumnName(i + 1);
			}
			int fila = 0;
			while (rs.next()) {
				for (int column = 1; column <= numColumnas; column++) {
					contenido[fila][column - 1] = rs.getString(column);
				}
				fila++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new DefaultTableModel(contenido, cabecera);

	}

	public String getSQLanexo1Busqueda() {
		return SQLanexo1Busqueda;
	}

	public String getSQLanexo2_1Busqueda() {
		return SQLanexo2_1Busqueda;
	}

	public String getSQLanexo2_2Busqueda() {
		return SQLanexo2_2Busqueda;
	}

	public String getSQLanexo3Busqueda() {
		return SQLanexo3Busqueda;
	}

	public String getSQLanexo7Busqueda() {
		return SQLanexo7Busqueda;
	}

	public String getSQLanexo8Busqueda() {
		return SQLanexo8Busqueda;
	}

	public String getSQLinforme1() {
		return SQLinforme1;
	}
	

	public String getSQLinforme2() {
		return SQLinforme2;
	}

	public String getSQLinforme3() {
		return SQLinforme3;
	}

	public String getSQLinforme4() {
		return SQLinforme4;
	}

	public void GruposAlumnosTutor() {

		if (!tutorAlumnos.isEmpty()) {
			tutorAlumnos.clear();
		}
		try {
			PreparedStatement ps = conexion.prepareStatement(SqlAlumnosTutor);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tutorAlumnos.put(rs.getString("TUTOR"), rs.getInt("ALUMNOS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dibujargraficaCircularAlumnosTutor() {
		DefaultPieDataset circularChart = new DefaultPieDataset();
		circularChart.setValue(
				tutorAlumnos.keySet().toArray()[0] + ": " + tutorAlumnos.get(tutorAlumnos.keySet().toArray()[0]),
				tutorAlumnos.get(tutorAlumnos.keySet().toArray()[0]));
		circularChart.setValue(
				tutorAlumnos.keySet().toArray()[1] + ": " + tutorAlumnos.get(tutorAlumnos.keySet().toArray()[1]),
				tutorAlumnos.get(tutorAlumnos.keySet().toArray()[1]));
		circularChart.setValue(
				tutorAlumnos.keySet().toArray()[2] + ": " + tutorAlumnos.get(tutorAlumnos.keySet().toArray()[2]),
				tutorAlumnos.get(tutorAlumnos.keySet().toArray()[2]));
		circularChart.setValue(
				tutorAlumnos.keySet().toArray()[3] + ": " + tutorAlumnos.get(tutorAlumnos.keySet().toArray()[3]),
				tutorAlumnos.get(tutorAlumnos.keySet().toArray()[3]));
		JFreeChart circulo = ChartFactory.createPieChart3D("Alumnos Tutor", circularChart, true, true, false);
		BufferedImage circchrt = circulo.createBufferedImage(785, 460);
		;
		CircularPanelAlumnosTutor = new ChartPanel(circulo);
		CircularPanelAlumnosTutor.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel6();
	}

	public ChartPanel getCircularPanelAlumnosTutor() {
		return CircularPanelAlumnosTutor;
	}

	public void dibujarGraficaBarrasAlumnosTutor() {
		DefaultCategoryDataset barChart = new DefaultCategoryDataset();
		barChart.setValue((tutorAlumnos.get(tutorAlumnos.keySet().toArray()[0])), "cantidad",
				(Comparable) tutorAlumnos.keySet().toArray()[0]);
		barChart.setValue((tutorAlumnos.get(tutorAlumnos.keySet().toArray()[1])), "cantidad",
				(Comparable) tutorAlumnos.keySet().toArray()[1]);
		barChart.setValue((tutorAlumnos.get(tutorAlumnos.keySet().toArray()[2])), "cantidad",
				(Comparable) tutorAlumnos.keySet().toArray()[2]);
		barChart.setValue((tutorAlumnos.get(tutorAlumnos.keySet().toArray()[3])), "cantidad",
				(Comparable) tutorAlumnos.keySet().toArray()[3]);

		JFreeChart barChart1 = ChartFactory.createBarChart3D("Alumnos Tutor", "", "Cantidad Alumnos", barChart,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt = barChart1.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.orange);
		barPanelAlumnosTutor = new ChartPanel(barChart1);
		ventana_estadisticas.actualizarPanel7();
	}
	public ChartPanel getBarPanelAlumnosTutor() {
		return barPanelAlumnosTutor;
	}

	public void tutoresCiclo() {
		if (!tutorCiclos.isEmpty()) {
			tutorCiclos.clear();
		}
		try {
			PreparedStatement ps = conexion.prepareStatement(SQLTutoresCiclo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tutorCiclos.put(rs.getString("CICLO"), rs.getInt("TUTORES"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dibujargraficaCircularTutoresCiclo() {

		DefaultPieDataset circularChart = new DefaultPieDataset();
		circularChart.setValue(
				tutorCiclos.keySet().toArray()[0] + ": " + tutorCiclos.get(tutorCiclos.keySet().toArray()[0]),
				tutorCiclos.get(tutorCiclos.keySet().toArray()[0]));
		circularChart.setValue(
				tutorCiclos.keySet().toArray()[1] + ": " + tutorCiclos.get(tutorCiclos.keySet().toArray()[1]),
				tutorCiclos.get(tutorCiclos.keySet().toArray()[1]));
		circularChart.setValue(
				tutorCiclos.keySet().toArray()[2] + ": " + tutorCiclos.get(tutorCiclos.keySet().toArray()[2]),
				tutorCiclos.get(tutorCiclos.keySet().toArray()[2]));
		circularChart.setValue(
				tutorCiclos.keySet().toArray()[3] + ": " + tutorCiclos.get(tutorCiclos.keySet().toArray()[3]),
				tutorCiclos.get(tutorCiclos.keySet().toArray()[3]));
		JFreeChart circulo = ChartFactory.createPieChart3D("Tutores Ciclo", circularChart, true, true, false);
		BufferedImage circchrt = circulo.createBufferedImage(785, 460);
		;
		CircularPanelTutoresCiclo = new ChartPanel(circulo);
		CircularPanelTutoresCiclo.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel8();
	}

	public ChartPanel getCircularPanelTutoresCiclo() {
		return CircularPanelTutoresCiclo;
	}

	public ChartPanel getBarPanelTutoresCiclo() {
		return barPanelTutoresCiclo;
	}

	public void dibujarBarrasTutoresCiclo() {

		DefaultCategoryDataset barChart = new DefaultCategoryDataset();
		barChart.setValue((tutorCiclos.get(tutorCiclos.keySet().toArray()[0])), "cantidad",
				(Comparable) tutorCiclos.keySet().toArray()[0]);
		barChart.setValue((tutorCiclos.get(tutorCiclos.keySet().toArray()[1])), "cantidad",
				(Comparable) tutorCiclos.keySet().toArray()[1]);
		barChart.setValue((tutorCiclos.get(tutorCiclos.keySet().toArray()[2])), "cantidad",
				(Comparable) tutorCiclos.keySet().toArray()[2]);
		barChart.setValue((tutorCiclos.get(tutorCiclos.keySet().toArray()[3])), "cantidad",
				(Comparable) tutorCiclos.keySet().toArray()[3]);

		JFreeChart barChart1 = ChartFactory.createBarChart3D("Tutores Ciclo", "", "Cantidad Tutores", barChart,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt = barChart1.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.orange);
		barPanelTutoresCiclo = new ChartPanel(barChart1);
		ventana_estadisticas.actualizarPanel9();
	
	}

	public void alumnosEmpresa() {
		if (!alumnosEmpresa.isEmpty()) {
			alumnosEmpresa.clear();
		}
		try {
			PreparedStatement ps = conexion.prepareStatement(SQLAlumnosEmpresa);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				alumnosEmpresa.put(rs.getString("EMPRESA"), rs.getInt("ALUMNOS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public void dibujargraficaCircularAlumnosEmpresa() {


		DefaultPieDataset circularChart = new DefaultPieDataset();
			for (int i = 0; i < alumnosEmpresa.size(); i++) {
				circularChart.setValue(
						alumnosEmpresa.keySet().toArray()[i] + ": " + alumnosEmpresa.get(alumnosEmpresa.keySet().toArray()[i]),
						alumnosEmpresa.get(alumnosEmpresa.keySet().toArray()[i]));
			}
		JFreeChart circulo = ChartFactory.createPieChart3D("Alumnos Empresa", circularChart, true, true, false);
		BufferedImage circchrt = circulo.createBufferedImage(785, 460);
		;
		CircularPanelAlumnosEmpresa = new ChartPanel(circulo);
		CircularPanelAlumnosEmpresa.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel10();
	}

	public ChartPanel getCircularPanelAlumnosEmpresa() {
		return CircularPanelAlumnosEmpresa;
	}
	public ChartPanel getBarPanelAlumnosEmpresa() {
		return barPanelAlumnosEmpresa;
	}

	public void dibujargraficaBarrasAlumnosEmpresa() {


		DefaultCategoryDataset barChart = new DefaultCategoryDataset();
			for (int i = 0; i < alumnosEmpresa.size(); i++) {
				barChart.setValue((alumnosEmpresa.get(alumnosEmpresa.keySet().toArray()[i])), "cantidad",
						(Comparable) alumnosEmpresa.keySet().toArray()[i]);
			}
		JFreeChart barChart1 = ChartFactory.createBarChart3D("Alumnos Empresa", "", "Cantidad Alumnos", barChart,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt = barChart1.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.orange);
		barPanelAlumnosEmpresa = new ChartPanel(barChart1);
		ventana_estadisticas.actualizarPanel11();
	}
	
	
}
