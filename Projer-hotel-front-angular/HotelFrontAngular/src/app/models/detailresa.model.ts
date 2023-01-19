//import { jsonIgnore } from "json-ignore";

export class Detailresa {
    id:             number;
    dateDebut_resa: Date;
    dateFin_resa:   Date;
    passagers:      Passager[];
    typeLogement:   string;
    id_chambre:     number;

    constructor(){}
}

export class Passager {
    id_passager:        number;
    nom_passager:       string;
    prenom_passager:    string;
    naissance_passager: string;
    date:               string;
    nombre:             number;
    typeActivite:       string;
    id_prestation:      number;
    //@jsonIgnore()
    affichageActiviter:  boolean = false;
    constructor(nom? : string,prenom? :string, naissance? : string){
        this.nom_passager=nom
        this.prenom_passager=prenom
        this.naissance_passager=naissance
    }
}