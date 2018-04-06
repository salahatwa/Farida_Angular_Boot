import { Component, OnInit } from '@angular/core';
import { ServiceConfigMapService } from '../../shared/service-config-map.service';
import { ServiceConfigMap } from '../../models/service-config-map';
import { Operation } from '../../utils/operation.enum';


@Component({
  selector: 'app-service-config-map',
  templateUrl: './service-config-map.component.html',
  styleUrls: ['./service-config-map.component.css']
})
export class ServiceConfigMapComponent implements OnInit {

  page: Number = 0;
  services: Array<any>;
  pages: Array<Number>;

  numOfServices: Number;
  numOfPages: Number;


  constructor(private _servicConfigMapService: ServiceConfigMapService) { }

  ngOnInit() {
    this.getServices();
  }


  getServices() {
    this._servicConfigMapService.getServices(this.page).subscribe(
      (data) => {
        console.log(data);

        this.services = data['content'];
        this.numOfPages = data['totalPages'];
        this.pages = new Array(this.numOfPages);
        this.numOfServices = data['totalElements'];
      }, (error) => {
        console.log(error.error.message);
      }
    );
  }

  createService() {
    return new ServiceConfigMap();
  }


  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.getServices();
  }


  deleteService(service) {
    this._servicConfigMapService.deleteService(service.id).subscribe((data) => {
      this.services.splice(this.services.indexOf(service), 1);
    }, (error) => {
      console.log(error);
    });
  }

  getOperation(operation: String) {
    return operation;
  }
}
