import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ServiceConfigMap } from '../../models/service-config-map';

@Component({
  selector: 'app-service-delete',
  templateUrl: './service-delete.component.html',
  styleUrls: ['./service-delete.component.css']
})
export class ServiceDeleteComponent {

  // that's variable that will be received
  @Input() service: ServiceConfigMap;

  @Output() deleteService = new EventEmitter<ServiceConfigMap>();

  modalDailog: NgbModalRef;

  constructor(private modalService: NgbModal) { }

  delete(service) {
    this.deleteService.emit(service);
    this.closeDailog();

  }

  openDailog(content: any) {
    this.modalDailog = this.modalService.open(content);
  }

  closeDailog() {
    this.modalDailog.close();
  }


}
