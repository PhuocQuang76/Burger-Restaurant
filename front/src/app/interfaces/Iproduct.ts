import { IUser } from "./Iuser";


export interface IProduct {
  product_id?:number,    //unique id mainly used for form request
  name?:string,
  price?:number,
  description?:string,
  seller?:IUser,
  statusid?:string,
  typeid?:string
}
