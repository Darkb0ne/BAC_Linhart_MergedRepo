import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/models/News.model';
import { catchError, map } from 'rxjs/operators';
import { ApiService } from 'src/app/services/api.service';
import { ActivatedRoute } from '@angular/router';
import { IServerAuthor } from 'src/app/models/IServerAuthor.model';
import { IServerNews } from 'src/app/models/IServerNews.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  data!: News[];

  author?: IServerAuthor;
  article?: IServerNews;

  result: any;

  constructor(private _apiService: ApiService, private _route: ActivatedRoute) { }

  ngOnInit(): void {
    this._apiService.getAllNews$().subscribe(res => {
      this.result = res.content.sort((a : any, b: any) => {
        return b.viewCount - a.viewCount;
      });

    })
  }
}
