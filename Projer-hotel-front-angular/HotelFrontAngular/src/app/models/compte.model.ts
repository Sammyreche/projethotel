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
     
     constructor(nom : string,prenom :string){
         this.nom=nom
         this.prenom=prenom
     }
 }
 


 export class Reservation {
     id:              number;
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
resa : Array<Reservation>;

}
export class Personnel extends Compte{

nom : string;
prenom: string;
fonction : string;
salaire : number


}
export class Admin extends Compte{
    nom : string;
    prenom: string;
}