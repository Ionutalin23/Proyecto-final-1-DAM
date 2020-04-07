import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		
		controlador miControlador = new controlador();
		modelo miModelo = new modelo();
		Ventana_Login miVista = new Ventana_Login();
		
		miControlador.setModelo(miModelo);
		miControlador.setVista(miVista);
		
		miModelo.setVista(miVista);
		miVista.setControlador(miControlador);
		miVista.setModelo(miModelo);
		
		
	}
}
