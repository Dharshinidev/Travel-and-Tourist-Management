/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class SearchPackageTours implements ActionListener,ItemListener {
    static String packageid1,packageid2;
    JFrame package_frame=new JFrame("Search Package Tours");
    JLabel from_label=new JLabel("From :");
    JLabel to_label=new JLabel("To :");
    String[] s={"Select State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh",
                "Uttarakhand","West Bengal"};
    JComboBox from_field=new JComboBox(s);
    JComboBox to_field=new JComboBox(s);
    ImageIcon home_icon=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\home.jpeg");
    JButton home=new JButton(home_icon);
    ImageIcon search_icon=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\home (1).jpeg");
    JButton search=new JButton("Search",search_icon);
    String from,to;
   SearchPackageTours_Bean sbean=new SearchPackageTours_Bean();
    SearchPackageTours(){
        package_frame.setBounds(400,200,1150,730);
        package_frame.setBackground(new Color(222, 68, 96  ));
        package_frame.setLayout(null);
        package_frame.setVisible(true);
        from_label.setBounds(350,180,100,40);
        from_label.setForeground(new Color(0, 5, 6));
        from_label.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        package_frame.add(from_label);
        to_label.setBounds(350,270,100,40);
        to_label.setForeground(new Color(0, 5, 6));
        to_label.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        package_frame.add(to_label);
        from_field.setBounds(520,180,230,50);
        from_field.setOpaque(false);
        from_field.addItemListener(this);
        from_field.setBackground(new Color(242, 248, 249 ));
        from_field.setFont(new Font("Bookman Old Style",Font.PLAIN,15));
        from_field.setBorder(BorderFactory. createLineBorder(new Color(0,5,6 ),2));
        from_field.setFocusable(false);
        package_frame.add(from_field);
        to_field.setBounds(520,270,230,50);
        to_field.addItemListener(this);
        to_field.setBackground(new Color(242, 248, 249 ));
        to_field.setFont(new Font("Bookman Old Style",Font.PLAIN,15));
        to_field.setFocusable(false);
        to_field.setBorder(BorderFactory. createLineBorder(new Color(0,5,6 ),2));
        package_frame.add(to_field);
        home.setBounds(100,500,110,68);
        home.addActionListener(this);
        home.setFont(new Font("SERIF",Font.HANGING_BASELINE, 20)); 
        home.setForeground(Color.white);
        home.setFocusable(false);
        home.setBorderPainted(false);
        home.setBackground(Color.WHITE);
        package_frame.add(home);
        search.setBounds(480,400,180,84);
        search.addActionListener(this);
        search.setFont(new Font("Cooper Black",Font.PLAIN, 15)); 
        search.setForeground(new Color(0,5,6));
        search.setFocusable(false);
        search.setBorderPainted(false);
        search.setBackground( Color.WHITE);
        package_frame.add(search);
        package_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        package_frame.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(50,30,30, 30,new Color(222, 68, 96  )) , "Package Tours", 2, 2,new Font("Bookman Old Style",Font.BOLD,40),new Color(255,255,255 )));
        package_frame.getContentPane().setBackground(new Color(255, 255, 255 )); 
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==home){
            
            package_frame.dispose();
            
        }
        else if(e.getSource()==search){
           sbean.setFrom(from);
           sbean.setTo(to);
           try{
           Socket s = new Socket("localhost",7000);
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           oos.writeObject(sbean);
           ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
           Object obj = ois.readObject();
           ViewPackage_Bean vpbn = (ViewPackage_Bean)obj;
           
           
           ViewPackages vp =new ViewPackages();
           vp.tFrom_Location.setText(vpbn.getFrom1());
           vp.tTo_Location.setText(vpbn.getTo1());
           vp.tpackage_name.setText(vpbn.getPackage_name1());
           vp.tstates_covered.setText(vpbn.getStates_covered1());
           vp.tstart_date.setText(vpbn.getStart_date1());
           vp.tnoofdays.setText(vpbn.getNo_of_days1());
           vp.tnoofpersons.setText(vpbn.getNo_of_persons1());
           vp.ttransport.setText(vpbn.getTransport1());
           vp.tamount.setText(vpbn.getAmount1());
           packageid1=vpbn.getPackageid1();
           //System.out.print(packageid1);
       
           vp.tFrom_Location1.setText(vpbn.getFrom2());
           vp.tTo_Location1.setText(vpbn.getTo2());
           vp.tpackage_name1.setText(vpbn.getPackage_name2());
           vp.tstates_covered1.setText(vpbn.getStates_covered2());
           vp.tstart_date1.setText(vpbn.getStart_date2());
           vp.tnoofdays1.setText(vpbn.getNo_of_days2());
           vp.tnoofpersons1.setText(vpbn.getNo_of_persons2());
           vp.ttransport1.setText(vpbn.getTransport2());
           vp.tamount1.setText(vpbn.getAmount2());
           packageid2=vpbn.getPackageid2();
          // System.out.print(sbean.getTo());
           }
           catch(Exception e1){
           System.out.println(e1);
           }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getSource()==from_field){
            from_field.setBackground(Color.WHITE);
           from=String.valueOf(from_field.getSelectedItem());
        }
        else if(e.getSource()==to_field){
           to_field.setBackground(new Color(255,255,255));
           to=String.valueOf(to_field.getSelectedItem());
        }
    }
}
    
