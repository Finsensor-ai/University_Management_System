import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class TeacherDetails extends JFrame implements ActionListener {
    Choice employee_ID;
    JTable table;
    JButton search , print, update,add,cancel;
    TeacherDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // DropDown List Label.
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        employee_ID = new Choice();
        employee_ID.setBounds(180,20,150,20);
        add(employee_ID);

        // get roll no. from backend(mysql);
        try{
            Conn cn = new Conn();
            ResultSet res = cn.s.executeQuery("select * from teacher");
            while(res.next()){
                employee_ID.add(res.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        // create table.

        table = new JTable();

        // Render ALL Details into Table.
        try{
            Conn cn = new Conn();
            ResultSet res = cn.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(res));
        }catch(Exception e){
            e.printStackTrace();
        }


        JScrollPane  scroll_pane = new JScrollPane(table);
        scroll_pane.setBounds(0,100,900,600);
        add(scroll_pane);

        // Buttons.
        // search
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        // print button
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        // add button
        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);
        // update button
        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==search){

            String query = "select * from teacher where empId ='"+employee_ID.getSelectedItem()+"'";
            try{
                Conn cn = new Conn();
                ResultSet res = cn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(res));
            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(e.getSource()==print){
            try{
                table.print();
            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(e.getSource()==add){
            setVisible(false);
            new AddTeacher();
        }else if(e.getSource()==update){
            setVisible(false);
            // new UpdateTeacher();
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherDetails();
    }
}
