import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { HttpClient } from '@angular/common/http';
import { Detailresa } from '../models/detailresa.model';
import { Client, Compte } from '../models/compte.model';
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

      create(reservation: Detailresa, Id_Compte : number): void {
      this.http.post<Detailresa>(this.serviceUrl+"/biss/"+Id_Compte, reservation).subscribe(resp => {
        console.log(reservation)
       });
    }

    listeClient():Observable<Array<Client>>{
      
       this.http.get<Array<Client>>(this.appConfig.backEndUrl+"list/client").subscribe(resp => {
        this.comptesClient = resp
        console.log(resp)
       });
       return null
    }
}
