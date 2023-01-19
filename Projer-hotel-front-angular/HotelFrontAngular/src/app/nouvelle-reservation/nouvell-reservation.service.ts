import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { HttpClient } from '@angular/common/http';
import { Detailresa } from '../models/detailresa.model';
import { Client, Compte, Passager } from '../models/compte.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NouvellReservationService {
  serviceUrl! : string;
  comptesClient : Array<Client> 

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
        this.serviceUrl = appConfig.backEndUrl + "reservations";
        this.listeClient()
   }

    //   create(reservation: Detailresa, Id_Compte : number): void {
    //   this.http.post<Detailresa>(this.serviceUrl+"/biss/"+Id_Compte, reservation).subscribe(resp => {
    //     console.log(reservation)
    //    });
    // }


    create(reservation: Detailresa, Id_Compte : number): Observable<boolean> {
      return new Observable<boolean>(observer => {
      this.http.post<Detailresa>(this.serviceUrl+"/biss/"+Id_Compte, reservation).subscribe(resp => {
        console.log(reservation)
        observer.next(true);
       });
      });
    }




// search(kw : string) : Observable<boolean> {
//   return new Observable<boolean>(observer => {
//     this.http.get <Array<ListeReservation>>(this.serviceUrl+"liste/search/" + kw).subscribe(response => {
//       this.reservations = response;
//       observer.next(true);
//       //console.log(this.reservations)
//     });
//   });
// }









    listeClient():Observable<Array<Client>>{
      
       this.http.get<Array<Client>>(this.appConfig.backEndUrl+"list/client").subscribe(resp => {
        this.comptesClient = resp
        console.log(resp)
       });
       return null
    }
    supprimerPassager(id_passager : number){
    this.http.delete<Passager>(this.serviceUrl+"/passager/"+id_passager).subscribe(resp => {
      console.log("supression Ok")
     });
    }
}
