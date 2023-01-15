import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { HttpClient } from '@angular/common/http';
import { Detailresa } from '../models/detailresa.model';
import { Compte } from '../models/compte.model';

@Injectable({
  providedIn: 'root'
})
export class NouvellReservationService {
  serviceUrl! : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
        this.serviceUrl = appConfig.backEndUrl + "reservations";
   }

      create(reservation: Detailresa, Id_Compte : number): void {
      this.http.post<Detailresa>(this.serviceUrl+"/biss/"+Id_Compte, reservation).subscribe(resp => {
        console.log(reservation)
       });
    }
}
