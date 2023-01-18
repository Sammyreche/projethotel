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
      switch (resp.className) {
        case 'Admin': alert("connection admin ok ; mais pas encore page admin"); this.router.navigate(['listeResa']) ; break;
        case 'Client':  this.router.navigate(['listeResa']) ; break;
        case 'personel': this.router.navigate(['listeResa']) ; break;
      }
    });
  }


}

