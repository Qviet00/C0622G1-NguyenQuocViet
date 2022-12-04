import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CreateCutomerComponent} from "./create-cutomer/create-cutomer.component";
import {DeleteCustomerComponent} from "./delete-customer/delete-customer.component";
import {EditCustomerComponent} from "./edit-customer/edit-customer.component";


const routes: Routes = [
  {
    path: '',
    component: CustomerListComponent
  },
  {
    path: 'customer/create',
    component: CreateCutomerComponent
  },
  {
    path: 'product/delete/:id',
    component: DeleteCustomerComponent
  },
  {
    path: 'product/edit/:id',
    component: EditCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
