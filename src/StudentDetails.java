import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentDetails extends JFrame {
    Choice choice_roll_no;
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

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentDetails();
    }
}
