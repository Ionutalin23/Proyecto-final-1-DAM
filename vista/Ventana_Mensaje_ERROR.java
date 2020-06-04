package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controlador.controlador;
import modelo.modelo;

import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Cursor;

public class Ventana_Mensaje_ERROR extends JFrame {
//======================================= MVC ==================================
	private modelo miModelo;
	private controlador miControlador;
	
	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}
	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}
//===============================================================================
//=============================== ATTRIBUTES AND OTHERS =========================
	private Image img_bg = new ImageIcon(Ventana_Login.class.getResource("/img/bg9.jpg")).getImage()
			.getScaledInstance(500, 325, Image.SCALE_SMOOTH);
	private Image errorIcon = new ImageIcon(Ventana_Login.class.getResource("/img/error.png")).getImage()
			.getScaledInstance(65, 47, Image.SCALE_SMOOTH);
	private Image img_buttonLogin = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin2 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton2.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private Image img_buttonLogin3 = new ImageIcon(Ventana_Login.class.getResource("/img/loginbutton3.png")).getImage()
			.getScaledInstance(110, 48, Image.SCALE_SMOOTH);
	private JLabel lblBackground;
	private JLabel lblError;
	private JTextArea txtMessage;
	private JLabel lblErrorIcon;
	private JLabel lblExit;
	private JLabel lblExitBtn;
//===============================================================================
	public Ventana_Mensaje_ERROR() {
		
		lblExit = new JLabel("SALIR");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblExit.setForeground(Color.WHITE);
		lblExit.setBounds(192, 254, 109, 36);
		getContentPane().add(lblExit);
		
				lblExitBtn = new JLabel("");
				lblExitBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						lblExitBtn.setIcon(new ImageIcon(img_buttonLogin3));
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						lblExitBtn.setIcon(new ImageIcon(img_buttonLogin2));
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						lblExitBtn.setIcon(new ImageIcon(img_buttonLogin2));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						lblExitBtn.setIcon(new ImageIcon(img_buttonLogin));
					}

					public void mouseClicked(MouseEvent e) {
						miControlador.closeSystem();
						
					}
				});
				lblExitBtn.setBounds(192, 255, 118, 48);
				getContentPane().add(lblExitBtn);
				lblExitBtn.setIcon(new ImageIcon(img_buttonLogin));
		
		lblErrorIcon = new JLabel("");
		lblErrorIcon.setIcon(new ImageIcon(errorIcon));
		lblErrorIcon.setBounds(97, 24, 65, 47);
		getContentPane().add(lblErrorIcon);
		
		txtMessage = new JTextArea();
		txtMessage.setOpaque(false);
		txtMessage.setForeground(Color.WHITE);
		txtMessage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtMessage.setEditable(false);
		txtMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMessage.setBackground(new Color(255, 255, 255, 150));
		txtMessage.setText("    PARECE QUE HAS INTRODUCIDO LA CONTRASE\u00D1A\r\n Y EL USUARIO ERR\u00D3NEOS TRES VECES CONSECUTIVAS...\r\n\r\n Por su seguridad y la de la aplicaci\u00F3n, se proceder\u00E1\r\n             el cierre autom\u00E1tico de la misma.\n");
		txtMessage.setBounds(39, 109, 420, 110);
		getContentPane().add(txtMessage);
		
		lblError = new JLabel("Oops.... :/");
		lblError.setForeground(Color.WHITE);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblError.setBounds(119, 24, 272, 47);
		getContentPane().add(lblError);
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, -17, 482, 342);
		lblBackground.setIcon(new ImageIcon(img_bg));
		getContentPane().add(lblBackground);
//		POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setTitle("ERROR");
		setBounds(100, 400, 500, 363);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		
		
	}
}
