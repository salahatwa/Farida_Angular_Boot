import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { SortableModule } from 'ngx-bootstrap/sortable';


import { AppComponent } from './app.component';
import { ServiceConfigMapService } from './shared/service-config-map.service';
import { OfferedServiceTypeService } from './shared/offered-service-type.service';
import { BusinessServiceConfigService } from './shared/business-service-config.service';
import { BusinessServiceStepService } from './shared/business-service-step.service';
import { FormsModule, NgForm } from '@angular/forms';
import { ServiceConfigMapComponent } from './components/service-config-map/service-config-map.component';
import { ServiceDeleteComponent } from './dialogs/service-delete/service-delete.component';
import { ServiceUpdateComponent } from './dialogs/service-update/service-update.component';
import { ServiceComponent } from './forms/service/service.component';
import { Http, HttpModule } from '@angular/http';
import { ServicesFilterPipe } from './filters/services-filter.pipe';

import { TodoService } from './Todo/todo.service';
import { ServiceListComponent } from './Todo/service-list.component';

// Format code using Ctrl + Shift + i
// For modal PopUp modal : npm install --save @ng-bootstrap/ng-bootstrap

@NgModule({
  declarations: [
    AppComponent,
    ServiceListComponent,
    ServiceConfigMapComponent,
    ServiceDeleteComponent,
    ServiceUpdateComponent,
    ServiceComponent,
    ServicesFilterPipe
  ],
  imports: [
    FormsModule,
    HttpModule,
    BrowserModule,
    NgbModule.forRoot(),
    Ng2SearchPipeModule,
    SortableModule.forRoot()
  ],
  providers: [ServiceConfigMapService, OfferedServiceTypeService, BusinessServiceConfigService, BusinessServiceStepService, TodoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
