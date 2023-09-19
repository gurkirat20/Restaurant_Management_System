package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Add_Employee implements ActionListener {
    JFrame f;
    JLabel lab, l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    JPanel body;

    Add_Employee() {
        /**** Creating Frame ****/
        f = new JFrame("Add Employee");

        /**** Background ****/
        ImageIcon background_image= new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Employee/employeeImg.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(700,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);

        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,700,600);
        f.add(background);

        /**** Main Heading ****/
        lab = new JLabel("Employee Details");
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setSize(700, 80);
        lab.setFont(new Font("Poppins", Font.BOLD,30));
        lab.setForeground(Color.black);
        background.add(lab);

        
        body = new JPanel();
        body.setLayout(null);
        body.setBounds(30, 70, 500, 450);
        body.setBackground(new Color(0, 0, 0, 100));
        background.add(body);

        /**** ID ****/
        l1 = new JLabel("Employee ID");
        l1.setBounds(50, 30, 200, 30);
        l1.setFont(new Font("poppins", Font.BOLD, 15));
        l1.setForeground(Color.white);
        body.add(l1);

        t1 = new JTextField();
        t1.setBounds(220, 30, 200, 30);
        body.add(t1);

        /**** Name ****/
        l2 = new JLabel("Name");
        l2.setBounds(50, 80, 200, 30);
        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        l2.setForeground(Color.white);
        body.add(l2);

        t2 = new JTextField();
        t2.setBounds(220, 80, 200, 30);
        body.add(t2);

        /**** Age ****/
        l3 = new JLabel("Age");
        l3.setBounds(50, 130, 200, 30);
        l3.setFont(new Font("Poppins", Font.BOLD, 15));
        l3.setForeground(Color.white);
        body.add(l3);

        t3 = new JTextField();
        t3.setBounds(220, 130, 200, 30);
        body.add(t3);

        /**** Address ****/
        l4 = new JLabel("Address");
        l4.setBounds(50, 180, 200, 30);
        l4.setFont(new Font("Poppins", Font.BOLD, 15));
        l4.setForeground(Color.white);
        body.add(l4);

        t4 = new JTextField();
        t4.setBounds(220, 180, 200, 30);
        body.add(t4);

        /**** Phone ****/
        l5 = new JLabel("Phone");
        l5.setBounds(50, 230, 200, 30);
        l5.setFont(new Font("Poppins", Font.BOLD, 15));
        l5.setForeground(Color.white);
        body.add(l5);

        t5 = new JTextField();
        t5.setBounds(220, 230, 200, 30);
        body.add(t5);

        /**** Email ****/
        l6 = new JLabel("Email");
        l6.setBounds(50, 280, 200, 30);
        l6.setFont(new Font("Poppins", Font.BOLD, 15));
        l6.setForeground(Color.white);
        body.add(l6);

        t6 = new JTextField();
        t6.setBounds(220, 280, 200, 30);
        body.add(t6);

        /**** Designation ****/
        l7 = new JLabel("Designation");
        l7.setBounds(50, 330, 200, 30);
        l7.setFont(new Font("Poppins", Font.BOLD, 15));
        l7.setForeground(Color.white);
        body.add(l7);

        t7 = new JTextField();
        t7.setBounds(220, 330, 200, 30);
        body.add(t7);

        /**** Submit Button ****/
        b1 = new JButton("ADD");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100, 390, 100, 40);
        body.add(b1);

        /**** Cancel Button ****/
        b2 = new JButton("CANCEL");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 390, 100, 40);
        body.add(b2);

        /**** Registering the buttons to the listener ****/
        b1.addActionListener(this);
        b2.addActionListener(this);

        /**** Setting the frame ****/
        f.setSize(700, 600);
        f.setLocation(280,40);
        f.setLayout(null);
        f.add(background);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {
            int ID = Integer.parseInt(t1.getText());
            String name = t2.getText();
            int age = Integer.parseInt(t3.getText());
            String address = t4.getText();
            String phone = t5.getText();
            String email = t6.getText();
            String designation = t7.getText();

            EmployeeList list = new EmployeeList();
            list.addEmployee(new Employee(ID, name, age, address, phone, email, designation));
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