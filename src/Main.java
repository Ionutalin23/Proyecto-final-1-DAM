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
		
		Vista_Info_Alumno vista_info_alumno=new Vista_Info_Alumno();
		Vista_Info_Grupo vista_info_grupo=new Vista_Info_Grupo();
		Vista_Info_Tutor vista_info_tutor=new Vista_Info_Tutor();
		Vista_Info_Empresa vista_info_empresa= new Vista_Info_Empresa(); 
		
		miControlador.setModelo(miModelo);
		miControlador.setVista(vista_ventana_login);
		miControlador.setVista(vista_ventana_menu);
		miControlador.setVista(busquedaAlumnos);
		miControlador.setVista(busquedaAnexos);
		miControlador.setVista(busquedaEmpresas);
		miControlador.setVista(busquedaGrupos);
		miControlador.setVista(busquedaTutores);
		miControlador.setVista_info_tutor(vista_info_tutor);
		miControlador.setVista_info_alumno(vista_info_alumno);
		miControlador.setVista_info_empresa(vista_info_empresa);
		miControlador.setVista_info_grupo(vista_info_grupo);
		
		miModelo.setVista(vista_ventana_login);
		miModelo.setVista(vista_ventana_menu);
		miModelo.setVista(busquedaAlumnos);
		miModelo.setVista(busquedaAnexos);
		miModelo.setVista(busquedaEmpresas);
		miModelo.setVista(busquedaGrupos);
		miModelo.setVista(busquedaTutores);
		miModelo.setVista_info_alumno(vista_info_alumno);
		miModelo.setVista_info_grupo(vista_info_grupo);
		miModelo.setVista_info_tutor(vista_info_tutor);
		miModelo.setVista_info_empresa(vista_info_empresa);
		
		vista_info_grupo.setControlador(miControlador);
		vista_info_grupo.setModelo(miModelo);
		
		vista_info_tutor.setControlador(miControlador);
		vista_info_tutor.setModelo(miModelo);
		
		vista_info_empresa.setControlador(miControlador);
		vista_info_empresa.setModelo(miModelo);
		
		vista_info_alumno.setControlador(miControlador);
		vista_info_alumno.setModelo(miModelo);
		
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