import { Component } from '@angular/core';
import { Reservation } from '../models/reservation.model';
import { ResaService } from '../resa.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.css']
})
export class ListeReservationComponent {
  keyword! :string;
  reservations: Array<Reservation> = [];
  totalPages! : number;
  currentpage! : number;
  
  constructor(public resaService : ResaService){
    this.reservations = this.resaService.reservations
  }
  handlereservations() : Array<Reservation> {
    if(this.keyword) {
      return this.reservations.filter(resa => resa.clientPrincipal.nom.indexOf(this.keyword) != -1 || resa.clientPrincipal.prenom.indexOf(this.keyword) != -1);
    } 
    return this.reservations
  }
  handleSearchProducts(){
    console.log(this.keyword)
  }
  handleDeleteProduct(r : Reservation ){
    this.resaService.remove(r.id)
  }
  goToPage(i:number){}
}
