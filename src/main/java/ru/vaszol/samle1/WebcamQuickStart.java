package ru.vaszol;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 */
public class WebcamQuickStart {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        Webcam webcam = Webcam.getDefault();

        webcam.addWebcamListener(new WebcamListener() {
            public void webcamOpen(WebcamEvent webcamEvent) {
                System.out.println("webcam open!");
            }

            public void webcamClosed(WebcamEvent webcamEvent) {
                System.out.println("webcam close");
            }

            public void webcamDisposed(WebcamEvent webcamEvent) {
                System.out.println("webcam dispose");
            }

            public void webcamImageObtained(WebcamEvent webcamEvent) {
                System.out.println("image taken");
            }
        });

        for(Dimension supportSize: webcam.getViewSizes()){
            System.out.println(supportSize.toString());
        }
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();
        ImageIO.write(webcam.getImage(), "JPG", new File("picture_" + System.currentTimeMillis() + ".jpg"));
        webcam.close();
    }
}
