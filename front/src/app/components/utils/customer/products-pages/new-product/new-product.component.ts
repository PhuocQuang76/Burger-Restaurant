import { Component, OnInit } from '@angular/core';
import { IProduct } from 'src/app/interfaces/Iproduct';
import { IModalParams } from 'src/app/interfaces/modal/Imodal-params';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  constructor(private productService:ProductService) { }

  ngOnInit() {
  }

  createProduct(form:any){
    let product:IProduct={
      name: form[0].value,
      price: form[1].value,
      description: form[2].value,
      typeid: form[3].value,
      statusid: form[4].value
    }
    this.productService.createProduct(product);
    this.hide();
  }

  hide():void{
    this.params.hidden=!this.params.hidden;
  }

  params:IModalParams={
    hidden: true,
    title: 'Create Product',
    formParams: {
      inputs:[
        {
          name: "name",
          title: "Name",
          type: "text"
        },
        {
          name: "price",
          title: "Price",
          type: "text"
        },
        {
          name: "description",
          title: "Description",
          type: "text"
        },
        {
          name: "typeid",
          title: "Type",
          type: "text"
        }
      ],
      selects:[
        {
          name:"statusid",
          title:"Status",
          id:"statusid",
          options:[
            {value:"Open",title:"Open"},
            {value:"Close",title:"Close"}
          ]
        }
      ]
    },
    footer: 'Create new product'
  }
}
