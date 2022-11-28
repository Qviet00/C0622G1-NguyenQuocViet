import {Component, OnInit} from '@angular/core';
import {Product} from "../model/Product";
import {ProductService} from "../service/product.service";

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  products: Product[] = [];

  constructor(private productSevice: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();

  }

  getAll() {
    this.products = this.productSevice.getAll();
  }

}
