package chat2;

import java.net.*;
import java.io.*;
import javax.swing.UIManager;
import java.awt.*;


public class ChatApp {
  boolean packFrame = false;

  public ChatApp() {
    ChatFrame frame = new ChatFrame();
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //放置窗体在屏幕中央
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
    frame.waitforpackets();
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new ChatApp();
  }
}