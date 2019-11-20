import {Plateau} from "./Plateau";

export class Jeu {
    j1;
    j2;
    plateau;

    constructor(j1, j2) {
        this.plateau = new Plateau(j1, j2);
        this.j1 = j1;
        this.j2 = j2;
    }

    aGagner() {
        if(this.j1.score()>=25)
            return 1;
        else if(this.j2.score()>=25)
            return 2;
        return 0;
    }

    jouer(i) {
        this.plateau.jouerCase(i%5, i/5);
        return this.aGagner();
    }
}