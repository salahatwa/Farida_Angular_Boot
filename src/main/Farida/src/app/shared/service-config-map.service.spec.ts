import { TestBed, inject } from '@angular/core/testing';

import { ServiceConfigMapService } from './service-config-map.service';

describe('ServiceConfigMapService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServiceConfigMapService]
    });
  });

  it('should be created', inject([ServiceConfigMapService], (service: ServiceConfigMapService) => {
    expect(service).toBeTruthy();
  }));
});
