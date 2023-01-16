import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Client } from '../models/compte.model';


@Injectable({
  providedIn: 'root'
})

export class InscriptionService {
  serviceUrl! : string;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService) {

    this.serviceUrl = appConfig.backEndUrl + "inscription";
    //this.load();
   }


     create(inscription: Client): void {
      console.log(inscription)
      this.http.put<Client>(this.serviceUrl, inscription).subscribe(resp => {
        console.log(inscription)
       });
    }


}
