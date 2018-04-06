import { TestBed, inject } from '@angular/core/testing';

import { BusinessServiceConfigService } from './business-service-config.service';

describe('BusinessServiceConfigService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BusinessServiceConfigService]
    });
  });

  it('should be created', inject([BusinessServiceConfigService], (service: BusinessServiceConfigService) => {
    expect(service).toBeTruthy();
  }));
});
