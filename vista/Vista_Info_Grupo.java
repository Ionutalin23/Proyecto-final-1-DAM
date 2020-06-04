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

public class Vista_Info_Grupo extends JFrame {
	private controlador miControlador;
	private modelo miModelo;
	private JTextField txtCodGrupo;
	private JTextField txtName;
	private JTextField txtNomCiclo;
	private JTextField txtClaveCiclo;
	private JPanel pnlCrear;
	private JLabel lblLogout;
	private JLabel lblBack;
	private JLabel lblUser;
	private boolean modify=false;
	private int temp = 5000;
	private JLabel lblMod;
	private JLabel lblModButton;
	private JLabel lblCrear;
	private JLabel lblCrearButton;
	private JLabel lblRespuesta;
	private JPanel pnlContenido;
	private JPanel pnlUser;
	private JPanel pnlUser_1;

	public Vista_Info_Grupo() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);
		ImageIcon ico = new ImageIcon(getClass().getResource("/images/logo.png"));
		Image button1 = new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
		Image button2 = new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
		Image button3 = new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110,48, Image.SCALE_SMOOTH);
		Image back1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);
		Image back2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);
		Image back3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 870, 617);
		getContentPane().add(panel);
		panel.setLayout(null);

//		LOGGED AS LBL ========================
		pnlUser_1 = new JPanel();
		pnlUser_1.setBounds(25, 13, 196, 27);
		panel.add(pnlUser_1);
		pnlUser_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlUser_1.setBackground(new Color(224, 24, 24, 220));
				pnlUser_1.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlUser_1.setBackground(new Color(245, 245, 245, 220));
				pnlUser_1.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				miModelo.soundButton();
				miControlador.verPerfil3();
			}
		});
		pnlUser_1.setForeground(new Color(255, 0, 0));
		pnlUser_1.setBackground(new Color(245, 245, 245));
		pnlUser_1.setLayout(null);

		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setBounds(0, 0, 196, 27);
		pnlUser_1.add(lblUser);
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
		
		//FORM TITLE ========================
		JLabel lblTitle = new JLabel("Informaci\u00F3n del grupo:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(35, 82, 296, 29);
		pnlContenido.add(lblTitle);

		//CODIGO DE GRUPO TXT FIELD ========================
		JLabel lblDni = new JLabel("CODIGO DE GRUPO:");
		lblDni.setForeground(new Color(0, 0, 0));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(35, 147, 146, 16);
		pnlContenido.add(lblDni);

		txtCodGrupo = new JTextField();
		txtCodGrupo.setBounds(35, 176, 267, 22);
		pnlContenido.add(txtCodGrupo);
		txtCodGrupo.setColumns(10);

		//NOMBRE TEXT FIELD ========================
		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(35, 211, 77, 16);
		pnlContenido.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(35, 240, 267, 22);
		pnlContenido.add(txtName);

		//NOMBRE DEL CICLO TEXT FIELD ========================
		JLabel lblApellidos = new JLabel("NOMBRE DEL CICLO:");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(35, 275, 156, 16);
		pnlContenido.add(lblApellidos);

		txtNomCiclo = new JTextField();
		txtNomCiclo.setColumns(10);
		txtNomCiclo.setBounds(35, 304, 267, 22);
		pnlContenido.add(txtNomCiclo);

		//CLAVE DEL CICLO TEXT FIELD ========================
		JLabel lblNacim = new JLabel("CLAVE DEL CICLO:");
		lblNacim.setForeground(Color.BLACK);
		lblNacim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNacim.setBounds(35, 339, 177, 16);
		pnlContenido.add(lblNacim);

		txtClaveCiclo = new JTextField();
		txtClaveCiclo.setColumns(10);
		txtClaveCiclo.setBounds(35, 368, 267, 22);
		pnlContenido.add(txtClaveCiclo);
		
		lblRespuesta = new JLabel("New label");
		lblRespuesta.setBackground(Color.WHITE);
		lblRespuesta.setForeground(Color.WHITE);
		lblRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRespuesta.setBounds(35, 532, 308, 29);
		pnlContenido.add(lblRespuesta);
		lblRespuesta.setText("");

//		CREATE BUTTON ========================
		lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(128, 448, 109, 48);
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
				miControlador.insertarGrupo();
			}
		});
		lblCrearButton.setBounds(128, 448, 110, 48);
		pnlContenido.add(lblCrearButton);
		lblCrearButton.setIcon(new ImageIcon(button1));
		
// 		Boton Modificar
		lblMod = new JLabel("MODIFICAR");
		lblMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMod.setForeground(Color.WHITE);
		lblMod.setBackground(new Color(205, 92, 92));
		lblMod.setBounds(128, 448, 109, 48);
		pnlContenido.add(lblMod);
		
		lblModButton = new JLabel("");
		lblMod.setVisible(false);
		lblModButton.setVisible(false);
		lblModButton.setBounds(127, 448, 110, 48);
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
				miModelo.modificarGrupo(Integer.parseInt(txtCodGrupo.getText()),txtName.getText(),Integer.parseInt(txtClaveCiclo.getText()),txtNomCiclo.getText());
			}
		});

//		LOGOUT BUTTON ========================
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

			public void mouseClicked(MouseEvent e) {
				clearFields();
				miControlador.logout8();
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
				miControlador.back7();
			}
		});
		lblBack.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/back1.png")));
		lblBack.setBounds(35, 13, 24, 24);
		pnlContenido.add(lblBack);

//		BACKGROUND IMG ========================
		JLabel lblPortada = new JLabel("");
		lblPortada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPortada.setBounds(0, 0, 870, 617);
		panel.add(lblPortada);
		lblPortada.setIcon(new ImageIcon(Vista_Info_Tutor.class.getResource("/images/uni3.jpg")));
		lblPortada.setBackground(new Color(0, 0, 0));

	}
//	GETTERS & SETTERS ========================

	public String getTxtCodGrupo() {
		return txtCodGrupo.getText();
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtNomCiclo() {
		return txtNomCiclo.getText();
	}

	public String getTxtClaveCiclo() {
		return txtClaveCiclo.getText();
	}
	
public void setTxtCodGrupo(String txtCodGrupo) {
		this.txtCodGrupo.setText(txtCodGrupo);
	}

	public void setTxtName(String txtName) {
		this.txtName.setText(txtName);
	}

	public void setTxtNomCiclo(String txtNomCiclo) {
		this.txtNomCiclo.setText(txtNomCiclo);
	}

	public void setTxtClaveCiclo(String txtClaveCiclo) {
		this.txtClaveCiclo.setText(txtClaveCiclo);
	}
	public void setTxtCodGrupo(JTextField txtCodGrupo) {
		this.txtCodGrupo = txtCodGrupo;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public void setTxtNomCiclo(JTextField txtNomCiclo) {
		this.txtNomCiclo = txtNomCiclo;
	}

	public void setTxtClaveCiclo(JTextField txtClaveCiclo) {
		this.txtClaveCiclo = txtClaveCiclo;
	}

	//	MVC ========================
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}
	
// 	UPDATE ========================
	public void actualizar() {
		String resultado = miModelo.getResultadoGrupo();
		if(resultado.equals("EXITO")) {
			lblRespuesta.setText("Grupo añadido con ÉXITO");
			clearFields();
		}else {
			lblRespuesta.setText("Error,No se ha podido añadidir el Grupo");
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
	
//	UPDATE LOGGED USER ========================
	public void actualizarLogged() {

		lblUser.setText("Logged as: " + miModelo.getUSR());
	}

	public void actualizar2() {
		String resultado = miModelo.getResultadoGrupoUpdate();
		if(resultado.equals("EXITO")) {
			lblRespuesta.setText("Grupo modificado con ÉXITO");
			clearFields();
		}else {
			lblRespuesta.setText("Error,No se ha podido modifcar el Grupo");
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
