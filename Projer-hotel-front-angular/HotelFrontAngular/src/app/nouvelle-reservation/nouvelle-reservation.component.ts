import { JsonPipe } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ConnexionService } from '../connexion/connexion.service';
import { resaDetailHttpService } from '../detail-reservation/resaDetailHttp.service';
import { ResaService } from '../liste-reservation/resa.service';
import { Client, Compte } from '../models/compte.model';
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
  compte :Compte  = this.compteService.compteConnecte;

  //compte : Compte = JSON.parse(sessionStorage.getItem('connected'));
  //let compteJson = JSON.stringify(compte);
 // sessionStorage.setItem('user', compteJson);

  NbrPasssager =0;
  constructor(private compteService : ConnexionService,
    private nouvellResaService : NouvellReservationService,
    private route: ActivatedRoute,
    private router: Router,
    public resaService : resaDetailHttpService,
    private listeResaService : ResaService){

      this.nouvellResaService.listeClient()
      console.log(this.listeResaService.premiereConnection)
      this.listeResaService.premiereConnection =false
      console.log(this.listeResaService.premiereConnection)


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


  if (this.currentAction == "inscription" && this.compte.className=="Client") {
    this.editPassager = true
    let client = JSON.stringify(this.compte)
    let client2 : Client = JSON.parse(client)
    console.log(client2)
    this.formReservation.passagers.push(structuredClone(new Passager(client2.nom,client2.prenom,client2.naissance)))  }





  }



  onInit(){
    this.NbrPasssager = this.formReservation.passagers.length;
    // this.nouvellResaService.listeClient().subscribe(rep=>{
    //   this.comptesClient=rep;
    //   console.log(rep)
    // })
    // this.compteClient


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
      if (this.formReservation.passagers.length>1) {
        this.formReservation.passagers.splice( (this.formReservation.passagers.length-1),1)
      }
      
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

      if (this.compte.className=='Admin'||this.compte.className=='Personnel') {
    if (("" + this.formReservation.dateDebut_resa>=new Date().toISOString().split('T')[0]) &&
    (this.formReservation.dateDebut_resa<this.formReservation.dateFin_resa)) {
      console.log("okokokokokokokoko")
 
        this.nouvellResaService.create(this.formReservation,this.clientId).subscribe(rep=>{
          this.router.navigate(['/listeResa'])
        })
    }
      return null
      }else if (this.compte.className=='Client')
        
      if (("" + this.formReservation.dateDebut_resa>=new Date().toISOString().split('T')[0])&&
      (this.formReservation.dateDebut_resa<this.formReservation.dateFin_resa)) {
      
        this.nouvellResaService.create(this.formReservation,this.compte.id).subscribe(rep=>{
          this.router.navigate(['/listeResa'])
        }) 
      }
    }


    
    logout(){
      console.log("ok")
      this.compteService.logout()
    }

    handleSupprimerPassage(p : Passager){
      this.nouvellResaService.supprimerPassager(p.id_passager)
      this.formReservation.passagers.splice( (this.formReservation.passagers.indexOf(p)),1)
    }
    verifDateDebut() :boolean{
      if (("" + this.formReservation.dateDebut_resa>=new Date().toISOString().split('T')[0])) {
        return false
      }return true
      
    }
    verifDateFin() :boolean{
      if ( this.formReservation.dateDebut_resa> this.formReservation.dateFin_resa ) {
        return true
      }return false
      
    }

    popup(){
      
    }
}
