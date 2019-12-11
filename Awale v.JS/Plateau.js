import { Regle, Affame, Doitdonner } from "./Regles.js";
import {JoueurHumain} from "./JoueurHumain.js";
import {nbcasejoueur} from "./IHM.js";

export class Plateau {
    
    plateau;
    static regles = Plateau.initialiserRegle();
    j1;
    j2;

    static initialiserRegle() {
        let reg = [];
        reg.push(new Affame());
        reg.push(new Doitdonner());
        return reg;
    }

    constructor(j1, j2){
        if(j1 instanceof JoueurHumain) {
            this.j1 = j1;
            this.j2 = j2;
            this.plateau = [];
            for(let i = 0; i<2; i++) {
                let a = [];
                for(let j = 0; j<nbcasejoueur; j++)
                    a.push(4);
                this.plateau.push(a);
            }
            // this.plateau = [[3,4,4,4,4], [1,1,2,4,4]];
        }
        else if(j1 instanceof Plateau) {
            this.plateau = j1.plateau;
            this.j1 = j1.j1;
            this.j2 = j1.j2;
        }
    }

    setPlateau(p) {
        this.plateau = p;
    }

    coupPossible(i, j){
        let res = this.plateau[i][j]!==0;
        Plateau.regles.forEach(regle => {
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
        if(this.plateau[cote][j]===0)
            return -1;
        if(this.coupPossible(cote, j)){
            let jcote = this.incrCases(j, cote, this.retirerGraine(j, cote));
            if(jcote[1]!==cote)
                return this.gagnerpoint(jcote[0], jcote[1]);
            return 0;
        }
        return -2;
    }

    getCase(i, j) {
        return this.plateau[i][j];
    }

    retirerGraine(j, cote) {
        let graine = this.plateau[cote][j];
        this.plateau[cote][j] = 0;
        return graine;
    }

    incrGraine(j, cote) {
        this.plateau[cote][j]++;
    }

    incrCases(j, cote, nbcase) {
        if(cote===0) {
            if (j === 0)
                return this.incrCasesAux(0, 1, nbcase);
            else
                return this.incrCasesAux(j - 1, cote, nbcase);
        } else {
            if (j === nbcasejoueur-1)
                return this.incrCasesAux(nbcasejoueur-1, 0, nbcase);
            else
                return this.incrCasesAux(j + 1, cote, nbcase);
        }
    }

    incrCasesAux(j, cote, nbcase) {
        if(nbcase!==0) {
            this.incrGraine(j, cote);
            if (cote === 0) {
                if(j===0)
                    return this.incrCasesAux(0, 1, nbcase-1);
                else
                    return this.incrCasesAux(j-1, cote, nbcase-1);
            } else {
                if(j===nbcasejoueur-1)
                    return this.incrCasesAux(nbcasejoueur-1, 0, nbcase-1);
                else
                    return this.incrCasesAux(j+1, cote, nbcase-1);
            }
        }
        if(cote === 0) {
            if (j === nbcasejoueur-1)
                return [nbcasejoueur-1, 1];
            return [j+1, 0];
        } else {
            if (j === 0)
                return [0, 0];
            return [j-1, 1];
        }
    }

    gagnerpoint(j, cote) {
        if(this.plateau[cote][j]===2 || this.plateau[cote][j]===3) {
            let point = this.retirerGraine(j, cote);
            if(cote===1) {
                if(j===0)
                    return point + this.gagnerpoint(0, 0);
                return point + this.gagnerpoint(j-1, cote);
            } else {
                if(j===nbcasejoueur-1)
                    return point + this.gagnerpoint(nbcasejoueur-1, 1);
                return point + this.gagnerpoint(j+1, cote);
            }
        }
        return 0;
    }
}