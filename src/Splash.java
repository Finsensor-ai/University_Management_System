import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // object of thread class.
        t = new Thread(this);
        t.start();  // internally called run method.

        setVisible(true);
        int  helper = 1;
        for(int i=2; i<=600; i+=4,helper+=1){
            setLocation(600-((i+helper)/2), 350 -(i/2));
            setSize(i+3*helper,i+helper/2);
            try{
                Thread.sleep(10);
            }catch (Exception e){}
        }


    }
    // override abstract
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);

            // next Frame open.
        }catch (Exception e){}
    }
    public static void main(String[] args) {
        new Splash();
    }
}
