/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PurchaseService } from './purchase.service';

describe('Service: Products', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PurchaseService]
    });
  });

  it('should ...', inject([PurchaseService], (service: PurchaseService) => {
    expect(service).toBeTruthy();
  }));
});
