import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConnexionService } from './connexion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent {
  login: string;
  password: string;
  compteinexistant : boolean =false;

  constructor(private connexionService: ConnexionService,  private router: Router, private route: ActivatedRoute){
    this.route.queryParams.subscribe(params => {
      this.login = params['username'];
      });
      
  }

  auth(): void {
    this.connexionService.findByLoginAndPassword(this.login, this.password).subscribe(resp => {
      this.connexionService.compteConnecte = resp;
      sessionStorage.setItem('connected',JSON.stringify(structuredClone(resp)))
      console.log(this.connexionService.compteConnecte)
      if(this.connexionService.compteConnecte==null){
        // alert("login ou mot de passe incorrect")
        this.compteinexistant=true
        return
      }
      this.compteinexistant=false;
      switch (resp.className) {
        case 'Admin': ; this.router.navigate(['listeResa']) ; break;
        case 'Client':  this.router.navigate(['listeResa']) ; break;
        case 'Personnel': this.router.navigate(['listeResa']) ; break;
      }
    });
  }


}

