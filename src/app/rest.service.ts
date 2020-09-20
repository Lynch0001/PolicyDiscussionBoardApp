import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {map, catchError, tap} from 'rxjs/operators';
import {AuthService} from './security/auth.service';
import {User} from './model/user';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  user:User;
  authenticated = false;
  endpoint = 'http://localhost:8080/api/';
  httpOptions={
    headers: new HttpHeaders({'content-type': 'application/json'})
  };

  constructor(private http : HttpClient ) { }

  private extractData(res: Response){
    let body = res;
    return body || { };
  }

  getDiscussions(): Observable<any>{
    return this.http.get(this.endpoint + 'discussions').pipe(
      map(this.extractData));
  }

  getAllTags(): Observable<any>{
    return this.http.get(this.endpoint + 'tags').pipe(
      map(this.extractData));
  }

  getAllComments(): Observable<any>{
    return this.http.get(this.endpoint + 'comments').pipe(
      map(this.extractData));
  }

  getDiscussionHeaders(): Observable<any>{
    return this.http.get(this.endpoint + 'discussion/headers').pipe(
      map(this.extractData));
  }

  getDiscussion(id:number): Observable<any> {
    return this.http.get<any>(this.endpoint + 'discussions/' + id).pipe(
      map(this.extractData));
  }

  getDiscussionsByContributor(contributorName:string): Observable<any> {
    let params = new HttpParams().append('contributorName', contributorName);
    return this.http.get<any>(this.endpoint + 'discussions/contributor',{params:params}).pipe(
      map(this.extractData));
  }

  getDiscussionsByTag(tag:string): Observable<any> {
    let params = new HttpParams().append('tag', tag);
    return this.http.get<any>(this.endpoint + 'discussions/tag',{params:params}).pipe(
      map(this.extractData));
  }

  addDiscussion(discussion): Observable<any> {
    console.log(discussion);
    return this.http.post<any>(this.endpoint + 'discussions', JSON.stringify(discussion), this.httpOptions).pipe(
      tap((discussion) => console.log(`updated discussion title=${discussion.discussTitle}`))
    );}

  updateDiscussion(discussion): Observable<any> {
    console.log(discussion);
    return this.http.put<any>(this.endpoint + 'discussions', JSON.stringify(discussion), this.httpOptions).pipe(
      tap((discussion) => console.log(`updated discussion title=${discussion.discussTitle}`))
    );}

  deleteDiscussion(id:number): Observable<any> {
    return this.http.delete<any>(this.endpoint + 'discussions/' + id).pipe(
      tap(_ => console.log(`deleted discussion id=${id}`))
    );
  }

  deleteComment(id:number): Observable<any> {
    return this.http.delete<any>(this.endpoint + 'comments/' + id).pipe(
      tap(_ => console.log(`deleted comment id=${id}`))
    );
  }

  getUser(credentials:any): Observable<any> {
    console.log('Rest Service received credentials: ', credentials);
    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});
    console.log('Rest Service header data: ', headers);
    let params = new HttpParams().append('username', credentials.username);
    console.log('Retrieving user information from server');
    return this.http.get<any>(this.endpoint + 'user', {headers: headers, params:params}).pipe(
      map(this.extractData));
  }

  getMessages(): Observable<any>{
    return this.http.get(this.endpoint + 'messages').pipe(
      map(this.extractData));
  }

  addMessage(message): Observable<any> {
    console.log('Sending message: ' , message);
    return this.http.post<any>(this.endpoint + 'messages/send', JSON.stringify(message), this.httpOptions).pipe(
      tap((message) => console.log(`added message from=${message.name}`))
    );}

  deleteMessage(id:number): Observable<any> {
    return this.http.delete<any>(this.endpoint + 'messages/' + id).pipe(
      tap(_ => console.log(`deleted message id=${id}`))
    );
  }

}
