package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.border.Border;

import controlador.controlador;
import modelo.modelo;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class MenuVista extends JFrame {
	private controlador miControlador;
	private modelo miModelo;
	private JLabel lblAnexos;
	private JLabel lblTutoBtn;
	private JLabel lblTuto;
	Image button1 = new ImageIcon(getClass().getResource("/img/boton1.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	Image button2 = new ImageIcon(getClass().getResource("/img/boton2.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	Image button3 = new ImageIcon(getClass().getResource("/img/boton3.png")).getImage().getScaledInstance(110, 48,
			Image.SCALE_SMOOTH);
	private JLabel lblLogout;
	private JLabel lblUser;
	private JLabel lblEstadist;
	private JLabel lblEnConstruccion;
	private JLabel lblStatsBtn;
	private JLabel BtnMenu;
	private JPanel pnlMenu;
	private JPanel pnlUser;

	public MenuVista() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setBounds(100, 400, 800, 550);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 664);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);
		// USER SETTINGS PANEL-------------------------------------------------------
		BtnMenu = new JLabel("");
		BtnMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int posicion = BtnMenu.getX();
				if (posicion > 12) {
					Animacion.Animacion.mover_izquierda(264, 12, 2, 2, BtnMenu);
					Animacion.Animacion.mover_izquierda(0, -260, 2, 2, pnlMenu);
				} else {
					Animacion.Animacion.mover_derecha(12, 220, 2, 2, BtnMenu);
					Animacion.Animacion.mover_derecha(-260, 0, 2, 2, pnlMenu);
				}
			}
		});
		BtnMenu.setIcon(new ImageIcon(MenuVista.class.getResource("/images/menu.png")));
		BtnMenu.setBounds(12, 13, 25, 27);
		getContentPane().add(BtnMenu);
		pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(220, 20, 60));
		pnlMenu.setForeground(new Color(0, 0, 0));
		pnlMenu.setBounds(-260, 0, 254, 617);
		getContentPane().add(pnlMenu);
		pnlMenu.setLayout(null);

		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBounds(49, 31, 167, 128);
		lblPhoto.setIcon(new ImageIcon(MenuVista.class.getResource("/images/user.png")));
		pnlMenu.add(lblPhoto);

		lblLogout = new JLabel("LOGOUT");
		lblLogout.setBounds(753, 13, 92, 27);
		getContentPane().add(lblLogout);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBackground(new Color(205, 92, 92));

		JLabel lblLogoutButton = new JLabel("");
		lblLogoutButton.setBounds(753, 13, 92, 27);
		getContentPane().add(lblLogoutButton);
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
				miControlador.rol();
				miControlador.logout();
			}

		});
		lblLogoutButton.setIcon(new ImageIcon(button1));

//		------------------------------------------------------------------------------

		pnlUser = new JPanel();
		pnlUser.setBounds(49, 13, 196, 27);
		getContentPane().add(pnlUser);
		pnlUser.setForeground(new Color(240, 248, 255));
		pnlUser.setBackground(new Color(192, 192, 192, 190));
		pnlUser.setLayout(null);

		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setBounds(0, 0, 196, 27);
		pnlUser.add(lblUser);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel pnlMed = new JPanel();
		pnlMed.setBounds(269, 0, 412, 617);
		pnlMed.setBackground(new Color(255, 255, 255, 200));
		getContentPane().add(pnlMed);
		pnlMed.setLayout(null);

		lblAnexos = new JLabel("Anexos");
		lblAnexos.setBounds(70, 241, 283, 27);
		pnlMed.add(lblAnexos);
		lblAnexos.setBackground(new Color(205, 92, 92));
		lblAnexos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexos.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblAnexos.setForeground(new Color(255, 255, 255));

		JLabel lblAnxBtn = new JLabel("");
		lblAnxBtn.setBounds(70, 241, 283, 27);
		pnlMed.add(lblAnxBtn);
		lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblAnxBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				miModelo.soundButton();
				miControlador.BusquedaAnexos();
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Anexos vista = new Busqueda_Anexos();
//				vista.setVisible(true);
//			}
		});

		lblTuto = new JLabel("Tutores");
		lblTuto.setBounds(70, 308, 283, 27);
		pnlMed.add(lblTuto);
		lblTuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuto.setForeground(Color.WHITE);
		lblTuto.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblTuto.setBackground(new Color(43, 43, 43));

		lblTutoBtn = new JLabel("");
		lblTutoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				miControlador.BusquedaTutores();
				miModelo.soundButton();
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Tutores vista = new Busqueda_Tutores();
//				vista.setVisible(true);
//			}
		});

		lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblTutoBtn.setBounds(70, 308, 283, 27);
		pnlMed.add(lblTutoBtn);

		JLabel lblEmp = new JLabel("Empresas");
		lblEmp.setBounds(70, 371, 283, 27);
		pnlMed.add(lblEmp);
		lblEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmp.setForeground(Color.WHITE);
		lblEmp.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblEmp.setBackground(new Color(43, 43, 43));

		JLabel lblEmpBtn = new JLabel("");
		lblEmpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				miControlador.BusquedaEmpresas();
				miModelo.soundButton();
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Empresas vista = new Busqueda_Empresas();
//				vista.setVisible(true);
//			}
		});

		lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblEmpBtn.setBounds(70, 371, 283, 27);
		pnlMed.add(lblEmpBtn);

		JLabel lblAl = new JLabel("Alumnos");
		lblAl.setBounds(70, 436, 283, 27);
		pnlMed.add(lblAl);
		lblAl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAl.setForeground(Color.WHITE);
		lblAl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblAl.setBackground(new Color(43, 43, 43));

		JLabel lblAlmnBtn = new JLabel("");
		lblAlmnBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				miControlador.BusquedaAlumnos();
				miModelo.soundButton();
			}
		});

		lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblAlmnBtn.setBounds(70, 436, 283, 27);
		pnlMed.add(lblAlmnBtn);

		JLabel lblProf = new JLabel("");
		lblProf.setBounds(146, 50, 166, 148);
		pnlMed.add(lblProf);
		lblProf.setIcon(new ImageIcon(MenuVista.class.getResource("/img/img.png")));

		JLabel lblGrup = new JLabel("Grupos");
		lblGrup.setBounds(70, 505, 283, 27);
		pnlMed.add(lblGrup);
		lblGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrup.setForeground(Color.WHITE);
		lblGrup.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblGrup.setBackground(new Color(43, 43, 43));

		JLabel lblGrupBtn = new JLabel("");
		lblGrupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				miControlador.BusquedaGrupos();
				miModelo.soundButton();
			}
		});

		lblEstadist = new JLabel("Estad\u00EDsticas");
		lblEstadist.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadist.setForeground(Color.WHITE);
		lblEstadist.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblEstadist.setBackground(new Color(43, 43, 43));
		lblEstadist.setBounds(70, 561, 283, 27);
		pnlMed.add(lblEstadist);

		lblEnConstruccion = new JLabel("EN CONSTRUCCION");
		lblEnConstruccion.setForeground(Color.RED);
		lblEnConstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnConstruccion.setVisible(false);
		lblStatsBtn = new JLabel("");
		lblStatsBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblStatsBtn.setBounds(70, 561, 283, 27);
		pnlMed.add(lblStatsBtn);
		lblStatsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStatsBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblStatsBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblStatsBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblStatsBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				lblEnConstruccion.setVisible(true);
				miModelo.soundButton();
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Grupos vista = new Busqueda_Grupos();
//				vista.setVisible(true);
//			}
		});
		lblEnConstruccion.setBounds(111, 588, 218, 16);
		pnlMed.add(lblEnConstruccion);

		lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblGrupBtn.setBounds(70, 505, 283, 27);
		pnlMed.add(lblGrupBtn);

		JLabel lblBg = new JLabel("");
		lblBg.setForeground(SystemColor.window);
		lblBg.setIcon(new ImageIcon(MenuVista.class.getResource("/img/uem.jpg")));
		lblBg.setBackground(new Color(255, 99, 71));
		lblBg.setBounds(1, 0, 888, 664);
		getContentPane().add(lblBg);

	}

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void actualizarLogged() {
		lblUser.setText("Logged as: " + miModelo.getUSR());
	}

	public void cambiarTutor() {
		lblEnConstruccion.setVisible(false);
		lblEstadist.setVisible(false);
		lblStatsBtn.setVisible(false);
	}

	public void cambiarDirector() {
		lblEnConstruccion.setVisible(true);
		lblEstadist.setVisible(true);
		lblStatsBtn.setVisible(true);
	}
}
