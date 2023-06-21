package com.freeacess.main;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.freeacess.main.menubar.AboutPage;
import com.freeacess.main.menubar.ContactPage;
import com.freeacess.main.menubar.coursesPage.HardwareCourse;
import com.freeacess.main.menubar.coursesPage.NetworkCourse;
import com.freeacess.main.menubar.coursesPage.ProgrammingLangCouse;
import com.freeacess.main.menubar.profilePage.ProfilePage;

public class MainMenu extends JFrame {

	public static final int H_FRAME = 360;
	public static final int W_FRAME = 540;
	private JPanel contentPane;
	private Insets insets;
	private Integer cache = 0;

	private static final long serialVersionUID = 1L;

	public MainMenu() {

		super("Menu");
		setLayout(null);
		setSize(W_FRAME, H_FRAME);
		setLocationRelativeTo(null);
		setLocation(getX() - 80, getY() - 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		insets = this.getInsets();

		try {
			GUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MainMenu(int cache_id_user) {

		super("Menu");
		setLayout(null);
		setSize(W_FRAME, H_FRAME);
		setLocationRelativeTo(null);
		setLocation(getX() - 80, getY() - 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		insets = this.getInsets();
		cache = cache_id_user;

		try {
			GUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void GUI() throws IOException {

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
				H_FRAME - insets.bottom - insets.top);

		BufferedImage mypicture = ImageIO
				.read(new File("freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-media.png"));
		JLabel picLabel = new JLabel(new ImageIcon(mypicture));
		picLabel.setBounds(-12, -17, 540, 360);
		contentPane.add(picLabel);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				if (JOptionPane.showConfirmDialog(contentPane,
						"Você tem certeza que quer sair?", "Fechar Sessão?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					MainMenu.this.dispose();
					new Login();

				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenu profileMenu = new JMenu("Perfil");
		JMenu coursesMenu = new JMenu("Cursos");
		JMenu aboutMenu = new JMenu("Sobre");
		JMenu contactMenu = new JMenu("Contato");

		menuBar.add(profileMenu);
		menuBar.add(coursesMenu);
		menuBar.add(aboutMenu);
		menuBar.add(contactMenu);

		JMenuItem profileAction = new JMenuItem("Perfil");
		profileAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				new ProfilePage(cache);
			}
		});

		JMenuItem exitAction = new JMenuItem("Sair");
		exitAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(contentPane,
						"Você tem certeza que quer sair?", "Fechar Sessão?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					MainMenu.this.dispose();
					new Login();
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		JMenuItem hardwareAction = new JMenuItem("Hardware");
		hardwareAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				new HardwareCourse();
			}
		});

		JMenuItem networkAction = new JMenuItem("Redes");
		networkAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				new NetworkCourse();
			}
		});

		JMenuItem programming_languageAction = new JMenuItem("Linguagens de Programação");
		programming_languageAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				new ProgrammingLangCouse();
			}
		});

		JMenuItem aboutAction = new JMenuItem("Sobre");
		aboutAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				new AboutPage();
			}
		});

		JMenuItem contactAction = new JMenuItem("Contato");
		contactAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				new ContactPage();
			}
		});

		profileMenu.add(profileAction);
		profileMenu.add(exitAction);
		coursesMenu.add(hardwareAction);
		coursesMenu.add(networkAction);
		coursesMenu.add(programming_languageAction);
		aboutMenu.add(aboutAction);
		contactMenu.add(contactAction);

		setContentPane(contentPane);
	}
}