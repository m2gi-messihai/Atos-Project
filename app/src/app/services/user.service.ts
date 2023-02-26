import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  API = 'http://localhost:8081';

  constructor(private http: HttpClient) { }
  createUser(user: User) {
    return this.http
      .post<User>(
        this.API + "/registration",
        user
      )

  }
  getStudents() {
    return this.http
      .get<{ [key: string]: User }>(
        this.API + "/students"
      )
      .pipe(
        map((res) => {
          const users = [];
          for (const key in res) {
            if (res.hasOwnProperty(key)) {
              users.push({ ...res[key], id: key });
            }
          }
          return users;
        })
      );
  }

}
