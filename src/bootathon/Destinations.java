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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Destinations implements ActionListener{
    JPanel jf = new JPanel();;
    JFrame frame;
    JLabel state_label,destination_label;
    JComboBox state_combobox,destination_combobox;
    JButton button,button1;
    String stateofindia="";
    String TypeOfplace="";
    Destinations()throws Exception{
        frame=new JFrame("Holiday Destinations");
        frame.setBackground(new Color(222, 68, 96));
        String[] state={"Select State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar",
            "Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand",
            "Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram",
            "Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh",
                "Uttarakhand","West Bengal"};
        String[] Destination={"Choose your place","Holy Places","Hill Stations","Places Of Architectural Importance",
        "Beaches"};
        
        state_label = new JLabel("State ");
        state_label.setBounds(50,50,70,50);
        state_label.setFont(new Font("Bookman Old Style",Font.BOLD, 20));
        state_label.setForeground(new Color(0,0,0));
        state_combobox = new JComboBox(state);
        state_combobox.setBounds(300,50,250,50);
        state_combobox.setFocusable(false);
        state_combobox.setBackground(new Color(214, 231, 245));
        state_combobox.setFont(new Font("Bookman Old Style",Font.PLAIN,15));
        jf.add(state_label);jf.add(state_combobox);
        
        destination_label = new JLabel("Place Type");
        destination_label.setBounds(50,150,227,50);
        destination_label.setFont(new Font("Bookman Old Style",Font.BOLD, 20));
        destination_label.setForeground(Color.black);
        destination_combobox = new JComboBox(Destination);
        destination_combobox.setBounds(300,150,250,50);
        destination_combobox.setFocusable(false);
        destination_combobox.setBackground(new Color(214, 231, 245));
        destination_combobox.setFont(new Font("Bookman Old Style",Font.PLAIN, 15));
        jf.add(destination_label); jf.add(destination_combobox);
        ImageIcon home_icon=new ImageIcon("D:\\\\SEM 5-2021\\\\miniproject 5th sem\\\\home.jpeg");
        button = new JButton(home_icon);
        button.setBounds(50,240,100,89);
        button.setFont(new Font("SERIF",Font.HANGING_BASELINE, 20));
        button.setForeground(Color.white);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(255,255,255 ));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button) 
               
                frame.dispose();
            }
        });
        jf.add(button);
        //ImageIcon search_icon=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\home (1).jpeg");
        button1 = new JButton("Search");
        button1.setBounds(250,250,150,60);
        button1.setFont(new Font("Cooper Black",Font.PLAIN, 15));
        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLACK);
        button1.setFocusable(false);
        button1.setBorderPainted(false);
        jf.add(button1);
        button1.addActionListener(this);
        ImageIcon frame_image=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\shore-temple-640319518-58e3eaf25f9b58ef7e113e1f.jpg");
        JLabel image_label=new JLabel(frame_image);
        image_label.setBounds(0,0,1900,900);
        frame.add(jf);;
        jf.setBounds(10,210,570,370);
        jf.setBackground(new Color(255,255,255));
        jf.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(231, 126, 45)));
        jf.setLayout(null);
        jf.setVisible(true);
        frame.add(image_label);
        frame.setBounds(0,0,1900,1000);
        frame.getRootPane().setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(70, 50, 50, 50, new Color(222, 68, 96 )),"Destinations", 2, 2, new Font("Bookman Old Style",Font.BOLD,38), Color.WHITE));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==button1){
           
            try{
               stateofindia =(String)state_combobox.getSelectedItem();
               TypeOfplace = (String)destination_combobox.getSelectedItem();
               
               HolidayDestinations_Bean DB = new HolidayDestinations_Bean();
               DB.setPlaceType(TypeOfplace);
               DB.setState(stateofindia);
               Socket s = new Socket("localhost",7000);
               ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
               oos.writeObject(DB);
               ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
               Object ob=ois.readObject();
               ViewPlaces_Bean vpb=(ViewPlaces_Bean)ob;
               System.out.println(stateofindia+"  "+TypeOfplace);
               PlaceDescription pd = new PlaceDescription();
               
                pd.tdis1.setText(vpb.getDistrict1());
                pd.tdis2.setText(vpb.getDistrict2());
                pd.tdis3.setText(vpb.getDistrict3());
                pd.tdis4.setText(vpb.getDistrict4());
                pd.tdis5.setText(vpb.getDistrict5());
                
                pd.tplace_name1.setText(vpb.getPlace1());
                pd.tplace_name2.setText(vpb.getPlace2());
                pd.tplace_name3.setText(vpb.getPlace3());
                pd.tplace_name4.setText(vpb.getPlace4());
                pd.tplace_name5.setText(vpb.getPlace5());
                
                pd.tplace_description1.setText(vpb.getDescription1());
                pd.tplace_description2.setText(vpb.getDescription2());
                pd.tplace_description3.setText(vpb.getDescription3());
                pd.tplace_description4.setText(vpb.getDescription4());
                pd.tplace_description5.setText(vpb.getDescription5());
           }
           catch(Exception e){
               System.out.println(e);
           }
      
        }
    }
    
}
