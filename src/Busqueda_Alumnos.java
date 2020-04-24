import java.awt.Color;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class Busqueda_Alumnos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton ModifyBtn;
	private JButton DeleteBtn;
	private JTextField SearchField;
	// Setting images
	private Image img_buttonBack1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image img_buttonBack2 = new ImageIcon(getClass().getResource("/images/back2.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image img_buttonBack3 = new ImageIcon(getClass().getResource("/images/back3.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);

	private controlador miControlador;
	private modelo miModelo;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Busqueda_Alumnos() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 888, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane TableView = new JScrollPane();
		TableView.setBounds(10, 137, 852, 443);
		contentPane.add(TableView);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { "Benjamin", "Buford", "1" }, { "Dan", "Taylor", "1" },
								{ "Jules", "Winnfield", "1" }, { "Vito", "Corleone", "2" }, { "Marty", "McFly", "2" },
								{ "Vincent", "Vega", "2" }, { "Mia", "Wallace", "3" }, { "Nicky", "Koskoff", "3" },
								{ "Donnie", "Azoff", "3" }, { "Kirk", "Lazarus", "4" }, { "Less", "Grossman", "4" },
								{ "Alpa", "Chino", "4" }, { "Tugg", "Speedman", "5" }, { "Carole", "Baskin", "5" },
								{ "Joe", "Exotic", "5" }, { "Doc", "Antle", "5" }, },
						new String[] { "NOMBRE", "APELLIDO", "CENTRO" }));
		TableView.setViewportView(table);

		JButton CreateNewBtn = new JButton("Nuevo Alumno");
		CreateNewBtn.setForeground(Color.WHITE);
		CreateNewBtn.setBackground(Color.DARK_GRAY);
		CreateNewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.nuevoTutor();
			}
		});
		CreateNewBtn.setBounds(740, 591, 122, 23);
		contentPane.add(CreateNewBtn);

		ModifyBtn = new JButton("Modificar");
//		ModifyBtn.setIcon(new ImageIcon(img_buttonModify1));
		ModifyBtn.setForeground(Color.BLACK);
		ModifyBtn.setBackground(new Color(255, 255, 102));
		ModifyBtn.setBounds(10, 591, 89, 23);
		contentPane.add(ModifyBtn);

		DeleteBtn = new JButton("Eliminar");
		DeleteBtn.setForeground(Color.BLACK);
		DeleteBtn.setBackground(new Color(255, 0, 0));
		DeleteBtn.setBounds(109, 591, 89, 23);
		contentPane.add(DeleteBtn);

		JComboBox ViewComboBox = new JComboBox();
		ViewComboBox.setBackground(Color.GRAY);
		ViewComboBox.setForeground(Color.WHITE);
		ViewComboBox.setModel(new DefaultComboBoxModel(new String[] { "DAM-2020" }));
		ViewComboBox.setBounds(648, 104, 96, 22);
		contentPane.add(ViewComboBox);

		JButton CreateViewBtn = new JButton("Crear Vista");
		CreateViewBtn.setBackground(Color.DARK_GRAY);
		CreateViewBtn.setForeground(Color.WHITE);
		CreateViewBtn.setBounds(754, 104, 106, 23);
		contentPane.add(CreateViewBtn);

		SearchField = new JTextField();
		SearchField.setBounds(10, 103, 271, 23);
		contentPane.add(SearchField);
		SearchField.setColumns(10);

		JComboBox FilterComboBox = new JComboBox();
		FilterComboBox.setForeground(Color.WHITE);
		FilterComboBox.setBackground(Color.GRAY);
		FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Centro" }));
		FilterComboBox.setBounds(367, 103, 71, 22);
		contentPane.add(FilterComboBox);

		JLabel FilterbyLbl = new JLabel("Filter by:");
		FilterbyLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		FilterbyLbl.setBounds(309, 107, 62, 14);
		contentPane.add(FilterbyLbl);
//	Copy pasta onto other Busquedas
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
				miControlador.logout9();
			}
		});
		BackBtn.setBounds(10, 11, 57, 23);
		contentPane.add(BackBtn);
		BackBtn.setIcon(new ImageIcon(img_buttonBack1));

		JButton LogoutBtn = new JButton("Logout");
		LogoutBtn.setBackground(Color.DARK_GRAY);
		LogoutBtn.setForeground(Color.WHITE);
		LogoutBtn.setBounds(780, 11, 82, 23);
		contentPane.add(LogoutBtn);

		JLabel UserLbl = new JLabel("John DOE SMITH");
		UserLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserLbl.setBounds(657, 10, 113, 23);
		contentPane.add(UserLbl);

		JLabel WindowTitle = new JLabel("Alumnos");
		WindowTitle.setForeground(Color.BLACK);
		WindowTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		WindowTitle.setBounds(389, 12, 82, 14);
		contentPane.add(WindowTitle);

		JButton SearchBtn = new JButton("New button");
		SearchBtn.setBounds(279, 103, 25, 23);
		contentPane.add(SearchBtn);
	}
}
