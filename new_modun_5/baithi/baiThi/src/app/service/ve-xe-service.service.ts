import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Vexe} from "../model/vexe";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Nhaxe} from "../model/nhaxe";

@Injectable({
  providedIn: 'root'
})
export class VeXeServiceService {

  constructor(private httpClient: HttpClient) {
  }

  getAllVeXe(): Observable<Vexe[]> {
    return this.httpClient.get<Vexe[]>(environment.api_ve);
  }
  save(veXe): Observable<Vexe> {
    return this.httpClient.post<Vexe>(environment.api_ve, veXe);
  }
  getAllNhaxe(): Observable<Nhaxe[]>{
    return this.httpClient.get<Nhaxe[]>(environment.api_nha);
  }

  searchNgay(diemDi: string, diemDen:string) {
    return this.httpClient.get<Vexe[]>(environment.api_ve+'?diemDi_like='+ diemDi+'?diemDen_like='+ diemDen)
  }
  getAllById(id: number): Observable<Vexe> {
    return this.httpClient.get<Vexe>(`${environment.api_ve}/${id}`);
  }

  deleteVeXe(id: number):  Observable<Vexe> {
    return this.httpClient.delete<Vexe>(`${environment.api_ve}/${id}`);
  }

  editVexe(id: number, vexe: Vexe) {
  return this.httpClient.put<Vexe>(`${environment.api_ve}/${id}`, vexe);

}
}
