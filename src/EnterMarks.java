import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class EnterMarks extends JFrame {
    Choice choice_roll_no;
    JComboBox combo_Semester;
    JTextField Input_subject_1,Input_subject_2,Input_subject_3,Input_subject_4,Input_subject_5,Input_marks_1,Input_marks_2,Input_marks_3,Input_marks_4,Input_marks_5;
    EnterMarks(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        // heading
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        // student roll no.
        JLabel roll_Number_label = new JLabel("Select Roll Number");
        roll_Number_label.setBounds(50,70,150,20);
        add(roll_Number_label);

        choice_roll_no = new Choice();
        choice_roll_no.setBounds(200,70,150,20);
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

        // Semester
        JLabel semester_Label = new JLabel("Select Semester");
        semester_Label.setBounds(50,110,150,20);
        add(semester_Label);


        String[] semester={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        combo_Semester = new JComboBox(semester);
        combo_Semester.setBounds(200,110,150,20);
        combo_Semester.setBackground(Color.WHITE);
        add(combo_Semester);

        // enter subject label
        JLabel subject_Label = new JLabel("Enter Subject");
        subject_Label.setBounds(100,150,200,40);
        add(subject_Label);

        // enter marks label
        JLabel enterMarks_Label = new JLabel("Enter Marks");
        enterMarks_Label.setBounds(320,150,200,40);
        add(enterMarks_Label);


        // Subject Input Text Field

        Input_subject_1=new JTextField();
        Input_subject_1.setBounds(50,200,200,20);
        add(Input_subject_1);

        Input_subject_2=new JTextField();
        Input_subject_2.setBounds(50,200,200,20);
        add(Input_subject_2);

        Input_subject_3=new JTextField();
        Input_subject_3.setBounds(50,200,200,20);
        add(Input_subject_3);

        Input_subject_4=new JTextField();
        Input_subject_4.setBounds(50,200,200,20);
        add(Input_subject_4);

        Input_subject_5=new JTextField();
        Input_subject_5.setBounds(50,200,200,20);
        add(Input_subject_5);


        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}
