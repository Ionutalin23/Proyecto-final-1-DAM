package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import controlador.controlador;
import modelo.modelo;
import javax.swing.JRadioButton;

public class Ventana_Login_Register extends JFrame {
	private controlador miControlador;
	private modelo miModelo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JRadioButton rdbtnDirector;
	private JRadioButton rdbtnTutor;
	private JPanel pnlCrear;
	private JLabel lblBack;
	private JLabel lblResul;
	private JPanel pnlContenido;
	private JTextField txtRol;

	public Ventana_Login_Register() {

		ImageIcon ico = new ImageIcon(getClass().getResource("/images/logo.png"));
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/images/uni2.jpg"));
		Image button1 = new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image button2 = new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image button3 = new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image back1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Image back2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Image back3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);

//		TITULO DEL PANE ========================
		setTitle("Crear nuevo usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
		
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA ========================
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 870, 617);
		getContentPane().add(panel);
		panel.setLayout(null);

//		UEM LOGO - BOTTOM LEFT ========================
		JLabel lblLogo = new JLabel("");
		lblLogo.setForeground(new Color(0, 0, 0));
		lblLogo.setBounds(25, 555, 162, 49);
		panel.add(lblLogo);
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
		lblLogo.setIcon(img);
		lblLogo.setBackground(new Color(0, 0, 0));

//		FORM PANEL ========================
		pnlContenido = new JPanel();
		pnlContenido.setBounds(230, 32, 405, 561);
		panel.add(pnlContenido);
		pnlContenido.setBackground(new Color(226, 106, 106, 240));
		pnlContenido.setLayout(null);

//		FORM PANEL TITLE ========================
		JLabel lblTitle = new JLabel("Crear nuevo usuario");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(80, 53, 296, 29);
		pnlContenido.add(lblTitle);

//		NOMBRE LBL ========================
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(65, 95, 77, 16);
		pnlContenido.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(65, 124, 267, 22);
		pnlContenido.add(txtNombre);
		txtNombre.setColumns(10);

//		APPELIDOS LBL ========================
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(65, 159, 92, 16);
		pnlContenido.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(65, 188, 267, 22);
		pnlContenido.add(txtApellidos);

//		EMAIL LBL ========================
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(65, 223, 92, 16);
		pnlContenido.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(65, 252, 267, 22);
		pnlContenido.add(txtEmail);

//		NOMBRE DE USUARIO LBL ========================
		JLabel lblUsername = new JLabel("NOMBRE DE USUARIO:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(65, 287, 177, 16);
		pnlContenido.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(65, 316, 267, 22);
		pnlContenido.add(txtUsername);		
		
//		CONTRASENA LBL ========================
		JLabel lblPassword = new JLabel("CONTRASE\u00D1A:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(65, 351, 177, 16);
		pnlContenido.add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(65, 378, 267, 22);
		pnlContenido.add(txtPassword);
		
//		ROL LBL ========================
		JLabel lblRol = new JLabel("ROL(Tutor/Director):");
		lblRol.setForeground(Color.BLACK);
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRol.setBounds(65, 415, 148, 16);
		pnlContenido.add(lblRol);
		
		txtRol = new JTextField();
		txtRol.setColumns(10);
		txtRol.setBounds(65, 442, 267, 22);
		pnlContenido.add(txtRol);

//		BACK BUTTON ========================
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

			public void mouseClicked(MouseEvent e) {
				miControlador.back9();
			}
		});
		lblBack.setIcon(new ImageIcon(Ventana_Login_Register.class.getResource("/images/back1.png")));
		lblBack.setBounds(35, 13, 24, 24);
		pnlContenido.add(lblBack);
		
//		CREAR BUTTON ========================
		JLabel lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(150, 500, 109, 48);
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

			public void mouseClicked(MouseEvent e) {
				miControlador.insertarUsuario();
			}
		});
		lblCrearButton.setBounds(150, 500, 110, 48);
		pnlContenido.add(lblCrearButton);
		lblCrearButton.setIcon(new ImageIcon(button1));

//		VALID USER RESULT ========================
		lblResul = new JLabel("");
		lblResul.setForeground(new Color(128, 0, 0));
		lblResul.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResul.setHorizontalAlignment(SwingConstants.CENTER);
		lblResul.setBounds(65, 479, 267, 16);
		pnlContenido.add(lblResul);
		
//		BACKGROUND ========================		
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 870, 617);
		panel.add(lblBgColor);
		lblBgColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblBgColor.setIcon(new ImageIcon(Vista_Info_Tutor.class.getResource("/images/uni.jpg")));
	}

//	MVC ========================
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

//	TXT GETTERS ========================
	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public String getTxtApellidos() {
		return txtApellidos.getText();
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getTxtPassword() {
		return txtPassword.getText();
	}
	
	public String getTxtRol() {
		return txtRol.getText();
	}
	
//	ACTUALIZAR ========================
	public void actualizar() {
		String resultado = miModelo.getResultadoAlum();
		if (resultado.equals("EXISTENTE")) {
			JOptionPane.showMessageDialog(this, "El usuario ya existe");
			//lblResul.setText("EL USUARIO YA EXISTE");
		} else if (resultado.equals("EXITO")) {
			//lblResul.setText("USUARIO AÑADIDO CON EXITO!!");
			JOptionPane.showMessageDialog(this, "Usuario añadido con éxito");
			clearFields();
		}else if(resultado.equals("VACIO")){
			JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos");
		}else {
			JOptionPane.showMessageDialog(this, "Error, por favor compruebe todos los datos");
		lblResul.setText("ERROR");
		}
		}

//	LIMPIAR CAMPOS ========================
	public void clearFields() {
		for (Object obj : pnlContenido.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
	}
}
