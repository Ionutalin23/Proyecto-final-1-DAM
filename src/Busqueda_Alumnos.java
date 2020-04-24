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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;

public class Busqueda_Alumnos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField;
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 852, 357);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Benjamin", "Buford", "1"},
				{"Dan", "Taylor", "1"},
				{"Jules", "Winnfield", "1"},
				{"Vito", "Corleone", "2"},
				{"Marty", "McFly", "2"},
				{"Vincent", "Vega", "2"},
				{"Mia", "Wallace", "3"},
				{"Nicky", "Koskoff", "3"},
				{"Donnie", "Azoff", "3"},
				{"Kirk", "Lazarus", "4"},
				{"Less", "Grossman", "4"},
				{"Alpa", "Chino", "4"},
				{"Tugg", "Speedman", "5"},
				{"Carole", "Baskin", "5"},
				{"Joe", "Exotic", "5"},
				{"Doc", "Antle", "5"},
			},
			new String[] {
				"NOMBRE", "APELLIDO", "CENTRO"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Nuevo Alumno");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.nuevoAlumno();
			}
		});
		btnNewButton.setBounds(740, 591, 122, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(255, 255, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 591, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(109, 591, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DAM-2020"}));
		comboBox.setBounds(646, 190, 96, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_3 = new JButton("Crear Vista");
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(752, 190, 106, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(186, 103, 296, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setBackground(Color.GRAY);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Centro"}));
		comboBox_1.setBounds(545, 103, 71, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Filter by:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(492, 107, 62, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(391, 137, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("BUSQUEDA:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(186, 72, 106, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_5 = new JButton("<-");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.back1();
			}
		});
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(10, 11, 57, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.logout2();
			}
		});
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBounds(780, 11, 82, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("John DOE SMITH");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(657, 10, 113, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnos");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(395, 15, 82, 14);
		contentPane.add(lblNewLabel_3);
	}
}
