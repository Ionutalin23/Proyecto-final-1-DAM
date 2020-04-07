
public class controlador {
	private modelo miModelo;
	private Ventana_Login vista_ventana_login;
	private MenuVista vista_ventana_menu;
	private Busqueda_Alumnos busquedaAlumnos;
	private Busqueda_Anexos busquedaAnexos;
	private Busqueda_Empresas busquedaEmpresas;
	private Busqueda_Grupos busquedaGrupos;
	private Busqueda_Tutores busquedaTutores;
	
	
	
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
	public void setVista(MenuVista vista_ventana_menu) {
		this.vista_ventana_menu = vista_ventana_menu;
	}
	public void menu() {
		vista_ventana_login.frame.setVisible(false);
		vista_ventana_menu.setVisible(true);
	}
	public void logout() {
		vista_ventana_menu.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
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
	}
	public void back1() {
		busquedaAlumnos.setVisible(false);
		vista_ventana_menu.setVisible(true);
		
	}
	public void logout2() {
		busquedaAlumnos.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
	}
	public void back2() {
		busquedaEmpresas.setVisible(false);
		vista_ventana_menu.setVisible(true);
	}
	public void logout3() {
		busquedaEmpresas.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
	}
	public void back3() {
		busquedaGrupos.setVisible(false);
		vista_ventana_menu.setVisible(true);
		
	}
	public void logout4() {
		busquedaGrupos.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
	}
	public void back4() {
		busquedaTutores.setVisible(false);
		vista_ventana_menu.setVisible(true);
		
	}
	public void logout5() {
		busquedaTutores.setVisible(false);
		vista_ventana_login.frame.setVisible(true);
	}
}
	
	
	
