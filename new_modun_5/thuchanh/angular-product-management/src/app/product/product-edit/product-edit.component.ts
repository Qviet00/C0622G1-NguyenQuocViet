import {Component, OnInit} from '@angular/core';
import {Category} from '../../model/category';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  productEdit: FormGroup;
  categoryEdit: Category[] = [];
  id: number;

  equals(o1: Category, o2: Category) {
    return o1.id === o2.id;
  }

  constructor(
    private builder: FormBuilder,
    private productService: ProductService,
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
    return this.productService.getAllById(id).subscribe(x => {
      this.getCategory();
      this.productEdit = this.builder.group({
        id: [x.id],
        name: [x.name],
        price: [x.price],
        description: [x.description],
        category: [x.category]
      });
    });
  }

  editProduct(id: number) {
    const product = this.productEdit.value;
    this.productService.editProduct(id, product).subscribe(() => {
      this.router.navigateByUrl('').then(() => null);
    });
  }

  getCategory() {
    this.productService.getAllCategory().subscribe(data => {
      this.categoryEdit = data;
    });
  }
}
