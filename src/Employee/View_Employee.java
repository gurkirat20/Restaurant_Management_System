package Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

class View_Employee {
    JFrame f;
    JTable t;

    View_Employee() {
        f = new JFrame("View Employee");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 100));
        panel.setBounds(0, 0, 900, 600);

        DefaultTableModel model = new DefaultTableModel();
        t = new JTable(model);
        t.setBounds(100, 100, 650, 450);
        model.addColumn("eID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("Email");
        model.addColumn("Designation");
        t.getColumnModel().getColumn(1).setPreferredWidth(100);
        t.getColumnModel().getColumn(2).setPreferredWidth(80);
        t.getColumnModel().getColumn(3).setPreferredWidth(150);
        t.getColumnModel().getColumn(4).setPreferredWidth(120);
        t.getColumnModel().getColumn(5).setPreferredWidth(180);
        t.getColumnModel().getColumn(6).setPreferredWidth(120);

        String[] row = new String[7];
        EmployeeList list = new EmployeeList();
        for (int i = 0; i < EmployeeList.employeeList.size(); i++) {
            Employee e = list.getEmployee(i);
            row[0] = Integer.toString(e.getID());
            row[1] = e.getName();
            row[2] = Integer.toString(e.getAge());
            row[3] = e.getAddress();
            row[4] = e.getPhoneNumber();
            row[5] = e.getEmail();
            row[6] = e.getDesignation();
            model.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(t);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        panel.add(scrollPane);

        JButton back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {

               f.setVisible(false);
               new Manage_Employee();

           }

       });

        f.add(panel);
        f.setSize(900, 400);
        f.setLocation(280, 40);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
