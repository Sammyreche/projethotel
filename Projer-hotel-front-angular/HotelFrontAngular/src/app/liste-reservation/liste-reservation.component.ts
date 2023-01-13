import { Component } from '@angular/core';
import { ListeReservation, PageReservation } from '../models/reservation.model';
import { ResaService } from './resa.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.css']
})
export class ListeReservationComponent {
  keyword! :string;
  reservations: Array<ListeReservation> = [];
  currentAction :string="all";
  currentpage : number=0;
  pageSize : number=5;
  totalPages:number=0;
  
  constructor(public resaService : ResaService){
    this.reservations = this.resaService.reservations
  }
  list(): Array<ListeReservation> {
    return this.resaService.findAll();
  }
  handleSearchReservations() : Array<ListeReservation> {
   
    if(this.keyword) {
      this.resaService.search(this.keyword)
    } else this.resaService.load()
    return null;
  }

  handleDeleteReservation(r : ListeReservation ){
    this.resaService.remove(r.id)
  }
  // handlGetPageReservations(){
  //   this.currentAction="all"
  //   this.resaService.getPageReservations(this.currentpage,this.pageSize).subscribe({
  //     next: (data: PageReservation) => {
  //       this.reservations = data.reservations;
  //       this.totalPages=data.totalPages;
  //     }
  //   });
  //   throw new Error('Method not implemented.');
  // }

  goToPage(i:number){}
}
