import { TestBed } from '@angular/core/testing';

import { FoodishService } from './foodish.service';

describe('FoodishService', () => {
  let service: FoodishService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodishService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
