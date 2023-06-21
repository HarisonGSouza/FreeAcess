package com.freeacess.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.freeacess.dao.LoginDAO;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	Boolean exist_on_db;
	Integer cache_id_user;
	HashMap<Boolean, Integer> hm;
	public static final int H_FRAME = 360;
	public static final int W_FRAME = 540;
	private JPanel contentPane;
	private JButton button_login;
	private JButton button_primeiro_acesso;
	private JLabel label_username, label_password, label_icon, label_errorText;
	private JTextField textField_username;
	private JPasswordField passwordField_password;
	private Insets insets;
	String errorText = "Usuário ou Senha incorreto";

	public Login() {

		super("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
			"freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-133426253(1).png"));
			// setResizable(false);
		setLayout(null);
		setSize(W_FRAME, H_FRAME);
		setLocationRelativeTo(null);
		setLocation(getX() - 80, getY() - 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		insets = this.getInsets();

		GUI();

	}

	private void GUI() {

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
				H_FRAME - insets.bottom - insets.top);

		label_username = new JLabel("Usuário:");
		label_username.setFont(new Font("Bold", Font.PLAIN, 14));
		label_username.setBounds(110, 140, 80, 20);
		contentPane.add(label_username);

		label_password = new JLabel("Senha:");
		label_password.setFont(label_username.getFont());
		label_password.setBounds(label_username.getX(), label_username.getY() + 40, label_username.getWidth(),
				label_username.getHeight());
		contentPane.add(label_password);

		textField_username = new JTextField();
		textField_username.setBounds(label_username.getX() + label_username.getWidth() + 40, label_username.getY(), 130,
				label_username.getHeight());
		textField_username.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordField_password.requestFocus();
			}
		});
		contentPane.add(textField_username);

		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(textField_username.getX(), label_password.getY(), 130,
				label_password.getHeight());
		passwordField_password.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_login.doClick();
			}
		});
		contentPane.add(passwordField_password);

        button_login = new JButton("Login");
        button_login.setBounds(textField_username.getX() + 20, label_username.getY() + 80, 80, 22);
        button_login.setFocusPainted(false);
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                if(textField_username.getText().equals("") || String.valueOf(passwordField_password.getPassword()).equals("")) {
                    
                    label_errorText.setText(errorText);
                
                } else {
                    
                    label_errorText.setText("");
                    LoginDAO loginDAO = new LoginDAO();
					hm = loginDAO.verifyLogin(textField_username.getText(), String.valueOf(passwordField_password.getPassword()));
					
					for(Map.Entry<Boolean, Integer> m:hm.entrySet()) {
						exist_on_db = m.getKey();
						cache_id_user = m.getValue();
					}

                    if(exist_on_db) {
                        JOptionPane.showMessageDialog(contentPane, "Login realizado com sucesso!", "Login", 
                                JOptionPane.INFORMATION_MESSAGE);
                        
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                Login.this.dispose();
                                new MainMenu(cache_id_user);
                            }
                        });
                        
                    } else {
                        label_errorText.setText(errorText);
                    }
                    
                }
                
            }
        });
        contentPane.add(button_login);

		button_primeiro_acesso = new JButton("Cadastre-se");
		button_primeiro_acesso.setBounds(textField_username.getX(), button_login.getY() + 30, 130, 22);
		button_primeiro_acesso.setFocusPainted(false);
		button_primeiro_acesso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						new RegisterPeople();
					}
				});

			}

		});
		contentPane.add(button_primeiro_acesso);

		label_icon = new JLabel(new ImageIcon(
			"freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-133426253(1).png"));
			label_icon.setBounds(textField_username.getX() - 10, textField_username.getY() - 120, 148, 108);
		contentPane.add(label_icon);

		label_errorText = new JLabel();
		label_errorText.setForeground(Color.RED);
		label_errorText.setBounds(218, button_login.getY() + 50, 160, 30);
		label_errorText.setFont(new Font("Tahoma", Font.PLAIN + Font.BOLD, 11));
		contentPane.add(label_errorText);

		setContentPane(contentPane);

	}

}