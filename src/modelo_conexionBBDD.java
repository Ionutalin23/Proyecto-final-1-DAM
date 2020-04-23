import java.sql.Connection;
import java.sql.DriverManager;

public class modelo_conexionBBDD {

	//Atributos de la clase
		private String bd = "PI";
		private String login = "SYSTEM";
		private String pwd = "Moni199823*";
		private String url = "jdbc:oracle:thin:@localhost:1521:XE";
		private Connection conexion;


//Constructor que crea la conexión
	public modelo_conexionBBDD() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println(" - Conexión con ORACLE establecida -");
			conexion.close();
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con ORACLE -");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new modelo_conexionBBDD();
	}
}
