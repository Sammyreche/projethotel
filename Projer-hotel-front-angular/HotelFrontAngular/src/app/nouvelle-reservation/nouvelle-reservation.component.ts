import { Component } from '@angular/core';
import { ConnexionService } from '../connexion/connexion.service';
import { NouvellReservationService } from './nouvell-reservation.Service';
import { Compte } from '../models/compte.model';
import { Detailresa, Passager } from '../models/detailresa.model';

@Component({
  selector: 'app-nouvelle-reservation',
  templateUrl: './nouvelle-reservation.component.html',
  styleUrls: ['./nouvelle-reservation.component.css']
})
export class NouvelleReservationComponent {
  reservation : Detailresa = new Detailresa();
  passager = new Passager();
  formReservation : Detailresa = new Detailresa();
  
  editPassager : boolean = false
  editActiviter : boolean = false
  compte : Compte = this.compteService.compteConnecte;
  NbrPasssager =0;
  constructor(private compteService : ConnexionService, private nouvellResaService : NouvellReservationService){
   this.formReservation.passagers = new Array<Passager>() 
   //this.formReservation.passagers.length
  }
  onInit(){
    this.NbrPasssager = this.formReservation.passagers.length;

  }
    handleSetAffichagePassager(){
      if (this.editPassager==false) {
        this.editPassager=true;
        
        console.log(this.formReservation.passagers.length)
      }else {
        
        this.editPassager=false
        if (this.editActiviter=true) {
          this.editActiviter=false
          
        }
      } 
    }
    handleSetAffichageActiviter(p : Passager){
      if (p.affichageActiviter==false) {
        p.affichageActiviter=true
      }else p.affichageActiviter=false
    }
    ajouterPassager(){
      this.formReservation.passagers.push(structuredClone(this.passager))
    }
    supprimerPassager(){
      this.formReservation.passagers.splice( (this.formReservation.passagers.length-1),1)
    }
    augmenterNbrAccomp(p : Passager){
       if (p.nombre ==undefined) {
         p.nombre = 1
       }else{
          console.log(p)
          p.nombre = (p.nombre +1)
       }
      
      
    }
        diminuerNbrAccomp(p : Passager){
       if (p.nombre ==undefined) {
         p.nombre = 0
       }if (p.nombre > 0) {
         p.nombre = (p.nombre - 1)
       }if (p.nombre == 0) {
         p.nombre=null
       }
      
    }


    saveReservation(){
      this.nouvellResaService.create(this.formReservation,this.compte)
    }
}
