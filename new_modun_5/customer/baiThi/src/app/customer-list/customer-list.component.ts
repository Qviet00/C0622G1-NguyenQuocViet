import {Component, OnInit} from '@angular/core';
import {Customer} from "../model/customer";
import {CustomerType} from "../model/customerType";
import {CustomerService} from "../service/customer-service.service";


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customerList: Customer[] = [];
  p: number;
  customerSearch: string;
  customerTypeSearch: string;
  customerTypesList: CustomerType[] | undefined;
  date1: string;
  date2: string;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.getAllCusstomer().subscribe(data => {
      this.customerList = data;
    });
    this.date1 = "";
    this.date2 = "";
    this.customerSearch = '';
    this.customerTypeSearch = '';
    this.getSearchCustomer();
  }

  search(value1: string, value2: string) {
    this.p = 1;
    this.customerSearch = value1;
    this.customerTypeSearch = value2;
    this.customerService.searchByNameAndCustomer(this.customerSearch,
      this.customerTypeSearch).subscribe(data => {
      this.customerList = data;
    });
  }

  private getSearchCustomer() {
    this.customerService.getAllCusstomer().subscribe(data => {
      this.customerList = data;
    });
    this.customerService.getAllCusstomerType().subscribe(data => {
      this.customerTypesList = data;
    });
  }

  searchDateOfBirth() {
    if ((this.date1 == "" || this.date2 == "")) {
      return this.ngOnInit()
    }
    this.customerService.getAllCusstomer().subscribe(
      data => {
        this.customerList = data.filter(value => {
          const format = new Date(value.dateOfBirth);
          const startDate = new Date(this.date1);
          const endDate = new Date(this.date2);
          if (format > startDate && format < endDate) {
            return data;
          }
        });
      });
  }
}
