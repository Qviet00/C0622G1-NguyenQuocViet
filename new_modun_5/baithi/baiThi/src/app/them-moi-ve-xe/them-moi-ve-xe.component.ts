import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Nhaxe} from "../model/nhaxe";
import {VeXeServiceService} from "../service/ve-xe-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-them-moi-ve-xe',
  templateUrl: './them-moi-ve-xe.component.html',
  styleUrls: ['./them-moi-ve-xe.component.css']
})
export class ThemMoiVeXeComponent implements OnInit {

  themMoiVeXe: FormGroup;
  themMoiNhaXe: Nhaxe[] | undefined;

  constructor(private vexeService: VeXeServiceService,
              private router: Router,
              private builder: FormBuilder) {
  }

  ngOnInit(): void {
    this.vexeService.getAllNhaxe().subscribe(data => {
      this.themMoiNhaXe = data;
      this.themMoiVeXe = this.builder.group({
        diemDi: ["",[Validators.required]],
        diemDen: ["",[Validators.required]],
        giaVe: ["",[Validators.required]],
        ngayKhoiHanh: ["",[Validators.required]],
        gioKhoiHanh: ["",[Validators.required]],
        soLuong: ["",[Validators.required]],
        nhaXe: ['',[Validators.required]],
      })
    })
  }

  themMoi() {
    if (this.themMoiVeXe.valid) {
      this.vexeService.save(this.themMoiVeXe.value).subscribe(() =>
        this.router.navigateByUrl(''));
    }
  }

}
