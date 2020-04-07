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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda_Alumnos frame = new Busqueda_Alumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda_Alumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 766, 243);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(654, 477, 122, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 477, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(109, 477, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DAM-2020"}));
		comboBox.setBounds(564, 189, 96, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_3 = new JButton("Crear Vista");
		btnNewButton_3.setBounds(670, 189, 106, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(191, 103, 296, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Centro"}));
		comboBox_1.setBounds(546, 103, 71, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Filter by:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(492, 107, 62, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.setBounds(347, 137, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("BUSQUEDA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(191, 74, 106, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_5 = new JButton("<-");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(10, 11, 57, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setBounds(692, 11, 82, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("John DOE SMITH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(580, 10, 113, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(351, 15, 82, 14);
		contentPane.add(lblNewLabel_3);
	}
}
