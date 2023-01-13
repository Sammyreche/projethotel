import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Inscription } from '../models/inscription.models';

@Injectable({
  providedIn: 'root'
})

export class InscriptionService {
  serviceUrl! : string;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService) {

    this.serviceUrl = appConfig.backEndUrl + "inscription";
    //this.load();
   }


     create(inscription: Inscription): void {
      this.http.put<Inscription>(this.serviceUrl, inscription).subscribe(resp => {
        console.log(inscription)
       });
    }


}
