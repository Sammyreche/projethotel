import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListeReservationComponent } from './liste-reservation/liste-reservation.component';
import { DetailReservationComponent } from './detail-reservation/detail-reservation.component';


@NgModule({
  declarations: [
    AppComponent,
    ListeReservationComponent,
    DetailReservationComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserModule,
    HttpClientModule 
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
