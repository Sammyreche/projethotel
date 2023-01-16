import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { HttpClient } from '@angular/common/http';
import { Detailresa } from '../models/detailresa.model';

@Injectable({
  providedIn: 'root'
})
export class NouvellReservationService {
  serviceUrl! : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
        this.serviceUrl = appConfig.backEndUrl + "reservations";
   }

      create(reservation: Detailresa): void {
      this.http.post<Detailresa>(this.serviceUrl+"/bis", reservation).subscribe(resp => {
        console.log(reservation)
       });
    }
}
