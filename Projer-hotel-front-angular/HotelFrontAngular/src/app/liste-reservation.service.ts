import { Injectable } from '@angular/core';
import { ClientPrincipal, Passager, Reservation } from './models/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class ListeReservationService {
  reservations! : Array<Reservation>
  reservation! : Reservation;
  passager!:Passager;
  clientPrinipale! : ClientPrincipal
  constructor() {
this.reservations = [
  {
    "id": 1,
    "clientPrincipal": {
      "id": 1,
      "nom": "omar",
      "prenom": "lam"
    },
    "passagers": [
      {
        "id": 1,
        "nom": "chads",
        "prenom": "chfffa"
      }
    ],
    "dateDebut": "2022-01-11",
    "dateFin": "2022-11-12"
  }
]


    // this.reservation.id=1;
    // this.reservation.dateDebut="12-11-1994";
    // this.reservation.dateFin="12-11-1994";
    // this.passager.id=1;
    // this.passager.nom="lam";
    // this.passager.prenom="omar";
    // this.clientPrinipale.id=1;
    // this.clientPrinipale.nom="moumkin";
    // this.clientPrinipale.prenom="othmane";
    // this.reservation.passagers.push(this.passager);
    // this.reservation.clientPrincipal=this.clientPrinipale;


   }
}
