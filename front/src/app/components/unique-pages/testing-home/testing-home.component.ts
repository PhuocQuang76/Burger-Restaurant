import { Component, OnInit } from '@angular/core';
import { IPurchase } from 'src/app/interfaces/Ipurchase';
import { IUser } from 'src/app/interfaces/Iuser';

@Component({
  selector: 'testing-home',
  templateUrl: './testing-home.component.html',
  styleUrls: ['./testing-home.component.css']
})
export class TestingHomeComponent implements OnInit {

  user:IUser=JSON.parse(sessionStorage.getItem("user")||"{}");

  constructor() { }

  ngOnInit() {
  }

  isLogin():boolean{
    return this.user?this.user.user_id?true:false:false;
  }
  isCustomer():boolean{
    return this.isLogin()?this.user.roleid=="Customer"?true:false:false;
  }

}
