public class Case {

    private int nbGraines;

    public int getNbGraines() {
        return nbGraines;
    }

    public void ajouterGraines(){
        nbGraines++;
    }

    public void enleverToutesGraines(){
        nbGraines = 0;
    }
}
