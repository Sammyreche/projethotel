export class Compte{
    className: String;
    id : number;
    login : string;
    password: string;

}

 export class Passager {
     id:     number;
     nom:    string;
     prenom: string;
 }

 export class Reservation {
     id:              string;
     clientPrincipal: Client;
     passagers:       Passager[];
     dateDebut:       string;
     dateFin:         string;
 }
export class Client extends Compte{
nom : string;
prenom : string;
mail : string;
telephone : string;
naissance : string;
listResa : Array<Reservation>;

}
export class Personnel extends Compte{

nom : string;
prenom: string;



}
export class Admin extends Compte{
    nom : string;
    prenom: string;
}