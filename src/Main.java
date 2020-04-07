import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		
		controlador miControlador = new controlador();
		modelo miModelo = new modelo();
		Ventana_Login vista_ventana_login = new Ventana_Login();
		
		miControlador.setModelo(miModelo);
		miControlador.setVista(vista_ventana_login);
		
		miModelo.setVista(vista_ventana_login);
		vista_ventana_login.setControlador(miControlador);
		vista_ventana_login.setModelo(miModelo);
		
		
		
	}
}
