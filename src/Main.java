
import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		
		controlador miControlador = new controlador();
		
		modelo miModelo = new modelo();
		
		Ventana_Login vista_ventana_login = new Ventana_Login();
		MenuVista vista_ventana_menu = new MenuVista();
		
		Busqueda_Alumnos busquedaAlumnos= new Busqueda_Alumnos();
		Busqueda_Anexos busquedaAnexos= new Busqueda_Anexos();
		Busqueda_Empresas busquedaEmpresas= new Busqueda_Empresas();
		Busqueda_Grupos busquedaGrupos= new Busqueda_Grupos();
		Busqueda_Tutores busquedaTutores=new Busqueda_Tutores();
		
		miControlador.setModelo(miModelo);
		miControlador.setVista(vista_ventana_login);
		miControlador.setVista(vista_ventana_menu);
		miControlador.setVista(busquedaAlumnos);
		miControlador.setVista(busquedaAnexos);
		miControlador.setVista(busquedaEmpresas);
		miControlador.setVista(busquedaGrupos);
		miControlador.setVista(busquedaTutores);
		
		miModelo.setVista(vista_ventana_login);
		miModelo.setVista(vista_ventana_menu);
		miModelo.setVista(busquedaAlumnos);
		miModelo.setVista(busquedaAnexos);
		miModelo.setVista(busquedaEmpresas);
		miModelo.setVista(busquedaGrupos);
		miModelo.setVista(busquedaTutores);
		
		busquedaAlumnos.setModelo(miModelo);
		busquedaAlumnos.setControlador(miControlador);

		busquedaAnexos.setModelo(miModelo);
		busquedaAnexos.setControlador(miControlador);
		
		busquedaEmpresas.setModelo(miModelo);
		busquedaEmpresas.setControlador(miControlador);
		
		busquedaTutores.setModelo(miModelo);
		busquedaTutores.setControlador(miControlador);
		
		busquedaGrupos.setModelo(miModelo);
		busquedaGrupos.setControlador(miControlador);
		
		vista_ventana_login.setControlador(miControlador);
		vista_ventana_login.setModelo(miModelo);
		
		vista_ventana_menu.setControlador(miControlador);
		vista_ventana_menu.setModelo(miModelo);
		
		vista_ventana_login.frame.setVisible(true);
		
	}
}

