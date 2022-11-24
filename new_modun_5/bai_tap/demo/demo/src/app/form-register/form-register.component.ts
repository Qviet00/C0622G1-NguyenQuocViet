import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ValidatorFn, Validators} from "@angular/forms";

@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css']
})
export class FormRegisterComponent implements OnInit {

  constructor(private _formBuilder: FormBuilder) {
  }

  rfRegister: FormGroup

  ngOnInit(): void {
    this.rfRegister = this._formBuilder.group({
      email: ['', [Validators.email, Validators.required]],
      password: [],
      confirmPassword: [],
      country: ['', [Validators.required]],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', [Validators.required]],
      phone: ["", [Validators.required, Validators.pattern("[+84]\\d{9,10}")]]
    }, {validators: this.rfRegister})
  }

  onSubmit() {
    if (this.rfRegister.valid) {
      console.log(this.rfRegister.value)
    }
  }

}
