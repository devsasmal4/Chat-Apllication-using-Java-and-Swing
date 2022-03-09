/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_System;

import static Chat_System.Client1.din;
import static Chat_System.Server.skt;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author DEV SASMAL
 */
public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField tf;
    JButton b1;
    static JTextArea a1;
    static Socket soc;
    static DataInputStream dis;
    static DataOutputStream dos;
    Client()
    {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,50));
        p1.setBounds(0,0,450,60);
        add(p1);
        
        ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
        Image img2 = img.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel l1 = new JLabel(img3);
        l1.setBounds(5,17,30,30);
        p1.add(l1);
        
        l1.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent ae){
              System.exit(0);
          }
        });
                
        
        ImageIcon img4 = (new javax.swing.ImageIcon(getClass().getResource("/images/ds.jpg")));
        Image img5 = img4.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(img5);
        JLabel l2 = new JLabel(img6);
        l2.setBounds(40,5,60,50);
        p1.add(l2);
        
        ImageIcon img7 = (new javax.swing.ImageIcon(getClass().getResource("/images/video.png")));
        Image img8 = img7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon img9 = new ImageIcon(img8);
        JLabel l3 = new JLabel(img9);
        l3.setBounds(290,20,30,30);
        p1.add(l3);
        
        l3.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent ae){
              JOptionPane.showMessageDialog(null,"Couldn't Make a Video call", "Video",2);
          }
        });
        
        ImageIcon img10 = (new javax.swing.ImageIcon(getClass().getResource("/images/phone.png")));
        Image img11 = img10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon img12 = new ImageIcon(img11);
        JLabel l4 = new JLabel(img12);
        l4.setBounds(350,20,35,30);
        p1.add(l4);
        
        l4.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent ae){
              JOptionPane.showMessageDialog(null,"Couldn't Make a Call", "Phone",2); 
          }
        });
        
        ImageIcon img13 = (new javax.swing.ImageIcon(getClass().getResource("/images/3icon.png")));
        Image img14 = img13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon img15= new ImageIcon(img14);
        JLabel l5 = new JLabel(img15);
        l5.setBounds(410,20,13,25);
        p1.add(l5);
        
        l5.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent ae){
              JOptionPane.showMessageDialog(null,"Couldn't Open", "Icon",2);
          }
        });
        
        JLabel l6 = new JLabel("Umar");
        l6.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        l6.setForeground(Color.white);
        l6.setBounds(110,15,100,18);
        p1.add(l6);
        
        JLabel l7 = new JLabel("Active Now");
        l7.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l7.setForeground(Color.white);
        l7.setBounds(110,35,100,18);
        p1.add(l7);
        
        a1 = new JTextArea();
        a1.setBackground(Color.LIGHT_GRAY);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        JScrollPane js = new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setBounds(5,65,440,485); 
        add(js);
        
        tf = new JTextField();
        tf.setBounds(5,555,310,30);
        add(tf);
        
        b1 = new JButton("Send");
        b1.setBounds(320,555,125,30);
        b1.setBackground(new Color(7,94,50));
        b1.setForeground(Color.white);
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        b1.addActionListener(this);
        add(b1);
        
        //getContentPane().setBackground(Color.YELLOW);
        
        setLayout(null);
        setSize(450,600);
        setLocation(800, 50);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String out = tf.getText();
            a1.setText(a1.getText()+"\n\t\t\t"+out);
            dos .writeUTF(out);
            tf.setText("");
        }
        catch(Exception e){}
    }
    
    
    public static void main (String args[])
    {
        new Client().setVisible(true);
        try{
            soc = new Socket("127.0.0.1",6001); 
            dis = new DataInputStream(soc.getInputStream());
            dos = new DataOutputStream(soc.getOutputStream());
            
            String msgin = "";
            while(true){
	        msgin = dis.readUTF();
            	a1.setText(a1.getText()+"\n"+msgin);
            }
        }catch(Exception e){}
    }
    
    
}
