import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {ToastrModule, ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productCreate: FormGroup;
  categoryCreate: Category[] | undefined;

  constructor(private producService: ProductService,
              private router: Router,
              private buider: FormBuilder,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.producService.getAllCategory().subscribe(data => {
      this.categoryCreate = data;
      this.productCreate = this.buider.group({
        name: ['', [Validators.required]],
        price: ['0', [Validators.min(1)]],
        category: ['', [Validators.required]],
        description: ['', [Validators.required]]
      });
    });
  }

  sumit() {
    if (this.productCreate.valid) {
      this.producService.save(this.productCreate.value).subscribe(() => {
        this.router.navigateByUrl('').then(r => null);
        this.toastr.success('Thêm mới thành công');
      });
    }
  }
}
