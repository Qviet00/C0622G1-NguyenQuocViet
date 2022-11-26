import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  login: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
      this.login = new FormGroup({
        email: new FormControl('', [Validators.required, Validators.email]),
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      });
  }
  onSubmit(): void {
    if (this.login.valid)
    console.log(this.login.value);
  }
}
