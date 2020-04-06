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
	private MenuControlador controlador;
	private MenuModelo modelo;
	private JLabel lblAnexos;

	public MenuVista() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		getContentPane().setBounds(100, 400, 800, 550);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 613);
		getContentPane().setLayout(null);

		JPanel pnlMed = new JPanel();
		pnlMed.setBackground(SystemColor.textHighlightText);
		pnlMed.setBounds(181, 0, 363, 566);
		getContentPane().add(pnlMed);
		pnlMed.setLayout(null);

		JPanel pnlBtnAnx = new JPanel();
		pnlBtnAnx.setBounds(39, 217, 283, 27);
		pnlMed.add(pnlBtnAnx);
		pnlBtnAnx.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(43, 43, 43), null, null, null));
		pnlBtnAnx.setBackground(new Color(89, 89, 89));
		pnlBtnAnx.setLayout(null);

		lblAnexos = new JLabel("Anexos");
		lblAnexos.setBounds(0, 0, 283, 27);
		pnlBtnAnx.add(lblAnexos);
		lblAnexos.setBackground(new Color(205, 92, 92));
		lblAnexos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexos.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblAnexos.setForeground(new Color(255, 255, 255));

		lblAnexos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnAnx.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnAnx.setBackground(new Color(89, 89, 89));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnAnx.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnAnx.setBackground(new Color(128, 128, 128));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				PruebaVista vista = new PruebaVista();
//				MenuControlador.CambiarPantalla(vista);
//			}
		});

		JPanel pnlBtnTuto = new JPanel();
		pnlBtnTuto.setLayout(null);
		pnlBtnTuto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(43, 43, 43), null, null, null));
		pnlBtnTuto.setBackground(new Color(89, 89, 89));
		pnlBtnTuto.setBounds(39, 285, 283, 27);
		pnlMed.add(pnlBtnTuto);

		JLabel lblTuto = new JLabel("Tutores");
		lblTuto.setBounds(0, 0, 283, 27);
		pnlBtnTuto.add(lblTuto);
		lblTuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuto.setForeground(Color.WHITE);
		lblTuto.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblTuto.setBackground(new Color(43, 43, 43));

		lblTuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnTuto.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnTuto.setBackground(new Color(89, 89, 89));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnTuto.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnTuto.setBackground(new Color(128, 128, 128));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Ventana_Admin admin = new Ventana_Admin();
//				admin.setVisible(true);
//				admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				dispose();
//			}
		});

		JPanel pnlBtnEmp = new JPanel();
		pnlBtnEmp.setLayout(null);
		pnlBtnEmp.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(43, 43, 43), null, null, null));
		pnlBtnEmp.setBackground(new Color(89, 89, 89));
		pnlBtnEmp.setBounds(39, 357, 283, 27);
		pnlMed.add(pnlBtnEmp);

		JLabel lblEmp = new JLabel("Empresas");
		lblEmp.setBounds(0, 0, 283, 27);
		pnlBtnEmp.add(lblEmp);
		lblEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmp.setForeground(Color.WHITE);
		lblEmp.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblEmp.setBackground(new Color(43, 43, 43));

		lblEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnEmp.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnEmp.setBackground(new Color(89, 89, 89));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnEmp.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnEmp.setBackground(new Color(128, 128, 128));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Ventana_Admin admin = new Ventana_Admin();
//				admin.setVisible(true);
//				admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				dispose();
//			}
		});

		JPanel pnlBtnAl = new JPanel();
		pnlBtnAl.setLayout(null);
		pnlBtnAl.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(43, 43, 43), null, null, null));
		pnlBtnAl.setBackground(new Color(89, 89, 89));
		pnlBtnAl.setBounds(39, 426, 283, 27);
		pnlMed.add(pnlBtnAl);

		JLabel lblAl = new JLabel("Alumnos");
		lblAl.setBounds(0, 0, 283, 27);
		pnlBtnAl.add(lblAl);
		lblAl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAl.setForeground(Color.WHITE);
		lblAl.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblAl.setBackground(new Color(43, 43, 43));

		lblAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnAl.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnAl.setBackground(new Color(89, 89, 89));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnAl.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnAl.setBackground(new Color(128, 128, 128));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Ventana_Admin admin = new Ventana_Admin();
//				admin.setVisible(true);
//				admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				dispose();
//			}
		});

		JPanel pnlBtnGrup = new JPanel();
		pnlBtnGrup.setLayout(null);
		pnlBtnGrup.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(43, 43, 43), null, null, null));
		pnlBtnGrup.setBackground(new Color(89, 89, 89));
		pnlBtnGrup.setBounds(39, 496, 283, 27);
		pnlMed.add(pnlBtnGrup);

		JLabel lblGrup = new JLabel("Grupos");
		lblGrup.setBounds(0, 0, 283, 27);
		pnlBtnGrup.add(lblGrup);
		lblGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrup.setForeground(Color.WHITE);
		lblGrup.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblGrup.setBackground(new Color(43, 43, 43));

		lblGrup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnGrup.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnGrup.setBackground(new Color(89, 89, 89));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnGrup.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnGrup.setBackground(new Color(128, 128, 128));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Ventana_Admin admin = new Ventana_Admin();
//				admin.setVisible(true);
//				admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				dispose();
//			}
		});

		JPanel pnlBtnLgo = new JPanel();
		pnlBtnLgo.setBounds(543, 0, 139, 27);
		getContentPane().add(pnlBtnLgo);
		pnlBtnLgo.setLayout(null);
		pnlBtnLgo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(43, 43, 43), null, null, null));
		pnlBtnLgo.setBackground(new Color(89, 89, 89));

		JLabel lblALgo = new JLabel("Logout");
		lblALgo.setBounds(0, 0, 139, 27);
		pnlBtnLgo.add(lblALgo);
		lblALgo.setHorizontalAlignment(SwingConstants.CENTER);
		lblALgo.setForeground(Color.WHITE);
		lblALgo.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblALgo.setBackground(new Color(43, 43, 43));

		lblALgo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLgo.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLgo.setBackground(new Color(89, 89, 89));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLgo.setBackground(new Color(128, 128, 128));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLgo.setBackground(new Color(128, 128, 128));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Ventana_Admin admin = new Ventana_Admin();
//				admin.setVisible(true);
//				admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				dispose();
//			}
		});

		JLabel lblmsg = new JLabel("Logged as: Pedro Camacho");
		lblmsg.setForeground(SystemColor.textHighlightText);
		lblmsg.setHorizontalAlignment(SwingConstants.TRAILING);
		lblmsg.setBounds(0, 0, 157, 27);
		getContentPane().add(lblmsg);

		JLabel lblBg = new JLabel("");
		lblBg.setForeground(SystemColor.window);
		lblBg.setIcon(null);
		lblBg.setBackground(new Color(43, 43, 43));
		lblBg.setBounds(0, 0, 682, 566);
		getContentPane().add(lblBg);

		JLabel lblProf = new JLabel("");
		lblProf.setBounds(100, 26, 166, 148);
		pnlMed.add(lblProf);
		lblProf.setIcon(new ImageIcon(MenuVista.class.getResource("/img/img.png")));

	}

	public void setControlador(MenuControlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(MenuModelo modelo) {
		this.modelo = modelo;
	}
}
