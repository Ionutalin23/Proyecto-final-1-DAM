
import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		
		controlador miControlador = new controlador();
		
		modelo miModelo = new modelo();
		
		Ventana_Login vista_ventana_login = new Ventana_Login();
		MenuVista vista_ventana_menu = new MenuVista();
		
		miControlador.setModelo(miModelo);
		miControlador.setVista(vista_ventana_login);
		miControlador.setVista(vista_ventana_menu);
		
		miModelo.setVista(vista_ventana_login);
		miModelo.setVista(vista_ventana_menu);
		
		vista_ventana_login.setControlador(miControlador);
		vista_ventana_login.setModelo(miModelo);
		
		vista_ventana_menu.setControlador(miControlador);
		vista_ventana_menu.setModelo(miModelo);
		
		
		
	}
}

