package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.controlador;
import modelo.modelo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class Busqueda_Alumnos extends JFrame {

//	GUI Content ========================
	private JPanel contentPane;
	private JTable table;
	private JTextField SearchField;
	private JLabel lblLogout;
	private JLabel ModifyBtn;
	private JLabel ModifyLbl;
	private JLabel DeleteBtn;
	private JLabel DeleteLbl;
	private JLabel CreateNewLbl;
	private JLabel CreateNewBtn;
	private JLabel SearchBtn;
	private JLabel lblUser;
	private JLabel lblSelcc;
	private int selected;
	private int selectFilter;
	private String NomTabla = "alumno";
	private String NomClave = "num_EXP";
	private boolean modificar = false;
	private int temp = 5000;

// 	Setting Images ======================== (Check all images are linked to correct folder to avoid null pointer exception)
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
	private Image img_ButtonEliminar = new ImageIcon(getClass().getResource("/images/Btn_Eliminar.jpg")).getImage()
			.getScaledInstance(88, 23, Image.SCALE_SMOOTH);
	private Image img_ButtonEliminarHover = new ImageIcon(getClass().getResource("/images/Btn_Eliminar_Hover.jpg"))
			.getImage().getScaledInstance(88, 23, Image.SCALE_SMOOTH);
	private Image img_ButtonModificar = new ImageIcon(getClass().getResource("/images/Btn_Modificar.jpg")).getImage()
			.getScaledInstance(88, 23, Image.SCALE_SMOOTH);
	private Image img_ButtonModificarHover = new ImageIcon(getClass().getResource("/images/Btn_Modificar_Hover.jpg"))
			.getImage().getScaledInstance(88, 23, Image.SCALE_SMOOTH);
	private Image img_default1Button = new ImageIcon(getClass().getResource("/images/Btn_default1.jpg")).getImage()
			.getScaledInstance(106, 23, Image.SCALE_SMOOTH);
	private Image img_default1ButtonHover = new ImageIcon(getClass().getResource("/images/Btn_default1_Hover.jpg"))
			.getImage().getScaledInstance(106, 23, Image.SCALE_SMOOTH);
	private Image img_default2Button = new ImageIcon(getClass().getResource("/images/Btn_default3.jpg")).getImage()
			.getScaledInstance(122, 23, Image.SCALE_SMOOTH);
	private Image img_default2ButtonHover = new ImageIcon(getClass().getResource("/images/Btn_default3_Hover.jpg"))
			.getImage().getScaledInstance(122, 23, Image.SCALE_SMOOTH);
	private Image img_SearchLupa = new ImageIcon(getClass().getResource("/images/SearchIcon.png")).getImage()
			.getScaledInstance(25, 23, Image.SCALE_SMOOTH);

// 	MVC ========================
	private controlador miControlador;
	private modelo miModelo;
	private JPanel pnlUser;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

//	Frame ========================
	public Busqueda_Alumnos() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 888, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);

// 		Label MSG borrado
		lblSelcc = new JLabel("No ha seleccionado ninguna fila");
		lblSelcc.setVisible(false);
		lblSelcc.setBounds(225, 593, 426, 16);
		contentPane.add(lblSelcc);

		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setBounds(572, 7, 196, 27);
		getContentPane().add(lblUser);
		lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUser.setBackground(new Color(211, 211, 211));
		lblUser.setForeground(new Color(139, 0, 0));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		pnlUser = new JPanel();
		pnlUser.setBounds(572, 7, 196, 27);
		getContentPane().add(pnlUser);
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
				miControlador.verPerfil11();
			}
		});
		pnlUser.setForeground(new Color(255, 0, 0));
		pnlUser.setBackground(new Color(245, 245, 245));
		pnlUser.setLayout(null);

//		Table View =======================
		JScrollPane TableView = new JScrollPane();
		TableView.setBounds(10, 137, 852, 443);
		contentPane.add(TableView);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					ModifyBtn.setEnabled(true);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TableView.setViewportView(table);

		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String SQL = miModelo.getSQLalumnos2();
				table.setModel(miModelo.getTabla(SQL));
			}
		});

//		Create New Button ========================
		CreateNewLbl = new JLabel("Nuevo Alumno");
		CreateNewLbl.setBounds(763, 591, 91, 23);
		CreateNewLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		CreateNewLbl.setForeground(Color.BLACK);
		contentPane.add(CreateNewLbl);

		CreateNewBtn = new JLabel("");
		CreateNewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CreateNewBtn.setIcon(new ImageIcon(img_default2ButtonHover));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CreateNewBtn.setIcon(new ImageIcon(img_default2Button));
			}

			public void mouseClicked(MouseEvent e) {
				vasAModificar(modificar);
				miControlador.nuevoAlumno();
			}
		});
		CreateNewBtn.setBounds(740, 591, 122, 23);
		contentPane.add(CreateNewBtn);
		CreateNewBtn.setIcon(new ImageIcon(img_default2Button));

//		Modify Table Button ========================
		ModifyLbl = new JLabel("Modificar");
		ModifyLbl.setBounds(29, 591, 62, 23);
		ModifyLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		ModifyLbl.setForeground(Color.BLACK);
		contentPane.add(ModifyLbl);

		ModifyBtn = new JLabel("");
		ModifyBtn.setEnabled(false);
		ModifyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ModifyBtn.setIcon(new ImageIcon(img_ButtonModificarHover));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ModifyBtn.setIcon(new ImageIcon(img_ButtonModificar));
			}

			public void mouseClicked(MouseEvent e) {
				modificar = true;

				int seleccion = table.getSelectedRow();
				String dni = String.valueOf(table.getValueAt(seleccion, 0));
				String nombre = String.valueOf(table.getValueAt(seleccion, 1));
				String apellidos = String.valueOf(table.getValueAt(seleccion, 2));
				String expe = String.valueOf(table.getValueAt(seleccion, 3));
				String nacim = String.valueOf(table.getValueAt(seleccion, 5));
				String nacionalidad = String.valueOf(table.getValueAt(seleccion, 4));
				vasAModificar(modificar);
				miControlador.enviarDatosAlumnos(dni, nombre, apellidos, expe, nacim, nacionalidad);

			}
		});
		ModifyBtn.setBounds(10, 591, 89, 23);
		contentPane.add(ModifyBtn);
		ModifyBtn.setIcon(new ImageIcon(img_ButtonModificar));

//		Delete Button ========================
		DeleteLbl = new JLabel("Eliminar");
		DeleteLbl.setBounds(128, 591, 51, 23);
		DeleteLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		DeleteLbl.setForeground(Color.BLACK);
		contentPane.add(DeleteLbl);

		DeleteBtn = new JLabel("");
		DeleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DeleteBtn.setIcon(new ImageIcon(img_ButtonEliminarHover));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DeleteBtn.setIcon(new ImageIcon(img_ButtonEliminar));
			}

			public void mouseClicked(MouseEvent e) {
				// ADD METHOD FOR DELETING SELECTED CELL
				if (table.getSelectionModel().isSelectionEmpty()) {
					lblSelcc.setVisible(true);
				} else {
					lblSelcc.setVisible(false);
					miModelo.setClave((String) table.getValueAt(table.getSelectedRow(), 3));
					miModelo.setNombreTabla(NomTabla);
					miModelo.setNombreClave(NomClave);
					miControlador.ventana_conf_delete();

				}

			}
		});
		DeleteBtn.setBounds(109, 591, 89, 23);
		contentPane.add(DeleteBtn);
		DeleteBtn.setIcon(new ImageIcon(img_ButtonEliminar));

//		View Combo Box ========================
		JComboBox A�oAcad = new JComboBox();
		A�oAcad.setBackground(Color.GRAY);
		A�oAcad.setForeground(Color.WHITE);
		A�oAcad.setModel(new DefaultComboBoxModel(new String[] { "CURSO-2020", "CURSO-2019" }));
		A�oAcad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = A�oAcad.getSelectedIndex();
				if (selected == 0) {
					String SQL = miModelo.getSQLalumnos2();
					table.setModel(miModelo.getTabla(SQL));
				} else if (selected == 1) {
					String SQL = miModelo.getSQLalumnos();
					table.setModel(miModelo.getTabla(SQL));
				}
			}
		});
		A�oAcad.setBounds(740, 102, 122, 22);
		contentPane.add(A�oAcad);
//		Search Filter Combo Box ========================
		JComboBox FilterComboBox = new JComboBox();
		FilterComboBox.setForeground(Color.WHITE);
		FilterComboBox.setBackground(Color.GRAY);
		FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "---Selecciona---", "Nombre", "Centro" }));
		FilterComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFilter = FilterComboBox.getSelectedIndex();
				if (selectFilter == 1) {

					String SQL = miModelo.getSQLalumnos();
					table.setModel(miModelo.getTabla(SQL));
				} else if (selectFilter == 2) {
					String SQL = miModelo.getSQLalumnos();
					table.setModel(miModelo.getTabla(SQL));
				}
			}
		});
		FilterComboBox.setBounds(367, 103, 104, 22);
		contentPane.add(FilterComboBox);

//		Search Field ========================
		SearchField = new JTextField();
		SearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (selectFilter == 0) {

				} else if (selectFilter == 1) {
					String condicion = SearchField.getText();
					table.setModel(miModelo.getTablaBusquedaAnexos(miModelo.getSQAL_2BUS(), condicion));

				} else if (selectFilter == 2) {
					String condicion = SearchField.getText();
					table.setModel(miModelo.getTablaBusquedaAnexos(miModelo.getSQAL_3BUS(), condicion));
				}
			}
		});
		SearchField.setBounds(10, 103, 271, 23);
		contentPane.add(SearchField);
		SearchField.setColumns(10);

//		Search Button ========================
		SearchBtn = new JLabel("");
		SearchBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ADD METHOD FOR SEARCH
			}
		});
		SearchBtn.setBounds(282, 103, 25, 23);
		contentPane.add(SearchBtn);
		SearchBtn.setIcon(new ImageIcon(img_SearchLupa));

//		Filter By Label ========================
		JLabel FilterbyLbl = new JLabel("Filter by:");
		FilterbyLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		FilterbyLbl.setBounds(309, 107, 62, 14);
		contentPane.add(FilterbyLbl);

//		Back Button ========================
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
				miControlador.back1();
			}
		});
		BackBtn.setBounds(10, 11, 57, 23);
		contentPane.add(BackBtn);
		BackBtn.setIcon(new ImageIcon(img_buttonBack1));

//		Logout Button ========================
		lblLogout = new JLabel("LOGOUT");
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
				miControlador.logout2();
			}

		});
		lblLogoutButton.setIcon(new ImageIcon(button1));

//		Window Title ========================
		JLabel WindowTitle = new JLabel("Alumnos");
		WindowTitle.setForeground(Color.WHITE);
		WindowTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		WindowTitle.setBounds(389, 12, 82, 14);
		contentPane.add(WindowTitle);

//		Background Image ========================
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 888, 664);
		getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));
	}

	public void actualizarLogged() {
		lblUser.setText("Logged as: " + miModelo.getUSR());

	}

	public void actualizarDELETE() {
		lblSelcc.setText("Borrado realizado con �XITO");
		lblSelcc.setVisible(true);
		ActionListener ocultarLabel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblSelcc.setVisible(false);
			}
		};
		new Timer(temp, ocultarLabel).start();
	}

	public String getNombreClave() {
		return NomClave;
	}

	public void vasAModificar(boolean mod) {
		miModelo.setmodificar(mod);
	}
}
