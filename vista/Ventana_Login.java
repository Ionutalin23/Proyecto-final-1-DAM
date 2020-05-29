package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
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
import javax.swing.border.LineBorder;

public class Ventana_Login extends JFrame {

	private Image img_usr = new ImageIcon(Ventana_Login.class.getResource("/img/usr.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_passwd = new ImageIcon(Ventana_Login.class.getResource("/img/passwd.png")).getImage()
			.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_uem = new ImageIcon(Ventana_Login.class.getResource("/img/uemlogo.png")).getImage()
			.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	private Image img_buttonLogin = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin2 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton2.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin3 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton3.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_bg = new ImageIcon(Ventana_Login.class.getResource("/img/bg9.jpg")).getImage()
			.getScaledInstance(800, 590, Image.SCALE_SMOOTH);
	private Image img_bg2 = new ImageIcon(Ventana_Login.class.getResource("/img/bg9.jpg")).getImage()
			.getScaledInstance(459, 503, Image.SCALE_SMOOTH);
	private Image img_config = new ImageIcon(Ventana_Login.class.getResource("/img/config.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_config2 = new ImageIcon(Ventana_Login.class.getResource("/img/config.png")).getImage()
			.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image arrow = new ImageIcon(Ventana_Login.class.getResource("/img/arrow.png")).getImage()
			.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image arrow2 = new ImageIcon(Ventana_Login.class.getResource("/img/arrow2.png")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private JLabel lblLogin;
	private JLabel lblRegister;
	private JPasswordField txtPassword;
	private JTextField txtUsuario;

	private controlador miControlador;
	private modelo miModelo;
	private JLabel lblRespuesta;
	private JTextField txtNameR;
	private JTextField txtUserR;
	private JTextField txtRolR;
	private JTextField txtApellidoR;
	private JTextField txtMailR;
	private JLabel lblArrow;
	private JLabel lblUsrText;
	private JComponent panel;
	private JLabel lblIconUsr;
	private JLabel lblPasswdText;
	private JComponent panel_1;
	private JLabel lblIconPasswd;
	private JLabel lblLoginButton;
	private JLabel lblMember;
	private JLabel lblConfig;
	private JLabel lblBgColorRegister;
	private JLabel lblRegisterBtn;
	private JLabel lblRegisterTitle;
	private JPasswordField txtPassR;
	private JPanel pnlRegister;
	private JLabel lblRespuesta_1;
	private JLabel lblIconUEM_1;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Ventana_Login() {
		setTitle("Acceder");
		setBounds(100, 400, 800, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);

		lblRespuesta = new JLabel("");
		lblRespuesta.setBounds(290, 363, 215, 27);
		getContentPane().add(lblRespuesta);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 239, 215, 36);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblIconUsr = new JLabel("");
		lblIconUsr.setBounds(0, 0, 40, 36);
		panel.add(lblIconUsr);
		lblIconUsr.setIcon(new ImageIcon(img_usr));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(290, 321, 215, 36);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblIconPasswd = new JLabel("");
		lblIconPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPasswd.setBounds(0, 0, 43, 36);
		panel_1.add(lblIconPasswd);
		lblIconPasswd.setIcon(new ImageIcon(img_passwd));

		pnlRegister = new JPanel();

		pnlRegister.setBackground(new Color(165, 42, 42));
		pnlRegister.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlRegister.setBounds(800, 0, 459, 503);
		getContentPane().add(pnlRegister);
		pnlRegister.setLayout(null);
				
				lblRespuesta_1 = new JLabel("");
				lblRespuesta_1.setBounds(122, 371, 242, 27);
				pnlRegister.add(lblRespuesta_1);
		
				txtPassR = new JPasswordField();
				txtPassR.setBounds(274, 239, 159, 36);
				pnlRegister.add(txtPassR);

		JLabel lblUser = new JLabel("USUARIO:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUser.setBounds(274, 119, 130, 36);
		pnlRegister.add(lblUser);

		JLabel lblRegister;
		lblRegisterTitle = new JLabel("REGISTER");
		lblRegisterTitle.setForeground(Color.WHITE);
		lblRegisterTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblRegisterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterTitle.setBounds(106, 27, 203, 79);
		pnlRegister.add(lblRegisterTitle);

		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblName.setBounds(58, 119, 130, 36);
		pnlRegister.add(lblName);

		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblApellido.setBounds(58, 199, 130, 36);
		pnlRegister.add(lblApellido);

		JLabel lblRegPwd = new JLabel("CONTRASE\u00D1A:");
		lblRegPwd.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblRegPwd.setForeground(Color.WHITE);
		lblRegPwd.setBounds(274, 199, 130, 36);
		pnlRegister.add(lblRegPwd);

		JLabel lblRol = new JLabel("ROL:");
		lblRol.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblRol.setForeground(Color.WHITE);
		lblRol.setBounds(274, 287, 130, 36);
		pnlRegister.add(lblRol);

		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEmail.setBounds(58, 287, 130, 36);
		pnlRegister.add(lblEmail);

		lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setBounds(189, 409, 109, 36);
		pnlRegister.add(lblRegister);

		lblRegisterBtn = new JLabel("");
		lblRegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblRegisterBtn.setIcon(new ImageIcon(img_buttonLogin3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblRegisterBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegisterBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblRegisterBtn.setIcon(new ImageIcon(img_buttonLogin));
			}

			public void mouseClicked(MouseEvent e) {
				miModelo.ConexionBBDD();
				miControlador.insertarUsuario();

			}
		});
		lblRegisterBtn.setBounds(189, 408, 118, 48);
		pnlRegister.add(lblRegisterBtn);
		lblRegisterBtn.setIcon(new ImageIcon(img_buttonLogin));

		lblArrow = new JLabel("");
		lblArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Animacion.Animacion.mover_derecha(325, 800, 2, 2, pnlRegister);
				Animacion.Animacion.mover_derecha(109, 332, 2, 2, lblIconUEM_1);
				Animacion.Animacion.mover_derecha(77, 287, 2, 2, lblUsrText);
				Animacion.Animacion.mover_derecha(77, 290, 2, 2, panel);
				Animacion.Animacion.mover_derecha(77, 290, 2, 2, panel_1);
				Animacion.Animacion.mover_derecha(115, 328, 2, 2, txtUsuario);
				Animacion.Animacion.mover_derecha(117, 330, 2, 2, txtPassword);
				Animacion.Animacion.mover_derecha(77, 290, 2, 2, lblPasswdText);
				Animacion.Animacion.mover_derecha(135, 348, 2, 2, lblLogin);
				Animacion.Animacion.mover_derecha(135, 348, 2, 2, lblLoginButton);
				Animacion.Animacion.mover_derecha(251, 465, 2, 2, lblConfig);
				Animacion.Animacion.mover_derecha(53, 274, 2, 2, lblMember);
				Animacion.Animacion.mover_derecha(77, 290, 2, 2, lblRespuesta);
			}

			public void mouseEntered(MouseEvent e) {
				lblArrow.setIcon(new ImageIcon(arrow2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblArrow.setIcon(new ImageIcon(arrow));
			}
		});
		lblArrow.setIcon(new ImageIcon(Ventana_Login.class.getResource("/img/arrow.png")));
		lblArrow.setBounds(221, 454, 64, 36);
		pnlRegister.add(lblArrow);

		txtNameR = new JTextField();
		txtNameR.setBounds(58, 151, 159, 35);
		pnlRegister.add(txtNameR);
		txtNameR.setColumns(10);

		txtUserR = new JTextField();
		txtUserR.setColumns(10);
		txtUserR.setBounds(274, 151, 159, 35);
		pnlRegister.add(txtUserR);

		txtRolR = new JTextField();
		txtRolR.setColumns(10);
		txtRolR.setBounds(274, 336, 159, 35);
		pnlRegister.add(txtRolR);

		txtApellidoR = new JTextField();
		txtApellidoR.setColumns(10);
		txtApellidoR.setBounds(58, 239, 159, 35);
		pnlRegister.add(txtApellidoR);

		txtMailR = new JTextField();
		txtMailR.setColumns(10);
		txtMailR.setBounds(58, 336, 159, 35);
		pnlRegister.add(txtMailR);

		lblBgColorRegister = new JLabel("");
		lblBgColorRegister.setBounds(0, 0, 459, 503);
		pnlRegister.add(lblBgColorRegister);

		lblUsrText = new JLabel("USUARIO:");
		lblUsrText.setForeground(Color.WHITE);
		lblUsrText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsrText.setBounds(287, 206, 92, 20);
		getContentPane().add(lblUsrText);

		lblMember = new JLabel("Not yet a member?");
		lblMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMember.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				lblBgColorRegister.setIcon(new ImageIcon(img_bg2));
				Animacion.Animacion.mover_izquierda(800, 325, 2, 2, pnlRegister);
				Animacion.Animacion.mover_izquierda(332, 109, 2, 2, lblIconUEM_1);
				Animacion.Animacion.mover_izquierda(287, 77, 2, 2, lblUsrText);
				Animacion.Animacion.mover_izquierda(290, 77, 2, 2, panel);
				Animacion.Animacion.mover_izquierda(290, 77, 2, 2, panel_1);
				Animacion.Animacion.mover_izquierda(290, 115, 2, 2, txtUsuario);
				Animacion.Animacion.mover_izquierda(290, 117, 2, 2, txtPassword);
				Animacion.Animacion.mover_izquierda(290, 77, 2, 2, lblPasswdText);
				Animacion.Animacion.mover_izquierda(348, 135, 2, 2, lblLogin);
				Animacion.Animacion.mover_izquierda(348, 135, 2, 2, lblLoginButton);
				Animacion.Animacion.mover_izquierda(465, 251, 2, 2, lblConfig);
				Animacion.Animacion.mover_izquierda(274, 53, 2, 2, lblMember);
				Animacion.Animacion.mover_izquierda(290, 77, 2, 2, lblRespuesta);
			}
		});
		lblMember.setForeground(new Color(139, 0, 0));
		lblMember.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember.setBounds(274, 445, 259, 27);
		getContentPane().add(lblMember);

		lblPasswdText = new JLabel("CONTRASE\u00D1A:");
		lblPasswdText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPasswdText.setForeground(Color.WHITE);
		lblPasswdText.setBounds(290, 288, 118, 20);
		getContentPane().add(lblPasswdText);

//		LOGIN BUTTON ========================
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(348, 396, 109, 36);
		getContentPane().add(lblLogin);
		lblLoginButton = new JLabel("");
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
				
				miModelo.soundButton();
				miModelo.ConexionBBDD();
				miControlador.rol();
				miControlador.login();
			}
		});
		lblLoginButton.setBounds(348, 396, 118, 48);
		getContentPane().add(lblLoginButton);
		lblLoginButton.setIcon(new ImageIcon(img_buttonLogin));
		
//		UEM LOGO ========================
		JLabel lblIconUEM = new JLabel("");
		lblIconUEM.setBounds(332, 63, 154, 125);

		lblIconUEM_1 = new JLabel("");
		lblIconUEM_1.setBounds(332, 54, 154, 125);

		getContentPane().add(lblIconUEM_1);
		lblIconUEM_1.setIcon(new ImageIcon(img_uem));

		lblConfig = new JLabel("");
		lblConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miModelo.VerFichero();
				miControlador.loginConfig();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblConfig.setIcon(new ImageIcon(img_config2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblConfig.setIcon(new ImageIcon(img_config));
			}
		});
		lblConfig.setBounds(465, 396, 40, 36);
		getContentPane().add(lblConfig);
		lblConfig.setIcon(new ImageIcon(img_config));

		txtUsuario = new JTextField();
		txtUsuario.setBounds(328, 239, 177, 36);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(332, 321, 173, 36);
		getContentPane().add(txtPassword);
		
//		BACKGROUND ========================
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 784, 511);
		getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					miModelo.soundButton();
					miModelo.ConexionBBDD();
					miControlador.rol();
					miControlador.login();
				}
			}
		});

	}

// GETTER ========================
	public String getUsuario() {

		return txtUsuario.getText();
	}

	public String getPassword() {

		return String.valueOf(txtPassword.getPassword());
	}

//	ACTUALIZAR ========================
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
			miControlador.loginError();
		}
	}

	public String getTxtApellidoR() {
		return txtApellidoR.getText();
	}

	public String getTxtNameR() {
		return txtNameR.getText();
	}

	public String getTxtUserR() {
		return txtUserR.getText();
	}

	public String getTxtPassR() {
		return String.valueOf(txtPassR.getPassword());
	}

	public String getTxtRolR() {
		return txtRolR.getText();
	}

	public String getTxtMailR() {
		return txtMailR.getText();
	}

	public void actualizar2() {
		String resultado = miModelo.getResultadoUsu();
		if (resultado.equals("EXISTENTE")) {
			lblRespuesta_1.setText("El Usuario ya existe");
		} else if (resultado.equals("EXITO")) {
			lblRespuesta_1.setText("Usuario añadido con éxito");
			clearFields();
		} else if (resultado.equals("VACIO")) {
			lblRespuesta_1.setText("Por favor, rellene todos los campos");
		} else {
			lblRespuesta_1.setText("Error, por favor compruebe todos los datos");
		}
	}

//LIMPIAR CAMPOS ========================
	public void clearFields() {
		for (Object obj : pnlRegister.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
	}
}
