package vista;

import java.awt.Color;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.controlador;
import modelo.modelo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Busqueda_Anexos extends JFrame {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	// GUI Content ========================
	private JPanel contentPane;
	private JTable table;
	private JTextField SearchField;
	private JLabel lblLogout;
	private JLabel ModifyBtn;
	private JLabel ModifyLbl;
	private JLabel DeleteBtn;
	private JLabel DeleteLbl;
	private JLabel DownloadBtn;
	private JLabel DownloadLbl;
	private JLabel CreateViewLbl;
	private JLabel CreateViewBtn;
	private JLabel CreateNewLbl;
	private JLabel CreateNewBtn;
	private JLabel SearchBtn;
	private JLabel lblUser;

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
	private JComboBox FilterComboBox;
	private JLabel DeleteBtn_1;
	private JLabel CargarLbl;
	private JLabel CargarBtn;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

//	Frame ========================
	public Busqueda_Anexos() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 888, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setLocationRelativeTo(null);
		
		
// 		Download button ============================	
		DownloadLbl = new JLabel("Descargar");
		DownloadLbl.setHorizontalAlignment(SwingConstants.CENTER);
		DownloadLbl.setBounds(754, 591, 82, 23);
		DownloadLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		DownloadLbl.setForeground(Color.BLACK);
		contentPane.add(DownloadLbl);
		
		DownloadBtn = new JLabel("");
		DownloadBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DownloadBtn.setIcon(new ImageIcon(img_ButtonEliminarHover));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DownloadBtn.setIcon(new ImageIcon(img_ButtonEliminar));
			}

			public void mouseClicked(MouseEvent e) {
				JTable tabla= getTable();
				miControlador.saveTable(tabla);
			}
		});
		DownloadBtn.setBounds(750, 591, 89, 23);
		contentPane.add(DownloadBtn);
		DownloadBtn.setIcon(new ImageIcon(img_ButtonEliminar));
		
// 		LOGGED PANEL

		lblUser = new JLabel("Logged as: Pedro Camacho");
		lblUser.setBounds(560, 7, 208, 27);
		contentPane.add(lblUser);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);

//		Table View ========================
		JScrollPane TableView = new JScrollPane();
		TableView.setBounds(10, 137, 852, 443);
		contentPane.add(TableView);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableView.setViewportView(table);

		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String SQL = miModelo.getSQLanexo1();
				table.setModel(miModelo.getTabla(SQL));
			}
		});

		// Modify Table Button ========================
		ModifyLbl = new JLabel("Modificar");
		ModifyLbl.setBounds(29, 591, 62, 23);
		ModifyLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		ModifyLbl.setForeground(Color.BLACK);
		contentPane.add(ModifyLbl);

		ModifyBtn = new JLabel("");
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
				// ADD METHOD FOR MODIFYING SELECTED CELL
			}
		});
		ModifyBtn.setBounds(10, 591, 89, 23);
		contentPane.add(ModifyBtn);
		ModifyBtn.setIcon(new ImageIcon(img_ButtonModificar));
		
//		DELETE BUTTON=========================================
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
			}
		});
		DeleteBtn.setBounds(111, 591, 89, 23);
		contentPane.add(DeleteBtn);
		DeleteBtn.setIcon(new ImageIcon(img_ButtonEliminar));

//		View Combo Box ========================
		JComboBox ViewComboBox = new JComboBox();
		ViewComboBox.setBackground(Color.GRAY);
		ViewComboBox.setForeground(Color.WHITE);
		ViewComboBox.setModel(new DefaultComboBoxModel(new String[] { "DAM-2020" }));
		ViewComboBox.setBounds(648, 104, 96, 22);
		contentPane.add(ViewComboBox);

//		Create New View Button ========================
		CreateViewLbl = new JLabel("Crear Vista");
		CreateViewLbl.setBounds(775, 104, 71, 23);
		CreateViewLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		CreateViewLbl.setForeground(Color.BLACK);
		contentPane.add(CreateViewLbl);

		CreateViewBtn = new JLabel("");
		CreateViewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CreateViewBtn.setIcon(new ImageIcon(img_default1ButtonHover));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CreateViewBtn.setIcon(new ImageIcon(img_default1Button));
			}

			public void mouseClicked(MouseEvent e) {
				// ADD METHOD FOR CREATING VIEW
			}
		});
		CreateViewBtn.setBounds(754, 104, 106, 23);
		contentPane.add(CreateViewBtn);
		CreateViewBtn.setIcon(new ImageIcon(img_default1Button));

//		Search Field ========================
		SearchField = new JTextField();
		SearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
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

//		Search Filter Combo Box ========================
		FilterComboBox = new JComboBox();
		FilterComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = FilterComboBox.getSelectedIndex();
				if (selected == 0) {
					String SQL = miModelo.getSQLanexo1();
					table.setModel(miModelo.getTabla(SQL));
				} else if (selected == 1) {
					String SQL = miModelo.getSQLanexo2_1();
					table.setModel(miModelo.getTabla(SQL));
				} else if (selected == 2) {
					String SQL = miModelo.getSQLanexo2_2();
					table.setModel(miModelo.getTabla(SQL));
				} else if (selected == 3) {
					String SQL = miModelo.getSQLanexo3();
					table.setModel(miModelo.getTabla(SQL));
				}else if (selected == 4) {
					String SQL = miModelo.getSQLanexo7();
					table.setModel(miModelo.getTabla(SQL));
				}else if (selected == 5) {
					String SQL = miModelo.getSQLanexo8();
					table.setModel(miModelo.getTabla(SQL));
				}
			}
		});
		FilterComboBox.setForeground(Color.WHITE);
		FilterComboBox.setBackground(Color.GRAY);
		FilterComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Anexo 1", "Anexo 2_1", "Anexo_2_2", "Anexo 3", "Anexo 7", "Anexo 8" }));
		FilterComboBox.setBounds(367, 103, 104, 22);
		contentPane.add(FilterComboBox);

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
				miControlador.back();
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
				miControlador.logout1();
			}

		});
		lblLogoutButton.setIcon(new ImageIcon(button1));
// 		Cargar btn
		
		CargarLbl = new JLabel("Cargar");
		CargarLbl.setForeground(Color.BLACK);
		CargarLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		CargarLbl.setBounds(667, 591, 62, 23);
		contentPane.add(CargarLbl);
		
		CargarBtn = new JLabel("");
		CargarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CargarBtn.setIcon(new ImageIcon(img_ButtonModificarHover));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CargarBtn.setIcon(new ImageIcon(img_ButtonModificar));
			}

			public void mouseClicked(MouseEvent e) {
				table.setModel(miModelo.CargarTabla().getModel());

			}

			
		});
		CargarBtn.setIcon(new ImageIcon(img_ButtonModificar));
		CargarBtn.setBounds(648, 591, 89, 23);
		contentPane.add(CargarBtn);

//		User Name Label ========================
		JPanel pnlUser = new JPanel();
		pnlUser.setForeground(new Color(240, 248, 255));
		pnlUser.setBackground(new Color(192, 192, 192, 190));
		pnlUser.setBounds(560, 7, 208, 27);
		getContentPane().add(pnlUser);
		pnlUser.setLayout(null);

//		Window Title ========================
		JLabel WindowTitle = new JLabel("Anexos");
		WindowTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		WindowTitle.setForeground(Color.WHITE);
		WindowTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		WindowTitle.setBounds(389, 12, 82, 23);
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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable tabla) {

		this.table = tabla;
	}
	

}
