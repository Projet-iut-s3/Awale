const Joueur = require('./Joueur');

class JoueurHumain extends Joueur {
    constructor(pseudo, cote) {
        super(pseudo, cote);
    }

    jouer(plateau) {
        return 0;
    }
}

module.exports = JoueurHumain;