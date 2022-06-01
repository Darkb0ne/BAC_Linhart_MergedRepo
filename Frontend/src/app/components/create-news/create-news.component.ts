import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IServerAuthor } from 'src/app/models/IServerAuthor.model';
import { ApiService } from 'src/app/services/api.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { IClientNews } from 'src/app/models/IClientNews.model';
import { IPostNews, IServerNews } from 'src/app/models/IServerNews.model';
import { News } from 'src/app/models/News.model';

@Component({
  selector: 'app-create-news',
  templateUrl: './create-news.component.html',
  styleUrls: ['./create-news.component.scss']
})
export class CreateNewsComponent implements OnInit {

  authors?: any[];
  news_data: IServerNews[] = [];

  array:any[]=[];
  newsTitle:string = "";
  newsText:string = "";
  attractionName:string = "";


  articleForm = new FormGroup({
    author: new FormControl(),
    title: new FormControl(''),
    text: new FormControl(''),
    attraction: new FormControl(''),
  });

  constructor(private _apiService: ApiService, private _router: Router, private _snackBar: MatSnackBar) { }

  submitArticle() {
    

    const value = this.articleForm.value;

    const news: IPostNews = {
      authorIds: value.author,
      attractionName: value.attraction,
      newsTitle: value.title,
      newsText: value.text,
    };

    console.log(value.author);

    this._apiService.setNews$(news).subscribe({
      next: (res) => {
        this._router.navigate(['/home']);
      },
      error: _ => {
        console.log(_)
      },
      complete: () => {
        this._snackBar.open('Succesfully created new Article', undefined, {
          duration: 2000,
          panelClass: ['green-snackbar']
         });
      }
    });
  }

  convertAuthorToAuthorId(authorArr1: IServerAuthor[], authorArr2: IPostNews) {

  }

  ngOnInit(): void {
   // this._apiService.getAllNews$().subscribe(news => {
    //  this.news_data = news;
   // })
    this._apiService.getAllAuthor$().subscribe(author => {
      this.authors = author;
    })
  }

  goToList() {
    this._router.navigate(['/home']);
  }

  addToArray(feature: any){
    this.array.push(feature);
  }

}
