import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { SortableModule } from 'ngx-bootstrap/sortable';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { ClipboardModule } from 'ngx-clipboard';


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
import { ServiceStepsComponent } from './dialogs/service-steps/service-steps.component';

// Format code using Ctrl + Shift + i
// For modal PopUp modal : npm install --save @ng-bootstrap/ng-bootstrap
// npm install ngx-clipboard --save  Copy To CLiboard
// npm install --save-dev electron  #to convert my app to desktop app
// electron #https://scotch.io/tutorials/build-a-music-player-with-angular-2-electron-i-setup-basics-concepts  , npm run electron-build

@NgModule({
  declarations: [
    AppComponent,
    ServiceListComponent,
    ServiceConfigMapComponent,
    ServiceDeleteComponent,
    ServiceUpdateComponent,
    ServiceComponent,
    ServicesFilterPipe,
    ServiceStepsComponent
  ],
  imports: [
    FormsModule,
    HttpModule,
    BrowserModule,
    ClipboardModule,
    NgbModule.forRoot(),
    Ng2SearchPipeModule,
    SortableModule.forRoot(),
    PopoverModule.forRoot()
  ],
  providers: [ServiceConfigMapService, OfferedServiceTypeService, BusinessServiceConfigService, BusinessServiceStepService, TodoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
