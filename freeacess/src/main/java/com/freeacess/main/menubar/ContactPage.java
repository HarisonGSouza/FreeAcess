package com.freeacess.main.menubar;

import javax.swing.JFrame;

import java.awt.Insets;

import javax.swing.JLabel;  
import javax.swing.JPanel;

public class ContactPage extends JFrame
{
    private static final long serialVersionUID = 1L;

    public static final int H_FRAME = 360;
    public static final int W_FRAME = 540;
    Insets insets;

    public ContactPage () {
        
        super("Contatos");
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

        JLabel label = new JLabel("<html><i><strong>Email: fake.company@gmail.com </strong></i>");
        label.setBounds(170, 90 , 200, 20);
        panel.add(label);

        JLabel label1 = new JLabel("<html><i><strong>Telefone: (011) 99999-9999 </strong></i>");
        label1.setBounds(label.getX() + 20, label.getY() + 20 , 160, 20);
        panel.add(label1);

        JLabel label2 = new JLabel("<html><i><strong>Endereço: Av. Rio bonito, Jardim Moro, 142, H </strong></i>");
        label2.setBounds(label1.getX() - 55, label1.getY() + 20 , 270, 20);
        panel.add(label2);

        setContentPane(panel);
        
    }
}