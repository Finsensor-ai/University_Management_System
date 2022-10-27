import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame {
    Choice choice_roll_no;
    JComboBox Combo_Box_course,Combo_Box_Branch,combo_Semester;
 StudentFeeForm(){
     setSize(900,500);
     setLocation(300,100);
     setLayout(null);
     // background image add.
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
     Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(400,50,500,300);
     add(image);


     // student
     // student roll no.
     JLabel roll_Number_label = new JLabel("Select Roll No");
     roll_Number_label.setBounds(40,60,150,20);
     roll_Number_label.setFont(new Font("Tahoma",Font.BOLD,16));
     add(roll_Number_label);

     choice_roll_no = new Choice();
     choice_roll_no.setBounds(200,60,150,20);
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
     name_Label.setBounds(40,100,150,20);
     name_Label.setFont(new Font("Tahoma",Font.BOLD,16));
     add(name_Label);


     // name text field.

     JLabel Input_name = new JLabel();
     Input_name.setBounds(200,100,150,20);
     Input_name.setFont(new Font("Tahoma",Font.PLAIN,16));
     add(Input_name);


     // father name label.
     JLabel father_name = new JLabel("Father's Name");
     father_name.setBounds(40,140,150,20);
     father_name.setFont(new Font("Tahoma",Font.BOLD,16));
     add(father_name);

     // name text field.
     JLabel Input_Father_name = new JLabel();
     Input_Father_name.setBounds(200,140,150,20);
     Input_Father_name.setFont(new Font("Tahoma",Font.PLAIN,16));
     add(Input_Father_name);


     // mysql data fetch

     try{
         Conn cn = new Conn();
         String query = "select * from student where rollno ='"+choice_roll_no.getSelectedItem()+"'";
         ResultSet res = cn.s.executeQuery(query);
         while(res.next()){
             Input_name.setText(res.getString("name"));
             Input_Father_name.setText(res.getString("fname"));


         }
     }catch(Exception e){
         e.printStackTrace();
     }

     // event lister on Items List. (Drop Down Menu).
     choice_roll_no.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
             try{
                 Conn cn = new Conn();
                 String query = "select * from student where rollno ='"+choice_roll_no.getSelectedItem()+"'";
                 ResultSet res = cn.s.executeQuery(query);
                 while(res.next()){
                     Input_name.setText(res.getString("name"));
                     Input_Father_name.setText(res.getString("fname"));
                 }
             }catch(Exception error){
                 error.printStackTrace();
             }
         }
     });

     // Course
     JLabel course_Label = new JLabel("Course");
     course_Label.setBounds(40,180,150,20);
     course_Label.setFont(new Font("Tahoma",Font.BOLD,16));
     add(course_Label);


     // drop down list.

     String course[] = {"BCA","MCA","B.Tech","M.Tech","Bsc","MSC","MBA","MCom","MA","BA"};
     Combo_Box_course = new JComboBox(course);
     Combo_Box_course.setBounds(200,180,150,20);
     Combo_Box_course.setBackground(Color.WHITE);
     add(Combo_Box_course);


     // Branch
     JLabel Branch_Label = new JLabel("Branch");
     Branch_Label.setBounds(40,220,150,20);
     Branch_Label.setFont(new Font("Tahoma",Font.BOLD,16));
     add(Branch_Label);


     // drop down list.

     String branch[] = {"Computer Science","Electronics","Mechanical","Civil","IT","MSC","MBA","MCom","MA","BA"};
     Combo_Box_Branch = new JComboBox(branch);
     Combo_Box_Branch.setBounds(200,220,150,20);
     Combo_Box_Branch.setBackground(Color.WHITE);
     add(Combo_Box_Branch);

     // Semester
     JLabel semester_Label = new JLabel("Semester");
     semester_Label.setBounds(40,260,150,20);
     semester_Label.setFont(new Font("Tahoma",Font.BOLD,16));
     add(semester_Label);


     String[] semester={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
     combo_Semester = new JComboBox(semester);
     combo_Semester.setBounds(200,260,150,20);
     combo_Semester.setBackground(Color.WHITE);
     add(combo_Semester);



     // last statement
     setVisible(true);
 }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
