import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Nhaxe} from "../model/nhaxe";
import {VeXeServiceService} from "../service/ve-xe-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-xoa-danh-sach',
  templateUrl: './xoa-danh-sach.component.html',
  styleUrls: ['./xoa-danh-sach.component.css']
})

export class XoaDanhSachComponent implements OnInit {

  xoaVeXe: FormGroup;
  id: number;
  xoaNhaXe: Nhaxe[];

  equals(o1: Nhaxe, o2: Nhaxe) {
    return o1.id === o2.id;
  }

  constructor(private veXeService: VeXeServiceService,
              private activeRouter: ActivatedRoute,
              private router: Router,
              private builder: FormBuilder) {
    this.activeRouter.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getVeXe(this.id);
    });
  }

  ngOnInit(): void {
  }

  delete(id: number) {
    this.veXeService.deleteVeXe(id).subscribe(() => {
      this.router.navigateByUrl('').then(null);
    })
  }

  private getVeXe(id: number) {
    this.veXeService.getAllNhaxe().subscribe(data => {
      this.xoaNhaXe = data;
    });
    return this.veXeService.getAllById(id).subscribe(x => {
      this.xoaVeXe = this.builder.group({
        id: [x.id],
        diemDi: [x.diemDi],
        diemDen: [x.diemDen],
        ngayKhoiHanh: [x.ngayKhoiHanh],
        gioKhoiHanh: [x.gioKhoiHanh],
        giaVe: [x.giaVe],
        soLuong: [x.soLuong],
        nhaXe: [x.nhaXe],
      });
    });
  }
}
