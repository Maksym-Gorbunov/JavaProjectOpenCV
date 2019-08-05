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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;

import com.constants.Constants;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
//import org.opencv.highgui.Highgui;
//import org.opencv.highgui.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Page4 implements Pages {
  private static final long serialVersionUID = 1L;
  //  private Detector detector;
//  private CameraPanel cameraPanel;
  private JPanel panel;
//  private JPanel webcamPanel;
  private Gui gui;
  private JButton jButton1;
  private JButton jButton2;
  private JPanel jPanel1;
  private JPanel buttonsPannel;
//  private FaceDetection.DaemonThread myThread = null;
  private DaemonThread myThread = null;
  int count = 0;
  VideoCapture webSource = null;
  Mat frame = new Mat();
  MatOfByte mem = new MatOfByte();
  CascadeClassifier faceDetector = new CascadeClassifier(Constants.CASCADE_CLASSIFIER);
  MatOfRect faceDetections = new MatOfRect();






  // Video Face Recognition
  public Page4(Gui gui) {
    this.gui = gui;
    panel = gui.getPagePanel4();
    jPanel1 = new JPanel();
    jButton1 = new JButton();
    jButton2 = new JButton();
    buttonsPannel = new JPanel();

    jPanel1.setPreferredSize(new Dimension(400, 300));
    jPanel1.setBackground(Color.orange);
    panel.add(jPanel1, new GridConstraints());

    buttonsPannel.add(jButton1, new GridConstraints());
//    panel.add(jButton2, new GridConstraints());
    panel.add(buttonsPannel, new GridConstraints());
    initComponents();


  }

  private void initComponents() {




    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        myThread.runnable = false;            // stop thread
        jButton2.setEnabled(false);   // activate start button
        jButton1.setEnabled(true);     // deactivate stop button

        webSource.release();  // stop caturing fron cam
      }
    });

    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        webSource = new VideoCapture(0); // video capture from default cam
         myThread = new DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 //start thrad
        jButton1.setEnabled(false);  // deactivate start button
        jButton2.setEnabled(true);  //  activate stop button
      }
    });


//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//      myThread.runnable = false;            // stop thread
//      jButton2.setEnabled(false);   // activate start button
//      jButton1.setEnabled(true);     // deactivate stop button
//
//      webSource.release();  // stop caturing fron cam
//
//
//    }//GEN-LAST:event_jButton2ActionPerformed

//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//
//      webSource = new VideoCapture(0); // video capture from default cam
//      myThread = new FaceDetection.DaemonThread(); //create object of threat class
//      Thread t = new Thread(myThread);
//      t.setDaemon(true);
//      myThread.runnable = true;
//      t.start();                 //start thrad
//      jButton1.setEnabled(false);  // deactivate start button
//      jButton2.setEnabled(true);  //  activate stop button
//
//
//    }
  }

//  public void displayScreen() {
//    Mat webcamImage = new Mat();
//    VideoCapture videoCapture = new VideoCapture(0);

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
//    System.gc();
//    for (int i = 0; i < 200; i++) {
//      webcamImage = detector.detect(webcamImage);
//      cameraPanel.convertMatToImage(webcamImage);
//      cameraPanel.repaint();
//    }
//    videoCapture.read(webcamImage);
////    setSize(webcamImage.width() + 50, webcamImage.height() + 70);
//    cameraPanel.convertMatToImage(webcamImage);
//  }
  class DaemonThread implements Runnable {

    protected volatile boolean runnable = false;

    @Override
    public void run() {
      synchronized (this) {
        while (runnable) {
          if (webSource.grab()) {
            try {
              webSource.retrieve(frame);
              Graphics g = jPanel1.getGraphics();
              faceDetector.detectMultiScale(frame, faceDetections);
              for (Rect rect : faceDetections.toArray()) {
                // System.out.println("ttt");

                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(0, 255, 0));


//                                Core.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
//                                        new Scalar(0, 255,0));
              }
              Imgcodecs.imencode(".bmp", frame, mem);
//                            Highgui.imencode(".bmp", frame, mem);
              Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
              BufferedImage buff = (BufferedImage) im;
              if (g.drawImage(buff, 0, 0, 600, 500, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                if (runnable == false) {
                  System.out.println("Paused ..... ");
                  this.wait();
                }
              }
            } catch (Exception ex) {
              System.out.println("Error!!");
              ex.printStackTrace();
            }
          }
        }
      }
    }
  }
}
