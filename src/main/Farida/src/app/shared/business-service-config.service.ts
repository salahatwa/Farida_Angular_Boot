import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Observable } from 'rxjs/Observable';

import { ServiceConfigMap } from '../models/service-config-map';
import { BusinessServiceConfig } from '../models/business-service-config';


@Injectable()
export class BusinessServiceConfigService {

  private baseUrl: String = 'http://localhost:8080/api';

  private headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json;' });
  private options = new RequestOptions({ headers: this.headers });

  constructor(private _http: Http) { }

  getBussinessServiceConfig(id: Number) {
    return this._http.get(this.baseUrl + '/config/' + id, this.options)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }

  createBussinessServiceConfig(businessConfig: BusinessServiceConfig) {
    return this._http.post(this.baseUrl + '/config', JSON.stringify(businessConfig), this.options)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }

  handleError(error: Response) {
    console.error('Error *_*: ' + error);
    return Observable.throw(error.json() || 'Server error');
  }
}
