import { HttpClient } from "@angular/common/http";
import { Component, Injectable } from "@angular/core";
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from "@angular/router";
import { Observable } from "rxjs";
import { AppConfigService } from "../app-config.service";
import { Detailresa, Passager } from "../models/detailresa.model";
import { resaDetailHttpService } from "./resaDetailHttp.service";


  
@Component({
  selector: 'detail-reservation',
  templateUrl: './detail-reservation.component.html',
  styleUrls: ['./detail-reservation.component.css']
})
export class DetailReservationComponent {
 
  reservations: Detailresa = new Detailresa();
  //reservations!: Detailresa 

  passagers = new Array<Passager>();
 // this.reservations.passagers = new Array<Passager>();

  
  constructor(public resaService : resaDetailHttpService,private router: Router ,private route: ActivatedRoute){
   // this.reservations = this.resaService.reservations;
  //  this.reservations.passagers = new Array<Passager>()
  }

 ngOnInit():void{

  this.route.queryParams.subscribe(paramss=> {
  
    let recup : any = + paramss['id'] ||0;
    this.resaService.load(recup).subscribe(rep=>{
      this.reservations =rep
      console.log(rep)
    })
    //   resaService.findById(recup).subscribe(rep=>{
    //     if (rep!=null) {
    //       rep.passagers.forEach(element => {
    //         element.affichageActiviter=false
    //       });
    //       this.formReservation=rep
         
    //       if (this.currentAction = "inscription") {
    //         this.currentAction = "edit"

    //       }
    //     }
    // })
    console.log(recup);
    
  });
 
 }
  // list(): Array<ListeReservation> {
  //   this.reservations = this.resaService.findAll()
  //   return this.reservations;
  // }
  list(id:number): Detailresa {
   this.resaService.findById(id).subscribe(rep=>{
    this.reservations = rep
   })
    return this.reservations;
  }


 //navigator(){ 
 // [RouterLink]="['/nouvelResa', this.reservations]"
//        RouterLinkActive="active"
//this.router.navigate(['/nouvelResa', 43])
// }


}