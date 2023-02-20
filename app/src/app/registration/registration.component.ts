import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Role } from '../models/Role';
import { User } from '../models/User';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService) {
    this.registrationForm = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      birthDate: ['', [Validators.required]],
      email: ['', [Validators.required]],
      mobileNumber: ['', [Validators.required]],
      address: ['', [Validators.required]],
      roles: ['', [Validators.required]]
    })
  }
  onSubmit(user: User) {
    this.userService.createUser(user).subscribe((res) => {
    })

  }
  roles: Role[] = [
    { code: 'admin', label: 'Admin' },
    { code: 'sme', label: 'SME' },
    { code: 'student', label: 'Student' }
  ];

  ngOnInit(): void {
  }

}
