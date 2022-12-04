import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../service/customer-service.service";
import {CustomerType} from "../model/customerType";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormBuilder, FormGroup} from '@angular/forms';
import {Customer} from "../model/customer";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  customerDelete: FormGroup;
  id: number;
  customerTypeDelete: CustomerType[];

  equals(o1: CustomerType, o2: CustomerType) {
    return o1.id === o2.id;
  }

  constructor(private customerService: CustomerService,
              private activeRouter: ActivatedRoute,
              private router: Router,
              private builder: FormBuilder,) {
    this.activeRouter.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit(): void {

  }

  deleteProduct(id: number) {
    this.customerService.deleteProduct(id).subscribe(() => {
      this.router.navigateByUrl('');
    });
  }

  private getProduct(id: number) {
    this.customerService.getAllCusstomerType().subscribe(data => {
      this.customerTypeDelete = data;
    });
    return this.customerService.getAllById(id).subscribe(x => {
      this.customerDelete = this.builder.group({
        id: [x.id],
        name: [x.name],
        dateOfBirth: [x.dateOfBirth],
        idCard: [x.idCard],
        phone: [x.phone],
        address: [x.address],
        email: [x.email],
        gender: [x.gender],
        customerType: [x.customerType]
      });
    });
  }
}
