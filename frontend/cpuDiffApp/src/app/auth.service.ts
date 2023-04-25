import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public login(dane: Object[]): Observable<Object[]> {
    return this.http.post<Object[]>(`${this.apiServerUrl}/login`, dane)
  }

  public register(dane: Object[]): Observable<Object[]> {
    return this.http.post<Object[]>(`${this.apiServerUrl}/register`, dane)
  }
}
