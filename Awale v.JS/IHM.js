import {JoueurHumain} from "./JoueurHumain.js";
import {Jeu} from './Jeu.js';

export const nbcasejoueur = 6;

export class IHM {

    constructor() {
        let j1 = new JoueurHumain("sam", 1);
        let j2 = new JoueurHumain("uel", 1);
        this.jeu = new Jeu(j1, j2, 0, [[1,0,0,0,0,0],[4,1,1,1,1,1]]);
        this.tour = 1;
        this.fini = false;
    }

    paint() {
        let joueurQuiDoitJouer = document.getElementById('joueurQuiDoitJouer');
        joueurQuiDoitJouer.innerText = this.tour + "";
        for (let i=0; i<2; i++)
            for (let j=0; j<nbcasejoueur; j++)
                document.getElementById('img_case'+(i*nbcasejoueur+j)).src = "../PHOTOGRAINE/"+this.jeu.getPlateau().getCase(i, j)+"bille.jpg";
        document.getElementById('pointJoueur1').innerText = this.jeu.j1.score;
        document.getElementById('pointJoueur2').innerText = this.jeu.j2.score;
    }

    click(i) {
        if(!this.fini) {
            let cote = Math.floor(i / nbcasejoueur);
            let res = this.jeu.jouer(i % nbcasejoueur, cote);
            if (res !== -1) {
                if(res===1)
                    document.getElementById('joueurvictoire').innerText = "Victoire du joueur 1 ("+this.jeu.j1.pseudo+")";
                else if(res===2)
                    document.getElementById('joueurvictoire').innerText = "Victoire du joueur 2 ("+this.jeu.j2.pseudo+")";
                this.tour = this.tour % 2 + 1;
                if(res!==0)
                    this.fini = true;
            }
            this.paint();
        }
    }

    static init() {
        let ihm = new IHM();
        document.getElementById("AwaleContener").innerHTML = "\n" +
            "        <div class='col-left' id='grille_case'>\n" +
            "            <div class='row'>\n" +
            "                <a id='click_case0' ><img id='img_case0' alt='case0' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case1'><img id='img_case1' alt='case1' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case2'><img id='img_case2' alt='case2' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case3'><img id='img_case3' alt='case3' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case4'><img id='img_case4' alt='case4' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case5'><img id='img_case5' alt='case5' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "            </div>\n" +
            "            <div class='row'>\n" +
            "                <a id='click_case6'><img id='img_case6' alt='case6' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case7'><img id='img_case7' alt='case7' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case8'><img id='img_case8' alt='case8' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case9'><img id='img_case9' alt='case9' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case10'><img id='img_case10' alt='case10' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "                <a id='click_case11'><img id='img_case11' alt='case11' src='../PHOTOGRAINE/4bille.jpg'></a>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class='col-rigth'>\n" +
            "            <p>C'est au joueur <span id='joueurQuiDoitJouer'>1</span> de jouer</p>\n" +
            "            <br>\n" +
            "            <p>Points du joueur 1 (<span id='nomJoueur1'></span>) : <span id='pointJoueur1'>0</span> </p>\n" +
            "            <p>Points du joueur 2 (<span id='nomJoueur2'></span>) : <span id='pointJoueur2'>0</span> </p>\n" +
            "            <p id='joueurvictoire'></p>\n" +
            "        </div>";
        for (let i=0; i<2*nbcasejoueur; i++)
            document.getElementById("click_case"+i).onclick = () => ihm.click(i);
        document.getElementById("nomJoueur1").innerText = ihm.jeu.j1.pseudo;
        document.getElementById("nomJoueur2").innerText = ihm.jeu.j2.pseudo
        ihm.paint();
    }
}

IHM.init();
