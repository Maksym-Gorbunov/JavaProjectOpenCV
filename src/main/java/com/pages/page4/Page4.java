package com.pages.page4;

import com.constants.Constants;
import com.gui.Gui;
import com.intellij.uiDesigner.core.GridConstraints;
import com.pages.Pages;

import java.awt.*;
//import javafx.scene.paint.Color;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;

public class Page4 implements Pages {
  private static final long serialVersionUID = 1L;
  private Detector detector;
  private CameraPanel cameraPanel;
  private JPanel panel;
  private JPanel webcamPanel;
  private Gui gui;

  // Video Face Recognition
  public Page4(Gui gui) {
    this.gui = gui;
    detector = new Detector();
    cameraPanel = new CameraPanel();
//    cameraPanel = new CameraPanel();
    panel = gui.getPagePanel4();


//    panel.setLayout(null);
//    webcamPanel = new JPanel();
//    webcamPanel.setBackground(Color.GREEN);
//    webcamPanel.setBounds((Constants.FRAME_WIDTH-600)/2,10,600,500);

    cameraPanel.setPreferredSize(new Dimension(800, 600));


    panel.add(cameraPanel, new GridConstraints());


//    panel.add(webcamPanel);


    displayScreen();


  }

  public void displayScreen() {
    Mat webcamImage = new Mat();
    VideoCapture videoCapture = new VideoCapture(0);

//    if (videoCapture.isOpened()) {
//      while (true) {
//        videoCapture.read(webcamImage);
//        if (!webcamImage.empty()) {
//          setSize(webcamImage.width() + 50, webcamImage.height() + 70);
//          webcamImage = detector.detect(webcamImage);
//          cameraPanel.convertMatToImage(webcamImage);
//          cameraPanel.repaint(); // update camera panel
//        } else {
//          System.out.println("Problem");
//          break;
//        }
//      }
//    }


//    cameraPanel.setBackground(Color.BLUE);
    System.gc();
    for (int i = 0; i < 200; i++) {
      webcamImage = detector.detect(webcamImage);
      cameraPanel.convertMatToImage(webcamImage);
      cameraPanel.repaint();
    }
    videoCapture.read(webcamImage);
//    setSize(webcamImage.width() + 50, webcamImage.height() + 70);
    cameraPanel.convertMatToImage(webcamImage);
  }
}
