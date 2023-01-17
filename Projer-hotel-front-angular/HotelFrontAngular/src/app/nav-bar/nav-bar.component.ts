import { Component } from '@angular/core';
import { ConnexionService } from '../connexion/connexion.service';
import { Compte } from '../models/compte.model';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})

export class NavBarComponent {
connectedCompte : Compte
constructor(public connexionService : ConnexionService){
  this.connectedCompte = connexionService.compteConnecte
}

logout(){
  console.log("ok")
  this.connexionService.logout()
}
}
