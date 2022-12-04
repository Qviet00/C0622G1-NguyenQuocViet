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
    return this.httpClient.get<Vexe[]>(environment.apiURLVX);
  }
  save(veXe): Observable<Vexe> {
    return this.httpClient.post<Vexe>(environment.apiURLVX, veXe);
  }
  getAllNhaxe(): Observable<Nhaxe[]>{
    return this.httpClient.get<Nhaxe[]>(environment.apiURLNX);
  }

  searchNgay(diemDi: string, diemDen:string) {
    return this.httpClient.get<Vexe[]>(environment.apiURLVX+'?diemDi_like='+ diemDi+'?diemDen_like='+ diemDen)
  }
  getAllById(id: number): Observable<Vexe> {
    return this.httpClient.get<Vexe>(`${environment.apiURLVX}/${id}`);
  }

  deleteVeXe(id: number):  Observable<Vexe> {
    return this.httpClient.delete<Vexe>(`${environment.apiURLVX}/${id}`);
  }

  editVexe(id: number, vexe: Vexe) {
  return this.httpClient.put<Vexe>(`${environment.apiURLVX}/${id}`, vexe);

}
}
