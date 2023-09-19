package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Login.Attempt;

public class Manage_Employee implements ActionListener {

    public void main(String[] args) {
        new Manage_Employee();
    }

    static JFrame f;
    JButton b1, b2, b3, b4, back;

    public Manage_Employee() {
        /** Creating Frame **/
        f = new JFrame("Manage Employee");

        /** Background **/
        ImageIcon background_image= new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Employee/employeeImg.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);
        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);
        f.add(background);

        /** Adding buttons **/
        b1 = new JButton("Add Employee");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(170,50,250,50);
        background.add(b1);

        b2 = new JButton("Update Employee");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170, 150, 250, 50);
        background.add(b2);

        b3 = new JButton("Remove Employee");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(170, 250, 250, 50);
        background.add(b3);

        b4 = new JButton("View Employee");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(170, 350, 250, 50);
        background.add(b4);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250, 470, 100, 40);
        background.add(back);

        /** registering buttons to the listener **/
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        back.addActionListener(this);

        /** setting the frame **/
        f.setSize(900, 600);
        f.setLocation(220,40);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {
            new Add_Employee();
            f.setVisible(false);
        }

        if(e.getSource() == b2) {
            new Update_Employee();
            f.setVisible(false);
        }

        if(e.getSource() == b3) {
            new Remove_Employee();
            f.setVisible(false);
        }

        if(e.getSource() == b4) {
            new View_Employee();
            f.setVisible(false);
        }

        if(e.getSource() == back) {
            new Attempt();
            f.setVisible(false);
        }

    }

   
    
}
