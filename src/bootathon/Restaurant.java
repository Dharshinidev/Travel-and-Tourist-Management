/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Restaurant implements ActionListener{
    JButton button,button1;
    JPanel jp1,jp2,jp3;
    JFrame f;
    JTextField Restaurant1_field,Restaurant1_Type,Restaurant1_rating,Restaurant2_rating,Restaurant3_rating,Restaurant2_Type,Restaurant3_Type,Restaurant2_field,Restaurant3_field;
    JTextArea Restaurant1location_area,Restaurant2location_area,Restaurant3location_area;
     JLabel district;
   Restaurant(){
       f = new JFrame("Restaurant");
       
       Font font=new Font("Bookman Old Style",Font.BOLD,15);
       
       district = new JLabel();
       district.setBounds(250,50,600,150);
       district.setFont(new Font("Bookman Old Style",Font.BOLD,25));
       f.add(district);
       
       
       jp1 = new JPanel();
       jp1.setLayout(null);
       jp1.setBackground(Color.white);
       jp1.setBounds(25,200,550,500);
       f.add(jp1);
       
        JLabel Restaurant1_label = new JLabel("Restaurant Name");
        Restaurant1_label.setBounds(30,100,170,40);
        Restaurant1_label.setFont(font);
        jp1.add(Restaurant1_label);
        
        Restaurant1_field = new JTextField();
        Restaurant1_field.setBounds(230,100,200,40);
        Restaurant1_field.setBackground(Color.WHITE);
        Restaurant1_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant1_field .setEditable(false);
        jp1.add(Restaurant1_field);
        
        JLabel Restaurant1location_label = new JLabel("Restaurant Location");
        Restaurant1location_label.setBounds(30,150,170,40);
        Restaurant1location_label.setFont(font);
        jp1.add(Restaurant1location_label);
        
         Restaurant1location_area = new JTextArea();
        Restaurant1location_area.setBounds(230,150,300,120);
        Restaurant1location_area.setBackground(Color.WHITE);
        Restaurant1location_area.setEditable(false);
        Restaurant1location_area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.add(Restaurant1location_area);
        Restaurant1location_area.setEditable(false);
        
        JLabel Restaurant1Type_label = new JLabel("Restaurant Type");
        Restaurant1Type_label.setBounds(30,300,170,40);
        Restaurant1Type_label.setFont(font);
        jp1.add(Restaurant1Type_label);
        
         Restaurant1_Type = new JTextField();
        Restaurant1_Type.setBounds(230,300,200,40);
        Restaurant1_Type.setBackground(Color.WHITE);
        Restaurant1_Type.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant1_Type.setEditable(false);
        jp1.add(Restaurant1_Type);
        
        JLabel Restaurant1rating_label = new JLabel("Restaurant Ratings");
        Restaurant1rating_label.setBounds(30,350,170,40);
        Restaurant1rating_label.setFont(font);
        jp1.add(Restaurant1rating_label);
        
        Restaurant1_rating = new JTextField();
        Restaurant1_rating.setBounds(230,350,200,40);
        Restaurant1_rating.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant1_rating.setBackground(Color.WHITE);
        Restaurant1_rating.setEditable(false);
        jp1.add(Restaurant1_rating);
        
       jp2 = new JPanel(null);
       jp2.setLayout(null);
       jp2.setBackground(Color.white);
       jp2.setBounds(650,200,550,500);
       f.add(jp2);
       
        JLabel Restaurant2_label = new JLabel("Restaurant Name");
        Restaurant2_label.setBounds(30,100,170,40);
        Restaurant2_label.setFont(font);
        jp2.add(Restaurant2_label);
        
        Restaurant2_field = new JTextField();
        Restaurant2_field.setBounds(230,100,200,40);
        Restaurant2_field.setBackground(Color.WHITE);
        Restaurant2_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant2_field.setEditable(false);
        jp2.add(Restaurant2_field );
        
        JLabel Restaurant2location_label = new JLabel("Restaurant Location");
        Restaurant2location_label.setBounds(30,150,170,40);
        Restaurant2location_label.setFont(font);
        jp2.add(Restaurant2location_label);
        
        Restaurant2location_area = new JTextArea();
        Restaurant2location_area.setBounds(230,150,300,120);
        Restaurant2location_area.setBackground(Color.WHITE);
        Restaurant2location_area.setEditable(false);
        Restaurant2location_area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant2location_area.setEditable(false);
        jp2.add(Restaurant2location_area);
        
        JLabel Restaurant2Type_label = new JLabel("Restaurant Type");
        Restaurant2Type_label.setBounds(30,300,170,40);
        Restaurant2Type_label.setFont(font);
        jp2.add(Restaurant2Type_label);
        
        Restaurant2_Type = new JTextField();
        Restaurant2_Type.setBounds(230,300,200,40);
        Restaurant2_Type.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant2_Type.setBackground(Color.WHITE);
        Restaurant2_Type.setEditable(false);
        jp2.add(Restaurant2_Type);
        
        JLabel Restaurant2rating_label = new JLabel("Restaurant Ratings");
        Restaurant2rating_label.setBounds(30,350,270,40);
        Restaurant2rating_label.setFont(font);
        jp2.add(Restaurant2rating_label);
        
        Restaurant2_rating = new JTextField();
        Restaurant2_rating.setBounds(230,350,200,40);
        Restaurant2_rating.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant2_rating.setBackground(Color.WHITE);
        Restaurant2_rating.setEditable(false);
        jp2.add(Restaurant2_rating);
        
       jp3 = new JPanel();
       jp3.setLayout(null);
       jp3.setBackground(Color.white);
       jp3.setBounds(1275,200,550,500);
       f.add(jp3);
       
        JLabel Restaurant3_label = new JLabel("Restaurant Name");
        Restaurant3_label.setBounds(30,100,170,40);
        Restaurant3_label.setFont(font);
        jp3.add(Restaurant3_label);
        
        Restaurant3_field = new JTextField();
        Restaurant3_field.setBounds(230,100,200,40);
        Restaurant3_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant3_field.setBackground(Color.WHITE);
        Restaurant3_field.setEditable(false);
        jp3.add(Restaurant3_field);
        
        JLabel Restaurant3location_label = new JLabel("Restaurant Location");
        Restaurant3location_label.setBounds(30,150,170,40);
        Restaurant3location_label.setFont(font);
        jp3.add(Restaurant3location_label);
        
        Restaurant3location_area = new JTextArea();
        Restaurant3location_area.setBounds(230,150,300,120);
        Restaurant3location_area.setBackground(Color.WHITE);
        Restaurant3location_area.setEditable(false);
        Restaurant3location_area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant3location_area.setEditable(false);
        jp3.add(Restaurant3location_area);
        
        JLabel Restaurant3Type_label = new JLabel("Restaurant Type");
        Restaurant3Type_label.setBounds(30,300,170,40);
        Restaurant3Type_label.setFont(font);
        jp3.add(Restaurant3Type_label);
        
        Restaurant3_Type = new JTextField();
        Restaurant3_Type.setBounds(230,300,200,40);
        Restaurant3_Type.setBackground(Color.WHITE);
        Restaurant3_Type.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant3_Type.setEditable(false);
        jp3.add(Restaurant3_Type);
        
        JLabel Restaurant3rating_label = new JLabel("Restaurant Ratings");
        Restaurant3rating_label.setBounds(30,350,170,40);
        Restaurant3rating_label.setFont(font);
        jp3.add(Restaurant3rating_label);
        
        Restaurant3_rating = new JTextField();
        Restaurant3_rating.setBounds(230,350,200,40);
        Restaurant3_rating.setBackground(Color.WHITE);
        Restaurant3_rating.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Restaurant3_rating.setEditable(false);
        jp3.add(Restaurant3_rating);
        
     ImageIcon back=new ImageIcon("D:\\\\SEM 5-2021\\\\miniproject 5th sem\\\\Facebook Post 940x788 px (2).jpeg");
     button = new JButton(back);
     button.setBounds(150,780,90,50);
     button.setBackground(Color.WHITE);
     button.setFocusable(false);
     f.add(button);
     button.addActionListener(this);
        
     button1 = new JButton("Done");
     button1.setBounds(900,780,100,50);
     button1.setBackground(new Color(190, 239, 246));
     button1.setForeground(Color.BLACK);
     button1.setFont(font);
     f.add(button1);
     button1.addActionListener(this);
        
     f.setBounds(0,0,1970,1030);
     f.setBackground(new Color(27, 172, 192));
     f.getContentPane().setBackground(new Color(236, 242, 243 ));
     f.getRootPane().setBorder(BorderFactory.createTitledBorder( BorderFactory.createMatteBorder(70, 30,30, 30,new Color(27, 172, 192 )) , "Restaurant", 2, 2,new Font("Bookman Old Style",Font.BOLD,30),new Color(255,255,255 )));
     f.setLayout(null);
     f.setVisible(true);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   @Override
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==button){
            f.dispose();
       }
       if(e.getSource()==button1){
          // f.dispose();
       }
   }
   public static void main(String[] args){
       new Restaurant();
   }
}
