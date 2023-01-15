import { Component } from '@angular/core';

@Component({
  selector: 'app-edit-resa',
  templateUrl: './edit-resa.component.html',
  styleUrls: ['./edit-resa.component.css']
})
export class EditResaComponent {
editPassager : boolean = false
editActiviter : boolean = false
  handleSetAffichagePassager(){
    if (this.editPassager==false) {
      this.editPassager=true
    }else {
      this.editPassager=false
      if (this.editActiviter=true) {
        this.editActiviter=false
      }
    } 
  }
  handleSetAffichageActiviter(){
    if (this.editActiviter==false) {
      this.editActiviter=true
    }else this.editActiviter=false
  }
}
