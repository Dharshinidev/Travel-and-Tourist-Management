/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.net.*;
import java.io.*;


public class PlaceDescription implements ActionListener{
    JFrame frame;
    JPanel tpanel,panel,panel1,panel2,panel3,panel4,panel5;
    JLabel state,place_type,sstate,splace_type;
    JLabel lplace_name1,lplace_discription1,lplace_name2,lplace_discription2,lplace_name3,lplace_discription3,lplace_name4,lplace_discription4,lplace_name5,lplace_discription5;
    JLabel ldis1,ldis2,ldis3,ldis4,ldis5;
    JTextField tdis1,tdis2,tdis3,tdis4,tdis5;
    JTextField tplace_name1,tplace_name2,tplace_name3,tplace_name4,tplace_name5;
    JTextArea tplace_description1, tplace_description2 ,tplace_description3 ,tplace_description4, tplace_description5;
    String district1,district2,district3,district4,district5;
    JButton back,select;
    JScrollPane scroll;
    JButton acc1,acc2,acc3,acc4,acc5,guide1,guide2,guide3,guide4,guide5,car1,car2,car3,car4,car5,res1,res2,res3,res4,res5;
    static String guideId1,guideId2,guideId3;
    static String driverName1,driverContactNumber1,driverGender1,driverAmountperday1,carbooked1,driverbooked1,
            driverName2,driverContactNumber2,driverGender2,driverAmountperday2,carbooked2,driverbooked2,driverName3,
            driverContactNumber3,driverGender3,driverAmountperday3,carbooked3,driverbooked3,driverName4,driverContactNumber4,
            driverGender4,driverAmountperday4,carbooked4,driverbooked4;
    static String carId1,carId2,carId3,carId4;
    static String hotel_amountACS1,hotel_amountACS2,hotel_amountACS3,hotel_amountACS4,
          hotel_amountNACS1,hotel_amountNACS2,hotel_amountNACS3,hotel_amountNACS4,
          hotel_amountACD1,hotel_amountACD2,hotel_amountACD3,hotel_amountACD4,
          hotel_amountNACD1,hotel_amountNACD2,hotel_amountNACD3,hotel_amountNACD4,
          hotel_amountACM1,hotel_amountACM2,hotel_amountACM3,hotel_amountACM4;
    static String hotelid1,hotelid2,hotelid3,hotelid4;
    static String hotelname1,hotelname2,hotelname3,hotelname4;
   PlaceDescription(){
        
        //Socket placesocket=new Socket("localhost",6898);
        //ObjectInputStream oi=new ObjectInputStream(placesocket.getInputStream());
        //pbean=(placeDescription_Bean)oi.readObject();
        
        frame = new JFrame();
        panel = new JPanel(null);
        scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0,0,1795,850);
        panel.setPreferredSize(new Dimension(1820,4200));
        panel.setBackground(new Color(255,255,255 ));
   
        tpanel = new JPanel(null);
        tpanel.setBounds(300, 100, 1210, 100);
        tpanel.setBackground(new  Color(255,255,255));
           
        state = new JLabel();
        state.setBounds(150, 5, 300, 100);
        state.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        //place_type = new JLabel(pla);
        place_type=new JLabel();
        place_type.setBounds(650, 5, 300, 100);
        place_type.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        tpanel.add(state);
        tpanel.add(place_type);
        sstate = new JLabel();
        sstate.setBounds(400, 5, 150, 100);
        splace_type = new JLabel();
        splace_type.setBounds(900, 5, 150, 100);
        tpanel.add(sstate);
        tpanel.add(splace_type);
        panel.add(tpanel);
        
        
        panel1 = new JPanel(null);
        panel1.setBounds(300, 300, 1210, 650);
        panel1.setBackground(new Color(214, 241, 246 ));
        panel.add(panel1);
        
        
        lplace_name1 = new JLabel("Place                          :");
        lplace_name1.setBounds(50, 60, 200, 40);
        lplace_name1.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel1.add(lplace_name1);
        
        lplace_discription1 = new JLabel("Description                 :");
        lplace_discription1.setBounds(50, 160, 600, 100);
        lplace_discription1.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel1.add(lplace_discription1);
        
        ldis1 = new JLabel("District                       :");
        ldis1.setBounds(50, 410, 200, 40);
        ldis1.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel1.add(ldis1);
        
        tplace_name1 = new JTextField();
        tplace_name1.setBounds(350, 60, 300, 50);
        tplace_name1.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tplace_name1.setEditable(false);
        panel1.add(tplace_name1);
        
        tplace_description1 = new JTextArea();
        tplace_description1.setBounds(350, 160, 750, 200);
        tplace_description1.setFont(new Font(Font.SERIF,Font.ITALIC, 18));
        tplace_description1.setEditable(false);
        panel1.add(tplace_description1);
        
        tdis1 = new JTextField();
        tdis1 .setBounds(350, 410, 300, 50);
        tdis1 .setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tdis1 .setEditable(false);
        panel1.add(tdis1 );
        
        acc1 = new JButton("ACCOMMODATION");
        acc1.setBounds(60, 540, 200, 50);
        acc1.setBackground(new Color(83, 209, 220));
        acc1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        acc1.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel1.add(acc1);
        acc1.addActionListener(this);
        
        car1 = new JButton("RENTAL CARS");
        car1.setBounds(360, 540, 200, 50);
        car1.setBackground(new Color(83, 209, 220));
        car1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        car1.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel1.add(car1);
        car1.addActionListener(this);
        
        guide1 = new JButton("GUIDES");
        guide1.setBounds(660, 540, 200, 50);
        guide1.setBackground(new Color(83, 209, 220));
        guide1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        guide1.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel1.add(guide1);
        guide1.addActionListener(this);

        
        res1 = new JButton("RESTAURENT");
        res1.setBounds(960, 540, 200, 50);
        res1.setBackground(new Color(83, 209, 220));
        res1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        res1.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel1.add(res1);
        res1.addActionListener(this);

        
        panel2 = new JPanel(null);
        panel2.setBounds(300, 980, 1210, 650);
        panel2.setBackground(new Color(214, 241, 246 ));
        panel.add(panel2);
        
        lplace_name2 = new JLabel("Place                          :");
        lplace_name2.setBounds(50, 80, 200, 40);
        lplace_name2.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel2.add(lplace_name2);
        
        lplace_discription2 = new JLabel("Description                 :");
        lplace_discription2.setBounds(50, 180, 600, 100);
        lplace_discription2.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel2.add(lplace_discription2);
        
        ldis2 = new JLabel("District                       :");
        ldis2.setBounds(50, 410, 200, 40);
        ldis2.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel2.add(ldis2);
        
        tplace_name2 = new JTextField();
        tplace_name2.setBounds(350, 80, 300, 50);
        tplace_name2.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tplace_name2.setEditable(false);
        panel2.add(tplace_name2);
        
        tplace_description2 = new JTextArea();
        tplace_description2.setBounds(350, 180, 750, 170);
        tplace_description2.setFont(new Font(Font.SERIF,Font.ITALIC, 18));
        tplace_description2.setEditable(false);
        panel2.add(tplace_description2);
        
        tdis2 = new JTextField();
        tdis2 .setBounds(350, 410, 300, 50);
        tdis2 .setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tdis2 .setEditable(false);
        panel2.add(tdis2 );
        
        acc2 = new JButton("ACCOMMODATION");
        acc2.setBounds(60, 540, 200, 50);
        acc2.setBackground(new Color(83, 209, 220));
        acc2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        acc2.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel2.add(acc2);
        acc2.addActionListener(this);
        
        car2 = new JButton("RENTAL CARS");
        car2.setBounds(360, 540, 200, 50);
        car2.setBackground(new Color(83, 209, 220));
        car2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        car2.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel2.add(car2);
        car2.addActionListener(this);
        
        guide2 = new JButton("GUIDES");
        guide2.setBounds(660, 540, 200, 50);
        guide2.setBackground(new Color(83, 209, 220));
        guide2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        guide2.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel2.add(guide2);
        guide2.addActionListener(this);
        
        res2 = new JButton("RESTAURENT");
        res2.setBounds(960, 540, 200, 50);
        res2.setBackground(new Color(83, 209, 220));
        res2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        res2.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel2.add(res2);
        guide2.addActionListener(this);
        
        panel3 = new JPanel(null);
        panel3.setBounds(300, 1780, 1210, 650);
        panel3.setBackground(new Color(214, 241, 246 ));
        panel.add(panel3);
        
        lplace_name3 = new JLabel("Place                          :");
        lplace_name3.setBounds(50, 80, 200, 40);
        lplace_name3.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel3.add(lplace_name3);
        
        lplace_discription3 = new JLabel("Description                 :");
        lplace_discription3.setBounds(50, 180, 600, 100);
        lplace_discription3.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel3.add(lplace_discription3);
        
        ldis3 = new JLabel("District                       :");
        ldis3.setBounds(50, 410, 200, 40);
        ldis3.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel3.add(ldis3);
        
        tplace_name3 = new JTextField();
        tplace_name3.setBounds(350, 80, 300, 50);
        tplace_name3.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tplace_name3.setEditable(false);
        panel3.add(tplace_name3);
        
        tplace_description3 = new JTextArea();
        tplace_description3.setBounds(350, 180, 750, 170);
        tplace_description3.setFont(new Font(Font.SERIF,Font.ITALIC, 18));
        tplace_description3.setEditable(false);
        panel3.add(tplace_description3);
        
        tdis3 = new JTextField();
        tdis3 .setBounds(350, 410, 300, 50);
        tdis3 .setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tdis3 .setEditable(false);
        panel3.add(tdis3 );
        
        acc3 = new JButton("ACCOMMODATION");
        acc3.setBounds(60, 540, 200, 50);
        acc3.setBackground(new Color(83, 209, 220));
        acc3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        acc3.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel3.add(acc3);
        acc3.addActionListener(this);
        
        car3 = new JButton("RENTAL CARS");
        car3.setBounds(360, 540, 200, 50);
        car3.setBackground(new Color(83, 209, 220));
        car3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        car3.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel3.add(car3);
        car3.addActionListener(this);
        
        guide3 = new JButton("GUIDES");
        guide3.setBounds(660, 540, 200, 50);
        guide3.setBackground(new Color(83, 209, 220));
        guide3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        guide3.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel3.add(guide3);
        guide3.addActionListener(this);
        
        res3 = new JButton("RESTAURENT");
        res3.setBounds(960, 540, 200, 50);
        res3.setBackground(new Color(83, 209, 220));
        res3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        res3.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel3.add(res3);
        res3.addActionListener(this);
        
        panel4 = new JPanel(null);
        panel4.setBounds(300, 2580, 1210, 650);
        panel4.setBackground(new Color(214, 241, 246 ));
        panel.add(panel4);
        
        lplace_name4 = new JLabel("Place                          :");
        lplace_name4.setBounds(50, 80, 200, 40);
        lplace_name4.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel4.add(lplace_name4);
        
        lplace_discription4 = new JLabel("Description                 :");
        lplace_discription4.setBounds(50, 180, 600, 100);
        lplace_discription4.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel4.add(lplace_discription4);
        
        ldis4 = new JLabel("District                       :");
        ldis4.setBounds(50, 410, 200, 40);
        ldis4.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel4.add(ldis4);
        
        tplace_name4 = new JTextField();
        tplace_name4.setBounds(350, 80, 300, 50);
        tplace_name4.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tplace_name4.setEditable(false);
        panel4.add(tplace_name4);
        
        tplace_description4 = new JTextArea();
        tplace_description4.setBounds(350, 180, 750, 170);
        tplace_description4.setFont(new Font(Font.SERIF,Font.ITALIC, 18));
        tplace_description4.setEditable(false);
        panel4.add(tplace_description4);
        
        tdis4 = new JTextField();
        tdis4 .setBounds(350, 410, 300, 50);
        tdis4 .setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tdis4 .setEditable(false);
        panel4.add(tdis4 );
        
        acc4 = new JButton("ACCOMMODATION");
        acc4.setBounds(60, 540, 200, 50);
        acc4.setBackground(new Color(83, 209, 220));
        acc4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        acc4.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel4.add(acc4);
        acc4.addActionListener(this);
        
        car4 = new JButton("RENTAL CARS");
        car4.setBounds(360, 540, 200, 50);
        car4.setBackground(new Color(83, 209, 220));
        car4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        car4.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel4.add(car4);
        car4.addActionListener(this);
        
        guide4 = new JButton("GUIDES");
        guide4.setBounds(660, 540, 200, 50);
        guide4.setBackground(new Color(83, 209, 220));
        guide4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        guide4.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel4.add(guide4);
        guide4.addActionListener(this);
        
        
        res4 = new JButton("RESTAURENT");
        res4.setBounds(960, 540, 200, 50);
        res4.setBackground(new Color(83, 209, 220));
        res4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        res4.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel4.add(res4);
        res4.addActionListener(this);
        
        panel5 = new JPanel(null);
        panel5.setBounds(300, 3380, 1210, 650);
        panel5.setBackground(new Color(214, 241, 246 ));
        panel.add(panel5);
        
        lplace_name5 = new JLabel("Place                          :");
        lplace_name5.setBounds(50, 80, 200, 40);
        lplace_name5.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel5.add(lplace_name5);
        
        lplace_discription5 = new JLabel("Description                 :");
        lplace_discription5.setBounds(50, 180, 600, 100);
        lplace_discription5.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel5.add(lplace_discription5);
        
        ldis5 = new JLabel("District                       :");
        ldis5.setBounds(50, 410, 200, 40);
        ldis5.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        panel5.add(ldis5);
        
        tplace_name5 = new JTextField();
        tplace_name5.setBounds(350, 80, 300, 50);
        tplace_name5.setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tplace_name5.setEditable(false);
        panel5.add(tplace_name5);
        
        tplace_description5 = new JTextArea();
        tplace_description5.setBounds(350, 180, 750, 170);
        tplace_description5.setFont(new Font(Font.SERIF,Font.ITALIC, 18));
        tplace_description5.setEditable(false);
        panel5.add(tplace_description5);
        
        tdis5 = new JTextField();
        tdis5 .setBounds(350, 410, 300, 50);
        tdis5 .setFont(new Font(Font.SERIF,Font.BOLD, 18));
        tdis5 .setEditable(false);
        panel5.add(tdis5 );
        
        acc5 = new JButton("ACCOMMODATION");
        acc5.setBounds(60, 540, 200, 50);
        acc5.setBackground(new Color(83, 209, 220));
        acc5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        acc5.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel5.add(acc5);
        acc5.addActionListener(this);

        
        car5 = new JButton("RENTAL CARS");
        car5.setBounds(360, 540, 200, 50);
        car5.setBackground(new Color(83, 209, 220));
        car5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        car5.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel5.add(car5);
        car5.addActionListener(this);

        
        guide5 = new JButton("GUIDES");
        guide5.setBounds(660, 540, 200, 50);
        guide5.setBackground(new Color(83, 209, 220));
        guide5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        guide5.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel5.add(guide5);
        guide5.addActionListener(this);

        res5 = new JButton("RESTAURENT");
        res5.setBounds(960, 540, 200, 50);
        res5.setBackground(new Color(83, 209, 220));
        res5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        res5.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        panel5.add(res5);
        res5.addActionListener(this);
  
        frame.setBounds(0,0,1900,1000);
        frame.setBackground(new Color(222, 68, 96 ));
       
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(scroll);
        frame.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(100, 40,40, 40,new Color(222, 68, 96  )) , "HolidayDestinations", 2, 2,new Font("Bookman Old Style",Font.BOLD,38),new Color( 255,255,255  )));
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==acc1){
            district1=tdis1.getText();
            AccommodationDistrict_Bean adb = new AccommodationDistrict_Bean();
            adb.setDistrict(district1);
            try {
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(adb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob =ois.readObject();
                ViewHotels_Bean vhb=(ViewHotels_Bean)ob;
                Hotel_Details hd =new Hotel_Details();
                hd.name1_val.setText(vhb.getHotel_name1());
                hd.name2_val.setText(vhb.getHotel_name2());
                hd.name3_val.setText(vhb.getHotel_name3());
                hd.name4_val.setText(vhb.getHotel_name4());
                
                hd.type1_val.setText(vhb.getHotel_type1());
                hd.type2_val.setText(vhb.getHotel_type2());
                hd.type3_val.setText(vhb.getHotel_type3());
                hd.type4_val.setText(vhb.getHotel_type4());
                
                hd.location1_val.setText(vhb.getLocation1());
                hd.location2_val.setText(vhb.getLocation2());
                hd.location3_val.setText(vhb.getLocation3());
                hd.location4_val.setText(vhb.getLocation4());
                
                hd.phn1_val.setText(vhb.getCon_num1());
                hd.phn2_val.setText(vhb.getCon_num2());
                hd.phn3_val.setText(vhb.getCon_num3());
                hd.phn4_val.setText(vhb.getCon_num4());
                hotel_amountACS1=vhb.getHotel_amountACS1();
                hotel_amountACS2=vhb.getHotel_amountACS2();
                hotel_amountACS3=vhb.getHotel_amountACS3();
                hotel_amountACS4=vhb.getHotel_amountACS4();
                hotel_amountNACS1=vhb.getHotel_amountNACS1();
                hotel_amountNACS2=vhb.getHotel_amountNACS2();
                hotel_amountNACS3=vhb.getHotel_amountNACS3();
                hotel_amountNACS4=vhb.getHotel_amountNACS4();
                hotel_amountACD1=vhb.getHotel_amountACD1();
                hotel_amountACD2=vhb.getHotel_amountACD2();
                hotel_amountACD3=vhb.getHotel_amountACD3();
                hotel_amountACD4=vhb.getHotel_amountACD4();
                hotel_amountNACD1=vhb.getHotel_amountNACD1();
                hotel_amountNACD2=vhb.getHotel_amountNACD2();
                hotel_amountNACD3=vhb.getHotel_amountNACD3();
                hotel_amountNACD4=vhb.getHotel_amountNACD4();
                hotel_amountACM1=vhb.getHotel_amountACM1();
                hotel_amountACM2=vhb.getHotel_amountACM2();
                hotel_amountACM3=vhb.getHotel_amountACM3();
                hotel_amountACM4=vhb.getHotel_amountACM4();
                
                hotelid1=vhb.getHotel_id1();
                hotelid2=vhb.getHotel_id2();
                hotelid3=vhb.getHotel_id3();
                hotelid4=vhb.getHotel_id4();
                
            } 
            catch (Exception ex) {
                System.out.println(ex);
            } 
        }
        else if(e.getSource()==guide1){
            try{
                district1=tdis1.getText();
                Guides_District_Bean gdb = new Guides_District_Bean();
                gdb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(gdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob=ois.readObject();
                ViewGuides_Bean vgb = (ViewGuides_Bean)ob;
                 Guide g=new Guide();
                 g.district_label.setText("Guides avaliable in "+vgb.getDistrict());
                 g.text_name1.setText(vgb.getGuideName1());
                 g.text_name2.setText(vgb.getGuideName2());
                 g.text_name3.setText(vgb.getGuideName3());
                 
                 g.text_gender1.setText(vgb.getGuideGender1());
                 g.text_gender2.setText(vgb.getGuideGender2());
                 g.text_gender3.setText(vgb.getGuideGender3());
                 
                 g.text_phno1.setText(vgb.getContactNumber1());
                 g.text_phno2.setText(vgb.getContactNumber2());
                 g.text_phno3.setText(vgb.getContactNumber3());
                 
                 g.text_amount1.setText(vgb.getAmountPerDay1());
                 g.text_amount2.setText(vgb.getAmountPerDay2());
                 g.text_amount3.setText(vgb.getAmountPerDay3());
           
                 guideId1=vgb.getGuideid1();
                 guideId2=vgb.getGuideid2();
                 guideId3=vgb.getGuideid3();
                 
                if(vgb.getBooked1().equals("YES")){
                    g.guide1_button.setEnabled(false);
                }
                else if(vgb.getBooked2().equals("YES")){
                    g.guide2_button.setEnabled(false);
                }
                else  if(vgb.getBooked3().equals("YES")){
                    g.guide3_button.setEnabled(false);
                }
            }
            catch(Exception ge){
                System.out.println(ge);
            }
        }
        else if(e.getSource()==car1){
            try {
                district1=tdis1.getText();
                RentalCars_District_Bean rcdb = new RentalCars_District_Bean();
                rcdb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(rcdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ViewRentalCars_Bean  vrcb=(ViewRentalCars_Bean)ois.readObject();
                RentalCars obj = new RentalCars();
                obj.lDistrict.setText("District : "+vrcb.getDistrict());
               obj.model_textfield1.setText(vrcb.getCarModel1());
               obj.model_textfield2.setText(vrcb.getCarModel2());
               obj.model_textfield3.setText(vrcb.getCarModel3());
               obj.model_textfield4.setText(vrcb.getCarModel4());
               
               carId1=vrcb.getCarId1();
               carId2=vrcb.getCarId2();
               carId3=vrcb.getCarId3();
               carId4=vrcb.getCarId4();
               obj.carId_textfield1.setText(vrcb.getCarId1());
               obj.carId_textfield2.setText(vrcb.getCarId2());
               obj.carId_textfield3.setText(vrcb.getCarId3());
               obj.carId_textfield4.setText(vrcb.getCarId4());
               
               
               obj.rent_textfield1.setText(vrcb.getCarRentperday1());
               obj.rent_textfield2.setText(vrcb.getCarRentperday2());
               obj.rent_textfield3.setText(vrcb.getCarRentperday3());
               obj.rent_textfield4.setText(vrcb.getCarRentperday4());
               
                  driverName1=vrcb.getDriverName1();
                  driverContactNumber1=vrcb.getDriverContactNumber1();
                  driverGender1=vrcb.getDriverGender1();
                  driverAmountperday1=vrcb.getDriverAmountperday1();
                  carbooked1=vrcb.getCarbooked1();
                  driverbooked1=vrcb.getDriverbooked1();
                  
                  driverName2=vrcb.getDriverName2();
                  driverContactNumber2=vrcb.getDriverContactNumber2();
                  driverGender2=vrcb.getDriverGender2();
                  driverAmountperday2=vrcb.getDriverAmountperday2();
                  carbooked2=vrcb.getCarbooked2();
                  driverbooked2=vrcb.getDriverbooked2();
                  
                  driverName3=vrcb.getDriverName3();
                  driverContactNumber3=vrcb.getDriverContactNumber3();
                  driverGender3=vrcb.getDriverGender3();
                  driverAmountperday3=vrcb.getDriverAmountperday3();
                  carbooked3=vrcb.getCarbooked3();
                  driverbooked3=vrcb.getDriverbooked3();
                  
                  driverName4=vrcb.getDriverName4();
                  driverContactNumber4=vrcb.getDriverContactNumber4();
                  driverGender4=vrcb.getDriverGender4();
                  driverAmountperday4=vrcb.getDriverAmountperday4();
                  carbooked4=vrcb.getCarbooked4();
                  driverbooked4=vrcb.getDriverbooked4();
            } catch (Exception ex) {
                
            }
        }
        else if(e.getSource()==res1){
            try{
            district1=tdis1.getText();
            Restaurant_District_Bean rdb = new Restaurant_District_Bean();
            rdb.setDistrict(district1);
             Socket s = new Socket("localhost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(rdb);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object rob=ois.readObject();
            ViewRestaurants_Bean vrsb = (ViewRestaurants_Bean)rob;
            
           Restaurant rt= new Restaurant();
           rt.district.setText("District       :  " +vrsb.getDistrict());
           rt.Restaurant1_field.setText(vrsb.getRestaurant_name1());
           rt.Restaurant2_field.setText(vrsb.getRestaurant_name2());
           rt.Restaurant3_field.setText(vrsb.getRestaurant_name3());
           
           rt.Restaurant1_Type.setText(vrsb.getRestaurant_Type1());
           rt.Restaurant2_Type.setText(vrsb.getRestaurant_Type2());
           rt.Restaurant3_Type.setText(vrsb.getRestaurant_Type3());
           
           rt.Restaurant1_rating.setText(vrsb.getRestaurant_Ratings1());
           rt.Restaurant2_rating.setText(vrsb.getRestaurant_Ratings2());
           rt.Restaurant3_rating.setText(vrsb.getRestaurant_Ratings3());
           
           rt.Restaurant1location_area.setText(vrsb.getRestaurant_Location1());
           rt.Restaurant2location_area.setText(vrsb.getRestaurant_Location2());
           rt.Restaurant3location_area.setText(vrsb.getRestaurant_Location3());
            }
            catch(Exception re){
                   System.out.println(re);
            }
        }
        else if(e.getSource()==acc2){
            try {
                district1=tdis2.getText();
            AccommodationDistrict_Bean adb = new AccommodationDistrict_Bean();
            adb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(adb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob =ois.readObject();
                ViewHotels_Bean vhb=(ViewHotels_Bean)ob;
                Hotel_Details hd =new Hotel_Details();
                hd.name1_val.setText(vhb.getHotel_name1());
                hd.name2_val.setText(vhb.getHotel_name2());
                hd.name3_val.setText(vhb.getHotel_name3());
                hd.name4_val.setText(vhb.getHotel_name4());
                
                hd.type1_val.setText(vhb.getHotel_type1());
                hd.type2_val.setText(vhb.getHotel_type2());
                hd.type3_val.setText(vhb.getHotel_type3());
                hd.type4_val.setText(vhb.getHotel_type4());
                
                hd.location1_val.setText(vhb.getLocation1());
                hd.location2_val.setText(vhb.getLocation2());
                hd.location3_val.setText(vhb.getLocation3());
                hd.location4_val.setText(vhb.getLocation4());
                
                hd.phn1_val.setText(vhb.getCon_num1());
                hd.phn2_val.setText(vhb.getCon_num2());
                hd.phn3_val.setText(vhb.getCon_num3());
                hd.phn4_val.setText(vhb.getCon_num4());
                hotel_amountACS1=vhb.getHotel_amountACS1();
                hotel_amountACS2=vhb.getHotel_amountACS2();
                hotel_amountACS3=vhb.getHotel_amountACS3();
                hotel_amountACS4=vhb.getHotel_amountACS4();
                hotel_amountNACS1=vhb.getHotel_amountNACS1();
                hotel_amountNACS2=vhb.getHotel_amountNACS2();
                hotel_amountNACS3=vhb.getHotel_amountNACS3();
                hotel_amountNACS4=vhb.getHotel_amountNACS4();
                hotel_amountACD1=vhb.getHotel_amountACD1();
                hotel_amountACD2=vhb.getHotel_amountACD2();
                hotel_amountACD3=vhb.getHotel_amountACD3();
                hotel_amountACD4=vhb.getHotel_amountACD4();
                hotel_amountNACD1=vhb.getHotel_amountNACD1();
                hotel_amountNACD2=vhb.getHotel_amountNACD2();
                hotel_amountNACD3=vhb.getHotel_amountNACD3();
                hotel_amountNACD4=vhb.getHotel_amountNACD4();
                hotel_amountACM1=vhb.getHotel_amountACM1();
                hotel_amountACM2=vhb.getHotel_amountACM2();
                hotel_amountACM3=vhb.getHotel_amountACM3();
                hotel_amountACM4=vhb.getHotel_amountACM4();
                
                hotelid1=vhb.getHotel_id1();
                hotelid2=vhb.getHotel_id2();
                hotelid3=vhb.getHotel_id3();
                hotelid4=vhb.getHotel_id4();
                
            } 
            catch (Exception ex) {
                System.out.println(ex);
            } 
        }
        else if(e.getSource()==guide2){
            try{
                district1=tdis2.getText();
                Guides_District_Bean gdb = new Guides_District_Bean();
                gdb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(gdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob=ois.readObject();
                ViewGuides_Bean vgb = (ViewGuides_Bean)ob;
                 Guide g=new Guide();
                 g.district_label.setText("Guides avaliable in "+vgb.getDistrict());
                 g.text_name1.setText(vgb.getGuideName1());
                 g.text_name2.setText(vgb.getGuideName2());
                 g.text_name3.setText(vgb.getGuideName3());
                 
                 g.text_gender1.setText(vgb.getGuideGender1());
                 g.text_gender2.setText(vgb.getGuideGender2());
                 g.text_gender3.setText(vgb.getGuideGender3());
                 
                 g.text_phno1.setText(vgb.getContactNumber1());
                 g.text_phno2.setText(vgb.getContactNumber2());
                 g.text_phno3.setText(vgb.getContactNumber3());
                 
                 g.text_amount1.setText(vgb.getAmountPerDay1());
                 g.text_amount2.setText(vgb.getAmountPerDay2());
                 g.text_amount3.setText(vgb.getAmountPerDay3());
           
                 guideId1=vgb.getGuideid1();
                 guideId2=vgb.getGuideid2();
                 guideId3=vgb.getGuideid3();
                 
                if(vgb.getBooked1().equals("YES")){
                    g.guide1_button.setEnabled(false);
                }
                else if(vgb.getBooked2().equals("YES")){
                    g.guide2_button.setEnabled(false);
                }
                else  if(vgb.getBooked3().equals("YES")){
                    g.guide3_button.setEnabled(false);
                }
            }
            catch(Exception ge){
                System.out.println(ge);
            }
            
        }
        else if(e.getSource()==car2){
            try{
             district1=tdis2.getText();
                RentalCars_District_Bean rcdb = new RentalCars_District_Bean();
                rcdb.setDistrict(district1);
                Socket s;
           
                s = new Socket("localhost",7000);
            
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(rcdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ViewRentalCars_Bean  vrcb=(ViewRentalCars_Bean)ois.readObject();
                RentalCars obj = new RentalCars();
                obj.lDistrict.setText("District : "+vrcb.getDistrict());
               obj.model_textfield1.setText(vrcb.getCarModel1());
               obj.model_textfield2.setText(vrcb.getCarModel2());
               obj.model_textfield3.setText(vrcb.getCarModel3());
               obj.model_textfield4.setText(vrcb.getCarModel4());
               
               carId1=vrcb.getCarId1();
               carId2=vrcb.getCarId2();
               carId3=vrcb.getCarId3();
               carId4=vrcb.getCarId4();
               obj.carId_textfield1.setText(vrcb.getCarId1());
               obj.carId_textfield2.setText(vrcb.getCarId2());
               obj.carId_textfield3.setText(vrcb.getCarId3());
               obj.carId_textfield4.setText(vrcb.getCarId4());
               
               
               obj.rent_textfield1.setText(vrcb.getCarRentperday1());
               obj.rent_textfield2.setText(vrcb.getCarRentperday2());
               obj.rent_textfield3.setText(vrcb.getCarRentperday3());
               obj.rent_textfield4.setText(vrcb.getCarRentperday4());
               
                  driverName1=vrcb.getDriverName1();
                  driverContactNumber1=vrcb.getDriverContactNumber1();
                  driverGender1=vrcb.getDriverGender1();
                  driverAmountperday1=vrcb.getDriverAmountperday1();
                  carbooked1=vrcb.getCarbooked1();
                  driverbooked1=vrcb.getDriverbooked1();
                  
                  driverName2=vrcb.getDriverName2();
                  driverContactNumber2=vrcb.getDriverContactNumber2();
                  driverGender2=vrcb.getDriverGender2();
                  driverAmountperday2=vrcb.getDriverAmountperday2();
                  carbooked2=vrcb.getCarbooked2();
                  driverbooked2=vrcb.getDriverbooked2();
                  
                  driverName3=vrcb.getDriverName3();
                  driverContactNumber3=vrcb.getDriverContactNumber3();
                  driverGender3=vrcb.getDriverGender3();
                  driverAmountperday3=vrcb.getDriverAmountperday3();
                  carbooked3=vrcb.getCarbooked3();
                  driverbooked3=vrcb.getDriverbooked3();
                  
                  driverName4=vrcb.getDriverName4();
                  driverContactNumber4=vrcb.getDriverContactNumber4();
                  driverGender4=vrcb.getDriverGender4();
                  driverAmountperday4=vrcb.getDriverAmountperday4();
                  carbooked4=vrcb.getCarbooked4();
                  driverbooked4=vrcb.getDriverbooked4();
            } 
        catch (Exception ex) {
                
            }
        }
        else if(e.getSource()==res2){
            try{
            district1=tdis2.getText();
            Restaurant_District_Bean rdb = new Restaurant_District_Bean();
            rdb.setDistrict(district1);
             Socket s = new Socket("localhost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(rdb);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object rob=ois.readObject();
            ViewRestaurants_Bean vrsb = (ViewRestaurants_Bean)rob;
            
           Restaurant rt= new Restaurant();
           rt.district.setText("District       :  " +vrsb.getDistrict());
           rt.Restaurant1_field.setText(vrsb.getRestaurant_name1());
           rt.Restaurant2_field.setText(vrsb.getRestaurant_name2());
           rt.Restaurant3_field.setText(vrsb.getRestaurant_name3());
           
           rt.Restaurant1_Type.setText(vrsb.getRestaurant_Type1());
           rt.Restaurant2_Type.setText(vrsb.getRestaurant_Type2());
           rt.Restaurant3_Type.setText(vrsb.getRestaurant_Type3());
           
           rt.Restaurant1_rating.setText(vrsb.getRestaurant_Ratings1());
           rt.Restaurant2_rating.setText(vrsb.getRestaurant_Ratings2());
           rt.Restaurant3_rating.setText(vrsb.getRestaurant_Ratings3());
           
           rt.Restaurant1location_area.setText(vrsb.getRestaurant_Location1());
           rt.Restaurant2location_area.setText(vrsb.getRestaurant_Location2());
           rt.Restaurant3location_area.setText(vrsb.getRestaurant_Location3());
            }
            catch(Exception re){
                   System.out.println(re);
            } 
        }
        else if(e.getSource()==acc3){
             try {
                district1=tdis3.getText();
            AccommodationDistrict_Bean adb = new AccommodationDistrict_Bean();
            adb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(adb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob =ois.readObject();
                ViewHotels_Bean vhb=(ViewHotels_Bean)ob;
                Hotel_Details hd =new Hotel_Details();
                hd.name1_val.setText(vhb.getHotel_name1());
                hd.name2_val.setText(vhb.getHotel_name2());
                hd.name3_val.setText(vhb.getHotel_name3());
                hd.name4_val.setText(vhb.getHotel_name4());
                
                hd.type1_val.setText(vhb.getHotel_type1());
                hd.type2_val.setText(vhb.getHotel_type2());
                hd.type3_val.setText(vhb.getHotel_type3());
                hd.type4_val.setText(vhb.getHotel_type4());
                
                hd.location1_val.setText(vhb.getLocation1());
                hd.location2_val.setText(vhb.getLocation2());
                hd.location3_val.setText(vhb.getLocation3());
                hd.location4_val.setText(vhb.getLocation4());
                
                hd.phn1_val.setText(vhb.getCon_num1());
                hd.phn2_val.setText(vhb.getCon_num2());
                hd.phn3_val.setText(vhb.getCon_num3());
                hd.phn4_val.setText(vhb.getCon_num4());
                hotel_amountACS1=vhb.getHotel_amountACS1();
                hotel_amountACS2=vhb.getHotel_amountACS2();
                hotel_amountACS3=vhb.getHotel_amountACS3();
                hotel_amountACS4=vhb.getHotel_amountACS4();
                hotel_amountNACS1=vhb.getHotel_amountNACS1();
                hotel_amountNACS2=vhb.getHotel_amountNACS2();
                hotel_amountNACS3=vhb.getHotel_amountNACS3();
                hotel_amountNACS4=vhb.getHotel_amountNACS4();
                hotel_amountACD1=vhb.getHotel_amountACD1();
                hotel_amountACD2=vhb.getHotel_amountACD2();
                hotel_amountACD3=vhb.getHotel_amountACD3();
                hotel_amountACD4=vhb.getHotel_amountACD4();
                hotel_amountNACD1=vhb.getHotel_amountNACD1();
                hotel_amountNACD2=vhb.getHotel_amountNACD2();
                hotel_amountNACD3=vhb.getHotel_amountNACD3();
                hotel_amountNACD4=vhb.getHotel_amountNACD4();
                hotel_amountACM1=vhb.getHotel_amountACM1();
                hotel_amountACM2=vhb.getHotel_amountACM2();
                hotel_amountACM3=vhb.getHotel_amountACM3();
                hotel_amountACM4=vhb.getHotel_amountACM4();
                
                hotelid1=vhb.getHotel_id1();
                hotelid2=vhb.getHotel_id2();
                hotelid3=vhb.getHotel_id3();
                hotelid4=vhb.getHotel_id4();
                
            } 
            catch (Exception ex) {
                System.out.println(ex);
            } 
        }
        else if(e.getSource()==guide3){
            try{
                district1=tdis3.getText();
                Guides_District_Bean gdb = new Guides_District_Bean();
                gdb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(gdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob=ois.readObject();
                ViewGuides_Bean vgb = (ViewGuides_Bean)ob;
                 Guide g=new Guide();
                 g.district_label.setText("Guides avaliable in "+vgb.getDistrict());
                 g.text_name1.setText(vgb.getGuideName1());
                 g.text_name2.setText(vgb.getGuideName2());
                 g.text_name3.setText(vgb.getGuideName3());
                 
                 g.text_gender1.setText(vgb.getGuideGender1());
                 g.text_gender2.setText(vgb.getGuideGender2());
                 g.text_gender3.setText(vgb.getGuideGender3());
                 
                 g.text_phno1.setText(vgb.getContactNumber1());
                 g.text_phno2.setText(vgb.getContactNumber2());
                 g.text_phno3.setText(vgb.getContactNumber3());
                 
                 g.text_amount1.setText(vgb.getAmountPerDay1());
                 g.text_amount2.setText(vgb.getAmountPerDay2());
                 g.text_amount3.setText(vgb.getAmountPerDay3());
           
                 guideId1=vgb.getGuideid1();
                 guideId2=vgb.getGuideid2();
                 guideId3=vgb.getGuideid3();
                 
                if(vgb.getBooked1().equals("YES")){
                    g.guide1_button.setEnabled(false);
                }
                else if(vgb.getBooked2().equals("YES")){
                    g.guide2_button.setEnabled(false);
                }
                else  if(vgb.getBooked3().equals("YES")){
                    g.guide3_button.setEnabled(false);
                }
            }
            catch(Exception ge){
                System.out.println(ge);
            }
        }
        else if(e.getSource()==car3){
            try{
             district1=tdis3.getText();
                RentalCars_District_Bean rcdb = new RentalCars_District_Bean();
                rcdb.setDistrict(district1);
                Socket s;
           
                s = new Socket("localhost",7000);
            
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(rcdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ViewRentalCars_Bean  vrcb=(ViewRentalCars_Bean)ois.readObject();
                RentalCars obj = new RentalCars();
                obj.lDistrict.setText("District : "+vrcb.getDistrict());
               obj.model_textfield1.setText(vrcb.getCarModel1());
               obj.model_textfield2.setText(vrcb.getCarModel2());
               obj.model_textfield3.setText(vrcb.getCarModel3());
               obj.model_textfield4.setText(vrcb.getCarModel4());
               
               carId1=vrcb.getCarId1();
               carId2=vrcb.getCarId2();
               carId3=vrcb.getCarId3();
               carId4=vrcb.getCarId4();
               obj.carId_textfield1.setText(vrcb.getCarId1());
               obj.carId_textfield2.setText(vrcb.getCarId2());
               obj.carId_textfield3.setText(vrcb.getCarId3());
               obj.carId_textfield4.setText(vrcb.getCarId4());
               
               
               obj.rent_textfield1.setText(vrcb.getCarRentperday1());
               obj.rent_textfield2.setText(vrcb.getCarRentperday2());
               obj.rent_textfield3.setText(vrcb.getCarRentperday3());
               obj.rent_textfield4.setText(vrcb.getCarRentperday4());
               
                  driverName1=vrcb.getDriverName1();
                  driverContactNumber1=vrcb.getDriverContactNumber1();
                  driverGender1=vrcb.getDriverGender1();
                  driverAmountperday1=vrcb.getDriverAmountperday1();
                  carbooked1=vrcb.getCarbooked1();
                  driverbooked1=vrcb.getDriverbooked1();
                  
                  driverName2=vrcb.getDriverName2();
                  driverContactNumber2=vrcb.getDriverContactNumber2();
                  driverGender2=vrcb.getDriverGender2();
                  driverAmountperday2=vrcb.getDriverAmountperday2();
                  carbooked2=vrcb.getCarbooked2();
                  driverbooked2=vrcb.getDriverbooked2();
                  
                  driverName3=vrcb.getDriverName3();
                  driverContactNumber3=vrcb.getDriverContactNumber3();
                  driverGender3=vrcb.getDriverGender3();
                  driverAmountperday3=vrcb.getDriverAmountperday3();
                  carbooked3=vrcb.getCarbooked3();
                  driverbooked3=vrcb.getDriverbooked3();
                  
                  driverName4=vrcb.getDriverName4();
                  driverContactNumber4=vrcb.getDriverContactNumber4();
                  driverGender4=vrcb.getDriverGender4();
                  driverAmountperday4=vrcb.getDriverAmountperday4();
                  carbooked4=vrcb.getCarbooked4();
                  driverbooked4=vrcb.getDriverbooked4();
            } 
        catch (Exception ex) {
                
            } 
        }
        else if(e.getSource()==res3){
             try{
            district1=tdis3.getText();
            Restaurant_District_Bean rdb = new Restaurant_District_Bean();
            rdb.setDistrict(district1);
             Socket s = new Socket("localhost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(rdb);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object rob=ois.readObject();
            ViewRestaurants_Bean vrsb = (ViewRestaurants_Bean)rob;
            
           Restaurant rt= new Restaurant();
           rt.district.setText("District       :  " +vrsb.getDistrict());
           rt.Restaurant1_field.setText(vrsb.getRestaurant_name1());
           rt.Restaurant2_field.setText(vrsb.getRestaurant_name2());
           rt.Restaurant3_field.setText(vrsb.getRestaurant_name3());
           
           rt.Restaurant1_Type.setText(vrsb.getRestaurant_Type1());
           rt.Restaurant2_Type.setText(vrsb.getRestaurant_Type2());
           rt.Restaurant3_Type.setText(vrsb.getRestaurant_Type3());
           
           rt.Restaurant1_rating.setText(vrsb.getRestaurant_Ratings1());
           rt.Restaurant2_rating.setText(vrsb.getRestaurant_Ratings2());
           rt.Restaurant3_rating.setText(vrsb.getRestaurant_Ratings3());
           
           rt.Restaurant1location_area.setText(vrsb.getRestaurant_Location1());
           rt.Restaurant2location_area.setText(vrsb.getRestaurant_Location2());
           rt.Restaurant3location_area.setText(vrsb.getRestaurant_Location3());
           
           
            }
            catch(Exception re){
                   System.out.println(re);
            }
        }
        else if(e.getSource()==acc4){
            try {
                district1=tdis4.getText();
            AccommodationDistrict_Bean adb = new AccommodationDistrict_Bean();
            adb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(adb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob =ois.readObject();
                ViewHotels_Bean vhb=(ViewHotels_Bean)ob;
                Hotel_Details hd =new Hotel_Details();
                hd.name1_val.setText(vhb.getHotel_name1());
                hd.name2_val.setText(vhb.getHotel_name2());
                hd.name3_val.setText(vhb.getHotel_name3());
                hd.name4_val.setText(vhb.getHotel_name4());
                
                hd.type1_val.setText(vhb.getHotel_type1());
                hd.type2_val.setText(vhb.getHotel_type2());
                hd.type3_val.setText(vhb.getHotel_type3());
                hd.type4_val.setText(vhb.getHotel_type4());
                
                hd.location1_val.setText(vhb.getLocation1());
                hd.location2_val.setText(vhb.getLocation2());
                hd.location3_val.setText(vhb.getLocation3());
                hd.location4_val.setText(vhb.getLocation4());
                
                hd.phn1_val.setText(vhb.getCon_num1());
                hd.phn2_val.setText(vhb.getCon_num2());
                hd.phn3_val.setText(vhb.getCon_num3());
                hd.phn4_val.setText(vhb.getCon_num4());
                hotel_amountACS1=vhb.getHotel_amountACS1();
                hotel_amountACS2=vhb.getHotel_amountACS2();
                hotel_amountACS3=vhb.getHotel_amountACS3();
                hotel_amountACS4=vhb.getHotel_amountACS4();
                hotel_amountNACS1=vhb.getHotel_amountNACS1();
                hotel_amountNACS2=vhb.getHotel_amountNACS2();
                hotel_amountNACS3=vhb.getHotel_amountNACS3();
                hotel_amountNACS4=vhb.getHotel_amountNACS4();
                hotel_amountACD1=vhb.getHotel_amountACD1();
                hotel_amountACD2=vhb.getHotel_amountACD2();
                hotel_amountACD3=vhb.getHotel_amountACD3();
                hotel_amountACD4=vhb.getHotel_amountACD4();
                hotel_amountNACD1=vhb.getHotel_amountNACD1();
                hotel_amountNACD2=vhb.getHotel_amountNACD2();
                hotel_amountNACD3=vhb.getHotel_amountNACD3();
                hotel_amountNACD4=vhb.getHotel_amountNACD4();
                hotel_amountACM1=vhb.getHotel_amountACM1();
                hotel_amountACM2=vhb.getHotel_amountACM2();
                hotel_amountACM3=vhb.getHotel_amountACM3();
                hotel_amountACM4=vhb.getHotel_amountACM4();
                
                hotelid1=vhb.getHotel_id1();
                hotelid2=vhb.getHotel_id2();
                hotelid3=vhb.getHotel_id3();
                hotelid4=vhb.getHotel_id4();
                
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }  
        }
        else if(e.getSource()==guide4){
            try{
                district1=tdis4.getText();
                Guides_District_Bean gdb = new Guides_District_Bean();
                gdb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(gdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob=ois.readObject();
                ViewGuides_Bean vgb = (ViewGuides_Bean)ob;
                 Guide g=new Guide();
                 g.district_label.setText("Guides avaliable in "+vgb.getDistrict());
                 g.text_name1.setText(vgb.getGuideName1());
                 g.text_name2.setText(vgb.getGuideName2());
                 g.text_name3.setText(vgb.getGuideName3());
                 
                 g.text_gender1.setText(vgb.getGuideGender1());
                 g.text_gender2.setText(vgb.getGuideGender2());
                 g.text_gender3.setText(vgb.getGuideGender3());
                 
                 g.text_phno1.setText(vgb.getContactNumber1());
                 g.text_phno2.setText(vgb.getContactNumber2());
                 g.text_phno3.setText(vgb.getContactNumber3());
                 
                 g.text_amount1.setText(vgb.getAmountPerDay1());
                 g.text_amount2.setText(vgb.getAmountPerDay2());
                 g.text_amount3.setText(vgb.getAmountPerDay3());
           
                 guideId1=vgb.getGuideid1();
                 guideId2=vgb.getGuideid2();
                 guideId3=vgb.getGuideid3();
                 
                if(vgb.getBooked1().equals("YES")){
                    g.guide1_button.setEnabled(false);
                }
                else if(vgb.getBooked2().equals("YES")){
                    g.guide2_button.setEnabled(false);
                }
                else  if(vgb.getBooked3().equals("YES")){
                    g.guide3_button.setEnabled(false);
                }
            }
            catch(Exception ge){
                System.out.println(ge);
            }
        }
        else if(e.getSource()==car4){
            try{
             district1=tdis4.getText();
                RentalCars_District_Bean rcdb = new RentalCars_District_Bean();
                rcdb.setDistrict(district1);
                Socket s;
           
                s = new Socket("localhost",7000);
            
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(rcdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ViewRentalCars_Bean  vrcb=(ViewRentalCars_Bean)ois.readObject();
                RentalCars obj = new RentalCars();
                obj.lDistrict.setText("District : "+vrcb.getDistrict());
               obj.model_textfield1.setText(vrcb.getCarModel1());
               obj.model_textfield2.setText(vrcb.getCarModel2());
               obj.model_textfield3.setText(vrcb.getCarModel3());
               obj.model_textfield4.setText(vrcb.getCarModel4());
               
               carId1=vrcb.getCarId1();
               carId2=vrcb.getCarId2();
               carId3=vrcb.getCarId3();
               carId4=vrcb.getCarId4();
               obj.carId_textfield1.setText(vrcb.getCarId1());
               obj.carId_textfield2.setText(vrcb.getCarId2());
               obj.carId_textfield3.setText(vrcb.getCarId3());
               obj.carId_textfield4.setText(vrcb.getCarId4());
               
               
               obj.rent_textfield1.setText(vrcb.getCarRentperday1());
               obj.rent_textfield2.setText(vrcb.getCarRentperday2());
               obj.rent_textfield3.setText(vrcb.getCarRentperday3());
               obj.rent_textfield4.setText(vrcb.getCarRentperday4());
               
                  driverName1=vrcb.getDriverName1();
                  driverContactNumber1=vrcb.getDriverContactNumber1();
                  driverGender1=vrcb.getDriverGender1();
                  driverAmountperday1=vrcb.getDriverAmountperday1();
                  carbooked1=vrcb.getCarbooked1();
                  driverbooked1=vrcb.getDriverbooked1();
                  
                  driverName2=vrcb.getDriverName2();
                  driverContactNumber2=vrcb.getDriverContactNumber2();
                  driverGender2=vrcb.getDriverGender2();
                  driverAmountperday2=vrcb.getDriverAmountperday2();
                  carbooked2=vrcb.getCarbooked2();
                  driverbooked2=vrcb.getDriverbooked2();
                  
                  driverName3=vrcb.getDriverName3();
                  driverContactNumber3=vrcb.getDriverContactNumber3();
                  driverGender3=vrcb.getDriverGender3();
                  driverAmountperday3=vrcb.getDriverAmountperday3();
                  carbooked3=vrcb.getCarbooked3();
                  driverbooked3=vrcb.getDriverbooked3();
                  
                  driverName4=vrcb.getDriverName4();
                  driverContactNumber4=vrcb.getDriverContactNumber4();
                  driverGender4=vrcb.getDriverGender4();
                  driverAmountperday4=vrcb.getDriverAmountperday4();
                  carbooked4=vrcb.getCarbooked4();
                  driverbooked4=vrcb.getDriverbooked4();
            } 
        catch (Exception ex) {
                
            } 
        }
        else if(e.getSource()==res4){
             try{
            district1=tdis4.getText();
            Restaurant_District_Bean rdb = new Restaurant_District_Bean();
            rdb.setDistrict(district1);
             Socket s = new Socket("localhost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(rdb);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object rob=ois.readObject();
            ViewRestaurants_Bean vrsb = (ViewRestaurants_Bean)rob;
            
           Restaurant rt= new Restaurant();
           rt.district.setText("District       :  " +vrsb.getDistrict());
           rt.Restaurant1_field.setText(vrsb.getRestaurant_name1());
           rt.Restaurant2_field.setText(vrsb.getRestaurant_name2());
           rt.Restaurant3_field.setText(vrsb.getRestaurant_name3());
           
           rt.Restaurant1_Type.setText(vrsb.getRestaurant_Type1());
           rt.Restaurant2_Type.setText(vrsb.getRestaurant_Type2());
           rt.Restaurant3_Type.setText(vrsb.getRestaurant_Type3());
           
           rt.Restaurant1_rating.setText(vrsb.getRestaurant_Ratings1());
           rt.Restaurant2_rating.setText(vrsb.getRestaurant_Ratings2());
           rt.Restaurant3_rating.setText(vrsb.getRestaurant_Ratings3());
           
           rt.Restaurant1location_area.setText(vrsb.getRestaurant_Location1());
           rt.Restaurant2location_area.setText(vrsb.getRestaurant_Location2());
           rt.Restaurant3location_area.setText(vrsb.getRestaurant_Location3());
            }
            catch(Exception re){
                   System.out.println(re);
            }
        }
        else if(e.getSource()==acc5){
             try {
                district1=tdis5.getText();
            AccommodationDistrict_Bean adb = new AccommodationDistrict_Bean();
            adb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(adb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob =ois.readObject();
                ViewHotels_Bean vhb=(ViewHotels_Bean)ob;
                Hotel_Details hd =new Hotel_Details();
                hd.name1_val.setText(vhb.getHotel_name1());
                hd.name2_val.setText(vhb.getHotel_name2());
                hd.name3_val.setText(vhb.getHotel_name3());
                hd.name4_val.setText(vhb.getHotel_name4());
                
                hd.type1_val.setText(vhb.getHotel_type1());
                hd.type2_val.setText(vhb.getHotel_type2());
                hd.type3_val.setText(vhb.getHotel_type3());
                hd.type4_val.setText(vhb.getHotel_type4());
                
                hd.location1_val.setText(vhb.getLocation1());
                hd.location2_val.setText(vhb.getLocation2());
                hd.location3_val.setText(vhb.getLocation3());
                hd.location4_val.setText(vhb.getLocation4());
                
                hd.phn1_val.setText(vhb.getCon_num1());
                hd.phn2_val.setText(vhb.getCon_num2());
                hd.phn3_val.setText(vhb.getCon_num3());
                hd.phn4_val.setText(vhb.getCon_num4());
                hotel_amountACS1=vhb.getHotel_amountACS1();
                hotel_amountACS2=vhb.getHotel_amountACS2();
                hotel_amountACS3=vhb.getHotel_amountACS3();
                hotel_amountACS4=vhb.getHotel_amountACS4();
                hotel_amountNACS1=vhb.getHotel_amountNACS1();
                hotel_amountNACS2=vhb.getHotel_amountNACS2();
                hotel_amountNACS3=vhb.getHotel_amountNACS3();
                hotel_amountNACS4=vhb.getHotel_amountNACS4();
                hotel_amountACD1=vhb.getHotel_amountACD1();
                hotel_amountACD2=vhb.getHotel_amountACD2();
                hotel_amountACD3=vhb.getHotel_amountACD3();
                hotel_amountACD4=vhb.getHotel_amountACD4();
                hotel_amountNACD1=vhb.getHotel_amountNACD1();
                hotel_amountNACD2=vhb.getHotel_amountNACD2();
                hotel_amountNACD3=vhb.getHotel_amountNACD3();
                hotel_amountNACD4=vhb.getHotel_amountNACD4();
                hotel_amountACM1=vhb.getHotel_amountACM1();
                hotel_amountACM2=vhb.getHotel_amountACM2();
                hotel_amountACM3=vhb.getHotel_amountACM3();
                hotel_amountACM4=vhb.getHotel_amountACM4();
                
                hotelid1=vhb.getHotel_id1();
                hotelid2=vhb.getHotel_id2();
                hotelid3=vhb.getHotel_id3();
                hotelid4=vhb.getHotel_id4();
                
            } 
            catch (Exception ex) {
                System.out.println(ex);
            } 
        }
        else if(e.getSource()==guide5){
            try{
                district1=tdis5.getText();
                Guides_District_Bean gdb = new Guides_District_Bean();
                gdb.setDistrict(district1);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(gdb);
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object ob=ois.readObject();
                ViewGuides_Bean vgb = (ViewGuides_Bean)ob;
                 Guide g=new Guide();
                 g.district_label.setText("Guides avaliable in "+vgb.getDistrict());
                 g.text_name1.setText(vgb.getGuideName1());
                 g.text_name2.setText(vgb.getGuideName2());
                 g.text_name3.setText(vgb.getGuideName3());
                 
                 g.text_gender1.setText(vgb.getGuideGender1());
                 g.text_gender2.setText(vgb.getGuideGender2());
                 g.text_gender3.setText(vgb.getGuideGender3());
                 
                 g.text_phno1.setText(vgb.getContactNumber1());
                 g.text_phno2.setText(vgb.getContactNumber2());
                 g.text_phno3.setText(vgb.getContactNumber3());
                 
                 g.text_amount1.setText(vgb.getAmountPerDay1());
                 g.text_amount2.setText(vgb.getAmountPerDay2());
                 g.text_amount3.setText(vgb.getAmountPerDay3());
           
                 guideId1=vgb.getGuideid1();
                 guideId2=vgb.getGuideid2();
                 guideId3=vgb.getGuideid3();
                 
                if(vgb.getBooked1().equals("YES")){
                    g.guide1_button.setEnabled(false);
                }
                else if(vgb.getBooked2().equals("YES")){
                    g.guide2_button.setEnabled(false);
                }
                else  if(vgb.getBooked3().equals("YES")){
                    g.guide3_button.setEnabled(false);
                }
            }
            catch(Exception ge){
                System.out.println(ge);
            }
        }
        else if(e.getSource()==car5){
            
        }
        else if(e.getSource()==res5){
            try{
            district1=tdis5.getText();
            Restaurant_District_Bean rdb = new Restaurant_District_Bean();
            rdb.setDistrict(district1);
             Socket s = new Socket("localhost",7000);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(rdb);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object rob=ois.readObject();
            ViewRestaurants_Bean vrsb = (ViewRestaurants_Bean)rob;
            
           Restaurant rt= new Restaurant();
           rt.district.setText("District       :  " +vrsb.getDistrict());
           rt.Restaurant1_field.setText(vrsb.getRestaurant_name1());
           rt.Restaurant2_field.setText(vrsb.getRestaurant_name2());
           rt.Restaurant3_field.setText(vrsb.getRestaurant_name3());
           
           rt.Restaurant1_Type.setText(vrsb.getRestaurant_Type1());
           rt.Restaurant2_Type.setText(vrsb.getRestaurant_Type2());
           rt.Restaurant3_Type.setText(vrsb.getRestaurant_Type3());
           
           rt.Restaurant1_rating.setText(vrsb.getRestaurant_Ratings1());
           rt.Restaurant2_rating.setText(vrsb.getRestaurant_Ratings2());
           rt.Restaurant3_rating.setText(vrsb.getRestaurant_Ratings3());
           
           rt.Restaurant1location_area.setText(vrsb.getRestaurant_Location1());
           rt.Restaurant2location_area.setText(vrsb.getRestaurant_Location2());
           rt.Restaurant3location_area.setText(vrsb.getRestaurant_Location3());
            }
            catch(Exception re){
                   System.out.println(re);
            } 
        }
    }
    
    public static void main(String ss[]){
        new PlaceDescription();
    }
}
