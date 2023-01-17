import { Component } from '@angular/core';


import { InscriptionService } from '../inscription/inscription.service';
import { ConnexionService } from '../connexion/connexion.service';
import { Client } from '../models/compte.model';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent {

  formInscription: Client= new Client ;


constructor(public InscriptionService : InscriptionService,
  public connexionService : ConnexionService){

}

  save(): void {
    console.log(this.formInscription)
     this.InscriptionService.create(this.formInscription);
  }

}


