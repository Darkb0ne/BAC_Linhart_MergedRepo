import { Component, OnInit } from '@angular/core';
import { IServerNews } from 'src/app/models/IServerNews.model';
import { ApiService } from 'src/app/services/api.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { IServerAuthor } from 'src/app/models/IServerAuthor.model';

@Component({
  selector: 'app-detail-news',
  templateUrl: './detail-news.component.html',
  styleUrls: ['./detail-news.component.scss']
})
export class DetailNewsComponent implements OnInit {

  news$?: Observable<IServerNews>;
  authors$?: Observable<IServerAuthor[]>;

  constructor(private _apiService: ApiService, private _route: ActivatedRoute) {}

  ngOnInit(): void {

    const id_news = this._route.snapshot.paramMap.get('id');


    this.news$ = this._apiService.getNews$(id_news!);
    this.authors$ = this._apiService.getAuthorOfNews$(id_news!);
  }

}
