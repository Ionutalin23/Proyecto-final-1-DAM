import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Vista_Info_Alumno extends JFrame {
	private controlador miControlador;
	private modelo miModelo;
	private JTextField txtDni;
	private JTextField txtName;
	private JTextField txtApellidos;
	private JTextField txtNacim;
	private JPanel pnlCrear;
	private JLabel lblLogout;
	private JLabel lblBack;
	private JTextField txtNacionalidad;
	private JLabel lblUser;
	
	public Vista_Info_Alumno() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
		ImageIcon ico =new ImageIcon(getClass().getResource("/images/logo.png"));
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/images/uni2.jpg"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 870, 617);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel pnlUser = new JPanel();
		pnlUser.setForeground(new Color(240, 248, 255));
		pnlUser.setBackground(new Color(192, 192, 192,190));
		pnlUser.setBounds(0, 0, 208, 27);
		panel.add(pnlUser);
		pnlUser.setLayout(null);
		
		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(0, 0, 208, 27);
		pnlUser.add(lblUser);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setForeground(new Color(0, 0, 0));
		lblLogo.setBounds(25, 555, 162, 49);
		panel.add(lblLogo);
		ImageIcon img=new ImageIcon(ico.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
		lblLogo.setIcon(img);
		lblLogo.setBackground(new Color(0, 0, 0));
		
		JPanel pnlContenido = new JPanel();
		pnlContenido.setBounds(230, 32, 405, 561);
		panel.add(pnlContenido);
		pnlContenido.setBackground(new Color(226,106,106,240));
		pnlContenido.setLayout(null);
		
		JLabel lblTitle = new JLabel("Informaci\u00F3n del alumno:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(35, 82, 296, 29);
		pnlContenido.add(lblTitle);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(0, 0, 0));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(35, 147, 56, 16);
		pnlContenido.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(35, 176, 267, 22);
		pnlContenido.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(35, 211, 77, 16);
		pnlContenido.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(35, 240, 267, 22);
		pnlContenido.add(txtName);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(35, 275, 92, 16);
		pnlContenido.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(35, 304, 267, 22);
		pnlContenido.add(txtApellidos);
		
		JLabel lblNacim = new JLabel("FECHA DE NACIMIENTO:");
		lblNacim.setForeground(Color.BLACK);
		lblNacim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacim.setBounds(35, 339, 177, 16);
		pnlContenido.add(lblNacim);
		
		txtNacim = new JTextField();
		txtNacim.setColumns(10);
		txtNacim.setBounds(35, 368, 267, 22);
		pnlContenido.add(txtNacim);
		
		pnlCrear = new JPanel();
		pnlCrear.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 0, 0), null, null, null));
		pnlCrear.setBackground(new Color(128, 0, 0));
		pnlCrear.setBounds(148, 492, 114, 27);
		pnlContenido.add(pnlCrear);
		pnlCrear.setLayout(null);
		
		JLabel lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(0, 0, 114, 27);
		pnlCrear.add(lblCrear);
		
		JPanel pnlLogout = new JPanel();
		pnlLogout.setLayout(null);
		pnlLogout.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 0, 0), null, null, null));
		pnlLogout.setBackground(new Color(128, 0, 0));
		pnlLogout.setBounds(301, 13, 92, 27);
		pnlContenido.add(pnlLogout);
		
		lblLogout = new JLabel("LOGOUT");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBackground(new Color(205, 92, 92));
		lblLogout.setBounds(0, 0, 92, 27);
		pnlLogout.add(lblLogout);
		
		lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon(Vista_Info_Tutor.class.getResource("/images/back-arrow.png")));
		lblBack.setBounds(35, 13, 34, 16);
		pnlContenido.add(lblBack);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD:");
		lblNacionalidad.setForeground(Color.BLACK);
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacionalidad.setBounds(35, 404, 131, 16);
		pnlContenido.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(35, 433, 267, 22);
		pnlContenido.add(txtNacionalidad);
		
		JLabel lblPortada = new JLabel("");
		lblPortada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPortada.setBounds(0, 0, 870, 617);
		panel.add(lblPortada);
		ImageIcon img2=new ImageIcon(ico2.getImage().getScaledInstance(lblPortada.getWidth(), lblPortada.getHeight(), Image.SCALE_SMOOTH));
		lblPortada.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/resi.jpg")));
		lblPortada.setBackground(new Color(0, 0, 0));
		
	
	}

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}
}
