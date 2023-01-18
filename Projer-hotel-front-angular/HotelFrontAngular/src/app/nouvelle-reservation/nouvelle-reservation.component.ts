import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
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
  clientId : number;
 
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
    private router: Router,
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
            this.searchIdClient()
            
          }
        }
      
      

    })
    console.log(recup);
    
  });

  }



  onInit(){
    this.NbrPasssager = this.formReservation.passagers.length;
    // this.nouvellResaService.listeClient().subscribe(rep=>{
    //   this.comptesClient=rep;
    //   console.log(rep)
    // })
    // this.compteClient
    this.nouvellResaService.listeClient()

  }

    listClient(){
     return this.nouvellResaService.comptesClient
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

    searchIdClient() : void {
      
      if (this.currentAction=="edit") {
        console.log(this.nouvellResaService.comptesClient)
        this.nouvellResaService.comptesClient.forEach(compte => {
          compte.resa.forEach(ele => {
            if (ele.id==this.formReservation.id) {
              this.clientId = compte.id
            }
          });
        });
      }
    }

    saveReservation() : any{
      if (this.compte==undefined) {
        alert("Merci de vous connecter avant la reservation")
        this.router.navigate(['/login'])
       return null
      }
      if (this.formReservation.passagers.length==0) {
        alert("impossible de sauvgarder une reservation sans passager")
        alert("merci de remplir au moins les information d'un seul passager")
        return null
      }else
      if (this.compte.className=='Admin'||this.compte.className=='Personnel') {
        this.nouvellResaService.create(this.formReservation,this.clientId)
        alert("Reservation bien effectuée")
      this.router.navigate(['/listeResa'])
      return null
      }
      this.nouvellResaService.create(this.formReservation,this.compte.id)
      alert("Reservation bien effectuée")
      this.router.navigate(['/listeResa'])
    }
    logout(){
      console.log("ok")
      this.compteService.logout()
    }
}
