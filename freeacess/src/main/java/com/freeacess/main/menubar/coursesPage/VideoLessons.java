package com.freeacess.main.menubar.coursesPage;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VideoLessons extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public static final int H_FRAME = 360;
    public static final int W_FRAME = 540;

    public static Insets insets;
    public static String array_element;
    public static String[] arraylist;
    public static JPanel panel = new JPanel();

    public static int w;
    public static int h;
    public static int wid;
    public static int hei;


    public VideoLessons(String[] array_videos_path) {

        super("VideoLessons");
        setLayout(null);
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setLocation(getX() - 80, getY() - 80);
        setVisible(true);

        insets = this.getInsets();
        arraylist = array_videos_path;
        w = 210;
        h = 65;
        wid = 130;
        hei = 10;

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                panel = new JPanel();
                insets = null;
                arraylist = null;
                w = 210;
                h = 65;
                wid = 130;
                hei = 10;
            }
        });

        panel.setLayout(null);
        panel.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);

        createComponents();
        setContentPane(panel);

    }

    public static void createComponents() {
        if (arraylist.length >= 4) {

            for (int i = 0; i <= 4; i++) {

                array_element = arraylist[i];

                String file_name = getNameFile(array_element);
                JLabel label = new JLabel();
                label.setText(file_name);
                label.setBounds(w, h, wid, hei);
                label.setName(array_element);
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {

                        String labelName = ((JLabel) e.getSource()).getName();

                        VideoPlayer video = new VideoPlayer("Ola Video");
                        video.executeVideo(labelName);
                    }
                });
                panel.add(label);

                if (i == 4 && arraylist.length > 4) {
                    JButton button = new JButton("Próximo");
                    button.setBounds(210, label.getY() + 40, 130, 22);
                    button.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            w = 210;
                            h = 23;
                            wid = 130;
                            hei = 100;
                            removeComponents();
                            createComponents();
                        }
                    });
                    panel.add(button);

                    String[] new_arr = removeArrayElements(arraylist, 5);
                    arraylist = new_arr;
                }

                h = h + 30;

            }

        } else {

            for (int i = 0; i < arraylist.length; i++) {

                array_element = arraylist[i];

                String file_name = getNameFile(array_element);
                JLabel label = new JLabel();
                label.setText(file_name);
                label.setBounds(w, h, wid, hei);
                label.setName(array_element);
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {

                        String labelName = ((JLabel) e.getSource()).getName();

                        VideoPlayer video = new VideoPlayer("Ola Video");
                        video.executeVideo(labelName);
                    }
                });
                panel.add(label);

                h = h + 30;

            }
        }
    }

    public static String[] removeArrayElements(String[] arr, int qtt_elements) {

        List<String> list = new ArrayList<>();
        String[] new_arr;

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int i = 0; i < qtt_elements; i++) {
            list.remove(0);
        }

        new_arr = list.toArray(new String[0]);

        return new_arr;
    }

    public static void removeComponents() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);
    }

    public static String getNameFile(String path) {
        String pathString = path;
        String file_name_with_extension = pathString.replaceAll(".*\\\\", "");
        String file_name_without_extension = file_name_with_extension.replaceAll("\\.\\w+$", "");
        String file_name = file_name_without_extension;
        return file_name;
    }

}