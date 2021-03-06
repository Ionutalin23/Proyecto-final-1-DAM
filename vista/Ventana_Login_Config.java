package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;

public class Ventana_Login_Config extends JFrame {

//	GUI Content ========================
	private JLabel lblModificar;
	private JLabel lblSalir;
	private JPasswordField txtPasswordBD;
	private JTextField txtUsuarioBD;
	private JLabel lblRespuesta;
	private JTextField txtUrlBD;

// 	Setting Images ======================== (Check all images are linked to correct folder to avoid null pointer exception)
	private Image img_usr = new ImageIcon(Ventana_Login.class.getResource("/img/usr.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_passwd = new ImageIcon(Ventana_Login.class.getResource("/img/passwd.png")).getImage()
			.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_database = new ImageIcon(Ventana_Login.class.getResource("/images/DatabaseIcon.jpg")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_uem = new ImageIcon(Ventana_Login.class.getResource("/img/uemlogo.png")).getImage()
			.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
	private Image img_buttonLogin = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin2 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton2.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin3 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton3.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_bg = new ImageIcon(Ventana_Login.class.getResource("/img/bg9.jpg")).getImage()
			.getScaledInstance(800, 590, Image.SCALE_SMOOTH);

// 	MVC ========================
	private controlador miControlador;
	private modelo miModelo;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

//	Frame ========================
	public Ventana_Login_Config() {

		setTitle("Acceder");
		setBounds(100, 400, 800, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);

//	Respuesta de datos introducidos ========================
		lblRespuesta = new JLabel("");
		lblRespuesta.setBounds(290, 421, 215, 20);
		lblRespuesta.setVisible(false);
		getContentPane().add(lblRespuesta);

//	Panel de Usuario ========================
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 281, 215, 36);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIconUsr = new JLabel("");
		lblIconUsr.setBounds(0, 0, 40, 36);
		panel.add(lblIconUsr);
		lblIconUsr.setIcon(new ImageIcon(img_usr));

		txtUsuarioBD = new JTextField();
		txtUsuarioBD.setColumns(10);
		txtUsuarioBD.setBounds(42, 0, 177, 36);
		panel.add(txtUsuarioBD);

		JLabel lblUsrText = new JLabel("USUARIO:");
		lblUsrText.setForeground(Color.WHITE);
		lblUsrText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsrText.setBounds(290, 255, 92, 20);
		getContentPane().add(lblUsrText);

//	Panel de Password ========================
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(290, 352, 215, 36);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIconPasswd = new JLabel("");
		lblIconPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPasswd.setBounds(0, 0, 43, 36);
		panel_1.add(lblIconPasswd);
		lblIconPasswd.setIcon(new ImageIcon(img_passwd));

		txtPasswordBD = new JPasswordField();
		txtPasswordBD.setBounds(42, 0, 173, 36);
		panel_1.add(txtPasswordBD);

		JLabel lblPasswdText = new JLabel("CONTRASE\u00D1A:");
		lblPasswdText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPasswdText.setForeground(Color.WHITE);
		lblPasswdText.setBounds(290, 326, 118, 20);
		getContentPane().add(lblPasswdText);

//	Campo de introducion de URL de BD ========================
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(290, 208, 215, 36);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblIconBD = new JLabel("");
		lblIconBD.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconBD.setBounds(0, 0, 43, 36);
		panel_2.add(lblIconBD);
		lblIconBD.setIcon(new ImageIcon(img_database));

		txtUrlBD = new JTextField();
		txtUrlBD.setBounds(42, 0, 177, 36);
		panel_2.add(txtUrlBD);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUrl.setForeground(Color.WHITE);
		lblUrl.setBounds(290, 177, 92, 20);
		getContentPane().add(lblUrl);

//	BTN Modificar ========================
		lblModificar = new JLabel("MODIFICAR");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblModificar.setForeground(Color.WHITE);
		lblModificar.setBounds(349, 443, 109, 36);
		getContentPane().add(lblModificar);

		JLabel lblModificarBtn = new JLabel("");
		lblModificarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblModificarBtn.setIcon(new ImageIcon(img_buttonLogin3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblModificarBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblModificarBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblModificarBtn.setIcon(new ImageIcon(img_buttonLogin));
			}
			public void mouseClicked(MouseEvent e) {

//	Crear metodo para cambiar variables de loging de la base de datos
				miModelo.modificarfichero();
				lblRespuesta.setText("Fichero modificado con �xito");
				lblRespuesta.setVisible(true);
			}
		});
		lblModificarBtn.setBounds(349, 443, 118, 47);
		getContentPane().add(lblModificarBtn);
		lblModificarBtn.setIcon(new ImageIcon(img_buttonLogin));

//	BTN Salir ========================

		lblSalir = new JLabel("SALIR");
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBounds(666, 464, 109, 36);
		getContentPane().add(lblSalir);

		JLabel lblSalirBtn = new JLabel("");
		lblSalirBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblSalirBtn.setIcon(new ImageIcon(img_buttonLogin3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblSalirBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalirBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSalirBtn.setIcon(new ImageIcon(img_buttonLogin));
			}

			public void mouseClicked(MouseEvent e) {
//	Crear metodo en controlador para volver para atras
				miControlador.loginConfigSalir();
			}
		});
		lblSalirBtn.setBounds(666, 464, 118, 47);
		getContentPane().add(lblSalirBtn);
		lblSalirBtn.setIcon(new ImageIcon(img_buttonLogin));

// 	Icono de UEM ========================	

		JLabel lblIconUEM = new JLabel("");
		lblIconUEM.setBounds(326, 4, 154, 125);
		getContentPane().add(lblIconUEM);
		lblIconUEM.setIcon(new ImageIcon(img_uem));

// Titulo de ventana ========================	

		JLabel lblTitulo = new JLabel("Configuracion de Base de Datos");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setBounds(272, 140, 256, 20);
		getContentPane().add(lblTitulo);


//	Background Image ========================
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 784, 511);
		getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));

	}
	public String getUsuarioBD() {
		return txtUsuarioBD.getText();
	}
	public String getPassBD() {

		return String.valueOf(txtPasswordBD.getPassword());
	}
	public String getUrlBD() {

		return txtUrlBD.getText();
	}

	public void setTxtUsuarioBD(String user) {
		txtUsuarioBD.setText(user);
	}
	
	public void setTxtUrlBD(String URL) {
		txtUrlBD.setText(URL);
	}

	public void setTxtPasswordBD(String password) {
		txtPasswordBD.setText(password);
	}
}
