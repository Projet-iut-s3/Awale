public class Jeu {

    private Joueur j1;
    private Joueur j2;
    private Plateau plateau;

    public void deroulement(){

    }

    public boolean estGagnant(Joueur j){
        return j.getScore()>=25;
    }

}
