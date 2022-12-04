import { Component, OnInit } from '@angular/core';
import {CustomerType} from "../model/customerType";
import {CustomerService} from "../service/customer-service.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-create-cutomer',
  templateUrl: './create-cutomer.component.html',
  styleUrls: ['./create-cutomer.component.css']
})
export class CreateCutomerComponent implements OnInit {
  customerCreate: FormGroup;
  customerTypeCreate: CustomerType[] | undefined;

  constructor(private customerService: CustomerService,
              private router: Router,
              private buider: FormBuilder) {
  }

  ngOnInit(): void {
    this.customerService.getAllCusstomerType().subscribe(data => {
      this.customerTypeCreate = data;
      this.customerCreate = this.buider.group({
        name: [],
        dateOfBirth: [],
        idCard: [],
        phone: [],
        address: [],
        email: [],
        gender: [''],
        customerType: ['']
      })
    })
  }

  create() {
    if (this.customerCreate.valid) {
      this.customerService.save(this.customerCreate.value).subscribe(() => {
        this.router.navigateByUrl('');
      })
    }
  }
}
