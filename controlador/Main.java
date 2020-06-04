package controlador;

import java.awt.EventQueue;

import modelo.modelo;
import vista.Busqueda_Alumnos;
import vista.Busqueda_Anexos;
import vista.Busqueda_Empresas;
import vista.Busqueda_Grupos;
import vista.Busqueda_Tutores;
import vista.MenuVista;
import vista.Ventana_Estadisticas;
import vista.Ventana_Conf_Delete;
import vista.Ventana_Conf_Anexo;
import vista.Ventana_Login;
import vista.Ventana_Login_Config;
import vista.Ventana_Mensaje_ERROR;
//import vista.Ventana_config_User;
import vista.Vista_Info_Alumno;
import vista.Vista_Info_Empresa;
import vista.Vista_Info_Grupo;
import vista.Vista_Info_Tutor;

public class Main {
	public static void main(String[] args) {
		
		controlador miControlador = new controlador();
		
		modelo miModelo = new modelo();
		
		Ventana_Login vista_ventana_login = new Ventana_Login();
		MenuVista vista_ventana_menu = new MenuVista();
		Ventana_Login_Config ventana_login_config= new Ventana_Login_Config();
		
		Busqueda_Alumnos busquedaAlumnos= new Busqueda_Alumnos();
		Busqueda_Anexos busquedaAnexos= new Busqueda_Anexos();
		Busqueda_Empresas busquedaEmpresas= new Busqueda_Empresas();
		Busqueda_Grupos busquedaGrupos= new Busqueda_Grupos();
		Busqueda_Tutores busquedaTutores=new Busqueda_Tutores();
		Ventana_Estadisticas ventana_estadisticas= new Ventana_Estadisticas();
		
		Vista_Info_Alumno vista_info_alumno=new Vista_Info_Alumno();
		Vista_Info_Grupo vista_info_grupo=new Vista_Info_Grupo();
		Vista_Info_Tutor vista_info_tutor=new Vista_Info_Tutor();
		Vista_Info_Empresa vista_info_empresa= new Vista_Info_Empresa(); 
		
		Ventana_Mensaje_ERROR ventana_mensaje_error= new Ventana_Mensaje_ERROR();
		Ventana_Conf_Delete ventana_Conf_Delete = new Ventana_Conf_Delete();
		Ventana_Conf_Anexo ventana_conf_anexo = new Ventana_Conf_Anexo();
		
		miControlador.setModelo(miModelo);
		miControlador.setVista(vista_ventana_login);
		miControlador.setVista(vista_ventana_menu);
		miControlador.setVista(busquedaAlumnos);
		miControlador.setVista(busquedaAnexos);
		miControlador.setVista(busquedaEmpresas);
		miControlador.setVista(busquedaGrupos);
		miControlador.setVista(busquedaTutores);
		miControlador.setVista(vista_info_tutor);
		miControlador.setVista(vista_info_alumno);
		miControlador.setVista(vista_info_empresa);
		miControlador.setVista(vista_info_grupo);
		miControlador.setVista(ventana_login_config);
		miControlador.setVista(ventana_mensaje_error);
		miControlador.setVista(ventana_estadisticas);
		miControlador.setVista(ventana_Conf_Delete);
		miControlador.setVista(ventana_conf_anexo);
		
		miModelo.setVista(vista_ventana_login);
		miModelo.setVista(vista_ventana_menu);
		miModelo.setVista(busquedaAlumnos);
		miModelo.setVista(busquedaAnexos);
		miModelo.setVista(busquedaEmpresas);
		miModelo.setVista(busquedaGrupos);
		miModelo.setVista(busquedaTutores);
		miModelo.setVista(vista_info_alumno);
		miModelo.setVista(vista_info_grupo);
		miModelo.setVista(vista_info_tutor);
		miModelo.setVista(vista_info_empresa);
		miModelo.setVista(ventana_login_config);
		miModelo.setVista(ventana_mensaje_error);
		miModelo.setVista(ventana_estadisticas);
		miModelo.setVista(ventana_Conf_Delete);
		miModelo.setVista(ventana_conf_anexo);
		
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
		
		ventana_login_config.setControlador(miControlador);
		ventana_login_config.setModelo(miModelo);
		
		vista_ventana_menu.setControlador(miControlador);
		vista_ventana_menu.setModelo(miModelo);
		
		ventana_mensaje_error.setControlador(miControlador);
		ventana_mensaje_error.setModelo(miModelo);
		
		ventana_estadisticas.setControlador(miControlador);
		ventana_estadisticas.setModelo(miModelo);
		
		ventana_Conf_Delete.setControlador(miControlador);
		ventana_Conf_Delete.setModelo(miModelo);
		
		ventana_conf_anexo.setControlador(miControlador);
		ventana_conf_anexo.setModelo(miModelo);
		
		
		vista_ventana_login.setVisible(true);
		

	}
}