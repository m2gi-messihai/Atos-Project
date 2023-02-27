import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map, Observable, startWith } from 'rxjs';
import { ExamInstance } from '../models/ExamInstance';
import { GeneratedLink } from '../models/GeneratedLink';
import { User } from '../models/User';
import { ExamInstanceService } from '../services/exam-instance.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-assign-exam-to-student',
  templateUrl: './assign-exam-to-student.component.html',
  styleUrls: ['./assign-exam-to-student.component.css']
})
export class AssignExamToStudentComponent implements OnInit {

  students: User[] | null = null;
  teachers: User[] | null = null;
  userId: string | null = null;
  examId: string | null = "";
  examInstanceId: string | null = null;
  generatedLink: GeneratedLink | null = null;
  assignExamForm: FormGroup;
  generatedLinkForm: FormGroup;
  studentsControl = new FormControl('');
  teachersControl = new FormControl('');
  filteredStudents: Observable<User[]> | null = null;
  filteredTeachers: Observable<User[]> | null = null;

  constructor(private router: Router, private examInstanceService: ExamInstanceService, private userService: UserService, private route: ActivatedRoute, private fb: FormBuilder) {
    this.assignExamForm = this.fb.group({
      duration: ['', [Validators.required]],



    });
    this.generatedLinkForm = this.fb.group({
      scheduledTimeFrom: ['', [Validators.required]],
      scheduledTimeTo: ['', [Validators.required]],

    })
  }

  ngOnInit(): void {
    this.examId = this.route.snapshot.paramMap.get('examId');
    console.log(this.examId);
    this.userService.getStudents().subscribe((res) => {
      this.students = res;
      console.log(this.students);
    })
    this.userService.getTeachers().subscribe((res) => {
      this.teachers = res;
      console.log(this.teachers);
    })
    this.filteredStudents = this.studentsControl.valueChanges.pipe(
      startWith(''),
      map(value => this.filterStudents(value || '')),
    );
    this.filteredTeachers = this.teachersControl.valueChanges.pipe(
      startWith(''),
      map(value => this.filterTeachers(value || '')),
    );

  }
  private filterStudents(user: string): User[] {
    const filterStudents = user.toLowerCase();
    if (this.students) {
      return this.students.filter(student => student.email.toLowerCase().includes(filterStudents));
    }
    return [];

  }
  private filterTeachers(user: string): User[] {
    const filterTeachers = user.toLowerCase();
    if (this.teachers) {
      return this.teachers.filter(teacher => teacher.email.toLowerCase().includes(filterTeachers));
    }
    return [];

  }
  assignExam(examInstance: ExamInstance, generatedLink: GeneratedLink) {
    if (this.examId && this.userId && examInstance) {
      examInstance.examDefinitionId = this.examId;
      examInstance.takenBy = this.userId;
      examInstance.generatedLink = generatedLink;
      console.log(this.generatedLinkForm.value.scheduledTimeFrom);
      examInstance.generatedLink.scheduledTimeFrom = this.generatedLinkForm.value.scheduledTimeFrom;
      examInstance.generatedLink.scheduledTimeTo = this.generatedLinkForm.value.scheduledTimeTo;
    }
    this.examInstanceService.assignExam(examInstance).subscribe((res) => {
      console.log(res);
    });
    console.log(examInstance.examInstanceId);
    this.router.navigate(['/assignedExams']);
  }
  getUserId(id: string) {
    this.userId = id;
  }
}
