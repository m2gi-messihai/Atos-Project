import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamInitialPageComponent } from './exam-initial-page.component';

describe('ExamInitialPageComponent', () => {
  let component: ExamInitialPageComponent;
  let fixture: ComponentFixture<ExamInitialPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamInitialPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamInitialPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
