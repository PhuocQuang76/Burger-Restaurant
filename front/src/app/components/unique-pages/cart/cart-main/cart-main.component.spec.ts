/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { CartMainComponent } from './cart-main.component';

describe('CartMainComponent', () => {
  let component: CartMainComponent;
  let fixture: ComponentFixture<CartMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
