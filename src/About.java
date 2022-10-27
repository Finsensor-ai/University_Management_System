import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){
        setSize(700,600);
        setLocation(400,150);

        getContentPane().setBackground(Color.WHITE);

        // background image add.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);
        // heading label
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70,20,250,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        // creator name
        JLabel creator_name = new JLabel("Developed By: Anish Kumar");
        creator_name.setBounds(70,220,550,30);
        creator_name.setFont(new Font("Tahoma",Font.BOLD,30));
        add(creator_name);

        // roll no creator
        // creator name
        JLabel creator_ROLLNO = new JLabel("Roll Number: 18000108");
        creator_ROLLNO.setBounds(70,280,550,40);
        creator_ROLLNO.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(creator_ROLLNO);

        // creator contact
        JLabel creator_Contact = new JLabel("Contact: anishbishnoi@gmail.com");
        creator_Contact.setBounds(100,340,200,40);
        creator_Contact.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(creator_Contact);

        //last statement
        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
