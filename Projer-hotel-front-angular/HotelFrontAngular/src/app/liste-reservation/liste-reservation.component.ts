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
  pageReservation : PageReservation;
  currentAction :string="all";
  currentpage : number=0;
  pageSize : number=5;
  totalPages:number=0;
  
  constructor(public resaService : ResaService){
    this.reservations = this.resaService.reservations
  }
  // list(): Array<ListeReservation> {
  //   this.reservations = this.resaService.findAll()
  //   return this.reservations;
  // }
  list(): Array<ListeReservation> {
    this.resaService.findAll()
    this.resaService.getPageReservations(this.currentpage,this.pageSize).subscribe(resp=>{
      this.reservations = resp.reservations;
      this.totalPages=resp.totalPages;
      this.currentpage=resp.page
    })
    return this.reservations;
  }

  handleSearchReservations() : Array<ListeReservation> {
   
    if(this.keyword) {
      this.currentpage=0
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

  goToPage(i:number){
    this.currentpage=i;
    if (this.currentAction=="all") {
      this.list();
    } else this.list();

  }
}
