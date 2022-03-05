import { Component, OnInit } from '@angular/core';
import { IPurchase } from 'src/app/interfaces/Ipurchase';
import { PurchaseService } from 'src/app/services/purchasee/purchase.service';

@Component({
  selector: 'cart-main',
  templateUrl: './cart-main.component.html',
  styleUrls: ['./cart-main.component.css']
})
export class CartMainComponent implements OnInit {

  purchases:IPurchase[] = [];
  totalPrice: number = 0;
  total: number = 0;
  totalTax: number = 0;
 //purchases:Observable<IPurchase[]> = new Observable<IPurchase[]>();

  constructor(private purchasesService: PurchaseService) { }
  display:boolean= false;

  ngOnInit() {
    this.purchasesService.getCartPurchases().subscribe((data) =>{
      this.purchases = data;
      if(this.purchases.length>0){
        this.display = true;
        for(let purchase of this.purchases){
          this.totalPrice += purchase.product.price;
          this.totalTax += purchase.product.price * 0.1;
          this.total += purchase.product.price + this.totalTax;

        }
      }
    });

  }

  buy(){
    this.purchasesService.buy(this.purchases);
    location.reload();
  }
}
