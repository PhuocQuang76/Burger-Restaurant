import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/interfaces/Iuser';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user:IUser=JSON.parse(sessionStorage.getItem("user")||"{}");

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  checksession():void{
    this.userService.islogin();
  }

  isLogin():boolean{
    return this.user?this.user.user_id?true:false:false;
  }
  isCustomer():boolean{
    return this.isLogin()?this.user.roleid=="Customer"?true:false:false;
  }

}
