import { Component, OnInit } from '@angular/core';
import { Article } from '../models/article';
import { ActivatedRoute } from '@angular/router';
import { ArticleService } from '../services/article.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit{
  public article: Article;

  constructor(
    private route: ActivatedRoute,
    private articleService: ArticleService
  ) {}

  ngOnInit(): void {
    this.getArticle();
  }

  public getArticle(): void {
    const articleId = this.route.snapshot.paramMap.get('id');
    const numId: number = Number(articleId);
    if (articleId == undefined) {
      return;
    }

    if (articleId) {
      this.articleService.getArticle(numId).subscribe(
        (response: Article) => {
          this.article = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  }

}
