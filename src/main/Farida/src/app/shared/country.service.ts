import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CountryService {
  private baseUrl:String="http://localhost:8080";

  constructor(private _http:HttpClient) { }


  getCountries(page:Number)
  {
    return this._http.get(this.baseUrl+"/api/countries?page="+page);
  }

}
