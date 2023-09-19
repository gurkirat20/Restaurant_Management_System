package Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Login.Attempt;

public class billGUI{

    /**** constructor ****/
    public billGUI(){
        /**** calculating the bill for the latest order ****/

        int tot = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Order\\latOrder.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Payment\\bill.txt"));

            String str1 = new String();
            while ((str1 = br.readLine()) != null) {
                int a = 0, qu = 0;
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) == ',') {
                        a++;
                    }
                    if (a == 2) {
                        qu = i;
                        break;
                    }
                }

                qu += 4;
                StringBuilder str2 = new StringBuilder();
                for (int i = qu + 1; i < str1.length(); i++) {
                    if (str1.charAt(i) != '\t') {
                        str2.append(str1.charAt(i));
                    } else
                        break;
                }
                String str3 = str2.toString();
                int cInt = Integer.parseInt(str3);

                int qu2 = 0, b = 0;
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) == ',') {
                        b++;
                    }
                    if (b == 3) {
                        qu2 = i;
                        break;
                    }
                }

                StringBuilder str4 = new StringBuilder();
                for (int i = qu2 + 1; i < str1.length(); i++) {
                    str4.append(str1.charAt(i));
                }


                String str5 = str4.toString();
                int qInt = Integer.parseInt(str5);
                bw.write(str1 + "," + qInt * cInt + "\n");
                tot += qInt * cInt;
            }
            br.close();
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Payment\\bill.txt"));
            bw.write("\n" + "Total is " + tot + "\n");

            bw.write("-----\n");

            bw.close();
            reader.close();

        } catch (IOException io) {
            //System.out.println("IO EXCEPTION THROWN");
        }



        /**** frame ****/
        JFrame j=new JFrame("BILL");
        Font f=new Font("serif",Font.BOLD,30);

        /**** for background image ****/
	    ImageIcon background_image = new ImageIcon("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Payment\\bill2.jpeg");
        Image img = background_image.getImage();
        Image im = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(im);
        JLabel background = new JLabel(" ", background_image, JLabel.CENTER);
	    background.setBounds(0, 0, 900, 600);

        /**** JPanel for heading ****/
        JPanel header=new JPanel();
        header.setBackground(new Color( 0,0,0,80));
        header.setBounds(0,0,900,50);

        /**** Heading text ****/
        JLabel heading=new JLabel("BILL DETAILS");
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

        /**** button in secondary panel ****/
        JButton btn=new JButton("Show Bill");
        btn.setBounds(150,0,200,50);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        sec.add(btn);

        /**** tertiary panel ****/
        JPanel tert=new JPanel();
        tert.setBackground(new Color( 0,0,0,80));
        tert.setBounds(20,100,450,200);
	    String temp=new String();

	    /**** button for navigating to the last page ****/
        JButton back=new JButton("Back");
        back.setBounds(200,350,100,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        sec.add(back);
	    background.add(tert);

        /**** creating a table ****/
        {
            int c = 0;
            try {
                BufferedReader brTemp = new BufferedReader(new FileReader("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Payment\\bill.txt"));
                String strTemp = new String();

                while ((strTemp = brTemp.readLine()) != null) {
                    if (strTemp.compareTo("") == 0)
                        break;
                    c++;
                }
		    temp=brTemp.readLine();//line for the total amount
            } catch (IOException io) {
                System.out.println("IO EXCEPTION Thrown");
            }

            String[][] arr = new String[c+1][5];//2d array for creating a table............c->number of rows
            String[] colNames = {
                    "Item id", "Item Name", "rate", "Quantity", "total price"
            };/**** array for column names ****/

            JTable bill = new JTable(arr, colNames);//creating a table
            bill.setVisible(false);

            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Payment\\bill.txt"));
                String str;
                int i = 0;
                while ((str = br.readLine()) != null) {
                    if (str.compareTo("") == 0)
                        break;

                    String[] element = str.split(",");
                    for (int k = 0; k < 5; k++)
                    {
                        arr[i][k] = element[k];
                    }
                    i++;
                }
		        arr[i][4]=temp;
                tert.add(new JScrollPane(bill));
                br.close();
            } catch (IOException io) {
                System.out.println("IO Exception Thrown");
            }
            sec.add(tert);
            btn.addActionListener(new ActionListener() {// action listener for "show bill" button

                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btn) {
                        bill.setVisible(true);
                    }
                }
            });
        }

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                j.setVisible(false);
                //j.dispose();
                new Attempt();
                File del=new File("C:\\Users\\gurki\\OneDrive\\Desktop\\Java Project\\src\\Order\\latOrder.txt");
                del.delete();

            }
        } );


	//jbutton for sales
	JButton sales=new JButton("Sales");
	sales.setBounds(200,450,100,50);
        sales.setBackground(Color.BLACK);
        sales.setForeground(Color.white);
        sec.add(sales);
	//background.add(tert);

        sales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sales();
                j.setVisible(false);
            }
        });


        background.add(sec);
        j.setSize(890, 640);
        j.setLayout(null);
        j.setVisible(true);
        background.setVisible(true);
	    j.add(background);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
