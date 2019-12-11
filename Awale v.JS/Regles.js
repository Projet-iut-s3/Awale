export class Regle {

	constructor(){

	}

	appliquerRegle(p, i, j) {
	    return true;
    }

}

export class Affame extends Regle {
    
    appliquerRegle(p, i, j){
        return true;
    }

}

export class Doitdonner extends Regle {
    
    appliquerRegle(p, i, j){
        let coteadverse = (i+1)%2;
        let estVide = true;
        for (let $i=0; $i<6 && estVide; $i++)
            if (p.plateau[coteadverse][$i] !== 0)
                estVide = false;
        return (estVide && (coteadverse === 1 && j === 0) || (coteadverse === 0 && j === 5)) || !estVide;

    }

}

