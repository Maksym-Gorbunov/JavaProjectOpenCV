package com.pages.page4;

import com.constants.Constants;
import com.gui.Gui;
import com.pages.Pages;
import java.awt.Color;
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
    this.detector = new Detector();
    this.cameraPanel = new CameraPanel();
    this.panel = gui.getPagePanel4();

    panel.setLayout(null);
    webcamPanel = new JPanel();
    webcamPanel.setBackground(Color.GREEN);
    webcamPanel.setBounds((Constants.FRAME_WIDTH-600)/2,20,600,500);
    panel.add(webcamPanel);





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
//    setSize(webcamImage.width() + 50, webcamImage.height() + 70);
    cameraPanel.convertMatToImage(webcamImage);
    }
  }
