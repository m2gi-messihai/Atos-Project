import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Role } from '../models/Role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  API = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  createRule(role: Role) {
    return this.http
      .post<Role>(
        this.API + "/roleForm",
        role
      );
  }
  getRoles() {
    return this.http
      .get<{ [key: string]: Role }>(
        this.API + "/roles"
      )
      .pipe(
        map((res) => {
          const roles = [];
          for (const key in res) {
            if (res.hasOwnProperty(key)) {
              roles.push({ ...res[key], id: key });
            }
          }
          return roles;
        })
      );
  }

}
