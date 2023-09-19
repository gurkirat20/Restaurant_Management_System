package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Update_Employee implements ActionListener {
    JFrame f;
    JLabel lab, l, l1, l2, l3, l4, l5, l6;
    JTextField t, t1, t2, t3, t4, t5, t6;
    JButton b, b1, b2;

    Update_Employee() {
        /** Creating Frame **/
        f = new JFrame("Update Employee");

        ImageIcon background_image= new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Employee/empImg2.jfif");

        Image img= background_image.getImage();
        Image im= img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);
        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,700,600);

        /** Main Heading **/
        lab = new JLabel("Update Employee Details");
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setSize(700, 80);
        lab.setFont(new Font("Poppins", Font.BOLD,25));
        lab.setForeground(Color.black);
        f.add(lab);

        l = new JLabel("Enter Employee ID :");
        l.setBounds(50, 100, 180, 25);
        l.setFont(new Font("Ubuntu", Font.BOLD, 16));
        f.add(l);

        t = new JTextField();
        t.setBounds(300,100,180,25);
        f.add(t);

        /** Search button **/
        b = new JButton("Search");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(378, 145, 100, 30);
        f.add(b);

        b.addActionListener(this);

        /** Name **/
        l1 = new JLabel("Name");
        l1.setBounds(50, 200, 100, 30);
        l1.setFont(new Font("Poppins", Font.BOLD, 15));
        l1.setVisible(false);
        f.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 200, 180, 30);
        t1.setVisible(false);
        f.add(t1);

        /** Age **/
        l2 = new JLabel("Age");
        l2.setBounds(50, 250, 100, 30);
        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        l2.setVisible(false);
        f.add(l2);

        t2 = new JTextField();
        t2.setBounds(200, 250, 180, 30);
        t2.setVisible(false);
        f.add(t2);

        /** Address **/
        l3 = new JLabel("Address");
        l3.setBounds(50, 300, 100, 30);
        l3.setFont(new Font("Poppins", Font.BOLD, 15));
        l3.setVisible(false);
        f.add(l3);

        t3 = new JTextField();
        t3.setBounds(200, 300, 180, 30);
        t3.setVisible(false);
        f.add(t3);

        /** Phone **/
        l4 = new JLabel("Phone");
        l4.setBounds(50, 350, 100, 30);
        l4.setFont(new Font("Poppins", Font.BOLD, 15));
        l4.setVisible(false);
        f.add(l4);

        t4 = new JTextField();
        t4.setBounds(200, 350, 180, 30);
        t4.setVisible(false);
        f.add(t4);

        /** Email **/
        l5 = new JLabel("Email");
        l5.setBounds(50, 400, 100, 30);
        l5.setFont(new Font("Poppins", Font.BOLD, 15));
        l5.setVisible(false);
        f.add(l5);

        t5 = new JTextField();
        t5.setBounds(200, 400, 180, 30);
        t5.setVisible(false);
        f.add(t5);

        /** Designation **/
        l6 = new JLabel("Designation");
        l6.setBounds(50, 450, 100, 30);
        l6.setFont(new Font("Poppins", Font.BOLD, 15));
        l6.setVisible(false);
        f.add(l6);

        t6 = new JTextField();
        t6.setBounds(200, 450, 180, 30);
        t6.setVisible(false);
        f.add(t6);

        /** Update Button **/
        b1 = new JButton("UPDATE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80, 515, 100, 30);
        b1.setVisible(false);
        f.add(b1);

        /** Cancel Button **/
        b2 = new JButton("CANCEL");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 515, 100, 30);
        b2.setVisible(false);
        f.add(b2);

        /** registering the buttons to the listener **/
        b1.addActionListener(this);
        b2.addActionListener(this);

        /** Setting the frame **/
        f.setSize(700,600);
        f.setLocation(280,40);
        f.add(background);
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
                l3.setVisible(true);
                l4.setVisible(true);
                l5.setVisible(true);
                l6.setVisible(true);
                b1.setVisible(true);
                b2.setVisible(true);

                t1.setText(employee.getName());
                t1.setVisible(true);
                t2.setText(Integer.toString(employee.getAge()));
                t2.setVisible(true);
                t3.setText(employee.getAddress());
                t3.setVisible(true);
                t4.setText(employee.getPhoneNumber());
                t4.setVisible(true);
                t5.setText(employee.getEmail());
                t5.setVisible(true);
                t6.setText(employee.getDesignation());
                t6.setVisible(true);
            }
            else {
                f.setVisible(false);
                Manage_Employee.f.setVisible(true);
            }
        }

        if(e.getSource() == b1){
            String name = t1.getText();
            int age = Integer.parseInt(t2.getText());
            String address = t3.getText();
            String phone = t4.getText();
            String email = t5.getText();
            String designation = t6.getText();
            Employee newEmployee = new Employee(ID, name, age, address, phone, email, designation);
            list.updateEmployee(employee, newEmployee);
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
