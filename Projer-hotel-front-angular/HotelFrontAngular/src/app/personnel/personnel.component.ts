import { Component } from '@angular/core';
import { Compte, Personnel } from '../models/compte.model';
import { PersonnelHttpService } from './personnel-http.service';

@Component({
  selector: 'app-personnel',
  templateUrl: './personnel.component.html',
  styleUrls: ['./personnel.component.css']
})
export class PersonnelComponent {
personnel: Personnel = new Personnel();
compte: Compte;
personnels: Array<Personnel> = [];

constructor(private personnelService : PersonnelHttpService){
  this.personnels = this.personnelService.personnels

}

list(): Array<Personnel> {
  return this.personnelService.findAll();
}

add():void {
  this.personnel = new Personnel();
}


// edit(id: number): void {
//   this.personnel = {...this.personnelService.findById(id)};
// }

save(): void {
  if(this.personnel.id) {
    this.personnelService.update(this.personnel);
  } else {
    this.personnelService.create(this.personnel);
  }

  this.cancel();
}

cancel(): void {
  this.personnel = null;
}

remove(id: number): void {
  this.personnelService.remove(id);
}

}
