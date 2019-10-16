import java.util.ArrayList;

public class JoueurIA extends Joueur {

    private int profondeur;
    private int cote;

    public JoueurIA(String pseudo, int coté) {
        super(pseudo, coté);
        profondeur = 10;
        cote = 1;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = 2*profondeur;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public int jouer(Plateau plateau) {
        int res = max(simulerCoup(plateau, 1), profondeur);
        int j = 1;
        for(int i = 2; i<6; i++) {
            int resbis = max(simulerCoup(plateau, i), profondeur);
            if(resbis>res)
                j=i;
        }
        return j;
    }

    private int max(Plateau p, int generationRestante){
        if(generationRestante == 0){
            Plateau pl = new Plateau(p);
            int res = pl.jouerCase(1, cote);
            for(int i = 0; i < 5; i++){
                pl = new Plateau(p);
                int resbis = pl.jouerCase(i, cote);
                if(resbis>res)
                    res = resbis;
            }
            if(res==-1)
                return -1000;
            return res;
        }
        return maxScoreDes6(
                max(simulerCoup(p, 1), generationRestante-1),
                max(simulerCoup(p, 2), generationRestante-1),
                max(simulerCoup(p, 3), generationRestante-1),
                max(simulerCoup(p, 4), generationRestante-1),
                max(simulerCoup(p, 5), generationRestante-1),
                max(simulerCoup(p, 6), generationRestante-1));
    }

    private Plateau simulerCoup(Plateau p, int i){
        Plateau plateau = new Plateau(p);
        plateau.jouerCase(i, cote);
        return plateau;
    }


    private int maxScoreDes6(int i1,int i2,int i3,int i4,int i5,int i6){
        return maxScoreDe2(i1, maxScoreDe2(i2 ,maxScoreDe2(i3 ,maxScoreDe2(i4 ,maxScoreDe2(i5, i6)))));
    }

    private int maxScoreDe2(int i, int j){
        if(i>j)
            return i;
        return j;
    }

}
