import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Role } from '../models/Role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  API = 'http://localhost:8080/ruleForm';

  constructor(private http: HttpClient) { }
  createRule(role: Role) {
    return this.http
      .post<Role>(
        this.API,
        role
      );
  }
}
