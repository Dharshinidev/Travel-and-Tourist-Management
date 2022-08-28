/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Guide implements ActionListener,ItemListener{

    String w ="";
    JFrame Guide_frame;
    JLabel district_label, guide1_label, guide2_label, guide3_label;
    JButton back, guide1_button, guide2_button, guide3_button;
    JPanel g1_details, g2_details, g3_details;
    JTextField text_name1,text_gender1,text_phno1,text_amount1,text_name2,text_gender2,text_phno2,text_amount2,text_name3,text_gender3,text_phno3,text_amount3;
    JComboBox box1,box2,box3;
    String days;
    String userid=Home_page.mail;
    String payid=Home_page.payid;
    
    String guide;
    String days1,days2,days3;
    String book="YES";
    
    Guide() {
      
        String fr = "Guide_details ";
        
        Guide_frame = new JFrame(fr);
        Guide_frame.setBackground(new Color(82, 78, 114));
        district_label = new JLabel();
        district_label.setFont(new Font( "Bookman Old Style",Font.BOLD, 25));
        district_label.setBounds(750, 10, 700, 40);
        ImageIcon guide_image=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\tour-guide-travel-information-vacation-260nw-696827443.jpg");
        guide1_label = new JLabel(guide_image,0);
        guide1_label.setText("\n    "
                +"\n"
                + "Guide 1\n");
        guide1_label.setOpaque(false);
        guide1_label.setFont(new Font("Bookman Old Style",Font.BOLD, 25));
        guide1_label.setBounds(150, 90, 450, 190);
       // guide1_label.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
        guide1_label.setForeground(new Color(37, 4, 64));
        guide2_label = new JLabel(guide_image);
        guide2_label.setText("\n    "
                +"\n"
                + "Guide 2\n");
        guide2_label.setFont(new Font( "Bookman Old Style",Font.BOLD, 25 ));
       // guide2_label.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2));
        guide2_label.setForeground(new Color(37, 4, 64 ));
        guide2_label.setBounds(150, 330, 450, 190);
        guide3_label = new JLabel(guide_image);
        guide3_label.setText("\n    "
                +"\n"
                + "Guide 3\n");
        guide3_label.setFont(new Font( "Bookman Old Style",Font.BOLD, 25));
        guide3_label.setForeground(new Color(37, 4, 64));
     //   guide3_label.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2));
        guide3_label.setBounds(150, 570, 450, 190);
        
        Font f=new Font("Cambria",Font.PLAIN,17);
        Integer[] day={ 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        
        JLabel g1=new JLabel("Guide-1 Details");
        g1.setFont(new Font( "Bookman Old Style",Font.BOLD, 25));
        g1.setBounds(1100,90,250,30);
        g1.setVisible(false);
        JLabel g2=new JLabel("Guide-2 Details");
        g2.setFont(new Font( "Bookman Old Style",Font.BOLD, 25));
        g2.setBounds(1100,90,250,30);
        g2.setVisible(false);
        JLabel g3=new JLabel("Guide-3 Details");
        g3.setFont(new Font( "Bookman Old Style",Font.BOLD, 25));
        g3.setBounds(1100,90,250,30);
        g3.setVisible(false);
        
        g1_details = new JPanel();
        guide1_button = new JButton("Book");
        guide1_button.setBackground(Color.WHITE);
        guide1_button.setForeground(Color.BLACK);
        guide1_button.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        guide1_button.setBounds(400, 550, 150, 40);
        guide1_button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        guide1_button.addActionListener(this);
        g1_details.setVisible(false);
        guide1_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                  g1.setVisible(true);
                  g2.setVisible(false);
                  g3.setVisible(false);
                  g1_details.setVisible(true);
                  g3_details.setVisible(false);
                  g2_details.setVisible(false);
            }
        });
        JLabel name1 = new JLabel("Guide Name");
        name1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        name1.setBounds(100, 30, 150, 50);
        text_name1=new JTextField();
        text_name1.setFont(f);
        text_name1.setBounds(300, 30, 250, 50);
        JLabel gender1 = new JLabel("Guide's Gender");
        gender1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        gender1.setBounds(100, 130, 150, 50);
         text_gender1=new JTextField();
        text_gender1.setFont(f);
        text_gender1.setBounds(300, 130, 250, 50);
        JLabel phno1 = new JLabel("Contact number");
        phno1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        phno1.setBounds(100, 230, 150, 50);
        text_phno1=new JTextField();
        text_phno1.setFont(f);
        text_phno1.setBounds(300, 230, 250, 50);
        JLabel days1 = new JLabel("Choose days");
        days1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        days1.setBounds(100, 330, 150, 50);
         box1=new JComboBox(day);
        box1.setBounds(300,330, 250, 50);
        box1.setBackground(Color.WHITE);
        box1.setFont(new Font( "Bookman Old Style",Font.PLAIN, 15));
        box1.setFocusable(false);
        box1.addItemListener(this);
        JLabel amount1 = new JLabel("Amount per Day");
        amount1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        amount1.setBounds(100, 430, 150, 50);
        text_amount1=new JTextField();
        text_amount1.setFont(f);
        text_amount1.setBounds(300, 430, 250, 50);
        g1_details.add(amount1);
        g1_details.add(box1);
        g1_details.add(text_amount1);
        g1_details.add(text_name1);
        g1_details.add(name1);
        g1_details.add(gender1);
        g1_details.add(text_gender1);
        g1_details.add(phno1);
        g1_details.add(text_phno1);
        g1_details.add(days1);
        g1_details.setBackground(new Color(255,255,255));
        g1_details.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
        g1_details.add(guide1_button);
        g1_details.setBounds(800, 120, 800, 650);
        
        g2_details = new JPanel();
        guide2_button = new JButton("Book");
        guide2_button.setBackground(Color.WHITE);
        guide2_button.setForeground(Color.BLACK);
        guide2_button.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        guide2_button.setBounds(400, 550, 150, 40);
        guide2_button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        g2_details.setVisible(false);
        guide2_button.addActionListener(this);
        guide2_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                  g1.setVisible(false);
                  g2.setVisible(true);
                  g3.setVisible(false);
                  g2_details.setVisible(true);
                  g3_details.setVisible(false);
                  g1_details.setVisible(false);
            }
        });
        JLabel name2 = new JLabel("Guide Name");
        name2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        name2.setBounds(100, 30, 150, 50);
        text_name2=new JTextField();
        text_name2.setFont(f);
        text_name2.setBounds(300, 30, 250, 50);
        JLabel gender2 = new JLabel("Guide's Gender");
        gender2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        gender2.setBounds(100, 130, 150, 50);
        text_gender2=new JTextField();
        text_gender2.setFont(f);
        text_gender2.setBounds(300, 130, 250, 50);
        JLabel phno2 = new JLabel("Contact number");
        phno2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        phno2.setBounds(100, 230, 150, 50);
        text_phno2=new JTextField();
        text_phno2.setFont(f);
        text_phno2.setBounds(300, 230, 250, 50);
        JLabel days2 = new JLabel("Choose days");
        days2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        days2.setBounds(100, 330, 150, 50);
        box2=new JComboBox(day);
        box2.setBounds(300,330, 250, 50);
        box2.setBackground(Color.WHITE);
        box2.setFont(new Font( "Bookman Old Style",Font.PLAIN, 15));
        box2.setFocusable(false);
        box2.addItemListener(this);
        JLabel amount2 = new JLabel("Amount per Day");
        amount2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        amount2.setBounds(100, 430, 150, 50);
         text_amount2=new JTextField();
        text_amount2.setFont(f);
        text_amount2.setBounds(300, 430, 250, 50);
        g2_details.add(box2);
        g2_details.add(amount2);
        g2_details.add(name2);
        g2_details.add(gender2);
        g2_details.add(phno2);
        g2_details.add(days2);
        g2_details.add(text_amount2);
        g2_details.add(text_gender2);
        g2_details.add(text_name2);
        g2_details.add(text_phno2);
        g2_details.add(guide2_button);
        g2_details.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
        g2_details.setBackground(new Color(242, 241, 247 ));
        g2_details.setBounds(800, 120, 800, 650);

        g3_details = new JPanel();
        guide3_button = new JButton("Book");
        guide3_button.setBackground(Color.WHITE);
        guide3_button.setForeground(Color.BLACK);
        guide3_button.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        guide3_button.setBounds(400, 550, 150, 40);
        guide3_button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        guide3_button.addActionListener(this);
        g3_details.setVisible(false);
        guide3_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                  g1.setVisible(false);
                  g2.setVisible(false);
                  g3.setVisible(true);
                  g3_details.setVisible(true);
                  g2_details.setVisible(false);
                  g1_details.setVisible(false);
              
            }
        });
        JLabel name3 = new JLabel("Guide Name");
        name3.setFont(new Font( "Bookman Old Style",Font.BOLD, 15));
        name3.setBounds(100, 30, 150, 50);
        text_name3=new JTextField();
        text_name3.setFont(f);
        text_name3.setBounds(300, 30, 250, 50);
        JLabel gender3 = new JLabel("Guide's Gender");
        gender3.setFont(new Font( "Bookman Old Style",Font.BOLD, 15));
        gender3.setBounds(100, 130, 150, 50);
        text_gender3=new JTextField();
        text_gender3.setFont(f);
        text_gender3.setBounds(300, 130, 250, 50);
        JLabel phno3 = new JLabel("Contact number");
        phno3.setFont(new Font( "Bookman Old Style",Font.BOLD, 15));
        phno3.setBounds(100, 230, 150, 50);
        text_phno3=new JTextField();
        text_phno3.setFont(f);
        text_phno3.setBounds(300, 230, 250, 50);
        JLabel days3 = new JLabel("Choose days");
        days3.setFont(new Font( "Bookman Old Style",Font.BOLD, 15));
        days3.setBounds(100, 330, 150, 50);
        box3=new JComboBox(day);
        box3.setBounds(300,330, 250, 50);
        box3.setBackground(Color.WHITE);
        box3.setFont(new Font( "Bookman Old Style",Font.PLAIN, 15));
        box3.setFocusable(false);
        box3.addItemListener(this);
        JLabel amount3 = new JLabel("Amount per Day");
        amount3.setFont(new Font( "Bookman Old Style",Font.BOLD, 15));
        amount3.setBounds(100, 430, 150, 50);
        text_amount3=new JTextField();
        text_amount3.setFont(f);
        text_amount3.setBounds(300, 430, 250, 50);
        g3_details.add(amount3);
        g3_details.add(name3);
        g3_details.add(gender3);
        g3_details.add(phno3);
        g3_details.add(days3);
        g3_details.add(text_amount3);
        g3_details.add(text_gender3);
        g3_details.add(text_name3);
        g3_details.add(text_phno3);
        g3_details.add(box3);
        g3_details.add(guide3_button);
        g3_details.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
        g3_details.setBackground(new Color(204, 225, 228 ));
        g3_details.setBounds(800, 120, 800, 650);

        ImageIcon home_icon=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\Facebook Post 940x788 px (2).jpeg");
        back = new JButton(home_icon);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.setBackground(new Color(255,255,255));
        back.setBounds(50, 810, 70, 60);
        back.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back) 
                
                Guide_frame.dispose();
            }
        });
        
     
        g1_details.setLayout(null);
        g2_details.setLayout(null);
        g3_details.setLayout(null);
        Guide_frame.add(back);
        Guide_frame.add(g1);
        Guide_frame.add(g2);
        Guide_frame.add(g3);
        Guide_frame.add(district_label);
        Guide_frame.add(guide1_label);
        Guide_frame.add(guide2_label);
        Guide_frame.add(guide3_label);
        Guide_frame.add(g1_details);
        Guide_frame.add(g2_details);
        Guide_frame.add(g3_details);
        Guide_frame.getContentPane().setBackground(new Color(218, 215, 241));
        Guide_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Guide_frame.getRootPane().setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(70, 30, 30, 30, new Color(82, 78, 114)), "Guide_Details", 2, 2, new Font("Bookman Old Style", Font.CENTER_BASELINE, 30), new Color(255,255,255)));
        Guide_frame.setBounds(0, 0, 1920, 1025);
        Guide_frame.setLayout(null);
        Guide_frame.setVisible(true);
    }
     @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==box1){
            days1=String.valueOf(box1.getSelectedItem());
        }
         if(e.getSource()==box2){
            days2=String.valueOf(box2.getSelectedItem());
        }
          if(e.getSource()==box3){
            days3=String.valueOf( box3.getSelectedItem());
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==guide1_button){
           guide = PlaceDescription.guideId1;;
           days=days1;
           try {
            GuideBooking_Bean gbb = new GuideBooking_Bean();
            gbb.setNo_of_days(days);
            gbb.setPaymentid(payid);
            gbb.setUserid(userid);
            gbb.setGuideid(guide);
            gbb.setBooked(book);
            Socket s = new Socket("localHost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(gbb);
            JOptionPane.showMessageDialog(Guide_frame,"Your Booking is successful!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        }
        else if(ae.getSource()==guide2_button){
            guide = PlaceDescription.guideId2;
            days=days2;
            try {
            GuideBooking_Bean gbb = new GuideBooking_Bean();
            gbb.setNo_of_days(days);
            gbb.setPaymentid(payid);
            gbb.setUserid(userid);
            gbb.setGuideid(guide);
            gbb.setBooked(book);
            Socket s = new Socket("localHost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(gbb);
            JOptionPane.showMessageDialog(Guide_frame,"Your Booking is successful!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        }
        else if(ae.getSource()==guide3_button){
            guide = PlaceDescription.guideId3;
            System.out.println(guide);
            System.out.println(guide);
            days=days3;
            try {
            GuideBooking_Bean gbb = new GuideBooking_Bean();
            gbb.setNo_of_days(days);
            gbb.setPaymentid(payid);
            gbb.setUserid(userid);
            gbb.setGuideid(guide);
            gbb.setBooked(book);
            Socket s = new Socket("localHost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(gbb);
            JOptionPane.showMessageDialog(Guide_frame,"Your Booking is successful!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        }
        
        
        
    }
    public static void main(String[] args) {
        new Guide();
    }

    
}

