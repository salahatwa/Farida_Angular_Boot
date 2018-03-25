import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { AppComponent } from './app.component';
import { CountryComponent } from './components/country/country.component';
import { CountryService } from './shared/country.service';
import { ConfirmDeleteComponent } from './dialogs/confirm-delete/confirm-delete.component';
import { UpdateCountryComponent } from './dialogs/update-country/update-country.component';

// Format code using Ctrl + Shift + i
// For modal PopUp modal : npm install --save @ng-bootstrap/ng-bootstrap

@NgModule({
  declarations: [
    AppComponent,
    CountryComponent,
    ConfirmDeleteComponent,
    UpdateCountryComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    NgbModule.forRoot()
  ],
  providers: [CountryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
