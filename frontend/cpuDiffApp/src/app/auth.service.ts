import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiServerUrl = environment.apiBaseUrl;
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();

  constructor(private http: HttpClient) { 
    const token = localStorage.getItem('cpudiff_jwt');
    if(token){
      this._isLoggedIn$.next(!!token);
    }
    else{
      this._isLoggedIn$.next(false);
    }
  }

  public login(dane: Object[]): Observable<Object[]> {
    return this.http.post<Object[]>(`${this.apiServerUrl}/auth/authenticate`, dane).pipe(
      tap(
        (response: any) =>{
          this._isLoggedIn$.next(true);
          localStorage.setItem('cpudiff_jwt', response["token"]);
        }
      )
    )
  }

  public register(dane: Object[]): Observable<Object[]> {
    return this.http.post<Object[]>(`${this.apiServerUrl}/auth/register`, dane)
  }

  public deleteAccount(): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/auth/deleteAccount`)
  }

}
