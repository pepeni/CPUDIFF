import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(private authService: AuthService){}

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
