import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Subject, throwError } from 'rxjs';
import { IUser } from '../../interfaces/Iuser';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

constructor(private http:HttpClient) {
 }

httpOptions = {
  withCredentials: true
 };


  islogin():void{
    let url:string=`${environment.url.base}/user/islogin`;
    this.http.get<IUser>(url,environment.httpOptions)
      .pipe(
        catchError((e) => {
          console.log(e);
          return throwError(e);
        })
      ).subscribe((data) => {
        
      });
  }

  login(user:IUser): void{
    let url:string=`${environment.url.base}/user/login`;
    this.http.post<IUser>(url,user,environment.httpOptions)
      .pipe(
        catchError((e) => {
          console.log(e);
          return throwError(e);
        })
      ).subscribe((data) => {
        
        sessionStorage.setItem("user",JSON.stringify(data));
        if(data)location.reload();
      });
  }
  
  registerCustomer(user:IUser): void{
    let url:string=`${environment.url.base}/user/register/customer`;
    this.http.post<IUser>(url,user,environment.httpOptions)
      .pipe(
        catchError((e) => {
          console.log(e);
          return throwError(e);
        })
      ).subscribe((data) => {
        
        sessionStorage.setItem("user",JSON.stringify(data));
        if(data)location.reload();


      });
  }

  registerSeller(user:IUser): void{
    let url:string=`${environment.url.base}/user/register/seller`;
    this.http.post<IUser>(url,user,environment.httpOptions)
      .pipe(
        catchError((e) => {
          console.log(e);
          return throwError(e);
        })
      ).subscribe((data) => {
        
        sessionStorage.setItem("user",JSON.stringify(data));
                if(data)location.reload();


      });
  }
  logOut():void{
    let url:string=`${environment.url.base}/user/logout`;
    this.http.post<void>(url,null,environment.httpOptions)
      .pipe(
        catchError((e) => {
          console.log(e);
          return throwError(e);
        })
      ).subscribe((data) => {
        
        sessionStorage.setItem("user","");
        location.reload();
      });
  }
  update(user:IUser):void{
    let url:string=`${environment.url.base}/user/update`;
    this.http.put<IUser>(url,user,environment.httpOptions)
      .pipe(
        catchError((e) => {
          console.log(e);
          return throwError(e);
        })
      ).subscribe((data) => {
        
        sessionStorage.setItem("user",JSON.stringify(data));
        if(data)location.reload();

      });
  }
}
