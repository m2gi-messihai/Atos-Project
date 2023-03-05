import { TestBed } from '@angular/core/testing';

import { GetExmQuestionsService } from './get-exm-questions.service';

describe('GetExmQuestionsService', () => {
  let service: GetExmQuestionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetExmQuestionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
