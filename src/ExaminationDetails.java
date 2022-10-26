import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField search;
    JButton submit_button,cancel_button;
    JTable table;
    ExaminationDetails(){

        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        // heading
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);

        // search
        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);

        // Submit Button
        submit_button = new JButton("Result");
        submit_button.setBounds(300,90,120,30);
        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        submit_button.addActionListener(this);
        submit_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit_button);

        // cancel button design.
        cancel_button = new JButton("Cancel");
        cancel_button.setBounds(440,90,120,30);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        cancel_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel_button);

        // Table
        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        JScrollPane scroller_pane = new  JScrollPane(table);
        scroller_pane.setBounds(0,130,1000,310);
        add(scroller_pane);


        // my sql data get for table
        try{
            Conn cn = new Conn();
            ResultSet res = cn.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(res));

        }catch (Exception e){
            e.printStackTrace();
        }

        // mouse Event Listener
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit_button){

        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
