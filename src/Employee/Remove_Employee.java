package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Remove_Employee implements ActionListener {
    JFrame f;
    JLabel lab, l, l1, l2, l3, l4, l5, l6, l7;
    JTextField t;
    JButton b, b1, b2;

    Remove_Employee() {
        /**** Frame ****/
        f = new JFrame("Remove Employee");

        ImageIcon background_image= new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Employee/remove.jfif");

        Image img= background_image.getImage();
        Image im= img.getScaledInstance(470,350,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);
        JLabel background= new JLabel(" ", background_image, JLabel.RIGHT);
        background.setBounds(450,200,450,400);
        f.add(background);
        background.setVisible(true);

        /**** Main Heading ****/
        lab = new JLabel("Remove Employee");
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setSize(600, 80);
        lab.setFont(new Font("Poppins", Font.BOLD,25));
        lab.setForeground(Color.black);
        f.add(lab);

        /** Label **/
        l = new JLabel("Enter Employee ID :");
        l.setBounds(50, 100, 180, 25);
        l.setFont(new Font("Ubuntu", Font.BOLD, 16));
        f.add(l);

        /** TextField **/
        t = new JTextField();
        t.setBounds(300,100,180,25);
        f.add(t);

        /** Search Button **/
        b = new JButton("SEARCH");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(378, 140, 100, 30);
        f.add(b);

        /** registering button to listener **/
        b.addActionListener(this);

        /** After Search **/

        /** Employee.Employee Details **/
        l1 = new JLabel("Employee Details :");
        l1.setBounds(50, 195, 180, 25);
        l1.setFont(new Font("Ubuntu", Font.BOLD, 17));
        l1.setVisible(false);
        f.add(l1);

        /** Name **/
        l2 = new JLabel("Name :");
        l2.setBounds(50, 225, 180, 75);
        l2.setFont(new Font("sans serif", Font.BOLD, 15));
        l2.setVisible(false);
        f.add(l2);

        l3 = new JLabel("abc");
        l3.setBounds(200, 225, 180, 75);
        l3.setVisible(false);
        f.add(l3);

        /** Phone **/
        l4 = new JLabel("Phone :");
        l4.setBounds(50, 265, 180, 75);
        l4.setFont(new Font("sans serif", Font.BOLD, 15));
        l4.setVisible(false);
        f.add(l4);

        l5 = new JLabel("def");
        l5.setBounds(200, 265, 180, 75);
        l5.setVisible(false);
        f.add(l5);

        /** Email **/
        l6 = new JLabel("Email :");
        l6.setBounds(50, 305, 180, 75);
        l6.setFont(new Font("sans serif", Font.BOLD, 15));
        l6.setVisible(false);
        f.add(l6);

        l7 = new JLabel("ghi");
        l7.setBounds(200, 305, 180, 75);
        l7.setVisible(false);
        f.add(l7);

        /** Remove Button **/
        b1 = new JButton("REMOVE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80, 390, 100, 30);
        b1.setVisible(false);
        f.add(b1);

        /** Cancel Button **/
        b2 = new JButton("CANCEL");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 390, 100, 30);
        b2.setVisible(false);
        f.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        /**** Setting the frame ****/
        f.setSize(900, 600);
        f.setLocation(280,40);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        int ID = Integer.parseInt(t.getText());
        EmployeeList list = new EmployeeList();
        Employee employee = list.searchEmployeeByID(ID);

        if(e.getSource() == b) {
            if(employee != null) {
                l1.setVisible(true);
                l2.setVisible(true);
                l3.setText(employee.getName());
                l3.setVisible(true);
                l4.setVisible(true);
                l5.setText(employee.getPhoneNumber());
                l5.setVisible(true);
                l6.setVisible(true);
                l7.setText(employee.getEmail());
                l7.setVisible(true);
                b1.setVisible(true);
                b2.setVisible(true);
            }
            else {
                f.setVisible(false);
                Manage_Employee.f.setVisible(true);
            }
        }

        if(e.getSource() == b1) {
            list.removeEmployee(employee);
            list.dataToFile();
            f.setVisible(false);
            Manage_Employee.f.setVisible(true);
        }

        if(e.getSource() == b2) {
            f.setVisible(false);
            Manage_Employee.f.setVisible(true);
        }

    }

}
