import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListeReservationComponent } from './liste-reservation/liste-reservation.component';
import { DetailReservationComponent } from './detail-reservation/detail-reservation.component';
import { EditResaComponent } from './edit-resa/edit-resa.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { InscriptionService } from './inscription/inscription.service';
import { ResaService } from './liste-reservation/resa.service';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';


@NgModule({
  declarations: [
    AppComponent,
    ListeReservationComponent,
    DetailReservationComponent,
    EditResaComponent,
    NavBarComponent,
    ConnexionComponent,
    InscriptionComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserModule,
    HttpClientModule 
    
  ],
  providers: [InscriptionService,ResaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
