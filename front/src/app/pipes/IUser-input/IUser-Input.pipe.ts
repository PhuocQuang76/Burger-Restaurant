import { Pipe, PipeTransform } from '@angular/core';
import { IUser } from '../../interfaces/Iuser';
import { IlabelHiddenInput } from '../../interfaces/modal/Ilabel-hidden-input';
import { AbbreviationsPipe } from '../ab/abbreviations.pipe';

@Pipe({
  name: 'IUser-Input'
})
export class IUserInputPipe implements PipeTransform {

  pipe:AbbreviationsPipe = new AbbreviationsPipe();

  transform(user: IUser): IlabelHiddenInput[] {

    let final:IlabelHiddenInput[]=[];
    for(let name in user){
      if(name!="user_id"&&name!="roleid"){
        let temp:IlabelHiddenInput={
          hidden: true,
          input: {
            name: name,
            title: this.pipe.transform(name),
            value:""+user[name as keyof IUser],
            type: "text"
          }
        };
        final.push(temp);
      }
    }

    return final;
  }

}
