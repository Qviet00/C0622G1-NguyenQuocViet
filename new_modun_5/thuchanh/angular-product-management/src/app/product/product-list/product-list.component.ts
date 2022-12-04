import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  p: number;
  productSearch: string;
  categorySearch: string;
  categoryList: Category[] | undefined;


  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.productService.getAllProduct().subscribe(
      data => {
        this.products = data;
      }
    );
    this.productSearch = '';
    this.categorySearch = '';
    this.getSearch();
  }

  search(value1: string, value2: string) {
    this.p = 1;
    this.productSearch = value1;
    this.categorySearch = value2;
    this.productService.searchByName(this.productSearch,
      this.categorySearch).subscribe(data => {
      this.products = data;
    });
  }

  private getSearch() {
    this.productService.getAllProduct().subscribe(data => {
      this.products = data;
    });
    this.productService.getAllCategory().subscribe(data => {
      this.categoryList = data;
    });
  }
}
