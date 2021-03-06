package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import controlador.controlador;
import modelo.modelo;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Vista_Info_Tutor extends JFrame {
	private controlador miControlador;
	private modelo miModelo;
	private JTextField txtDni;
	private JTextField txtName;
	private JTextField txtApellidos;
	private JTextField txtCodCentro;
	private JPanel pnlCrear;
	private JLabel lblLogout;
	private JLabel lblBack;
	private JLabel lblUser;
	private boolean modify = false;
	private int temp = 5000;
	private JLabel lblRespuesta;
	private JLabel lblModify;
	private JLabel lblCrearButton;
	private JLabel lblCrear;
	private JLabel lblModButton;
	private JPanel pnlContenido;
	private JPanel pnlUser;

	public Vista_Info_Tutor() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);

		ImageIcon ico = new ImageIcon(getClass().getResource("/images/logo.png"));
		Image button1 = new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110,
				48, Image.SCALE_SMOOTH);
		Image button2 = new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110,
				48, Image.SCALE_SMOOTH);
		Image button3 = new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110,
				48, Image.SCALE_SMOOTH);
		Image back1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24,
				Image.SCALE_SMOOTH);
		Image back2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24,
				Image.SCALE_SMOOTH);
		Image back3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24,
				Image.SCALE_SMOOTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 870, 617);
		getContentPane().add(panel);
		panel.setLayout(null);

		// LOGGED AS LBL ========================
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
				miControlador.verPerfil2();
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

		pnlContenido = new JPanel();
		pnlContenido.setBounds(230, 32, 405, 561);
		panel.add(pnlContenido);
		pnlContenido.setBackground(new Color(226, 106, 106, 240));
		pnlContenido.setLayout(null);

		// FORM TITLE ========================
		JLabel lblTitle = new JLabel("Informaci\u00F3n del tutor:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(35, 82, 267, 29);
		pnlContenido.add(lblTitle);

		// DNI TEXT FIELD ========================
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(0, 0, 0));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(35, 147, 56, 16);
		pnlContenido.add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(35, 176, 267, 22);
		pnlContenido.add(txtDni);
		txtDni.setColumns(10);

		// NOMBRE TEXT FIELD ========================
		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(35, 211, 77, 16);
		pnlContenido.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(35, 240, 267, 22);
		pnlContenido.add(txtName);

		// APELLIDOS TEXT FIELD ========================
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(35, 275, 92, 16);
		pnlContenido.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(35, 304, 267, 22);
		pnlContenido.add(txtApellidos);

		// CODIGO DE CENTRO TEXT FIELD ========================
		JLabel lblCodCentro = new JLabel("C\u00D3DIGO DE CENTRO:");
		lblCodCentro.setForeground(Color.BLACK);
		lblCodCentro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodCentro.setBounds(35, 339, 157, 16);
		pnlContenido.add(lblCodCentro);

		txtCodCentro = new JTextField();
		txtCodCentro.setColumns(10);
		txtCodCentro.setBounds(35, 368, 267, 22);
		pnlContenido.add(txtCodCentro);

//		CREAR BUTTON ========================
		lblCrear = new JLabel("CREAR");
		lblCrear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(142, 445, 109, 48);
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
				miControlador.insertarTutor();
			}
		});
		lblCrearButton.setBounds(141, 445, 110, 48);
		pnlContenido.add(lblCrearButton);
		lblCrearButton.setIcon(new ImageIcon(button1));

//		MODIFICAR BUTTON =====================
		lblModify = new JLabel("MODIFICAR");
		lblModify.setHorizontalAlignment(SwingConstants.CENTER);
		lblModify.setForeground(Color.WHITE);
		lblModify.setBackground(new Color(205, 92, 92));
		lblModify.setBounds(141, 445, 109, 48);
		pnlContenido.add(lblModify);

		lblModButton = new JLabel("");
		lblModify.setVisible(false);
		lblModButton.setVisible(false);
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
				miModelo.modificarTutor(txtDni.getText(), txtName.getText(), txtApellidos.getText(),
						Integer.parseInt(txtCodCentro.getText()));
			}
		});
		lblModButton.setBounds(141, 445, 109, 48);
		pnlContenido.add(lblModButton);
		lblModButton.setIcon(new ImageIcon(button1));

//		LOGOUT BUTTON ========================
		lblLogout = new JLabel("LOGOUT");
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
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

			public void mouseClicked(MouseEvent e) {
				clearFields();
				miControlador.logout9();
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
				miControlador.back8();
			}
		});
		lblBack.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/back1.png")));
		lblBack.setBounds(35, 13, 24, 24);
		pnlContenido.add(lblBack);

		lblRespuesta = new JLabel("New label");
		lblRespuesta.setBackground(Color.WHITE);
		lblRespuesta.setForeground(Color.WHITE);
		lblRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuesta.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblRespuesta.setBounds(55, 509, 287, 29);
		pnlContenido.add(lblRespuesta);
		lblRespuesta.setText("");

//		BACKGROUND IMG ========================
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Vista_Info_Tutor.class.getResource("/images/uni.jpg")));
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setBounds(0, 0, 870, 617);
		panel.add(lblFondo);

	}

//  SETTERS=========================
	public void setTxtDni(String txtDni) {
		this.txtDni.setText(txtDni);
	}

	public void setTxtName(String txtName) {
		this.txtName.setText(txtName);
	}

	public void setTxtApellidos(String txtApellidos) {
		this.txtApellidos.setText(txtApellidos);
	}

	public void setTxtCodCentro(String txtCodCentro) {
		this.txtCodCentro.setText(txtCodCentro);
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

	public String getTxtCodCentro() {
		return txtCodCentro.getText();
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

	public void setTxtCodCentro(JTextField txtCodCentro) {
		this.txtCodCentro = txtCodCentro;
	}

	// MCV ========================
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

// 	UPDATE ========================
	public void actualizar() {
		String resultado = miModelo.getResultadoTutor();
		if (resultado.equals("EXITO")) {
			clearFields();
			lblRespuesta.setText("Tutor a�adido con �XITO");
		} else {
			lblRespuesta.setText("Error,No se ha podido a�adir el tutor");
		}
		// lblRespuesta.setVisible(true);
		ActionListener ocultarLabel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// lblRespuesta.setVisible(false);
				lblRespuesta.setText("");
			}
		};
		new Timer(temp, ocultarLabel).start();
	}

	public void actualizarUpdate() {
		String resultado = miModelo.getResultadoTutor();
		if (resultado.equals("EXITO")) {
			clearFields();
			lblRespuesta.setText("Tutor modificado con �XITO");
		} else {
			lblRespuesta.setText("Error,No se ha podido modifcar el tutor");
		}
		// lblRespuesta.setVisible(true);
		ActionListener ocultarLabel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// lblRespuesta.setVisible(false);
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

//	UPDATE ========================
	public void actualizarLogged() {

		lblUser.setText("Logged as: " + miModelo.getUSR());

	}

	public void mostrarBoton() {
		if (modify) {
			lblModify.setVisible(true);
			lblModButton.setVisible(true);
			lblCrear.setVisible(false);
			lblCrearButton.setVisible(false);
		} else {
			lblModify.setVisible(false);
			lblModButton.setVisible(false);
			lblCrear.setVisible(true);
			lblCrearButton.setVisible(true);
		}
	}

	public void setModify(boolean modify) {
		this.modify = modify;
	}
}
