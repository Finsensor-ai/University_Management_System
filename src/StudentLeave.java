import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {
    Choice choice_roll_no,choice_time;
    JDateChooser date_chooser;
    JButton submit_button,cancel_button;
    StudentLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // heading
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        // DropDown List Label.
        JLabel rollno_Label = new JLabel("Search by Roll Number");
        rollno_Label.setBounds(60,100,200,20);
        rollno_Label.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(rollno_Label);

        choice_roll_no = new Choice();
        choice_roll_no.setBounds(60,130,200,20);
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


        // date leave
        JLabel date_Label = new JLabel("Date");
        date_Label.setBounds(60,180,200,20);
        date_Label.setFont(new Font("serif",Font.PLAIN,18));
        add(date_Label);

        date_chooser = new JDateChooser();
        date_chooser.setBounds(60,210,200,25);
        add(date_chooser);

        // leave date
        JLabel time_Duration = new JLabel("Time Duration");
        time_Duration.setBounds(60,260,200,20);
        time_Duration.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time_Duration);

        choice_time = new Choice();
        choice_time.setBounds(60,290,200,20);
        choice_time.add("Full Day");
        choice_time.add("Half Day");
        add(choice_time);

        // Submit Button
        submit_button = new JButton("Submit");
        submit_button.setBounds(60,350,100,25);
        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        submit_button.addActionListener(this);
        submit_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit_button);

        // cancel button design.
        cancel_button = new JButton("Cancel");
        cancel_button.setBounds(200,350,100,25);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        cancel_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel_button);

        // last statement
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit_button){

            String rollno = choice_roll_no.getSelectedItem();
            String date = ((JTextField) date_chooser.getDateEditor().getUiComponent()).getText();
            String duration = choice_time.getSelectedItem();

            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeave();
    }
}
