/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Payment_Receipt implements ActionListener{
    JFrame f=new JFrame("Payment Receipt");
    JLabel name=new JLabel("Name");
    JLabel transport=new JLabel("Transportation Charges");
    JLabel accommodation=new JLabel("Accommodation Charges");
    JLabel cars=new JLabel("Rental Car Charges");
    JLabel guide=new JLabel("Guide Charges");
    JLabel package_tours=new JLabel("Package Tour");
    JLabel sep1=new JLabel("---------------------------------------------------------------------------------------------------------------");
    JLabel total=new JLabel("Total Amount");
    JLabel sep2=new JLabel("---------------------------------------------------------------------------------------------------------------"); 
    JLabel name_value=new JLabel();
    JLabel payid=new JLabel();
    JLabel transport_value=new JLabel();
    JLabel accommodation_value=new JLabel();
    JLabel cars_value=new JLabel();
    JLabel guide_value=new JLabel();
    JLabel package_tours_value=new JLabel();
    JLabel total_value=new JLabel();
    JButton home=new JButton("Logout");
    JButton pay=new JButton("PAY");
    
    Payment_Receipt(){
        f.setBounds(300,180,1380,730);
        f.setLayout(null);
        f.setVisible(true);
        Font font=new Font("Bookman Old Style",Font.BOLD,20);
        name.setBounds(450,120,350,40);
        name.setFont(font);
        f.add(name);
        payid.setBounds(450,70,350,40);
        payid.setFont(font);
        f.add(payid);
        transport.setBounds(450,170,350,40);
        transport.setFont(font);
        f.add(transport);
        accommodation.setBounds(450,220,350,40);
        accommodation.setFont(font);
        f.add(accommodation);
        cars.setBounds(450,270,350,40);
        cars.setFont(font);
        f.add(cars);
        guide.setBounds(450,320,350,40);
        guide.setFont(font);
        f.add(guide);
        package_tours.setBounds(450,370,350,40);
        package_tours.setFont(font);
        f.add(package_tours);
        sep1.setBounds(450,420,600,40);
        sep1.setFont(font);
        f.add(sep1);
        total.setBounds(450,460,350,40);
        total.setFont(font);
        f.add(total);
        sep2.setBounds(450,500,600,40);
        sep2.setFont(font);
        f.add(sep2);
        name_value.setBounds(830,120,350,40);
        name_value.setFont(font);
        f.add(name_value);
        transport_value.setBounds(830,170,350,40);
        transport_value.setFont(font);
        f.add(transport_value);
        accommodation_value.setBounds(830,220,350,40);
        accommodation_value.setFont(font);
        f.add(accommodation_value);
        cars_value.setBounds(830,270,350,40);
        cars_value.setFont(font);
        f.add(cars_value);
        guide_value.setBounds(830,320,350,40);
        guide_value.setFont(font);
        f.add(guide_value);
        package_tours_value.setBounds(830,370,350,40);
        package_tours_value.setFont(font);
        f.add(package_tours_value);
        total_value.setBounds(830,460,350,40);
        total_value.setFont(font);
        f.add(total_value);
        home.setBounds(150,550,150,40);
        home.setBackground(new Color(222, 68, 96));
        home.setForeground(Color.BLACK);
        home.setFont(font);
        home.addActionListener(this);
        f.add(home);
        pay.setBounds(720,550,150,40);
        pay.setFont(font);
        pay.addActionListener(this);
        pay.setBackground(new Color(222, 68, 96));
        pay.setForeground(Color.BLACK);
        f.add(pay);
        f.setBackground(new Color(222, 68, 96 ));
        f.getContentPane().setBackground(new Color(255,255,255));
        f.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(50,30,30, 30,new Color(222, 68, 96  )) , "Payment Receipt", 2, 2,new Font("Bookman Old Style",Font.BOLD,40),new Color(255,255,255 )));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==home){
            
            f.dispose();
        }
        else if(e.getSource()==pay){
            
            Payment_Processing pp=new Payment_Processing();
            pp.totalamount.setText("Total Amount "+Home_page.totalvalue);
            
        }}
    

public static void main(String args[]){
        new Payment_Receipt();
    }   

}