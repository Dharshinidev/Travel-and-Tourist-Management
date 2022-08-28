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

public class DriverDetails {
    JPanel panel;
    JFrame dd_frame;
    JLabel title,dname_label,dcontact_label,dgender_label,damount_label;
    JTextField dname_textfield,dcontact_textfield,dgender_textfield,damount_textfield;
    JButton back;

    public DriverDetails() {
        dd_frame = new JFrame();
        
        panel = new JPanel();
        panel.setBounds(550, 190, 710, 510);
        panel.setBackground(Color.WHITE);
        
         Font font=new Font("Bookman Old Style",Font.BOLD,20);
        Font font1=new Font("Bookman Old Style",Font.PLAIN,15);
        
        title = new JLabel("DRIVER DETAILS");
        title.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        title.setBounds(790, 100, 300, 40);
        dd_frame.add(title);
        
        
        dname_label = new JLabel("Driver Name");
        dname_label.setFont(font);
        dname_label.setBounds(580, 260, 300, 40);
        dname_textfield = new JTextField();
        dname_textfield.setFont(font1);
        dname_textfield.setBackground(Color.WHITE);
        dname_textfield.setEditable(false);
        dname_textfield.setBounds(980, 260, 250, 40);
        dd_frame.add(dname_label);
        dd_frame.add(dname_textfield);
        
        dcontact_label = new JLabel("Driver Contact Number");
        dcontact_label.setFont(font);
        dcontact_label.setBounds(580, 360, 300, 40);
        dcontact_textfield = new JTextField("");
        dcontact_textfield.setFont(font1);
        dcontact_textfield.setBackground(Color.WHITE);
        dcontact_textfield.setEditable(false);
        dcontact_textfield.setBounds(980, 360, 250, 40);
        dd_frame.add(dcontact_label);
        dd_frame.add(dcontact_textfield);
        
        dgender_label = new JLabel("Driver Gender");
        dgender_label.setFont(font);
        dgender_label.setBounds(580, 460, 300, 40); 
        dgender_textfield = new JTextField("");
        dgender_textfield.setFont(font1);
        dgender_textfield.setBackground(Color.WHITE);
        dgender_textfield.setEditable(false);
        dgender_textfield.setBounds(980, 460, 250, 40);
        dd_frame.add(dgender_label);
        dd_frame.add(dgender_textfield);
        
        damount_label = new JLabel("Driver Amount Per Day");
        damount_label.setFont(font);
        damount_label.setBounds(580, 560, 300, 40); 
        damount_textfield = new JTextField("");
        damount_textfield.setFont(font1);
        damount_textfield.setBackground(Color.WHITE);
        damount_textfield.setEditable(false);
        damount_textfield.setBounds(980, 560, 250, 40);
        dd_frame.add(damount_label);
        dd_frame.add(damount_textfield);
        
        back = new JButton(new ImageIcon("D:\\SEM 5-2021\\miniproject 5th sem\\Facebook Post 940x788 px (2).jpeg"));
        back.setBounds(100, 750, 150, 60);
        back.setFocusable(false);
        back.setBackground(Color.WHITE);
        dd_frame.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    dd_frame.dispose();
                }
            }
        });
        dd_frame.add(panel);
        
        dd_frame.setBounds(0, 0, 1900, 1025);
        dd_frame.getContentPane().setBackground(Color.WHITE);
        dd_frame.setBackground(new Color(226, 102, 123 ));
        dd_frame.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(70, 30,30, 30,new Color(226, 102, 123  )) , "Driver Details", 2, 2,new Font("Bookman Old Style",Font.CENTER_BASELINE,30),new Color(255,255,255 )));
        dd_frame.setLayout(null);
        dd_frame.setVisible(true);
        dd_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public static void main(String args[]){
        new DriverDetails();
    }
}