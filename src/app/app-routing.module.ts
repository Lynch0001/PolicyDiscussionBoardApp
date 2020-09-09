import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from './main/main.component';
import {ContactComponent} from './contact/contact.component';
import {AboutComponent} from './about/about.component';
import {PostComponent} from './post/post.component';
import {ReviewComponent} from './review/review.component';
import {LoginComponent} from './login/login.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {HomeComponent} from './home/home.component';
import {AuthGuard} from './security/auth.guard';
import {LogoutComponent} from './logout/logout.component';
import {RegisterComponent} from './register/register.component';
import {AdminDashboardComponent} from './admin-dashboard/admin-dashboard.component';
import {AdminUsersEditComponent} from './admin-dashboard/admin-users-edit/admin-users-edit.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'home', component: HomeComponent},
  { path: 'main', component: MainComponent},
  { path: 'main/reload', component: MainComponent},
  { path: 'review/:id', component: ReviewComponent, canActivateChild:[AuthGuard]},
  { path: 'post', component: PostComponent, canActivate:[AuthGuard]},
  { path: 'admin-users-edit/:id', component: AdminUsersEditComponent},
  { path: 'about', component: AboutComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent},
  { path: 'admin-dashboard', component: AdminDashboardComponent},
  { path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
