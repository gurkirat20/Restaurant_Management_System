package Order;

import Employee.ExceptionClass;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Delete_MenuItem extends ExceptionClass {

    
    Delete_MenuItem() {

        JFrame f = new JFrame("REMOVE MENU ITEM");

        /**** Background ****/
        ImageIcon background_image= new ImageIcon("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Order/delete.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);

        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);

        /**** Header ****/
        JPanel heading= new JPanel();
        heading.setBackground(new Color(0,0,0,90));
        heading.setBounds(0,0,900,100);

        JLabel name= new JLabel("REMOVE ITEM DETAILS");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(900, 100);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Poppins", Font.BOLD,40));
        heading.add(name);
        background.add(heading);

        /*** panel ****/
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(250,160, 400, 300);
        panel.setBackground(new Color(0, 0, 0, 90));
        background.add(panel);

        /**** panel body ****/
        JLabel a = new JLabel("Enter ItemID : ");
        a.setBounds(20,60,200,50);
        a.setFont(new Font("Ubuntu", Font.BOLD, 18));
        a.setForeground(Color.white);
        panel.add(a);

        JTextField itemID= new JTextField();
        itemID.setBounds(180,60,200,40);
        itemID.setForeground(Color.white);
        itemID.setBackground(Color.black);
        panel.add(itemID);

        JButton del = new JButton("DELETE");
        del.setBounds(50,220,100,40);
        del.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        panel.add(del);

        JButton back = new JButton("BACK");
        back.setBounds(250, 220, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);


        /**** Setting the frame ****/
        f.add(background);
        f.setSize(900,600);
        f.setLocation(280, 40);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**** Handling Events ****/
        del.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

             int flag=0;
             String id=itemID.getText();
            
             try {
                 BufferedWriter tempWriter = new BufferedWriter(new FileWriter("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Order/temp.txt",false));
                 BufferedReader menuReader = new BufferedReader(new FileReader("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Order/menu.txt"));
            
                 String str = "";
                 while((str=menuReader.readLine()) != null) {
                     if(!str.startsWith(id)) {
                        tempWriter.write(str+"\n");
                     }
                     else flag = 1;
                 }
            
                 tempWriter.close();
                 menuReader.close();
            
                 BufferedReader tempReader = new BufferedReader(new FileReader("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Order/temp.txt"));
                 BufferedWriter menuWriter = new BufferedWriter(new FileWriter("C:/Users/gurki/OneDrive/Desktop/Java Project/src/Order/menu.txt"));
            
                 String str1 = "";
                 while((str1=tempReader.readLine()) != null) {
                        menuWriter.write(str1+"\n");
                 }
                 if(flag==1)
                     JOptionPane.showMessageDialog(null,"Content modified");
                 else
                     throw new ExceptionClass ("Please enter correct item ID");

                 tempReader.close();
                 menuWriter.close();

                 File f=new File("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Order\\temp.txt");
                 f.delete();
             }
             catch(IOException io) {
                 JOptionPane.showMessageDialog(null,"IO EXCEPTION THROWN");
             }
             catch (ExceptionClass exception) {
                 exception.showMessage();
             }
         }

        });

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Order2();
            }

        });



    }
}
