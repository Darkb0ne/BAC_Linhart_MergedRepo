import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorComponent } from './components/author/author.component';
import { CreateNewsComponent } from './components/create-news/create-news.component';
import { DetailNewsComponent } from './components/detail-news/detail-news.component';
import { HomeComponent } from './components/home/home.component';
import { StatisticsComponent } from './components/statistics/statistics.component';



const routes: Routes = [
  { path: 'author', component: AuthorComponent},
  { path: 'article', component: CreateNewsComponent},
  { path: 'home', component: HomeComponent},
  { path: 'statistics', component: StatisticsComponent},
  { path: 'news/:id', component: DetailNewsComponent, pathMatch: 'full'},
  { path: '**', redirectTo: 'author', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }