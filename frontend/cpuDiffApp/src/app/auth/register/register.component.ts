import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
constructor(private authService: AuthService){}

  public onUserRegister(registerForm: NgForm): void{
    this.authService.register(registerForm.value).subscribe(
      (response: Object) => {},
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
