public abstract class Joueur {

    private String pseudo;
    private int coté;
    private int score;

    public Joueur(String pseudo, int coté) {
        this.pseudo = pseudo;
        this.coté = coté;
        this.score = 0;
    }

    public abstract int jouer(Plateau plateau);


    public void ajouterPoint(int point) {
        this.score += point;
    }

    public int getScore() {
        return score;
    }

    public String getPseudo() {
        return pseudo;
    }


    public String toString(){
        return "Le joueur " + this.pseudo + " a " + this.score + " points.";
    }
}
