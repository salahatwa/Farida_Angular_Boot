import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ServiceConfigMap } from '../../models/service-config-map';
import { BusinessServiceConfig } from '../../models/business-service-config';
import { ServiceConfigMapService } from '../../shared/service-config-map.service';
import { OfferedServiceTypeService } from '../../shared/offered-service-type.service';
import { BusinessServiceConfigService } from '../../shared/business-service-config.service';
import { OfferedServiceType } from '../../models/offered-service-type';
import { BusinessServiceStep } from '../../models/business-service-step';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {

  // that's variable that will be received
  @Input() service: ServiceConfigMap;

  serviceConfigMap: ServiceConfigMap;

  businessServiceConfig: BusinessServiceConfig;
  steps: Array<BusinessServiceStep>;

  @Input() operation: String;

  @Output() updateModel = new EventEmitter<ServiceConfigMap>();

  servicesTypes: Array<OfferedServiceType>;


  constructor(private _serviceConfigMapService: ServiceConfigMapService, private _serviceConfig: BusinessServiceConfigService,
    private _serviceType: OfferedServiceTypeService) {
    this.serviceConfigMap = new ServiceConfigMap();
  }

  ngOnInit() {

    this.getServiceTypes();
    if (this.operation === 'CREATE') {
      this.serviceConfigMap = new ServiceConfigMap();
      this.businessServiceConfig = new BusinessServiceConfig();
    } else if (this.operation === 'UPDATE') {
      this.serviceConfigMap = this.service;
      this.getBusinessServiceConfig();
    }

  }

  getBusinessServiceConfig() {
    return this._serviceConfig.getBussinessServiceConfig(this.serviceConfigMap.id).subscribe(
      (data) => {
        console.log(data);
        this.businessServiceConfig = data;
        this.steps = this.businessServiceConfig.steps;
        console.log(JSON.stringify(this.steps));
      }, (error) => {
        console.log(error.error.message);
      }
    );
  }
  getServiceTypes() {
    return this._serviceType.getServiceTypes().subscribe(
      (data) => {
        console.log(data);
        this.servicesTypes = data;
      }, (error) => {
        console.log(error.error.message);
      }
    );
  }


  processForm() {


    if (this.operation === 'UPDATE') {
      this._serviceConfigMapService.updateService(this.serviceConfigMap).subscribe(
        (data) => {
          console.log(data);
        }, (error) => {
          console.log(error.error.message);
        }
      );
    } else {
      this._serviceConfigMapService.createService(this.serviceConfigMap).subscribe(
        (data) => {
          console.log(data);
        }, (error) => {
          console.log(error.error.message);
        }
      );
    }

    this.updateModel.emit(this.service);

    console.log('Finished....................');
  }

  get currentService() { return JSON.stringify(this.serviceConfigMap); }
}
