import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { IServerAttraction } from 'src/app/models/IServerAttraction.model';
import { IDictionary, IServerNews, IStatisticsServerNews } from 'src/app/models/IServerNews.model';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-statistics-news-lastmonth',
  templateUrl: './statistics-news-lastmonth.component.html',
  styleUrls: ['./statistics-news-lastmonth.component.scss']
})
export class StatisticsNewsLastmonthComponent implements OnInit {

  response!: IDictionary;
  result?: MatTableDataSource<IStatisticsServerNews>; 
  columnNames = [ 'title', 'viewCount'];

  constructor(private _apiService: ApiService) { }

  ngOnInit(): void {
    this._apiService.getNewsStatisticsMonthly$().subscribe(res => {

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
