package com.freeacess.main.menubar.coursesPage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VideoPlayer extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Media Player";
    private static JPanel contentPane = new JPanel();
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private JButton playButton;

    public VideoPlayer(String title) {
        super(title);
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
    }

    public void initialize() {
        this.setBounds(100, 100, 600, 400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        playButton = new JButton("Play");
        controlsPane.add(playButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().play();
            }
        });
        this.setContentPane(contentPane);
        this.setVisible(true);
    }

    public void loadVideo(String path) {
        mediaPlayerComponent.mediaPlayer().media().startPaused(path);
    }

    public void executeVideo(String VIDEO_PATH) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
        VideoPlayer application = new VideoPlayer(TITLE);
        application.initialize();
        application.setVisible(true);
        application.loadVideo(VIDEO_PATH);
    }
}