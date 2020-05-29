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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
	
//  ========================================================================= MVC ====================================================

	private String[] credenciales = new String[3];
	private ArrayList<Integer> alumnosEstadisticas= new ArrayList<Integer>();
	private LinkedHashMap<String, Integer> gruposAlumnos= new LinkedHashMap<String, Integer>();
	private String nombreTabla;
	private String nombreClave;
	private String clave;
	private Connection conexion;
	private int fallos;
	private String resultado;
	private String resultadoAlum;
	private String resultadoUsu;
	private String resultadoDEL;
	private String USR;
	private String rol;
	private String SQLanexo2_1 = "SELECT nombre, apellidos, anexo_2_1 FROM PI.alumno, PI.practica WHERE num_exp=alumno_num_exp";
	private String SQLanexo1 = "SELECT E.nombre \"Empresa\",C.cod_centro, C.localidad, C.director, CO.anexo_1 FROM PI.centro C, PI.colabora CO, PI.empresa E WHERE CO.centro_cod_centro=C.cod_centro AND  CO.empresa_cif=E.cif";
	private String SQLanexo2_2 = "SELECT A.nombre, A.apellidos, E.nombre \"EMPRESA\", PR.horario, G.Anexo_2_2 FROM PI.alumno A, PI.pertenece P, PI.grupo GR, PI.gestiona G, PI.Tutor T, PI.centro C, "
			+ "PI.colabora CO, PI.Empresa E, PI.practica PR WHERE A.num_exp=P.alumno_num_exp AND T.dni_tutor=G.tutor_dni_tutor AND C.cod_centro=T.centro_cod_centro AND CO.empresa_cif=E.cif "
			+ "AND P.grupo_cod_grupo=GR.cod_grupo AND G.grupo_cod_grupo=GR.cod_grupo AND CO.centro_cod_centro=C.cod_centro\n"
			+ "AND PR.empresa_cif=E.cif AND PR.alumno_num_exp=A.num_exp";
	private String SQLanexo3 = "SELECT A.nombre, A.apellidos, A.dni, PR.anexo_3 FROM PI.alumno A, PI.practica PR WHERE num_exp=alumno_num_exp";
	private String SQLanexo7 = "SELECT A.nombre, A.apellidos, PR.anexo_7 FROM PI.alumno A, PI.practica PR WHERE A.num_exp=PR.alumno_num_exp";
	private String SQLanexo8 = "SELECT A.nombre, A.apellidos,CONCAT(C.localidad,CONCAT(',',C.cod_centro)) \"CENTRO\", E.Nombre \"EMPRESA\", PR.anexo_8 FROM PI.alumno A, PI.practica PR, PI.empresa E, PI.centro C, PI.colabora CO WHERE num_exp=alumno_num_exp AND PR.empresa_cif=E.cif\n"
			+ "AND CO.empresa_cif=E.cif AND C.cod_centro=CO.centro_cod_centro";
	private String SQLTut = "SELECT * FROM PI.TUTOR";
	private String SQLTut_2 = "SELECT nombre, apellidos,clave_ciclo, nombre_ciclo FROM PI.Tutor TU, PI.Grupo GR, PI.Gestiona GE WHERE TU.dni_tutor = GE.tutor_dni_tutor AND GE.grupo_cod_grupo = GR.cod_grupo AND nombre_ciclo ='DAMM'";
	private String SQAlumno = "SELECT * FROM PI.alumno";
	private String SQLEmp = "SELECT * FROM PI.empresa";
	private String SQLGrp = "SELECT * FROM PI.grupo";
	private String SqlEstadisticasPracticas = "SELECT COUNT(ANEXO_2_1) FROM PI.practica where ? IS NOT NULL";
	private String SqlEstadisticasPracticas2 = "SELECT COUNT(?) FROM PI.practica where ANEXO_2_1 IS NULL";
	private String SqlGruposAlumnos="select nom_grupo \"GRUPO\", count(*) \"ALUMNOS\" from PI.grupo, PI.alumno, PI.pertenece where alumno.num_exp=pertenece.alumno_num_exp AND grupo.cod_grupo=pertenece.grupo_cod_grupo group by grupo.nom_grupo";
	private JTable tablaTut;
	private JTable tablaAnx;
	private ChartPanel barPanelAlumnos;
	private ChartPanel CircularPanelAlumnos;
	private ChartPanel linealPanelAlumnos;
	private ChartPanel barPanelGrupos;
	private ChartPanel CircularPanelGrupos;

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
				FileOutputStream fout = new FileOutputStream("img/" + usu + ".jpg");
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
		DefaultCategoryDataset barChart= new DefaultCategoryDataset();
		barChart.setValue((alumnosEstadisticas.get(0)), "cantidad","Alumnos en Prácticas");
		barChart.setValue((alumnosEstadisticas.get(1)), "cantidad","Alumnos sin Prácticas");
		barChart.setValue((alumnosEstadisticas.get(0)+alumnosEstadisticas.get(1)), "cantidad","Total Alumnos");
		
		JFreeChart barChart1 = ChartFactory.createBarChart3D("Alumnos", "", "Cantidad", barChart, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt= barChart1.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.orange);
		barPanelAlumnos = new ChartPanel(barChart1);
		ventana_estadisticas.actualizarPanel();
		
	}
	
	public void dibujarGraficaCircularAlumnos() {
		DefaultPieDataset circularChart= new DefaultPieDataset();
		circularChart.setValue("Alumnos en Prácticas: "+alumnosEstadisticas.get(0),alumnosEstadisticas.get(0));
		circularChart.setValue("Alumnos sin Prácticas: "+alumnosEstadisticas.get(1),alumnosEstadisticas.get(1));
		JFreeChart circulo= ChartFactory.createPieChart3D("Alumnos",circularChart, true, true, false);
		BufferedImage circchrt= circulo.createBufferedImage(785, 460);;
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
		XYSeries series=new XYSeries("Alumnos");
		series.add(0,0);
		series.add(0,5);
		series.add((int)alumnosEstadisticas.get(0),30);
		XYDataset datos= new XYSeriesCollection(series);
		JFreeChart linea= ChartFactory.createXYLineChart("Alumnos en prácticas", "cantidad alumnos", "Marzo", datos, PlotOrientation.HORIZONTAL, true, true, false);
		BufferedImage linealImage= linea.createBufferedImage(785, 460);
		linealPanelAlumnos= new ChartPanel(linea);
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
			PreparedStatement ps= conexion.prepareStatement(SqlEstadisticasPracticas);
			ps.setString(1, "ANEXO_2_1");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				alumnosEstadisticas.add(rs.getInt(1));
			}
			PreparedStatement ps2= conexion.prepareStatement(SqlEstadisticasPracticas2);
			ps2.setString(1, "*");
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()) {
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
			PreparedStatement ps= conexion.prepareStatement(SqlGruposAlumnos);
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()) {
				gruposAlumnos.put(rs.getString("GRUPO"), rs.getInt("ALUMNOS"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dibujarGraficaBarrasGrupos() {
		DefaultCategoryDataset barChart= new DefaultCategoryDataset();
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[0])), "cantidad",(Comparable) gruposAlumnos.keySet().toArray()[0]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[1])), "cantidad",(Comparable) gruposAlumnos.keySet().toArray()[1]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[2])), "cantidad",(Comparable) gruposAlumnos.keySet().toArray()[2]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[3])), "cantidad",(Comparable) gruposAlumnos.keySet().toArray()[3]);
		barChart.setValue((gruposAlumnos.get(gruposAlumnos.keySet().toArray()[4])), "cantidad",(Comparable) gruposAlumnos.keySet().toArray()[4]);
		
		JFreeChart barChart1 = ChartFactory.createBarChart3D("Grupos", "", "Cantidad Alumnos", barChart, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt= barChart1.getCategoryPlot();
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
		DefaultPieDataset circularChart= new DefaultPieDataset();
		circularChart.setValue(gruposAlumnos.keySet().toArray()[0]+": "+gruposAlumnos.get(gruposAlumnos.keySet().toArray()[0]),gruposAlumnos.get(gruposAlumnos.keySet().toArray()[0]));
		circularChart.setValue(gruposAlumnos.keySet().toArray()[1]+": "+gruposAlumnos.get(gruposAlumnos.keySet().toArray()[1]),gruposAlumnos.get(gruposAlumnos.keySet().toArray()[1]));
		circularChart.setValue(gruposAlumnos.keySet().toArray()[2]+": "+gruposAlumnos.get(gruposAlumnos.keySet().toArray()[2]),gruposAlumnos.get(gruposAlumnos.keySet().toArray()[2]));
		circularChart.setValue(gruposAlumnos.keySet().toArray()[3]+": "+gruposAlumnos.get(gruposAlumnos.keySet().toArray()[3]),gruposAlumnos.get(gruposAlumnos.keySet().toArray()[3]));
		circularChart.setValue(gruposAlumnos.keySet().toArray()[4]+": "+gruposAlumnos.get(gruposAlumnos.keySet().toArray()[4]),gruposAlumnos.get(gruposAlumnos.keySet().toArray()[4]));
		JFreeChart circulo= ChartFactory.createPieChart3D("Grupos",circularChart, true, true, false);
		BufferedImage circchrt= circulo.createBufferedImage(785, 460);;
		CircularPanelGrupos = new ChartPanel(circulo);
		CircularPanelGrupos.setBounds(44, 103, 785, 460);
		ventana_estadisticas.actualizarPanel5();
	}
//ELIMINAR DATOS
	public void borrarDato(String clave, String nombre, String nombreClave) {

		nombre = "PI." + nombre;
		String delete = "DELETE FROM " + nombre + " WHERE " + nombreClave + " = '" + clave + "'"; 

		try {
			Statement ins = conexion.createStatement();
			ResultSet rs=ins.executeQuery(delete);
			ins.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

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
}
