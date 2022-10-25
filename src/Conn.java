import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            ("jdbc:mysql://localhost:3306/university");
            c=DriverManager.getConnection("jdbc:mysql:///university","root","mahadev");
            s=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
