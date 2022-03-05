import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/interfaces/Iuser';
import { IModalParams } from 'src/app/interfaces/modal/Imodal-params';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  setUser(form:any){
    let role=form[5].value;
    let user:IUser={
      username:form[0].value,
      password:form[1].value,
      fname:form[2].value,
      lname:form[3].value,
      email:form[4].value,
      roleid:role
    }
    // sessionStorage.setItem("user",JSON.stringify(user));
    // location.reload();

    if(role=='Seller'){
      this.userService.registerSeller(user);
    }else{
      this.userService.registerCustomer(user);
    }
  }

  hide():void{
    this.params.hidden=!this.params.hidden;
  }

  params:IModalParams={
    hidden: true,
    title: 'Register',
    formParams: {
      selects:[
        {
          name:"Role",
          title:"Role",
          id:"Roleid",
          options:[
            {value:"Customer",title:"Customer"},
            {value:"Seller",title:"Seller"}
          ]
        }
      ],
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
        },
        {
          name: "fname",
          title: "First Name",
          type: "text"
        },
        {
          name: "lname",
          title: "Last Name",
          type: "text"
        },
        {
          name: "email",
          title: "Email",
          type: "text"
        }
      ]
    },
    footer: 'Register'
  }

}
