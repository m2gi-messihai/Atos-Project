import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  API = 'http://localhost:8081/registration';

  constructor(private http: HttpClient) { }
  createUser(user: User) {
    return this.http
      .post<User>(
        this.API,
        user
      );

  }
}
