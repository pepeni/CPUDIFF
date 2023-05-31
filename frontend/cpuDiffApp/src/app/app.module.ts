import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { MenuComponent } from './menu/menu.component';
import { ComparisonComponent } from './comparison/comparison.component';
import { ArticleComponent } from './article/article.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { ProcessorComponent } from './processor/processor.component';
import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JwtInterceptor } from './jwt.interceptor';
import { AuthGuard } from './auth.guard';


const appRoute: Routes = [
  {path: '', title: 'Login', component: LoginComponent, canActivate: [AuthGuard]},
  {path: 'login', title: 'Login', component: LoginComponent},
  {path: 'register', title: 'Register', component: RegisterComponent},
  {path: 'menu', title: 'Menu', component: MenuComponent, canActivate: [AuthGuard]},
  {path: 'articleList', title: 'Articles', component: ArticleListComponent, canActivate: [AuthGuard]},
  {path: 'articles/:id', title: 'Article', component: ArticleComponent, canActivate: [AuthGuard]},
  {path: 'processor', title: 'Processor', component: ProcessorComponent, canActivate: [AuthGuard]},
  {path: 'comparison', title: 'Compare', component: ComparisonComponent, canActivate: [AuthGuard]}
]

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    MenuComponent,
    ComparisonComponent,
    ArticleComponent,
    ArticleListComponent,
    ProcessorComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoute),
    HttpClientModule, FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }, 
    { provide: AuthGuard, useClass: AuthGuard }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
