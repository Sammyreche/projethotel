import { HttpClient } from "@angular/common/http";
import { Component, Injectable } from "@angular/core";
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

  
  constructor(public resaService : resaDetailHttpService ){
   // this.reservations = this.resaService.reservations;
  //  this.reservations.passagers = new Array<Passager>()
  }

 ngOnInit():void{
   this.resaService.load(5).subscribe(rep=>{
    this.reservations =rep
    console.log(rep)
  })
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
}