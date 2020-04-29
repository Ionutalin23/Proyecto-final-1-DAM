import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
	private String pwd = "Gormiti2001";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private Connection conexion;
	private int fallos;
	private String resultado;
	private String USR;
	private String rol;
	private String SQLanexo2_1 = "SELECT nombre, apellidos, anexo_2_1 FROM PI.alumno, PI.practica WHERE num_exp=alumno_num_exp";

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

	private int getColumnas() {
		int num = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(SQLanexo2_1);
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	private int getFilas() {
		int numFilas = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(SQLanexo2_1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				numFilas++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	public TableModel getTabla() {
		int numColumnas=getColumnas();
		int numFilas=getFilas();
		
		String[] cabecera= new String[numColumnas];
		
		Object[][] contenido=new Object[numFilas][numColumnas];
		
		try {
			PreparedStatement pst= conexion.prepareStatement(SQLanexo2_1);
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData rsmd= rs.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				cabecera[i]= rsmd.getColumnName(i+1);
			}
			int fila=0;
			while (rs.next()) {
				for (int column = 1; column <= numColumnas; column++) {
					contenido[fila][column -1] =rs.getString(column);
				}
			fila++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return new DefaultTableModel(contenido,cabecera);
		
		
	}
}