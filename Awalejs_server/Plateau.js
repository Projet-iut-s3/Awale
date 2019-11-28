const {Affame, Doitdonner} = require('./Regles');
const JoueurHumain =  require('./JoueurHumain');

class Plateau {

    initialiserRegle() {
        let reg = [];
        reg.push(new Affame());
        reg.push(new Doitdonner());
        return reg;
    }

    constructor(j1, j2){
        if(j1 instanceof JoueurHumain) {
            this._j1 = j1;
            this._j2 = j2;
            this._plateau = [];
            for(let i = 0; i<2; i++) {
                let a = [];
                for(let j = 0; j<5; j++)
                    a.push(4);
                this._plateau.push(a);
            }
            // this.plateau = [[3,4,4,4,4], [1,1,2,4,4]];
        }
        else {
            this._plateau = j1._plateau;
            this._j1 = j1._j1;
            this._j2 = j1._j2;
        }
    }

    coupPossible(i, j){
        let res = this._plateau[i][j]!==0;
        this.initialiserRegle().forEach(regle => {
            res &= regle.appliquerRegle(this, i, j);
        });
        return res;
    }

    victorieux() {
        if(this._j1.score()>=25)
            return this._j1.pseudo();
        else if(this._j2.score()>=25)
            return this._j2.pseudo();
        return 0;
    }

    jouerCase(j, cote) {
        if(this._plateau[cote][j]===0)
            return -1;
        if(this.coupPossible(cote, j)){
            let jcote = this.incrCases(j, cote, this.retirerGraine(j, cote));
            if(jcote[1]!==cote)
                return this.gagnerpoint(jcote[0], jcote[1]);
        }
        return 0;
    }

    getCase(i, j) {
        return this._plateau[i][j];
    }

    retirerGraine(j, cote) {
        let graine = this._plateau[cote][j];
        this._plateau[cote][j] = 0;
        return graine;
    }

    incrGraine(j, cote) {
        this._plateau[cote][j]++;
    }

    incrCases(j, cote, nbcase) {
        if(cote===0) {
            if (j === 0)
                return this.incrCasesAux(0, 1, nbcase);
            else
                return this.incrCasesAux(j - 1, cote, nbcase);
        } else {
            if (j === 4)
                return this.incrCasesAux(4, 0, nbcase);
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
                if(j===4)
                    return this.incrCasesAux(4, 0, nbcase-1);
                else
                    return this.incrCasesAux(j+1, cote, nbcase-1);
            }
        }
        if(cote === 0) {
            if (j === 4)
                return [4, 1];
            return [j+1, 0];
        } else {
            if (j === 0)
                return [0, 0];
            return [j-1, 1];
        }
    }

    gagnerpoint(j, cote) {
        if(this._plateau[cote][j]===2 || this._plateau[cote][j]===3) {
            let point = this.retirerGraine(j, cote);
            if(cote===1) {
                if(j===0)
                    return point + this.gagnerpoint(0, 0);
                return point + this.gagnerpoint(j-1, cote);
            } else {
                if(j===4)
                    return point + this.gagnerpoint(4, 1);
                return point + this.gagnerpoint(j+1, cote);
            }
        }
        return 0;
    }

    getPlateauList() {
        return [this._plateau[0][0],
                this._plateau[0][1],
                this._plateau[0][2],
                this._plateau[0][3],
                this._plateau[0][4],
                this._plateau[1][0],
                this._plateau[1][1],
                this._plateau[1][2],
                this._plateau[1][3],
                this._plateau[1][4]];
    }
}

module.exports = Plateau;