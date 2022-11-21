package chat2;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class ChatFrame extends JFrame {
  JPanel contentPane;
  Label label1 = new Label();//������Ϣ
  Label label2 = new Label();//����ip
  Label label3 = new Label();//����˿ڱ�ǩ
  Label label4 = new Label();//����˿ڱ�ǩ
  TextField textField1 = new TextField();//����ip
  TextField textField2 = new TextField();//������Ϣ
  TextField textField3 = new TextField();//�������˿�
  TextField textField4 = new TextField();//�������˿�
  Button button1 = new Button();//������Ϣ
  Button button2 = new Button();//��������
  TextArea textArea1 = new TextArea();

  boolean online = false;
  int portIn = 5000;//����˿�
  int portOut = 5001;//����˿�

  DatagramPacket sendpacket,receivepacket;//�������ͺͽ������ݰ�
  DatagramSocket sendsocket,receivesocket;//�������ͺͽ���DatagramSocket


  public ChatFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      toInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  private void toInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    label1.setText("������Ϣ��");
    label1.setBounds(new Rectangle(13, 100, 60, 21));
    contentPane.setLayout(null);
    this.setSize(new Dimension(363, 320));
    this.setTitle("����������");
    label2.setText("����Է�IP��ַ��");
    label2.setBounds(new Rectangle(12, 19, 109, 23));
    label3.setText("����˿ڣ�");
    label3.setBounds(new Rectangle(12,58,55,22));
    label4.setText("����˿ڣ�");
    label4.setBounds(new Rectangle(180,58,55,22));
    textField3.setText("5000");
    textField4.setText("5001");
    textField2.setText("210.77.26.60");

    button1.setLabel("����");
    button1.setBounds(new Rectangle(280, 100, 59, 21));
    button1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button1_actionPerformed(e);
      }
    });
    button2.setLabel("����");
    button2.setBounds(new Rectangle(280, 20, 59, 21));
    button2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button2_actionPerformed(e);
      }
    });

    textField4.setBounds(new Rectangle(240,58,90,22));
    textField3.setBounds(new Rectangle(70,58,90,22));
    textField2.setBounds(new Rectangle(123, 20, 120, 19));
	textField1.setBounds(new Rectangle(76, 100, 190, 19));
    textArea1.setBounds(new Rectangle(11, 140, 333, 134));
    textArea1.setEditable(false);
    contentPane.add(label4, null);
    contentPane.add(label3, null);
    contentPane.add(label2, null);
    contentPane.add(label1, null);
    contentPane.add(textField1, null);
    contentPane.add(textField2, null);
    contentPane.add(textField3, null);
    contentPane.add(textField4, null);
    contentPane.add(textArea1, null);
    contentPane.add(button1, null);
    contentPane.add(button2,null);
    
    try {    	
    	  	sendsocket=new DatagramSocket(5001);//ʵ����DatagramSocket����Ϊ�����
          	receivesocket=new DatagramSocket(5000);//ʵ����DatagramSocket����Ϊ�����
          	online = !(sendsocket.isClosed());
    		}
   	 	catch(SocketException se){//�쳣����
        	se.printStackTrace() ;
        	System.exit(0);
    	}
  }
  
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }
  public void waitforpackets(){//��Ⲣ���ܶԷ���������Ϣ
    while(true){
        try{
             byte[]array=new byte[100];
              receivepacket=new DatagramPacket(array,array.length );
              receivesocket.receive(receivepacket);//����
              textArea1.append("\nfrom "+receivepacket.getAddress() +":"+receivepacket.getPort()+" get:");
             byte data[]=receivepacket.getData() ;
              String received=new String(data,0);
              textArea1.append(received);
        }
        catch (IOException se){
                se.printStackTrace() ;
        }
    }
  }
  
  void button2_actionPerformed(ActionEvent e){//�ͶԷ���������
  	
  	String str2 = new String();
    String str3 = new String();
  	str2 = textField3.getText();
    str3 = textField4.getText();
        
    if(str2.compareTo("")!=0&&str3.compareTo("")!=0){
    	
    	portIn = (int) Integer.parseInt(str2);
    	portOut = (int) Integer.parseInt(str3);
    	
    	
    	if(online){
    		sendsocket.close();
    		receivesocket.close();
    		textArea1.append("\n formal connection closed");
    	}
    	    		
    	try {
    		 textArea1.append("\n building a connection use the port defined...");	
    	  	sendsocket=new DatagramSocket(portOut);
          	receivesocket=new DatagramSocket(portIn);
          	textArea1.append("\n connection builded.");
    		}
   	 	catch(SocketException se){
        	se.printStackTrace() ;
        	System.exit(0);
    	}
    	online = !(sendsocket.isClosed());
    }
    	
    	
	else
        textArea1.append("\nplease input ports and IP");
       	
    }
  
  void button1_actionPerformed(ActionEvent e) {//������Ϣ���Է�
       	
        
        String str=textField2.getText();
        if(online){
        	if(str.compareTo("")!=0 ){
        		
            	
            	try {
            		
        		        		            	
                 textArea1.append("\nto "+textField2.getText() +":"+portOut+" say: "+textField1.getText() );
                 String s=textField1.getText() ;
                 byte data[]=new byte[100];
                 s.getBytes(0,s.length() ,data,0);
                 sendpacket=new DatagramPacket(data,s.length() ,InetAddress.getByName(textField2.getText()),portOut);
                 sendsocket.send(sendpacket);
            	}
            	catch(IOException exc){
               		exc.printStackTrace() ;
            	}
        	
        	}
        	
        	}
        else textArea1.append("\nplease build a connection first!");
  }
}