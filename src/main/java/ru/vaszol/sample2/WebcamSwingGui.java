package ru.vaszol;

import com.github.sarxos.webcam.Webcam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vas on 02.07.2017.
 */
public class WebcamSwingGui extends JFrame {
    private final Webcam webcam;
    private JPanel panel1;
    private JLabel imageHolder;
    private JButton button;
    private Boolean isRunning = false;

    // Constructor
    public WebcamSwingGui() {
        initComponents();
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(320, 240));
        webcam.open();
    }

    private void initComponents() {
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!isRunning){
                    isRunning = true;
                    new VideoFeedTaker().start();
                } else {
                    isRunning = false;
                }
            }
        });
    }

    /**
     * <p>repain image on Label from webcam</p>
     */
    private void showImage() {
        Image image = webcam.getImage();
        imageHolder.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WebcamSwingGui().setVisible(true);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Logger.getLogger(WebcamSwingGui.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        });
    }

    class VideoFeedTaker extends Thread {
        @Override
        public void run() {
            while (isRunning) {
                showImage();
            }
        }
    }
}
