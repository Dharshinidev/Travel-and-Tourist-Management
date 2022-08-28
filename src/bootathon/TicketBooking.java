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
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TicketBooking implements ActionListener {

    JFrame jframe;
    JLabel lfrom, lto, ldate, lmodeOfTrans;
    JTextField tfrom, tto;
    JComboBox date1, month1, year1;
    String Date[] = {"DATE", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String Month[] = {"MONTH", "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"};
    String Year[] = {"YEAR", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030",
        "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040",
        "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050",};
    ButtonGroup bg;
    JRadioButton bus, train;
    JComboBox jcb1, jcb2, jcb3;
    String Bus[] = {"SELECT", "Ac", "NonAc"};
    String Train[] = {"TRAIN", "1ST CLASS", "2ND CLASS", "3RD CLASS", "SLEEPR CLASS"};
    JButton button, back;
    BusDetailsset_Bean bbn=new BusDetailsset_Bean();

    public TicketBooking() {
        jframe = new JFrame("Ticket Booking");
        lfrom = new JLabel("From");
        lfrom.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        lfrom.setForeground(new Color(0, 5, 6));
        jframe.setBackground(new Color(222, 68, 96));
        lfrom.setBounds(550, 100, 200, 40);
        tfrom = new JTextField();
        tfrom.setBackground(new Color(242, 248, 249));
        tfrom.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        tfrom.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        tfrom.setBounds(700, 100, 400, 40);
        jframe.add(lfrom);
        jframe.add(tfrom);

        lto = new JLabel("To");
        lto.setBounds(550, 200, 200, 40);
        lto.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        lto.setForeground(new Color(0, 5, 6));
        tto = new JTextField();
        tto.setBackground(new Color(242, 248, 249));
        tto.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        tto.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        tto.setBounds(700, 200, 400, 40);
        jframe.add(lto);
        jframe.add(tto);

        ldate = new JLabel("Date");
        ldate.setBounds(550, 300, 200, 40);
        ldate.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        ldate.setForeground(new Color(0, 5, 6));
        jframe.add(ldate);
        date1 = new JComboBox(Date);
        date1.setBounds(700, 300, 90, 40);
        date1.setBackground(new Color(255, 255, 255));
        date1.setFocusable(false);
        date1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        date1.setBorder(BorderFactory.createLineBorder(new Color(0, 5, 6), 2));
        jframe.add(date1);
        month1 = new JComboBox(Month);
        month1.setBounds(820, 300, 150, 40);
        month1.setBackground(new Color(255, 255, 255));
        month1.setFocusable(false);
        month1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        month1.setBorder(BorderFactory.createLineBorder(new Color(0, 5, 6), 2));
        jframe.add(month1);
        year1 = new JComboBox(Year);
        year1.setBounds(1010, 300, 120, 40);
        year1.setBackground(new Color(255, 255, 255));
        year1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        year1.setFocusable(false);
        year1.setBorder(BorderFactory.createLineBorder(new Color(0, 5, 6), 2));
        jframe.add(year1);

        lmodeOfTrans = new JLabel("Mode Of Transport");
        lmodeOfTrans.setFont(new Font("Bookman Old Style", Font.BOLD, 28));
        lmodeOfTrans.setForeground(new Color(0, 5, 6));
        lmodeOfTrans.setBounds(750, 390, 300, 40);
        jframe.add(lmodeOfTrans);

        jcb1 = new JComboBox(Bus);
        jcb1.setBounds(800, 500, 150, 40);
        jcb1.setBorder(BorderFactory.createLineBorder(new Color(0, 5, 6), 2));
        jcb1.setBackground(new Color(255, 255, 255));
        jcb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        jframe.add(jcb1);
        jcb1.setVisible(false);
        jcb2 = new JComboBox(Train);
        jcb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        jcb2.setBackground(new Color(255, 255, 255));
        jcb2.setBorder(BorderFactory.createLineBorder(new Color(0, 5, 6), 2));
        jcb2.setBounds(1200, 500, 150, 40);
        jframe.add(jcb2);
        jcb2.setVisible(false);

        bg = new ButtonGroup();
        ImageIcon bus_image=new ImageIcon("C:\\Users\\Anusha Ramesh\\OneDrive\\Pictures\\bus-icon-260nw-720063202.jpg");
        bus = new JRadioButton(bus_image);
        ImageIcon train_image=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\67-200.png");
        train = new JRadioButton(train_image);
        bus.setBounds(550, 430, 190, 190);
        train.setBounds(1000, 430, 190, 190);
        bus.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        bus.setFocusable(true);
        bus.setBackground(new Color(253, 251, 252));
        train.setFocusable(true);
        train.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        train.setBackground(new Color(253, 251, 252));
        bg.add(bus);
        bg.add(train);
        jframe.add(bus);
        jframe.add(train);
        bus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jcb1.setVisible(true);
                jcb2.setVisible(false);
            }
        });
        train.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jcb2.setVisible(true);
                jcb1.setVisible(false);
            }
        });
        ImageIcon home_icon=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\home.jpeg");
        back = new JButton(home_icon);
        back.setForeground(Color.white);
        back.setFocusable(true);
        back.setBorderPainted(false);
        back.setBackground(new Color(255, 255, 255));
        back.setBounds(150, 650, 110, 86);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) // new  Home_page();
                {
                    jframe.dispose();
                }
            }
        });
        jframe.add(back);
        ImageIcon search_icon = new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\home (1).jpeg");
        button = new JButton("Search", search_icon);
        button.setBounds(800, 650, 180, 100);
        button.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(255, 255, 255));
        jframe.add(button);
        button.addActionListener(this);
        jframe.getContentPane().setBackground(new Color(255, 255, 255));
        jframe.getRootPane().setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(100, 50, 50, 50, new Color(222, 68, 96)), "Ticket Booking", 2, 2, new Font("Bookman Old Style", Font.BOLD, 38), new Color(255, 255, 255)));
        jframe.setBounds(0, 0, 2000, 1000);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    }
 
 Backend be=new Backend();
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String from = tfrom.getText();
            String to = tto.getText();
            String date = (String) date1.getSelectedItem();
            String month = (String) month1.getSelectedItem();
            String year = (String) year1.getSelectedItem();
            String bus_type = (String) jcb1.getSelectedItem();
            System.out.println(bus_type);
            
            ResultSet rs=be.ticketBooking(from, to, date, month, year, bus_type);
            try {
                rs.next();
                String from1 = rs.getString(1);
                System.out.println(from1);
                String to1 = rs.getString(2);
                String date12 = rs.getString(3);
                String month12 = rs.getString(4);
                String year12 = rs.getString(5);
                String busname1=rs.getString(7);
                String bus_type1 = rs.getString(8);
                String departure_time1 = rs.getString(9);
                String arrival_time1 = rs.getString(10);
                
                rs.next();
                String from2 = rs.getString(1);
                System.out.println(from2);
                String to2 = rs.getString(2);
                String date2 = rs.getString(3);
                String month2 = rs.getString(4);
                String year2 = rs.getString(5);
                String busname2=rs.getString(7);
                String bus_type2 = rs.getString(8);
                String departure_time2 = rs.getString(9);
                String arrival_time2= rs.getString(10);
        
                rs.next();
                String from3 = rs.getString(1);
                System.out.println(from3);
                String to3 = rs.getString(2);
                String date3 = rs.getString(3);
                String month3 = rs.getString(4);
                String year3 = rs.getString(5);
                String busname3=rs.getString(7);
                String bus_type3 = rs.getString(8);
                String departure_time3 = rs.getString(9);
                String arrival_time3 = rs.getString(10);
                System.out.println(arrival_time3+"corret");
                bbn.setFrom1(from1);
                System.out.print(bbn.getFrom1());
                bbn.setFrom2(from2);
                bbn.setFrom3(from3);
                bbn.setTo1(to1);
                bbn.setTo2(to2);
                bbn.setTo3(to3);
                bbn.setDate1(date12);
                bbn.setDate2(date2);
                bbn.setDate3(date3);
                bbn.setMonth1(month12);
                bbn.setMonth2(month2);
                bbn.setMonth3(month3);
                bbn.setBusname1(busname1);
                bbn.setBusname2(busname2);
                bbn.setBusname3(busname3);
                bbn.setBus_type1(bus_type1);
                bbn.setBus_type2(bus_type2);
                bbn.setBus_type3(bus_type3);
                bbn.setArrival_time1(arrival_time1);
                bbn.setArrival_time2(arrival_time2);
                bbn.setArrival_time3(arrival_time3);
                bbn.setDeparture_time1(departure_time1);
                bbn.setDeparture_time2(departure_time2);
                bbn.setDeparture_time3(departure_time3);
                
                System.out.println(departure_time3+"corret");
                System.out.println(departure_time2+"corret");
                System.out.println(departure_time1+"corret");
                
            } catch (SQLException ex) {
                Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            
           System.out.println("-------;;;;;;");
            String transportMode;
            if (from.length() == 0) {
                JOptionPane jp1 = new JOptionPane();
                jp1.showMessageDialog(jframe, "ENTER FROM");
            } else if (to.length() == 0) {
                JOptionPane jp2 = new JOptionPane();
                jp2.showMessageDialog(jframe, "ENTER TO");
            } else if (date == "DATE") {
                JOptionPane jp3 = new JOptionPane();
                jp3.showMessageDialog(jframe, "ENTER DATE");
            } else if (month == "MONTH") {
                JOptionPane jp4 = new JOptionPane();
                jp4.showMessageDialog(jframe, "ENTER MONTH");
            } else if (year == "YEAR") {
                JOptionPane jp5 = new JOptionPane();
                jp5.showMessageDialog(jframe, "ENTER YEAR");
            } else if (bus.isSelected()) {
                transportMode = "BUS";
                String Bus = (String) jcb1.getSelectedItem();
                if (Bus == "BUS") {
                    JOptionPane jp6 = new JOptionPane();
                    jp6.showMessageDialog(jframe, "INVALID OPTION IN BUS");
                } else {
                    new BusDetails(bbn);
                }
            }

            /* else if(train.isSelected()){
                transportMode="TRAIN";
                String Train = (String)jcb2.getSelectedItem();
                if(Train=="TRAIN"){
                    JOptionPane jp7 = new JOptionPane();
                    jp7.showMessageDialog(jframe,"INVALID OPTION IN TRAIN");
                }
            }  
            tbn = new TicketBooking_Bean();
            tbn.setFrom(from);
            tbn.setTo(to);
            tbn.setDate(date);
            tbn.setMonth(month);
            tbn.setYear(year);
            tbn.setbus_type(bus_type);
            */
            
            
        }
    }

    public static void main(String[] args) {
        new TicketBooking();
    }
}