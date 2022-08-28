/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class register {

    JFrame register_form;
    JButton Confirm, back;
    JTextField name, age, dob, last, mail, phnumber, pass, pass1, address, city, district;
    JLabel name_label, last_label, age_label, dob_label, mail_label, phnumber_label, pass_label, pass1_label, gender_label, head_label, address_label, state_label, city_label, district_label;
    String font;
    JScrollPane scroll;
    String fn,ln,d,m,ph,di,add,ci,pa, w, gn, st,ag;
           
    @SuppressWarnings("empty-statement")
    public register() {
        //beanregister bean = new beanregister();
        register_form = new JFrame("Sign Up");
        register_form.setBackground(new Color(27, 172, 192));
        ///*************LABEL**************//
        name_label = new JLabel("First Name");
        name_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        name_label.setForeground(new Color(0, 5, 6));
        name_label.setBounds(150, 50, 150, 50);
        last_label = new JLabel("Last Name");
        last_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        last_label.setForeground(new Color(0, 5, 6));
        last_label.setBounds(150, 150, 150, 50);

        dob_label = new JLabel("DateofBirth");
        dob_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        dob_label.setForeground(new Color(0, 5, 6));
        dob_label.setBounds(150, 250, 150, 50);
        mail_label = new JLabel("Email");
        mail_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        mail_label.setForeground(new Color(0, 5, 6));
        mail_label.setBounds(150, 350, 150, 50);
        gender_label = new JLabel("Gender");
        gender_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        gender_label.setForeground(new Color(0, 5, 6));
        gender_label.setBounds(150, 450, 150, 50);
        age_label = new JLabel("Age");
        age_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        age_label.setForeground(new Color(0, 5, 6));
        age_label.setBounds(150, 650, 150, 50);
        address_label = new JLabel("Address");
        address_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        address_label.setForeground(new Color(0, 5, 6));
        address_label.setBounds(950, 350, 150, 50);
        city_label = new JLabel("City");
        city_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        city_label.setForeground(new Color(0, 5, 6));
        city_label.setBounds(950, 450, 200, 50);
        district_label = new JLabel("District");
        district_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        district_label.setForeground(new Color(0, 5, 6));
        district_label.setBounds(950, 550, 200, 50);
        state_label = new JLabel("State");
        state_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        state_label.setForeground(new Color(0, 5, 6));
        state_label.setBounds(950, 650, 200, 50);
        phnumber_label = new JLabel("Contact no");
        phnumber_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        phnumber_label.setForeground(new Color(0, 5, 6));
        phnumber_label.setBounds(150, 550, 150, 50);
        pass_label = new JLabel("Enter Password");
        pass_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        pass_label.setForeground(new Color(0, 5, 6));
        pass_label.setBounds(150, 750, 200, 50);
        pass1_label = new JLabel("Re-enter Password");
        pass1_label.setFont(new Font("Bauhaus Bold", Font.BOLD, 20));
        pass1_label.setForeground(new Color(0, 5, 6));
        pass1_label.setBounds(950, 750, 250, 50);

        name = new JTextField();
        name.setBackground(new Color(255, 255, 255));
        name.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        name.setBounds(600, 50, 300, 40);
        name.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        last = new JTextField();
        last.setBackground(new Color(255, 255, 255));
        last.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        last.setBounds(600, 150, 300, 40);
        last.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        dob = new JTextField();
        dob.setBackground(new Color(255, 255, 255));
        dob.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        dob.setBounds(600, 250, 300, 40);
        dob.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        mail = new JTextField();
        mail.setBackground(new Color(255, 255, 255));
        mail.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        mail.setBounds(600, 350, 300, 40);
        mail.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        address = new JTextField();
        address.setBackground(new Color(255, 255, 255));
        address.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        address.setBounds(1200, 350, 400, 60);
        address.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        city = new JTextField();
        city.setBackground(new Color(255, 255, 255));
        city.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        city.setBounds(1200, 450, 300, 40);
        city.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        district = new JTextField();
        district.setBackground(new Color(255, 255, 255));
        district.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        district.setBounds(1200, 550, 300, 40);
        district.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        phnumber = new JTextField();
        phnumber.setBackground(new Color(255, 255, 255));
        phnumber.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        phnumber.setBounds(600, 550, 300, 40);
        phnumber.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        age = new JTextField();
        age.setBackground(new Color(255, 255, 255));
        age.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        age.setBounds(600, 650, 300, 40);
        age.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        pass = new JTextField();
        pass.setBackground(new Color(255, 255, 255));
        pass.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        pass.setBounds(600, 750, 300, 40);
        pass.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        String g[] = {"", "male", "female", "transgender"};
        JComboBox gender = new JComboBox(g);
        gender.setBounds(600, 450, 300, 40);
        gender.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 2));
        gender.setFocusable(false);
        gender.setFont(new Font("Bauhaus Bold", Font.BOLD, 15));
        gender.setBackground(new Color(255, 255, 255));
        gender.addItemListener(new ItemListener() {
            @Override

            public void itemStateChanged(ItemEvent e) {

                if (e.getSource() == gender) {

                    gn = (String) gender.getSelectedItem();
                }
            }
        });
        String s[] = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "'+puducherry+'"};
        JComboBox state = new JComboBox(s);
        state.setBounds(1200, 650, 300, 40);
        state.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        state.setBackground(new Color(255, 255, 255));
        state.addItemListener(new ItemListener() {
            @Override

            public void itemStateChanged(ItemEvent e) {

                if (e.getSource() == state) {

                    st = (String) state.getSelectedItem();
                }
            }
        });
        pass1 = new JPasswordField();
        pass1.setBounds(1200, 750, 300, 40);
        pass1.setBorder(BorderFactory.createLineBorder(new Color(100, 17, 17), 3));
        pass1.setBackground(new Color(255, 255, 255));

        Confirm = new JButton("Createaccount");
        Confirm.setFont(new Font("SERIF", Font.BOLD, 20));
        Confirm.setForeground(Color.white);
        Confirm.setFocusable(true);
        Confirm.setBackground(new Color(48, 137, 211));
        Confirm.setBounds(800, 840, 200, 50);
        ImageIcon home_icon = new ImageIcon("D:\\\\SEM 5-2021\\\\miniproject 5th sem\\\\home.jpeg");
        back = new JButton(home_icon);
        back.setFont(new Font("SERIF", Font.HANGING_BASELINE, 20));
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.setBackground(new Color(255, 255, 255));
        back.setBounds(100, 820, 150, 90);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    /*try {
                        ServerSocket ss=new ServerSocket(7000);
                    } catch (IOException ex) {
                    }*/
                    register_form.dispose();
                }
                register_form.dispose();
            }
        });

        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Confirm) {
                    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                     fn = name.getText();
                     ln = last.getText();
                     d = dob.getText();
                     m = mail.getText();
                     ph = phnumber.getText();
                     ag = age.getText();
                     di = district.getText();
                     add = address.getText();
                     ci = city.getText();
                     pa = pass.getText();
                    String pa1 = pass1.getText();
                    String phone_regex = "\\d{5}\\d{5}";
                    String date = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
                    String passre="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                    Pattern paregex=Pattern.compile(passre);
                    Pattern pattern = Pattern.compile(EMAIL_REGEX);
                    Pattern pat = Pattern.compile(date);
                    Pattern p1 = Pattern.compile(phone_regex);
                    Matcher mat = pattern.matcher(m);
                    Matcher ma = pat.matcher(d);
                    Matcher matt = p1.matcher(ph);
                    Matcher mpas=paregex.matcher(pa);

                    if (fn.length() == 0) {
                        JOptionPane.showMessageDialog(register_form, "enter user name");
                    } else if (d.length() == 0) {
                        JOptionPane.showMessageDialog(register_form, "enter dateofbirth");
                    } else if (!ma.matches()) {
                        JOptionPane.showMessageDialog(register_form, "enter  dob in correct format  dd-mm-yyyy");

                    } else if (m.length() == 0) {
                        JOptionPane.showMessageDialog(register_form, "Entermail");
                    } else if (!mat.matches()) {
                        JOptionPane.showMessageDialog(register_form, "Enter valid email");

                    } else if (ph.length() == 0) {
                        JOptionPane.showMessageDialog(register_form, "enter phone number");
                    } else if (!matt.matches()) {
                        JOptionPane.showMessageDialog(register_form, "enter  valid phone-number");

                    } else if (gn.length() == 0) {
                        JOptionPane.showMessageDialog(register_form, "select gender");
                    } else if (pa.length() == 0) {
                        JOptionPane.showMessageDialog(register_form, "enter password");
                    } 
                    else if(!mpas.matches()){
                        JOptionPane.showMessageDialog(register_form,"Enter password with at least one uppercase letter, one lowercase letter, one number and one special character");
                    }
                    else if (!pass.getText().equals(pass1.getText())) {
                        JOptionPane.showMessageDialog(register_form, "Enter valid pass");

                    } 
                    else if(add.length()==0||add.length()>35){
                        JOptionPane.showMessageDialog(register_form,"Enter address");
                    }
                    else if(gn==null){
                        JOptionPane.showMessageDialog(register_form,"Select Gender");
                    }
                    else if(st==null){
                        JOptionPane.showMessageDialog(register_form,"Select State");
                    }
                    else if(ci.length()==0){
                        JOptionPane.showMessageDialog(register_form,"Enter City");
                    }
                    else if(di.length()==0){
                        JOptionPane.showMessageDialog(register_form,"Enter District");
                    }
                    else {
                        
                        //be.insert_register(fn,ln,gn,d,ag,ph,m,add,ci,di,st,pa);
                        JOptionPane.showMessageDialog(register_form, "Accountcreated");
                    }
                    Registration_Bean bean = new Registration_Bean();
                    bean.setFname(fn);
                    bean.setLname(ln);
                    bean.setDob(d);
                    bean.setGender(gn);
                    bean.setMail(m);
                    bean.setPhno(ph);
                    bean.setAge(ag);
                    bean.setAddressline1(add);
                    bean.setCity(ci);
                    bean.setDistrict(di);
                    bean.setState(st);
                    bean.setPass(pa);
                    
                    try {
                        Socket r1 = new Socket("localhost",7000);
                        
                        ObjectOutputStream os = new ObjectOutputStream(r1.getOutputStream());
                        os.writeObject(bean);
                    } catch (IOException ex) {
                        
                    }

                
                    
                }
            }
        });
        register_form.add(name_label);
        register_form.add(last_label);
        register_form.add(dob_label);
        register_form.add(mail_label);
        register_form.add(gender_label);
        register_form.add(pass1_label);
        register_form.add(pass_label);
        register_form.add(address_label);
        register_form.add(city_label);
        register_form.add(state_label);
        register_form.add(phnumber_label);
        register_form.add(district_label);
        register_form.add(age_label);
        register_form.add(age);
        register_form.add(district);
        register_form.add(name);
        register_form.add(last);
        register_form.add(dob);
        register_form.add(mail);
        register_form.add(phnumber);
        register_form.add(address);
        register_form.add(city);
        register_form.add(state);
        register_form.add(pass);
        register_form.add(pass1);
        register_form.add(Confirm);
        register_form.add(gender);
        register_form.add(back);
        register_form.getContentPane().setBackground(new Color(230, 236, 241));
        register_form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register_form.setSize(1900, 1020);
        register_form.getRootPane().setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(30, 10, 10, 10, new Color(27, 172, 192)), "Register", 2, 2, new Font("Bookman Old Style", Font.CENTER_BASELINE, 20), new Color(255, 255, 255)));
        register_form.setLayout(null);
        register_form.setVisible(true);

    }

}

