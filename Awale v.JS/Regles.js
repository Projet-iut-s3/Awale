export class Regle {

	constructor(){

	}

	appliquerRegle(p, i, j);

}

export class Affame extends Regle {
    
    appliquerRegle(p, i, j){
        return true;
    }

}

export class Doitdonner extends Regle {
    
    appliquerRegle(p, i, j){
        return true;
    }

}