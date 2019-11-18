public abstract class Joueur {

    private String pseudo;
    private int cote;
    private int score;

    public Joueur(String pseudo, int cote) {
        this.pseudo = pseudo;
        this.cote = cote;
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

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public String toString(){
        return "Le joueur " + this.pseudo + " a " + this.score + " points.";
    }
}
