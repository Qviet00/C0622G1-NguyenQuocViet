import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerType} from "../model/customerType";
import {CustomerService} from "../service/customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {


  customerEdit: FormGroup;
  customerTypeEdit: CustomerType[] = [];
  id: number;

  equals(o1: CustomerType, o2: CustomerType) {
    return o1.id === o2.id;
  }

  constructor(
    private customerService: CustomerService,
    private builder: FormBuilder,
    private activateRoute: ActivatedRoute,
    private router: Router) {

  }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });

    this.getEditProduct(this.id);
  }

  getEditProduct(id: number) {
    return this.customerService.getAllById(id).subscribe(x => {
      this.getCategory();
      this.customerEdit = this.builder.group({
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

  editCustomer(id: number) {
    const product = this.customerEdit.value;
    this.customerService.editCustomer(id, product).subscribe(() => {
      this.router.navigateByUrl('');
    });
  }

  getCategory() {
    this.customerService.getAllCusstomerType().subscribe(data => {
      this.customerTypeEdit = data;
    });
  }

}
