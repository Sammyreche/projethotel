import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConnexionService } from '../connexion/connexion.service';
import { resaDetailHttpService } from '../detail-reservation/resaDetailHttp.service';
import { Compte } from '../models/compte.model';
import { Detailresa, Passager } from '../models/detailresa.model';
import { NouvellReservationService } from './nouvell-reservation.service';

@Component({
  selector: 'app-nouvelle-reservation',
  templateUrl: './nouvelle-reservation.component.html',
  styleUrls: ['./nouvelle-reservation.component.css']
})
export class NouvelleReservationComponent {
 currentAction = "inscription"
  //currentAction = "edit"
  reservation : Detailresa = new Detailresa();
  passager = new Passager();
  formReservation : Detailresa = new Detailresa();
  
  editPassager : boolean = false
  editActiviter : boolean = false
  compte : Compte = this.compteService.compteConnecte;
  //compte : Compte = JSON.parse(sessionStorage.getItem('connected'));
  //let compteJson = JSON.stringify(compte);
 // sessionStorage.setItem('user', compteJson);

  NbrPasssager =0;
  constructor(private compteService : ConnexionService,
    private nouvellResaService : NouvellReservationService,
    private route: ActivatedRoute,
    public resaService : resaDetailHttpService){
   this.formReservation.passagers = new Array<Passager>() 

  // this.route.params.subscribe(param => {

  //   // resaService.findById([param]).subscribe(rep=>{
  //   //   this.formReservation=rep
  //   // })
  //   console.log(param);
  // });

  this.route.queryParams.subscribe(paramss=> {
  
    let recup : any = + paramss['id'] ||0;
      resaService.findById(recup).subscribe(rep=>{
        if (rep!=null) {
          rep.passagers.forEach(element => {
            element.affichageActiviter=false
          });
          this.formReservation=rep
         
          if (this.currentAction = "inscription") {
            this.currentAction = "edit"

          }
        }
      
      

    })
    console.log(recup);
    
  });

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
      // if (p.affichageActiviter==undefined) {
      //   p.affichageActiviter==false
      // }else
      console.log(p.affichageActiviter)
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
      this.nouvellResaService.create(this.formReservation,this.compte.id)
    }
    logout(){
      console.log("ok")
      this.compteService.logout()
    }
}
