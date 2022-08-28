/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;


public class  Payment_Processing {
    JFrame payment;
    JLabel mode;
    JComboBox paymode;
    JTextField enteramount;
    JLabel amount ,totalamount;
    JButton pay,logout;
    String ode;
     Payment_Processing(){
        String m1="mail"+"paymentpage";
        payment =new JFrame(m1);
       
        totalamount=new JLabel("Total amount");
        totalamount.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        totalamount.setBounds(150,100,300,50);
        payment.add(totalamount);
        
        amount=new JLabel("Enter Total amount");
        amount.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        amount.setBounds(150,200,300,50);
        payment.add(amount);
        
        enteramount=new JTextField();
        enteramount.setFont(new Font("Bookman Old Style",Font.PLAIN,15));
        enteramount.setBounds(600,200,300,50);
        payment.add(enteramount);
        
        pay=new JButton("Confirm Payment");
        pay.setFont(new Font("Bookman Old Style",Font.PLAIN,15));
        pay.setBounds(430,430,300,50);
        pay.setBackground(new Color(245, 130, 151 ));
        pay.setForeground(Color.BLACK);
        payment.add(pay);
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==pay){
                   if(enteramount.getText().equals(Home_page.totalvalue)){
                       
                   
             String to = Home_page.mail;//change accordingly  
      String from = "19euec014@skcet.ac.in"; 
      String pass="anus@123";
       
      Properties properties = System.getProperties();  
      
                properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
      
          Session session = Session.getInstance(properties,new Authenticator() {

                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, pass);
                        }

                });
    String bodyText = addColor("  Your Payment for your adventure is Successful  ",
           "\n",    "\nBon Voyage",Color.BLACK);
     String msg="";
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
         message.setContent(bodyText, "text/html; charset=UTF-8");
         message.setSubject("Travel and Tourism Management-Payment Confirmation Mail");  
        
    
      
     
         Transport.send(message);  
         JOptionPane.showMessageDialog(payment,"Mail has been successfully sent to your Email");
         System.out.println("message sent successfully...."); 
         
      }
      
      catch(Exception ebh){
          
      }
                   }}}        
            

     private  String addColor(String msg,String a, String b,Color color) {
        String hexColor = String.format("#%06X",  ( color.getRGB()));
    String colorMsg = "<font size =\"10\" face=\"Bookman Old Style \" > "+"🎉🎉🎉🎉🎉"+ msg + "🎉🎉🎉🎉🎉"+b+a;
    return colorMsg;
   
            }
        });
        payment.setBounds(300,150,1200,600);
        logout=new JButton("Logout");
        logout.setFont(new Font("Bookman Old Style",Font.PLAIN,15));
        logout.setBounds(150,430,150,50);
        logout.setBackground(new Color(245, 130, 151 ));
        logout.setForeground(Color.BLACK);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==logout){
            
            payment.dispose();
        }
            }
        });
       
        payment.add(logout);
        
        payment.setLayout(null);
        payment.getContentPane().setBackground(Color.WHITE);
        payment.getRootPane().setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30,new Color(234, 111, 134 )));
        payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        payment.setVisible(true);
        
    }
    public static void main(String[] args) {
        new  Payment_Processing();
    }
}
