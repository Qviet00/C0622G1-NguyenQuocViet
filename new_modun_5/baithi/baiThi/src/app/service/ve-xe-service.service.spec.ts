import { TestBed } from '@angular/core/testing';

import { VeXeServiceService } from './ve-xe-service.service';

describe('VeXeServiceService', () => {
  let service: VeXeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VeXeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
