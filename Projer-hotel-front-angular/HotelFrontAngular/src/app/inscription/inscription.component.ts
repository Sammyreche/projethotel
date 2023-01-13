import { Component } from '@angular/core';

import { InscriptionService } from '../inscription/inscription.service';
import { Inscription } from '../models/inscription.models';

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


