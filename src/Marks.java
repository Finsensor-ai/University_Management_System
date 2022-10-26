import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    String rollno;
    JButton cancel_button;
    Marks(String rollno){
        this.rollno=rollno;

        setSize(500,600);
        setLocation(500,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        // heading
        JLabel heading = new JLabel("SGN Khalsa PG College");
        heading.setBounds(100,10,500,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);


        // sub heading

        JLabel sub_heading = new JLabel("Result of Examination 2022");
        sub_heading.setBounds(100,50,500,20);
        sub_heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(sub_heading);

        // rollno sub-heading
        JLabel rollno_heading = new JLabel("Roll Number "+rollno);
        rollno_heading.setBounds(60,100,500,20);
        rollno_heading.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(rollno_heading);

        // semester sub-heading
        JLabel semester_heading = new JLabel();
        semester_heading.setBounds(60,130,500,20);
        semester_heading.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(semester_heading);


        // Subject

        JLabel subject_1 = new JLabel();
        subject_1.setBounds(100,200,500,20);
        subject_1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(subject_1);

        JLabel subject_2 = new JLabel();
        subject_2.setBounds(100,230,500,20);
        subject_2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(subject_2);

        JLabel subject_3 = new JLabel();
        subject_3.setBounds(100,260,500,20);
        subject_3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(subject_3);

        JLabel subject_4 = new JLabel();
        subject_4.setBounds(100,290,500,20);
        subject_4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(subject_4);

        JLabel subject_5 = new JLabel();
        subject_5.setBounds(100,320,500,20);
        subject_5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(subject_5);

        // mysql database get

        try{
            Conn cn = new Conn();
            ResultSet res1 = cn.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(res1.next()){
                subject_1.setText(res1.getString("subject1"));
                subject_2.setText(res1.getString("subject2"));
                subject_3.setText(res1.getString("subject3"));
                subject_4.setText(res1.getString("subject4"));
                subject_5.setText(res1.getString("subject5"));
            }
            ResultSet res2 = cn.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(res2.next()) {
                subject_1.setText(subject_1.getText() + "------------"+res2.getString("marks1"));
                subject_2.setText(subject_2.getText() + "------------"+res2.getString("marks2"));
                subject_3.setText(subject_3.getText() + "------------"+res2.getString("marks3"));
                subject_4.setText(subject_4.getText() + "------------"+res2.getString("marks4"));
                subject_5.setText(subject_5.getText() + "------------"+res2.getString("marks5"));

                // semester
                semester_heading.setText("Semester "+res2.getString("semester"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        // cancel button design.
        cancel_button = new JButton("Cancel");
        cancel_button.setBounds(250,500,120,25);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        cancel_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel_button);

        // last statement.
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }
    public static void main(String[] args) {
        new Marks("");
    }
}
