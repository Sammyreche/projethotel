import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { DetailReservationComponent } from './detail-reservation/detail-reservation.component';
import { EditResaComponent } from './edit-resa/edit-resa.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ListeReservationComponent } from './liste-reservation/liste-reservation.component';
import { NouvelleReservationComponent } from './nouvelle-reservation/nouvelle-reservation.component';
import { PersonnelComponent } from './personnel/personnel.component';

const routes: Routes = [
{path: "", component: HomeComponent, pathMatch: 'full'},
{path: "listeResa", component: ListeReservationComponent},
{path: "home", component: HomeComponent},
{path: "editResa", component: EditResaComponent},
{path: "login",component: ConnexionComponent},
{path: "detailResa",component: DetailReservationComponent},
{path: "inscription",component: InscriptionComponent},
{path: "nouvelResa",component: NouvelleReservationComponent},
{path: "nouvelResa/:id",component: NouvelleReservationComponent},
{path: "personnel",component: PersonnelComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
