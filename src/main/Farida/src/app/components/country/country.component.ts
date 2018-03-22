import { Component, OnInit } from '@angular/core';
import { CountryService } from '../../shared/country.service';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {

  private page:Number=0;
  private countries:Array<any>;
  private pages:Array<Number>;

  constructor(private _countryService:CountryService) { }

  ngOnInit() {
    this.getCountries();
  }


  getCountries()
  {
    this._countryService.getCountries(this.page).subscribe(
      data=>{
        console.log(data);
        this.countries=data['content'];
        this.pages=new Array(data['totalPages']);
      },(error)=>{console.log(error.error.message);}
    );
  }


  setPage(i,event:any)
  {
    event.preventDefault();
    this.page=i;
    this.getCountries();
  }
}