import { Joueur } from 'joueur';
import { Plateau } from 'plateau';

export class JoueurIA extends Joueur {

    private profondeur:number;
    private cotep:number;
	
    constructor(pseudo: String, cote: number) {
        super(pseudo, cote);
        this.profondeur = 10;
        this.cotep = 1;
    }
    
    public jouer(plateau: Plateau): number {
        var res: number = this.max(this.simulerCoup(plateau, 1), this.profondeur);
        var j: number = 1;
        for (var i: number = 2; i < 6; i++) {
            var resbis: number = this.max(this.simulerCoup(plateau, i), this.profondeur);
            if (resbis > res)
                j = i;
        }
        return j;
    }

    public setProfondeur(profondeur:number) {
    	this.profondeur = 2*profondeur;
    }

    public setCotep(cote:number) {
    	this.cotep = cote;
    }

    public max(p:Plateau, generationRestante:number): number{
    	if(generationRestante == 0){
    		var pl:Plateau = new Plateau(p);
    		var res:number = pl.jouerCase(1, this.cotep);
    		for (var i = 0; i < 5; i++) {
    			pl = new Plateau(p);
    			var resbis = pl.jouerCase(i, this.cotep);
    			if(resbis>res)
    				res=resbis;
    		}
    		if(res==-1)
    			return -10000;
    		return res;
    	}
    	return this.maxScoreDes6(
    				this.max(this.simulerCoup(p, 1), generationRestante - 1),
    				this.max(this.simulerCoup(p, 2), generationRestante - 1),
    				this.max(this.simulerCoup(p, 3), generationRestante - 1),
    				this.max(this.simulerCoup(p, 4), generationRestante - 1),
    				this.max(this.simulerCoup(p, 5), generationRestante - 1),
    				this.max(this.simulerCoup(p, 6), generationRestante - 1));
    }

    private simulerCoup(p:Plateau, i:number): Plateau{
    	var plateau:Plateau = new Plateau(p);
    	plateau.jouerCase(i, this.cotep);
    	return plateau;
    }

    private maxScoreDes6(i1: number, i2: number, i3: number, i4: number, i5: number, i6: number): number {
        return this.maxScoreDe2(i1, this.maxScoreDe2(i2, this.maxScoreDe2(i3, this.maxScoreDe2(i4, this.maxScoreDe2(i5, i6)))));
    }
    
    private maxScoreDe2(i: number, j: number): number {
        if (i > j)
            return i;
        return j;
    }

}