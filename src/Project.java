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

        // Leave Details
        JMenu leave_Details = new JMenu("Leave Details");
        leave_Details.setForeground(Color.RED);
        nav.add(leave_Details);

        // nav bar lists items (menu items).
        JMenuItem faculty_Leave_Details = new JMenuItem("Faculity Leave Details");
        faculty_Leave_Details.setBackground(Color.WHITE);
        leave_Details.add(faculty_Leave_Details);

        JMenuItem student_Leave_Details = new JMenuItem("Student Leave Details");
        student_Leave_Details.setBackground(Color.WHITE);
        leave_Details.add(student_Leave_Details);

        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        nav.add(exam);

        // nav bar lists items (menu items).
        JMenuItem examination_Details = new JMenuItem("Examination Results");
        examination_Details.setBackground(Color.WHITE);
        exam.add(examination_Details);

        JMenuItem enter_marks = new JMenuItem("Enter Marks");
        enter_marks.setBackground(Color.WHITE);
        exam.add(enter_marks);


        // Update information.
        JMenu update_Info = new JMenu("Update Details");
        update_Info.setForeground(Color.RED);
        nav.add(update_Info);

        // nav bar lists items (menu items).
        JMenuItem update_Faculty_Info = new JMenuItem("Update Faculty Details");
        update_Faculty_Info.setBackground(Color.WHITE);
        update_Info.add(update_Faculty_Info);

        JMenuItem update_Student_Info = new JMenuItem("Update Student Details");
        update_Student_Info.setBackground(Color.WHITE);
        update_Info.add(update_Student_Info);


        // Fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        nav.add(fee);

        // nav bar lists items (menu items).
        JMenuItem fee_Structure = new JMenuItem("Fee Structure");
        fee_Structure.setBackground(Color.WHITE);
        fee.add(fee_Structure);

        JMenuItem fee_Form = new JMenuItem("Student Fee Form");
        fee_Form.setBackground(Color.WHITE);
        fee.add(fee_Form);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        nav.add(utility);

        // nav bar lists items (menu items).
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        utility.add(calc);

        // Exit

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        nav.add(exit);

        // nav bar lists items (menu items).
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        exit.add(ex);


        // nav bar
        setJMenuBar(nav);



        // last statement.
        setVisible(true);
    }
    public static void main(String[] args) {
        new Project();
    }
}
