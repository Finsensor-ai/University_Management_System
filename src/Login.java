import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login(){
        getContentPane().setBackground(Color.WHITE);

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}
