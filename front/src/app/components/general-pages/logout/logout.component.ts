import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private userService:UserService,private router: Router) { }

  ngOnInit() {
  }
  logout():void{
    this.userService.logOut();
    sessionStorage.setItem("user","");
    this.router.navigate(['/home']);
  }

}
