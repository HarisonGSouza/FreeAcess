package com.freeacess.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.freeacess.dao.UserDAO;
import com.freeacess.entity.User;
import com.freeacess.entity.User.UserBuilder;

import com.freeacess.dao.EmployerDAO;
import com.freeacess.dao.TablesDbDAO;
import com.freeacess.entity.Employer;
import com.freeacess.entity.Employer.EmployerBuilder;
import com.freeacess.exception.EntityException;

public class RegisterPeople extends JFrame {

	private static final long serialVersionUID = 1L;

    public static final int H_FRAME = 405;
    public static final int W_FRAME = 540;
	private JPanel contentPane; 
	private JLabel label_full_name, label_date_birth, label_cell_phone, label_CPF, label_RG,
			label_adress_with_number_and_complement, label_email, label_username, label_password,label_errorText;
	private JTextField textField_full_name, textField_date_birth, textField_cell_phone, textField_CPF, textField_RG,
			textField_adress_with_number_and_complement, textField_email, textField_username, textField_password;
	private JButton button_save;
	private Insets insets;
	private UserBuilder user;
	private User newUserObject;
	private UserDAO userdao;
	private TablesDbDAO tablesdao;

	private EmployerBuilder employer;
	private Employer newObjectEmployer;
	private EmployerDAO employerdao;
	private Boolean createSucessUser;
	private Boolean createSucessEmployer;
	String errorText = "Preencha todos os campos";

	public RegisterPeople() {

		super("Cadastre-se");
		setLayout(null);
		setSize(W_FRAME, H_FRAME);
		setLocationRelativeTo(null);
		setLocation(getX() - 80, getY() - 80);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		insets = this.getInsets();

		GUI();
	}

	private void GUI() {

		// PANEL
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
				H_FRAME - insets.bottom - insets.top);

		// LABELS
		label_full_name = new JLabel("Nome Completo:");
		label_full_name.setFont(new Font("Bold", Font.PLAIN, 14));
		label_full_name.setBounds(30, 20, 280, 18);
		contentPane.add(label_full_name);

		label_date_birth = new JLabel("Data de Nascimento:");
		label_date_birth.setFont(label_full_name.getFont());
		label_date_birth.setBounds(label_full_name.getX(), label_full_name.getY() + 33, label_full_name.getWidth(),
				label_full_name.getHeight());
		contentPane.add(label_date_birth);

		label_CPF = new JLabel("Certificado de Pessoa Fisica (C.P.F):");
		label_CPF.setFont(label_full_name.getFont());
		label_CPF.setBounds(label_date_birth.getX(), label_date_birth.getY() + 33, label_date_birth.getWidth(),
				label_date_birth.getHeight());
		contentPane.add(label_CPF);

		label_RG = new JLabel("Registro Geral (R.G):");
		label_RG.setFont(label_full_name.getFont());
		label_RG.setBounds(label_CPF.getX(), label_CPF.getY() + 33, label_CPF.getWidth(), label_CPF.getHeight());
		contentPane.add(label_RG);

		label_adress_with_number_and_complement = new JLabel("Endereço com Número e Complemento:");
		label_adress_with_number_and_complement.setFont(label_full_name.getFont());
		label_adress_with_number_and_complement.setBounds(label_RG.getX(), label_RG.getY() + 33, label_RG.getWidth(), label_RG.getHeight());
		contentPane.add(label_adress_with_number_and_complement);

		label_cell_phone = new JLabel("Telefone Celular:");
		label_cell_phone.setFont(label_full_name.getFont());
		label_cell_phone.setBounds(label_adress_with_number_and_complement.getX(),
				label_adress_with_number_and_complement.getY() + 33, label_adress_with_number_and_complement.getWidth(),
				label_adress_with_number_and_complement.getHeight());
		contentPane.add(label_cell_phone);

		label_email = new JLabel("Email:");
		label_email.setFont(label_full_name.getFont());
		label_email.setBounds(label_cell_phone.getX(), label_cell_phone.getY() + 33, label_cell_phone.getWidth(),
				label_cell_phone.getHeight());
		contentPane.add(label_email);

		label_username = new JLabel("Username:");
		label_username.setFont(label_full_name.getFont());
		label_username.setBounds(label_email.getX(), label_email.getY() + 33, label_email.getWidth(),
				label_email.getHeight());
		contentPane.add(label_username);

		label_password = new JLabel("Senha:");
		label_password.setFont(label_full_name.getFont());
		label_password.setBounds(label_username.getX(), label_username.getY() + 33, label_username.getWidth(),
				label_username.getHeight());
		contentPane.add(label_password);

		// TEXT_FIELDS
		textField_full_name = new JTextField();
		textField_full_name.setBounds(label_full_name.getX() + label_full_name.getWidth() + 40, label_full_name.getY(),
				150, label_full_name.getHeight());
		contentPane.add(textField_full_name);

		textField_date_birth = new JTextField();
		textField_date_birth.setBounds(label_date_birth.getX() + label_date_birth.getWidth() + 40,
				label_date_birth.getY(), 150, label_date_birth.getHeight());
		contentPane.add(textField_date_birth);

		textField_cell_phone = new JTextField();
		textField_cell_phone.setBounds(label_cell_phone.getX() + label_cell_phone.getWidth() + 40,
				label_cell_phone.getY(), 150, label_cell_phone.getHeight());
		contentPane.add(textField_cell_phone);

		textField_CPF = new JTextField();
		textField_CPF.setBounds(label_CPF.getX() + label_CPF.getWidth() + 40, label_CPF.getY(), 150, label_CPF.getHeight());
		contentPane.add(textField_CPF);

		textField_RG = new JTextField();
		textField_RG.setBounds(label_RG.getX() + label_RG.getWidth() + 40, label_RG.getY(), 150, label_RG.getHeight());
		contentPane.add(textField_RG);

		textField_adress_with_number_and_complement = new JTextField();
		textField_adress_with_number_and_complement.setBounds(
				label_adress_with_number_and_complement.getX() + label_adress_with_number_and_complement.getWidth() + 40,
				label_adress_with_number_and_complement.getY(), 150,
				label_adress_with_number_and_complement.getHeight());
		contentPane.add(textField_adress_with_number_and_complement);

		textField_email = new JTextField();
		textField_email.setBounds(label_email.getX() + label_email.getWidth() + 40, label_email.getY(), 150, label_email.getHeight());
		contentPane.add(textField_email);

		textField_username = new JTextField();
		textField_username.setBounds(label_username.getX() + label_username.getWidth() + 40, label_username.getY(), 150, label_username.getHeight());
		contentPane.add(textField_username);

		textField_password = new JTextField();
		textField_password.setBounds(label_password.getX() + label_password.getWidth() + 40, label_password.getY(), 150, label_password.getHeight());
		contentPane.add(textField_password);

		// Buttons
		button_save = new JButton("Save");
		button_save.setBounds(230, textField_password.getY() + 30, 80, 22);
		button_save.setFocusPainted(false);
		button_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (textField_full_name.getText().equals("") || textField_date_birth.getText().equals("")
						|| textField_cell_phone.getText().equals("") || textField_CPF.getText().equals("")
						|| textField_RG.getText().equals("")
						|| textField_adress_with_number_and_complement.getText().equals("")
						|| textField_email.getText().equals("") || textField_username.getText().equals("")
						|| textField_password.getText().equals("")) {

					label_errorText.setText(errorText);

				} else {

					label_errorText.setText("");

					tablesdao = new TablesDbDAO();
					user = new UserBuilder(tablesdao.getLastIdFrom("users") + 1, textField_username.getText(),
							textField_password.getText());

					try {
						newUserObject = user.build();
					} catch (EntityException e1) {
						e1.printStackTrace();
					}

					userdao = new UserDAO();
					createSucessUser = userdao.create(newUserObject);

					employer = new EmployerBuilder(tablesdao.getLastIdFrom("employer") + 1,
							textField_full_name.getText(), textField_date_birth.getText(),
							Long.parseLong(textField_cell_phone.getText()), textField_CPF.getText(),
							textField_RG.getText(), textField_adress_with_number_and_complement.getText(),
							textField_email.getText(), newUserObject.getId());

					try {
						newObjectEmployer = employer.build();
					} catch (EntityException e1) {
						e1.printStackTrace();
					}

					employerdao = new EmployerDAO();
					//mesma coisa aqui
					createSucessEmployer = employerdao.create(newObjectEmployer);

					if (createSucessUser && createSucessEmployer) {
						JOptionPane.showMessageDialog(contentPane, "Cadastro realizado com sucesso! ", "Login",
								JOptionPane.INFORMATION_MESSAGE);

						EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								RegisterPeople.this.dispose();
							}
						});
					} else {

						label_errorText.setText(errorText);

					}

				}

			}
		});
		contentPane.add(button_save);

		label_errorText = new JLabel();
		label_errorText.setForeground(Color.RED);
		label_errorText.setBounds(200, button_save.getY() + 20, 160, 30);
		label_errorText.setFont(new Font("Tahoma", Font.PLAIN + Font.BOLD, 11));
		contentPane.add(label_errorText);

		setContentPane(contentPane);

	}
}