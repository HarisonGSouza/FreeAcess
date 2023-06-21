package com.freeacess.main.menubar;

import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPage extends JFrame {
        
    private static final long serialVersionUID = 1L;

    public static final int H_FRAME = 360;
    public static final int W_FRAME = 540;
    private JLabel label_icon;
    Insets insets;

    public AboutPage() {

        super("Sobre");
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-133426253(1).png"));
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

        GUI();

    }

    private void GUI() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);

        label_icon = new JLabel(new ImageIcon(
                "freeacess\\src\\main\\java\\com\\freeacess\\icons\\ícone-das-asas-do-anjo-133426253(1).png"));
        label_icon.setBounds(195, 45, 150, 100);
        panel.add(label_icon);

        JLabel label = new JLabel();
        label.setBounds(label_icon.getX() - 75, label_icon.getY() + 110, 300, 90);
        label.setText(
                "<html><p text-align:center;>A Livre Acesso é uma ONG formada por um estudante que tem como finalidade levar para pessoas com dificuldades financeiras o acesso a cursos na área da tecnologia, sem a cobrança pelo acesso.</p>");
        panel.add(label);

        setContentPane(panel);

    }
}