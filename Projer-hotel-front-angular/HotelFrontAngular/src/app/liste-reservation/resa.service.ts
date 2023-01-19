import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { UUID } from 'angular2-uuid';
import { Observable, of } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { ConnexionService } from '../connexion/connexion.service';
import { ListeReservation, PageReservation } from '../models/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class ResaService  {
  serviceUrl! : string;
  reservations : Array<ListeReservation> = null
  premiereConnection : boolean =true
  
  result! : Observable<ListeReservation>;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService, private connexionService :ConnexionService) {
    this.serviceUrl = appConfig.backEndUrl + "reservations/";
  // this.reservations = [{"id":1,"dateDebut_resa":"2022-01-13","dateFin_resa":"2022-11-12","nom":"lam","prenom":"omar","email":"client@ client","telephone":"1111111","naissance":"2023-01-12","nombrePassager":1}]
  // for (let index = 2; index < 10; index++) {
  //   this.reservations.push({"id":index,"dateDebut_resa":"2022-01-11","dateFin_resa":"2022-11-12","nom":"lam","prenom":"omar","email":"client@ client","telephone":"1111111","naissance":"2023-01-12","nombrePassager":1})
  //       }
   }

//    public findAll() { return this.http
//     .get('http://localhost:8080/api/client')
//     .subscribe(resp => this.clients = resp.json());
// }

//    findById(id: number): Observable<ListeReservation> {
//     this.reservations.forEach(c => {
//       console.log(c.id)
//         if (c.id == id) {
//           this.result= c;
//         }else return null;
//       });
//       return this.result;
// }

findById(id: number): Observable<ListeReservation> {
  return this.http.get<ListeReservation>(this.serviceUrl+"liste/" + id);
}

findAll(): Array<ListeReservation> {
  
  return this.reservations;
}



search(kw : string) : Observable<boolean> {
  return new Observable<boolean>(observer => {
    this.http.get <Array<ListeReservation>>(this.serviceUrl+"liste/search/" + kw).subscribe(response => {
      this.reservations = response;
      observer.next(true);
      //console.log(this.reservations)
    });
  });
}

remove(id: number): Observable<boolean> {
  return new Observable<boolean>(observer => {
  this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
    this.load();
    observer.next(true);
  });
});
}

//    remove(id: number): void {
//     console.log(id)
//      //console.log(this.findById(id))
//      if (this.findById(id)!=null) {
//        this.reservations.splice(this.reservations.indexOf(this.findById(id)),1)
//      }
// }

public getPageReservations(page :number,size : number) : Observable<PageReservation> {
  let index = page*size;
  let totalPages = ~~(this.reservations?.length/size);
  if (this.reservations.length%size != 0) {
    totalPages++;
  }
  let PageReservations = this.reservations.slice(index,index+size);
  return of ({page:page,size:size,totalPages:totalPages,reservations : PageReservations});
} 




public load(): Observable<boolean> {
  return new Observable<boolean>(observer => {
    if (this.connexionService.compteConnecte) {
      if (this.connexionService.compteConnecte.className=="Client") {
        this.http.get<Array<ListeReservation>>(this.serviceUrl+"liste/client/"+this.connexionService.compteConnecte.id).subscribe(response => {
          this.reservations = response;
          observer.next(true);
      });} 
      else if(this.connexionService.compteConnecte.className=="Personnel" || this.connexionService.compteConnecte.className=="Admin"){
        {
          this.http.get<Array<ListeReservation>>(this.serviceUrl+"liste/").subscribe(response => {
            this.reservations = response;
            observer.next(true);
            // console.log(response)
          });}
      }
    }else
    
    this.reservations=[];
    observer.next(false);
    });
  }


// if (this.connexionService.compteConnecte.className=="Client") {
//   this.http.get<Array<ListeReservation>>(this.serviceUrl+"liste/client/"+this.connexionService.compteConnecte.id).subscribe(response => {
//     this.reservations = response
// } }





// if (this.connexionService.compteConnecte.className!="Client"){
//   this.http.get<Array<ListeReservation>>(this.serviceUrl+"liste/").subscribe(response => {
//     this.reservations = response;
//     console.log(response)
//   });}
 }