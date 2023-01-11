import { Injectable } from '@angular/core';
import { UUID } from 'angular2-uuid';
import { Reservation } from './models/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class ResaService {
  reservations! : Array<Reservation>;
  result! : Reservation;
  constructor() {
  this.reservations = [{"id":UUID.UUID(),"clientPrincipal":{"id":1,"nom":"omar","prenom":"lam"},"passagers":[{"id":1,"nom":"chads","prenom":"chfffa"}],"dateDebut":"2022-01-11","dateFin":"2022-11-12"}]
  for (let index = 0; index < 10; index++) {
    this.reservations.push({"id":UUID.UUID(),"clientPrincipal":{"id":1,"nom":"omar","prenom":"lam"},"passagers":[{"id":1,"nom":"chads","prenom":"chfffa"}],"dateDebut":"2022-01-11","dateFin":"2022-11-12"})
        }
   }
//    public findAll() { return this.httpc
//     .get('http://localhost:8080/api/client')
//     .subscribe(resp => this.clients = resp.json());
// }

   findById(id: string): Reservation {
    this.reservations.forEach(c => {
        if (c.id == id) {
          this.result= c;
        }else return null;
      });
      return this.result;
}


   remove(id: string): void {
    console.log(id)
     console.log(this.findById(id))
     if (this.findById(id)!=null) {
       this.reservations.splice(this.reservations.indexOf(this.findById(id)),1)
     }
}


}
