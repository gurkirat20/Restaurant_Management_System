package Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sales {

    Sales(){
        JFrame j=new JFrame("SALES");
        Font f=new Font("serif",Font.BOLD,30);

        /**** background ****/
        ImageIcon background_image = new ImageIcon("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Payment\\bill2.jpeg");
        Image img = background_image.getImage();
        Image im = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(im);
        JLabel background = new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 600);

        /**** Heading ****/
        JPanel header=new JPanel();
        header.setBackground(new Color( 0,0,0,80));
        header.setBounds(0,0,900,50);

        /**** Heading ****/
        JLabel heading=new JLabel("SALES");
        heading.setFont(f);
        heading.setForeground(Color.WHITE);
        header.add(heading);
        heading.setVerticalAlignment(JLabel.CENTER);
        background.add(header);

        /**** Secondary panel ****/
        JPanel sec=new JPanel();
        sec.setLayout(null);
        sec.setBackground(new Color( 0,0,0,80));
        sec.setBounds(200,100,500,600);

        /**** tertiary panel ****/
        JPanel tert=new JPanel();
        tert.setBackground(new Color( 0,0,0,80));
        tert.setBounds(20,20,450,300);
        String temp=new String();

        /**** button for navigating ot the last page ****/
        JButton back=new JButton("Back");
        back.setBounds(200,350,100,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        sec.add(back);

        /**** creating a text area ****/
        JTextArea ta = new JTextArea(20, 40);

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Order\\Orders.txt"));

            String str = new String();
            while ((str = br.readLine()) != null) {
                ta.append(str+"\n");
            }

        }
        catch(IOException io)
        {
            io.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tert.add(sp);
        sp.setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.setVisible(false);
                new billGUI();
            }
        });

        sec.add(tert);
        background.add(sec);
        j.setBounds(0,0,900,600);
        j.setVisible(true);
        j.add(background);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}