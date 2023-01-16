import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Personnel } from '../models/compte.model';

@Injectable({
  providedIn: 'root'
})
export class PersonnelHttpService {
  serviceUrl! : string;
  personnels: Array<Personnel> = new Array<Personnel>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "list/";}

   findAll(): Array<Personnel> {
     return this.personnels;
   }



findById(id: number) : Observable <Personnel> {
  return this.http.get<Personnel>(this.serviceUrl+"personnel/" + id);
}

create(personnel: Personnel): void {
  let maxId = 0;

  this.personnels.forEach(pers => {
    if(pers.id > maxId) {
      maxId = pers.id;
    }
  });
  personnel.id = maxId + 1;

  this.personnels.push(personnel);
}

update(personnel: Personnel): void {
  let idx: number;

  idx = this.personnels.findIndex(pers => pers.id == personnel.id);

  this.personnels[idx] = personnel;
}

remove(id: number): void {
  let idx: number = this.personnels.findIndex(pers => pers.id == id);

  this.personnels.splice(idx, 1);
}

// remove(id: number): void {
//   this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
//     this.load();
//   });

}
