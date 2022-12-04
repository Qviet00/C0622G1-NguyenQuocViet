import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DanhSachNhaxeComponent} from "./danh-sach-nhaxe/danh-sach-nhaxe.component";
import {ThemMoiVeXeComponent} from "./them-moi-ve-xe/them-moi-ve-xe.component";
import {XoaDanhSachComponent} from "./xoa-danh-sach/xoa-danh-sach.component";
import {EditVexeComponent} from "./edit-vexe/edit-vexe.component";


const routes: Routes = [{
  path: "",
  component: DanhSachNhaxeComponent
},
  {
    path: 'themmoivexe/create',
    component: ThemMoiVeXeComponent
  },
  {
    path: 'xoavexe/delete/:id',
    component: XoaDanhSachComponent
  }, {
    path: 'xoavexe/edit/:id',
    component: EditVexeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
