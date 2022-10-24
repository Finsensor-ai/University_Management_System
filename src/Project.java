import javax.swing.*;
import java.awt.*;

public class Project extends JFrame {
    Project(){
        setSize(1540,850);

        // background image add.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // nav bar (menu bar)
        JMenuBar nav = new JMenuBar();

        // new information
        JMenu information = new JMenu("Information");
        information.setForeground(Color.BLUE);
        nav.add(information);

        // nav bar lists items (menu items).
        JMenuItem faculty_Info = new JMenuItem("Faculity Information");
        faculty_Info.setBackground(Color.WHITE);
        information.add(faculty_Info);

        JMenuItem student_Info = new JMenuItem("Student Information");
        student_Info.setBackground(Color.WHITE);
        information.add(student_Info);

        // Details
        JMenu view_details = new JMenu("View Details");
        view_details.setForeground(Color.RED);
        nav.add(view_details);

        // nav bar lists items (menu items).
        JMenuItem faculty_Details = new JMenuItem("View Faculity Details");
        faculty_Details.setBackground(Color.WHITE);
        view_details.add(faculty_Details);

        JMenuItem student_Details = new JMenuItem("View Student Details");
        student_Details.setBackground(Color.WHITE);
        view_details.add(student_Details);

        // Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        nav.add(leave);

        // nav bar lists items (menu items).
        JMenuItem faculty_Leave = new JMenuItem("Faculity Leave");
        faculty_Leave.setBackground(Color.WHITE);
        leave.add(faculty_Leave);

        JMenuItem student_Leave = new JMenuItem("Student Leave");
        student_Leave.setBackground(Color.WHITE);
        leave.add(student_Leave);


        // nav bar
        setJMenuBar(nav);



        // last statement.
        setVisible(true);
    }
    public static void main(String[] args) {
        new Project();
    }
}
