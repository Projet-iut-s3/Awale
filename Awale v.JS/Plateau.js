import { Regle, Affame, Doitdonner } from "./Regles";

export class Plateau {
    
    plateau;
    static regles = () => {
        reg = new Array;
        reg.push(new Affame());
        reg.push(new Doitdonner());
        return reg;
    };
    j1;
    j2;

    constructor(j1, j2){
        this.plateau = [[]];
        this.j1 = j1;
        this.j2 = j2;
    }

    couoPossible(i, j){
        res = this.plateau[i][j]!=0;
        this.regles.forEach(regle => {
            res &= regle.appliquerRegle(this, i, j);
        });
        return res;
    }

    victorieux() {
        if(this.j1.score()>=25)
            return this.j1.pseudo();
        else if(this.j2.score()>=25)
            return this.j2.pseudo();
        return 0;
    }

    jouerCase(j, cote) {
        
    }

}