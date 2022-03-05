import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IProduct } from '../../interfaces/Iproduct';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<IProduct[]>{
    let url  = `${environment.url.base}/product/`
    return this.http.get<IProduct[]>(url,environment.httpOptions);
  }

  activateProduct(prod: IProduct): void {
    let url = `${environment.url.base}/product/activate`;
    const body ={    
        product_id: prod.product_id

    };

    this.http.put<any>(url, body, environment.httpOptions).subscribe((data) => {});
  }

  deactivateProduct(prod: IProduct): void {
    let url = `${environment.url.base}/product/deactivate`;
    const body = {
      product_id: prod.product_id
    };

    this.http.put<any>(url, body, environment.httpOptions).subscribe((data) => {});
  }
  createProduct(product:IProduct):void{
    let url = `${environment.url.base}/product/create`;
    this.http.post<IProduct>(url,product,environment.httpOptions).subscribe((data)=>{
      
    });

  }
}
