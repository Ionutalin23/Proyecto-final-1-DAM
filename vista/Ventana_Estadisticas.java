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
				miControlador.logout5();
			}

		});
		lblLogoutButton.setIcon(new ImageIcon(button1));

		
		// Search Filter Combo Box ========================
		JComboBox FilterComboBox = new JComboBox();
		FilterComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = FilterComboBox.getSelectedIndex();
				switch (selected) {
				case 1:
					actualizarPanel3();
					break;
				case 2:
					miControlador.graficaCircular();
					break;
				case 3:
					miControlador.graficaBarras();
					break;
				default:
					break;
				}}
		});
		FilterComboBox.setForeground(Color.WHITE);
		FilterComboBox.setBackground(Color.GRAY);
		FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "Selecciona","Lineal", "Circular", "Barras" }));
		FilterComboBox.setBounds(47, 68, 71, 22);
		getContentPane().add(FilterComboBox);

		JComboBox FilterComboBox2 = new JComboBox();
		FilterComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = FilterComboBox2.getSelectedIndex();
				switch (selected) {
				case 1:
					String titulo= "Alumnos en prácticas";
					String leyenda="Alumnos"; 
					String tiempo="Dias";
					miControlador.graficaLineal(titulo,leyenda,tiempo);
					break;
				case 2:
					miControlador.graficaCircular();
					break;
				case 3:
					miControlador.graficaBarras();
					break;
				default:
					break;
				}}
		});
		FilterComboBox2.setForeground(Color.WHITE);
		FilterComboBox2.setBackground(Color.GRAY);
		FilterComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Alumnos en Practicas", "Alumnos" }));
		FilterComboBox2.setBounds(607, 68, 222, 22);
		getContentPane().add(FilterComboBox2);

		panelGrafos = new JPanel();
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

	public void actualizarPanel() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanel(), BorderLayout.CENTER);
		panelGrafos.validate();
	}

	public void actualizarLogged() {
		lblUser.setText("Logged as: " + miModelo.getUSR());
	}
	public void actualizarPanel2() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularPanel(), BorderLayout.CENTER);
		panelGrafos.validate();
	}

	public void actualizarPanel3() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getLinealPanel(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
}
