import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product/product.service';


@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

 public products = [];

  constructor(private productservice: ProductService) { }

  ngOnInit() {
    this.productservice.getProducts().subscribe(data => this.products = data);
  }



}
