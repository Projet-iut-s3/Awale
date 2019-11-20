import { Joueur } from "./Joueur";

export class JoueurHumain extends Joueur {
    constructor(pseudo, cote) {
        super(pseudo, cote);
    }

    jouer(plateau) {
        return 0;
    }
}