import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Compte } from '../models/compte.model';

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {

  serviceUrl: string;
  compteConnecte: Compte = JSON.parse(sessionStorage.getItem('connected'));

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "login/";
  }


  findByLoginAndPassword(login: string, password: string): Observable<Compte> {
    let authDTO: Object = {login: login, password: password};
    return this.http.post<Compte>(this.serviceUrl , authDTO);
  }

  logout(){
    if (typeof sessionStorage != 'undefined') {
      sessionStorage.clear();
      this.compteConnecte=undefined
    }
    else {
      // localStorage est indisponible
    }
  }
  // compteEnregister(login: string, password: string){
  //   this.findByLoginAndPassword(login, this.password).subscribe(resp=>{
  //     this.compteConnecte =resp;
  //   }) 
  // }

}
