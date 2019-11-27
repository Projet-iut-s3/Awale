import { Joueur } from "./Joueur.js";
import { Plateau } from "./Plateau.js";

class JoueurIA extends Joueur {

    pronfondeur;

    constructor(pseudo, cote){
        super(pseudo, cote);
        this.pronfondeur = 10;
    }

    set pronfondeur(pronfondeur){
        this.pronfondeur = 2*pronfondeur;
    }

    jouer(plateau) {
        let coupAFaire = [];
        let tousLesCoups = this.coupsPossibles();
        tousLesCoups.forEach((element) => {
            coupAFaire.push(min(plateau, this.pronfondeur-1));
        });
        return tousLesCoups.indexOf(Math.max(coupAFaire));
    }
    
    max(p, pronf){
        if(this.coupsPossibles().length===0 || pronf===this.pronfondeur+1) {
            if(p.victorieux()===this.pseudo)
                return 1000-pronf; // Victoire de l'IA
            else if(p.victorieux()!==0)
                return -1000+pronf; // Victoire de l'autre joueur
            else
                return 0; // On s'arrete de regarder et on deplie la pile
        }
        let vals_max = [];
        this.coupsPossibles().forEach((element) => {
            vals_max.push(this.pointsijouer(p, element) + this.min(this.simulerCoup(p, element), pronf+1));
        });
        return Math.max(vals_max); // Le maximun de point que l'on peut avoir
    }

    min(p, pronf) {
        if(this.coupsPossibles().length===0 || pronf===this.pronfondeur+1) {
            if(p.victorieux()===this.pseudo)
                return 1000-pronf; // Victoire de l'IA
            else if(p.victorieux()!==0)
                return -1000+pronf; // Victoire de l'autre joueur
            else
                return 0; // On s'arrete de regarder et on deplie la pile
        }
        let vals_min = [];
        this.coupsPossibles().forEach((element) => {
            vals_min.push(this.pointsijouer(p, element) + this.max(this.simulerCoup(p, element), pronf+1));
        });
        return Math.max(vals_min); // Le maximun de point que l'on peut sauver
    }

    pointsijouer(p, i) {
        let plateau = new Plateau(p);
        return plateau.jouerCase(i, cote); // Le nombre de point si le joueur jouer cette case
    }
    
    simulerCoup(p, i){
        let plateau = new Plateau(p);
        plateau.jouerCase(i, cote);
        return plateau; // Un plateau fictif dans lequel le jouer a jouer cette case
    }
    
}