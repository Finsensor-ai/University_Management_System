import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class StudentDetails extends JFrame {
    Choice choice_roll_no;
    JTable table;
    JButton search , print, update,add,cancel;
    StudentDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // DropDown List Label.
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice_roll_no = new Choice();
        choice_roll_no.setBounds(180,20,150,20);
        add(choice_roll_no);

        // get roll no. from backend(mysql);
        try{
            Conn cn = new Conn();
            ResultSet res = cn.s.executeQuery("select * from student");
            while(res.next()){
                choice_roll_no.add(res.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        // create table.

        table = new JTable();

        // Render ALL Details into Table.
        try{
            Conn cn = new Conn();
            ResultSet res = cn.s.executeQuery("select * from student");
           table.setModel(DbUtils.resultSetToTableModel(res));
        }catch(Exception e){
            e.printStackTrace();
        }


        JScrollPane  scroll_pane = new JScrollPane(table);
        scroll_pane.setBounds(0,100,900,600);
        add(scroll_pane);

        // Buttons.
        // search
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        add(search);
        // print button
        print = new JButton("Print");
        print.setBounds(20,70,80,20);
        add(print);
        // add button
        add = new JButton("Add");
        add.setBounds(20,70,80,20);
        add(add);
        // update button
        update = new JButton("Update");
        update.setBounds(20,70,80,20);
        add(update);
        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(20,70,80,20);
        add(cancel);



        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentDetails();
    }
}
