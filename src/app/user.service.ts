import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "./model/user";
import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";

@Injectable({ providedIn: 'root' })
export class UserService {

  endpoint = 'http://localhost:8080/api/';
  httpOptions={
    headers: new HttpHeaders({'content-type': 'application/json'})
  };

  constructor(private http: HttpClient) { }

  private extractData(res: Response){
    let body = res;
    return body || { };
  }

  getAllUsernames(): Observable<any>{
    return this.http.get(this.endpoint + 'users/usernames/all').pipe(
      map(this.extractData));
  }

  getAllUserEmails(): Observable<any>{
    return this.http.get(this.endpoint + 'users/useremails/all').pipe(
      map(this.extractData));
  }

  getUsers(): Observable<any>{
    return this.http.get(this.endpoint + 'users').pipe(
      map(this.extractData));
  }

  getUser(id:number): Observable<any> {
    return this.http.get<any>(this.endpoint + 'users/' + id).pipe(
      map(this.extractData));
  }

  addUser(user): Observable<any> {
    console.log('Add user method in UserService');
    console.log(user);
    return this.http.post<any>(this.endpoint + 'users/register', JSON.stringify(user), this.httpOptions).pipe(
      tap((user) => console.log(`added username=${user.username}`))
    );}

  deleteUser(id): Observable<any> {
    return this.http.delete<any>(this.endpoint + 'users/' + id).pipe(
      tap(_ => console.log(`deleted user id=${id}`))
    );
  }

  updateUser(user): Observable<any> {
    console.log(user);
    return this.http.put<any>(this.endpoint + 'users', JSON.stringify(user), this.httpOptions).pipe(
      tap((user) => console.log(`updated username=${user.username}`))
    );}

}
