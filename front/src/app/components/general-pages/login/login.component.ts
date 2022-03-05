import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/interfaces/Iuser';
import { IModalParams } from 'src/app/interfaces/modal/Imodal-params';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  getUser(form:any){
    let role=form[2].value;
    let user:IUser={
      username:form[0].value,
      password:form[1].value,
    }
    this.userService.login(user);

    // sessionStorage.setItem("user",JSON.stringify(user));
    // location.reload();

  }

  hide():void{
    this.params.hidden=!this.params.hidden;
  }

  params:IModalParams={
    hidden: true,
    title: 'Log in',
    formParams: {
      inputs:[
        {
          name: "username",
          title: "Username",
          type: "text"
        },
        {
          name: "password",
          title: "Password",
          type: "password"
        }
      ]
    },
    footer: 'Log in'
  }

}
