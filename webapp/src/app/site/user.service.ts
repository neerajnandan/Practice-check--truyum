import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, enableProdMode } from '@angular/core';
import { User } from './user';
import { Observable, Observer, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { delay } from 'q';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  

  userUrl:string = environment.userUrl;
  
  authUrl:string = environment.authUrl;





  
  userList: User[] = [
    { username:'admin', firstName: 'Neeraj', lastName: '(Admin)', password:'pwd', role: 'admin'},
    { username:'user', firstName: 'Neeraj', lastName: 'Nandan', password:'pwd', role: 'user'}
  ];

  constructor(private http: HttpClient) { }
  
  
  addUser(newUser:User):Observable<boolean>{
    // this.userList.push(newUser);
    return this.http.post<boolean>(this.userUrl,newUser);
  }

  userExists(username:string):boolean{
    return this.userList.some(user => user.username === username );
  }

  
  getUser(username:string){
    return this.userList.find(user => user.username === username );
  }

  isUserNameTaken(username:string){
   return of({ isLoginAvailable: !this.userList.some(user=> user.username == username) });
   
  }

  authenticate(username: string, password: string): Observable<any> {
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get<any>(this.authUrl,{headers});

      return null;
   
  }

}





