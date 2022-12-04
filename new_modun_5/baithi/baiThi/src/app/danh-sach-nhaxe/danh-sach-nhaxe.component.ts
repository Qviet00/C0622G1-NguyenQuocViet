import {Component, OnInit} from '@angular/core';
import {Vexe} from "../model/vexe";
import {VeXeServiceService} from "../service/ve-xe-service.service";

@Component({
  selector: 'app-danh-sach-nhaxe',
  templateUrl: './danh-sach-nhaxe.component.html',
  styleUrls: ['./danh-sach-nhaxe.component.css']
})
export class DanhSachNhaxeComponent implements OnInit {
  danhSachVe: Vexe[] = [];
  p: number;
  date1: string;
  date2: string;
  diemDenSearch: string;
  diemdiSearch: string;

  constructor(private veXeService: VeXeServiceService) {
  }

  ngOnInit(): void {
    this.veXeService.getAllVeXe().subscribe(data => {
      this.danhSachVe = data;
    })
    this.date1 = "";
    this.date2 = "";
    this.diemDenSearch= "";
    this.diemdiSearch="";
    this.searchDiaDiem();
  }

  searchNgayKhoiHanh(value1:string, value2:string) {
    this.search(value1,value2);
    if ((this.date1 == "" && this.date2 == "")) {
      return this.ngOnInit()
    }
    this.veXeService.getAllVeXe().subscribe(
      data => {
        this.danhSachVe = data.filter(value => {
          const format = new Date(value.ngayKhoiHanh);
          const startDate = new Date(this.date1);
          const endDate = new Date(this.date2);
          if (format > startDate && format < endDate) {
            return data;
          }
        });
      });

  }

  private searchDiaDiem() {
    this.veXeService.getAllVeXe().subscribe(data => {
      this.danhSachVe = data;
    })
  }
  search(value1:string, value2:string){
    this.p=1;
    this.diemdiSearch=value1;
    this.diemDenSearch=value2;
    this.veXeService.searchNgay(this.diemdiSearch, this.diemdiSearch).subscribe(data =>{
      this.danhSachVe=data;
    })

  }
}
