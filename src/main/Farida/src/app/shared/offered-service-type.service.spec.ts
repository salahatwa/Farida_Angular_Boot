import { TestBed, inject } from '@angular/core/testing';

import { OfferedServiceTypeService } from './offered-service-type.service';

describe('OfferedServiceTypeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OfferedServiceTypeService]
    });
  });

  it('should be created', inject([OfferedServiceTypeService], (service: OfferedServiceTypeService) => {
    expect(service).toBeTruthy();
  }));
});
