import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceConfigMapComponent } from './service-config-map.component';

describe('ServiceConfigMapComponent', () => {
  let component: ServiceConfigMapComponent;
  let fixture: ComponentFixture<ServiceConfigMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceConfigMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceConfigMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
