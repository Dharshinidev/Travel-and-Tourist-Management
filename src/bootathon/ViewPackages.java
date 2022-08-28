/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;
import java.awt.*;
public class ViewPackages implements ActionListener,ItemListener{
    JButton back,confirm;
    JRadioButton book,book1;
    JFrame f;
    JTextField tFrom_Location, tTo_Location,tpackage_name,tstart_date,tnoofdays,tnoofpersons,ttransport, tamount,
           tFrom_Location1, tTo_Location1,tpackage_name1,tstart_date1,tnoofdays1,tnoofpersons1,ttransport1,tamount1;
    JTextArea tstates_covered,tstates_covered1;
    //String packageid1,packageid2;
   String packageid;
   
    ViewPackages(){
    Font font=new Font("Bookman Old Style",Font.BOLD,15);
    Font font1=new Font("Bookman Old Style",Font.PLAIN,15);
    f = new JFrame();
    f.setBounds(0,0,1960,1030);
    JPanel jp1 = new JPanel(null);
    jp1.setBounds(350,40,600,740);
    jp1.setBackground(Color.white);
    f.add(jp1);
    JLabel From_Location = new JLabel("From Location");
    From_Location.setFont(font);
    From_Location.setBounds(50,90,250,40);
    jp1.add(From_Location);
     
    tFrom_Location = new JTextField();
    tFrom_Location.setBounds(280,90,200,40);
    tFrom_Location.setFont(font1);
    jp1.add(tFrom_Location);
    
    JLabel To_Location = new JLabel("To Location");
    To_Location.setBounds(50,150,250,40);
    To_Location.setFont(font);
    jp1.add(To_Location);
    
    tTo_Location = new JTextField();
    tTo_Location.setBounds(280,150,200,40);
    tTo_Location.setFont(font1);
    jp1.add(tTo_Location);
    
    JLabel package_name = new JLabel("Package Name");
    package_name.setBounds(50,210,250,40);
    package_name.setFont(font);
    jp1.add(package_name);
    
    tpackage_name = new JTextField();
    tpackage_name.setBounds(280,210,200,40);
    tpackage_name.setFont(font1);
    jp1.add(tpackage_name);
    
    JLabel states_covered = new JLabel("States to be Covered");
    states_covered.setBounds(50,270,250,40);
    states_covered.setFont(font);
    jp1.add(states_covered);
    
     tstates_covered = new JTextArea();
    tstates_covered.setBounds(280,270,250,60);
    tstates_covered.setFont(font1);
    jp1.add(tstates_covered);
    
    JLabel start_date = new JLabel("Start Date");
    start_date.setBounds(50,330,250,40);
    start_date.setFont(font);
    jp1.add(start_date);
    
    tstart_date = new JTextField();
    tstart_date.setBounds(280,330,200,40);
    tstart_date.setFont(font1);
    jp1.add(tstart_date);
    
    JLabel noofdays = new JLabel("No of Days");
    noofdays.setBounds(50,390,250,40);
    noofdays.setFont(font);
    jp1.add(noofdays);
    
    tnoofdays = new JTextField();
    tnoofdays.setBounds(280,390,200,40);
    tnoofdays.setFont(font1);
    jp1.add(tnoofdays);
    
    JLabel noofpersons = new JLabel("No of persons");
    noofpersons.setBounds(50,450,250,40);
    noofpersons.setFont(font);
    jp1.add(noofpersons);
    
    tnoofpersons = new JTextField();
    tnoofpersons.setBounds(280,450,200,40);
    tnoofpersons.setFont(font1);
    jp1.add(tnoofpersons);
    
    JLabel transport = new JLabel("Transport");
    transport.setBounds(50,510,250,40);
    transport.setFont(font);
    jp1.add(transport);
    
    ttransport = new JTextField();
    ttransport.setBounds(280,510,200,40);
    ttransport.setFont(font1);
    jp1.add(ttransport);
    
    JLabel amount = new JLabel("Amount");
    amount.setBounds(50,570,250,40);
    amount.setFont(font);
    jp1.add(amount);
    
     tamount = new JTextField();
    tamount.setBounds(280,570,200,40);
    tamount.setFont(font1);
    jp1.add(tamount);
    
    book = new JRadioButton("BOOK");
    book.setBounds(280, 650, 200, 40);
    book.setBackground(Color.white);
    book.setFont(font);
    ButtonGroup bg = new ButtonGroup();
    bg.add(book);
    jp1.add(book);
    book.addItemListener(this);

    
    
    JPanel jp2 = new JPanel(null);
    jp2.setBounds(1050,40,600,740);
    jp2.setBackground(Color.white);
    f.add(jp2);
    JLabel From_Location1 = new JLabel("From Location");
    From_Location1.setFont(font);
    From_Location1.setBounds(50,90,250,40);
    jp2.add(From_Location1);
    
    tFrom_Location1 = new JTextField();
    tFrom_Location1.setFont(font1);
    tFrom_Location1.setBounds(280,90,200,40);
    jp2.add(tFrom_Location1);
    
    JLabel To_Location1 = new JLabel("To Location");
    To_Location1.setBounds(50,150,250,40);
    To_Location1.setFont(font);
    jp2.add(To_Location1);
    
     tTo_Location1 = new JTextField();
    tTo_Location1.setBounds(280,150,200,40);
    tTo_Location1.setFont(font1);
    jp2.add(tTo_Location1);
    
    JLabel package_name1 = new JLabel("Package Name");
    package_name1.setBounds(50,210,250,40);
    package_name1.setFont(font);
    jp2.add(package_name1);
    
    tpackage_name1 = new JTextField();
    tpackage_name1.setBounds(280,210,200,40);
    tpackage_name1.setFont(font1);
    jp2.add(tpackage_name1);
    
    JLabel states_covered1 = new JLabel("States to be Covered");
    states_covered1.setBounds(50,270,250,40);
    states_covered1.setFont(font);
    jp2.add(states_covered1);
    
    tstates_covered1 = new JTextArea();
    tstates_covered1.setBounds(280,270,250,60);
    tstates_covered1.setFont(font1);
    jp2.add(tstates_covered1);
    
    JLabel start_date1 = new JLabel("Start Date");
    start_date1.setFont(font);
    start_date1.setBounds(50,330,250,40);
    jp2.add(start_date1);
    
     tstart_date1 = new JTextField();
    tstart_date1.setBounds(280,330,200,40);
    tstart_date1.setFont(font1);
    jp2.add(tstart_date1);
    
    JLabel noofdays1 = new JLabel("No of Days");
    noofdays1.setBounds(50,390,250,40);
    noofdays1.setFont(font);
    jp2.add(noofdays1);
    
    tnoofdays1 = new JTextField();
    tnoofdays1.setBounds(280,390,200,40);
    tnoofdays1.setFont(font1);
    jp2.add(tnoofdays1);
    
    JLabel noofpersons1 = new JLabel("No of persons");
    noofpersons1.setBounds(50,450,250,40);
    noofpersons1.setFont(font);
    jp2.add(noofpersons1);
    
    tnoofpersons1 = new JTextField();
    tnoofpersons1.setBounds(280,450,200,40);
    tnoofpersons1.setFont(font1);
    jp2.add(tnoofpersons1);
    
    JLabel transport1 = new JLabel("Transport");
    transport1.setBounds(50,510,250,40);
    transport1.setFont(font);
    jp2.add(transport1);
    
    ttransport1 = new JTextField();
    ttransport1.setBounds(280,510,200,40);
    ttransport1.setFont(font1);
    jp2.add(ttransport1);
    
    JLabel amount1 = new JLabel("Amount");
    amount1.setBounds(50,570,250,40);
    amount1.setFont(font);
    jp2.add(amount1);
    
    tamount1 = new JTextField();
    tamount1.setBounds(280,570,200,40);
    tamount1.setFont(font1);
    jp2.add(tamount1);
    
    book1 = new JRadioButton("BOOK");
    book1.setBounds(280, 650, 200, 40);
    book1.setBackground(Color.white);
    book1.setFont(font);
    
    book1.addItemListener(this);
    bg.add(book1);
    jp2.add(book1);
    
    back = new JButton("BACK");
    back.setBounds(60, 800, 200, 50);
    f.add(back);
    back.setFont(font1);
    back.setBackground(Color.WHITE);
    back.addActionListener(this);
    
    confirm = new JButton("Confirm");
    confirm.setBounds(850,800,200,50);
    confirm.setForeground(Color.WHITE);
    confirm.setBackground(new Color(241, 125, 146 ));
    confirm.setFont(font);
    f.add(confirm);
    confirm.addActionListener(this);
    
    f.getContentPane().setBackground(Color.WHITE);
    jp1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(236, 225, 227 )));
    jp2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(236, 225, 227 )));
    f.setBackground(new Color(222, 68, 96));
    f.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(70,30,30, 30,new Color(222, 68, 96  )) , "Book Package Tours", 2, 2,new Font("Bookman Old Style",Font.BOLD,40),new Color(255,255,255 )));
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
    
    public void itemStateChanged(ItemEvent e){
        if(e.getSource()==book){
                packageid= SearchPackageTours.packageid1;
        }  
        else if(e.getSource()==book1){
                packageid = SearchPackageTours.packageid2;
            }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== confirm){
             try{
                PackageToursBooking_Bean ptb = new PackageToursBooking_Bean();
                ptb.setPackageid(packageid);
                
                ptb.setUserid(Home_page.mail);
                ptb.setPaymentid(Home_page.payid);
                Socket s = new Socket("localhost",7000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(ptb);
                
            }
            catch(Exception sse){
                System.out.println(sse);
            }
            
                
            
        }
        
        else if(e.getSource()==back){
            f.dispose();
        }
    }
    
    public static void main(String args[]){
        new ViewPackages();
    } 
}