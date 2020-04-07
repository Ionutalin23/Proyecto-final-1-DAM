import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.border.Border;

import java.awt.SystemColor;

public class MenuVista extends JFrame {
	private controlador controlador;
	private modelo modelo;
	private JLabel lblAnexos; 

	public MenuVista() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setBounds(100, 400, 800, 550);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 613);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JPanel pnlMed = new JPanel();
		pnlMed.setBounds(181, 0, 363, 566);
		pnlMed.setBackground(SystemColor.textHighlightText);
		getContentPane().add(pnlMed);
		pnlMed.setLayout(null);

		lblAnexos = new JLabel("Anexos");
		lblAnexos.setBounds(39, 217, 283, 27);
		pnlMed.add(lblAnexos);
		lblAnexos.setBackground(new Color(205, 92, 92));
		lblAnexos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexos.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblAnexos.setForeground(new Color(255, 255, 255));

		JLabel lblAnxBtn = new JLabel("");
		lblAnxBtn.setBounds(39, 217, 283, 27);
		pnlMed.add(lblAnxBtn);
		lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblAnxBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblAnxBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Anexos vista = new Busqueda_Anexos();
//				controlador.CambiarPantalla(vista);
//			}
		});

		JLabel lblTuto = new JLabel("Tutores");
		lblTuto.setBounds(39, 284, 283, 27);
		pnlMed.add(lblTuto);
		lblTuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuto.setForeground(Color.WHITE);
		lblTuto.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblTuto.setBackground(new Color(43, 43, 43));

		JLabel lblTutoBtn = new JLabel("");
		lblTutoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Tutores vista = new Busqueda_Tutores();
//				controlador.CambiarPantalla(vista);
//			}
		});

		lblTutoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblTutoBtn.setBounds(39, 284, 283, 27);
		pnlMed.add(lblTutoBtn);

		JLabel lblEmp = new JLabel("Empresas");
		lblEmp.setBounds(39, 347, 283, 27);
		pnlMed.add(lblEmp);
		lblEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmp.setForeground(Color.WHITE);
		lblEmp.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblEmp.setBackground(new Color(43, 43, 43));

		JLabel lblEmpBtn = new JLabel("");
		lblEmpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Empresas vista = new Busqueda_Empresas();
//				controlador.CambiarPantalla(vista);
//			}
		});

		lblEmpBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblEmpBtn.setBounds(39, 347, 283, 27);
		pnlMed.add(lblEmpBtn);

		JLabel lblAl = new JLabel("Alumnos");
		lblAl.setBounds(39, 412, 283, 27);
		pnlMed.add(lblAl);
		lblAl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAl.setForeground(Color.WHITE);
		lblAl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblAl.setBackground(new Color(43, 43, 43));

		JLabel lblAlmnBtn = new JLabel("");
		lblAlmnBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Alumnos vista = new Busqueda_Alumnos();
//				controlador.CambiarPantalla(vista);
//			}
		});

		lblAlmnBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblAlmnBtn.setBounds(39, 412, 283, 27);
		pnlMed.add(lblAlmnBtn);

		JLabel lblProf = new JLabel("");
		lblProf.setBounds(100, 26, 166, 148);
		pnlMed.add(lblProf);
		lblProf.setIcon(new ImageIcon(MenuVista.class.getResource("/img/img.png")));

		JLabel lblGrup = new JLabel("Grupos");
		lblGrup.setBounds(39, 481, 283, 27);
		pnlMed.add(lblGrup);
		lblGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrup.setForeground(Color.WHITE);
		lblGrup.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblGrup.setBackground(new Color(43, 43, 43));

		JLabel lblGrupBtn = new JLabel("");
		lblGrupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Busqueda_Grupos vista = new Busqueda_Grupos();
//				controlador.CambiarPantalla(vista);
//			}
		});

		lblGrupBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/Btn.png")));
		lblGrupBtn.setBounds(39, 481, 283, 27);
		pnlMed.add(lblGrupBtn);

		JLabel lblALgo = new JLabel("Logout");
		lblALgo.setBounds(543, 0, 139, 27);
		getContentPane().add(lblALgo);
		lblALgo.setHorizontalAlignment(SwingConstants.CENTER);
		lblALgo.setForeground(Color.WHITE);
		lblALgo.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblALgo.setBackground(new Color(43, 43, 43));
		
		JLabel lblLgoBtn = new JLabel("");
		lblLgoBtn.setBounds(546, 0, 136, 27);
		lblLgoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLgoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/BtnLgo2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLgoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/BtnLgo.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblLgoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/BtnLgo3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblLgoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/BtnLgo.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.logout();
			}
		});

		
		lblLgoBtn.setIcon(new ImageIcon(MenuVista.class.getResource("/img/BtnLgo.png")));
		getContentPane().add(lblLgoBtn);
		
		JLabel lblmsg = new JLabel("Logged as: Pedro Camacho");
		lblmsg.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblmsg.setForeground(SystemColor.textHighlightText);
		lblmsg.setHorizontalAlignment(SwingConstants.TRAILING);
		lblmsg.setBounds(-9, 0, 178, 27);
		getContentPane().add(lblmsg);
		
		JLabel lblICO = new JLabel("");
		lblICO.setBounds(0, 510, 185, 56);
		lblICO.setIcon(new ImageIcon(MenuVista.class.getResource("/img/logo_uem.png")));
		getContentPane().add(lblICO);

		JLabel lblBg = new JLabel("");
		lblBg.setForeground(SystemColor.window);
		lblBg.setIcon(null);
		lblBg.setBackground(new Color(255, 99, 71));
		lblBg.setBounds(10, 0, 682, 566);
		getContentPane().add(lblBg);


	}

	public void setControlador(controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(modelo modelo) {
		this.modelo = modelo;
	}
}
