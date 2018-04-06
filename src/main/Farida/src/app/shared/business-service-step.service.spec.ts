import { TestBed, inject } from '@angular/core/testing';

import { BusinessServiceStepService } from './business-service-step.service';

describe('BusinessServiceStepService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BusinessServiceStepService]
    });
  });

  it('should be created', inject([BusinessServiceStepService], (service: BusinessServiceStepService) => {
    expect(service).toBeTruthy();
  }));
});
