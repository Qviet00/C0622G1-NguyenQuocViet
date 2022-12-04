import {Component, OnInit} from '@angular/core';
import {VeXeServiceService} from "../service/ve-xe-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormBuilder, FormGroup} from '@angular/forms';
import {Nhaxe} from "../model/nhaxe";

@Component({
  selector: 'app-edit-vexe',
  templateUrl: './edit-vexe.component.html',
  styleUrls: ['./edit-vexe.component.css']
})
export class EditVexeComponent implements OnInit {


  veXeEdit: FormGroup;
  nhaXeEdit: Nhaxe[] = [];
  id: number;

  equals(o1: Nhaxe, o2: Nhaxe) {
    return o1.id === o2.id;
  }

  constructor(
    private veXeService: VeXeServiceService,
    private builder: FormBuilder,
    private activateRoute: ActivatedRoute,
    private router: Router) {

  }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });

    this.getEditProduct(this.id);
  }

  getEditProduct(id: number) {
    return this.veXeService.getAllById(id).subscribe(x => {
      this.getCategory();
      this.veXeEdit = this.builder.group({
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

  editVeXe(id: number) {
    const product = this.veXeEdit.value;
    this.veXeService.editVexe(id, product).subscribe(() => {
      this.router.navigateByUrl('');
    });
  }

  getCategory() {
    this.veXeService.getAllNhaxe().subscribe(data => {
      this.nhaXeEdit = data;
    });
  }

}
