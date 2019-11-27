export class Joueur {

    pseudo;
    cote;
    score;

    constructor(pseudo, cote) {
        if(this.constructor===Joueur)
            throw new TypeError("Can't initialize Joueur");
        this.pseudo = pseudo;
        this.cote = cote;
        this.score = 0;
    }

    jouer(plateau){}

    ajouterPoint(point) {
        this.score += point;
    }

    get score() {
        return this.score;
    }

    get pseudo(){
        return this.pseudo;
    }

    set pseudo(pseudo) {
        this.pseudo = pseudo;
    }

    set cote(cote) {
        this.cote = cote;
    }

    coupsPossibles(plateau) {
        let coups = new Array;
        if(plateau.victorieux() == 0)
            for(let i=0; i<6; i++)
                if(plateau.coupPossible(cote, i))
                    coups.push(i);
        return coups;
    }

    toString(){
        return "Le joueur " + this.pseudo + " a " + this.score + " points.";
    }

}
