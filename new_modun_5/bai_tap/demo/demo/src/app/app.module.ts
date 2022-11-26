import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ReactiveFormsModule} from '@angular/forms';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { FormComponent } from './form/form.component';
import { FormRegisterComponent } from './form-register/form-register.component';
import { ProductServiceComponent } from './production/product-service/product-service.component';
import { ProductListComponent } from './production/product/product-list/product-list.component';
import { Routes, RouterModule } from '@angular/router';
import { ProductCreateComponent } from './production/product/product-create/product-create.component';
import { ProductUpdateComponent } from './production/product/product-update/product-update.component';
import { DictionaryDetailComponent } from './dictionary/dictionary-detail/dictionary-detail.component';
import { DictionaryPageComponent } from './dictionary/dictionary-page/dictionary-page.component';

const routes :Routes =[{
  path: 'production/list',
  component: ProductListComponent
}];



@NgModule({
  declarations: [
    AppComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    FormComponent,
    FormRegisterComponent,
    ProductServiceComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductUpdateComponent,
    DictionaryDetailComponent,
    DictionaryPageComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
