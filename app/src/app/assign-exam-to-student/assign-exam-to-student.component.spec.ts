import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignExamToStudentComponent } from './assign-exam-to-student.component';

describe('AssignExamToStudentComponent', () => {
  let component: AssignExamToStudentComponent;
  let fixture: ComponentFixture<AssignExamToStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignExamToStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignExamToStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
