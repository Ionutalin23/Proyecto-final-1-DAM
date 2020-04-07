
public class Main {

	public static void main(String[] args) {
		controlador miControlador= new controlador();
		modelo miModelo= new modelo();
		Vista_Info_Alumno vista_info_alumno=new Vista_Info_Alumno();
		Vista_Info_Grupo vista_info_grupo=new Vista_Info_Grupo();
		Vista_Info_Tutor vista_info_tutor=new Vista_Info_Tutor();
		Vista_Info_Empresa vista_info_empresa= new Vista_Info_Empresa(); 
		
		
		miControlador.setModelo(miModelo);
		miControlador.setVista_info_tutor(vista_info_tutor);
		miControlador.setVista_info_alumno(vista_info_alumno);
		miControlador.setVista_info_empresa(vista_info_empresa);
		miControlador.setVista_info_grupo(vista_info_grupo);
		
		miModelo.setVista_info_alumno(vista_info_alumno);
		miModelo.setVista_info_grupo(vista_info_grupo);
		miModelo.setVista_info_tutor(vista_info_tutor);
		miModelo.setVista_info_empresa(vista_info_empresa);
		
		vista_info_alumno.setControlador(miControlador);
		vista_info_alumno.setModelo(miModelo);
		vista_info_grupo.setControlador(miControlador);
		vista_info_grupo.setModelo(miModelo);
		vista_info_tutor.setControlador(miControlador);
		vista_info_tutor.setModelo(miModelo);
		vista_info_empresa.setControlador(miControlador);
		vista_info_empresa.setModelo(miModelo);
		
		vista_info_empresa.setVisible(true);

	}

}

