import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Rule } from '../models/Rule';
import { RuleService } from '../services/rule.service';

@Component({
  selector: 'app-rule-form',
  templateUrl: './rule-form.component.html',
  styleUrls: ['./rule-form.component.css']
})
export class RuleFormComponent implements OnInit {
  ruleForm: FormGroup;

  constructor(private fb: FormBuilder, private ruleService: RuleService) {
    this.ruleForm = this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],


    })
  }

  ngOnInit(): void {
  }
  onSubmit(rule: Rule) {
    this.ruleService.createRule(rule).subscribe((res) => {
    })

  }

}
