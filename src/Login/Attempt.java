package Login;

import Employee.Manage_Employee;
import Order.Order2;
import Payment.billGUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Attempt {

    static JButton Order_button, emp, Payment;

    public Attempt() {

        JFrame f = new JFrame("HOME PAGE");

        /**** Background ****/
        ImageIcon background_image= new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Login/home.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);

        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);
        f.add(background);

        /**** Header ****/
        JPanel heading= new JPanel();
        heading.setBackground(new Color(0,0,0,100));
        heading.setBounds(0,0,900,100);

        JLabel name= new JLabel("A-ONE RESTAURANT");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(900, 100);
        name.setForeground(Color.RED);
        name.setFont(new Font("Poppins", Font.BOLD,40));
        heading.add(name);

        /**** Menu ****/
        JPanel Menu= new JPanel();
        Menu.setLayout(null);
        Menu.setBackground(new Color(0,0,0,100));
        Menu.setBounds(222,170,450,350);

        emp= new JButton("Employee Management");
        emp.setBounds(105,50,250,50);
        emp.setFont(new Font("Poppins", Font.BOLD, 15));
        emp.setBackground(Color.RED);
        emp.setForeground(Color.WHITE);
        Menu.add(emp);

        Order_button= new JButton("Order Management");
        Order_button.setBounds(105,150,250,50);
        Order_button.setFont(new Font("Poppins", Font.BOLD, 15));
        Order_button.setBackground(Color.RED);
        Order_button.setForeground(Color.WHITE);
        Menu.add(Order_button);

         Payment= new JButton("Payment Report");
        Payment.setBounds(105,250,250,50);
        Payment.setFont(new Font("Poppins", Font.BOLD, 15));
        Payment.setBackground(Color.RED);
        Payment.setForeground(Color.WHITE);
        Menu.add(Payment);

        background.add(Menu);
        background.add(heading);
        f.add(background);

        /**** Setting the frame ****/
        f.setSize(900,600);
        f.setLocation(220, 40);
        f.setLayout(null);
        f.setVisible(true);

        /**** Handling Events ****/
        Order_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new Order2();
                f.setVisible(false);
            }
        });

        emp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new Manage_Employee();
                f.setVisible(false);
            }
        });

        Payment.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new billGUI();
                f.setVisible(false);
            }
        });
    }

}