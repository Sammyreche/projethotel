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
  personnel: Personnel;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "list/personnel";}

findAll(): Observable<Array<Personnel>> {
    return this.http.get<Array<Personnel>>(this.serviceUrl) }


findById(id: number) : Observable<Personnel> {
  return this.http.get<Personnel>(this.serviceUrl+"/" + id);
}

create(personnel: Personnel): void {
  personnel.className="Personnel";
  this.http.post<Personnel>(this.serviceUrl, personnel).subscribe(resp => {
    this.load();
  });
}

update(personnel: Personnel): void {
  this.http.put<Personnel>(this.serviceUrl +"/"+ personnel.id, personnel).subscribe(resp => {
    this.load();
  });
}

remove(id: number): void {
  this.http.delete<void>(this.serviceUrl +"/"+ id).subscribe(resp => {
    this.load();
  });
}

load(): void {
  this.http.get<Array<Personnel>>(this.serviceUrl).subscribe(response => {
    this.personnels = response;
  });
 }

}
