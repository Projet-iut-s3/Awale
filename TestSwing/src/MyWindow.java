import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame implements ActionListener {

    public MyWindow(){
        super("Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,400));
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new GridLayout(2, 5, 5, 5));
        JButton b1 = new JButton("1");
        b1.addActionListener(this);
        contentPane.add(b1);
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("3"));
        contentPane.add(new JButton("4"));
        contentPane.add(new JButton("5"));
        contentPane.add(new JButton("1"));
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("3"));
        contentPane.add(new JButton("4"));
        contentPane.add(new JButton("5"));


    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("boutton cliqué");
    }

    public static void main(String[] args) {
        MyWindow myWindow=new MyWindow();
        myWindow.setVisible(true);
    }



}

