//system library
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

//main library
import { AppComponent } from './app.component';


//unique library
import { HomeComponent } from './components/unique-pages/home/home.component';
import { CartMainComponent } from './components/unique-pages/cart/cart-main/cart-main.component';
import { CartDetailComponent } from './components/unique-pages/cart/cart-detail/cart-detail.component';
import { FoodMenuComponent } from './components/unique-pages/food-menu/menu.component';

//general library
import { NavbarComponent } from './components/general-pages/navbar/navbar.component';
import { FooterComponent } from './components/general-pages/footer/footer.component';
import { MyProfileComponent } from './components/general-pages/my-profile/my-profile.component';
import { LoginComponent } from './components/general-pages/login/login.component';
import { RegisterComponent } from './components/general-pages/register/register.component';
import { LogoutComponent } from './components/general-pages/logout/logout.component';

//utils modal
import { ModalComponent } from './components/utils/general/modal/modal/modal.component';
import { LabelSelectComponent } from './components/utils/general/modal/label-select/label-select.component';
import { LabelInputComponent } from './components/utils/general/modal/label-input/label-input.component';
import { LabelHiddenInputComponent } from './components/utils/general/modal/label-hidden-input/label-hidden-input.component';

//utils products
import { ProductComponent } from './components/utils/customer/products-pages/product/product.component';
import { ProductsComponent } from './components/utils/customer/products-pages/products/products.component';
import { NewProductComponent } from './components/utils/customer/products-pages/new-product/new-product.component';
import { ViewProductComponent } from './components/utils/customer/products-pages/view-product/view-product.component';

// //utils purchases
import { PurchaseComponent } from './components/utils/customer/purchases-pages/purchase/purchase.component';
import { PurchasesComponent } from './components/utils/customer/purchases-pages/purchases/purchases.component';
import { NewPurchaseComponent } from './components/utils/customer/purchases-pages/new-purchase/new-purchase.component';
import { ViewPurchaseComponent } from './components/utils/customer/purchases-pages/view-purchase/view-purchase.component';

//pipes
import { IUserInputPipe } from './pipes/IUser-input/IUser-Input.pipe';

//routing
import { AppRoutingModule, routingComponents } from './routes/app.routing';

//others


//testing this component is going to be removed before the presentation do not add anything important
import { TestingHomeComponent } from './components/unique-pages/testing-home/testing-home.component';
import { TempProductComponent } from './components/utils/customer/products-pages/temp-product/temp-product.component';
import { GetImgPipe } from './pipes/get-img/get-img.pipe';


@NgModule({
  declarations: [
    //main
    AppComponent,
    
    //router
    routingComponents,

    //general
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,

    //unique
    HomeComponent,
    CartMainComponent,
    CartDetailComponent,
    FoodMenuComponent,

    //products
    ProductComponent,
    ProductsComponent,
    NewProductComponent,
    ViewProductComponent,

    //purchases
    PurchaseComponent,
    PurchasesComponent,
    NewPurchaseComponent,
    ViewPurchaseComponent,

    //modal
    ModalComponent,
    LabelSelectComponent,
    LabelInputComponent,
    LabelHiddenInputComponent,

    //my-profile
    MyProfileComponent,

    //pipe
    IUserInputPipe,

    //testing will be deleted later
    TestingHomeComponent,
      TempProductComponent,
      GetImgPipe

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
