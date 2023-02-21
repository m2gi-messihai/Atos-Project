import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Role } from '../models/Role';
import { RoleService } from '../services/role.service';

@Component({
  selector: 'app-role-form',
  templateUrl: './role-form.component.html',
  styleUrls: ['./role-form.component.css']
})
export class RoleFormComponent implements OnInit {
  roleForm: FormGroup;

  constructor(private fb: FormBuilder, private roleService: RoleService) {
    this.roleForm = this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],


    })
  }

  ngOnInit(): void {
  }
  onSubmit(role: Role) {
    this.roleService.createRule(role).subscribe((res) => {
    })

  }

}
