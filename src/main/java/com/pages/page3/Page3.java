package com.pages.page3;

import com.constants.Constants;
import com.gui.Gui;
import com.intellij.uiDesigner.core.GridConstraints;
import com.pages.Pages;
import com.algoritm.FaceDetection;
import com.constants.Constants;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import java.io.File;

public class Page3  extends JFrame implements Pages {
  private Gui gui;
  private static final long serialVersionUID = 1L;
  private JLabel imageLabel;
  private ImageIcon transformedImageIcon;
  private ImagePanel imagePanel;
  private JFileChooser fileChooser;
  private FaceDetection faceDetection;
  private File file;
  private JPanel pagePanel;

  public Page3(Gui gui) {
    this.gui = gui;
    this.pagePanel = gui.getPagePanel3();
    this.imagePanel = new ImagePanel();
    this.fileChooser = new JFileChooser();
    this.faceDetection = new FaceDetection();

    gui();
  }

  private void gui() {
    gui.setJMenuBar(createMenuBar());
    pagePanel.add(imagePanel);
    pagePanel.setSize(700, 500);
//    pagePanel.add(imagePanel, new GridConstraints());

//    pagePanel.add(imagePanel, BorderLayout.CENTER);
//    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
//    setVisible(true);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setLocationRelativeTo(this);

  }


  public JMenuBar createMenuBar(){
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenuItem loadMenuItem = new JMenuItem("Load image");
    JMenuItem detectMenuItem = new JMenuItem("Detect faces");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    fileMenu.add(loadMenuItem);
    fileMenu.add(detectMenuItem);
    fileMenu.add(exitMenuItem);

    loadMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(fileChooser.showOpenDialog(gui) == JFileChooser.APPROVE_OPTION){
          file = fileChooser.getSelectedFile();
          // load the image
          System.out.println("Image url: " + file);
          imagePanel.loadImage(file);
          gui.getPagesPanel().setSelectedComponent(gui.getPagePanel3());
        }
      }
    });
    detectMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // detect algorithm
//        MainFrame.this.faceDetection.detectFaces(MainFrame.this.file, MainFrame.this.imagePanel);
        faceDetection.detectFaces(file, imagePanel);
        gui.getPagesPanel().setSelectedComponent(gui.getPagePanel3());
      }
    });
    exitMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        int action = JOptionPane.showConfirmDialog(gui, Constants.EXIT_WARNING);
        if(action == JOptionPane.OK_OPTION){
          System.gc();
          System.exit(0);
        }
      }
    });

    JMenu aboutMenu = new JMenu("About");
    JMenu helpMenu = new JMenu("Help");

    menuBar.add(fileMenu);
    menuBar.add(aboutMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }
}
