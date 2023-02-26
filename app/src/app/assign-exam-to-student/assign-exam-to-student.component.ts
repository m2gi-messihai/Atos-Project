import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { map, Observable, startWith } from 'rxjs';
import { User } from '../models/User';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-assign-exam-to-student',
  templateUrl: './assign-exam-to-student.component.html',
  styleUrls: ['./assign-exam-to-student.component.css']
})
export class AssignExamToStudentComponent implements OnInit {
  students: User[] | null = null;
  myControl = new FormControl('');
  filteredOptions: Observable<User[]> | null = null;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getStudents().subscribe((res) => {
      this.students = res;
      console.log(this.students);
    })
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }
  private _filter(user: string): User[] {
    const filterValue = user.toLowerCase();
    if (this.students) {
      return this.students.filter(student => student.email.toLowerCase().includes(filterValue));
    }
    return [];

  }

}
