import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {HttpClientModule} from '@angular/common/http';
import {ProductEditComponent} from './product/product-edit/product-edit.component';
import {ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {ProductDeleteComponent} from './product/product-delete/product-delete.component';
import {ToastrModule} from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    ProductDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
