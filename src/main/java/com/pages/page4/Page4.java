package com.pages.page4;

import com.gui.Gui;
import com.intellij.uiDesigner.core.GridConstraints;
import com.pages.Pages;
import java.awt.Color;
//import javafx.scene.paint.Color;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;

import java.awt.*;

import static javafx.scene.paint.Color.*;

public class Page4 extends JFrame implements Pages {
  private static final long serialVersionUID = 1L;
  private Detector detector;
  private CameraPanel cameraPanel;
  private JPanel mainPanel;

  // Video Face Recognition
  public Page4(Gui gui) {
    this.detector = new Detector();
    this.cameraPanel = new CameraPanel();
    this.mainPanel = gui.getMainPanel4();

    mainPanel.setSize(600, 200);
//    mainPanel.add(cameraPanel);
//    mainPanel.add(cameraPanel, new GridConstraints());
//    mainPanel.add(cameraPanel, BorderLayout.CENTER);
    mainPanel.setBackground(Color.BLUE);

//    setContentPane(this.cameraPanel);

//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setSize(600, 500);
//    setVisible(true);
//    displayScreen();
  }

  public void displayScreen() {
    Mat webcamImage = new Mat();
    VideoCapture videoCapture = new VideoCapture(0);

//    cameraPanel.setBackground(Color.BLUE);
    System.gc();
    for (int i = 0; i < 200; i++) {
      cameraPanel.repaint();

    }
    videoCapture.read(webcamImage);
    setSize(webcamImage.width() + 50, webcamImage.height() + 70);
    cameraPanel.convertMatToImage(webcamImage);
    }
  }
