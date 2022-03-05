import { Component, Input, OnInit } from '@angular/core';
import { IPurchase } from 'src/app/interfaces/Ipurchase';
import { PurchaseService } from 'src/app/services/purchasee/purchase.service';


@Component({
  selector: 'purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})

export class PurchaseComponent implements OnInit {

  //register purchase service
  constructor(private purchaseService: PurchaseService) { }

  ngOnInit() {
  
  }


  @Input() input:IPurchase = {
    purchase_id: 0,
    product: {
      product_id: 0,
      name:'',
      price: 0,
      description: '',
      seller: {
        user_id:0,    //unique id no need to display this
        fname:"",
        lname:"",
        email:""      //don't know if we should display this
      },
      statusid: "",
      typeid: ""
    },
    address:"",
    purchase: 0,
    delivery: 0,
    statusid: ""
  };

  onSelected(){
    this.purchaseService.purchaseSelected.emit(this.input);

  }


}
