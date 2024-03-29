package com.gui;

import javax.swing.*;

import com.pages.Pages;
import com.pages.page1.Page1;
import com.pages.page2.Page2;
import com.pages.page3.Page3;
import com.pages.page4.Page4;


public class Gui extends JFrame {
  private static final long serialVersionUID = 1L;

  private JTabbedPane pagesPanel;

  private JPanel pagePanel1;
  private JPanel pagePanel2;
  private JPanel pagePanel3;
  private JPanel mainPanel1;
  private JPanel buttonsPanel1;
  private JButton startButton1;
  private JButton pauseButton1;
  private JButton testButton1;
  private JPanel rootPanel;
  private JPanel webcamPanel1;

  private JPanel labelsPanel2;
  private JPanel fieldsPanel2;
  private JPanel buttonsPanel2;
  private JLabel nameLabel2;
  private JLabel emailLabel2;
  private JLabel phoneLabel2;
  private JLabel surnameLabel2;
  private JButton addContactButton2;
  private JButton printAllContactsButton2;
  private JButton deleteButton2;
  private JTextField nameTextField2;
  private JTextField phoneTextField2;
  private JTextField emailTextField2;
  private JTextField surnameTextField2;
  private JPanel contactsPanel2;
  private JComboBox contactsComboBox2;
  private JButton editButton2;
  private JButton saveButton2;
  private JButton cancelButton2;

  private JPanel pagePanel4;
  private JButton button1;
  private JButton button2;
  private JPanel video;
  private JPanel buttonsPannel4;
  private JButton button41;
  private JButton button42;
  private JPanel mainPanel4;

  private Pages page1;
  private Pages page2;
  private Pages page3;
  private Pages page4;

  public Gui() {
    super("Application");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(rootPanel);
    setLocationRelativeTo(this);
    setResizable(false);
    setVisible(true);
    //move to new project

    page1 = new Page1(Gui.this);
    page2 = new Page2(Gui.this);
    page3 = new Page3(Gui.this);
    page4 = new Page4(Gui.this);
  }

  // Getters & Setters
  public JTabbedPane getPagesPanel() {
    return pagesPanel;
  }

  public JPanel getPagePanel1() {
    return pagePanel1;
  }

  public JPanel getPagePanel2() {
    return pagePanel2;
  }

  public JPanel getPagePanel3() {
    return pagePanel3;
  }

  public JPanel getMainPanel1() {
    return mainPanel1;
  }

  public JPanel getButtonsPanel1() {
    return buttonsPanel1;
  }

  public JButton getStartButton1() {
    return startButton1;
  }

  public JButton getPauseButton1() {
    return pauseButton1;
  }

  public JButton getTestButton1() {
    return testButton1;
  }

  public JPanel getRootPanel() {
    return rootPanel;
  }

  public JPanel getWebcamPanel1() {
    return webcamPanel1;
  }

  public JPanel getLabelsPanel2() {
    return labelsPanel2;
  }

  public JPanel getFieldsPanel2() {
    return fieldsPanel2;
  }

  public JPanel getButtonsPanel2() {
    return buttonsPanel2;
  }

  public JLabel getNameLabel2() {
    return nameLabel2;
  }

  public JLabel getEmailLabel2() {
    return emailLabel2;
  }

  public JLabel getPhoneLabel2() {
    return phoneLabel2;
  }

  public JLabel getSurnameLabel2() {
    return surnameLabel2;
  }

  public JButton getAddContactButton2() {
    return addContactButton2;
  }

  public JButton getPrintAllContactsButton2() {
    return printAllContactsButton2;
  }

  public JButton getDeleteButton2() {
    return deleteButton2;
  }

  public JButton getEditButton2() {
    return editButton2;
  }

  public JButton getSaveButton2() {
    return saveButton2;
  }

  public JButton getCancelButton2() {
    return cancelButton2;
  }

  public JTextField getNameTextField2() {
    return nameTextField2;
  }

  public JTextField getPhoneTextField2() {
    return phoneTextField2;
  }

  public JTextField getEmailTextField2() {
    return emailTextField2;
  }

  public JTextField getSurnameTextField2() {
    return surnameTextField2;
  }

  public JPanel getContactsPanel2() {
    return contactsPanel2;
  }

  public JComboBox getContactsComboBox2() {
    return contactsComboBox2;
  }

  public Pages getPage1() {
    return page1;
  }

  public Pages getPage2() {
    return page2;
  }

  public Pages getPage3() { return page3; }

  public JPanel getPagePanel4() {
    return pagePanel4;
  }

  public JPanel getMainPanel4() {
    return mainPanel4;
  }

  public Pages getPage4() {
    return page4;
  }

  public JPanel getButtonsPannel4() {
    return buttonsPannel4;
  }

  public JButton getButton41() {
    return button41;
  }

  public JButton getButton42() {
    return button42;
  }
}
