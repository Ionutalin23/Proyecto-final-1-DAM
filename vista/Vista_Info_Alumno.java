package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import controlador.controlador;
import modelo.modelo;

public class Vista_Info_Alumno extends JFrame {
//	GUI Content ========================
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
	private JTextField txtExpediente;
	private JLabel lblResul;
	private JPanel pnlContenido;
	private JLabel lblModButton;
	private boolean modify=false;
	private int temp = 5000;
	
// 	Setting Images ======================== (Check all images are linked to correct folder to avoid null pointer exception)
	ImageIcon ico = new ImageIcon(getClass().getResource("/images/logo.png"));
	ImageIcon ico2 = new ImageIcon(getClass().getResource("/images/uni2.jpg"));
	Image button1 = new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
	Image button2 = new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
	Image button3 = new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
	Image button4 = new ImageIcon(getClass().getResource("/img/loginbutton4.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
	Image back1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);
	Image back2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);
	Image back3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);
	private JLabel lblCrear;
	private JLabel lblCrearButton;
	private JLabel lblMod;
	private JLabel lblRespuesta;
	private JPanel pnlUser;

	public Vista_Info_Alumno() {


//		Frame ========================
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 870, 617);
		getContentPane().add(panel);
		panel.setLayout(null);

//		LOGGED USER ========================
		pnlUser = new JPanel();
		pnlUser.setBounds(25, 13, 196, 27);
		panel.add(pnlUser);
		pnlUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlUser.setBackground(new Color(224, 24, 24, 220));
				lblUser.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlUser.setBackground(new Color(245, 245, 245, 220));
				lblUser.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miModelo.soundButton();
				miControlador.verPerfil5();
			}
		});
		pnlUser.setForeground(new Color(255, 0, 0));
		pnlUser.setBackground(new Color(245, 245, 245));
		pnlUser.setLayout(null);

		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setBounds(0, 0, 196, 27);
		pnlUser.add(lblUser);
		lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUser.setBackground(new Color(211, 211, 211));
		lblUser.setForeground(new Color(139, 0, 0));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);

//		UEM LOGO ========================
		JLabel lblLogo = new JLabel("");
		lblLogo.setForeground(new Color(0, 0, 0));
		lblLogo.setBounds(25, 555, 162, 49);
		panel.add(lblLogo);
		ImageIcon img = new ImageIcon(
				ico.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
		lblLogo.setIcon(img);
		lblLogo.setBackground(new Color(0, 0, 0));

//		FORM CONTENT ========================
		pnlContenido = new JPanel();
		pnlContenido.setBounds(230, 32, 405, 561);
		panel.add(pnlContenido);
		pnlContenido.setBackground(new Color(226, 106, 106, 240));
		pnlContenido.setLayout(null);

		//FORM TITLE ========================
		JLabel lblTitle = new JLabel("Informaci\u00F3n del alumno:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(32, 53, 296, 29);
		pnlContenido.add(lblTitle);
		
		//DNI TEXT FIELD ========================
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(0, 0, 0));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(32, 95, 56, 16);
		pnlContenido.add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(32, 124, 267, 22);
		pnlContenido.add(txtDni);
		txtDni.setColumns(10);
		
		//NAME TEXT FIELD ========================
		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(32, 159, 77, 16);
		pnlContenido.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(32, 188, 267, 22);
		pnlContenido.add(txtName);

		//LAST NAME TEXT FIELD ========================
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(32, 223, 92, 16);
		pnlContenido.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(32, 252, 267, 22);
		pnlContenido.add(txtApellidos);
		
		//EXPEDIENTE TEXT FIELD ========================
		JLabel lblExpediente = new JLabel("NUMERO EXPEDIENTE:");
		lblExpediente.setForeground(Color.BLACK);
		lblExpediente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpediente.setBounds(32, 287, 177, 16);
		pnlContenido.add(lblExpediente);

		txtExpediente = new JTextField();
		txtExpediente.setColumns(10);
		txtExpediente.setBounds(32, 316, 267, 22);
		pnlContenido.add(txtExpediente);

		//DOB TEXT FIELD ========================
		JLabel lblNacim = new JLabel("FECHA DE NACIMIENTO:");
		lblNacim.setForeground(Color.BLACK);
		lblNacim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacim.setBounds(32, 351, 177, 16);
		pnlContenido.add(lblNacim);

		txtNacim = new JTextField();
		txtNacim.setColumns(10);
		txtNacim.setBounds(32, 380, 267, 22);
		pnlContenido.add(txtNacim);
		
		//NATIONALITY TEXT FIELD ========================
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD:");
		lblNacionalidad.setForeground(Color.BLACK);
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacionalidad.setBounds(32, 415, 131, 16);
		pnlContenido.add(lblNacionalidad);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(32, 444, 267, 22);
		pnlContenido.add(txtNacionalidad);
		
		//FORM RESULT TEXT ========================
		lblResul = new JLabel("");
		lblResul.setForeground(new Color(128, 0, 0));
		lblResul.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResul.setHorizontalAlignment(SwingConstants.CENTER);
		lblResul.setBounds(65, 95, 267, 16);
		pnlContenido.add(lblResul);

//		LOGOUT BUTTON ========================
		lblLogout = new JLabel("LOGOUT");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBackground(new Color(205, 92, 92));
		lblLogout.setBounds(301, 13, 92, 27);
		pnlContenido.add(lblLogout);
		
		lblRespuesta = new JLabel("New label");
		lblRespuesta.setBackground(Color.WHITE);
		lblRespuesta.setForeground(Color.WHITE);
		lblRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRespuesta.setBounds(35, 532, 308, 29);
		pnlContenido.add(lblRespuesta);
		lblRespuesta.setText("");

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

			public void mouseClicked(MouseEvent e) {
				clearFields();
				miControlador.logout6();
			}
		});
		lblLogoutButton.setBounds(301, 13, 92, 27);
		pnlContenido.add(lblLogoutButton);
		lblLogoutButton.setIcon(new ImageIcon(button1));

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
				clearFields();
				miControlador.back5();
			}
		});
		lblBack.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/back1.png")));
		lblBack.setBounds(35, 13, 24, 24);
		pnlContenido.add(lblBack);
		
		lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(133, 479, 109, 48);
		pnlContenido.add(lblCrear);

		lblCrearButton = new JLabel("");
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
				miControlador.insertarAlumno();
			}
		});
		lblCrearButton.setBounds(133, 479, 110, 48);
		pnlContenido.add(lblCrearButton);
		lblCrearButton.setIcon(new ImageIcon(button1));
		
// 		Boton Modificar
		lblMod = new JLabel("MODIFICAR");
		lblMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMod.setForeground(Color.WHITE);
		lblMod.setBackground(new Color(205, 92, 92));
		lblMod.setBounds(133, 479, 109, 48);
		pnlContenido.add(lblMod);
		
		lblModButton = new JLabel("");
		lblMod.setVisible(false);
		lblModButton.setVisible(false);
		lblModButton.setBounds(132, 479, 110, 48);
		pnlContenido.add(lblModButton);
		lblModButton.setIcon(new ImageIcon(button1));
		lblModButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblModButton.setIcon(new ImageIcon(button3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblModButton.setIcon(new ImageIcon(button2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblModButton.setIcon(new ImageIcon(button2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblModButton.setIcon(new ImageIcon(button1));
			}

			public void mouseClicked(MouseEvent e) {
				miModelo.modificarAlumno(txtDni.getText(),txtName.getText(),txtApellidos.getText(),Integer.parseInt(txtExpediente.getText()),txtNacim.getText(),txtNacionalidad.getText() );
			}
		});


//		BACKGROUND IMG ========================
		JLabel lblPortada = new JLabel("");
		lblPortada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPortada.setBounds(0, 0, 870, 617);
		panel.add(lblPortada);
		ImageIcon img2 = new ImageIcon(
		ico2.getImage().getScaledInstance(lblPortada.getWidth(), lblPortada.getHeight(), Image.SCALE_SMOOTH));
		lblPortada.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/resi.jpg")));
		lblPortada.setBackground(new Color(0, 0, 0));
		
	}

// 	MVC ========================
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

//	UPDATE LOGGED USER ========================
	public void actualizarLogged() {
		lblUser.setText("Logged as: " + miModelo.getUSR());
	}

	
//	GETTERS & SETTERS ========================
	public String getTxtDni() {
		return txtDni.getText();
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtApellidos() {
		return txtApellidos.getText();
	}

	public String getTxtNacim() {
		return txtNacim.getText();
	}

	public String getTxtNacionalidad() {
		return txtNacionalidad.getText();
	}

	public String getTxtExpediente() {
		return txtExpediente.getText();
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public void setTxtNacim(JTextField txtNacim) {
		this.txtNacim = txtNacim;
	}

	public void setTxtNacionalidad(JTextField txtNacionalidad) {
		this.txtNacionalidad = txtNacionalidad;
	}

	public void setTxtExpediente(JTextField txtExpediente) {
		this.txtExpediente = txtExpediente;
	}

	// 	UPDATE ========================
	public void actualizarInsert() {
		String resultado = miModelo.getResultadoAlum();
		if(resultado.equals("EXITO")) {
			clearFields();
			lblRespuesta.setText("Alumno añadir con ÉXITO");
		}else {
			lblRespuesta.setText("Error,No se ha podido añadir el alumno");
		}
		//lblRespuesta.setVisible(true);
		ActionListener ocultarLabel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//lblRespuesta.setVisible(false);
				lblRespuesta.setText("");
			}
		};
		new Timer(temp, ocultarLabel).start();
	}
	public void actualizarUpdate() {
		String resultado=miModelo.getResultadoUsuarioUpdate();
		if(resultado.equals("EXITO")) {
			clearFields();
			lblRespuesta.setText("Alumno modificado con ÉXITO");
		}else {
			lblRespuesta.setText("Error,No se ha podido modifcar el Alumno");
		}
		//lblRespuesta.setVisible(true);
		ActionListener ocultarLabel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//lblRespuesta.setVisible(false);
				lblRespuesta.setText("");
			}
		};
		new Timer(temp, ocultarLabel).start();
	}

//	CLEAR FIELDS ========================
	public void clearFields() {
		for (Object obj : pnlContenido.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
	}

	public void setTxtDni(String txtDni) {
		this.txtDni.setText(txtDni);
	}

	public void setTxtName(String txtName) {
		this.txtName.setText(txtName);
	}

	public void setTxtApellidos(String txtApellidos) {
		this.txtApellidos.setText(txtApellidos);
	}

	public void setTxtNacim(String txtNacim) {
		this.txtNacim.setText(txtNacim);
	}

	public void setTxtNacionalidad(String txtNacionalidad) {
		this.txtNacionalidad.setText(txtNacionalidad);
	}

	public void setTxtExpediente(String txtExpediente) {
		this.txtExpediente.setText(txtExpediente);
	}
	public void mostrarBoton() {
		if (modify) {
			lblMod.setVisible(true);
			lblModButton.setVisible(true);
			lblCrear.setVisible(false);
			lblCrearButton.setVisible(false);
		}else {
			lblMod.setVisible(false);
			lblModButton.setVisible(false);
			lblCrear.setVisible(true);
			lblCrearButton.setVisible(true);
		}
	}

	public void setModify(boolean modify) {
		this.modify = modify;
	}
}
