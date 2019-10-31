import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHM extends JFrame implements ActionListener {


    private Plateau plateau = new Plateau();
    private JButton b0 = new JButton("Case n°0");
    private JButton b1 = new JButton("Case n°1");
    private JButton b2 = new JButton("Case n°2");
    private JButton b3 = new JButton("Case n°3");
    private JButton b4 = new JButton("Case n°4");
    private JButton b5 = new JButton("Case n°5");
    private JOptionPane jo = new JOptionPane(plateau.toString());
    private Joueur j1;
    private Joueur j2;
    private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    private JLabel l = new JLabel("........");
    private JLabel scorej1 = new JLabel("........");
    private JLabel scorej2 = new JLabel("........");

    public IHM() {
        super("Awale");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600, 400));
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();

        String nom = JOptionPane.showInputDialog("Enter le nom du Joueur 1");
        j1 = new JoueurHumain(nom, 1);

        String nom2 = JOptionPane.showInputDialog("Enter le nom du Joueur 2");
        j2 = new JoueurHumain(nom2, 2);


        contentPane.setLayout(new GridLayout(2, 10, 5, 5));


        contentPane.add(b0);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(b4);
        contentPane.add(b5);
        contentPane.add(jo);
        contentPane.add(l);
        contentPane.add(scorej1);
        contentPane.add(scorej2);

        scorej1.setText(j1.getPseudo() + " score : " + j1.getScore());
        scorej2.setText(j2.getPseudo() + " score : " + j2.getScore());
        l.setText(j1.getPseudo() + " choisissez une case à jouer");

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        JButton selectedItem = (JButton) event.getSource();
        int val = 0;
        if (l.getText().equals(j1.getPseudo() + " choisissez une case à jouer")) {
            if (selectedItem == b0) {
                val = plateau.jouerCase(0, 1);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b1) {
                val = plateau.jouerCase(1, 1);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b2) {
                val = plateau.jouerCase(2, 1);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b3) {
                val = plateau.jouerCase(3, 1);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b4) {
                val = plateau.jouerCase(4, 1);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b5) {
                val = plateau.jouerCase(5, 1);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (val > 0) j1.ajouterPoint(val);
            if (j1.getScore() >= 25) JOptionPane.showMessageDialog(frame, j1.getPseudo() + " a gagné !!!");
            if (j2.getScore() >= 25) JOptionPane.showMessageDialog(frame, j2.getPseudo() + " a gagné !!!");

            jo.setMessage(plateau.toString());
            l.setText(j2.getPseudo() + " choisissez un case à jouer");
            scorej1.setText(j1.getPseudo() + " score : " + j1.getScore());
            scorej2.setText(j2.getPseudo() + " score : " + j2.getScore());

        } else {
            if (selectedItem == b0) {
                val = plateau.jouerCase(0, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b1) {
                val = plateau.jouerCase(1, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b2) {
                val = plateau.jouerCase(2, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b3) {
                val = plateau.jouerCase(3, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b4) {
                val = plateau.jouerCase(4, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b5) {
                val = plateau.jouerCase(5, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (val > 0) j2.ajouterPoint(val);
            if (j1.getScore() >= 25) JOptionPane.showMessageDialog(frame, j1.getPseudo() + " a gagné !!!");
            if (j2.getScore() >= 25) JOptionPane.showMessageDialog(frame, j2.getPseudo() + " a gagné !!!");
            jo.setMessage(plateau.toString());
            l.setText(j1.getPseudo() + " choisissez une case à jouer");
            scorej1.setText(j1.getPseudo() + " score : " + j1.getScore());
            scorej2.setText(j2.getPseudo() + " score : " + j2.getScore());
        }

    }

    public static void main(String[] args) {
        IHM myWindow = new IHM();
        myWindow.setVisible(true);
    }

}




