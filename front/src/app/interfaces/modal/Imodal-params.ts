import { IlabelHiddenInput } from "./Ilabel-hidden-input";
import { IlabelInput } from "./Ilabel-input";
import { IlabelSelect } from "./Ilabel-select";

export interface IModalParams {
  hidden:boolean,
  title:string,
  id?:string,
  formParams:{
    hidden?:IlabelHiddenInput[],
    inputs?:IlabelInput[],
    selects?:IlabelSelect[],
  },
  footer:string
}
