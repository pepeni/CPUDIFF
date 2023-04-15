import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Article } from './article';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.apiServerUrl}/allArticles`)
  }

  public getArticle(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.apiServerUrl}/article/${id}`)
  }

  public addArticle(article: Article): Observable<Article> {
    return this.http.post<Article>(`${this.apiServerUrl}/addArticle`, article)
  }
}
