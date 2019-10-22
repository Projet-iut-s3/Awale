import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    public MyWindow(){
        super("Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,400));
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("Click ici"));
        contentPane.add(new JButton("Click ici 2"));
        contentPane.add(new JTextArea("Texte"));

    }

    public static void main(String[] args) {
        MyWindow myWindow=new MyWindow();
        //ImageIcon icone = new ImageIcon("grapefruit.jpg");
        //JLabel image = new JLabel(icone);
        //myWindow.add(image);
        myWindow.setVisible(true);
    }

}

