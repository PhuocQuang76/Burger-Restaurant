/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LabelHiddenInputComponent } from './label-hidden-input.component';

describe('LabelHiddenInputComponent', () => {
  let component: LabelHiddenInputComponent;
  let fixture: ComponentFixture<LabelHiddenInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LabelHiddenInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LabelHiddenInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
