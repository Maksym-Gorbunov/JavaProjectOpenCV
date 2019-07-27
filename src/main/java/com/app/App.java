package com.app;

import com.gui.Gui;
import org.opencv.core.Core;
import javax.swing.*;

public class App {
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.library.path"));


    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException
            | UnsupportedLookAndFeelException | IllegalAccessException e) {
      e.printStackTrace();
    }

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Gui();
      }
    });
  }
}
