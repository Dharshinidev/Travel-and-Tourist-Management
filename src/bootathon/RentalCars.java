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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class RentalCars {

    JFrame cars_frame;
    JButton back;
    JLabel title;
    
    JLabel model_label1, carId_label1, Driver_label1,rent_label1;
    JTextField model_textfield1, carId_textfield1,rent_textfield1;
    ButtonGroup bg1;
    JRadioButton YES1, NO1;
    JButton book_button1, detail_button1;
    Boolean error1;
    JPanel panel1;

    JLabel model_label2, carId_label2, Driver_label2,rent_label2;
    JTextField model_textfield2, carId_textfield2,rent_textfield2;
    ButtonGroup bg2;
    JRadioButton YES2, NO2;
    JButton book_button2, detail_button2;
    Boolean error2;
    JPanel panel2;

    JLabel model_label3, carId_label3, Driver_label3,rent_label3;
    JTextField model_textfield3, carId_textfield3,rent_textfield3;
    ButtonGroup bg3;
    JRadioButton YES3, NO3;
    JButton book_button3, detail_button3;
    Boolean error3;
    JPanel panel3;

    JLabel lDistrict,model_label4, carId_label4, Driver_label4,rent_label4;
    JTextField tDistrict, model_textfield4, carId_textfield4,rent_textfield4;
    ButtonGroup bg4;
    JRadioButton YES4, NO4;
    JButton book_button4, detail_button4;
    Boolean error4;
    JPanel panel4;
    String db1,db2,db3,db4;
    RentalCars() throws Exception { 
        cars_frame = new JFrame();
        
        Font font =new Font("Bookman Old Style",Font.BOLD,15);
        Font font1 =new Font("Bookman Old Style",Font.PLAIN,12);

        String dis="District"+"    district";
        lDistrict = new JLabel();
        lDistrict.setBounds(750, 30, 500, 40);
        lDistrict.setFont(new Font("Bookman Old Style",Font.BOLD,28));
        cars_frame.add(lDistrict);
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(200, 70, 640, 370);
        panel1.setBackground(Color.WHITE);
        model_label1 = new JLabel("Car Model");
        model_label1.setFont(font);
        model_label1.setBounds(50, 50, 250, 40);
        panel1.add(model_label1);
        model_textfield1 = new JTextField();
        model_textfield1.setBackground(new Color(255,255,255));
        model_textfield1.setFont(font1);
        model_textfield1.setBounds(300, 50, 250, 40);
        panel1.add(model_textfield1);
        model_textfield1.setEditable(false);

        carId_label1 = new JLabel("Car ID");
        carId_label1.setBounds(50, 100, 250, 40);
        carId_label1.setFont(font);
        panel1.add(carId_label1);
        carId_textfield1 = new JTextField();
        carId_textfield1.setBackground(Color.WHITE);
        carId_textfield1.setFont(font1);
        carId_textfield1.setBounds(300, 100, 250, 40);
        panel1.add(carId_textfield1);
        carId_textfield1.setEditable(false);

        rent_label1 = new JLabel("Car Rent Per Day");
        rent_label1.setBounds(50, 150, 250, 40);
        rent_label1.setFont(font);
        panel1.add(rent_label1);
        rent_textfield1 = new JTextField();
        rent_textfield1.setFont(font1);
        rent_textfield1.setBackground(Color.WHITE);
        rent_textfield1.setBounds(300, 150, 250, 40);
        panel1.add(rent_textfield1);
        rent_textfield1.setEditable(false);

        Driver_label1 = new JLabel("Driver");
        Driver_label1.setFont(font);
        Driver_label1.setBounds(50, 200, 250, 40);
        panel1.add(Driver_label1);

        bg1 = new ButtonGroup();
        YES1 = new JRadioButton("REQUIRED");
        NO1 = new JRadioButton("NOT REQUIRED");
        YES1.setBounds(300, 200, 100, 40);
        YES1.setFont(font1);
        YES1.setBackground(Color.WHITE);
        NO1.setBounds(420, 200, 150, 40);
        NO1.setBackground(Color.WHITE);
        NO1.setFont(font1);
        bg1.add(YES1);
        bg1.add(NO1);
        panel1.add(YES1);
        panel1.add(NO1);
        JOptionPane jp1 = new JOptionPane();
        YES1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button1.setVisible(true);
                
            }
        });
        NO1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button1.setVisible(false);
            }
        });
        book_button1 = new JButton("BOOK");
        book_button1.setBounds(50, 300, 150, 40);
        book_button1.setFont(font);
        book_button1.setBackground(new Color(108, 207, 241 ));
        panel1.add(book_button1);
        book_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                error1 = false;
                if (YES1.isSelected()) {
                    db1="YES";
                } 
                else if(NO1.isSelected()){
                    db1="NO";
                }
               else {
                    jp1.showMessageDialog(cars_frame, "ENTER EITHER DRIVER WANTED OR NOT IN DRIVER DETAIL 1");
                    error1 = true;
                }
                if (e.getSource() == book_button1) {
                    if (error1 == false) {
                        if(PlaceDescription.carbooked1.equals("YES")){
                            jp1.showMessageDialog(cars_frame,"This Car is already Booked");
                        }
                        else{
                            RentalCarsBooking_Bean rcbb = new RentalCarsBooking_Bean();
                            rcbb.setUserid(Home_page.mail);
                            rcbb.setPaymentid(Home_page.payid);
                            rcbb.setCarid(PlaceDescription.carId1);
                            rcbb.setCarbooked("YES");
                            rcbb.setDriverbooked(db1);
                            try{
                            Socket s = new Socket("localhost",7000);
                            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                            oos.writeObject(rcbb);
                            }
                            catch(Exception se){}
                        }
                    }
                    
                }
            }
        });
        detail_button1 = new JButton("Click Here to View Driver Details");
        detail_button1.setBackground(new Color(108, 207, 241 ));
        detail_button1.setFont(font);
        detail_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == detail_button1) {
                    //JTextField dname_textfield,dcontact_textfield,dgender_textfield,damount_textfield;
                    DriverDetails dd =new DriverDetails();
                    dd.dname_textfield.setText(PlaceDescription.driverName1);
                    dd.dcontact_textfield.setText(PlaceDescription.driverContactNumber1);
                    dd.dgender_textfield.setText(PlaceDescription.driverGender1);
                    dd.damount_textfield.setText(PlaceDescription.driverAmountperday1);
                }
            }
        });
        detail_button1.setBounds(300, 300, 300, 40);
        panel1.add(detail_button1);
        detail_button1.setVisible(false);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(200, 470, 640, 370);
        panel2.setBackground(Color.WHITE);
        model_label2 = new JLabel("Car Model");
        model_label2.setBounds(50,50, 120, 40);
        model_label2.setFont(font);
        panel2.add(model_label2);
        model_textfield2 = new JTextField();
        model_textfield2.setBounds(300, 50, 250, 40);
        model_textfield2.setFont(font1);
        model_textfield2.setBackground(Color.WHITE);
        panel2.add(model_textfield2);
        model_textfield2.setEditable(false);

        carId_label2 = new JLabel("Car ID");
        carId_label2.setBounds(50, 100, 250, 40);
        carId_label2.setFont(font);
        panel2.add(carId_label2);
        carId_textfield2 = new JTextField();
        carId_textfield2.setBounds(300, 100, 250, 40);
        carId_textfield2.setFont(font1);
        carId_textfield2.setBackground(Color.WHITE);
        panel2.add(carId_textfield2);
        carId_textfield2.setEditable(false);

        rent_label2 = new JLabel("Car Rent Per Day");
        rent_label2.setBounds(50, 150, 250, 40);
        rent_label2.setFont(font);
        panel2.add(rent_label2);
        rent_textfield2 = new JTextField();
        rent_textfield2.setFont(font1);
        rent_textfield2.setBackground(Color.WHITE);
        rent_textfield2.setBounds(300, 150, 250, 40);
        panel2.add(rent_textfield2);
        rent_textfield2.setEditable(false);

        Driver_label2 = new JLabel("Driver");
        Driver_label2.setBounds(50, 200, 250, 40);
        Driver_label2.setFont(font);
        panel2.add(Driver_label2);

        bg2 = new ButtonGroup();
        YES2 = new JRadioButton("REQUIRED");
        YES2.setBackground(Color.WHITE);
        YES2.setFont(font1);
        NO2 = new JRadioButton("NOT REQUIRED");
        NO2.setFont(font1);
        NO2.setBackground(Color.WHITE);
        YES2.setBounds(300, 200, 100, 40);
        NO2.setBounds(420, 200, 150, 40);
        bg2.add(YES2);
        bg2.add(NO2);
        panel2.add(YES2);
        panel2.add(NO2);
        YES2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button2.setVisible(true);
            }
        });
        NO2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button2.setVisible(false);
            }
        });
        book_button2 = new JButton("BOOK");
        book_button2.setBounds(50, 300, 150, 40);
        book_button2.setFont(font);
        book_button2.setBackground(new Color(108, 207, 241 ));
        panel2.add(book_button2);
        book_button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                error2 = false;
                if (YES2.isSelected()) {
                    db2="YES";
                } 
                else if(NO2.isSelected()){
                    db2="NO";
                }
               else {
                    jp1.showMessageDialog(cars_frame, "ENTER EITHER DRIVER WANTED OR NOT IN DRIVER DETAIL 1");
                    error2= true;
                }
                if (e.getSource() == book_button2) {
                    if (error2 == false) {
                        if(PlaceDescription.carbooked2.equals("YES")){
                            jp1.showMessageDialog(cars_frame,"This Car is already Booked");
                        }
                        else{
                            RentalCarsBooking_Bean rcbb = new RentalCarsBooking_Bean();
                            rcbb.setUserid(Home_page.mail);
                            rcbb.setPaymentid(Home_page.payid);
                            rcbb.setCarid(PlaceDescription.carId2);
                            rcbb.setCarbooked("YES");
                            rcbb.setDriverbooked(db2);
                            try{
                            Socket s = new Socket("localhost",7000);
                            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                            oos.writeObject(rcbb);
                            }
                            catch(Exception se){}
                        }
                    }
                    
                }
            }
        });
        detail_button2 = new JButton("Click Here to View Driver Details");
        detail_button2.setBackground(new Color(108, 207, 241 )); 
        detail_button2.setFont(font);
        detail_button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == detail_button2) {
                    DriverDetails dd =new DriverDetails();
                    dd.dname_textfield.setText(PlaceDescription.driverName2);
                    dd.dcontact_textfield.setText(PlaceDescription.driverContactNumber2);
                    dd.dgender_textfield.setText(PlaceDescription.driverGender2);
                    dd.damount_textfield.setText(PlaceDescription.driverAmountperday2);
                }
            }
        });
        detail_button2.setBounds(300, 300, 300, 40);
        panel2.add(detail_button2);
        detail_button2.setVisible(false);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(1050,70, 640, 370);
        panel3.setBackground(Color.WHITE);
        model_label3 = new JLabel("Car Model");
        model_label3.setFont(font);
        model_label3.setBounds(50, 50, 250, 40);
        panel3.add(model_label3);
        model_textfield3 = new JTextField();
        model_textfield3.setFont(font1);
        model_textfield3.setBackground(Color.WHITE);
        model_textfield3.setBounds(300, 50, 250, 40);
        panel3.add(model_textfield3);
        model_textfield3.setEditable(false);

        carId_label3 = new JLabel("Car ID");
        carId_label3.setBounds(50, 100, 250, 40);  
        carId_label3.setFont(font);
        panel3.add(carId_label3);
        carId_textfield3 = new JTextField();
        carId_textfield3.setFont(font1);
        carId_textfield3.setBackground(Color.WHITE);
        carId_textfield3.setBounds(300, 100, 250, 40);
        panel3.add(carId_textfield3);
        carId_textfield3.setEditable(false);

        rent_label3 = new JLabel("Car Rent Per Day");
        rent_label3.setBounds(50, 150, 250, 40);
        rent_label3.setFont(font);
        panel3.add(rent_label3);
        rent_textfield3 = new JTextField();
        rent_textfield3.setBounds(300, 150, 250, 40);
        rent_textfield3.setFont(font1);
        rent_textfield3.setBackground(Color.WHITE);
        panel3.add(rent_textfield3);
        rent_textfield3.setEditable(false);

        Driver_label3 = new JLabel("Driver");
        Driver_label3.setBounds(50, 200, 250, 40);
        Driver_label3.setFont(font);
        panel3.add(Driver_label3);

        bg3 = new ButtonGroup();
        YES3 = new JRadioButton("REQUIRED");
        NO3 = new JRadioButton("NOT REQUIRED");
        YES3.setBounds(300, 200, 100, 40);
        YES3.setBackground(Color.WHITE);
        YES3.setFont(font1);
        NO3.setBounds(420, 200, 150, 40);
        NO3.setBackground(Color.WHITE);
        NO3.setFont(font1);
        bg3.add(YES3);
        bg3.add(NO3);
        panel3.add(YES3);
        panel3.add(NO3);
        YES3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button3.setVisible(true);
            }
        });
        NO3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button3.setVisible(false);
            }
        });
        book_button3 = new JButton("BOOK");
        book_button3.setBounds(50, 300, 150, 40);
        book_button3.setFont(font);
        book_button3.setBackground(new Color(108, 207, 241));
        panel3.add(book_button3);
        book_button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                error3 = false;
                if (YES3.isSelected()) {
                    db3="YES";
                } 
                else if(NO3.isSelected()){
                    db3="NO";
                }
               else {
                    jp1.showMessageDialog(cars_frame, "ENTER EITHER DRIVER WANTED OR NOT IN DRIVER DETAIL 1");
                    error3 = true;
                }
                if (e.getSource() == book_button3) {
                    if (error3 == false) {
                        if(PlaceDescription.carbooked3.equals("YES")){
                            jp1.showMessageDialog(cars_frame,"This Car is already Booked");
                        }
                        else{
                            RentalCarsBooking_Bean rcbb = new RentalCarsBooking_Bean();
                            rcbb.setUserid(Home_page.mail);
                            rcbb.setPaymentid(Home_page.payid);
                            rcbb.setCarid(PlaceDescription.carId3);
                            rcbb.setCarbooked("YES");
                            rcbb.setDriverbooked(db3);
                            try{
                            Socket s = new Socket("localhost",7000);
                            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                            oos.writeObject(rcbb);
                            }
                            catch(Exception se){}
                        }
                    }
                    
                }
            }
        });
        detail_button3 = new JButton("Click Here to View Driver Details");
        detail_button3.setBounds(300, 300, 300, 40);
        detail_button3.setBackground(new Color(108, 207, 241));
        detail_button3.setFont(font);
        detail_button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == detail_button3) {
                    DriverDetails dd =new DriverDetails();
                    dd.dname_textfield.setText(PlaceDescription.driverName3);
                    dd.dcontact_textfield.setText(PlaceDescription.driverContactNumber3);
                    dd.dgender_textfield.setText(PlaceDescription.driverGender3);
                    dd.damount_textfield.setText(PlaceDescription.driverAmountperday3);
                }
            }
        });
        panel3.add (detail_button3);
        detail_button3.setVisible(false);

        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(1050, 470, 640, 370);
        panel4.setBackground(Color.WHITE);
        model_label4 = new JLabel("Car Model");
        model_label4.setBounds(50, 50, 250, 40);
        model_label4.setFont(font);
        panel4.add(model_label4);
        model_textfield4 = new JTextField();
        model_textfield4.setFont(font1);
        model_textfield4.setBackground(Color.WHITE);
        model_textfield4.setBounds(300, 50, 250, 40);
        panel4.add(model_textfield4);
        model_textfield4.setEditable(false);

        carId_label4 = new JLabel("Car ID");
        carId_label4.setBounds(50, 100, 250, 40);
        carId_label4.setFont(font);
        panel4.add(carId_label4);
        carId_textfield4 = new JTextField();
        carId_textfield4.setBounds(300, 100, 250, 40);
        carId_textfield4.setFont(font1);
        carId_textfield4.setBackground(Color.white);
        panel4.add(carId_textfield4);
        carId_textfield4.setEditable(false);

        rent_label4 = new JLabel("Car Rent Per Day");
        rent_label4.setBounds(50, 150, 250, 40);
        rent_label4.setFont(font);
        panel4.add(rent_label4);
        rent_textfield4 = new JTextField();
        rent_textfield4.setBounds(300, 150, 250, 40);
        rent_textfield4.setFont(font1);
        rent_textfield4.setBackground(Color.WHITE);
        panel4.add(rent_textfield4);
        rent_textfield4.setEditable(false);

        Driver_label4 = new JLabel("Driver");
        Driver_label4.setFont(font);
        Driver_label4.setBounds(50, 200, 250, 40);
        panel4.add(Driver_label4);

        bg4 = new ButtonGroup();
        YES4 = new JRadioButton("REQUIRED");
        NO4 = new JRadioButton("NOT REQUIRED");
        YES4.setBounds(300, 200, 100, 40);
        YES4.setFont(font1);
        YES4.setBackground(Color.WHITE);
        NO4.setBounds(420, 200, 150, 40);
        NO4.setFont(font1);
        NO4.setBackground(Color.WHITE);
        bg4.add(YES4);
        bg4.add(NO4);
        panel4.add(YES4);
        panel4.add(NO4);
        YES4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button4.setVisible(true);
            }
        });
        NO4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detail_button4.setVisible(false);
            }
        });
        book_button4 = new JButton("BOOK");
        book_button4.setBounds(50, 300, 150, 40);
        panel4.add(book_button4);
        book_button4.setFont(font);
        book_button4.setBackground(new Color(108, 207, 241 )); 
        book_button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                error4 = false;
                if (YES4.isSelected()) {
                    db4="YES";
                } 
                else if(NO4.isSelected()){
                    db4="NO";
                }
               else {
                    jp1.showMessageDialog(cars_frame, "ENTER EITHER DRIVER WANTED OR NOT IN DRIVER DETAIL 1");
                    error4 = true;
                }
                if (e.getSource() == book_button4) {
                    if (error4 == false) {
                        if(PlaceDescription.carbooked4.equals("YES")){
                            jp1.showMessageDialog(cars_frame,"This Car is already Booked");
                        }
                        else{
                            RentalCarsBooking_Bean rcbb = new RentalCarsBooking_Bean();
                            rcbb.setUserid(Home_page.mail);
                            rcbb.setPaymentid(Home_page.payid);
                            rcbb.setCarid(PlaceDescription.carId4);
                            rcbb.setCarbooked("YES");
                            rcbb.setDriverbooked(db4);
                            try{
                            Socket s = new Socket("localhost",7000);
                            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                            oos.writeObject(rcbb);
                            }
                            catch(Exception se){}
                        }
                    }
                    
                }
            }
        });
        detail_button4 = new JButton("Click Here to View Driver Details");
        detail_button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == detail_button4) {
                    DriverDetails dd =new DriverDetails();
                    dd.dname_textfield.setText(PlaceDescription.driverName4);
                    dd.dcontact_textfield.setText(PlaceDescription.driverContactNumber4);
                    dd.dgender_textfield.setText(PlaceDescription.driverGender4);
                    dd.damount_textfield.setText(PlaceDescription.driverAmountperday4);
                }
            }
        });
        detail_button4.setBounds(300, 300, 300, 40);
        detail_button4.setFont(font);
        detail_button4.setBackground(new Color(108, 207, 241 )); 
        panel4.add(detail_button4);
        detail_button4.setVisible(false);
 
        back = new JButton(new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\Facebook Post 940x788 px (2).jpeg"));
        back.setBounds(60,810, 90,60);
        back.setBackground(Color.WHITE);
        back.setFocusable(false);
        cars_frame.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                     cars_frame.dispose();
                }
            }
        });
        cars_frame.add(panel1);
        cars_frame.add(panel2);
        cars_frame.add(panel3);
        cars_frame.add(panel4);
        panel1.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, new Color(192, 219, 228 )));
        panel2.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, new Color(192, 219, 228 )));
        panel3.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, new Color(192, 219, 228 )));
        panel4.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, new Color(192, 219, 228 )));
        
        cars_frame.getContentPane().setBackground(new Color(243, 226, 229  ));
        cars_frame.setBackground(new Color(222, 68, 96));
        cars_frame.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(70, 30,30, 30,new Color(222, 68, 96 )) , "Rental Cars", 2, 2,new Font("Bookman Old Style",Font.CENTER_BASELINE,30),new Color(255,255,255 )));
        cars_frame.setBounds(0, 0, 1950, 1030);
        cars_frame.setLayout(null);
        cars_frame.setVisible(true);
        cars_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String args[]) throws Exception{
       new RentalCars();
    }
}

