export interface Compte{
    className: String;
    id : number;
    login : string;
    password: string;

}

 export interface Passager {
     id:     number;
     nom:    string;
     prenom: string;
 }

 export interface Reservation {
     id:              string;
     clientPrincipal: Client;
     passagers:       Passager[];
     dateDebut:       string;
     dateFin:         string;
 }
export interface Client extends Compte{
className: String;
nom : string;
prenom : string;
email : string;
telephone : string;
naissance : string;
listResa : Array<Reservation>;

}
export interface Personnel extends Compte{
className : string;
nom : string;
prenom: string;



}
export interface Admin extends Compte{
    className : string;
    nom : string;
    prenom: string;
}