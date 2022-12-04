import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { DanhSachNhaxeComponent } from './danh-sach-nhaxe/danh-sach-nhaxe.component';
import { ThemMoiVeXeComponent } from './them-moi-ve-xe/them-moi-ve-xe.component';
import { XoaDanhSachComponent } from './xoa-danh-sach/xoa-danh-sach.component';
import { EditVexeComponent } from './edit-vexe/edit-vexe.component';

@NgModule({
  declarations: [
    AppComponent,
    DanhSachNhaxeComponent,
    ThemMoiVeXeComponent,
    XoaDanhSachComponent,
    EditVexeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
