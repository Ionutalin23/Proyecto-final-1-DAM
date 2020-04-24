import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Busqueda_Anexos extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTable table;
	private JButton ModifyBtn;
	private JButton DeleteBtn;
	private JTextField SearchField;

	private controlador miControlador;
	private modelo miModelo;

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Busqueda_Anexos() {
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
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Benjamin", "Buford", "Completado" }, { "Dan", "Taylor", "Completado" },
						{ "Jules", "Winnfield", "Completado" }, { "Vito", "Corleone", "Completado" },
						{ "Marty", "McFly", "Completado" }, { "Vincent", "Vega", "Completado" },
						{ "Mia", "Wallace", "Completado" }, { "Nicky", "Koskoff", "Completado" },
						{ "Donnie", "Azoff", "Completado" }, { "Kirk", "Lazarus", "Completado" },
						{ "Less", "Grossman", "Incompleto" }, { "Alpa", "Chino", "Incompleto" },
						{ "Tugg", "Speedman", "Incompleto" }, { "Carole", "Baskin", "Incompleto" },
						{ "Joe", "Exotic", "Incompleto" }, { "Doc", "Antle", "Incompleto" }, },
				new String[] { "NOMBRE", "APELLIDO", "ANEXO 1" }));
		TableView.setViewportView(table);

		ModifyBtn = new JButton("Modificar");
		ModifyBtn.setForeground(Color.BLACK);
		ModifyBtn.setBackground(new Color(255, 255, 102));
		ModifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		FilterComboBox.setModel(new DefaultComboBoxModel(new String[] { "Anexo 1", "Nombre", "Apellido" }));
		FilterComboBox.setBounds(367, 103, 71, 22);
		contentPane.add(FilterComboBox);

		JLabel FilterbyLbl = new JLabel("Filter by:");
		FilterbyLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		FilterbyLbl.setBounds(309, 107, 62, 14);
		contentPane.add(FilterbyLbl);

		JButton BackBtn = new JButton("<-");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.back4();
			}
		});
		BackBtn.setForeground(Color.WHITE);
		BackBtn.setBackground(Color.GRAY);
		BackBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		BackBtn.setBounds(10, 11, 57, 23);
		contentPane.add(BackBtn);

		JButton LogoutBtn = new JButton("Logout");
		LogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.logout5();
			}
		});
		LogoutBtn.setBackground(Color.DARK_GRAY);
		LogoutBtn.setForeground(Color.WHITE);
		LogoutBtn.setBounds(780, 11, 82, 23);
		contentPane.add(LogoutBtn);

		JLabel UserLbl = new JLabel("John DOE SMITH");
		UserLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserLbl.setBounds(657, 10, 113, 23);
		contentPane.add(UserLbl);

		JLabel WindowTitle = new JLabel("Anexos");
		WindowTitle.setForeground(Color.BLACK);
		WindowTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		WindowTitle.setBounds(400, 12, 71, 14);
		contentPane.add(WindowTitle);

		JButton SearchBtn = new JButton("New button");
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SearchBtn.setBounds(279, 103, 25, 23);
		contentPane.add(SearchBtn);
	}
}
