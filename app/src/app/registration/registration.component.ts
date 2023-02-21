import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { resolvePtr } from 'dns';
import { Role } from '../models/Role';
import { User } from '../models/User';
import { RoleService } from '../services/role.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;
  roles: Role[] | null = null;


  constructor(private fb: FormBuilder, private userService: UserService, private roleService: RoleService) {
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


  ngOnInit(): void {
    this.roleService.getRoles().subscribe((res) => {
      this.roles = res;
      console.log(this.roles);
    })
  }

}
