import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Service } from '../models/service';

@Injectable()
export class TodoService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  getTodos():  Promise<Service[]> {
    return this.http.get(this.baseUrl + '/api/services/')
      .toPromise()
      .then(response => response.json() as Service[])
      .catch(this.handleError);
  }

  createTodo(todoData: Service): Promise<Service> {
    console.log(todoData);
    return this.http.post(this.baseUrl + '/api/service', todoData)
      .toPromise().then(response => response.json() as Service)
      .catch(this.handleError);
  }

  updateTodo(todoData: Service): Promise<Service> {
    return this.http.put(this.baseUrl + '/api/service', todoData)
      .toPromise()
      .then(response => response.json() as Service)
      .catch(this.handleError);
  }

  deleteTodo(id: string): Promise<any> {
    return this.http.delete(this.baseUrl + '/api/service/' + id)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
