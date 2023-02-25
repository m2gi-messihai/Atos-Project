import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddQuestionsPopupComponent } from './add-questions-popup.component';

describe('AddQuestionsPopupComponent', () => {
  let component: AddQuestionsPopupComponent;
  let fixture: ComponentFixture<AddQuestionsPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddQuestionsPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddQuestionsPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
