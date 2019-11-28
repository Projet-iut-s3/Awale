class Joueur {

    constructor(pseudo, cote) {
        if(this.constructor===Joueur)
            throw new TypeError("Can't initialize Joueur");
        this._pseudo = pseudo;
        this._cote = cote;
        this._score = 0;
    }

    jouer(plateau){}

    ajouterPoint(point) {
        this._score += point;
    }

    get score() {
        return this._score;
    }

    get pseudo(){
        return this._pseudo;
    }

    set pseudo(pseudo) {
        this._pseudo = pseudo;
    }

    set cote(cote) {
        this._cote = cote;
    }

    coupsPossibles(plateau) {
        let coups = [];
        if(plateau.victorieux() === 0)
            for(let i=0; i<6; i++)
                if(plateau.coupPossible(this._cote, i))
                    coups.push(i);
        return coups;
    }

    toString(){
        return "Le joueur " + this._pseudo + " a " + this._score + " points.";
    }

}
module.exports = Joueur;