import { Component, OnInit, Input } from '@angular/core';
import { NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ServiceConfigMap } from '../../models/service-config-map';
import { BusinessServiceStep } from '../../models/business-service-step';
import { BusinessServiceConfigService } from '../../shared/business-service-config.service';
import { BusinessServiceConfig } from '../../models/business-service-config';
import { TodoService } from '../../Todo/todo.service';
import { Service } from '../../models/service';
import { BusinessServiceStepService } from '../../shared/business-service-step.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-service-steps',
  templateUrl: './service-steps.component.html',
  styleUrls: ['./service-steps.component.css']
})
export class ServiceStepsComponent implements OnInit {

  // that's variable that will be received
  @Input() service: ServiceConfigMap;

  modalDailog: NgbModalRef;


  steps: Array<BusinessServiceStep> = [];

  businessServiceConfig: BusinessServiceConfig;

  businessServiceStep: BusinessServiceStep = new BusinessServiceStep();

  services: Service[];

  selectedValue: string;

  constructor(private modalService: NgbModal, private _serviceConfig: BusinessServiceConfigService,
    private todoService: TodoService, private _stepService: BusinessServiceStepService) { }

  ngOnInit() {
    this.getSteps();
  }


  getSteps() {
    return this._serviceConfig.getBussinessServiceConfig(this.service.id).subscribe(
      (data) => {
        console.log('Config Exist ' + JSON.stringify(data));
        this.businessServiceConfig = data;
        this.steps = this.businessServiceConfig.steps;
        console.log(JSON.stringify(this.steps));
      }, (error) => {
        console.log(error.error.message);
      }
    );
  }

  createConfig() {
    this._serviceConfig.createBussinessServiceConfig(this.businessServiceConfig).subscribe(
      (data) => { this.businessServiceConfig = data; }, (error) => { console.log(error); });
  }

  openDailog(content: any) {
    this.modalDailog = this.modalService.open(content);
  }

  closeDailog() {
    this.modalDailog.close();
  }

  deleteStep(id: Number) {
    console.log('delete step:' + id);
    this._stepService.deleteStep(id)
      .then(() => {
        this.steps = this.steps.filter(todo => todo.id !== id);
      });
  }

  editStep(step: BusinessServiceStep) {
    console.log('KKKKKKKKKKKKKKKKKKKKKKKKKKKK:' + step);
  }

  addStep() {
    if (!this.businessServiceConfig) {
      console.log('Creating Config >>>>>>>>>>>>>>>>');
      this.businessServiceConfig = new BusinessServiceConfig();
      this.businessServiceConfig.name = this.service.name + ' Config';
      this.businessServiceConfig.businessServiceType = this.service;
      // this.businessServiceConfig.segmentationType=3;
      this.createConfig();
    }
    this.businessServiceStep.businessServiceConfig = this.businessServiceConfig;
    console.log(JSON.stringify(this.businessServiceStep));
    this._stepService.createStep(this.businessServiceStep).subscribe(
      (data) => {
        this.steps.push(data);
      }, (error) => { console.log(error); });
  }


  // Update Step Order on Server Side
  updateSteps(steps: Array<BusinessServiceStep>) {
    console.log(JSON.stringify(steps));
  }

  onChange(selectedValue) {
    console.log(selectedValue);
    this.selectedValue = selectedValue;
    if (selectedValue === '1') {
      this.getServices();
    } else if (selectedValue === '2') {
    }
  }


  getServices(): void {
    this.todoService.getTodos()
      .then(services => this.services = services);
  }


  // To Update Step Order Using Sortable List [On the fly]

  updateStepOrder(newItem: BusinessServiceStep, order: Number) {
    const updateItem = this.steps.find(this.findIndexToUpdate, newItem.id);

    const index = this.steps.indexOf(updateItem);

    newItem.stepOrder = order;

    this.steps[index] = newItem;
  }

  findIndexToUpdate(newItem) {
    return newItem.id === this;
  }

}
