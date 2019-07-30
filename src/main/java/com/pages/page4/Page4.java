package com.pages.page4;

import com.gui.Gui;
import com.pages.Pages;
import javafx.scene.paint.Color;

import javax.swing.*;

public class Page4 extends JFrame implements Pages {
  private static final long serialVersionUID = 1L;
  private Detector detector;
  private CameraPanel cameraPanel;
  private JPanel mainPanel;

  public Page4(Gui gui) {
    this.detector = new Detector();
    this.cameraPanel = new CameraPanel();
    this.mainPanel = gui.getMainPanel4();

    mainPanel.setSize(600, 500);
    mainPanel.add(cameraPanel);
    mainPanel.setBackground(Color.BLUE);

//    setContentPane(this.cameraPanel);

//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setSize(600, 500);
//    setVisible(true);
  }
}
