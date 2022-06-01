import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatExpansionModule } from '@angular/material/expansion';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthorComponent } from './components/author/author.component';
import { CreateNewsComponent } from './components/create-news/create-news.component';
import { DetailNewsComponent } from './components/detail-news/detail-news.component';
import { HomeComponent } from './components/home/home.component';
import { SpinnerComponent } from './components/spinner/spinner.component';
import { ApiService } from './services/api.service';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatListModule } from '@angular/material/list';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { StatisticsAttractionAlltimeComponent } from './components/statistics-attraction-alltime/statistics-attraction-alltime.component';
import { StatisticsAttractionLastmonthComponent } from './components/statistics-attraction-lastmonth/statistics-attraction-lastmonth.component';
import { StatisticsNewsLastmonthComponent } from './components/statistics-news-lastmonth/statistics-news-lastmonth.component';
import { StatisticsNewsAlltimeComponent } from './components/statistics-news-alltime/statistics-news-alltime.component';
import { StatisticsComponent } from './components/statistics/statistics.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthorComponent,
    DetailNewsComponent,
    CreateNewsComponent,
    HomeComponent,
    SpinnerComponent,
    StatisticsAttractionAlltimeComponent,
    StatisticsAttractionLastmonthComponent,
    StatisticsNewsLastmonthComponent,
    StatisticsNewsAlltimeComponent,
    StatisticsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatTableModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatExpansionModule,
    MatToolbarModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatSortModule,
    MatListModule,
    MatSnackBarModule,
    MatCardModule
  ],
  providers: [
    ApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
