import {Plateau} from "./Plateau.js";

export class Jeu {
    j1;
    j2;
    tour; // O pour j1 | 1 pour j2
    plateau;

    constructor(j1, j2, tour, plateau = null) {
        this.tour = tour;
        this.j1 = j1;
        this.j2 = j2;
        this.plateau = new Plateau(this.j1, this.j2);
        if(plateau!==null)
            this.plateau.setPlateau(plateau);
    }

    aGagner() {
        if(this.j1.score>=25)
            return 1;
        else if(this.j2.score>=25)
            return 2;
        return 0;
    }

    jouer(j, cote) {
        if(cote!==this.tour)
            return -1; // Ce n'est pas a lui de jouer;
        let point = this.plateau.jouerCase(j, cote);
        if(point===-1 || point===-2)
            return -1;
        this.tour = (this.tour + 1) % 2;
        if(this.tour===0) // on a change le tour
            this.j2.ajouterPoint(point);
        else
            this.j1.ajouterPoint(point);
        return this.aGagner();
    }

    getPlateau() {return this.plateau;}
}