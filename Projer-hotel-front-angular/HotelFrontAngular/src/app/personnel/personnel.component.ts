import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Compte, Personnel } from '../models/compte.model';
import { PersonnelHttpService } from './personnel-http.service';

@Component({
  selector: 'app-personnel',
  templateUrl: './personnel.component.html',
  styleUrls: ['./personnel.component.css']
})
export class PersonnelComponent {
personnel! : Personnel;
personnels: Array<Personnel>;
constructor(private personnelService : PersonnelHttpService){
  //  this.load()
   this.personnelService.load()

}

// ngOninit(){
//   this.load()
// }

  // load(): void {
  //  this.personnelService.load()
  // }

 list() {
   return  this.personnelService.personnels
 }

add():void {
  this.personnel = new Personnel();
  this.personnelService.create(this.personnel)
}


 edit(id: number): void {
   this.personnelService.findById(id).subscribe(response => {
    this.personnel = response});
 }

save(): void {
  if(this.personnel.id) {
    this.personnelService.update(this.personnel);
  } else {
    this.personnelService.create(this.personnel);
    // this.load();
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
