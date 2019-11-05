import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class IHMbis extends JFrame implements ActionListener {

    private Plateau plateau = new Plateau();
    private List<ImageIcon> imageIconList = new ArrayList<>();
    private List<List<JButton>> jButtonList = new ArrayList<>();
    private Joueur j1;
    private Joueur j2;
    private JOptionPane jo;
    private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    private JLabel l = new JLabel("........");
    private JLabel scorej1 = new JLabel("........");
    private JLabel scorej2 = new JLabel("........");

    public IHMbis(){
        super("Awale");
        for(int i = 0; i<21; i++)
            imageIconList.add(new ImageIcon("PHOTOGRAINE/"+i+"bille.jpg"));
        for(int i = 0; i<2; i++) {
            List<JButton> list = new ArrayList<>();
            for (int j = 0; j < 6; j++)
                list.add(new JButton(imageIconList.get(plateau.plateau[i][j])));
            jButtonList.add(list);
        }

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

        for(int i = 0; i<2; i++)
            for (int j = 0; j < 6; j++)
                contentPane.add(jButtonList.get(i).get(j));

        contentPane.add(jo);
        contentPane.add(l);
        contentPane.add(scorej1);
        contentPane.add(scorej2);
        for(int i = 0; i<2; i++)
            for (int j = 0; j < 6; j++)
                jButtonList.get(i).get(j).addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectedItem = (JButton) e.getSource();
        int val = 0;
        Joueur joueurquiajoue;
        String joueurquivajouer;
        int cote;
        int coteplateau;
        if (l.getText().equals(j1.getPseudo() + " choisissez une case à jouer")){
            joueurquiajoue = j1;
            joueurquivajouer = j2.getPseudo();
            cote = 0;
            coteplateau = 1;
        }
        else {
            joueurquiajoue = j2;
            joueurquivajouer = j1.getPseudo();
            cote = 1;
            coteplateau = 2;
        }

        if (!jButtonList.get(cote).contains(selectedItem)) {
            JOptionPane.showMessageDialog(frame, joueurquiajoue.getPseudo() + ", cette case ne t'appartient pas n'y touche pas stp");
            return;
        }
        val = plateau.jouerCase(jButtonList.get(cote).indexOf(selectedItem), coteplateau);
        if (val == -1) {
            JOptionPane.showMessageDialog(frame, joueurquiajoue.getPseudo() + ", cette case est vide veuillez en sélectionner une contenant des graines.");
            return;
        }
        joueurquiajoue.ajouterPoint(val);
        if (joueurquiajoue.getScore() >= 25) {
            JOptionPane.showMessageDialog(frame, joueurquiajoue.getPseudo() + " a gagné !!!");
            System.exit(0);
        }
        jo.setMessage(plateau.toString(j1,j2));
        for(int i = 0; i<2; i++)
            for (int j = 0; j < 6; j++)
                jButtonList.get(i).get(j).setIcon(imageIconList.get(plateau.plateau[i][j]));
        l.setText(joueurquivajouer + " choisissez un case à jouer");
        scorej1.setText(j1.getPseudo() + " score : " + j1.getScore());
        scorej2.setText(j2.getPseudo() + " score : " + j2.getScore());
    }

    public static void main(String[] args) {
        IHMbis myWindow = new IHMbis();
        myWindow.setVisible(true);
    }
}
