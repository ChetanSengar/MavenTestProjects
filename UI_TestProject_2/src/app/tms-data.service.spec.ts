import { TestBed } from '@angular/core/testing';

import { TmsDataService } from './tms-data.service';

describe('TmsDataService', () => {
  let service: TmsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TmsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
