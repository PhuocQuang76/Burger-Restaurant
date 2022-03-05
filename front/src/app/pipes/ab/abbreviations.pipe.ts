import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'abbreviations'
})
export class AbbreviationsPipe implements PipeTransform {

  transform(abb: string):string{
    switch(abb){
      case "username":return "Username";
      case "password":return "Password";
      case "fname":return "First Name";
      case "lname":return "Last Name";
      case "email":return "Email";
    }
    return abb;
  }

}
