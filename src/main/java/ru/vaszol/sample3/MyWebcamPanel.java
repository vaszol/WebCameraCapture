package ru.vaszol.sample3;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;

/**
 * Use WebcamPanel to dosplay webcam.
 */
public class MyWebcamPanel {
    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setImageSizeDisplayed(true);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setMirrored(true);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
