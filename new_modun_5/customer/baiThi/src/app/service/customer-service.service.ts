import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Customer} from "../model/customer";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {CustomerType} from "../model/customerType";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) {
  }

  getAllCusstomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(environment.apiURLC);
  }

  searchByNameAndCustomer(name: string, customerTypeSearch: string) {
    return this.httpClient.get<Customer[]>(environment.apiURLC + '?name_like=' + name + '&customerType.name_like=' + customerTypeSearch);
  }

  getAllCusstomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(environment.apiURLCT);
  }

  save(customer): Observable<Customer> {
    return this.httpClient.post<Customer>(environment.apiURLC, customer);

  }

  deleteProduct(id: number): Observable<Customer> {
    return this.httpClient.delete<Customer>(`${environment.apiURLC}/${id}`);
  }

  getAllById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(`${environment.apiURLC}/${id}`);
  }

  editCustomer(id: number, product: Customer) {
    return this.httpClient.put<Customer>(`${environment.apiURLC}/${id}`, product);

  }
}
