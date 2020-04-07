import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana_Login {

	JFrame frame;
	private Image img_usr = new ImageIcon(Ventana_Login.class.getResource("/img/usr.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_passwd = new ImageIcon(Ventana_Login.class.getResource("/img/passwd.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_uem = new ImageIcon(Ventana_Login.class.getResource("/img/uem2.png")).getImage().getScaledInstance(135, 135, Image.SCALE_SMOOTH);
	private Image img_buttonLogin = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin2 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton2.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin3 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton3.png")).getImage().getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_bg = new ImageIcon(Ventana_Login.class.getResource("/img/bg9.jpg")).getImage().getScaledInstance(800, 590, Image.SCALE_SMOOTH);
	private JLabel lblLogin;
	private JPasswordField passwordField;
	private JTextField textField;
	
	private controlador miControlador;
	private modelo miModelo;
	
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}
	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}
	
	public Ventana_Login() {
		frame = new JFrame();
		frame.setTitle("Acceder");
		frame.setBounds(100, 400, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 281, 215, 36);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIconUsr = new JLabel("");
		lblIconUsr.setBounds(0, 0, 40, 36);
		panel.add(lblIconUsr);
		lblIconUsr.setIcon(new ImageIcon(img_usr));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(38, 0, 177, 36);
		panel.add(textField);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(290, 352, 215, 36);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIconPasswd = new JLabel("");
		lblIconPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPasswd.setBounds(0, 0, 43, 36);
		panel_1.add(lblIconPasswd);
		lblIconPasswd.setIcon(new ImageIcon(img_passwd));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(42, 0, 173, 36);
		panel_1.add(passwordField);
		
		JLabel lblUsrText = new JLabel("USUARIO:");
		lblUsrText.setForeground(Color.WHITE);
		lblUsrText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsrText.setBounds(290, 255, 92, 20);
		frame.getContentPane().add(lblUsrText);
		
		JLabel lblPasswdText = new JLabel("CONTRASE\u00D1A:");
		lblPasswdText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPasswdText.setForeground(Color.WHITE);
		lblPasswdText.setBounds(290, 326, 118, 20);
		frame.getContentPane().add(lblPasswdText);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				miControlador.menu();
			}
		});
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(348, 427, 109, 36);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblLoginButton = new JLabel("");
		lblLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin3));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin2));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLoginButton.setIcon(new ImageIcon(img_buttonLogin));
			}
		});
		lblLoginButton.setBounds(348, 427, 118, 47);
		frame.getContentPane().add(lblLoginButton);
		lblLoginButton.setIcon(new ImageIcon(img_buttonLogin));
		
		JLabel lblIconUEM = new JLabel("");
		lblIconUEM.setBounds(332, 54, 154, 125);
		frame.getContentPane().add(lblIconUEM);
		lblIconUEM.setIcon(new ImageIcon(img_uem));
		
		JLabel lblBgColor = new JLabel("");
		lblBgColor.setBounds(0, 0, 784, 511);
		frame.getContentPane().add(lblBgColor);
		lblBgColor.setIcon(new ImageIcon(img_bg));
	}
}
