package Login;

import Employee.Employee;
import Employee.EmployeeList;
import Employee.ExceptionClass;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Register extends ExceptionClass {

    Register() {

        JFrame f = new JFrame("Login");

        /**** Background ****/
        ImageIcon background_image = new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Login/bg.jpg");
        Image img = background_image.getImage();
        Image im = img.getScaledInstance(500,500, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(im);

        JLabel background = new JLabel(background_image);
        background.setBounds(0, 0, 500, 500);

        /**** Heading ****/
        JPanel heading = new JPanel();
        heading.setLayout(null);
        heading.setBounds(0, 0, 500, 100);
        heading.setBackground(new Color(0, 0, 0, 90));

        JLabel name = new JLabel("NEW USER REGISTRATION");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(500, 100);
        name.setForeground(Color.white);
        name.setFont(new Font("Poppins", Font.BOLD,20));
        heading.add(name);
        background.add(heading);

        /**** Body ****/
        JLabel uid = new JLabel("ENTER USERID : ");
        uid.setBounds(50,150,200,50);
        uid.setFont(new Font("Ubuntu", Font.BOLD,15));
        uid.setBackground(Color.BLACK);
        uid.setForeground(Color.WHITE);
        background.add(uid);

        JTextField UserID = new JTextField();
        UserID.setBounds(270,150,150,40);
        UserID.setForeground(Color.WHITE);
        UserID.setBackground(Color.BLACK);
        background.add(UserID);

        JLabel pass = new JLabel("CREATE PASSWORD : ");
        pass.setBounds(50,220,200,50);
        pass.setFont(new Font("Ubuntu", Font.BOLD,15));
        pass.setBackground(Color.BLACK);
        pass.setForeground(Color.WHITE);
        background.add(pass);

        JPasswordField password = new JPasswordField();
        password.setBounds(270,220,150,40);
        password.setForeground(Color.WHITE);
        password.setBackground(Color.BLACK);
        background.add(password);

        JButton register = new JButton("PROCEED");
        register.setBounds(100,340,100,40);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        background.add(register);

        f.add(background);

        /**** Setting the frame ****/
        f.setSize(500, 500);
        f.setLocation(280,50);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        /**** Handling Events ****/
        register.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                String userid = UserID.getText();
                String pwd = password.getText();
                try {
                    FileWriter w = new FileWriter("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Login/idPass.txt", true);
                    EmployeeList list = new EmployeeList();
                    list.getDataFromFile();
                    Employee e = list.searchEmployeeByID(Integer.parseInt(userid));
                    if(e != null) {
                        w.write(userid + " , " + pwd + '\n');
                    }
                    w.close();
                    new LoginPage();
                    f.setVisible(false);

                    File f = new File("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Login\\temp.txt");
                    f.delete();
                }
                catch (IOException ex) {
                   ex.printStackTrace();
                }
            }

        });

    }
        
}
