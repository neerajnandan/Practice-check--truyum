import { Injectable, Output, EventEmitter } from '@angular/core';
import { FoodItem } from 'src/app/food/item-info/food-item';
import { Cart } from './cart';
import { UUID } from 'angular2-uuid';
import { FoodService } from 'src/app/food/food.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthService } from '../../site/auth.service';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';

@Injectable({
  providedIn: 'root'
})
export class CartService {


  @Output() cartUpdated = new EventEmitter();
  
  cartUrl:string = environment.cartUrl;
  foodItems:FoodItem[]; //temporary
  cart: Cart = {
    cartItems :null,
    total : 0
  };
  
  alreadyExists:boolean = false;
  foodItemAdded:boolean = false;

  IdOffoodItemtobeAdded =-1;
  foodItemtobeAdded:FoodItem =  {id:-1,title:null,price:null,active:null,dateOfLaunch:new Date('03/15/2017'),
                                  category:null,freeDelivery:true,imageUrl:null};
                                   constructor(private http:HttpClient,
              private foodService: FoodService,
              private authService: AuthService) {
   }

  
   getCart():Observable<Cart>{
     
    if(!this.authService.loggedInUser){
     return of (this.cart);
  } else {
     const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authService.userAuthenticated.accessToken });
     return this.http.get<Cart>(this.cartUrl+'/'+this.authService.userAuthenticated.username, {headers});
    }
   }

   //unused method
   calculateTotalPrice(): number {
      let total = 0 ;
      for (const cartItem of this.cart.cartItems) {
        total += cartItem.price;
          }
    return total;
   }
   
   addToCartRest(itemId:number,quantity:number):Observable<boolean>{
      this.IdOffoodItemtobeAdded =+ itemId;
      this.foodItemAdded = true;
          setTimeout(() => {
            this.foodItemAdded = false;
          }, 1000);
    const headers = new HttpHeaders({ Authorization: 'Bearer '+this.authService.userAuthenticated.accessToken});
    return this.http.post<boolean>(this.cartUrl+'/'+this.authService.userAuthenticated.username+'/'+itemId,"", {headers});
   }

  RemoveCartItem(cartItemId:string):Observable<boolean>{
    const headers = new HttpHeaders({ Authorization: 'Bearer '+this.authService.userAuthenticated.accessToken});
    return this.http.delete<boolean>(this.cartUrl+'/'+this.authService.userAuthenticated.username+'/'+cartItemId, {headers});

  }
  clearCart() {
    this.cart.cartItems = null;
    this.cart.total = 0;
  }
}
