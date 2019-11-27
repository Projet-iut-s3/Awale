import { Joueur } from "./Joueur.js";

export class JoueurHumain extends Joueur {
    constructor(pseudo, cote) {
        super(pseudo, cote);
    }

    jouer(plateau) {
        return 0;
    }
}