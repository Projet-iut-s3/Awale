import { Joueur } from 'joueur';
import { Plateau } from 'plateau';

export class JoueurHumain extends Joueur {
    
    constructor(pseudo: String, cote: number) {
        super(pseudo, cote);
    }
    
    public jouer(plateau: Plateau): number {
        return 0;
    }
}