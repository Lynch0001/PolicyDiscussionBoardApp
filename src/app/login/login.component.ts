import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import {AuthService} from "../security/auth.service";


@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit{

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute,
                      private router: Router, private authService: AuthService) {
    // redirect to main if already logged in
    console.log("Login Constructor - currentUserValue: ", this.authService.currentUserValue);
    if (this.authService.currentUserValue) {
      this.router.navigate(['/main']);
    }
  }

ngOnInit() {
  this.loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    console.log("Login - init - returnUrl: ", this.returnUrl);
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    this.loading = true;
    console.log("Login Component calling AuthService with credentials");
    this.authService.login(this.f.username.value, this.f.password.value)
      .pipe(first())
      .subscribe(
        (data:{}) => {
          console.log("Login response - data", data);
          console.log("Login response - returnURL", this.returnUrl);
          this.router.navigate([this.returnUrl]);
        },
        error => {
          this.error = error;
          this.loading = false;
        });
  }
}
