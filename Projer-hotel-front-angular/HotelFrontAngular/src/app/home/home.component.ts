import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConnexionService } from '../connexion/connexion.service';
// import { convertJsToTs, convertJsToTsSync } from 'js-to-ts-converter';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  etat = "off";
connectedCompte = this.connexionService.compteConnecte;
newsLetter :string;

constructor(public connexionService: ConnexionService,private route: ActivatedRoute,
  private router: Router){
//   convertJsToTs( './script_test.js' ).then(
//     () => console.log( 'Done!' ),
//     ( err ) => console.log( 'Error: ', err )
// )
}
  ngOnInit(): void {
    window.addEventListener("scroll", () => {
      if (window.pageYOffset > 1) {
       // this.offset = true;
        document.getElementById("navbar").style.backgroundColor =
          "rgba(241, 215, 195)";
      } else if (window.pageYOffset < 1 && this.etat == "off") {
       // this.offset = false;
        document.getElementById("navbar").style.backgroundColor =
          "rgba(241, 215, 195,0)";
      }
    });
  }


  offset: boolean = true;

ChangeBackgroundColorNav() {
  if (this.etat == "off") {
    document.getElementById("navbar").style.backgroundColor =
      "rgba(241, 215, 195)";
    this.etat = "on";
  } else if (this.etat == "on") {
    document.getElementById("navbar").style.backgroundColor =
      "rgba(241, 215, 195,0)";
    this.etat = "off";
  }
}

changeColorMouse(x : any) {
  x.style.backgroundColor = "#ffffff";
}
changeColorMouseBack(x : any) {
  x.style.backgroundColor = "#f1d7c3";
}
// $.fn.datepicker.dates["fr"] = {
//   days: [
//     "Lundi",
//     "Mardi",
//     "Mercredi",
//     "Jeudi",
//     "Vendredi",
//     "Samedi",
//     "Dimanche",
//   ],
//   daysShort: ["Lan", "Mar", "Mer", "Jeu", "Vend", "Sam", "Dim"],
//   daysMin: ["L", "M", "Me", "J", "V", "S", "D"],
//   months: [
//     "Janvier",
//     "Février",
//     "Mars",
//     "Avril",
//     "Mai",
//     "Juin",
//     "Juillet",
//     "Aout",
//     "Septembre",
//     "Octobre",
//     "Novembre",
//     "Décembre",
//   ],
//   monthsShort: [
//     "Jan",
//     "Fév",
//     "Mar",
//     "Avr",
//     "Mai",
//     "Juin",
//     "Juil",
//     "Aou",
//     "Sep",
//     "Oct",
//     "Nov",
//     "Dec",
//   ],
//   today: "Today",
//   clear: "Clear",
//   format: "dd/mm/yyyy",
//   titleFormat: "MM yyyy" /* Leverages same syntax as 'format' */,
//   weekStart: 0,
// };
// $("#dateArv")
//   .datepicker({
//     startDate: "Today",
//     todayHighlight: true,
//     autoclose: true,
//     language: "fr",
//   })
//   .on("changeDate", function (e) {
//     $("#dateDep").datepicker("setStartDate", e.date);
//     $("#dateDep").focus();
//   });
// $("#dateDep").datepicker({
//   todayHighlight: true,
//   autoclose: true,
//   language: "fr",
// });
 
//nav = document.querySelector("nav");



affichagePlus() {
  console.log("affichage plus")
  document.getElementById("equipe").style.display = "flex";
  document.getElementById("plus").style.display = "none";
  document.getElementById("moins").style.display = "flex";
}
affichageMoins() {
  document.getElementById("equipe").style.display = "none";
  document.getElementById("plus").style.display = "flex";
  document.getElementById("moins").style.display = "none";
}

toNavig(){
  if (this.connectedCompte) {
    this.router.navigate(['/listeResa'])
  }else
  this.router.navigate(['/login'])
}
// *ngIf="connectedCompte : [routerLink]="['/nouvelResa']" "

alertNews() {
  this.newsLetter=""
  alert("Vous êtes maintenant inscrit à notre newsletter.")
}

}
