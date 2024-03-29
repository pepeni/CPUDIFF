import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Article } from '../models/article';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.apiServerUrl}/allArticles`);
  }

  public getArticle(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.apiServerUrl}/article/${id}`);
  }

  public addArticle(article: Article): Observable<Article> {
    return this.http.post<Article>(`${this.apiServerUrl}/addArticle`, article);
  }

  public updateArticle(article: Article): Observable<Article> {
    return this.http.put<Article>(`${this.apiServerUrl}/updateArticle`, article);
  }

  public deleteArticle(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/deleteArticle/${id}`);
  }
}
