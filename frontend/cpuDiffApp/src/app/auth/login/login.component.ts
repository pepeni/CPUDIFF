import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(
    private authService: AuthService,
    private router: Router
    ){}


  public onUserLogin(loginForm: NgForm): void{
    this.authService.login(loginForm.value).subscribe(
      (response: Object) => {
        this.router.navigate(['/menu']);
  
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
