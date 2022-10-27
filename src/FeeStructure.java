import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {
    FeeStructure(){

        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);


        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        // table object
        JTable table  = new JTable();


        // my sql data

        try{
            Conn cn = new Conn();
            ResultSet res = cn.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(res));

        }catch (Exception e){
            e.printStackTrace();
        }


        // table scroll bar
        JScrollPane scroll_pane = new JScrollPane(table);
        scroll_pane.setBounds(0,60,1000,700);
        add(scroll_pane);



        // last statement
        setVisible(true);

    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
