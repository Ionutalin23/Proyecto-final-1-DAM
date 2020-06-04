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

public class Vista_Info_Empresa extends JFrame {
//	GUI Content ========================
	private controlador miControlador;
	private modelo miModelo;
	private JTextField txtCif;
	private JTextField txtName;
	private JTextField txtDireccion;
	private JTextField txtTel;
	private JPanel pnlCrear;
	private JLabel lblLogout;
	private JLabel lblBack;
	private JTextField txtLocalidad;
	private boolean modify=false;
	private JLabel lblUser;
	private JTextField txtMail;
	private JTextField txtRepresentante;
	private int temp = 5000;
	private JLabel lblMod;
	private JLabel lblModButton;
	private JLabel lblCrear;
	private JLabel lblCrearButton;
	private JLabel lblRespuesta;
	private JPanel pnlContenido;
	private JPanel pnlUser;
	
	public Vista_Info_Empresa() {
		
//	 	Setting Images ======================== (Check all images are linked to correct folder to avoid null pointer exception)
		ImageIcon ico =new ImageIcon(getClass().getResource("/images/logo.png"));
		ImageIcon ico2 =new ImageIcon(getClass().getResource("/images/uni2.jpg"));
		Image button1= new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image button2= new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image button3= new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
		Image back1= new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Image back2= new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Image back3= new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	
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
		
//		UEM LOGO ========================
		JLabel lblLogo = new JLabel("");
		lblLogo.setForeground(new Color(0, 0, 0));
		lblLogo.setBounds(25, 555, 162, 49);
		panel.add(lblLogo);
		ImageIcon img=new ImageIcon(ico.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
		lblLogo.setIcon(img);
		lblLogo.setBackground(new Color(0, 0, 0));
		
		pnlContenido = new JPanel();
		pnlContenido.setBounds(230, 32, 405, 561);
		panel.add(pnlContenido);
		pnlContenido.setBackground(new Color(226,106,106,240));
		pnlContenido.setLayout(null);
		
		//FORM TITLE ========================
		JLabel lblTitle = new JLabel("Informaci\u00F3n de empresa:");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblTitle.setBounds(35, 82, 302, 29);
		pnlContenido.add(lblTitle);
		
		lblRespuesta = new JLabel("New label");
		lblRespuesta.setBackground(Color.WHITE);
		lblRespuesta.setForeground(Color.WHITE);
		lblRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRespuesta.setBounds(55, 532, 282, 29);
		pnlContenido.add(lblRespuesta);
		lblRespuesta.setText("");
		
		//CIF TEXT FIELD ========================
		JLabel lblCif = new JLabel("CIF:");
		lblCif.setForeground(new Color(0, 0, 0));
		lblCif.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCif.setBounds(35, 135, 56, 16);
		pnlContenido.add(lblCif);
		
		txtCif = new JTextField();
		txtCif.setBounds(35, 159, 267, 22);
		pnlContenido.add(txtCif);
		txtCif.setColumns(10);
		
		//NOMBRE TEXT FIELD ========================
		JLabel lblName = new JLabel("NOMBRE:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(35, 186, 77, 16);
		pnlContenido.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(35, 207, 267, 22);
		pnlContenido.add(txtName);
		
		//DIRECCION TEXT FIELD ========================
		JLabel lblDireccion = new JLabel("DIRECCION:");
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(35, 233, 92, 16);
		pnlContenido.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(35, 254, 267, 22);
		pnlContenido.add(txtDireccion);
		
		//TLF TEXT FIELD ========================
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(35, 281, 92, 16);
		pnlContenido.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(35, 304, 267, 22);
		pnlContenido.add(txtTel);
		
		//LOCATION TEXT FIELD ========================
		JLabel lblLocalidad = new JLabel("LOCALIDAD:");
		lblLocalidad.setForeground(Color.BLACK);
		lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocalidad.setBounds(35, 331, 92, 16);
		pnlContenido.add(lblLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(35, 353, 267, 22);
		pnlContenido.add(txtLocalidad);
		
		//EMAIL TEXT FIELD ========================
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(35, 380, 63, 16);
		pnlContenido.add(lblEmail);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(35, 402, 267, 22);
		pnlContenido.add(txtMail);
		
		//REPRESENTANTE TEXT FIELD ========================
		JLabel lblRepresentante = new JLabel("REPRESENTANTE:");
		lblRepresentante.setForeground(Color.BLACK);
		lblRepresentante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepresentante.setBounds(35, 430, 129, 16);
		pnlContenido.add(lblRepresentante);
		
		txtRepresentante = new JTextField();
		txtRepresentante.setColumns(10);
		txtRepresentante.setBounds(35, 452, 267, 22);
		pnlContenido.add(txtRepresentante);
		
//		CREATE NEW BUTTON ========================
		lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(205, 92, 92));
		lblCrear.setBounds(135, 481, 109, 48);
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
				miControlador.insertarEmpresa();
			}
		});
		
		lblCrearButton.setBounds(135, 481, 110, 48);
		pnlContenido.add(lblCrearButton);
		lblCrearButton.setIcon(new ImageIcon(button1));
		lblMod = new JLabel("MODIFICAR");
		lblMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMod.setForeground(Color.WHITE);
		lblMod.setBackground(new Color(205, 92, 92));
		lblMod.setBounds(135, 481, 109, 48);
		pnlContenido.add(lblMod);
		
		lblModButton = new JLabel("");
		lblModButton.setBounds(134, 481, 110, 48);
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
				miModelo.modificarEmpresa(txtCif.getText(),txtName.getText(),txtDireccion.getText(),Integer.parseInt(txtTel.getText()),txtLocalidad.getText(),txtRepresentante.getText(),txtMail.getText());
			}
		});
		
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
				miControlador.verPerfil4();
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
				miControlador.logout7();
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
				miControlador.back6();
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
		ImageIcon img2=new ImageIcon(ico2.getImage().getScaledInstance(lblPortada.getWidth(), lblPortada.getHeight(), Image.SCALE_SMOOTH));
		lblPortada.setIcon(new ImageIcon(Vista_Info_Alumno.class.getResource("/images/uni2.jpg")));
		lblPortada.setBackground(new Color(0, 0, 0));
	
		
	}

//	GETTERS & SETTERS========================
	public String getTxtCif() {
		return txtCif.getText();
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtDireccion() {
		return txtDireccion.getText();
	}

	public String getTxtTel() {
		return txtTel.getText();
	}

	public String getTxtLocalidad() {
		return txtLocalidad.getText();
	}

	public String getTxtMail() {
		return txtMail.getText();
	}

	public String getTxtRepresentante() {
		return txtRepresentante.getText();
	}
	
	public void setTxtCif(String txtCif) {
		this.txtCif.setText(txtCif);
	}

	public void setTxtName(String txtName) {
		this.txtName.setText(txtName);
	}

	public void setTxtDireccion(String txtDireccion) {
		this.txtDireccion.setText(txtDireccion);
	}

	public void setTxtTel(String txtTel) {
		this.txtTel.setText(txtTel);
	}

	public void setTxtLocalidad(String txtLocalidad) {
		this.txtLocalidad.setText(txtLocalidad);
	}

	public void setTxtMail(String txtMail) {
		this.txtMail.setText(txtMail);
	}

	public void setTxtRepresentante(String txtRepresentante) {
		this.txtRepresentante.setText(txtRepresentante);
	}

	//	MCV ========================
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

// 	UPDATE ========================
	public void actualizar() {
		String resultado = miModelo.getResultadoEmpresa();
		if(resultado.equals("EXITO")) {
			lblRespuesta.setText("Empresa añadida con ÉXITO");
		}else {
			lblRespuesta.setText("Error,No se ha podido añadir la empresa");
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
	
	//UPDATE LOGGED USER ========================
	public void actualizarLogged() {
		lblUser.setText("Logged as: "+miModelo.getUSR());
		
	}
	
//	CLEAR FIELDS ========================
	public void clearFields() {
		for (Object obj : pnlContenido.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
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
	public void actualizarUpdate() {
		String resultado=miModelo.getResultadoEmpresa();
		if(resultado.equals("EXITO")) {
			clearFields();
			lblRespuesta.setText("Empresa modificada con ÉXITO");
		}else {
			lblRespuesta.setText("Error,No se ha podido modifcar la empresa");
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
	
}