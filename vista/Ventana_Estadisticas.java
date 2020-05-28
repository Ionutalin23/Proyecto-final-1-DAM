package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.controlador;
import modelo.modelo;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana_Estadisticas extends JFrame {
//  ======================================= MVC ==================================

	private controlador miControlador;
	private modelo miModelo;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}
// ================================================================================

	private Image img_bg = new ImageIcon(getClass().getResource("/img/bg9.jpg")).getImage().getScaledInstance(888, 664,
			Image.SCALE_SMOOTH);
	private Image img_buttonBack1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage()
			.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image img_buttonBack2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage()
			.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image img_buttonBack3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage()
			.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image button1 = new ImageIcon(getClass().getResource("/img/boton1.png")).getImage().getScaledInstance(110,
			48, Image.SCALE_SMOOTH);
	private Image button2 = new ImageIcon(getClass().getResource("/img/boton2.png")).getImage().getScaledInstance(110,
			48, Image.SCALE_SMOOTH);
	private Image button3 = new ImageIcon(getClass().getResource("/img/boton3.png")).getImage().getScaledInstance(110,
			48, Image.SCALE_SMOOTH);
	private JPanel panelGrafos;
	private JLabel lblUser;
	private JComboBox FilterComboBox2;
	private JComboBox FilterComboBox;
	private JLabel lblTipo;

	public Ventana_Estadisticas() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 400, 888, 664);
		setTitle("Estadisticas");
		getContentPane().setLayout(null);
		// Back Button ========================
		JLabel BackBtn = new JLabel("");
		BackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BackBtn.setIcon(new ImageIcon(img_buttonBack3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				BackBtn.setIcon(new ImageIcon(img_buttonBack2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				BackBtn.setIcon(new ImageIcon(img_buttonBack2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				BackBtn.setIcon(new ImageIcon(img_buttonBack1));
			}

			public void mouseClicked(MouseEvent e) {
				miControlador.back9();
			}
		});
		
		lblTipo = new JLabel("TIPO:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setVisible(false);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(581, 67, 76, 22);
		getContentPane().add(lblTipo);
		
		JLabel lblNewLabel = new JLabel("GRAFICA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(44, 67, 76, 22);
		getContentPane().add(lblNewLabel);
		
		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setBounds(560, 7, 208, 27);
		getContentPane().add(lblUser);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		// LOGGED USER ===================================
//		User Name Label ========================
		JPanel pnlUser = new JPanel();
		pnlUser.setForeground(new Color(240, 248, 255));
		pnlUser.setBackground(new Color(192, 192, 192, 190));
		pnlUser.setBounds(560, 7, 208, 27);
		getContentPane().add(pnlUser);
		pnlUser.setLayout(null);
		BackBtn.setBounds(10, 11, 57, 23);
		getContentPane().add(BackBtn);
		BackBtn.setIcon(new ImageIcon(img_buttonBack1));

		// Logout Button ========================
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setBounds(780, 11, 82, 23);
		getContentPane().add(lblLogout);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBackground(new Color(205, 92, 92));

		JLabel lblLogoutButton = new JLabel("");
		lblLogoutButton.setBounds(780, 11, 82, 23);
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
				miControlador.logout10();
			}

		});
		lblLogoutButton.setIcon(new ImageIcon(button1));

		
		// Search Filter Combo Box ========================

		FilterComboBox2 = new JComboBox();
		FilterComboBox2.setForeground(Color.WHITE);
		FilterComboBox2.setBackground(Color.GRAY);
		FilterComboBox2.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--","Alumnos en Practicas", "Total Grupos" }));
		FilterComboBox2.setBounds(122, 68, 222, 22);
		getContentPane().add(FilterComboBox2);
		FilterComboBox = new JComboBox();
		FilterComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected2= FilterComboBox2.getSelectedIndex();
				if(selected2==1) {
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--","Lineal", "Circular", "Barras" }));
				}
				if(selected2==2) {
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--", "Circular", "Barras" }));
				}
				int selected=FilterComboBox.getSelectedIndex();
				if(selected==1&&selected2==1) {
					miControlador.graficaLinealPracticas();
				}else if(selected==2&&selected2==1) {
					miControlador.graficaCircularPracticas();
				}else if(selected==3 &&selected2==1) {
					miControlador.graficaBarrasPracticas();
				}else if(selected==1 && selected2==2) {
					miControlador.graficaCircularGrupos();
				}else if(selected==2 && selected2==2) {
					miControlador.graficaBarrasGrupos();
				}}
		});
		FilterComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected2= FilterComboBox2.getSelectedIndex();
				int selected=FilterComboBox.getSelectedIndex();
				if(selected==1&&selected2==1) {
					miControlador.graficaLinealPracticas();
				}else if(selected==2&&selected2==1) {
					miControlador.graficaCircularPracticas();
				}else if(selected==3 &&selected2==1) {
					miControlador.graficaBarrasPracticas();
				}else if(selected==1 && selected2==2) {
					miControlador.graficaCircularGrupos();
				}else if(selected==2 && selected2==2) {
					miControlador.graficaBarrasGrupos();
				}}
		});
		FilterComboBox.setForeground(Color.WHITE);
		FilterComboBox.setBackground(Color.GRAY);
		FilterComboBox.setVisible(false);
		FilterComboBox.setBounds(669, 68, 160, 22);
		getContentPane().add(FilterComboBox);

		panelGrafos = new JPanel();
		panelGrafos.setBackground(Color.WHITE);
		panelGrafos.setBounds(44, 103, 785, 460);
		getContentPane().add(panelGrafos);

//		Window Title ========================
		JLabel WindowTitle = new JLabel("Estadisticas");
		WindowTitle.setForeground(Color.WHITE);
		WindowTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		WindowTitle.setBounds(389, 12, 105, 14);
		getContentPane().add(WindowTitle);

//		Background Image ========================
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 888, 664);
		getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));
//		FRAME LOCATION ==========================
		setLocationRelativeTo(null);

	}

	public void actualizarLogged() {
		lblUser.setText("Logged as: " + miModelo.getUSR());
	}
	public void actualizarPanel() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanelAlumnos(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel2() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularPanelAlumnos(), BorderLayout.CENTER);
		panelGrafos.validate();
	}

	public void actualizarPanel3() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getLinealPanelAlumnos(), BorderLayout.CENTER);
		panelGrafos.validate();
	}

	public void actualizarPanel4() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanelGrupos(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel5() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularGrupos(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	
}
