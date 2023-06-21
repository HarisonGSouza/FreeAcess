package com.freeacess.main.menubar.profilePage;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.freeacess.dao.EmployerDAO;
import com.freeacess.entity.Employer;

public class ProfilePage extends JFrame {
    private Integer cache_user;

    private static final long serialVersionUID = 1L;

    Boolean exist_on_db;
    Integer cache_id_user;
    HashMap<Boolean, Integer> hm;
    public static final int H_FRAME = 360;
    public static final int W_FRAME = 540;
    private JPanel contentPane;
    private JLabel label_name, label_email, label_phone;
    private JTextField textField_name, textField_email, textField_phone;
    private Insets insets;
    String errorText = "ErrorText";
    private JLabel label_icon;

    public ProfilePage(int cache) {

        super("ProfilePage");
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-133426253(1).png"));
        // setResizable(false);
        setLayout(null);
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setLocation(getX() - 80, getY() - 80);
        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });

        insets = this.getInsets();

        this.cache_user = cache;

        GUI();

    }

    private void GUI() {

        EmployerDAO employerdao = new EmployerDAO();
        Employer employer = employerdao.getEmployer(cache_user);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);

        label_icon = new JLabel(new ImageIcon(
                "freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-133426253(1).png"));
        label_icon.setBounds(195, 25, 150, 100);
        contentPane.add(label_icon);

        label_name = new JLabel("Nome:");
        label_name.setFont(new Font("Bold", Font.PLAIN, 14));
        label_name.setBounds(150, label_icon.getY() + 120, 80, 20);
        contentPane.add(label_name);

        label_email = new JLabel("Email:");
        label_email.setFont(label_name.getFont());
        label_email.setBounds(label_name.getX(), label_name.getY() + 40, label_name.getWidth(), label_name.getHeight());
        contentPane.add(label_email);

        label_phone = new JLabel("Telefone:");
        label_phone.setFont(label_name.getFont());
        label_phone.setBounds(label_email.getX(), label_email.getY() + 40, label_email.getWidth(),
                label_email.getHeight());
        contentPane.add(label_phone);

        textField_name = new JTextField();
        textField_name.setBounds(label_name.getX() + label_name.getWidth() + 40, label_name.getY(), 130,
                label_name.getHeight());
        textField_name.setText(employer.getFullName());
        textField_name.setEnabled(false);
        contentPane.add(textField_name);

        textField_email = new JTextField();
        textField_email.setBounds(label_email.getX() + label_email.getWidth() + 40, label_email.getY(), 130,
                label_email.getHeight());
        textField_email.setText(employer.getEmail());
        textField_email.setEnabled(false);
        contentPane.add(textField_email);

        textField_phone = new JTextField();
        textField_phone.setBounds(label_phone.getX() + label_phone.getWidth() + 40, label_phone.getY(), 130,
                label_phone.getHeight());
        textField_phone.setText(employer.getCellPhone().toString());
        textField_phone.setEnabled(false);
        contentPane.add(textField_phone);

        setContentPane(contentPane);

    }

}
