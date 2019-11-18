import { Plateau } from 'plateau';

export interface Regle {
	appliquerRegle(plateau: Plateau, i: number, j: number): boolean;
}

export class Affame implements Regle {
    public appliquerRegle(plateau: Plateau, i: number, j: number): boolean {
        return true;
    }
}

export class Doitdonner implements Regle {
    public appliquerRegle(plateau: Plateau, i: number, j: number): boolean {
        return true;
    }
}