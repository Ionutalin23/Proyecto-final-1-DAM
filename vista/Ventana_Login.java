package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.applet.AudioClip;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana_Login {

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
	private Image img_config = new ImageIcon(Ventana_Login.class.getResource("/img/config.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private JLabel lblLogin;
	private JPasswordField txtPassword;
	private JTextField txtUsuario;

	private controlador miControlador;
	private modelo miModelo;
	private JLabel lblRespuesta;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Ventana_Login() {
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

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(38, 0, 177, 36);
		panel.add(txtUsuario);

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

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					miModelo.ConexionBBDD();
					miControlador.rol();
					miControlador.login();
		        }
			}
		});
		txtPassword.setBounds(42, 0, 173, 36);
		panel_1.add(txtPassword);

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

		lblLogin = new JLabel("LOGIN");
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
				sonido();
				miModelo.ConexionBBDD();
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
		
		JLabel lblConfig = new JLabel("");
		lblConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miModelo.VerFichero();
				miControlador.loginConfig();
			}
		});
		lblConfig.setBounds(726, 450, 44, 53);
		frame.getContentPane().add(lblConfig);
		lblConfig.setIcon(new ImageIcon(img_config));
		
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));
		
		
	}

	public String getUsuario() {

		return txtUsuario.getText();
	}

	public String getPassword() {

		return String.valueOf(txtPassword.getPassword());
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
	public void sonido() {
		AudioClip sonido;
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/sonido2.wav"));
		sonido.play();
	}
}
