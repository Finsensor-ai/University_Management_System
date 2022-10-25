import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AddStudent extends JFrame {
    JTextField Input_name,Input_Father_name;
    JLabel roll_Number_Label;
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


        // father name.

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


        //  last statement
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
