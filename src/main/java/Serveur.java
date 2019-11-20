import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {




    public static void main(String[] args) throws IOException {
        Plateau plateau1=new Plateau();
        ServerSocket ss=new ServerSocket(4999);
        System.out.println("Attente d'un client \n");
        Socket s=ss.accept();
        System.out.println("client connecté \n");
        Scanner sc = new Scanner(System.in);

        DataInputStream in= new DataInputStream(s.getInputStream());
        String nomJ1=in.readUTF();
        System.out.println("nomJ1="+nomJ1);
        DataOutputStream out= new DataOutputStream(s.getOutputStream());
        System.out.println("Veuillez saisir le nom de J2 \n");
        String nomj2=sc.nextLine();
        out.writeUTF(nomj2);
        System.out.println(plateau1.toString());
        out.writeUTF(plateau1.toString());

        Joueur j1=new JoueurHumain("yassine",1);
        Joueur j2=new JoueurHumain("sa",2);

        plateau1.jouerCase(1,1);
        System.out.println(plateau1.toString());
        out.writeUTF(plateau1.toString());









//        while (j1.getScore()<25 && j2.getScore()<25) {
//            //JOUEUR 1
//            System.out.println("\nJ1 choisi une case à jouer\n");
//            int numCase = Integer.parseInt(sc.nextLine());
//            int numCase1=Integer.parseInt(in.readUTF());
//            while (numCase > 5 || numCase < 0) {
//
//                System.out.println("La case saisie n'est pas valide, veuillez sélectionner une case entre 0 et 5\n");
//                numCase = Integer.parseInt(sc.nextLine());
//            }
//
//            int val = plateau1.jouerCase(numCase, 1);
//
//            while (val < 0) {
//
//                if (val == -1) {
//                    System.out.println("Joueur 1, cette case est vide veuillez en sélectionner une contenant des graines.\n");
//                }
//
//
//                numCase = Integer.parseInt(sc.nextLine());
//
//                while (numCase > 5 || numCase < 0) {
//
//                    System.out.println("La case saisie n'est pas valide, veuillez sélectionner une case entre 0 et 5\n");
//                    numCase = Integer.parseInt(sc.nextLine());
//
//                }
//
//                val = plateau.jouerCase(numCase, 1);
//
//            }
//
//
//            j1.ajouterPoint(val);
//
//            System.out.println(plateau);
//
//
//            nbTotalGraines -= val;
//
//
//            System.out.println(j1.toString());
//            System.out.println(j2.toString());
//
//
//            if (j1.getScore() >= 25)
//                break;
//
//
//
//
//
//
//

    }
}
