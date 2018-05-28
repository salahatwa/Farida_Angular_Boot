import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceStepsComponent } from './service-steps.component';

describe('ServiceStepsComponent', () => {
  let component: ServiceStepsComponent;
  let fixture: ComponentFixture<ServiceStepsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceStepsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceStepsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
