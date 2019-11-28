class Regle {

	constructor(){

	}

	appliquerRegle(p, i, j) {
	    return true;
    }

}

class Affame extends Regle {
    
    appliquerRegle(p, i, j){
        return true;
    }

}

class Doitdonner extends Regle {
    
    appliquerRegle(p, i, j){
        return true;
    }

}

module.exports = {Affame, Doitdonner};
