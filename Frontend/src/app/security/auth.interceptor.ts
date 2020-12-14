import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {AuthService} from './auth.service';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler):Observable<HttpEvent<any>> {

    // console.log('Interceptor request: ', request);
    const currentUser = this.authService.currentUserValue;
    // console.log('Interceptor request - currentUser: ', currentUser);
    if(currentUser && currentUser.authdata) {
      request = request.clone({
        setHeaders: { 'authorization': 'Basic '+ currentUser.authdata
        }
      });
    }
    // console.log('Interceptor request with header: ', request);
    return next.handle(request);
  }
}
