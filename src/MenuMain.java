

public class MenuMain {

	public static void main(String[] args) {
		
		MenuControlador cont = new MenuControlador();
		MenuModelo modelo = new MenuModelo();
		MenuVista vista = new MenuVista();
		
		cont.setModelo(modelo);
		cont.setVista(vista);
		
		modelo.setVista(vista);
		
		vista.setControlador(cont);
		vista.setModelo(modelo);
		
		
		vista.setVisible(true);
	}

}
