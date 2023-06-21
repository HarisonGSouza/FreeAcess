package com.freeacess.main.menubar.coursesPage;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.freeacess.dao.VideosPathDAO;

public class NetworkCourse extends JFrame {
    private static final long serialVersionUID = 1L;

    public static List<String> list_path_videos;
    public static String[] array_path_videos;
    public static final int H_FRAME = 360;
    public static final int W_FRAME = 540;
    private JLabel label_icon;
    Insets insets;

    public NetworkCourse() {

        super("Redes");
        setIconImage(Toolkit.getDefaultToolkit().getImage(
            "freeacess\\src\\main\\java\\com\\freeacess\\icons\\REDE-DE-COMPUTADORES-1280x720(1).jpg"));
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

        VideosPathDAO vp = new VideosPathDAO();
        list_path_videos = vp.getPathVideosFromDB("network");
        array_path_videos = list_path_videos.toArray(new String[0]);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);

            label_icon = new JLabel(new ImageIcon(
                "freeacess\\src\\main\\java\\com\\freeacess\\icons\\REDE-DE-COMPUTADORES-1280x720(1).jpg"));
                label_icon.setBounds(195, 23, 150, 100);
            panel.add(label_icon);

            JLabel label = new JLabel();
            label.setBounds(label_icon.getX() - 75, label_icon.getY() + 110, 300, 100);
            label.setText(
                    "<html><p text-align:center;>O curso de Redes é um cursos voltado para quem busca mais conhecimento na área e está afim de conhecer um pouquinho mais sobre a parte lógica que ocorre na comunicação entre computadores.</p> <p text-align:center;>Se você está procurando se aprofundar nessa área esse é o lugar certo para você.</p>");
            panel.add(label);

        JButton button = new JButton("Entrar");
        button.setBounds(label.getX() + 90, label.getY() + 120, 120, 22);
        button.setFocusPainted(false);
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                NetworkCourse.this.dispose();
                new VideoLessons(array_path_videos);
            }
        });
        panel.add(button);

        setContentPane(panel);

    }
}

