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

public class Ventana_Conf_Delete extends JFrame {
	// ======================================= MVC
	// ==================================
	private modelo miModelo;
	private controlador miControlador;

	public void setModelo(modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setControlador(controlador miControlador) {
		this.miControlador = miControlador;
	}

	// ===============================================================================
	// =============================== ATTRIBUTES AND OTHERS
	// =========================
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
	private JLabel lblseg;
	private JTextArea txtMessage;
	private JLabel lblNO;
	private JLabel lblNOBtn;

	// ===============================================================================
	public Ventana_Conf_Delete() {

// BOTON NO
		lblNO = new JLabel("NO");
		lblNO.setHorizontalAlignment(SwingConstants.CENTER);
		lblNO.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNO.setForeground(Color.WHITE);
		lblNO.setBounds(310, 254, 109, 36);
		getContentPane().add(lblNO);

		lblNOBtn = new JLabel("");
		lblNOBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblNOBtn.setIcon(new ImageIcon(img_buttonLogin3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblNOBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNOBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNOBtn.setIcon(new ImageIcon(img_buttonLogin));
			}

			public void mouseClicked(MouseEvent e) {
				setVisible(false);

			}
		});
		lblNOBtn.setBounds(310, 255, 118, 48);
		getContentPane().add(lblNOBtn);
		lblNOBtn.setIcon(new ImageIcon(img_buttonLogin));
	
//BOTON SI
		
		JLabel lblSI = new JLabel("SI");
		lblSI.setHorizontalAlignment(SwingConstants.CENTER);
		lblSI.setForeground(Color.WHITE);
		lblSI.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblSI.setBounds(71, 254, 109, 36);
		getContentPane().add(lblSI);
		
		JLabel lblSIBtn = new JLabel("");
		lblSIBtn.setBounds(71, 255, 118, 48);
		getContentPane().add(lblSIBtn);
		
		lblSIBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblSIBtn.setIcon(new ImageIcon(img_buttonLogin3));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblSIBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSIBtn.setIcon(new ImageIcon(img_buttonLogin2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSIBtn.setIcon(new ImageIcon(img_buttonLogin));
			}

			public void mouseClicked(MouseEvent e) {
				miModelo.borrarDato(miModelo.getClave(),miModelo.getNombreTabla(), miModelo.getNombreClave());
				setVisible(false);

			}
		});
		lblSIBtn.setIcon(new ImageIcon(img_buttonLogin));
		
//CAMPO DE TEXTO
		
		txtMessage = new JTextArea();
		txtMessage.setOpaque(false);
		txtMessage.setForeground(Color.BLACK);
		txtMessage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtMessage.setEditable(false);
		txtMessage.setFont(new Font("Century Gothic", Font.BOLD, 14));
		txtMessage.setBackground(new Color(255, 255, 255, 150));
		txtMessage.setText(
				"    Parece que quieres eliminar un dato. ¿Estas seguro?");
		txtMessage.setBounds(49, 109, 379, 110);
		getContentPane().add(txtMessage);

		lblseg = new JLabel("\u00BFEst\u00E1s Seguro?");
		lblseg.setForeground(Color.WHITE);
		lblseg.setHorizontalAlignment(SwingConstants.CENTER);
		lblseg.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblseg.setBounds(119, 24, 272, 47);
		getContentPane().add(lblseg);
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, -17, 482, 342);
		lblBackground.setIcon(new ImageIcon(img_bg));
		getContentPane().add(lblBackground);
//POSICIONAR VENTANA EN EL CENTRO DE LA PANTALLA
		setTitle("ERROR");
		setBounds(100, 400, 500, 363);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

	}
}
