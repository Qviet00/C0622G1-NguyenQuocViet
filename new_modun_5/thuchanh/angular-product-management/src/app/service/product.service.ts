import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  constructor(private httpClient: HttpClient) {
  }

  getAllProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(environment.apiURLPR);
  }

  getAllCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(environment.apiURLCT);
  }

  getAllById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${environment.apiURLPR}/${id}`);
  }

  editProduct(id: number, product: Product) {
    return this.httpClient.put<Product>(`${environment.apiURLPR}/${id}`, product);

  }

  save(product): Observable<Product> {
    return this.httpClient.post<Product>(environment.apiURLPR, product);

  }

  deleteProduct(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(`${environment.apiURLPR}/${id}`);
  }

  searchByName(name: string, category: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(environment.apiURLPR + '?name_like=' + name + '&category.name_like=' + category);
  }
}
