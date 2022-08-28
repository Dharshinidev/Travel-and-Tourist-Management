/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.lang.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.net.*;

class Home_page implements ActionListener{
    JFrame home_frame;
    JButton ticket_booking,package_tours,Holidays_destination,register_button ,login_button,payment_button;
    JTextField user_name,pass;
    String user,pass_W;
    JLabel user_label,pass_label,login_label,text_label;
    JPanel panel;
    static String mail,payid; 
    static String totalvalue;
    public Home_page() {
       
       home_frame=new JFrame();
       home_frame.setTitle("Travel and Tourist Management");
       home_frame.setBackground(new Color(31, 109, 133 ));
       panel=new JPanel();
       home_frame.setUndecorated(false); 
       /////LABEL//
       text_label=new JLabel("LOGIN or SIGNUP");
       text_label.setBounds(70,50,300,30);
       user_label=new JLabel("Email_Id");
       user_label.setBounds(20, 150, 120,70);
       pass_label=new JLabel("Password");
       pass_label.setBounds(20, 250, 120, 70);
       user_label.setFont(new Font("Bauhaus Bold",Font.BOLD, 20));
       pass_label.setFont(new Font("Bauhaus Bold" ,Font.BOLD, 20));
       text_label.setFont(new Font( "Bookman Old Style",Font.BOLD, 25));
       user_label.setForeground(new Color(0, 5, 6 ));
       pass_label.setForeground(new Color(0, 5, 6 ));
       text_label.setForeground(new Color(48, 137, 211) );
       
       user_name=new JTextField();
       user_name.setBackground(new Color(242, 248, 249 ));
       user_name.setBorder(BorderFactory. createLineBorder(new Color(100, 17, 17 ),4));
       user_name.setBounds(200,150,250,50);
       user_name.setFont(new Font(Font.SERIF,Font.PLAIN, 15));
       pass=new JPasswordField();
       pass.setBackground(new Color(242, 248, 249 ));
       pass.setBorder(BorderFactory. createLineBorder(new Color(100, 17, 17 ),4));
       pass.setBounds(200,250,250,50);
     
       login_button =new JButton("Login");
       login_button.setFont(new Font("SERIF",Font.PLAIN, 20));
       login_button.setForeground(Color.white);
       login_button.setFocusable(true);
       login_button.setBackground(new Color(48, 137, 211 ));
       login_button.setBounds(200,400, 100 ,40);
       login_button.addActionListener(this);
         /*  @Override
           public void actionPerformed(ActionEvent e) {
             try{
               
                String mail=user_name.getText();
                String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                Pattern pattern = Pattern.compile(EMAIL_REGEX);
                Matcher mat = pattern.matcher(mail);
                String passfield=pass.getText();
                String password="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                Pattern pattern1 = Pattern.compile(password);
                Matcher mat1 = pattern1.matcher(passfield);
                if(!mat.matches()){
                    JOptionPane.showMessageDialog(home_frame,"Enter Valid Email-id");
                }
                else if(!mat.matches()){
                    JOptionPane.showMessageDialog(home_frame,"Enter Valid Password");
                }
                else {
                    Login_Bean lb = new Login_Bean();
                    lb.setUserid(mail);
                    lb.setPass(passfield);
                 
                      Socket c1 = new Socket("localhost",7000);
                      ObjectOutputStream loos = new ObjectOutputStream(c1.getOutputStream());
                      loos.writeObject(lb);
                      ObjectInputStream lois = new ObjectInputStream(c1.getInputStream());
                      Object obj=lois.readObject();
                      LoginAccessMsg_Bean loacc = (LoginAccessMsg_Bean)obj;
                      String msg = loacc.getMsg();
                      if(msg=="0")
                      {
                           JOptionPane.showMessageDialog(home_frame, "Wrong User-id");
                      }
                      else if(msg=="-1")
                      {
                          JOptionPane.showMessageDialog(home_frame,"Password incorrect");
                      }
                      else if(msg=="1")
                      {
                           JOptionPane.showMessageDialog(home_frame,"Login successful");
                           ticket_booking.setEnabled(true);
                           payment_button.setEnabled(true);
                           Holidays_destination.setEnabled(true);
                           package_tours.setEnabled(true);
                      }
                  }
             } 
                catch(Exception a){
                 System.out.println(a);
             } 
    }
       });*/
                  
       ticket_booking=new JButton("Ticket Booking");
       ticket_booking.setBounds(0, 0, 530,50);
       ticket_booking.setFont(new Font("SERIF",Font.PLAIN, 20));
       ticket_booking.setForeground(new Color(255,255,255));
       ticket_booking.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
       ticket_booking.setBackground(new Color(242,5,52 ));
       ticket_booking.setFocusable(false);
       ticket_booking.setEnabled(false);
       ticket_booking.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            if(e.getSource()==ticket_booking){
                
                new TicketBooking();  
            }
           }
       });
       package_tours=new JButton("Package Tours");
       package_tours.setBounds(960,0,420,50);
       package_tours.setFont(new Font("SERIF",Font.PLAIN, 20));
       package_tours.setForeground(Color.WHITE);
       package_tours.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
       package_tours.setFocusable(false);
       package_tours.setEnabled(false);
       package_tours.setBackground(new Color(242,5,52));//35, 33, 33//
       package_tours.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(e.getSource()==package_tours){
                   new SearchPackageTours();
                   
               }
           }
       } );
       Holidays_destination=new JButton("Holiday Destinations");
       Holidays_destination.setBounds(530,0,430,50);
       Holidays_destination.setFont(new Font("SERIF",Font.PLAIN, 20));
       Holidays_destination.setForeground(Color.WHITE);
       Holidays_destination.setFocusable(false);
       Holidays_destination.setEnabled(false);
       Holidays_destination.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
       Holidays_destination.setBackground(new Color(0,5,6));
       Holidays_destination.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   new Destinations();
               } catch (Exception ex) {
                   
               }
             
           }
       });
       register_button=new JButton("Sign Up");
       register_button.setBounds(60,400,100,40);
       register_button.setFont(new Font("SERIF",Font.PLAIN, 20));
       register_button.setForeground(new Color(255,255,255));
       register_button.setFocusable(true);
       register_button.setBackground(new Color(48, 137, 211));
       register_button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              if (e.getSource()==register_button){
                  new register();
                  
              }
           }
       });
       payment_button=new JButton("Payment");
       payment_button.setBounds(1380,0,530,50);
       payment_button.setFont(new Font("SERIF",Font.PLAIN, 20));
       payment_button.setForeground(Color.WHITE);
       payment_button.setFocusable(false);
       payment_button.setEnabled(false);
       payment_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
       payment_button.setBackground(new Color(0,5,6 ));
       payment_button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(e.getSource()==payment_button){
                   try {
                       PaymentId_Bean pb=new PaymentId_Bean();
                       pb.setPaymentid(payid);
                       Socket s = new Socket("localhost",7000);
                       ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                       oos.writeObject(pb);
                       ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                       Payment_Receipt_Bean prb = (Payment_Receipt_Bean)ois.readObject();
                       Payment_Receipt pr = new Payment_Receipt();
                       pr.name_value.setText(prb.getUserid());
                       pr.payid.setText("Payment id        "+prb.getPaymentid());
                       pr.transport_value.setText(prb.getTransport_value());
                       pr.package_tours_value.setText(prb.getPackage_tours_value());
                       pr.accommodation_value.setText(prb.getAccommodation_value());
                       pr.guide_value.setText(prb.getGuide_value());
                       pr.cars_value.setText(prb.getCars_value());
                       pr.total_value.setText(prb.getTotal_value());
                       totalvalue=prb.getTotal_value();
                   } catch (Exception ex) {
                       System.out.print(ex);
                   }
                     
               }
           }
       } );
       //ImageIcon image=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\The_Common_Wanderer_three_week_india_itinerary-4.jpg");
       //JLabel label=new JLabel(image);
       //label.setBounds(530,50,1500,950);
       home_frame.add(ticket_booking);
       home_frame.setBounds(0,0,1960,1035);
       home_frame.add(ticket_booking);
       home_frame.add(package_tours);
       panel.add(user_label);
       panel.add(pass_label);
       panel.add(login_button);
       panel.add(user_name);
       panel.add(pass);
       //home_frame.add(label);
       home_frame.add(payment_button);
       home_frame.add(Holidays_destination);
       panel.add(register_button);
       panel.add(text_label);
       home_frame.add(panel);
       panel.setBounds(0, 200,530, 500);
       panel.setBackground(new Color(255,255,255 ));
       panel.setLayout(null);
       panel.setVisible(true);
       home_frame.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(150, 30,30, 30,new Color(31, 109, 133  )) , "Travel and Tourism Management", 2, 2,new Font("Bookman Old Style",Font.BOLD,38),new Color( 255,255,255  )));
       home_frame.getContentPane().setBackground(new Color(255,255,255)); 
       home_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       home_frame.setLayout(null);
       home_frame.setVisible(true);
        
     }
    @Override
            public void actionPerformed(ActionEvent e){
             try{
                
                mail=user_name.getText();
                String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                Pattern pattern = Pattern.compile(EMAIL_REGEX);
                Matcher mat = pattern.matcher(mail);
                String passfield=pass.getText();
                String password="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                Pattern pattern1 = Pattern.compile(password);
                Matcher mat1 = pattern1.matcher(passfield);
                if(!mat.matches()){
                    JOptionPane.showMessageDialog(home_frame,"Enter Valid Email-id");
                }
                else if(!mat.matches()){
                    JOptionPane.showMessageDialog(home_frame,"Enter Valid Password");
                }
                else {
                    Login_Bean lb = new Login_Bean();
                    lb.setUserid(mail);
                    lb.setPass(passfield);
                   JOptionPane jp = new JOptionPane();
                   
                      Socket c1 = new Socket("localhost",7000);
                      ObjectOutputStream loos = new ObjectOutputStream(c1.getOutputStream());
                      loos.writeObject(lb);
                      ObjectInputStream lois = new ObjectInputStream(c1.getInputStream());
                      Object obj=lois.readObject();
                      LoginAccessMsg_Bean loacc = (LoginAccessMsg_Bean)obj;
                      if(loacc.getMsg().equals("0"))
                      {
                           jp.showMessageDialog(home_frame, "Wrong User-id");
                      }
                      else if(loacc.getMsg().equals("-1"))
                      {
                          jp.showMessageDialog(home_frame,"Password incorrect");
                      }
                      else if(loacc.getMsg().equals("1"))
                      {
                           jp.showMessageDialog(home_frame,"Login successful");
                           payid = (loacc.getPayid());
                           ticket_booking.setEnabled(true);
                           payment_button.setEnabled(true);
                           Holidays_destination.setEnabled(true);
                           package_tours.setEnabled(true);
                      }
                  }
             } 
                catch(Exception a){
                 System.out.println(a);
             } 
    }}
       
               

               
public class Home {
    public static void main(String[] args)  {
       new Home_page();
    }
    
}

