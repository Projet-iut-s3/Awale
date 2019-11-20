import {JoueurHumain} from "./JoueurHumain.js";
import {Jeu} from './jeu';

export class IHM {

    jeu;
    tour = 1;

    constructor() {
        let j1 = new JoueurHumain("sam", 1);
        let j2 = new JoueurHumain("uel", 1);
        this.jeu = new Jeu(j1, j2);
    }

    paint() {
        let joueurQuiDoitJouer = document.getElementById('joueurQuiDoitJouer');
        joueurQuiDoitJouer.innerText = this.tour + "";
    }

    click(i) {
        this.tour = this.tour % 2 + 1;
        this.paint();
    }
}
