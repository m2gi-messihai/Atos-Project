import { TestBed } from '@angular/core/testing';

import { ExamInstanceService } from './exam-instance.service';

describe('ExamInstanceService', () => {
  let service: ExamInstanceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamInstanceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
