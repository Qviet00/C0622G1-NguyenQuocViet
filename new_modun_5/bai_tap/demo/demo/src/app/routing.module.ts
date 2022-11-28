import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListProductComponent} from "./product/list-product/list-product.component";


const routes: Routes = [{
  path: 'product/list',
  component: ListProductComponent
// ,
//   {
//   path: 'product/create',
//   component: ProductCreateComponent
// },
//   {
//   path: 'product/edit/:id',
//   component: ProductEditComponent
// }, {
//   path: 'product/delete/:id',
//   component: ProductDeleteComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
