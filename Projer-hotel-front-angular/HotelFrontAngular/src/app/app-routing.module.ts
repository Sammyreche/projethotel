import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { DetailReservationComponent } from './detail-reservation/detail-reservation.component';
import { EditResaComponent } from './edit-resa/edit-resa.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ListeReservationComponent } from './liste-reservation/liste-reservation.component';

const routes: Routes = [
{path: "listeResa", component: ListeReservationComponent},
{path: "login",component: ConnexionComponent}];
{path: "editResa", component: EditResaComponent},
{path: "login",component: ConnexionComponent},
{path: "detailResa",component: DetailReservationComponent},
{path: "inscription",component: InscriptionComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
