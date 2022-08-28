/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hotel_Details implements ActionListener{
    JFrame f=new JFrame("Hotels");
    JLabel district=new JLabel("District   :");
    JLabel district_value=new JLabel();
    JButton back=new JButton(new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\Facebook Post 940x788 px (2).jpeg"));
    JPanel p1=new JPanel(null);
    JPanel p2=new JPanel(null);
    JPanel p3=new JPanel(null);
    JPanel p4=new JPanel(null);
    JLabel name1=new JLabel("Hotel Name");
    JLabel name2=new JLabel("Hotel Name");
    JLabel name3=new JLabel("Hotel Name");
    JLabel name4=new JLabel("Hotel Name");
    JTextField name1_val=new JTextField();
    JTextField name2_val=new JTextField();
    JTextField name3_val=new JTextField();
    JTextField name4_val=new JTextField();
    JLabel type1=new JLabel("Type");
    JLabel type2=new JLabel("Type");
    JLabel type3=new JLabel("Type");
    JLabel type4=new JLabel("Type");
    JTextField type1_val=new JTextField();
    JTextField type2_val=new JTextField();
    JTextField type3_val=new JTextField();
    JTextField type4_val=new JTextField();
    JLabel location1=new JLabel("Location");
    JLabel location2=new JLabel("Location");
    JLabel location3=new JLabel("Location");
    JLabel location4=new JLabel("Location");
    JTextArea location1_val=new JTextArea();
    JTextArea location2_val=new JTextArea();
    JTextArea location3_val=new JTextArea();
    JTextArea location4_val=new JTextArea();
    JLabel phn1=new JLabel("Contact Number");
    JLabel phn2=new JLabel("Contact Number");
    JLabel phn3=new JLabel("Contact Number");
    JLabel phn4=new JLabel("Contact Number");
    JTextField phn1_val=new JTextField();
    JTextField phn2_val=new JTextField();
    JTextField phn3_val=new JTextField();
    JTextField phn4_val=new JTextField();
    JButton rooms1=new JButton("View Rooms");
    JButton rooms2=new JButton("View Rooms");
    JButton rooms3=new JButton("View Rooms");
    JButton rooms4=new JButton("View Rooms");
    static String htid;
    static String hotelname;
    
    Hotel_Details(){
        f.setBounds(0,0,1420,900);
       // JLabel image=new JLabel(new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\WhatsApp Image 2021-08-26 at 12.07.44.jpeg\""));
        //image.setBounds(0, 0,1420, 900);
        f.setBackground(new Color(27, 172, 192));
        f.getContentPane().setBackground(new Color(245, 250, 251 ));
        f.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(70, 30,30, 30,new Color(27, 172, 192 )) , "Accommodation", 2, 2,new Font("Bookman Old Style",Font.BOLD,30),new Color(255,255,255 )));
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font font=new Font("Bookman Old Style",Font.BOLD,15);
        Font text_font=new Font("Bookman Old Style",Font.PLAIN,15);
        
        district.setBounds(50,30,170,30);
        f.add(district);
        district.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        district_value.setBounds(130,30,200,30);
        f.add(district_value);
        back.setBounds(45,640,100,75);
        back.setBackground(Color.WHITE);
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        back.addActionListener(this);
        f.add(back);
        
        p1.setBounds(130,90,480,250);
        p1.setBackground(Color.WHITE);
        name1.setBounds(30,15,150,30);
        name1.setFont(font);
        p1.add(name1);
        name1_val.setBounds(180,15,230,30);
        name1_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        name1_val.setBackground(Color.WHITE);
        name1_val.setEditable(false);
        name1_val.setFont(text_font);
        p1.add(name1_val);
        type1.setBounds(30,55,150,30);
        type1.setFont(font);
        p1.add(type1);
        type1_val.setBounds(180,55,140,30);
        type1_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        type1_val.setBackground(Color.WHITE);
        type1_val.setEditable(false);
        type1_val.setFont(text_font);
        p1.add(type1_val);
        location1.setBounds(30,95,150,30);
        location1.setFont(font);
        p1.add(location1);
        location1_val.setBounds(180,95,270,60);
        location1_val.setFont(text_font);
        location1_val.setBackground(Color.WHITE);
        location1_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        location1_val.setBackground(Color.WHITE);
        location1_val.setEditable(false);
        p1.add(location1_val);
        phn1.setBounds(30,165,150,30);
        phn1.setFont(font);
        p1.add(phn1);
        phn1_val.setBounds(180,165,140,30);
        phn1_val.setBackground(Color.WHITE);
        phn1_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        phn1_val.setEditable(false);
        phn1_val.setFont(text_font);
        p1.add(phn1_val);
        rooms1.setBounds(150,210,170,30);
        rooms1.setFont(font);
        rooms1.setBackground(new Color(241, 108, 140  ));
        rooms1.addActionListener(this);
        p1.add(rooms1);
        p1.setBorder(BorderFactory.createLineBorder(new Color(27, 172, 192), 5));
        f.add(p1);
        
        p2.setBounds(750,90,480,250);
        p2.setBackground(Color.WHITE);
        name2.setBounds(30,15,150,30);
        name2.setFont(font);
        p2.add(name2);
        name2_val.setBounds(180,15,230,30);
        name2_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        name2_val.setBackground(Color.WHITE);
        name2_val.setFont(text_font);
        name2_val.setEditable(false);
        p2.add(name2_val);
        type2.setBounds(30,55,150,30);
        type2.setFont(font);
        p2.add(type2);
        type2_val.setBounds(180,55,140,30);
        type2_val.setFont(text_font);
        type2_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        type2_val.setBackground(Color.WHITE);
        type2_val.setEditable(false);
        p2.add(type2_val);
        location2.setBounds(30,95,150,30);
        location2.setFont(font);
        p2.add(location2);
        location2_val.setBounds(180,95,270,60);
        location2_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        location2_val.setBackground(Color.WHITE);
        location2_val.setFont(text_font);
        location2_val.setBackground(Color.WHITE);
        location2_val.setEditable(false);
        p2.add(location2_val);
        phn2.setBounds(30,165,150,30);
        phn2.setFont(font);
        p2.add(phn2);
        phn2_val.setBounds(180,165,140,30);
        phn2_val.setFont(text_font);
        phn2_val.setBackground(Color.WHITE);
        phn2_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        phn2_val.setEditable(false);
        p2.add(phn2_val);
        rooms2.setBounds(150,210,170,30);
        rooms2.setFont(font);
        rooms2.setBackground(new Color(241, 108, 140  ));
        rooms2.addActionListener(this);
        p2.add(rooms2);
        p2.setBorder(BorderFactory.createLineBorder(new Color(27, 172, 192), 5));
        f.add(p2);
        
        p3.setBounds(130,380,480,250);
        p3.setBackground(Color.WHITE);
        name3.setBounds(30,15,150,30);
        name3.setFont(font);
        p3.add(name3);
        name3_val.setBounds(180,15,230,30);
        name3_val.setBackground(Color.WHITE);
        name3_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        name3_val.setFont(text_font);
        name3_val.setEditable(false);
        p3.add(name3_val);
        type3.setBounds(30,55,150,30);
        type3.setFont(font);
        p3.add(type3);
        type3_val.setBounds(180,55,140,30);
        type3_val.setFont(text_font);
        type3_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        type3_val.setBackground(Color.WHITE);
        type3_val.setEditable(false);
        p3.add(type3_val);
        location3.setBounds(30,95,150,30);
        location3.setFont(font);
        p3.add(location3);
        location3_val.setBounds(180,95,270,60);
        location3_val.setFont(text_font);
        location3_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        location3_val.setBackground(Color.white);
        location3_val.setEditable(false);
        p3.add(location3_val);
        phn3.setBounds(30,165,150,30);
        phn3.setFont(font);
        p3.add(phn3);
        phn3_val.setBounds(180,165,140,30);
        phn3_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        phn3_val.setBackground(Color.WHITE);
        phn3_val.setFont(text_font);
        phn3_val.setEditable(false);
        p3.add(phn3_val);
        rooms3.setBounds(150,210,170,30);
        rooms3.setFont(font);
        rooms3.addActionListener(this);
        rooms3.setBackground(new Color(241, 108, 140  ));
        p3.add(rooms3);
        p3.setBorder(BorderFactory.createLineBorder(new Color(27, 172, 192), 5));
        f.add(p3);
        
        p4.setBounds(750,380,480,250);
        p4.setBackground(Color.WHITE);
        name4.setBounds(30,15,150,30);
        name4.setFont(font);
        p4.add(name4);
        name4_val.setBounds(180,15,230,30);
        name4_val.setFont(text_font);
        name4_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        name4_val.setBackground(Color.WHITE);
        name4_val.setEditable(false);
        p4.add(name4_val);
        type4.setBounds(30,55,150,30);
        type4.setFont(font);
        p4.add(type4);
        type4_val.setBounds(180,55,140,30);
        type4_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        type4_val.setBackground(Color.WHITE);
        type4_val.setFont(text_font);
        type4_val.setEditable(false);
        p4.add(type4_val);
        location4.setBounds(30,95,150,30);
        location4.setFont(font);
        p4.add(location4);
        location4_val.setBounds(180,95,270,60);
        location4_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        location4_val.setBackground(Color.WHITE);
        location4_val.setFont(text_font);
        location4_val.setEditable(false);
        p4.add(location4_val);
        phn4.setBounds(30,165,150,30);
        phn4.setFont(font);
        p4.add(phn4);
        phn4_val.setBounds(180,165,140,30);
        phn4_val.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        phn4_val.setBackground(Color.WHITE);
        phn4_val.setEditable(false);
        phn4_val.setFont(text_font);
        p4.add(phn4_val);
        rooms4.setBounds(150,210,170,30);
        rooms4.setFont(font);
        rooms4.addActionListener(this);
        rooms4.setBackground(new Color(241, 108, 140  ));
        p4.setBorder(BorderFactory.createLineBorder(new Color(27, 172, 192), 5));
        p4.add(rooms4);
        f.add(p4);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==rooms1){
            htid=PlaceDescription.hotelid1;
            hotelname=name1.getText();
            RoomDetails rd = new RoomDetails();
            rd.tac_1.setText(PlaceDescription.hotel_amountACS1);
            rd.tac_2.setText(PlaceDescription.hotel_amountACD1);
            rd.tnon_ac_1.setText(PlaceDescription.hotel_amountNACS1);
            rd.tnon_ac_2.setText(PlaceDescription.hotel_amountACD1);
            rd.tac_master.setText(PlaceDescription.hotel_amountACM1);
            rd.subtitle1.setText(hotelname);
            rd.subtitle2.setText(hotelname);
        }
        else if(e.getSource()==rooms2){
            htid=PlaceDescription.hotelid2;
            hotelname=name2.getText();
            RoomDetails rd = new RoomDetails();
            rd.tac_1.setText(PlaceDescription.hotel_amountACS2);
            rd.tac_2.setText(PlaceDescription.hotel_amountACD2);
            rd.tnon_ac_1.setText(PlaceDescription.hotel_amountNACS2);
            rd.tnon_ac_2.setText(PlaceDescription.hotel_amountACD2);
            rd.tac_master.setText(PlaceDescription.hotel_amountACM2);
            rd.subtitle1.setText(hotelname);
            rd.subtitle2.setText(hotelname);
        }
        else if(e.getSource()==rooms3){
            htid=PlaceDescription.hotelid3;
            hotelname=name3.getText();
            RoomDetails rd = new RoomDetails();
            rd.tac_1.setText(PlaceDescription.hotel_amountACS3);
            rd.tac_2.setText(PlaceDescription.hotel_amountACD3);
            rd.tnon_ac_1.setText(PlaceDescription.hotel_amountNACS3);
            rd.tnon_ac_2.setText(PlaceDescription.hotel_amountACD3);
            rd.tac_master.setText(PlaceDescription.hotel_amountACM3);
            rd.subtitle1.setText(hotelname);
            rd.subtitle2.setText(hotelname);
        }
        else if(e.getSource()==rooms4){
            htid=PlaceDescription.hotelid4;
            hotelname=name4.getText();
            RoomDetails rd = new RoomDetails();
            rd.tac_1.setText(PlaceDescription.hotel_amountACS4);
            rd.tac_2.setText(PlaceDescription.hotel_amountACD4);
            rd.tnon_ac_1.setText(PlaceDescription.hotel_amountNACS4);
            rd.tnon_ac_2.setText(PlaceDescription.hotel_amountACD4);
            rd.tac_master.setText(PlaceDescription.hotel_amountACM4);
            rd.subtitle1.setText(hotelname);
            rd.subtitle2.setText(hotelname);
        }
        else if(e.getSource()==back){
            f.dispose();
        }
    }
    
    public static void main(String[] args){
        new Hotel_Details();
    }
}
