import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { ConnexionService } from '../connexion/connexion.service';
import { Client } from '../models/compte.model';


@Injectable({
  providedIn: 'root'
})

export class InscriptionService {
  serviceUrl! : string;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService, private router:Router, private connexionService: ConnexionService) {

    this.serviceUrl = appConfig.backEndUrl + "inscription";
    //this.load();
   }


     create(inscription: Client): void {
      console.log(inscription)
      this.http.put<Client>(this.serviceUrl, inscription).subscribe(resp => {
        console.log(inscription);
      if (this.connexionService.compteConnecte) {
        this.router.navigate(['listeResa']);
      }
      else
        this.router.navigate(['login'], { queryParams :{'username': inscription.login}});
       });
       
    }


}
