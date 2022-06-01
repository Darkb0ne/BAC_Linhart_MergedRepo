import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { IServerAttraction } from 'src/app/models/IServerAttraction.model';
import { IServerNews, IDictionary, IStatisticsServerNews } from 'src/app/models/IServerNews.model';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-statistics-news-alltime',
  templateUrl: './statistics-news-alltime.component.html',
  styleUrls: ['./statistics-news-alltime.component.scss']
})
export class StatisticsNewsAlltimeComponent implements OnInit {

  response!: IDictionary;
  result?: MatTableDataSource<IStatisticsServerNews>; 
  columnNames = [ 'title', 'viewCount'];

  constructor(private _apiService: ApiService) { }

  ngOnInit(): void {
    this._apiService.getNewsStatisticsAlltime$().subscribe(res => {

      const newsData = [];

      for (let newsTitle in res) {
        const viewC = res[newsTitle];
        const news: IStatisticsServerNews = {title: newsTitle, viewCount: viewC};
        newsData.push(news);
      }

      this.result = new MatTableDataSource<IStatisticsServerNews>(newsData);

      //console.log(this.statsAttractionAlltime);
      console.log(this.result);
    });

  }

}
