import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from "@angular/router";
import { HomeComponent } from "../components/unique-pages/home/home.component";
import { CartMainComponent } from '../components/unique-pages/cart/cart-main/cart-main.component';
import { ProductsComponent } from '../components/utils/customer/products-pages/products/products.component';
import { PurchasesComponent } from '../components/utils/customer/purchases-pages/purchases/purchases.component';
import { ViewProductComponent } from '../components/utils/customer/products-pages/view-product/view-product.component';
import { ProductComponent } from '../components/utils/customer/products-pages/product/product.component';

const appRoutes:Routes = [
  {path:'', redirectTo:'/home',pathMatch:'full'},
  {path:'home', component:HomeComponent},
  // {path:'login', component:HomeComponent},
  // {path:'register', component:HomeComponent},
  {path:'product',component:ProductComponent},
  {path:'products',component:ProductsComponent},
  {path:'purchases',component:PurchasesComponent},
  {path:'cart', component:CartMainComponent},
  {path: 'viewproduct', component: ViewProductComponent}


];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ViewProductComponent]
