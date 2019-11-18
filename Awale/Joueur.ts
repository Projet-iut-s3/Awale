import { Plateau } from 'plateau';

export abstract class Joueur {
	
	private pseudo: String;
	private cote: number;
	private score: number;

	public constructor (pseudo: String, cote: number) {
		this.pseudo = pseudo;
		this.cote = cote;
		this.score = 0;
	}
	
	public abstract jouer(plateau: Plateau): number;
	
	public ajouterPoint(point: number) {
		this.score = (this.score + point);
	}
	
	public getScore(): number {
		return this.score;
	}
	
	public getPseudo(): String {
		return this.pseudo;
	}
	
	public setPseudo(pseudo: String) {
		this.pseudo = this.pseudo;
	}
	
	public setCote(cote: number) {
		this.cote = this.cote;
	}
	
	public afficher(): String {
		return "Le joueur " + this.pseudo + " a "+ this.score + " points.";
	}
}