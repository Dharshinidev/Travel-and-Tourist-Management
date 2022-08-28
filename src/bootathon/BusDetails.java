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
import javax.swing.*;

public class BusDetails implements ActionListener{
    JFrame BD_frame;
    JLabel title;
    JPanel bus1_info,bus2_info,bus3_info;
    JButton back,bus1_search,bus2_search,bus3_search;
     JLabel from,to,bus,at,dt,from2,to2,bus2,at2,dt2,from3,to3,bus3,at3,dt3,name1,name2,name3;
     String frombean,tobean,bustypebean;
    public BusDetails(BusDetailsset_Bean bbn) {
        BD_frame = new JFrame();
        frombean=bbn.getFrom1();
        tobean=bbn.getTo1();
        bustypebean=bbn.getBus_type1();
        
        System.out.print(bbn.getDate1());
        bus1_info = new JPanel();
        
        bus1_info.setBackground(Color.WHITE);
        String f1="FROM : "+bbn.getFrom1();
        name1=new JLabel(bbn.getBusname1().toUpperCase());
        name1.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        name1.setBounds(50,20,200,50);
         from=new JLabel(f1.toUpperCase());
        from.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        from.setBounds(50,50,200,50);
        String t1="TO : "+bbn.getTo1();
         to=new JLabel(t1.toUpperCase());
        to.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        to.setBounds(310,50,250,50);
       String bustype="BusType : "+bbn.getBus_type1();
         bus=new JLabel(bustype.toUpperCase());
        bus.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        bus.setBounds(180,100,200,50);
        String At1="Arrival Time : "+bbn.getArrival_time1();
         at=new JLabel(At1);
        at.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        at.setBounds(50,150,250,50);
        String Dt1="Departure Time : "+bbn.getDeparture_time1();
         dt=new JLabel(Dt1);
        dt.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        dt.setBounds(310,150,270,50);
        bus1_info.add(from);
        bus1_info.add(to);
        bus1_info.add(bus);
        bus1_info.add(at);
        bus1_info.add(dt);
        bus1_info.add(name1);
        bus1_info.setBounds(600, 60, 680, 250);
        BD_frame.add(bus1_info);
        
        bus2_info = new JPanel();
         String f2="FROM : "+bbn.getFrom2();
         name2=new JLabel(bbn.getBusname2().toUpperCase());
        name2.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        name2.setBounds(50,20,200,50);
        from2=new JLabel(f2.toUpperCase());
        from2.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        from2.setBounds(50,50,200,50);
        String t2="TO : "+bbn.getTo2();
         to2=new JLabel(t2.toUpperCase());
        to2.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        to2.setBounds(310,50,250,50);
        String bustype2="BusType : "+bbn.getBus_type2();
         bus2=new JLabel(bustype2.toUpperCase());
        bus2.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        bus2.setBounds(180,100,200,50);
        String At2="Arrival Time : "+bbn.getArrival_time2();
         at2=new JLabel(At2);
        at2.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        at2.setBounds(50,150,250,50);
        String Dt2="Departure Time : "+bbn.getDeparture_time2();
        dt2=new JLabel(Dt2);
        dt2.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        dt2.setBounds(310,150,270,50);
        bus2_info.add(from2);
        bus2_info.add(to2);
        bus2_info.add(at2);
        bus2_info.add(bus2);
        bus2_info.add(dt2);
        bus2_info.add(name2);
        bus2_info.setBackground(Color.WHITE);
        bus2_info.setBounds(600, 320, 680, 250);
        
        BD_frame.add(bus2_info);
        
        bus3_info = new JPanel();
        bus3_info.setBackground(Color.WHITE);
         String f3="FROM : "+bbn.getFrom3();
         name3=new JLabel(bbn.getBusname3().toUpperCase());
        name3.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        name3.setBounds(50,20,200,50);
         from3=new JLabel(f3.toUpperCase());
        from3.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        from3.setBounds(50,50,200,50);
        String t3="TO : "+bbn.getTo3();
        to3=new JLabel(t3.toUpperCase());
        to3.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        to3.setBounds(250,50,250,50);
        String bustype3="BusType : "+bbn.getBus_type3();
        bus3=new JLabel(bustype3.toUpperCase());
        bus3.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        bus3.setBounds(180,100,200,50);
        String At3="Arrival Time : "+bbn.getArrival_time3();
        at3=new JLabel(At1);
        at3.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        at3.setBounds(50,150,250,50);
        String Dt3="Departure Time : "+bbn.getDeparture_time3();
        dt3=new JLabel(Dt3);
        dt3.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        dt3.setBounds(310,150,270,50);
        bus3_info.add(from3);
        bus3_info.add(to3);
        bus3_info.add(at3);
        bus3_info.add(bus3);
        bus3_info.add(dt3);
        bus3_info.add(name3);
        bus3_info.setBounds(600, 580, 680, 250);
        
        BD_frame.add(bus3_info);
        
        bus1_search = new JButton("View Seats");
        bus1_search.setBounds(540,220,150,30);
        bus1_info.add(bus1_search);
        bus1_search.setBackground(new Color(231, 97, 121 ));
        bus1_search.setForeground(Color.WHITE);
        bus1_search.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        bus1_search.addActionListener(this);
        
        bus2_search = new JButton("View Seats");
        bus2_search.setBounds(540,220,150,30);
        bus2_info.add(bus2_search);
        bus2_search.setBackground(new Color(231, 97, 121 ));
        bus2_search.setForeground(Color.WHITE);
        bus2_search.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        bus2_search.addActionListener(this);
        
        bus3_search = new JButton("View Seats");
        bus3_search.setBounds(540,220,150,30);
        bus3_info.add(bus3_search);
        bus3_search.setBackground(new Color(231, 97, 121 ));
        bus3_search.setForeground(Color.WHITE);
        bus3_search.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        bus3_search.addActionListener(this);
        
        ImageIcon home_icon=new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\home.jpeg");
        back = new JButton(home_icon);
        back.setForeground(Color.white);
        back.setFocusable(true);
        back.setBorderPainted(false);
        back.setBackground(new Color(255, 255, 255));
        back.setBounds(50, 750, 110, 86);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) ;
                {
                    BD_frame.dispose();
                }
            }
        });
        BD_frame.add(back);
        JLabel image= new JLabel(new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\PAE224-Buses-cropped.jpg"));
        image.setBounds(0,0,1900,1030);
        BD_frame.add(image);
        BD_frame.setBounds(0, 0, 1900, 1030);
        bus1_info.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2,new Color(204, 192, 194 )));
        bus2_info.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2,new Color(204, 192, 194 )));
        bus3_info.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2,new Color(204, 192, 194 )));
        bus1_info.setLayout(null);
        bus2_info.setLayout(null);
        bus3_info.setLayout(null);
        bus1_info.setVisible(true);
        bus2_info.setVisible(true);
        bus3_info.setVisible(true);
        BD_frame.getContentPane().setBackground(Color.WHITE);
        BD_frame.setBackground(new Color(225, 92, 116 ));
        BD_frame.getRootPane().setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(100,10, 10, 10,new Color(225, 92, 116 )),"Available Buses",2,2,new Font("Bookman Old Style",Font.BOLD,35),Color.WHITE));
        BD_frame.setLayout(null);
        BD_frame.setVisible(true);
        BD_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bus1_search) {
            new BusSleeperSelection(frombean,tobean,bustypebean);
        }
        if (e.getSource() == bus2_search) {
            new BusSleeperSelection(frombean, tobean, bustypebean);
        }
        if (e.getSource() == bus3_search) {
            new BusSleeperSelection(frombean, tobean, bustypebean);
        }
        
        
    }
}