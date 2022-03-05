import { Component, Input, OnInit } from "@angular/core";
import { IPurchase } from 'src/app/interfaces/Ipurchase';
import { IUser } from "src/app/interfaces/Iuser";
import { PurchaseService } from "src/app/services/purchasee/purchase.service";
import { GetImgPipe } from "src/app/pipes/get-img/get-img.pipe";
import { FoodishService } from "src/app/services/foodish/foodish.service";

@Component({
  selector: 'view-purchase',
  templateUrl: './view-purchase.component.html',
  styleUrls: ['./view-purchase.component.css']
})
export class ViewPurchaseComponent implements OnInit {
  tax:number = 0;
  total:number = 0;
  user:IUser=JSON.parse(sessionStorage.getItem("user")||"{}");
  pipe:GetImgPipe = new GetImgPipe();
  image:string;

  constructor(private purchaseService:PurchaseService,private foodishService: FoodishService) { }

  ngOnChanges(){
    this.tax = Number((this.input.product.price * 0.1).toFixed(2));
    this.total = this.input.product.price + this.tax;
    let image=this.pipe.transform(this.input.product);
    this.foodishService.getData(image)
      .subscribe(
        imgData => this.image = imgData,
      );
  }
  

  ngOnInit() {
    let image=this.pipe.transform(this.input.product);
    this.foodishService.getData(image)
      .subscribe(
        imgData => this.image = imgData,
      );
  }
  @Input() input:IPurchase = {
    purchase_id: 0,
    product: {
      name: "Testing",
      product_id: 0,
      price: 30,
      description: 'Test Test Test Test Test Test Test Test Test Test Test Test Test',
      seller: {
        user_id:0,    //unique id no need to display this
        fname:"",
        lname:"",
        email:""     //don't know if we should display this
      },
      statusid: "",
      typeid: ""
    },
    address:"",
    purchase: 0,
    delivery: 0,
    statusid: ""
  };




  approvePurchase(purchaseId){
    this.purchaseService.approvePurchase(purchaseId).subscribe((data)=>{
        this.input=data;
    });
  }
  declinePurchase(purchaseId) {
    this.purchaseService.declinePurchase(purchaseId).subscribe((data)=>{
        this.input=data;
    });
  }
  deliveryPurchase(purchaseId) {
    this.purchaseService.deliveryPurchase(purchaseId).subscribe((data)=>{
        this.input=data;
    });
  }

  isLogin():boolean{
    return this.user?this.user.user_id?true:false:false;
  }
  isSeller():boolean{
    return this.isLogin()?this.user.roleid=="Seller"?true:false:false;
  }

}
