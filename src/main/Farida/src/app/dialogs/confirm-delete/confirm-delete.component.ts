import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Country } from '../../models/country';

@Component({
  selector: 'app-confirm-delete',
  templateUrl: './confirm-delete.component.html',
  styleUrls: ['./confirm-delete.component.css']
})
export class ConfirmDeleteComponent {

  // that's variable that will be received
  @Input() country: Country;

  @Output() deleteCountry = new EventEmitter<Country>();

  modalDailog: NgbModalRef;

  constructor(private modalService: NgbModal) { }

  delete(country) {
    this.deleteCountry.emit(country);
    this.closeDailog();

  }

  openDailog(content: any) {
    this.modalDailog = this.modalService.open(content);
  }

  closeDailog() {
    this.modalDailog.close();
  }


}
