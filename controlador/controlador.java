package controlador;

import modelo.modelo;
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

public class controlador {
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

	public void setVista_info_alumno(Vista_Info_Alumno vista_info_alumno) {
		this.vista_info_alumno = vista_info_alumno;
	}

	public void setVista_info_empresa(Vista_Info_Empresa vista_info_empresa) {
		this.vista_info_empresa = vista_info_empresa;
	}

	public void setVista_info_tutor(Vista_Info_Tutor vista_info_tutor) {
		this.vista_info_tutor = vista_info_tutor;
	}

	public void setVista_info_grupo(Vista_Info_Grupo vista_info_grupo) {
		this.vista_info_grupo = vista_info_grupo;
	}

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
		
		vista_ventana_login.frame.setVisible(false);
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
		
		vista_ventana_login.frame.setVisible(false);
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
	}

	public void logout() {
		vista_ventana_menu.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
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
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();
	}

	public void back1() {
		busquedaAlumnos.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout2() {
		busquedaAlumnos.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();
	}

	public void back2() {
		busquedaEmpresas.setVisible(false);
		vista_ventana_menu.setVisible(true);
	}

	public void logout3() {
		busquedaEmpresas.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();
	}

	public void back3() {
		busquedaGrupos.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout4() {
		busquedaGrupos.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();
	}

	public void back4() {
		busquedaTutores.setVisible(false);
		vista_ventana_menu.setVisible(true);

	}

	public void logout5() {
		busquedaTutores.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
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
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();
	}

	public void logout7() {
		vista_info_empresa.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();

	}

	public void logout8() {
		vista_info_grupo.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
		miModelo.finalizar();

	}

	public void logout9() {
		vista_info_tutor.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
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
	public void loginConfig() {
		ventana_login_config.frame.setVisible(true);
		vista_ventana_login.frame.setVisible(false);
	}
	public void loginConfigSalir() {
		ventana_login_config.frame.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
	}

}