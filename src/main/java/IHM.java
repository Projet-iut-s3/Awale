import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;

public class IHM extends JFrame implements ActionListener {


    private Plateau plateau = new Plateau();
    private JButton b0 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][0]+"bille.jpg"));
    private JButton b1 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][1]+"bille.jpg"));
    private JButton b2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][2]+"bille.jpg"));
    private JButton b3 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][3]+"bille.jpg"));
    private JButton b4 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][4]+"bille.jpg"));
    private JButton b5 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][5]+"bille.jpg"));
    private JButton b0j2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][0]+"bille.jpg"));
    private JButton b1j2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][1]+"bille.jpg"));
    private JButton b2j2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][2]+"bille.jpg"));
    private JButton b3j2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][3]+"bille.jpg"));
    private JButton b4j2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][4]+"bille.jpg"));
    private JButton b5j2 = new JButton(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][5]+"bille.jpg"));
    private Joueur j1;
    private Joueur j2;
    private JOptionPane jo;
    private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    private JLabel l = new JLabel("........");
    private JLabel scorej1 = new JLabel("........");
    private JLabel scorej2 = new JLabel("........");

    public IHM() {
        super("Awale");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 400));
        this.setLocationRelativeTo(null);



        JPanel contentPane = (JPanel) this.getContentPane();

        String nom = JOptionPane.showInputDialog("Enter le nom du Joueur 1");
        j1 = new JoueurHumain(nom, 1);

        String nom2 = JOptionPane.showInputDialog("Enter le nom du Joueur 2");
        j2 = new JoueurHumain(nom2, 2);
        jo= new JOptionPane(plateau.toString(j1,j2));

        contentPane.setLayout(new GridLayout(3, 8));

        contentPane.add(b0);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(b4);
        contentPane.add(b5);
        contentPane.add(b0j2);
        contentPane.add(b1j2);
        contentPane.add(b2j2);
        contentPane.add(b3j2);
        contentPane.add(b4j2);
        contentPane.add(b5j2);

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
        b0j2.addActionListener(this);
        b1j2.addActionListener(this);
        b2j2.addActionListener(this);
        b3j2.addActionListener(this);
        b4j2.addActionListener(this);
        b5j2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        JButton selectedItem = (JButton) event.getSource();
        int val = 0;
        if (l.getText().equals(j1.getPseudo() + " choisissez une case à jouer")) {

            if (selectedItem == b0j2||selectedItem == b1j2||selectedItem == b2j2||selectedItem == b3j2||selectedItem == b4j2||selectedItem == b5j2) {
                JOptionPane.showMessageDialog(frame, j1.getPseudo() + ", cette case ne t'appartient pas n'y touche pas stp");
                return;
            }

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
            if (j1.getScore() >= 25) {
                JOptionPane.showMessageDialog(frame, j1.getPseudo() + " a gagné !!!");
                System.exit(0);
            }
            if (j2.getScore() >= 25) {
                JOptionPane.showMessageDialog(frame, j2.getPseudo() + " a gagné !!!");
                System.exit(0);
            }


            jo.setMessage(plateau.toString(j1,j2));
            b0.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][0]+"bille.jpg"));
            b1.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][1]+"bille.jpg"));
            b2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][2]+"bille.jpg"));
            b3.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][3]+"bille.jpg"));
            b4.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][4]+"bille.jpg"));
            b5.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][5]+"bille.jpg"));
            b0j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][0]+"bille.jpg"));
            b1j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][1]+"bille.jpg"));
            b2j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][2]+"bille.jpg"));
            b3j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][3]+"bille.jpg"));
            b4j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][4]+"bille.jpg"));
            b5j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][5]+"bille.jpg"));

            l.setText(j2.getPseudo() + " choisissez un case à jouer");
            scorej1.setText(j1.getPseudo() + " score : " + j1.getScore());
            scorej2.setText(j2.getPseudo() + " score : " + j2.getScore());




        } else {

            if (selectedItem == b0||selectedItem == b1||selectedItem == b2||selectedItem == b3||selectedItem == b4||selectedItem == b5) {
                JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case ne t'appartient pas n'y touche pas stp");
                return;
            }

            if (selectedItem == b0j2) {
                val = plateau.jouerCase(0, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b1j2) {
                val = plateau.jouerCase(1, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b2j2) {
                val = plateau.jouerCase(2, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b3j2) {
                val = plateau.jouerCase(3, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b4j2) {
                val = plateau.jouerCase(4, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (selectedItem == b5j2) {
                val = plateau.jouerCase(5, 2);
                if (val == -1) {
                    JOptionPane.showMessageDialog(frame, j2.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
                    return;
                }
            }
            if (val > 0) j2.ajouterPoint(val);
            if (j1.getScore() >= 25) {
                JOptionPane.showMessageDialog(frame, j1.getPseudo() + " a gagné !!!");
                System.exit(0);
            }
            if (j2.getScore() >= 25) {
                JOptionPane.showMessageDialog(frame, j2.getPseudo() + " a gagné !!!");
                System.exit(0);
            }
            jo.setMessage(plateau.toString(j1,j2));
            b0.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][0]+"bille.jpg"));
            b1.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][1]+"bille.jpg"));
            b2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][2]+"bille.jpg"));
            b3.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][3]+"bille.jpg"));
            b4.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][4]+"bille.jpg"));
            b5.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[0][5]+"bille.jpg"));
            b0j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][0]+"bille.jpg"));
            b1j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][1]+"bille.jpg"));
            b2j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][2]+"bille.jpg"));
            b3j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][3]+"bille.jpg"));
            b4j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][4]+"bille.jpg"));
            b5j2.setIcon(new ImageIcon("PHOTOGRAINE/"+plateau.plateau[1][5]+"bille.jpg"));

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




