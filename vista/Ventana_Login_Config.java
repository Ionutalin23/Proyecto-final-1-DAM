package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controlador.controlador;
import modelo.modelo;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Ventana_Login_Config{

	public JFrame frame;
	private Image img_usr = new ImageIcon(Ventana_Login.class.getResource("/img/usr.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_passwd = new ImageIcon(Ventana_Login.class.getResource("/img/passwd.png")).getImage()
			.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_uem = new ImageIcon(Ventana_Login.class.getResource("/img/uem2.png")).getImage()
			.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
	private Image img_buttonLogin = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin2 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton2.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin3 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton3.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_bg = new ImageIcon(Ventana_Login.class.getResource("/img/bg9.jpg")).getImage()
			.getScaledInstance(800, 590, Image.SCALE_SMOOTH);
	private JLabel lblLogin;
	private JPasswordField txtPasswordBD;
	private JTextField txtUsuarioBD;

	private controlador miControlador;
	private modelo miModelo;
	private JLabel lblRespuesta;
	private JTextField txtUrlBD;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Ventana_Login_Config() {
		frame = new JFrame();
		frame.setTitle("Acceder");
		frame.setBounds(100, 400, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblRespuesta = new JLabel("");
		lblRespuesta.setBounds(290, 396, 215, 26);
		frame.getContentPane().add(lblRespuesta);

		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 281, 215, 36);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIconUsr = new JLabel("");
		lblIconUsr.setBounds(0, 0, 40, 36);
		panel.add(lblIconUsr);
		lblIconUsr.setIcon(new ImageIcon(img_usr));

		txtUsuarioBD = new JTextField();
		txtUsuarioBD.setColumns(10);
		txtUsuarioBD.setBounds(38, 0, 177, 36);
		panel.add(txtUsuarioBD);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(290, 352, 215, 36);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIconPasswd = new JLabel("");
		lblIconPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPasswd.setBounds(0, 0, 43, 36);
		panel_1.add(lblIconPasswd);
		lblIconPasswd.setIcon(new ImageIcon(img_passwd));

		txtPasswordBD = new JPasswordField();
		txtPasswordBD.setBounds(42, 0, 173, 36);
		panel_1.add(txtPasswordBD);

		JLabel lblUsrText = new JLabel("USUARIO:");
		lblUsrText.setForeground(Color.WHITE);
		lblUsrText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsrText.setBounds(290, 255, 92, 20);
		frame.getContentPane().add(lblUsrText);

		JLabel lblPasswdText = new JLabel("CONTRASE\u00D1A:");
		lblPasswdText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPasswdText.setForeground(Color.WHITE);
		lblPasswdText.setBounds(290, 326, 118, 20);
		frame.getContentPane().add(lblPasswdText);

		lblLogin = new JLabel("MODIFICAR");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(348, 427, 109, 36);
		frame.getContentPane().add(lblLogin);

		JLabel lblLoginButton = new JLabel("");
		lblLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin));
			}

			public void mouseClicked(MouseEvent e) {
				miControlador.rol();
				miControlador.login();
				
			}
		});
		lblLoginButton.setBounds(348, 427, 118, 47);
		frame.getContentPane().add(lblLoginButton);
		lblLoginButton.setIcon(new ImageIcon(img_buttonLogin));

		JLabel lblIconUEM = new JLabel("");
		lblIconUEM.setBounds(332, 54, 154, 125);
		frame.getContentPane().add(lblIconUEM);
		lblIconUEM.setIcon(new ImageIcon(img_uem));
		
		txtUrlBD = new JTextField();
		txtUrlBD.setColumns(10);
		txtUrlBD.setBounds(328, 208, 177, 36);
		frame.getContentPane().add(txtUrlBD);
				
				JLabel lblUrl = new JLabel("URL:");
				lblUrl.setForeground(Color.WHITE);
				lblUrl.setFont(new Font("Dialog", Font.BOLD, 14));
				lblUrl.setBounds(290, 177, 92, 20);
				frame.getContentPane().add(lblUrl);
						
						JLabel lblSalir = new JLabel("SALIR");
						lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
						lblSalir.setForeground(Color.WHITE);
						lblSalir.setFont(new Font("Dialog", Font.BOLD, 15));
						lblSalir.setBounds(666, 464, 109, 36);
						frame.getContentPane().add(lblSalir);
								
								JLabel lblLoginButton_1 = new JLabel("");
								lblLoginButton_1.setBounds(666, 464, 118, 47);
								frame.getContentPane().add(lblLoginButton_1);
						
								JLabel lblBgColor = new JLabel("");
								lblBgColor.setBounds(0, 0, 784, 511);
								frame.getContentPane().add(lblBgColor);
								lblBgColor.setIcon(new ImageIcon(img_bg));
	}

	public String getUsuario() {

		return txtUsuarioBD.getText();
	}

	public String getPassword() {

		return String.valueOf(txtPasswordBD.getPassword());
	}

	public void actualizar() {
		String resultado = miModelo.getResultado();
		if (resultado.equals("Correcto")) {
			lblRespuesta.setText("");
			if (miModelo.getRol().contentEquals("Director")) {
				miControlador.accesoDir();
			} else {
				miControlador.accesoTut();
			}
			
		} else if (resultado.equals("Incorrecto")) {
			lblRespuesta.setText("Usuario o contraseña incorrectos!!");
		} else {
			System.exit(0);
		}
	}
}
