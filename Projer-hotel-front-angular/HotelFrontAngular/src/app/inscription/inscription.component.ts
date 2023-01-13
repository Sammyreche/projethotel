import { Component } from '@angular/core';
import { Inscription } from '../models/inscription.models';
import { InscriptionService } from '../inscription/inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent {

  formInscription: Inscription = new Inscription();


constructor(public InscriptionService : InscriptionService){

}

  save(): void {
     this.InscriptionService.create(this.formInscription);
  }

}


