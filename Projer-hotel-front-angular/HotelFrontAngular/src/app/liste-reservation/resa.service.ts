import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UUID } from 'angular2-uuid';
import { Observable, of } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { ListeReservation, PageReservation } from '../models/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class ResaService {
  serviceUrl! : string;
  reservations! : Array<ListeReservation>;
  
  result! : Observable<ListeReservation>;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "reservations/";
    this.load();
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

public getPageReservations(page :number,size : number) : Observable<PageReservation> {
  let index = page*size;
  let totalPages = ~~(this.reservations.length/size);
  if (this.reservations.length%size != 0) {
    totalPages++;
  }
  let PageReservations = this.reservations.slice(index,index+size);
  return of ({page:page,size:size,totalPages:totalPages,reservations : PageReservations});
}



search(kw : string) : void{
this.http.get <Array<ListeReservation>>(this.serviceUrl+"liste/search/" + kw).subscribe(response => {
  this.reservations = response;
  //console.log(this.reservations)
});
}

remove(id: number): void {
  this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
    this.load();
  });
}

//    remove(id: number): void {
//     console.log(id)
//      //console.log(this.findById(id))
//      if (this.findById(id)!=null) {
//        this.reservations.splice(this.reservations.indexOf(this.findById(id)),1)
//      }
// }

public load(): void {
  this.http.get<Array<ListeReservation>>(this.serviceUrl+"liste/").subscribe(response => {
    this.reservations = response;
    
  });
}
}
