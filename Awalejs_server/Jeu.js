const Plateau = require("./Plateau")

class Jeu {

    constructor(j1, j2, tour) {
        this._tour = tour; // O pour j1 | 1 pour j2
        this._j1 = j1;
        this._j2 = j2;
        this._plateau = new Plateau(this._j1, this._j2);
    }

    aGagner() {
        if(this._j1.score>=25)
            return 1;
        else if(this._j2.score>=25)
            return 2;
        return 0;
    }

    jouer(j, cote) {
        console.log(this._tour, cote+1);
        if(cote+1!==this._tour)
            return -1; // Ce n'est pas a lui de jouer;
        let point = this._plateau.jouerCase(j, cote);
        if(point===-1)
            return -1;
        this._tour = this._tour % 2 + 1;
        if(this._tour===1) // on a change le tour
            this._j2.ajouterPoint(point);
        else
            this._j1.ajouterPoint(point);
        return this.aGagner();
    }

    getPlateau() {return this._plateau;}
    getTour() {return this._tour;}
}

module.exports = Jeu;