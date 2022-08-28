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
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;

public class BusSleeperSelection implements ActionListener {

    JFrame frame;
    JPanel panel;
    JTextField confirm, select;
    JTextArea update_Booking;
    String selected;
    JButton confirm_Booking, upper, lower, book, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30;
    String from, to, view;
    boolean available = false;
    String selected_seat,bus_type;
    int count=0;
    JLabel payment;
Backend be=new Backend();
    public BusSleeperSelection(String from, String to,String bus_type) {
        Font font=new Font("Bookman Old Style",Font.BOLD,20);
        Font font1=new Font("Bookman Old Style",Font.PLAIN,15);
        this.from = from;
        this.to = to;
        this.bus_type = bus_type;

        frame = new JFrame("sleeper Seat selection");
        lower = new JButton("LOWER");
        upper = new JButton("UPPER");
        upper.setBounds(890, 100, 165, 40);
        upper.setFont(font1);
        upper.setBackground(new Color(222, 68, 96));
        upper.setForeground(Color.BLACK);
        upper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setVisible(false);
                b2.setVisible(false);
                b3.setVisible(false);
                b4.setVisible(false);
                b5.setVisible(false);
                b6.setVisible(false);
                b7.setVisible(false);
                b8.setVisible(false);
                b9.setVisible(false);
                b10.setVisible(false);
                b11.setVisible(false);
                b12.setVisible(false);
                b13.setVisible(false);
                b14.setVisible(false);
                b15.setVisible(false);
                b16.setVisible(true);
                b17.setVisible(true);
                b18.setVisible(true);
                b19.setVisible(true);
                b20.setVisible(true);
                b21.setVisible(true);
                b22.setVisible(true);
                b23.setVisible(true);
                b24.setVisible(true);
                b25.setVisible(true);
                b26.setVisible(true);
                b27.setVisible(true);
                b28.setVisible(true);
                b29.setVisible(true);
                b30.setVisible(true);
            }
        });
        lower.setBounds(725, 100, 165, 40);
        lower.setFont(font1);
        lower.setBackground(new Color(222, 68, 96));
        lower.setForeground(Color.BLACK);
        lower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setVisible(true);
                b2.setVisible(true);
                b3.setVisible(true);
                b4.setVisible(true);
                b5.setVisible(true);
                b6.setVisible(true);
                b7.setVisible(true);
                b8.setVisible(true);
                b9.setVisible(true);
                b10.setVisible(true);
                b11.setVisible(true);
                b12.setVisible(true);
                b13.setVisible(true);
                b14.setVisible(true);
                b15.setVisible(true);
                b16.setVisible(false);
                b17.setVisible(false);
                b18.setVisible(false);
                b19.setVisible(false);
                b20.setVisible(false);
                b21.setVisible(false);
                b22.setVisible(false);
                b23.setVisible(false);
                b24.setVisible(false);
                b25.setVisible(false);
                b26.setVisible(false);
                b27.setVisible(false);
                b28.setVisible(false);
                b29.setVisible(false);
                b30.setVisible(false);
            }
        });
        panel = new JPanel();
        panel.setBounds(0, 0, 0, 0);
        panel.setBounds(725, 280, 330, 650);
        panel.setBackground(new Color(236, 227, 229 ));
        b1 = new JButton("1");
        b1.setBounds(770, 330, 50, 100);
        b1.addActionListener(this);
        b2 = new JButton("2");
        b2.setBounds(890, 330, 50, 100);
        b2.addActionListener(this);
        b3 = new JButton("3");
        b3.setBounds(960, 330, 50, 100);
        b3.addActionListener(this);
        b4 = new JButton("4");
        b4.setBounds(770, 450, 50, 100);
        b4.addActionListener(this);
        b5 = new JButton("5");
        b5.setBounds(890, 450, 50, 100);
        b5.addActionListener(this);
        b6 = new JButton("6");
        b6.setBounds(960, 450, 50, 100);
        b6.addActionListener(this);
        b7 = new JButton("7");
        b7.setBounds(770, 570, 50, 100);
        b7.addActionListener(this);
        b8 = new JButton("8");
        b8.setBounds(890, 570, 50, 100);
        b8.addActionListener(this);
        b9 = new JButton("9");
        b9.setBounds(960, 570, 50, 100);
        b9.addActionListener(this);
        b10 = new JButton("10");
        b10.setBounds(770, 690, 50, 100);
        b10.addActionListener(this);
        b11 = new JButton("11");
        b11.setBounds(890, 690, 50, 100);
        b11.addActionListener(this);
        b12 = new JButton("12");
        b12.setBounds(960, 690, 50, 100);
        b12.addActionListener(this);
        b13 = new JButton("13");
        b13.setBounds(770, 810, 50, 100);
        b13.addActionListener(this);
        b14 = new JButton("14");
        b14.setBounds(890, 810, 50, 100);
        b14.addActionListener(this);
        b15 = new JButton("15");
        b15.setBounds(960, 810, 50, 100);
        b15.addActionListener(this);

        b16 = new JButton("16");
        b16.setBounds(770, 330, 50, 100);
        b16.addActionListener(this);
        b17 = new JButton("17");
        b17.setBounds(890, 330, 50, 100);
        b17.addActionListener(this);
        b18 = new JButton("18");
        b18.setBounds(960, 330, 50, 100);
        b18.addActionListener(this);
        b19 = new JButton("19");
        b19.setBounds(770, 450, 50, 100);
        b19.addActionListener(this);
        b20 = new JButton("20");
        b20.setBounds(890, 450, 50, 100);
        b20.addActionListener(this);
        b21 = new JButton("21");
        b21.setBounds(960, 450, 50, 100);
        b21.addActionListener(this);
        b22 = new JButton("22");
        b22.setBounds(770, 570, 50, 100);
        b22.addActionListener(this);
        b23 = new JButton("23");
        b23.setBounds(890, 570, 50, 100);
        b23.addActionListener(this);
        b24 = new JButton("24");
        b24.setBounds(960, 570, 50, 100);
        b24.addActionListener(this);
        b25 = new JButton("25");
        b25.setBounds(770, 690, 50, 100);
        b25.addActionListener(this);
        b26 = new JButton("26");
        b26.setBounds(890, 690, 50, 100);
        b26.addActionListener(this);
        b27 = new JButton("27");
        b27.setBounds(960, 690, 50, 100);
        b27.addActionListener(this);
        b28 = new JButton("28");
        b28.setBounds(770, 810, 50, 100);
        b28.addActionListener(this);
        b29 = new JButton("29");
        b29.setBounds(890, 810, 50, 100);
        b29.addActionListener(this);
        b30 = new JButton("30");
        b30.setBounds(960, 810, 50, 100);
        b30.addActionListener(this);

        b1.setFont(font);
        b1.setBackground(new Color(255,255,255));
        b1.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b2.setFont(font);
        b2.setBackground(new Color(255,255,255));
        b2.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b3.setFont(font);
        b3.setBackground(new Color(255,255,255));
        b3.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b4.setFont(font);
        b4.setBackground(new Color(255,255,255));
        b4.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));b1.setFont(font);
        b5.setBackground(new Color(255,255,255));
        b5.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b5.setFont(font);
        b6.setBackground(new Color(255,255,255));
        b6.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b6.setFont(font);
        b7.setBackground(new Color(255,255,255));
        b7.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b7.setFont(font);
        b8.setBackground(new Color(255,255,255));
        b8.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b8.setFont(font);
        b9.setFont(font);
        b9.setBackground(new Color(255,255,255));
        b9.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));b1.setFont(font);
        b9.setBackground(new Color(255,255,255));
        b10.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));b1.setFont(font);
        b10.setBackground(new Color(255,255,255));
        b10.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b11.setFont(font);
        b11.setBackground(new Color(255,255,255));
        b11.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b12.setFont(font);
        b12.setBackground(new Color(255,255,255));
        b12.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b13.setFont(font);
        b13.setBackground(new Color(255,255,255));
        b13.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b14.setFont(font);
        b14.setBackground(new Color(255,255,255));
        b14.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));b1.setFont(font);
        b15.setFont(font);
        b15.setBackground(new Color(255,255,255));
        b15.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b16.setFont(font);
        b16.setBackground(new Color(255,255,255));
        b16.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b17.setFont(font);
        b17.setBackground(new Color(255,255,255));
        b17.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b18.setFont(font);
        b18.setBackground(new Color(255,255,255));
        b18.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b19.setFont(font);
        b19.setBackground(new Color(255,255,255));
        b19.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b20.setFont(font);
        b20.setBackground(new Color(255,255,255));
        b20.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b21.setFont(font);
        b21.setBackground(new Color(255,255,255));
        b21.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b22.setFont(font);
        b22.setBackground(new Color(255,255,255));
        b22.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b23.setFont(font);
        b23.setBackground(new Color(255,255,255));
        b23.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));b1.setFont(font);
        b24.setFont(font);
        b24.setBackground(new Color(255,255,255));
        b24.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b25.setFont(font);
        b25.setBackground(new Color(255,255,255));
        b25.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b26.setFont(font);
        b26.setBackground(new Color(255,255,255));
        b26.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b27.setFont(font);
        b27.setBackground(new Color(255,255,255));
        b27.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b28.setFont(font);
        b28.setBackground(new Color(255,255,255));
        b28.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b29.setFont(font);
        b29.setBackground(new Color(255,255,255));
        b29.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        b30.setFont(font);
        b30.setBackground(new Color(255,255,255));
        b30.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        
        
        book = new JButton("BOOK");
        book.setFont(font);
        book.setBackground(new Color(222, 68, 96));
        book.setForeground(Color.BLACK);
        book.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        book.setBounds(1200, 600, 200, 50);
        confirm = new JTextField();
        confirm.setBounds(1200, 700, 200, 50);
        confirm.setFont(font1);
        confirm.setBackground(new Color(255,255,255));
        confirm.setForeground(Color.BLACK);
        confirm.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        confirm.setVisible(false);
        confirm.setEditable(false);

        select = new JTextField();
        select.setFont(font1);
        select.setBackground(new Color(255,255,255));
        select.setForeground(Color.BLACK);
        select.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        select.setBounds(1200, 500, 200, 50);
        select.setVisible(true);
        select.setEditable(false);
        frame.add(select);
        
        confirm_Booking = new JButton("Confirm Booking");
        confirm_Booking.setBounds(1200, 800, 200, 50);
        confirm_Booking.setFont(font);
        confirm_Booking.setBackground(new Color(222, 68, 96));
        confirm_Booking.setForeground(Color.BLACK);
        confirm_Booking.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        frame.add(confirm_Booking);
        confirm_Booking.addActionListener(this);

        update_Booking = new JTextArea();
        update_Booking.setBounds(200, 500, 500, 100);
        update_Booking.setFont(font);
        update_Booking.setBackground(new Color(255,255,255));
        update_Booking.setForeground(Color.BLACK);
        update_Booking.setEditable(false);
        update_Booking.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, Color.BLACK));
        frame.add(update_Booking);
        view = be.Booking(from, to);///bookedseats
        System.out.println(view);
        update_Booking.setText(view);

        payment = new JLabel("Amount : 0");
        payment.setFont(font);
        payment.setForeground(Color.BLACK);
        payment.setBounds(1200, 900, 200,50);
        frame.add(payment);
        
        
        book.addActionListener(this);
        frame.add(confirm);
        frame.add(upper);
        frame.add(lower);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(b10);
        frame.add(b11);
        frame.add(b12);
        frame.add(b13);
        frame.add(b14);

        frame.add(b15);
        frame.add(b16);
        frame.add(b17);
        frame.add(b18);
        frame.add(b19);
        frame.add(b20);
        frame.add(b21);
        frame.add(b22);
        frame.add(b23);
        frame.add(b24);
        frame.add(b25);
        frame.add(b26);
        frame.add(b27);
        frame.add(b28);
        frame.add(b29);
        frame.add(b30);
        frame.add(panel);
        frame.add(book);
        frame.setBounds(0, 0, 1900, 1030);
        frame.setBackground(new Color(222, 68, 96));
        frame.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(50,30,30, 30,new Color(222, 68, 96  )) , "Booking Tickets", 2, 2,new Font("Bookman Old Style",Font.BOLD,40),new Color(255,255,255 )));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            selected = "1";

        } else if (e.getSource() == b2) {
            selected = "2";
        } else if (e.getSource() == b3) {
            selected = "3";
        } else if (e.getSource() == b4) {
            selected = "4";
        } else if (e.getSource() == b5) {
            selected = "5";
        } else if (e.getSource() == b6) {
            selected = "6";
        } else if (e.getSource() == b7) {
            selected = "7";
        } else if (e.getSource() == b8) {
            selected = "8";
        } else if (e.getSource() == b9) {
            selected = "9";
        } else if (e.getSource() == b10) {
            selected = "10";
        } else if (e.getSource() == b11) {
            selected = "11";
        } else if (e.getSource() == b12) {
            selected = "12";
        } else if (e.getSource() == b13) {

            selected = "13";
        } else if (e.getSource() == b14) {

            selected = "14";
        } else if (e.getSource() == b15) {
            selected = "15";
        } else if (e.getSource() == b16) {

            selected = "16";
        } else if (e.getSource() == b17) {

            selected = "17";
        } else if (e.getSource() == b18) {

            selected = "18";
        } else if (e.getSource() == b19) {

            selected = "19";
        } else if (e.getSource() == b20) {

            selected = "20";
        } else if (e.getSource() == b21) {

            selected = "21";
        } else if (e.getSource() == b22) {

            selected = "22";
        } else if (e.getSource() == b23) {

            selected = "23";
        } else if (e.getSource() == b24) {
            selected = "24";
        } else if (e.getSource() == b25) {
            selected = "25";
        } else if (e.getSource() == b26) {

            selected = "26";
        } else if (e.getSource() == b27) {

            selected = "27";
        } else if (e.getSource() == b28) {

            selected = "28";
        } else if (e.getSource() == b29) {
            selected = "29";
        } else if (e.getSource() == b30) {
            selected = "30";
        }
        if (e.getSource() == book) {
            confirm.setVisible(true);
            confirm.setText("Seat " + selected + " is Booked for You !!");
        }
        select.setText("Seat " + selected + " is Selected !!");

        if (e.getSource() == confirm_Booking) {
            System.out.println("-------->");
            available = false;
            String arr[] = view.split(",");///updated seats
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println(selected);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]+" " +selected);
                if (arr[i].equals(selected)) {
                    available = true;
                    System.out.println(available);
                }
            }
            if (available == true) {
                JOptionPane jp6 = new JOptionPane();
                jp6.showMessageDialog(frame, "THIS SEAT IS ALREADY BOOKED");
            } else if (available == false) {
              //  selected_seat = selected;
              //  System.out.println(selected_seat);
               
               String arr3[]= be.updateBooking(from, to, bus_type, selected);
               update_Booking.setText(arr3[0]);
                System.out.println("BOOK SUCESS");
                count+=1;
                int amount=count*(Integer.parseInt(arr3[1]));
                payment.setText("Amount = "+String.valueOf(amount));
                System.out.println(payment);
            }
        }
    }

    public static void main(String args[]) {
        
    }
}