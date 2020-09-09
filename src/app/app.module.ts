import {
  HttpClientModule,
  HttpClient,
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HTTP_INTERCEPTORS
} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { FooterComponent } from './footer/footer.component';
import { PostComponent } from './post/post.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ReviewComponent } from './review/review.component';
import { AddCommentComponent } from './add-comment/add-comment.component';
import { ShowCommentComponent } from './show-comment/show-comment.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import {RestService} from './rest.service';
import {ErrorInterceptor} from './security/error.interceptor';
import {AuthInterceptor} from './security/auth.interceptor';
import { QuillModule} from 'ngx-quill';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminMessagesComponent } from './admin-dashboard/admin-messages/admin-messages.component';
import { AdminActivityComponent } from './admin-dashboard/admin-activity/admin-activity.component';
import { AdminUsersComponent } from './admin-dashboard/admin-users/admin-users.component';
import { AdminUsersEditComponent } from './admin-dashboard/admin-users-edit/admin-users-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    AboutComponent,
    ContactComponent,
    FooterComponent,
    PostComponent,
    NotFoundComponent,
    ReviewComponent,
    AddCommentComponent,
    ShowCommentComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    HomeComponent,
    AdminDashboardComponent,
    AdminMessagesComponent,
    AdminActivityComponent,
    AdminUsersComponent,
    AdminUsersEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    QuillModule.forRoot()
  ],
  providers: [RestService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
