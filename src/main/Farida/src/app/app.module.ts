import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';


import { AppComponent } from './app.component';
import { CountryComponent } from './components/country/country.component';
import { CountryService } from './shared/country.service';


@NgModule({
  declarations: [
    AppComponent,
    CountryComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule
  ],
  providers: [CountryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
