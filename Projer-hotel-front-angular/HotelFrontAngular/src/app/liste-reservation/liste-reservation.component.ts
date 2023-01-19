import { Component, OnInit } from '@angular/core';
import { ConnexionService } from '../connexion/connexion.service';
import { ListeReservation, PageReservation } from '../models/reservation.model';
import { NouvellReservationService } from '../nouvelle-reservation/nouvell-reservation.service';
import { ResaService } from './resa.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.css']
})
export class ListeReservationComponent  implements OnInit{
  keyword! :string;
  reservations: Array<ListeReservation> = new Array<ListeReservation>();
  pageReservation : PageReservation;
  currentAction :string="all";
  currentpage : number=0;
  pageSize : number=5;
  totalPages:number=0;
  connectedCompte = this.connexionService.compteConnecte;
  listeClient :any;
  //premiereConnection : boolean =true
  recherche = true;
  


  
  constructor(public connexionService: ConnexionService,public resaService : ResaService,private nouvellResaService : NouvellReservationService)
  {console.log("de constructeur") }

    ngOnInit(): void {
      console.log("de onInit")
      this.resaService.load().subscribe(result => this.list());
      // if (this.premiereConnection==true) {
      //   this.premiereConnection=false
      // }

      
    //   this.nouvellResaService.listeClient().subscribe(rep=>{
        
    //     this.listeClient = rep
    //  })
    this.reservations.length
    }  
  // list(): Array<ListeReservation> {
  //   this.reservations = this.resaService.findAll()
  //   return this.reservations;
  // }
  list(): Array<ListeReservation> {
    this.resaService.getPageReservations(this.currentpage,this.pageSize).subscribe(resp=>{
      this.reservations = resp.reservations;
      this.totalPages=resp.totalPages;
      this.currentpage=resp.page
    })
    return this.reservations;
  }

  handleSearchReservations() : Array<ListeReservation> {
    // console.log(this.recherche)
     if (this.recherche = true) {
      this.recherche = false;
     }
    if(this.keyword) {
      this.currentpage=0
      this.resaService.search(this.keyword).subscribe(result => this.list());
    } else this.resaService.load().subscribe(result => this.list());
    return null;
  }

  handleDeleteReservation(r : ListeReservation ){
    this.currentpage=0
    this.resaService.remove(r.id).subscribe(result => this.resaService.load().subscribe(result => this.list()));
    
    
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

  rechercheCompteById(id : number){
    // this.listeClient.forEach(element => {
    //   element.resa
    // });
    this.connectedCompte.id
  }
}
