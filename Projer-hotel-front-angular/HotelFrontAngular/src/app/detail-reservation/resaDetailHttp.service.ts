import { HttpClient } from '@angular/common/http';
import { Component, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Detailresa } from '../models/detailresa.model';

@Injectable({
  providedIn: 'root'
})
export class resaDetailHttpService {
  serviceUrl! : string;
  reservations! :Detailresa;
 
  

  
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "reservations/";
    this.load(1);
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


public load(id?:number ): Observable<Detailresa> {
  return this.http.get<Detailresa>(this.serviceUrl+id+"/detail")

}

findById(id: number): Observable<Detailresa> {
  return this.http.get<Detailresa>(this.serviceUrl+ id+"/detail");
}








//    remove(id: number): void {
//     console.log(id)
//      //console.log(this.findById(id))
//      if (this.findById(id)!=null) {
//        this.reservations.splice(this.reservations.indexOf(this.findById(id)),1)
//      }
// }




}
