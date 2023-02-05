import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAnswerPopupComponent } from './add-answer-popup.component';

describe('AddAnswerPopupComponent', () => {
  let component: AddAnswerPopupComponent;
  let fixture: ComponentFixture<AddAnswerPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAnswerPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAnswerPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
