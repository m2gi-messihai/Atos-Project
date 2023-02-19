import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rule } from '../models/Rule';

@Injectable({
  providedIn: 'root'
})
export class RuleService {
  API = 'http://localhost:8080/ruleForm';

  constructor(private http: HttpClient) { }
  createRule(rule: Rule) {
    return this.http
      .post<Rule>(
        this.API,
        rule
      );
  }
}
