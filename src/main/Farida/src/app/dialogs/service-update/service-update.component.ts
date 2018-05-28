import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ServiceConfigMap } from '../../models/service-config-map';
import { Operation } from '../../utils/operation.enum';
import { ServiceConfigMapService } from '../../shared/service-config-map.service';
import { BusinessServiceConfig } from '../../models/business-service-config';

@Component({
  selector: 'app-service-update',
  templateUrl: './service-update.component.html',
  styleUrls: ['./service-update.component.css']
})
export class ServiceUpdateComponent {

  // that's variable that will be received
  @Input() service: ServiceConfigMap;

  @Input() operation: String;


  modalDailog: NgbModalRef;

  constructor(private modalService: NgbModal, private _serviceConfigMapService: ServiceConfigMapService) {

    if (this.service === undefined) {
      this.service = new ServiceConfigMap();
      this._serviceConfigMapService.setter(this.service);
    }
  }

  updateModel(service) {
    this.closeDailog();
  }

  openDailog(content: any) {
    this.modalDailog = this.modalService.open(content);
  }

  closeDailog() {
    this.modalDailog.close();
  }

}
