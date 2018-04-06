import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Observable } from 'rxjs/Observable';

import { ServiceConfigMap } from '../models/service-config-map';

@Injectable()
export class OfferedServiceTypeService {


  private baseUrl: String = 'http://localhost:8080/api';

  private headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json;' });
  private options = new RequestOptions({ headers: this.headers });

  constructor(private _http: Http) { }

  getServiceTypes() {
    return this._http.get(this.baseUrl + '/service/types', this.options).map((response: Response) => response.json())
      .catch(this.handleError);
  }

  handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }


}
