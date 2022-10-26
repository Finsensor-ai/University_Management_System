import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateStudent extends JFrame implements ActionListener {
    JTextField Input_Course,Input_Address,Input_Phone,Input_Email,Input_Branch;
    JLabel roll_Number_Label;
    JButton submit_button,cancel_button;
    Choice choice_roll_no;
    UpdateStudent(){
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);

        // student roll no.
        JLabel roll_Number_label = new JLabel("Select Roll Number");
        roll_Number_label.setBounds(50,100,200,20);
        roll_Number_label.setFont(new Font("Serif",Font.PLAIN,20));
        add(roll_Number_label);

        choice_roll_no = new Choice();
        choice_roll_no.setBounds(250,100,200,20);
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


        // name label
        JLabel name_Label = new JLabel("Name");
        name_Label.setBounds(50,150,100,30);
        name_Label.setFont(new Font("serif",Font.BOLD,20));
        add(name_Label);


        // name text field.

       JLabel Input_name = new JLabel();
        Input_name.setBounds(200,150,150,30);
        Input_name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Input_name);


        // father name label.
        JLabel father_name = new JLabel("Father's Name");
        father_name.setBounds(400,150,200,30);
        father_name.setFont(new Font("serif",Font.BOLD,20));
        add(father_name);

        // name text field.
        JLabel Input_Father_name = new JLabel();
        Input_Father_name.setBounds(600,150,150,30);
        Input_Father_name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Input_Father_name);


        // roll number
        JLabel roll_Number = new JLabel("Roll Number");
        roll_Number.setBounds(50,200,200,30);
        roll_Number.setFont(new Font("serif",Font.BOLD,20));
        add(roll_Number);

        // random roll number Generated.
       JLabel roll_Number_Label = new JLabel();
        roll_Number_Label.setBounds(200,200,200,30);
        roll_Number_Label.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(roll_Number_Label);

        // date of birth
        JLabel DOB = new JLabel("Date of Birth");
        DOB.setBounds(400,200,200,30);
        DOB.setFont(new Font("serif",Font.BOLD,20));
        add(DOB);

        JLabel date_DOB_Chooser = new JLabel();
        date_DOB_Chooser.setBounds(600,200,150,30);
        date_DOB_Chooser.setFont(new Font("Tahoma",Font.PLAIN,18));
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
        JLabel Input_X = new JLabel();
        Input_X.setBounds(600,300,150,30);
        Input_X.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Input_X);


        // Class xii %
        JLabel XII_Label = new JLabel("Class XII (%)");
        XII_Label.setBounds(50,350,200,30);
        XII_Label.setFont(new Font("serif",Font.BOLD,20));
        add(XII_Label);

        // name text field.
        JLabel Input_XII = new JLabel();
        Input_XII.setBounds(200,350,150,30);
        Input_XII.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Input_XII);


        // Aadhar Number
        JLabel aadhar_Label = new JLabel("Aadhar Number");
        aadhar_Label.setBounds(400,350,200,30);
        aadhar_Label.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar_Label);

        // name text field.
        JLabel Input_Aadhar = new JLabel();
        Input_Aadhar.setBounds(600,350,150,30);
        Input_Aadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Input_Aadhar);

        // Course
        JLabel course_Label = new JLabel("Course");
        course_Label.setBounds(50,400,200,30);
        course_Label.setFont(new Font("serif",Font.BOLD,20));
        add(course_Label);


        // drop down list.

        Input_Course = new JTextField();
        Input_Course.setBounds(200,400,150,30);
        add(Input_Course);


        // Branch
        JLabel Branch_Label = new JLabel("Branch");
        Branch_Label.setBounds(400,400,200,30);
        Branch_Label.setFont(new Font("serif",Font.BOLD,20));
        add(Branch_Label);


        // drop down list.

        Input_Branch = new JTextField();
        Input_Branch.setBounds(600,400,150,30);
        add(Input_Branch);

        // mysql data fetch

        try{
            Conn cn = new Conn();
            String query = "select * from student where rollno ='"+choice_roll_no.getSelectedItem()+"'";
            ResultSet res = cn.s.executeQuery(query);
            while(res.next()){
                Input_name.setText(res.getString("name"));
                Input_Father_name.setText(res.getString("fname"));
                date_DOB_Chooser.setText(res.getString("dob"));
                Input_Address.setText(res.getString("address"));
                Input_Phone.setText(res.getString("phone"));
                Input_Email.setText(res.getString("email"));
                Input_X.setText(res.getString("class_x"));
                Input_XII.setText(res.getString("class_xii"));
                Input_Aadhar.setText(res.getString("aadhar"));
                roll_Number_Label.setText(res.getString("rollno"));
                Input_Course.setText(res.getString("course"));
                Input_Branch.setText(res.getString("branch"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }


        // Submit Button
        submit_button = new JButton("Update");
        submit_button.setBounds(250,500,120,30);
        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        submit_button.addActionListener(this);
        submit_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit_button);

        // cancel button design.
        cancel_button = new JButton("Cancel");
        cancel_button.setBounds(450,500,120,30);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        cancel_button.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel_button);


        //  last statement
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
//        if(e.getSource()==submit_button){
//            String name = Input_name.getText();
//            String fname = Input_Father_name.getText();
//            String rollno= roll_Number_Label.getText();
//            String dob = ((JTextField) date_DOB_Chooser.getDateEditor().getUiComponent()).getText();
//            String address = Input_Address.getText();
//            String phone = Input_Phone.getText();
//            String email= Input_Email.getText();
//            String x = Input_X.getText();
//            String xii = Input_XII.getText();
//            String aadhar = Input_name.getText();
//            String course = (String) Combo_Box_course.getSelectedItem();
//            String branch = (String) Combo_Box_Branch.getSelectedItem();
//            try{
//                String query = "insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
//                Conn con = new Conn();
//                con.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
//                setVisible(false);
//            }catch (Exception error){
//                error.printStackTrace();
//            }
//        }else{
//            setVisible(false);
//        }
    }
    public static void main(String[] args) {
        new UpdateStudent();
    }
}
