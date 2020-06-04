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
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private Image img_ButtonCerrar = new ImageIcon(getClass().getResource("/images/Btn_Eliminar.jpg")).getImage()
			.getScaledInstance(147, 23, Image.SCALE_SMOOTH);
	private Image img_ButtonCerrarHover = new ImageIcon(getClass().getResource("/images/Btn_Eliminar_Hover.jpg"))
			.getImage().getScaledInstance(147, 23, Image.SCALE_SMOOTH);
	private Image img_ButtonVer = new ImageIcon(getClass().getResource("/images/Btn_Modificar.jpg")).getImage()
			.getScaledInstance(147, 23, Image.SCALE_SMOOTH);
	private Image img_ButtonVerHover = new ImageIcon(getClass().getResource("/images/Btn_Modificar_Hover.jpg"))
			.getImage().getScaledInstance(147, 23, Image.SCALE_SMOOTH);
	private JPanel panelGrafos;
	private JLabel lblUser;
	private JComboBox FilterComboBox2;
	private JComboBox FilterComboBox;
	private JLabel lblTipo;
	private JLabel lblInforme;
	private JLabel informeBTN;
	private JPanel panelInformes;
	private JScrollPane scrollPane;
	private JTable table;
	private int selected2;
	private JLabel lblCerrarInforme;
	private JLabel informeCerrarBTN;
	private JLabel lblGrafica;
	private JLabel windowTitle;
	private JLabel lblTituloInformes;


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
		
		informeCerrarBTN = new JLabel("");
		informeCerrarBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				informeCerrarBTN.setIcon(new ImageIcon(img_ButtonCerrar));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				informeCerrarBTN.setIcon(new ImageIcon(img_ButtonCerrarHover));
			}

			public void mouseClicked(MouseEvent e) {
				panelGrafos.setVisible(true);
				panelInformes.setVisible(false);
				lblCerrarInforme.setVisible(false);
				informeCerrarBTN.setVisible(false);
				lblGrafica.setVisible(true);
				FilterComboBox2.setVisible(true);
				lblTipo.setVisible(true);
				FilterComboBox.setVisible(true);
				windowTitle.setText("Estadisticas");
				informeBTN.setEnabled(true);
				lblTituloInformes.setVisible(false);
			}
		});
		
		lblCerrarInforme = new JLabel("Cerrar Informe");
		lblCerrarInforme.setVisible(false);
		informeCerrarBTN.setVisible(false);
		
		panelInformes = new JPanel();
		panelInformes.setBounds(44, 104, 785, 460);
		panelInformes.setVisible(false);
		
		lblTituloInformes = new JLabel("INFORME");
		lblTituloInformes.setVisible(false);
		lblTituloInformes.setForeground(Color.WHITE);
		lblTituloInformes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInformes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloInformes.setBounds(246, 47, 397, 46);
		getContentPane().add(lblTituloInformes);
		getContentPane().add(panelInformes);
		panelInformes.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 785, 460);
		panelInformes.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		lblCerrarInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarInforme.setForeground(Color.BLACK);
		lblCerrarInforme.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblCerrarInforme.setBounds(203, 576, 147, 23);
		getContentPane().add(lblCerrarInforme);
		informeCerrarBTN.setBounds(203, 576, 147, 23);
		getContentPane().add(informeCerrarBTN);
		informeCerrarBTN.setIcon(new ImageIcon(img_ButtonCerrar));
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(581, 67, 76, 22);
		getContentPane().add(lblTipo);
		
		lblGrafica = new JLabel("GRAFICA:");
		lblGrafica.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrafica.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrafica.setForeground(Color.WHITE);
		lblGrafica.setBounds(44, 67, 76, 22);
		getContentPane().add(lblGrafica);
		
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
		FilterComboBox2.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--","Alumnos por tutor","Tutores por ciclo","Alumnos por empresa","Alumnos en Practicas", "Informe Grupos","Informe Aseguradora" }));
		FilterComboBox2.setBounds(122, 68, 222, 22);
		getContentPane().add(FilterComboBox2);
		FilterComboBox = new JComboBox();
		FilterComboBox2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				selected2 = FilterComboBox2.getSelectedIndex();
				if(selected2==0) {
					lblInforme.setVisible(false);
					informeBTN.setVisible(false);
				}
				if(selected2==1) {
					lblInforme.setVisible(true);
					informeBTN.setVisible(true);
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--", "Circular", "Barras" }));
				}
				if(selected2==2) {
					lblInforme.setVisible(true);
					informeBTN.setVisible(true);
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--", "Circular", "Barras" }));
				}
				if(selected2==3) {
					lblInforme.setVisible(true);
					informeBTN.setVisible(true);
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--", "Circular", "Barras" }));
				}
				if(selected2==4) {
					lblInforme.setVisible(true);
					informeBTN.setVisible(true);
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--","Lineal", "Circular", "Barras" }));
				}
				if(selected2==5) {
					lblInforme.setVisible(true);
					informeBTN.setVisible(true);
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--", "Circular", "Barras" }));
				}
				if(selected2==6) {
					lblInforme.setVisible(true);
					informeBTN.setVisible(true);
					FilterComboBox.setVisible(true);
					lblTipo.setVisible(true);
					FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "--Selecciona--", "Circular", "Barras" }));
				}
				int selected=FilterComboBox.getSelectedIndex();
				if(selected==1&&selected2==1) {
					miControlador.graficaCircularAlumnosTutor();
				}else if(selected==2&&selected2==1) {
					miControlador.graficaBarrasAlumnosTutor();
				}else if(selected==1&&selected2==2) {
					miControlador.graficaCircularTutoresCiclo();
				}else if(selected==2&&selected2==2) {
					miControlador.graficaBarrasTutoresCiclo();
				}else if(selected==1&&selected2==3) {
					miControlador.graficaCircularAlumnosEmpresa();
				}else if(selected==2&&selected2==3) {
					miControlador.graficaBarrasAlumnosEmpresa();
				}else if(selected==1&&selected2==4) {
					miControlador.graficaLinealPracticas();
				}else if(selected==2&&selected2==4) {
					miControlador.graficaCircularPracticas();
				}else if(selected==3 &&selected2==4) {
					miControlador.graficaBarrasPracticas();
				}else if(selected==1 && selected2==5) {
					miControlador.graficaCircularGrupos();
				}else if(selected==2 && selected2==5) {
					miControlador.graficaBarrasAseguradoras();
				}else if(selected==1 && selected2==6) {
					miControlador.graficaCircularAseguradoras();
				}else if(selected==2 && selected2==6) {
					miControlador.graficaBarrasAseguradoras();
				}}
		});
		FilterComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected2= FilterComboBox2.getSelectedIndex();
				int selected=FilterComboBox.getSelectedIndex();
				if(selected==1&&selected2==1) {
					miControlador.graficaCircularAlumnosTutor();
				}else if(selected==2&&selected2==1) {
					miControlador.graficaBarrasAlumnosTutor();
				}else if(selected==1&&selected2==2) {
					miControlador.graficaCircularTutoresCiclo();
				}else if(selected==2&&selected2==2) {
					miControlador.graficaBarrasTutoresCiclo();
				}else if(selected==1&&selected2==3) {
					miControlador.graficaCircularAlumnosEmpresa();
				}else if(selected==2&&selected2==3) {
					miControlador.graficaBarrasAlumnosEmpresa();
				}else if(selected==1&&selected2==4) {
					miControlador.graficaLinealPracticas();
				}else if(selected==2&&selected2==4) {
					miControlador.graficaCircularPracticas();
				}else if(selected==3 &&selected2==4) {
					miControlador.graficaBarrasPracticas();
				}else if(selected==1 && selected2==5) {
					miControlador.graficaCircularGrupos();
				}else if(selected==2 && selected2==5) {
					miControlador.graficaBarrasAseguradoras();
				}else if(selected==1 && selected2==6) {
					miControlador.graficaCircularAseguradoras();
				}else if(selected==2 && selected2==6) {
					miControlador.graficaBarrasAseguradoras();
				}}
		});
		FilterComboBox.setForeground(Color.WHITE);
		FilterComboBox.setBackground(Color.GRAY);
		FilterComboBox.setVisible(false);
		FilterComboBox.setBounds(669, 68, 160, 22);
		getContentPane().add(FilterComboBox);
//=================================================== BTN INFORME ==================================== 
		lblInforme = new JLabel("Ver informe");
		lblInforme.setVisible(false);
		lblInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblInforme.setBounds(44, 576, 147, 23);
		lblInforme.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblInforme.setForeground(Color.BLACK);
		getContentPane().add(lblInforme);

		informeBTN = new JLabel("");
		informeBTN.setVisible(false);
		informeBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				informeBTN.setIcon(new ImageIcon(img_ButtonVer));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				informeBTN.setIcon(new ImageIcon(img_ButtonVerHover));
			}

			public void mouseClicked(MouseEvent e) {
				windowTitle.setText("Informes");
				if(selected2==1) {
					String SQL = miModelo.getSQLinforme1();
					table.setModel(miModelo.getTabla(SQL));
					mostrarPanelInformes();
					lblTituloInformes.setVisible(true);
					lblTituloInformes.setText("Informe alumnos por tutor");
					informeBTN.setEnabled(false);
				}else if(selected2==2) {
					String SQL = miModelo.getSQLinforme2();
					table.setModel(miModelo.getTabla(SQL));
					mostrarPanelInformes();
					lblTituloInformes.setVisible(true);
					lblTituloInformes.setText("Informe tutores por ciclo");
					informeBTN.setEnabled(false);
				}else if(selected2==3) {
					String SQL = miModelo.getSQLinforme3();
					table.setModel(miModelo.getTabla(SQL));
					mostrarPanelInformes();
					lblTituloInformes.setVisible(true);
					lblTituloInformes.setText("Informe alumnos por empresa");
					informeBTN.setEnabled(false);
				}else if(selected2==4) {
					String SQL = miModelo.getSQLinforme4();
					table.setModel(miModelo.getTabla(SQL));
					mostrarPanelInformes();
					lblTituloInformes.setVisible(true);
					lblTituloInformes.setText("Informe alumnos en prácticas");
					informeBTN.setEnabled(false);
				}else if(selected2==5) {
					String SQL = miModelo.getSQLinforme5();
					table.setModel(miModelo.getTabla(SQL));
					mostrarPanelInformes();
					lblTituloInformes.setVisible(true);
					lblTituloInformes.setText("Informe general FCT");
					informeBTN.setEnabled(false);
				}else if(selected2==6) {
					String SQL = miModelo.getSQLinforme6();
					table.setModel(miModelo.getTabla(SQL));
					mostrarPanelInformes();
					lblTituloInformes.setVisible(true);
					lblTituloInformes.setText("Informe Aseguradoras");
					informeBTN.setEnabled(false);
				}
				
			}
		});
		informeBTN.setBounds(44, 576, 147, 23);
		getContentPane().add(informeBTN);
		informeBTN.setIcon(new ImageIcon(img_ButtonVer));


		panelGrafos = new JPanel();
		panelGrafos.setBackground(Color.WHITE);
		panelGrafos.setBounds(44, 103, 785, 460);
		getContentPane().add(panelGrafos);

		windowTitle = new JLabel("Estadisticas");
		windowTitle.setForeground(Color.WHITE);
		windowTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		windowTitle.setBounds(389, 12, 105, 14);
		getContentPane().add(windowTitle);

//		Background Image ========================
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 888, 664);
		getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));
//		FRAME LOCATION ==========================
		setLocationRelativeTo(null);

	}
	public void mostrarPanelInformes() {
		panelGrafos.setVisible(false);
		panelInformes.setVisible(true);
		lblCerrarInforme.setVisible(true);
		informeCerrarBTN.setVisible(true);
		lblGrafica.setVisible(false);
		FilterComboBox2.setVisible(false);
		lblTipo.setVisible(false);
		FilterComboBox.setVisible(false);
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
	public void actualizarPanel6() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularPanelAlumnosTutor(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel7() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanelAlumnosTutor(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel8() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularPanelTutoresCiclo(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel9() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanelTutoresCiclo(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel10() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularPanelAlumnosEmpresa(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel11() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanelAlumnosEmpresa(), BorderLayout.CENTER);
		panelGrafos.validate();
	}

	public void actualizarPanel12() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getCircularPanelAseguradoras(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
	public void actualizarPanel13() {
		panelGrafos.removeAll();
		panelGrafos.add(miModelo.getBarPanelAseguradoras(), BorderLayout.CENTER);
		panelGrafos.validate();
	}
}

