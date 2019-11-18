import { Joueur } from 'joueur';
import { Regle, Affame, Doitdonner } from 'regles';

export class Plateau {
	
	private plateau:number[][];
	private j1:Joueur;
	private j2:Joueur;
	private static regles = ((): Array<Regle> => {
    	let reg:Array<Regle>;
        reg.push(new Affame());
        reg.push(new Doitdonner());
        return reg;
	})();

	constructor(p?:Plateau) {
		if(p.plateau){
			this.plateau = p.plateau;
			this.j1 = p.j1;
			this.j2 = p.j2;
		}
		else
			for(var i = 0; i < 2; i++)
				for(var j = 0; j < 6; j++)
					this.plateau[i][j] = 4;
	}

    public getnbGraines(i:number,j:number) : number{
        return this.plateau[i][j];
    }

    public ajouterGraine(i:number,j:number){
        this.plateau[i][j]++;
    }

    public enleverToutesGraines(i:number,j:number){
        this.plateau[i][j] = 0;
    }

   	public coupPossible(i:number, j:number):boolean {
   		let res:boolean = true;
   		Plateau.regles.forEach((r:Regle) => {
	   			res = res && r.appliquerRegle(this, i, j);
	   		});
   		return res;
   	}

   	

	public jouerCase(cas:number, cote:number):number{
		return 1;
	}
}