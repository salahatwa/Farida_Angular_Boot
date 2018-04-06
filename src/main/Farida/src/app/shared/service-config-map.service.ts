import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Observable } from 'rxjs/Observable';

import { ServiceConfigMap } from '../models/service-config-map';

@Injectable()
export class ServiceConfigMapService {

  private baseUrl: String = 'http://localhost:8080/api';

  private headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json;' });
  private options = new RequestOptions({ headers: this.headers });

  private serviceConfigMap: ServiceConfigMap;



  constructor(private _http: Http) { }


  getServices(page: Number) {
    return this._http.get(this.baseUrl + '/serviceConfigMap/all?page=' + page, this.options).map((response: Response) => response.json())
      .catch(this.handleError);
  }

  deleteService(id: Number) {
    return this._http.delete(this.baseUrl + '/serviceConfigMap/' + id);
  }

  updateService(serviceConfigMap: ServiceConfigMap) {
    return this._http.put(this.baseUrl + '/serviceConfigMap', JSON.stringify(serviceConfigMap), this.options)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }


  createService(serviceConfigMap: ServiceConfigMap) {
    return this._http.post(this.baseUrl + '/serviceConfigMap', JSON.stringify(serviceConfigMap), this.options)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }


  setter(serviceConfigMap: ServiceConfigMap) {
    this.serviceConfigMap = serviceConfigMap;
  }

  getter() {
    return this.serviceConfigMap;
  }

  handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
  // JSON.stringify(serviceConfigMap)
}
