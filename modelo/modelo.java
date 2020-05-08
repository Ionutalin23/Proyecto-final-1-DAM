package modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import vista.Busqueda_Alumnos;
import vista.Busqueda_Anexos;
import vista.Busqueda_Empresas;
import vista.Busqueda_Grupos;
import vista.Busqueda_Tutores;
import vista.MenuVista;
import vista.Ventana_Login;
import vista.Ventana_Login_Config;
import vista.Vista_Info_Alumno;
import vista.Vista_Info_Empresa;
import vista.Vista_Info_Grupo;
import vista.Vista_Info_Tutor;

public class modelo {

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
	private String [] credenciales= new String[3];

	private Connection conexion;
	private int fallos;
	private String resultado;
	private String USR;
	private String rol;
	private String SQLanexo2_1 = "SELECT nombre, apellidos, anexo_2_1 FROM PI.alumno, PI.practica WHERE num_exp=alumno_num_exp";
	private String SQLanexo1 = "SELECT E.nombre \"Empresa\",C.cod_centro, C.localidad, C.director, CO.anexo_1 FROM PI.centro C, PI.colabora CO, PI.empresa E WHERE CO.centro_cod_centro=C.cod_centro AND  CO.empresa_cif=E.cif";
	private String SQLanexo2_2 = "SELECT A.nombre, A.apellidos, E.nombre \"EMPRESA\", PR.horario, G.Anexo_2_2 FROM PI.alumno A, PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.Tutor T, PI.centro C, "
			+ "PI.colabora CO, PI.Empresa E, PI.practica PR WHERE A.num_exp=P.alumno_num_exp AND T.dni_tutor=G.tutor_dni_tutor AND C.cod_centro=T.centro_cod_centro AND CO.empresa_cif=E.cif "
			+ "AND P.grupo_cod_grupo=GR.cod_grupo AND G.grupo_cod_grupo=GR.cod_grupo AND CO.centro_cod_centro=C.cod_centro\n"
			+ "AND PR.empresa_cif=E.cif AND PR.alumno_num_exp=A.num_exp";
	private String SQLanexo3="SELECT A.nombre, A.apellidos, A.dni, PR.anexo_3 FROM PI.alumno A, PI.practica PR WHERE num_exp=alumno_num_exp";
	private String SQLanexo7="SELECT A.nombre, A.apellidos, PR.anexo_7 FROM PI.alumno A, PI.practica PR WHERE A.num_exp=PR.alumno_num_exp";
	private String SQLanexo8="SELECT A.nombre, A.apellidos,CONCAT(C.localidad,CONCAT(',',C.cod_centro)) \"CENTRO\", E.Nombre \"EMPRESA\", PR.anexo_8 FROM PI.alumno A, PI.practica PR, PI.empresa E, PI.centro C, PI.colabora CO WHERE num_exp=alumno_num_exp AND PR.empresa_cif=E.cif\n" + 
			"AND CO.empresa_cif=E.cif AND C.cod_centro=CO.centro_cod_centro";
	private String SQLTut = "SELECT * FROM PI.TUTOR";
	private String SQLTut_2 = "SELECT nombre, apellidos,clave_ciclo, nombre_ciclo FROM PI.Tutor TU, PI.Grupo GR, PI.Gestiona GE WHERE TU.dni_tutor = GE.tutor_dni_tutor AND GE.grupo_cod_grupo = GR.cod_grupo AND nombre_ciclo ='DAMM'";
	private String SQAlumno = "SELECT * FROM PI.alumno";
	private String SQLEmp = "SELECT * FROM PI.empresa";
	private String SQLGrp = "SELECT * FROM PI.grupo";
	public void ConexionBBDD() {
		lecturaFichero();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(credenciales[2], credenciales[0], credenciales[1]);
			System.out.println(" - Conexi�n con ORACLE establecida -");
		} catch (Exception e) {
			System.out.println(" � Error de Conexi�n con ORACLE -");
			e.printStackTrace();
		}
	}

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

	public void setVista_info_tutor(Vista_Info_Tutor vista_info_tutor) {
		this.vista_info_tutor = vista_info_tutor;
	}

	public void setVista_info_empresa(Vista_Info_Empresa vista_info_empresa) {
		this.vista_info_empresa = vista_info_empresa;
	}

	public void setVista_info_alumno(Vista_Info_Alumno vista_info_alumno) {
		this.vista_info_alumno = vista_info_alumno;
	}

	public void setVista_info_grupo(Vista_Info_Grupo vista_info_grupo) {
		this.vista_info_grupo = vista_info_grupo;
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
			System.out.println(" � Error Statement -");
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
			System.out.println(" � Error Statement -");
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

	public String getSQTUT_1() {
		return SQLTut;
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
	
	public String getSQLGrp() {
		return SQLGrp;
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
	public void lecturaFichero() {
		File file= new File("config.ini");
		int i=0;
		if (file.exists()) {
			try {
				Scanner sc= new Scanner(file);
				while (sc.hasNext()) {
					credenciales[i]=sc.nextLine();
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
	
}

