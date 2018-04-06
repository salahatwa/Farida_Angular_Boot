import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Observable } from 'rxjs/Observable';
import { BusinessServiceStep } from '../models/business-service-step';

@Injectable()
export class BusinessServiceStepService {

  private baseUrl: String = 'http://localhost:8080/api';

  private headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json;' });
  private options = new RequestOptions({ headers: this.headers });

  private businessServiceStep: BusinessServiceStep;



  constructor(private _http: Http) { }


  getSteps(page: Number) {
    return this._http.get(this.baseUrl + '/step/all', this.options).map((response: Response) => response.json())
      .catch(this.handleError);
  }

  deleteStep(id: Number) {
    return this._http.delete(this.baseUrl + '/step/' + id);
  }

  updateStep(businessServiceStep: BusinessServiceStep) {
    return this._http.put(this.baseUrl + '/step', JSON.stringify(businessServiceStep), this.options)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }


  createStep(businessServiceStep: BusinessServiceStep) {
    return this._http.post(this.baseUrl + '/step', JSON.stringify(businessServiceStep), this.options)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }


  setter(businessServiceStep: BusinessServiceStep) {
    this.businessServiceStep = businessServiceStep;
  }

  getter() {
    return this.businessServiceStep;
  }

  handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

}
