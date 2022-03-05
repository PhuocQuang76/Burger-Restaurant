import {Component, Input, OnInit} from '@angular/core';
import {IPurchase} from "../../../../interfaces/Ipurchase";

@Component({
  selector: 'cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnInit {
  tax:number = 0;
  total:number = 0;

  @Input() purchase:IPurchase;
  constructor() { }

  ngOnChanges(){
    this.tax = Number((this.purchase.product.price * 0.1).toFixed(2));
    this.total = this.purchase.product.price + this.tax;
  }
  ngOnInit(): void {
  }

}
