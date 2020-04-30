package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import vista.Busqueda_Alumnos;
import vista.Busqueda_Anexos;
import vista.Busqueda_Empresas;
import vista.Busqueda_Grupos;
import vista.Busqueda_Tutores;
import vista.MenuVista;
import vista.Ventana_Login;
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

	private String bd = "PI";
	private String login = "SYSTEM";
	private String pwd = "password";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private Connection conexion;
	private int fallos;
	private String resultado;
	private String USR;
	private String rol;
	private String SQLanexo2_1 = "SELECT nombre, apellidos, anexo_2_1 FROM PI.alumno, PI.practica WHERE num_exp=alumno_num_exp";
	private String SQLanexo1 = "SELECT cod_centro, localidad, director, anexo_1 FROM PI.centro, PI.colabora WHERE cod_centro=centro_cod_centro";
	private String SQLanexo2_2 = "SELECT A.nombre, A.apellidos, E.nombre \"EMPRESA\", PR.horario, G.Anexo_2_2 FROM PI.alumno A, PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.Tutor T, PI.centro C, "
			+ "PI.colabora CO, PI.Empresa E, PI.practica PR WHERE A.num_exp=P.alumno_num_exp AND T.dni_tutor=G.tutor_dni_tutor AND C.cod_centro=T.centro_cod_centro AND CO.empresa_cif=E.cif "
			+ "AND P.grupo_cod_grupo=GR.cod_grupo AND G.grupo_cod_grupo=GR.cod_grupo AND CO.centro_cod_centro=C.cod_centro\n"
			+ "AND PR.empresa_cif=E.cif AND PR.alumno_num_exp=A.num_exp";
	private String SQLTut = "SELECT nombre, apellidos, nombre_ciclo FROM PI.Tutor TU, PI.Grupo GR, PI.Gestiona GE WHERE TU.dni_tutor = GE.tutor_dni_tutor AND GE.grupo_cod_grupo = GR.cod_grupo";
	private String SQLTut_2 = "SELECT nombre, apellidos,clave_ciclo, nombre_ciclo FROM PI.Tutor TU, PI.Grupo GR, PI.Gestiona GE WHERE TU.dni_tutor = GE.tutor_dni_tutor AND GE.grupo_cod_grupo = GR.cod_grupo AND nombre_ciclo ='DAM'";
	private String SQAlumnos = "SELECT * FROM PI.alumno";

	public modelo() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println(" - Conexión con ORACLE establecida -");
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con ORACLE -");
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

	public String getSQTUT_1() {
		return SQLTut;
	}

	public String getSQTUT_2() {
		return SQLTut_2;
	}

	public String getSQLanexo2_2() {
		return SQLanexo2_2;
	}

	public String getSQLalumnos() {
		return SQAlumnos;
	}

//	private int getColumnasAnexo2_1() {
//		int num = 0;
//		try {
//			PreparedStatement pst = conexion.prepareStatement(SQLanexo2_1);
//			ResultSet rs = pst.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			num = rsmd.getColumnCount();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//	
//	private int getFilasAnexo2_1() {
//		int numFilas = 0;
//		try {
//			PreparedStatement pst = conexion.prepareStatement(SQLanexo2_1);
//			ResultSet rs = pst.executeQuery();
//			while (rs.next()) {
//				numFilas++;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return numFilas;
//	}
//
//	public TableModel getTablaAnexo2_1() {
//		int numColumnas=getColumnasAnexo2_1();
//		int numFilas=getFilasAnexo2_1();
//		
//		String[] cabecera= new String[numColumnas];
//		
//		Object[][] contenido=new Object[numFilas][numColumnas];
//		
//		try {
//			PreparedStatement pst= conexion.prepareStatement(SQLanexo2_1);
//			ResultSet rs=pst.executeQuery();
//			ResultSetMetaData rsmd= rs.getMetaData();
//			for (int i = 0; i < numColumnas; i++) {
//				cabecera[i]= rsmd.getColumnName(i+1);
//			}
//			int fila=0;
//			while (rs.next()) {
//				for (int column = 1; column <= numColumnas; column++) {
//					contenido[fila][column -1] =rs.getString(column);
//				}
//			fila++;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 
//		return new DefaultTableModel(contenido,cabecera);
//		
//		
//	}
//	private int getColumnasAnexo1() {
//		int num = 0;
//		try {
//			PreparedStatement pst = conexion.prepareStatement(SQLanexo1);
//			ResultSet rs = pst.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			num = rsmd.getColumnCount();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//	
//	private int getFilasAnexo1() {
//		int numFilas = 0;
//		try {
//			PreparedStatement pst = conexion.prepareStatement(SQLanexo1);
//			ResultSet rs = pst.executeQuery();
//			while (rs.next()) {
//				numFilas++;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return numFilas;
//	}
//
//	public TableModel getTablaAnexo1() {
//		int numColumnas=getColumnasAnexo1();
//		int numFilas=getFilasAnexo1();
//		
//		String[] cabecera= new String[numColumnas];
//		
//		Object[][] contenido=new Object[numFilas][numColumnas];
//		
//		try {
//			PreparedStatement pst= conexion.prepareStatement(SQLanexo1);
//			ResultSet rs=pst.executeQuery();
//			ResultSetMetaData rsmd= rs.getMetaData();
//			for (int i = 0; i < numColumnas; i++) {
//				cabecera[i]= rsmd.getColumnName(i+1);
//			}
//			int fila=0;
//			while (rs.next()) {
//				for (int column = 1; column <= numColumnas; column++) {
//					contenido[fila][column -1] =rs.getString(column);
//				}
//			fila++;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 
//		return new DefaultTableModel(contenido,cabecera);
//		
//	
//	}

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
}