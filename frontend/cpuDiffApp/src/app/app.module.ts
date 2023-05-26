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
  {path: '', component: LoginComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'menu', component: MenuComponent, canActivate: [AuthGuard]},
  {path: 'articleList', component: ArticleListComponent, canActivate: [AuthGuard]},
  {path: 'article', component: ArticleComponent, canActivate: [AuthGuard]},
  {path: 'processor', component: ProcessorComponent, canActivate: [AuthGuard]},
  {path: 'comparison', component: ComparisonComponent, canActivate: [AuthGuard]}
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
