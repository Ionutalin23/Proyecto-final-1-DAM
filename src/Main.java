

public class Main {

	public static void main(String[] args) {
		
		controlador cont = new controlador();
		modelo modelo = new modelo();
		MenuVista vista = new MenuVista();
		
		cont.setModelo(modelo);
		cont.setVista(vista);
		
		modelo.setVista(vista);
		
		vista.setControlador(cont);
		vista.setModelo(modelo);
		
		
		vista.setVisible(true);
	}

}
