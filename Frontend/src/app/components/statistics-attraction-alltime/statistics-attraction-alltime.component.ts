import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IServerNews } from 'src/app/models/IServerNews.model';
import { News } from 'src/app/models/News.model';
import { ApiService } from 'src/app/services/api.service';
import { IDictionary } from 'src/app/models/IServerNews.model';
import { IServerAttraction } from 'src/app/models/IServerAttraction.model';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-statistics-attraction-alltime',
  templateUrl: './statistics-attraction-alltime.component.html',
  styleUrls: ['./statistics-attraction-alltime.component.scss']
})
export class StatisticsAttractionAlltimeComponent implements OnInit {

  response!: IDictionary;
  result?: MatTableDataSource<IServerAttraction>; 
  columnNames = [ 'attraction', 'viewCount'];

  constructor(private _apiService: ApiService) { }

  ngOnInit(): void {
    this._apiService.getAttractionStatisticsAlltime$().subscribe(res => {

      const attractions = [];

      for (let locationName in res) {
        const viewC = res[locationName];
        const attraction: IServerAttraction = {name: locationName, viewCount: viewC};
        attractions.push(attraction);
      }

      this.result = new MatTableDataSource<IServerAttraction>(attractions);

      //console.log(this.statsAttractionAlltime);
      console.log(this.result);
    });
  }
}
