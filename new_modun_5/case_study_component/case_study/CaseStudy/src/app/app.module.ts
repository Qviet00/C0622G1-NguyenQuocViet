import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { CustomerComponent } from './customer/list/customer.component';
import { HomeComponent } from './home/home/home.component';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { EditFacilityComponent } from './facility/edit-facility/edit-facility.component';
import { AddFacilityComponent } from './facility/add-facility/add-facility.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { AddContraclComponent } from './contracl/add-contracl/add-contracl.component';
import { ListContraclComponent } from './contracl/list-contracl/list-contracl.component';
import {FacilityListComponent} from './facility/list-facility/list-facility.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    HomeComponent,
    AddCustomerComponent,
    EditFacilityComponent,
    AddFacilityComponent,
    EditCustomerComponent,
    AddContraclComponent,
    ListContraclComponent,
    FacilityListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
