public class Plateau {

    int[][] plateau;
    Joueur j1 = new JoueurHumain("J1", 1);
    Joueur j2 = new JoueurHumain("J2", 2);


    public Plateau() {
        this.plateau = new int[2][6];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 6; j++){
                plateau[i][j] = 4;
            }
        }
    }


    public Plateau(Plateau other) {
        this.plateau = other.plateau;
        this.j1 = other.j1;
        this.j2 = other.j2;
    }

    public int getnbGraines(int i, int j){
        return this.plateau[i][j];
    }


    public void ajouterGraine(int i, int j){
        plateau[i][j]++;
    }


    public void enleverToutesGraines(int i, int j){
        plateau[i][j] = 0;
    }




    public int jouerCase(int j, int coté) {

        if (coté == 1) {

            int nbGraine = getnbGraines(0, j);

            if (getnbGraines(0, j) > 0) {

                if (coupPossible(0, j)) {

                    enleverToutesGraines(0, j);

                    for (int i = j-1; i >= 0; i--){

                        if (nbGraine != 0){
                            ajouterGraine(0, i);
                            nbGraine--;
                        }
                    }
                    while(nbGraine != 0){

                        for (int k = 0; k < 6; k++){

                            if (nbGraine != 0){
                                ajouterGraine(1, k);
                                nbGraine--;
                                if (nbGraine == 0){
                                    return gagnerPoints(1, k);
                                }
                            }
                        }
                        if (nbGraine != 0)
                        {
                            for (int i = 5; i > 0; i--)
                            {
                                if (nbGraine != 0 && i != j)
                                {
                                    ajouterGraine(0, i--);
                                    nbGraine--;
                                }
                            }
                        }
                    }
                }
            } else return -1;
        }
        else{
            int nbGraine = getnbGraines(1, j);

            if (getnbGraines(1, j) > 0) {

                if (coupPossible(1, j)) {

                    enleverToutesGraines(1, j);

                    for (int i = j+1; i < 6; i++){

                        if (nbGraine != 0){
                            ajouterGraine(1, i);
                            nbGraine--;
                        }
                    }
                    while(nbGraine != 0){

                        for (int k = 5; k >= 0; k--){

                            if (nbGraine != 0){
                                ajouterGraine(0, k);
                                nbGraine--;
                                if (nbGraine == 0){
                                    return gagnerPoints(0, k);
                                }
                            }
                        }
                        if (nbGraine != 0){
                            for (int i = 0; i < 6; i++){
                                if (nbGraine != 0 && i != j){
                                    ajouterGraine(1, i);
                                    nbGraine--;
                                }
                            }
                        }
                    }
                }
            } else return -1;

        }
        return 0;
    }





    public boolean coupPossible(int i, int j){
        return true;
    }






    public int gagnerPoints(int i, int numcase){
        int res = 0;

        // Joueur 1 fini sur joueur 2 et peut gagner des points
        if(i == 1){
            for(int j = numcase; j > 0; j--){
                if(plateau[1][j] == 3 || plateau[1][j] == 2){
                    res += plateau[1][j];
                    enleverToutesGraines(1,j);
                }
                else break;
            }
        }
        else{
            for(int j = numcase; j < 6; j++){
                if(plateau[0][j] == 3 || plateau[0][j] == 2){
                    res += plateau[0][j];
                    enleverToutesGraines(0,j);
                }
                else break;
            }
        }

        return res;
    }





    public String toString(){
        String res = "Plateau :\n" +
                "-0-1-2-3-4-5-   <-- J1\n|";

        for(int j = 0; j < 6; j++){
            int i = 0;
            res += plateau[i][j] + "|";
        }
        res +="\n|";
        for(int j = 0; j < 6; j++){
            int i = 1;
            res += plateau[i][j] + "|";
        }
        return res + "\n-0-1-2-3-4-5-   <-- J2";
    }
}