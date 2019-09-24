public abstract class Joueur {

    private String pseudo;
    private int score;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.score = 0;
    }

    public abstract int jouer();

    public void ajouterPoint(int point) {
        this.score += point;
    }

    public int getScore() {
        return score;
    }

    public String getPseudo() {
        return pseudo;
    }
}
