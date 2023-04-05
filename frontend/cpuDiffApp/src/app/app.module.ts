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


const appRoute: Routes = [
  {path: '', component: MenuComponent},
  {path: 'Login', component: LoginComponent},
  {path: 'Register', component: RegisterComponent},
  {path: 'Menu', component: MenuComponent},
  {path: 'ArticleList', component: ArticleListComponent},
  {path: 'Article', component: ArticleComponent},
  {path: 'Processor', component: ProcessorComponent},
  {path: 'Comparison', component: ComparisonComponent}
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
    RouterModule.forRoot(appRoute)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
