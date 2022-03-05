import { IProduct } from "./Iproduct"
import { IUser } from "./Iuser"


export interface IPurchase {
  purchase_id?:number, //unique id mainly used for form request
  product?:IProduct,   //product
  buyer?:IUser,        //user type
  address?:string,
  purchase?:number,    //timestamp
  delivery?:number,    //timestamp
  statusid?:string       //current status
}
