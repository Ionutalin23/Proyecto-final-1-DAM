package controlador;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import modelo.modelo;
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

public class controlador {
// ==================================================== MVC ==============================================
	private modelo miModelo;
	private Ventana_Login vista_ventana_login;
	private Ventana_Login_Config ventana_login_config;
	private MenuVista vista_ventana_menu;
	private Busqueda_Alumnos busquedaAlumnos;
	private Busqueda_Anexos busquedaAnexos;
	private Busqueda_Empresas busquedaEmpresas;
	private Busqueda_Grupos busquedaGrupos;
	private Busqueda_Tutores busquedaTutores;
	private Vista_Info_Alumno vista_info_alumno;
	private Vista_Info_Empresa vista_info_empresa;
	private Vista_Info_Tutor vista_info_tutor;
	private Vista_Info_Grupo vista_info_grupo;
	private Ventana_Mensaje_ERROR ventana_mensaje_error;
	private Ventana_Estadisticas ventana_estadisticas;
	private Ventana_Conf_Delete ventana_conf_delete;


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

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setVista(Ventana_Login vista_ventana_login) {
		this.vista_ventana_login = vista_ventana_login;
	}
	

	public void setVista(Ventana_Login_Config ventana_login_config) {
		this.ventana_login_config = ventana_login_config;
	}

	public void setVista(MenuVista vista_ventana_menu) {
		this.vista_ventana_menu = vista_ventana_menu;
	}

	public void setVista(Vista_Info_Alumno vista_info_alumno) {
		this.vista_info_alumno = vista_info_alumno;
	}

	public void setVista(Vista_Info_Empresa vista_info_empresa) {
		this.vista_info_empresa = vista_info_empresa;
	}

	public void setVista(Vista_Info_Tutor vista_info_tutor) {
		this.vista_info_tutor = vista_info_tutor;
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
	public void setVista(Ventana_Conf_Delete ventana_conf_delete) {
		this.ventana_conf_delete = ventana_conf_delete;
	}

// ================================================================================

	

	public void login() {
		String usuario = vista_ventana_login.getUsuario();
		String password = vista_ventana_login.getPassword();

		miModelo.login(usuario, password);
	}

	public void rol() {
		String usuario = vista_ventana_login.getUsuario();
		String password = vista_ventana_login.getPassword();

		miModelo.rol(usuario, password);
	}

	public void accesoTut() {
		
		vista_ventana_login.setVisible(false);
		vista_ventana_menu.cambiarTutor();
		vista_ventana_menu.setVisible(true);
		
		vista_ventana_menu.actualizarLogged();
		vista_info_alumno.actualizarLogged();
		vista_info_empresa.actualizarLogged();
		vista_info_grupo.actualizarLogged();
		vista_info_tutor.actualizarLogged();
		busquedaAlumnos.actualizarLogged();
		busquedaAnexos.actualizarLogged();
		busquedaEmpresas.actualizarLogged();
		busquedaGrupos.actualizarLogged();
		busquedaTutores.actualizarLogged();

	}

	public void accesoDir() {
		
		vista_ventana_login.setVisible(false);
		vista_ventana_menu.setVisible(true);
		vista_ventana_menu.cambiarDirector();
		
		vista_ventana_menu.actualizarLogged();
		vista_info_alumno.actualizarLogged();
		vista_info_empresa.actualizarLogged();
		vista_info_grupo.actualizarLogged();
		vista_info_tutor.actualizarLogged();
		busquedaAlumnos.actualizarLogged();
		busquedaAnexos.actualizarLogged();
		busquedaEmpresas.actualizarLogged();
		busquedaGrupos.actualizarLogged();
		busquedaTutores.actualizarLogged();
		ventana_estadisticas.actualizarLogged();
	}

	public void logout() {
		vista_ventana_menu.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void BusquedaAnexos() {
		vista_ventana_menu.setVisible(false);
		busquedaAnexos.setVisible(true);
	}

	public void BusquedaTutores() {
		vista_ventana_menu.setVisible(false);
		busquedaTutores.setVisible(true);
	}

	public void BusquedaEmpresas() {
		vista_ventana_menu.setVisible(false);
		busquedaEmpresas.setVisible(true);
	}

	public void BusquedaAlumnos() {
		vista_ventana_menu.setVisible(false);
		busquedaAlumnos.setVisible(true);
	}

	public void BusquedaGrupos() {
		vista_ventana_menu.setVisible(false);
		busquedaGrupos.setVisible(true);
	}

	public void back() {
		busquedaAnexos.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout1() {
		busquedaAnexos.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void back1() {
		busquedaAlumnos.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout2() {
		busquedaAlumnos.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void back2() {
		busquedaEmpresas.setVisible(false);
		vista_ventana_menu.setVisible(true);
	}

	public void logout3() {
		busquedaEmpresas.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void back3() {
		busquedaGrupos.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout4() {
		busquedaGrupos.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void back4() {
		busquedaTutores.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout5() {
		busquedaTutores.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void nuevoAlumno() {
		busquedaAlumnos.setVisible(false);
		vista_info_alumno.setVisible(true);
	}

	public void nuevaEmpresa() {
		busquedaEmpresas.setVisible(false);
		vista_info_empresa.setVisible(true);
	}

	public void nuevoGrupo() {
		busquedaGrupos.setVisible(false);
		vista_info_grupo.setVisible(true);

	}

	public void nuevoTutor() {
		busquedaTutores.setVisible(false);
		vista_info_tutor.setVisible(true);
	}

	public void logout6() {
		vista_info_alumno.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void logout7() {
		vista_info_empresa.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();

	}

	public void logout8() {
		vista_info_grupo.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();

	}

	public void logout9() {
		vista_info_tutor.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}
	public void logout10() {
		ventana_estadisticas.setVisible(false);
		vista_ventana_login.setVisible(true);
		miModelo.finalizar();
	}

	public void back5() {
		vista_info_alumno.setVisible(false);
		busquedaAlumnos.setVisible(true);

	}

	public void back6() {
		vista_info_empresa.setVisible(false);
		busquedaEmpresas.setVisible(true);

	}

	public void back7() {
		vista_info_grupo.setVisible(false);
		busquedaGrupos.setVisible(true);

	}

	public void back8() {
		vista_info_tutor.setVisible(false);
		busquedaTutores.setVisible(true);

	}
	public void back9() {
		ventana_estadisticas.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}
	public void loginConfig() {
		ventana_login_config.setVisible(true);
		vista_ventana_login.setVisible(false);
	}
	public void loginConfigSalir() {
		ventana_login_config.setVisible(false);
		vista_ventana_login.setVisible(true);
	}
	public void saveTable(JTable tabla) {
		miModelo.downloadTable(tabla);
	}
	public void insertarAlumno() {
		String dni=vista_info_alumno.getTxtDni();
		String nombre=vista_info_alumno.getTxtName();
		String apellido=vista_info_alumno.getTxtApellidos();
		String expediente=vista_info_alumno.getTxtExpediente();
		String nacionalidad=vista_info_alumno.getTxtNacionalidad();
		String fechaNacim=vista_info_alumno.getTxtNacim();
		miModelo.añadirAlumno(dni,nombre,apellido,expediente,nacionalidad,fechaNacim);
	}
	
	public void insertarEmpresa() {
		String cif=vista_info_empresa.getTxtCif();
		String nombre=vista_info_empresa.getTxtName();
		String direccion=vista_info_empresa.getTxtDireccion();
		String telefono=vista_info_empresa.getTxtTel();
		String localidad=vista_info_empresa.getTxtLocalidad();
		String representante=vista_info_empresa.getTxtRepresentante();
		String email=vista_info_empresa.getTxtMail();
		miModelo.añadirEmpresa(cif, nombre, direccion, telefono, localidad, representante, email);
	}
	
	public void insertarGrupo() {
		String codGrupo=vista_info_grupo.getTxtCodGrupo();
		String nombre=vista_info_grupo.getTxtName();
		String claveCiclo=vista_info_grupo.getTxtClaveCiclo();
		String nomCiclo=vista_info_grupo.getTxtNomCiclo();
		miModelo.añadirGrupo(codGrupo, nombre, claveCiclo, nomCiclo);
	}
	
	public void insertarTutor() {
		String dni=vista_info_tutor.getTxtDni();
		String nombre=vista_info_tutor.getTxtName();
		String apellidos=vista_info_tutor.getTxtApellidos();
		String codCentro=vista_info_tutor.getTxtCodCentro();
		miModelo.añadirTutor(dni, nombre, apellidos, codCentro);
	}

	public void insertarUsuario() {
		String nombre=vista_ventana_login.getTxtNameR();
		String apellido=vista_ventana_login.getTxtApellidoR();
		String email=vista_ventana_login.getTxtMailR();
		String username=vista_ventana_login.getTxtUserR();
		String password=vista_ventana_login.getTxtPassR();
		String rol=vista_ventana_login.getTxtRolR();
		miModelo.añadirUsuario(username, password, rol, email, nombre, apellido);
	}

	public void closeSystem() {
		System.exit(0);
	}

	public void loginError() {
		vista_ventana_login.setVisible(false);
		ventana_mensaje_error.setVisible(true);
	}
	public void ventana_conf_delete() {
		ventana_conf_delete.setVisible(true);
	}


	public void VentanaEstadisticas() {
		vista_ventana_menu.setVisible(false);
		ventana_estadisticas.setVisible(true);
		
	}

	public void graficaCircularPracticas() {
		miModelo.alumnosPracticasAlumnos();
		miModelo.dibujarGraficaCircularAlumnos();
	}

	public void graficaBarrasPracticas() {
		miModelo.alumnosPracticasAlumnos();
		miModelo.dibujarGraficaBarrasPracticas();	
	}

	public void graficaLinealPracticas() {
		miModelo.alumnosPracticasAlumnos();
		miModelo.dibujarGraficaLinealPracticas();
	}
	public void graficaBarrasGrupos() {
		miModelo.GruposAlumnos();
		miModelo.dibujarGraficaBarrasGrupos();	
	}
	public void graficaCircularGrupos() {
		miModelo.GruposAlumnos();
		miModelo.dibujarGraficaCircularGrupos();	
	}

	

}