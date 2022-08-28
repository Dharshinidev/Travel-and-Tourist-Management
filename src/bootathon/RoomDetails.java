/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomDetails implements ItemListener,ActionListener{
    JPanel panel1,panel2;
    JFrame frame;
    JLabel title,subtitle1,subtitle2;
    JLabel lac_1,lac_2,lac_master,lnon_ac_1,lnon_ac_2;
    JTextField  tac_1,tac_2,tac_master,tnon_ac_1,tnon_ac_2;  
    JLabel lDate,lroom_type,lno_of_days;
    JTextField tDate,tno_of_days;
    JComboBox room_type;
    String dt,mon,dob,yr,room_Type;
    String roomType[] = {"SELECT ROOMTYPE","AC Single Cot","AC Double Cot","AC Master Room","NON-AC Single Cot","NON-AC Double Cot"};
    JComboBox date1 ,month1,year1;
    String Date[] = {"DATE","1","2","3","4","5","6","7","8","9","10",
                     "11","12","13","14","15","16","17","18","19","20",
                     "21","22","23","24","25","26","27","28","29","30","31"};
    String Month[] = {"MONTH","January","February","March","April","May","June","July",
                      "August","September","October","November","December"};
    String Year[] = {"YEAR","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030",
                     "2031","2032","2033","2034","2035","2036","2037","2038","2039","2040",
                     "2041","2042","2043","2044","2045","2046","2047","2048","2049","2050",};
    JButton check,Back;
    public RoomDetails(){
        frame = new JFrame();
        panel1 = new JPanel(null);
        panel2 = new JPanel(null);
        panel1.setBounds(290, 170, 600, 600);
        panel2.setBounds(1030, 170, 600, 600);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        frame.add(panel1);
        frame.add(panel2);
        
        title = new JLabel("ROOM DETAILS");
        title.setBounds(900, 60, 100, 40);
        frame.add(title);
        
        subtitle1 = new JLabel();
        subtitle1.setBounds(220, 50, 150, 40);
        panel1.add(subtitle1);
        
        lac_1 = new JLabel("AC Single Cot                             :");
        lac_1.setBounds(50, 130, 230, 40);
        panel1.add(lac_1);
        lac_2 = new JLabel("AC Double Cot                             :");
        lac_2.setBounds(50, 210, 230, 40);
        panel1.add(lac_2);
        lac_master = new JLabel("AC Master Room                         :");
        lac_master.setBounds(50, 290, 230, 40);
        panel1.add(lac_master);
        lnon_ac_1 = new JLabel("NON-AC Single Cot                     :");
        lnon_ac_1.setBounds(50, 370, 230, 40);
        panel1.add(lnon_ac_1);
        lnon_ac_2 = new JLabel("NON-AC Double Cot                     :");
        lnon_ac_2.setBounds(50, 450, 230, 40);
        panel1.add(lnon_ac_2);
        
        tac_1 = new JTextField();
        tac_1.setBounds(310, 130, 210, 40);
        tac_1.setEditable(false);
        panel1.add(tac_1);
        tac_2 = new JTextField();
        tac_2.setBounds(310, 210, 210, 40);
        panel1.add(tac_2);
        tac_2.setEditable(false);
        tac_master = new JTextField();
        tac_master.setBounds(310, 290, 210, 40);
        panel1.add(tac_master);
        tac_master.setEditable(false);
        tnon_ac_1 = new JTextField();
        tnon_ac_1.setBounds(310, 370, 210, 40);
        panel1.add(tnon_ac_1);
        tnon_ac_1.setEditable(false);
        tnon_ac_2 = new JTextField();
        tnon_ac_2.setBounds(310, 450, 210, 40);
        panel1.add(tnon_ac_2);
        tnon_ac_2.setEditable(false);
        
        
        subtitle2 = new JLabel();
        subtitle2.setBounds(250, 50, 150, 40);
        panel2.add(subtitle2);
        
        lDate = new JLabel("Check In                                            : ");
        lDate.setBounds(50, 130, 230, 40);
        panel2.add(lDate);
        lroom_type = new JLabel("Room Type                                        : ");
        lroom_type.setBounds(50, 210, 230, 40);
        panel2.add(lroom_type);
        lno_of_days = new JLabel("No Of Days                                         : ");
        lno_of_days.setBounds(50, 290, 230, 40);
        panel2.add(lno_of_days);
        
        date1 = new JComboBox(Date);
        date1.setBounds(280, 130, 60, 40);
        panel2.add(date1);
        date1.addItemListener(this);
        month1 = new JComboBox(Month);
        month1.setBounds(360, 130, 90, 40);
        panel2.add(month1);
        month1.addItemListener(this);
        year1 = new JComboBox(Year);
        year1.setBounds(480, 130, 70, 40);
        panel2.add(year1);
        year1.addItemListener(this);
        room_type = new JComboBox(roomType);
        room_type.setBounds(280, 210, 270, 40);
        panel2.add(room_type);
        room_type.addItemListener(this);
        tno_of_days = new JTextField();
        tno_of_days.setBounds(280, 290, 270, 40);
        panel2.add(tno_of_days);
        
        check = new JButton("CHECK AVAILABILITY");
        check.setBounds(320, 420, 180, 40);
        panel2.add(check);
        Back = new JButton("BACK");
        Back.setBounds(100, 850, 150, 40);
        Back.addActionListener(this);
        check.addActionListener(this);
        frame.add(Back);
        
        frame.setBounds(0, 0, 1900, 1030);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
    }
    @Override
    public void itemStateChanged(ItemEvent e){
        Object obj=e.getSource();
        if(obj==room_type){
             room_Type=String.valueOf(room_type.getSelectedItem());
        }
        if(obj==date1){
            dt=String.valueOf(date1.getSelectedItem());
        }
        else if(obj==month1){
            mon=String.valueOf(month1.getSelectedItem());
        }
        else if(obj==year1){
            yr=String.valueOf(year1.getSelectedItem());
            dob=dt+"-"+mon+"-"+yr;
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
            frame.dispose();
        }
        else if(ae.getSource()==check){
            try {
            CheckforRooms_Bean crb = new CheckforRooms_Bean();
            crb.setUserid(Home_page.mail);
            crb.setPaymentid(Home_page.payid);
            crb.setRoomtype(room_Type);
            crb.setHotelid(Hotel_Details.htid);
            System.out.println(crb.getHotelid());
            crb.setCheckindate(dob);
            crb.setDayscount(tno_of_days.getText());
            
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(crb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob = ois.readObject();
                RoomAvailability_Bean rab =(RoomAvailability_Bean)ob;
                if(rab.getAvailability().equals("0")){
                    JOptionPane jp1 = new JOptionPane();
                    jp1.showMessageDialog(frame,"Rooms not Available for the mentioned dates!");
                }
                else if(rab.getAvailability().equals("1")){
                    JOptionPane jp1 = new JOptionPane();
                    jp1.showMessageDialog(frame,"Your Rooms have been Booked!");
                }
            } catch (Exception ex) {
                 System.out.println(ex);
            } 
            
            
        }
    }
    public static void main(String Args[]){
        new RoomDetails();
    }
}
