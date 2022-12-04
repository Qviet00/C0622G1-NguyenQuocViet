import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';


@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productDelete: FormGroup;
  id: number;
  categoryDelete: Category[];

  equals(o1: Category, o2: Category) {
    return o1.id === o2.id;
  }

  constructor(
    private productService: ProductService,
    private activeRouter: ActivatedRoute,
    private router: Router,
    private builder: FormBuilder,
  ) {
    this.activeRouter.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });

  }

  ngOnInit(): void {

  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.router.navigateByUrl('').then(() => null);
    });
  }

  private getProduct(id: number) {
    this.productService.getAllCategory().subscribe(data => {
      this.categoryDelete = data;
    });
    return this.productService.getAllById(id).subscribe(x => {
      this.productDelete = this.builder.group({
        id: [x.id],
        name: [x.name],
        price: [x.price],
        category: [x.category],
        description: [x.description]
      });
    });
  }
}
