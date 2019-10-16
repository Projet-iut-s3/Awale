import java.util.Scanner;

public class Jeu {

    private Joueur j1;
    private Joueur j2;
    private Plateau plateau;

    public void deroulement(


    ){

    }

    public static boolean estGagnant(Joueur j){
        return j.getScore()>=25;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nomJ1;
        String nomJ2;


        System.out.println("Entrez un nom de Joueur pour le J1");
        nomJ1 = sc.nextLine();
        Joueur j1 = new JoueurHumain(nomJ1, 1);

        System.out.println("Entrez un nom de Joueur pour le J2");
        nomJ2 = sc.nextLine();
        Joueur j2 = new JoueurHumain(nomJ2, 2);


        Plateau plateau = new Plateau();
        System.out.println(plateau);


        int nbTotalGraines = 48;


        while (!estGagnant(j1) && !estGagnant(j2)) {


            //JOUEUR 1



            System.out.println("\nJ1 choisissez la case à jouer\n");
            int numCase = Integer.parseInt(sc.nextLine());
            while (numCase > 5 || numCase < 0) {

                System.out.println("La case saisie n'est pas valide, veuillez sélectionner une case entre 0 et 5\n");
                numCase = Integer.parseInt(sc.nextLine());
            }

            int val = plateau.jouerCase(numCase, 1);

            while (val < 0) {

                if (val == -1) {
                    System.out.println("Joueur 1, cette case est vide veuillez en sélectionner une contenant des graines.\n");
                }


                numCase = Integer.parseInt(sc.nextLine());

                while (numCase > 5 || numCase < 0) {

                    System.out.println("La case saisie n'est pas valide, veuillez sélectionner une case entre 0 et 5\n");
                    numCase = Integer.parseInt(sc.nextLine());

                }

                val = plateau.jouerCase(numCase, 1);

            }


            j1.ajouterPoint(val);

            System.out.println(plateau);


            nbTotalGraines -= val;


            System.out.println(j1.toString());
            System.out.println(j2.toString());


            if (j1.getScore() >= 25)
                break;


            //JOUEUR 2



            System.out.println("\nJ2 choisissez la case à jouer\n");
            numCase = Integer.parseInt(sc.nextLine());
            while (numCase > 5 || numCase < 0) {

                System.out.println("La case saisie n'est pas valide, veuillez sélectionner une case entre 0 et 5\n");
                numCase = Integer.parseInt(sc.nextLine());
            }

            val = plateau.jouerCase(numCase, 2);

            while (val < 0) {

                if (val == -1) {
                    System.out.println("Joueur 2, cette case est vide veuillez en sélectionner une contenant des graines.\n");
                }


                numCase = Integer.parseInt(sc.nextLine());

                while (numCase > 5 || numCase < 0) {

                    System.out.println("La case saisie n'est pas valide, veuillez sélectionner une case entre 0 et 5\n");
                    numCase = Integer.parseInt(sc.nextLine());

                }

                val = plateau.jouerCase(numCase, 2);

            }


            j2.ajouterPoint(val);


            System.out.println(plateau);


            nbTotalGraines -= val;


            System.out.println(j1.toString());
            System.out.println(j2.toString());
        }


        if (j1.getScore() > j2.getScore())
            System.out.println("Le joueur 1 a gagné.");
        else if (j1.getScore() < j2.getScore())
            System.out.println("Le joueur 2 a gagné.");
        else
            System.out.println("Egalité entre les joueurs");

    }



}