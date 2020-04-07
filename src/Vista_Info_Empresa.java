import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Vista_Info_Empresa extends JFrame {
	private controlador miControlador;
	private modelo miModelo;
	private JTextField txtCif;
	private JTextField txtName;
	private JTextField txtDireccion;
	private JTextField txtTel;
	private JPanel pnlCrear;
	private JLabel lblLogout;
	private JLabel lblBack;
	private JTextField txtNacionalidad;
	private JLabel lblUser;
	private JTextField txtMail;
	private JTextField txtRepresentante;
	
	public Vista_Info_Empresa() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
		
		ImageIcon ico =new ImageIcon(getClass().getResource("/images/logo.png"));
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/images/uni2.jpg"));
		
		Image button1= new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image button2= new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image button3= new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		
		Image back1= new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Image back2= new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Image back3= new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		
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
		
		JLabel lblTitle = new JLabel("Informaci\u00F3n de empresa:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(35, 82, 302, 29);
		pnlContenido.add(lblTitle);
		
		JLabel lblCif = new JLabel("CIF:");
		lblCif.setForeground(new Color(0, 0, 0));
		lblCif.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCif.setBounds(35, 135, 56, 16);
		pnlContenido.add(lblCif);
		
		txtCif = new JTextField();
		txtCif.setBounds(35, 159, 267, 22);
		pnlContenido.add(txtCif);
		txtCif.setColumns(10);
		
		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(35, 186, 77, 16);
		pnlContenido.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(35, 207, 267, 22);
		pnlContenido.add(txtName);
		
		JLabel lblDireccion = new JLabel("DIRECCION:");
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(35, 233, 92, 16);
		pnlContenido.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(35, 254, 267, 22);
		pnlContenido.add(txtDireccion);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(35, 281, 92, 16);
		pnlContenido.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(35, 304, 267, 22);
		pnlContenido.add(txtTel);
		
		JLabel lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(134, 487, 109, 48);
		pnlContenido.add(lblCrear);
		
		JLabel lblCrearButton = new JLabel("");
		lblCrearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblCrearButton.setIcon(new ImageIcon(button3));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblCrearButton.setIcon(new ImageIcon(button2));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrearButton.setIcon(new ImageIcon(button2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCrearButton.setIcon(new ImageIcon(button1));
			}
		});
		lblCrearButton.setBounds(134, 487, 110, 48);
		pnlContenido.add(lblCrearButton);
		lblCrearButton.setIcon(new ImageIcon(button1));
		
		lblLogout = new JLabel("LOGOUT");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBackground(new Color(205, 92, 92));
		lblLogout.setBounds(301, 13, 92, 27);
		pnlContenido.add(lblLogout);
		
		JLabel lblLogoutButton = new JLabel("");
		lblLogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblLogoutButton.setIcon(new ImageIcon(button3));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblLogoutButton.setIcon(new ImageIcon(button2));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogoutButton.setIcon(new ImageIcon(button2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogoutButton.setIcon(new ImageIcon(button1));
			}
		});
		lblLogoutButton.setBounds(301, 13, 92, 27);
		pnlContenido.add(lblLogoutButton);
		lblLogoutButton.setIcon(new ImageIcon(button1));
		
		lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblBack.setIcon(new ImageIcon(back3));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblBack.setIcon(new ImageIcon(back2));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setIcon(new ImageIcon(back2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setIcon(new ImageIcon(back1));
			}
		});
		lblBack.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/back1.png")));
		lblBack.setBounds(35, 13, 24, 24);
		pnlContenido.add(lblBack);
		
		JLabel lblLocalidad = new JLabel("LOCALIDAD:");
		lblLocalidad.setForeground(Color.BLACK);
		lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocalidad.setBounds(35, 331, 92, 16);
		pnlContenido.add(lblLocalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(35, 353, 267, 22);
		pnlContenido.add(txtNacionalidad);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(35, 380, 63, 16);
		pnlContenido.add(lblEmail);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(35, 402, 267, 22);
		pnlContenido.add(txtMail);
		
		JLabel lblRepresentante = new JLabel("REPRESENTANTE:");
		lblRepresentante.setForeground(Color.BLACK);
		lblRepresentante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepresentante.setBounds(35, 430, 129, 16);
		pnlContenido.add(lblRepresentante);
		
		txtRepresentante = new JTextField();
		txtRepresentante.setColumns(10);
		txtRepresentante.setBounds(35, 452, 267, 22);
		pnlContenido.add(txtRepresentante);
		
		JLabel lblPortada = new JLabel("");
		lblPortada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPortada.setBounds(0, 0, 870, 617);
		panel.add(lblPortada);
		ImageIcon img2=new ImageIcon(ico2.getImage().getScaledInstance(lblPortada.getWidth(), lblPortada.getHeight(), Image.SCALE_SMOOTH));
		lblPortada.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/uni2.jpg")));
		lblPortada.setBackground(new Color(0, 0, 0));
		
	
	}

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}
}