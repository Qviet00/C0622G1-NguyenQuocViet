import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { CustomerComponent } from './cusstomer/list/customer.component';
import { HomeComponent } from './home/home/home.component';
import { AddCustomerComponent } from './cusstomer/add-customer/add-customer.component';
import { ListFacilityComponent } from './facility/list-facility/list-facility.component';
import { EditFacilityComponent } from './facility/edit-facility/edit-facility.component';
import { AddFacilityComponent } from './facility/add-facility/add-facility.component';
import { EditCustomerComponent } from './cusstomer/edit-customer/edit-customer.component';
import { AddContraclComponent } from './contracl/add-contracl/add-contracl.component';
import { ListContraclComponent } from './contracl/list-contracl/list-contracl.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    HomeComponent,
    AddCustomerComponent,
    ListFacilityComponent,
    EditFacilityComponent,
    AddFacilityComponent,
    EditCustomerComponent,
    AddContraclComponent,
    ListContraclComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
