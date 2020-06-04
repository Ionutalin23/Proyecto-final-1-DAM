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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana_config_User extends JFrame {
//	GUI Content ========================
	private controlador miControlador;
	private modelo miModelo;
	private JPanel pnlCrear;
	private JLabel lblLogout;
	private JLabel lblBack;
	private JLabel lblResul;
	private JPanel pnlContenido;
	private JLabel lblModButton;

// 	Setting Images ======================== (Check all images are linked to correct folder to avoid null pointer exception)
	ImageIcon ico = new ImageIcon(getClass().getResource("/images/logo.png"));
	ImageIcon ico2 = new ImageIcon(getClass().getResource("/images/uni2.jpg"));
	Image button1 = new ImageIcon(getClass().getResource("/images/boton1.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	Image button2 = new ImageIcon(getClass().getResource("/images/boton2.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	Image button3 = new ImageIcon(getClass().getResource("/images/boton3.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	Image button4 = new ImageIcon(getClass().getResource("/img/loginbutton4.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	Image back1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24,
			Image.SCALE_SMOOTH);
	Image back2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24,
			Image.SCALE_SMOOTH);
	Image back3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24,
			Image.SCALE_SMOOTH);
	Image img_bg = new ImageIcon(getClass().getResource("/img/bg9.jpg")).getImage().getScaledInstance(888, 664,
			Image.SCALE_SMOOTH);
	Image banner = new ImageIcon(getClass().getResource("/img/bannerUem.jpg")).getImage().getScaledInstance(870, 162,
			Image.SCALE_SMOOTH);
	private JLabel lblFoto;
	private JLabel lblBanner;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JTextField txtRol;
	private JLabel lblModify;

	public Ventana_config_User() {

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

//		FORM CONTENT ========================
		pnlContenido = new JPanel();
		pnlContenido.setBounds(0, 0, 870, 617);
		panel.add(pnlContenido);
		pnlContenido.setBackground(new Color(226, 106, 106, 240));
		pnlContenido.setLayout(null);

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
				miControlador.logout6();
			}
		});

		// BACK BUTTON ========================
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
				miControlador.back5();
			}
		});
		
				lblModify = new JLabel("MODIFICAR");
				lblModify.setHorizontalAlignment(SwingConstants.CENTER);
				lblModify.setForeground(Color.WHITE);
				lblModify.setBackground(new Color(205, 92, 92));
				lblModify.setBounds(426, 546, 109, 48);
				pnlContenido.add(lblModify);

		lblFoto = new JLabel("");
		lblFoto.setBackground(Color.WHITE);
		lblFoto.setBounds(47, 163, 208, 186);
		pnlContenido.add(lblFoto);
		lblBack.setIcon(new ImageIcon(Ventana_config_User.class.getResource("/images/back1.png")));
		lblBack.setBounds(4, 2, 24, 24);
		pnlContenido.add(lblBack);

		// LOGOUT BUTTON ========================
		lblLogout = new JLabel("LOGOUT");
		lblLogout.addMouseListener(new MouseAdapter() {
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
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.logout11();
			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBackground(new Color(205, 92, 92));
		lblLogout.setBounds(778, 2, 92, 27);
		pnlContenido.add(lblLogout);
		lblLogoutButton.setBounds(778, 2, 92, 27);
		pnlContenido.add(lblLogoutButton);
		lblLogoutButton.setIcon(new ImageIcon(button1));

		lblBanner = new JLabel("");
		lblBanner.setIcon(new ImageIcon(banner));
		lblBanner.setBounds(0, 0, 870, 127);
		pnlContenido.add(lblBanner);

		// FORM RESULT TEXT ========================
		lblResul = new JLabel("");
		lblResul.setForeground(new Color(128, 0, 0));
		lblResul.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResul.setHorizontalAlignment(SwingConstants.CENTER);
		lblResul.setBounds(32, 479, 267, 16);
		pnlContenido.add(lblResul);

		JLabel lblDatos = new JLabel("DATOS PERSONALES");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setForeground(new Color(128, 0, 0));
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDatos.setBounds(301, 137, 338, 24);
		pnlContenido.add(lblDatos);
		
		lblModButton = new JLabel("");
		lblModButton.setEnabled(false);
		lblModButton.setBounds(426, 546, 110, 48);
		lblModButton.setIcon(new ImageIcon(button1));
		pnlContenido.add(lblModButton);
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
					miModelo.modificarUsuario(txtNombre.getText(),txtApellidos.getText(),txtEmail.getText(),txtUsuario.getText(),txtContra.getText(),txtRol.getText());
				}

			});

		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(301, 163, 128, 16);
		pnlContenido.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblModButton.setEnabled(true);
			}
		});
		txtNombre.setBounds(301, 192, 344, 22);
		pnlContenido.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(301, 227, 128, 16);
		pnlContenido.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblModButton.setEnabled(true);
			}
		});
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(301, 256, 344, 22);
		pnlContenido.add(txtApellidos);

		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(301, 291, 128, 16);
		pnlContenido.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblModButton.setEnabled(true);
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(301, 320, 344, 22);
		pnlContenido.add(txtEmail);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(301, 355, 128, 16);
		pnlContenido.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblModButton.setEnabled(true);
			}
		});
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(301, 384, 344, 22);
		pnlContenido.add(txtUsuario);

		JLabel lblContra = new JLabel("CONTRASE\u00D1A:");
		lblContra.setForeground(Color.WHITE);
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContra.setBounds(301, 419, 128, 16);
		pnlContenido.add(lblContra);

		txtContra = new JTextField();
		txtContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblModButton.setEnabled(true);
			}
		});
		txtContra.setColumns(10);
		txtContra.setBounds(301, 448, 344, 22);
		pnlContenido.add(txtContra);

		JLabel lblRol = new JLabel("ROL:");
		lblRol.setForeground(Color.WHITE);
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRol.setBounds(301, 479, 128, 16);
		pnlContenido.add(lblRol);

		txtRol = new JTextField();
		txtRol.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblModButton.setEnabled(true);
			}
		});
		txtRol.setColumns(10);
		txtRol.setBounds(301, 508, 344, 22);
		pnlContenido.add(txtRol);

		
		

//		BACKGROUND IMG ========================
		JLabel lblPortada = new JLabel("");
		lblPortada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPortada.setBounds(0, 0, 870, 617);
		panel.add(lblPortada);
		ImageIcon img2 = new ImageIcon(
				ico2.getImage().getScaledInstance(lblPortada.getWidth(), lblPortada.getHeight(), Image.SCALE_SMOOTH));
		lblPortada.setIcon(new ImageIcon(img_bg));
		lblPortada.setBackground(new Color(0, 0, 0));

	}

// 	MVC ========================
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

//	GETTERS & SETTERS ========================
	

	// UPDATE ========================

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);;
	}

	public String getTxtApellidos() {
		return txtApellidos.getText();
	}

	public void setTxtApellidos(String txtApellidos) {
		this.txtApellidos.setText(txtApellidos);
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);;
	}

	public String getTxtUsuario() {
		return txtUsuario.getText();
	}

	public void setTxtUsuario(String txtUsuario) {
		this.txtUsuario.setText(txtUsuario);;
	}

	public String getTxtContra() {
		return txtContra.getText();
	}

	public void setTxtContra(String txtContra) {
		this.txtContra.setText(txtContra);
	}

	public String getTxtRol() {
		return txtRol.getText();
	}

	public void setTxtRol(String txtRol) {
		this.txtRol.setText(txtRol);;
	}

	public void actualizar2() {
		String resultado = miModelo.getResultadoUsu();
		if (resultado.equals("EXITO")) {
			JOptionPane.showMessageDialog(this, "Usuario modificado con éxito");
			lblModButton.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, comprueba todos los campos");
		}
	}

//	CLEAR FIELDS ========================
	public void clearFields() {
		for (Object obj : pnlContenido.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
	}

	public void actualizarFoto() {
		Image imgPerfil = new ImageIcon(getClass().getResource("/img/" + miModelo.getUSR() + ".jpg")).getImage()
				.getScaledInstance(247, 221, Image.SCALE_SMOOTH);
		lblFoto.setIcon(new ImageIcon(imgPerfil));
	}
}
