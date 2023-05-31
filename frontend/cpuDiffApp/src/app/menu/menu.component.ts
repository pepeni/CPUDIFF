import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{

  userInfo: any;
  nick: string;
  role: string;
  constructor(private authService: AuthService){}

  ngOnInit(): void {
    this.getUserInfo();
  }

  getUserInfo(): void {
    this.authService.getUserInfo().subscribe(
      (response) => {
        this.userInfo = response;
        console.log(this.userInfo);
      },
      (error) => {
        console.error(error);
      }
    );
  }

  handleClickLogOut(): void {
    localStorage.clear();
  }

  handleClickDeleteAccount(): void {
    const confirmation = window.confirm("Czy na pewno chcesz usunąć konto?");
    if (confirmation) {
      this.authService.deleteAccount().subscribe(() => {localStorage.clear();}, (error) => {console.error(error)});
      localStorage.clear();
    }
  }

}
