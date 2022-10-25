import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class AddStudent extends JFrame {
    JTextField Input_name,Input_Father_name,Input_Address,Input_Phone,Input_Email,Input_X,Input_XII,Input_Aadhar;
    JLabel roll_Number_Label;

    JDateChooser date_DOB_Chooser;
    Random random = new Random();
    long first_4 = Math.abs((random.nextLong()%9000L)+1000L);
    AddStudent(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        // name label
        JLabel name_Label = new JLabel("Name");
        name_Label.setBounds(50,150,100,30);
        name_Label.setFont(new Font("serif",Font.BOLD,20));
        add(name_Label);


        // name text field.

        Input_name = new JTextField();
        Input_name.setBounds(200,150,150,30);
        add(Input_name);


        // father name label.
        JLabel father_name = new JLabel("Father's Name");
        father_name.setBounds(400,150,200,30);
        father_name.setFont(new Font("serif",Font.BOLD,20));
        add(father_name);

        // name text field.
        Input_Father_name = new JTextField();
        Input_Father_name.setBounds(600,150,150,30);
        add(Input_Father_name);


        // roll number
        JLabel roll_Number = new JLabel("Roll Number");
        roll_Number.setBounds(50,200,200,30);
        roll_Number.setFont(new Font("serif",Font.BOLD,20));
        add(roll_Number);

        // random roll number Generated.
         roll_Number_Label = new JLabel("1800"+first_4);
        roll_Number_Label.setBounds(200,200,200,30);
        roll_Number_Label.setFont(new Font("serif",Font.BOLD,20));
        add(roll_Number_Label);

        // date of birth
        JLabel DOB = new JLabel("Date of Birth");
        DOB.setBounds(400,200,200,30);
        DOB.setFont(new Font("serif",Font.BOLD,20));
        add(DOB);

        date_DOB_Chooser = new JDateChooser();
        date_DOB_Chooser.setBounds(600,200,150,30);
        add(date_DOB_Chooser);


        //  Address
        JLabel address_Label = new JLabel("Address");
        address_Label.setBounds(50,250,200,30);
        address_Label.setFont(new Font("serif",Font.BOLD,20));
        add(address_Label);

        // name text field.
        Input_Address = new JTextField();
        Input_Address.setBounds(200,250,150,30);
        add(Input_Address);

        // Phone
        JLabel phone_Label = new JLabel("Phone");
        phone_Label.setBounds(400,250,200,30);
        phone_Label.setFont(new Font("serif",Font.BOLD,20));
        add(phone_Label);

        // name text field.
        Input_Phone = new JTextField();
        Input_Phone.setBounds(600,250,150,30);
        add(Input_Phone);

        // Email Id

        JLabel email_Label = new JLabel("Email Id");
        email_Label.setBounds(50,300,200,30);
        email_Label.setFont(new Font("serif",Font.BOLD,20));
        add(email_Label);

        // name text field.
        Input_Email = new JTextField();
        Input_Email.setBounds(200,300,150,30);
        add(Input_Email);

        // Class X %
        JLabel X_Label = new JLabel("Class X (%)");
        X_Label.setBounds(400,300,200,30);
        X_Label.setFont(new Font("serif",Font.BOLD,20));
        add(X_Label);

        // name text field.
        Input_X = new JTextField();
        Input_X.setBounds(600,300,150,30);
        add(Input_X);


        // Class xii %
        JLabel XII_Label = new JLabel("Class XII (%)");
        XII_Label.setBounds(50,350,200,30);
        XII_Label.setFont(new Font("serif",Font.BOLD,20));
        add(XII_Label);

        // name text field.
        Input_XII = new JTextField();
        Input_XII.setBounds(200,350,150,30);
        add(Input_XII);


        // Aadhar Number
        JLabel aadhar_Label = new JLabel("Aadhar Number");
        aadhar_Label.setBounds(400,350,200,30);
        aadhar_Label.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar_Label);

        // name text field.
        Input_Aadhar = new JTextField();
        Input_Aadhar.setBounds(600,350,150,30);
        add(Input_Aadhar);

        // Course
        JLabel course_Label = new JLabel("Course");
        course_Label.setBounds(50,400,200,30);
        course_Label.setFont(new Font("serif",Font.BOLD,20));
        add(course_Label);


        //  last statement
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
